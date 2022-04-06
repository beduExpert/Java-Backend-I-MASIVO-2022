## Sesión 7: Integración de Thymeleaf y Spring Boot

### OBJETIVO

- Reemplazar el API REST creada la sesión anterior con una página HTML que reciba y procese la información de las personas regisrtadas en la agenda telefónica.

### DESARROLLO

En el Postwork de la sesión anterior implementamos una aplicación que recibe el nombre y teléfono de una persona y realiza una validación y limpieza sobre el número de teléfono. En esta ocasión tu misión será extender este programa eliminando la línea de comandos y sustituyéndolo por un controlador web el cual además de recibir la información de la persona a través de un servicio REST, deberá de: 

En el Postwork de la sesión anterior continuamos con la implementación de nuestra agenda, recibiendo los datos a través de un API REST. En ésta ocasión reemplazamos el API con una página web que contenga las siguientes funcionalidades.

1. Muestre la lista de personas registradas en la agenda, ordenadas de forma alfabética.
1. Muestre los teléfonos usando un formato de ##-####-####.
1. Contenga un formulario con validaciones y que permita agregar nuevos registros a la agenda.
1. Los distintos elementos de la aplicación se conectarán a través de clases “servicio” y controladores de Spring MVC.


---

### Solución

¡Recuerda intentar resolver el reto antes de ver la solución! Una vez que lo hayas intentado puedes dirijirte al [proyecto con la solución](./solucion).