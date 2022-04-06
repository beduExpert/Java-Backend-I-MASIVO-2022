## Sesión 5: Java Beans y la Inversión de Control en Spring Boot :arrows_clockwise:

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" align="right" height="120" hspace="10">
<div style="text-align: justify;">

### 1. Objetivos :dart:

- Identificar qué es un Java Bean
- Usar Spring como mecanismo de inyección de dependencias


### 2. Contenido :blue_book:

El Core de Spring (su módulo principal) es un poderoso mecanismo de inyección de dependencias, el cual es una de las formas principales de inversión de control. Como desarrolladores debemos colocar algunas anotaciones básicas para indicarle a Spring el uso que le daremos a un *Bean* o componente de nuestra aplicación, y Spring se encargará de crear una instancia de este componente e inyectarlo en todos los lugares en los que lo usemos. De esta forma, no nos preocupamos por la manera en la que el *Bean* es creado, inicializado y en cómo llega a las clases en donde se necesitan. 

Al librarnos de los mecanismos de *cableado* de los elementos entre nuestras distintas clases, logramos centrarnos más en la lógica de negocio que debemos resolver. Además, esto trae un beneficio adicional: Si deseamos cambiar la implementación de un *Bean* por otra equivalente, podemos hacerlo sin ningún esfuerzo y sin reescribir o modificar todas las partes de nuestra aplicación en la que se usa ese componente; dejamos que sea Spring quien se encarga de eso.

En este módulo aprenderemos:

- Scope de los Beans en Spring
- Configuración explícita de Beans para inyección de dependencias.
- Configuración implícita de Beans para inyección de dependencias.
- Inicialización de propiedades.

---

<img src=".github/assets/img/beans.jpeg" align="right" height="90" hspace="10">

#### <ins>Tema 1: ¿Qué son los Beans en Spring?</ins>

Los **Beans** en Spring Framework son los objetos que forman la columna vertebral de nuestras aplicaciones. Estos son manejados por el núcleo de inversión de control de Spring. Un **Bean** es automáticamente instanciado, inicializado, ensamblado y administrado por el contenedor de IoC de Spring.

El trabajo con *Beans* es un cambio a la forma tradicional de programación en la que el programador es responsable de cada aspecto de un objeto; aquí permitimos que sea el framework quien controle a estos objetos, delegándole de esa forma parte de la responsabilidad de la aplicación.

Crear e inyectar un *Bean* en Spring es muy sencillo, como lo veremos en el Ejemplo 1.

- [**`EJEMPLO 1`**](./Ejemplo-01)

---

<img src=".github/assets/img/selection.jpg" align="right" height="90" hspace="10">

#### <ins>Tema 2: Configuración implícita de Beans para inyección de dependencias.</ins>

Si bien es posible inicializar y configurar los *Beans* de forma explícita (y esto es algo muy común cuando deseamos modificar la configuración por default proporcionada por los distintos componentes ya que proporciona el Framework de Spring) cuando creamos nuestras propias clases podemos ahorrarnos este trabajo al permitir que Spring configure e inicialice de forma implícita los objetos creados a partir de nuestras clases. En el [segundo ejemplo](./Ejemplo-02) veremos cómo hacer esto, y tendrás como [primer reto](./Reto-01) el modificar el scope de uno de estos objetos.

- [**`EJEMPLO 2`**](./Ejemplo-02)
- [**`Reto 1`**](./Reto-01)

---

<img src=".github/assets/img/preparation.jpg" align="right" height="90" hspace="10">

#### <ins>Tema 3: Inicialización de propiedades.</ins>

En algunas ocasiones tendremos que modificar algunos valores de los *Beans* de la aplicación, una vez que todo se ha configurado, ya sea porque necesitemos que otros objetos estén inicializados o porque hay valores que solo podremos obtener en tiempo de ejecución. Para eso, en el [tercer ejemplo](./Ejemplo-03) veremos cómo podemos realizar la inicialización de valores una vez que nuestros *Beans* han sido creados.

- [**`EJEMPLO 3`**](./Ejemplo-03)

---

### 3. Postwork :memo:

Encuentra las indicaciones y consejos para reflejar los avances de tu proyecto de este módulo.

- [**`POSTWORK SESIÓN 5`**](./Postwork/)

<br/>

</div>
