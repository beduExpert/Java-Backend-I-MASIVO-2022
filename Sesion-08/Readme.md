## Sesión 8: Conexión a base de datos con Spring Data

<img src=".github/assets/img/index.jpg" align="right" height="120" hspace="10">
<div style="text-align: justify;">

### 1. Objetivos :dart:

- Identificar qué es una entidad, cómo se usa en una aplicación y cómo declararla.
- Reconocer qué es un repositorio de Spring Data y la forma de declararlos.
- Hacer uso de una consola embebida en la aplicación para realizar consultas.


### 2. Contenido :blue_book:

Cuando trabajamos para conectar nuestra aplicación a una base de datos y realizar operaciones sobre estas, puede que el código sea un tanto repetitivo afectando la calidad de nuestro trabajo haciéndolo difícil de leer. Java también tiene una solución para este problema: la Java Persistence API (JPA). Una API para simplificar el trabajo con las bases de datos.

Spring también proporciona un contenedor para trabajar con JPA, estamos hablando del Spring Data JPA container. Para comprender JPA y Spring Data JPA debemos hablar sobre entidades y repositorios, dos elementos fundamentales en el tema. Más adelante hablaremos sobre estos así como el funcionamiento de Spring Data JPA.

En este módulo aprenderemos:

- La forma correcta de declarar entidades y almacenarlas en una base de datos relacional.
- Crear un repositorio de Spring Data para guardar y recuperar entidades.
- Integrar la consola de H2 para visualizar la información de la base de datos-

---

<img src=".github/assets/img/entities.png" align="right" height="90" hspace="10">

#### <ins>Tema 1: Introducción a Spring Data JPA</ins>

Spring Data JPA es el módulo de Spring que permite trabajar con JPA en nuestras aplicaciones, encapsulando toda la complejidad del acceso a datos : nos ahorra escribir código repetitivo para ejecutar consultas simples o para realizar la paginación y auditoría. El objetivo de Spring Data JPA es mejorar significativamente la implementación de la capa de acceso de datos y reducir el esfuerzo a lo realmente necesario.

En el [primer ejemplo](./Ejemplo-01) aprenderemos a usar la anotaciones básicas de Spring Data JPA para indicar los objetos de una clase deben ser tratados como entidades de la base de datos. Además crearemos nuestro primer repositorio. En el [primer reto](./Reto-01) deberás hacer uso de este módulo de Spring para crear y recuperar una lista de productos almacenados en una base de datos MySQL a través de un API REST.

- [**`EJEMPLO 1`**](./Ejemplo-01)
- [**`Reto 1`**](./Reto-01)

---

<img src=".github/assets/img/intialization.png" align="right" height="90" hspace="10">

#### <ins>Tema 2: Inicialización de datos</ins>

En algunas ocasiones necesitamos que cierta información exista en la base de datos para que nuestra aplicación funcione de forma correcta. Algunos catálogos o datos de configuración que la misma usará. En el [segundo ejemplo](./Ejemplo-02) veremos una forma de hacer esta inicialización implementando la interface `CommandLineRunner` de Spring Boot y en el [segundo reto](./Reto-2) deberás lograr esto mismo pero ejecutando un script `SQL`

- [**`EJEMPLO 2`**](./Ejemplo-02)
- [**`Reto 2`**](./Reto-02)

---

<img src=".github/assets/img/h2.png" align="right" height="90" hspace="10">

#### <ins>Tema 3:Uso de la consola embebdida H2 para manejar la base de datos</ins>

No siempre tendremos la opción de conectarnos a la base de datos de nuestra aplicación desde una herramienta externa, es por eso que H2 proporciona una consola de SQL que puede incrustarse en nuestras aplicaciones y permite conectarse a diferentes gestores de bases de datos. En el [tercer ejemplo](./Ejemplo-03) veremos cómo hacer esto para poder realizar consultas directamente a nuestra aplicación.

- [**`EJEMPLO 3`**](./Ejemplo-03)

---

### 3. Postwork :memo:

Encuentra las indicaciones y consejos para reflejar los avances de tu proyecto de este módulo.

- [**`POSTWORK SESIÓN 8 `**](./Postwork/)

<br/>

</div>
