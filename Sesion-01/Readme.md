## Sesión 1: Construcción de proyectos con Gradle :elephant:

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/gradle/gradle-plain.svg" align="right" height="120" hspace="10">

<div style="text-align: justify;">
 
### 1. Objetivos :dart:

- Aprender el uso de la herramienta Gradle para construir y ejecutar proyectos en lenguaje Java.

### 2. Contenido :blue_book:

#### 👀 Antes de comenzar...

Debemos verificar que nuestro equipo tenga correctamente instalado **Java** y **Gradle**:

- Para verificar la versión instalada de **Java** ejecuta el comando `java -version`:

<img src="../.github/assets/img/java-version.png" alt="Versión de Java" />

*Nota: Usaremos la versión 11 de Java aunque puedes usar la más reciente.*

- Para verificar la versión instalada de **Gradle** ejecuta el comando `gradle -version`:

<img src="../.github/assets/img/gradle-version.png" alt="Versión de Gradle" />

*Nota: Usaremos la versión 7 de Gradle aunque puedes usar la más reciente.*

En este módulo aprenderemos:
- Creación de archivo `build.gradle`
- Compilación de código Java usando Gradle
- Ejecución de programas en código Java usando Gradle
- Instalación y uso de plugins de Gradle

---

<img src=".github/assets/img/Build-Tools.jpg" align="right" height="90" hspace="10">

#### <ins>Tema 1: ¿Qué es Gradle?</ins>

Todo proyecto que utilice Gradle como herramienta de construcción debe tener un archivo llamado `gradle.build` el cual contiene las instrucciones necesarias (en lenguaje Groovy) para ejecutar **tareas** que ayuden a realizar alguna acción sobre código.

Comenzaremos con el [primer ejemplo](./Ejemplo-01) creando nuestras propias tareas personalizadas para conocer el uso básico de Gradle.

- [**`EJEMPLO 1`**](./Ejemplo-01)

---

<img src=".github/assets/img/command-line.jpg" align="right" height="90" hspace="10">

#### <ins>Tema 2: Compilación y ejecución con Gradle.</ins>

Ahora que conocemos el uso general de Gradle, veremos cómo usarlo para el desarrollo de aplicaciones Java. En el [segundo ejemplo](./Ejemplo-02) lo usaremos para compilar una aplicación desde línea de comandos (así es, sin usar un IDE) y posteriormente, en el [tercer ejemplo](./Ejemplo-03) generaremos un jar para su ejecución usando el mismo Gradle.

Es aquí donde tendrás tu [primer reto](./Reto-01) en el que tendrás que escribir tu primera aplicación, compilarla y generar un archivo `.jar`.

- [**`EJEMPLO 2`**](./Ejemplo-02)
- [**`EJEMPLO 3`**](./Ejemplo-03)
- [**`Reto 1`**](./Reto-01)

---

 <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" align="right" height="90" hspace="10">

#### <ins>Tema 3: Compilación y ejecución de aplicaciones Javas.</ins>

Aquí aprenderás como compilar y ejecutar tu aplicación sin tener que generar el archivo `.jar`. Para eso usaremos un plugin de Gradle, `application` el cual nos simplificará la vida. 

- Compilación y ejecución de aplicaciones Java

- [**`EJEMPLO 4`**](./Ejemplo-04)
- [**`Reto 2`**](./Reto-02)

---

### 3. Postwork :memo:

Encuentra las indicaciones y consejos para reflejar los avances de tu proyecto de este módulo.
 
- [**`POSTWORK SESIÓN 1`**](./Postwork/)
  
<br/>

</div>
