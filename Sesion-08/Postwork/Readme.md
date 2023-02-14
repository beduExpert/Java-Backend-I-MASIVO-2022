## Postwork Sesión 8: Conexión a base de datos con Spring Data

### OBJETIVO

- Almacenar la información de la agenda en una base de datos relacional MySQL.
- Recuperar las personas contenidas en la agenda desde la base de datos para mostrarlas en pantalla.
- Que la información ingresada no desaparezca al momento de reiniciar la aplicación.


### DESARROLLO

En esta sesión aprendimos a usar Spring Data JPA como mecanismo para realizar el trabajo en una base de datos relacional. Spring Data JPA hace uso de Hibernate como motor de persistencia y este realiza las conversiones entre objetos Java a tablas de la base de datos para que no tengamos que preocuparnos por escribir ni una sola línea de SQL.

Además aprendimos dos diferentes formas de inicializar la información en la base de datos, la primera usando la interface CommandLineRunner y la segunda usando archivos SQL.

El postwork se realizará en equipo, los cuales serán formados previamente a la sesión uno.

**Asegúrate de comprender:**

1. Cómo integrar Spring Data JPA en un proyecto Spring Boot.
2. La forma de configurar la conexión a la base de datos.
3. Qué es una entidad, un repositorio, y cómo integrarlos en la aplicación.

**Indicaciones generales**

En el Postwork de la sesión anterior le dimos a nuestra agenda una interfaz de usuario muy sencilla. Con ella ya podemos ingresar en un formulario la información de las personas, y recuperar la misma para mostrarla en una lista. Sin embargo, debido a que estamos usando un almacén en memoria, cada vez que reiniciamos la aplicación perdemos la información que ya habíamos guardado.


En esta ocasión tu misión será extender este programa eliminando el `Set` en donde almacenamos la información de la agenda, y reemplzándolo por una base de datos relacional en MySQL. De esta forma, aunque reiniciemos la aplicación la información seguirá estando disponible.

1. Deberás integrar las depencias de Spring data JPA y el driver de MySQL en el archivo `build.gradle`.
1. Reemplaza la clase `AgendaMemoryDao` por un repositorio de Spring Data.
1. Convierte la clase `Persona` en una entidad de JPA.
1. Los distintos elementos de la aplicación se conectarán a través de clases “servicio” y controladores de Spring MVC.


</br>

<details>
  <summary>Solución</summary>

Agrega las dependencias:

```groovy
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
runtimeOnly 'mysql:mysql-connector-java'
```

Inserta la siguiente información al *application.properties* (Modificando los datos de tu conecxión)

```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.generate_statistics=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/bedu?serverTimezone=UTC
spring.datasource.username=<usuario>
spring.datasource.password=<password>
```

Agrega los tags al modelo *Persona*

```java
@Entity
@Table(name = "PERSONAS")
public class Persona implements Comparable<Persona> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la persona es un campo obligatorio.")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Pattern(regexp = "^(\\d{2,4}[- .]?){2}\\d{4}$", message = "El teléfono debe tener un formato de ##-####-####")
    @Column(nullable = false, length = 20)
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

Elimina *AgendaMemoryDao*, en el mismo package genera *PersonaRepository* y agrega el siguiente código:

```java
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
```

Modifica el *AgendaService*, ahora debe utilizar *PersonaRepository* en vez de *AgendaMemoryDao*:

```java
@Service
public class AgendaService {

    private final ValidadorTelefono validadorTelefono;
    private final PersonaRepository personaRepository;

    @Autowired
    public AgendaService(ValidadorTelefono validadorTelefono, PersonaRepository personaRepository) {
        this.validadorTelefono = validadorTelefono;
        this.personaRepository = personaRepository;
    }

    public Persona guardaPersona(Persona persona) {
        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());

        persona.setTelefono(telefono);

        return personaRepository.save(persona);
    }

    public List<Persona> getPersonas() {
        return personaRepository.findAll(Sort.by("nombre"));
    }
}
```

Ahora ejecuta la aplicación y desde postman envía peticiónes la URL base es: [http://localhost:8080/api/v1](http://localhost:8080/api/v1):

Luego conectate a la base de datos y verifica si la información enviada en las peticiones se encuentra almacenada.

</details>

<br>

[**`Regresar`**](../)