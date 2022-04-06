## Sesión 6: Patrón MVC con Spring Boot

<img src=".github/assets/img/SpringMVC.png" align="right" height="120" hspace="10">
<div style="text-align: justify;">

### 1. Objetivos :dart:

- Recibir y procesar parámetros de peticiones.
- Regresar objetos como respuesta.
- Cargar y descargar archivos.


### 2. Contenido :blue_book:

Spring MVC es el módulo de Spring que se encarga del manejo de peticiones HTTP (el protocolo que se usa en los servicios web REST).

Una API utiliza ciertos protocolos para permitir la comunicación entre aplicaciones programadas en diferentes lenguajes de programación. Acá es donde entran los servicios web, una tecnología que utiliza un conjunto de estándares y protocolos para intercambiar datos entre aplicaciones. En este sentido tenemos dos términos que usualmente son utilizados como sinónimos: REST y RESTful, estos definen características y/o principios de diseño que se deben seguir para programar servicios web.

Es importante conocer e implementar bien estos principios de diseño para crear una API con las características necesarias para ser considerada RESTful.

En la sesión 4 ya tuvimos un primer acercamiento a Spring Boot, así que en esta sesión veremos algunos puntos adicionales que te ayudarán a recibir peticiones de los usuarios de los servicios, y regresar respuestas en distintos formatos.

En este módulo aprenderemos:

- Recibir y procesar parámetros de peticiones.
- Regresar objetos como respuesta.
- Cargar y descargar archivos.

---

<img src=".github/assets/img/request.png" align="right" height="90" hspace="10">

#### <ins>Tema 1: Parámetros de peticiones HTTP POST y GET</ins>

La forma de comunicarse entre un cliente y el servidor es a través de peticiones HTTP, en el que el cliente envía una petición y datos hacia el servidor, este los interpreta y procesa para generar una respuesta al cliente. Spring MVC es muy flexible y existen muchas formas en las que puede recibir estos parámetros. En el [primer ejemplo](./Ejemplo-01) veremos como recibir información de una petición POST en el cuerpo de la petición. Y en tu [primer reto](./Reto-01) deberás, además de esto, recibir parámetros por la URL en forma de *query string*.


- [**`EJEMPLO 1`**](./Ejemplo-01)
- [**`Reto 1`**](./Reto-01)

---

<img src=".github/assets/img/response.png" align="right" height="90" hspace="10">

#### <ins>Tema 2: Regresar objetos como respuesta.</ins>

Ahora que sabemos cómo recibir una petición por parte del usuario, hay que procesarla y darle una respuesta. Existen diferentes formas en las que podemos regresar una respuesta a un cliente. En la siguiente sesión veremos cómo regresar una página web, pero en el [segundo ejemplo](./Ejemplo-02) veremos cómo regresar un objeto que será automáticamente convertido en JSON para que el cliente pueda interpretarlo.

- [**`EJEMPLO 2`**](./Ejemplo-02)

---

<img src=".github/assets/img/upload.jpg" align="right" height="90" hspace="10">

#### <ins>Tema 3: Carga y descarga de archivos.</ins>

Si bien la mayor parte de la comunicación entre cliente y servidor se realizan por medio de intercambio de información en texto plano, en algunas ocasiones será necesario el intercambio de archivos en un formato binario, ya sea para realizar la carga o descarga de archivos. En el [tercer ejemplo](./Ejemplo-03) veremos cómo realizar la carga de un archivo desde un cliente hasta el servidor. 

- [**`EJEMPLO 3`**](./Ejemplo-03)


---

### 3. Postwork :memo:

Encuentra las indicaciones y consejos para reflejar los avances de tu proyecto de este módulo.

- [**`POSTWORK SESIÓN 6`**](./Postwork/)

<br/>

</div>
