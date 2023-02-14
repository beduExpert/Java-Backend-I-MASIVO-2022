## Postwork Sesión 6: Introducción a Spring MVC

### OBJETIVO

- Reemplazar la aplicación de línea de comandos por un API Rest que reciba la información de nombre y teléfono.
- Tener un almacenamiento temporal de la información en la memoria.
- Desarrollar un Endpoint que regrese la información almacenada en la agenda.


### DESARROLLO

En esta sesión aprendimos MVC como estilo arquitectónico para nuestras aplicaciones. Ahora lo usaremos para dejar atrás la línea de comandos y realizar el desarrollo de un API Rest que nos ayude con el manejo de nuestra agenda telefónica.

El postwork se realizará en equipo, los cuales serán formados previamente a la sesión uno.

**Asegúrate de comprender:**

1. Cómo utilizar el Spring Initializr para crear un proyecto
2. Cómo configurar un proyecto de Gradle
3. Cómo crear un controlador REST en Spring MVC.
4. Cómo utilizar la Inyección de Dependencias en Spring Boot

**Indicaciones generales**

En el Postwork de la sesión anterior continuamos con la implementación de nuestra agenda, recibiendo y formateando el nombre y número de teléfono de una persona.

En ésta ocasión tu misión será eliminar el uso de la línea de comandos y reemplazarlo por un API Rest que contenga las siguientes funcionalidades.

1. Reciba la información del nombre y número de teléfono y aplique el mismo proceso de validación y limpieza del teléfono que desarrollamos en el módulo anterior.
1. Almacene la información en memoria usando un `Set` de Java que ordene las entradas de forma alfabética por el nombre de la persona. Para lograr esto `Persona` deberá implementar la interface `java.lang.Comparable`
1. Un servicio REST que al hacer una petición **GET** regrese la información de la agenda en formato JSON.
1. La aplicación debe implementar el patrón MVC. Esto quiere decir que el modelo se encontrará en una capa, el acceso a datos en otra capa y la vista (los servicios Rest) en otra capa. Es posible que para esto debas crear más de un nuevo paquete en la aplicación. 


La lógica de la aplicación debe estar contenida en una clase “servicio” que deberá recibir todas sus dependencias a través de inyección por constructor.

<details>
  <summary>Solución</summary>

Crea cuatro nuevos paquetes dentro de la aplicación: `model` que contendrá el modelo de datos de la aplicación; `controller` que tendrá el controlador principal de la aplicación; `persistence` que contendrá las clases de acceso a datos; y `service` que tendrá los servicios con la lógica de la aplicación.

![imagen](img/img_03.png)

Dentro del paquete `model` replica la clase `Persona` del postwork de la sesión anterior. Sobreescribe dos nuevos métodos: `equals` y `hashCode` usando el nombre de la persona. Esto nos ayudará a que el `Set` en el que almacenaremos la información de la agenda no tenga personas repetidas:

```java
public class Persona {
    private String nombre;
    private String telefono;

    public Persona() {
    }

    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

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
}
```

`Persona` debe implementar también la interface `java.lang.Comparable` usando el `nombre` de la persona. Esto permitirá que la lista de personas en la agenda se ordene de forma automática usando este atributo:

```java
public class Persona implements Comparable<Persona> {
    private String nombre;
    private String telefono;

    public Persona() {
    }

    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

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

En el paquete `persistence` crea una nueva clase llamada `AgendaMemoryDao`, esta representará la clase de acceso a datos. En esta sesión la información se almacenará en un `SortedSet` el cual se destruirá al detener la aplicación.

```java
public class AgendaMemoryDao {

    private static final SortedSet<Persona> personas = new TreeSet<>();
}
```

Agrega dos métodos a esta clase, uno que reciba un objeto de tipo `Persona` y lo agregue al `SortedSet` y otro que regrese este `SortedSet`:

```java
public class AgendaMemoryDao {

    private static final SortedSet<Persona> personas = new TreeSet<>();

    public Persona guardaPersona(Persona persona) {
        personas.add(persona);
        return persona;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }
}
```

Para terminar, decora la clase `AgendaMemoryDao` con la anotación `@Repository`, con esto le indicamos a Spring que esta clase debe ser tratada como un **Bean** y su propósito es el acceso a datos.

```java
@Repository
public class AgendaMemoryDao {

    private static final SortedSet<Persona> personas = new TreeSet<>();

    public Persona guardaPersona(Persona persona) {
        personas.add(persona);
        return persona;
    }

    public Set<Persona> getPersonas() {
        return personas;
    }
}
```

Dentro del paquete `service` replica la clase `ValidadorTelefono` de la sesión anterior:

```java
@Service
public class ValidadorTelefono {

    private static final Pattern PATTERN_TELEFONO = Pattern.compile("^(\\d{2,4}[- .]?){2}\\d{4}$");

