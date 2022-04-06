## Reto 01: Inicialización de datos con SQL

### OBJETIVO

- Aprovechar las capacidades de Spring Boot para ejecutar archivos SQL al momento de iniciar la aplicación.
- Inicializar valores de catálogos en base de datos.


### DESARROLLO

En el ejemplo anterior creamos una tabla e inicializamos el catálogo de `etapas` de la aplicación desde una clase que implementa la interface `CommandLineRunner`. Dentro de esta usamos la implementación de un repositorio de Spring Data JPA. Esta es una forma que tiene ventajas, pero no es la única forma de hacerlo cuando tenemos una aplicación creada con Spring Boot.

En este reto tendrás que eliminar la clase que implementa `CommandLineRunner` y lograr la creación de la tabla `etapas`, así como su inicialización. 

Como tip: deberás crear dos archivos `.sql` diferentes, uno con la estructura de la tabla y otro con los datos para inicializarla.

Para la estructura de la tabla, puedes usar el siguiente bloque de SQL:

```sql
CREATE TABLE `etapas` (
    `etapa_id` bigint       NOT NULL AUTO_INCREMENT,
    `nombre`   varchar(100) NOT NULL,
    `orden`    int          NOT NULL,
    PRIMARY KEY (`etapa_id`),
    UNIQUE KEY `UN_ORDERN` (`orden`)
);
```

---

### Solución

¡Recuerda intentar resolver el reto antes de ver la solución! Una vez que lo hayas intentado puedes dirijirte al [proyecto con la solución](./solucion).