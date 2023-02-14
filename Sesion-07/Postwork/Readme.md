## Postwork Sesión 7: Integración de Thymeleaf y Spring Boot

### OBJETIVO

- Colocar un formulario que permita crear nuevas entradas en la agenda de nuestro proyecto.
- Almacenar la información en la memoria de la aplicación.
- Mostrar en la pantalla la lista de personas registradas en la agenda (puede ser en la parte inferior de la pantalla del formulario).
- Validar que todos los datos obligatorios se hayan introducido.
- Mostrar un mensaje de error en caso de que algún dato introducido tenga un formato incorrecto.


### DESARROLLO

En esta sesión aprendimos a usar Thymeleaf como un motor de plantillas que nos permite generar páginas HTML del lado del servidor, para mostrar al cliente una vista dinámica con información generada en el servidor.

Además aprendimos la forma de validar y recibir la información proporcionada por el usuario a través de un formulario, y la forma de mostrar esta información en la página.

El postwork se realizará en equipo, los cuales serán formados previamente a la sesión uno.

**Asegúrate de comprender:**

1. Cómo integrar Thymeleaf en un proyecto Spring Boot.
2. Realizar validaciones de los datos de entrada.
3. Mostrar mensajes de error.


**Indicaciones generales**

En el Postwork de la sesión anterior continuamos con la implementación de nuestra agenda, recibiendo los datos a través de un API REST.

En ésta ocasión reemplazamos el API con una página web que contenga las siguientes funcionalidades.

En el Postwork de la sesión anterior continuamos con la implementación de nuestra agenda, recibiendo los datos a través de un API REST. En ésta ocasión reemplazamos el API con una página web que contenga las siguientes funcionalidades.

1. Muestre la lista de personas registradas en la agenda, ordenadas de forma alfabética.
1. Muestre los teléfonos usando un formato de ##-####-####.
1. Contenga un formulario con validaciones y que permita agregar nuevos registros a la agenda.

Los distintos elementos de la aplicación se conectarán a través de clases “servicio” y controladores de Spring MVC.

</br>

<details>
  <summary>Solución</summary>

Agrega las dependencias:

```groovy
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
implementation 'org.springframework.boot:spring-boot-starter-validation'
```

Genera el template para el formulario *src/main/resources/templates/index.html* :

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" lang="es">
<head>
    <title>Registro</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2>Introduce un nuevo registro</h2>
<form th:action="@{/registro}" th:object="${persona}" method="post">
    <div>
        <label for="nombre">Nombre: </label>
        <input id="nombre" type="text" th:field="*{nombre}">
        <div th:if="${#fields.hasErrors('nombre')}" th:errorclass="error" th:errors="*{nombre}"></div>
    </div>
    <div>
        <label for="telefono">Telefono: </label>
        <input id="telefono" type="text" th:field="*{telefono}">
        <div th:if="${#fields.hasErrors('telefono')}" th:errorclass="error" th:errors="*{telefono}"></div>
    </div>
    <input type="submit" th:value="Guardar"/>
</form>

<h3>Agenda: </h3>

<ul>
    <li th:each="registro : ${listaPersonas}" th:text="${ registro.getNombre() + ' ' + registro.getTelefono()}"  ></li>
</ul>
</body>
</html>
```

Modifica *AgendaController*

```java
@Controller
public class AgendaController {

    private final AgendaService agendaService;


    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping({"/", "/index"})
    public String formularioRegistro(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("listaPersonas", agendaService.getPersonas());

        return "index";
    }

    @PostMapping("/registro")
    public ModelAndView registra(@Valid Persona persona) {

        agendaService.guardaPersona(persona);

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listaPersonas", agendaService.getPersonas());
        return mav;
    }

}
```

Luego modifica el model *Persona*, agregando las restricciones:

```java
public class Persona implements Comparable<Persona> {

    @NotBlank(message = "El nombre de la persona es un campo obligatorio.")
    private String nombre;

    @Pattern(regexp = "^(\\d{2,4}[- .]?){2}\\d{4}$", message = "El teléfono debe tener un formato de ##-####-####")
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return nombre.equals(persona.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Persona o) {
        return this.nombre.compareTo(o.nombre);
    }
}
```

Después modifica *AgendaMemoryDao* para agregar la validación de télefono

```java
@Repository
public class AgendaMemoryDao {

    private static final SortedSet<Persona> personas = new TreeSet<>();
    private final FormateadorTelefono formateadorTelefono;

    public AgendaMemoryDao(FormateadorTelefono formateadorTelefono) {
        this.formateadorTelefono = formateadorTelefono;
    }

    public Persona guardaPersona(Persona persona) {
        persona.setTelefono(formateadorTelefono.formatea(persona.getTelefono()));
        personas.add(persona);
        return persona;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }
}
```

Edita *AgendaService* para implementar lo modificado en *AgendaMemoryDao*

```java
@Service
public class AgendaService {

    private final ValidadorTelefono validadorTelefono;
    private final AgendaMemoryDao agendaDao;

    @Autowired
    public AgendaService(ValidadorTelefono validadorTelefono, AgendaMemoryDao agendaDao) {
        this.validadorTelefono = validadorTelefono;
        this.agendaDao = agendaDao;
    }

    public Persona guardaPersona(Persona persona) {
        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());

        persona.setTelefono(telefono);

        return agendaDao.guardaPersona(persona);
    }

    public Set<Persona> getPersonas() {
        return agendaDao.getPersonas();
    }
}
```

Ya para terminar, elimina el método *isValido*, ya qué no lo vamos a utilizar.

```java
@Service
public class ValidadorTelefono {
    public String limpiaNumero(String telefono) {
        return telefono.replaceAll("[^0-9]", "");
    }
}
```

Ahora ejecuta la aplicación y desde postman envía peticiónes la URL base es: [http://localhost:8080/api/v1](http://localhost:8080/api/v1):

</details>


<br>

[**`Siguiente`** -> sesión 08](../../Sesion-08/)

[**`Regresar`**](../)