    public boolean isValido(String telefono) {
        return PATTERN_TELEFONO.matcher(telefono).matches();
    }

    public String limpiaNumero(String telefono){
        return telefono.replaceAll("[^0-9]", "");
    }
}
```

Y dentro de este mismo paquete agrega una nueva clase `AgendaService` la cual reciba una instancia de `ValidadorTelefono` y `AgendaMemoryDao` por medio de inyección de constructor:

```java
public class AgendaService {

    private final ValidadorTelefono validadorTelefono;
    private final AgendaMemoryDao agendaDao;

    @Autowired
    public AgendaService(ValidadorTelefono validadorTelefono, AgendaMemoryDao agendaDao) {
        this.validadorTelefono = validadorTelefono;
        this.agendaDao = agendaDao;
    }
}
```

Agrega un primer método a esta clase que se encargará de recibir como parámetro una persona, validar si el número de teléfono es válido, en cuyo caso eliminará cualquier caracter no numérico y lo guardará en la agenda. Si el teléfono no es válido entonces deberá regresar `null` como valor; de esta forma sabremos que el teléfono no es válido. En módulos posteriores aprenderás una forma mejor de manejar estas validaciones.

```java
    public Persona guardaPersona(Persona persona) {

        if (!validadorTelefono.isValido(persona.getTelefono())) {
            return null;
        }
        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());

        persona.setTelefono(telefono);

        return agendaDao.guardaPersona(persona);
    }
```

El segundo método será más sencillo, simplemente usará la instancia de `AgendaMemoryDao` para regresar la lista de todas las personas contenidas en la agenda.

```java
    public Set<Persona> getPersonas() {
        return agendaDao.getPersonas();
    }
```

No olvides decorar esta clase con la anotación `@Service`

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

        if (!validadorTelefono.isValido(persona.getTelefono())) {
            return null;
        }
        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());

        persona.setTelefono(telefono);

        return agendaDao.guardaPersona(persona);
    }

    public Set<Persona> getPersonas() {
        return agendaDao.getPersonas();
    }
}
```

Para terminar, debemos crear una nueva clase en el paquete `controller` la cual recibirá las peticiones de nuestros clientes. Esta clase debe estar decorada con las anotaciones `@RestController` y `@RequestMapping`:

@RestController
@RequestMapping("/api/v1/agenda")
public class AgendaController {

}

Además, debe tener una instancia de `AgendaService` que reciba por medio de la inyección de constructor:

```java

private final AgendaService agendaService;

@Autowired
public AgendaController(AgendaService agendaService) {
    this.agendaService = agendaService;
}
```

El primer método que implementaremos regresará la lista completa de `Persona`s que estén registradas en la agenda. Esta corresponderá a un método HTTP **GET**:

```java
@GetMapping
public ResponseEntity<Set<Persona>> getPersonas(){
  return ResponseEntity.ok(agendaService.getPersonas());
}
```

El segundo método de esta clase recibirá un objeto de tipo `Persona`, en el cuerpo de una petición HTTP **POST**, el cual guardará. Si obtiene un valor nulo quiere decir que algo no fue correcto al momento de almacenar la información y regresará un error. Si obtiene un nuevo objeto `Persona` lo regresará en la respuesta. En módulos posteriores aprenderás una mejor forma de manejar estos errores.

```java
    @PostMapping
    public ResponseEntity<Persona> guardaPersona(@RequestBody Persona persona) {
        Persona resultado = agendaService.guardaPersona(persona);

        if (resultado == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(resultado);
    }
```

La clase completa queda de la siguiente forma:
```java
@RestController
@RequestMapping("/api/v1/agenda")
public class AgendaController {

    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping
    public ResponseEntity<Persona> guardaPersona(@RequestBody Persona persona) {
        Persona resultado = agendaService.guardaPersona(persona);

        if (resultado == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public ResponseEntity<Set<Persona>> getPersonas(){
        return ResponseEntity.ok(agendaService.getPersonas());
    }
}
```
Ahora ejecuta la aplicación y desde postman envía una petición **POST** a esta URL: [http://localhost:8080/api/v1/agenda](http://localhost:8080/api/v1/agenda):

```json
{
    "nombre": "Beto",
    "telefono": "5512345678"
}
```

Debes obtener la siguiente salida en Postman:

![imagen](img/img_04.png)


Si ahora consultas la lista de personas registradas debes obtener la siguiente salida [http://localhost:8080/api/v1/agenda](http://localhost:8080/api/v1/agenda):

![imagen](img/img_05.png)

Continúa agregando más registros para que veas como poco a poco se va llenando la agenda con la información proporcionada.

![imagen](img/img_06.png)


</details>

<br>

[**`Siguiente`** -> sesión 07](../../Sesion-07/)

[**`Regresar`**](../)