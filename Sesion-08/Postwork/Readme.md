## Sesión 8: Conexión a base de datos con Spring Data

### OBJETIVO

- Almacenar la información de los nuevos registros de la agenda en una base de datos relacional.
- Recuperar de la base de datos los registros existentes para mostrarlos en la lista de entradas.

### DESARROLLO

En el Postwork de la sesión anterior le dimos a nuestra agenda una interfaz de usuario muy sencilla. Con ella ya podemos ingresar en un formulario la información de las personas, y recuperar la misma para mostrarla en una lista. Sin embargo, debido a que estamos usando un almacén en memoria, cada vez que reiniciamos la aplicación perdemos la información que ya habíamos guardado. 

En esta ocasión tu misión será extender este programa eliminando el `Set` en donde almacenamos la información de la agenda, y reemplzándolo por una base de datos relacional en MySQL. De esta forma, aunque reiniciemos la aplicación la información seguirá estando disponible.

1. Deberás integrar las depencias de Spring data JPA y el driver de MySQL en el archivo `build.gradle`.
1. Reemplaza la clase `AgendaMemoryDao` por un repositorio de Spring Data.
1. Convierte la clase `Persona` en una entidad de JPA.
1. Los distintos elementos de la aplicación se conectarán a través de clases “servicio” y controladores de Spring MVC.


---

### Solución
¡Recuerda intentar resolver el reto antes de ver la solución! Una vez que lo hayas intentado puedes dirijirte al [proyecto con la solución](./solucion).