## Sesión 3: Pruebas dinámicas

### 🎯 OBJETIVO

- Relizar una serie de pruebas dinámicas usando JUnit 5.

### DESARROLLO

Los casos de prueba anotados con `@Test` son pruebas estáticas, esto quiere decir que al momento de compilar la aplicación ya se tienen todos los elementos de la prueba listos para ejecutarse y su comportamiento no puede cambiarse. Esto es muy útil cuando tenemos un conjunto pequeño de datos con los que queremos hacer la prueba. Pero puede convertirse en un problema cuando tenemos un conjunto grande o dinámico de las mismas `@Test` tiene muchas limitaciones. 

Para sortear estas limitaciones, JUnit 5 agrega pruebas dinámicas, que son pruebas que se generan en tiempo de ejecución por un elemento conocido como fábrica de pruebas. Para esto también agrega una nueva anotación `@TestFactory`. 

Los métodos anotados con `@TestFactory` sirven para crear fábricas de pruebas. Estos métodos deben regresar un `DynamicNode`, `Stream`, `Collection`, `Iterable`, `Iterator`, o arreglo de `DynamicNode`.

El cliente de la calculadora nos ha dicho que algunos de sus ingenieros dudan de la calidad de nuestra calculadora, ya que se realizaron muy pocas pruebas de la misma y nos pide que generemos 1000 pruebas de alguna operación realizada por la calculadora para ganarnos su total y entera confianza. 

Para demostrarles que estamos comprometidos con nuestros clientes y queremos darles la tranquilidad a todos los miembros de su equipo, hemos decidido que realizaremos 1000 pruebas. Como no queremos estar todo el día escribiendo las pruebas, y después de una larga sesión de planeación con los Projects Managers, el becario (quién acaba de terminar la sesión 3 de este módulo y por lo tanto ya conoce la respuesta al problema) nos ha sugerido que usemos una prueba dinámica para generar las 1000 evidencias que necesitamos.

En este postwork deberás crear una prueba dinámica sobre cualquiera de las operaciones de la calculadora. La prueba debe ejecutarse al menos 1000 veces con números distintos, y debes garantizar que todas las ejecuciones terminen con un resultado exitoso.

A continuación te dejamos una lista de recursos donde podrás obtener más información de `@TestFactory`:
- [https://mincong.io/2021/04/09/junit-5-dynamic-tests/](JUnit 5: Dynamic Tests with TestFactory)
- [https://javabydeveloper.com/junit-5-dynamic-tests-testfactory-with-examples/](Junit 5 dynamic tests @TestFactory with examples)
- [https://roytuts.com/dynamic-tests-testfactory-in-junit-5/](Dynamic Tests – @TestFactory in Junit 5)


<details>
  <summary>Solución</summary>

  Comenzamos escribiendo la clase que contiene contendrá el método que servirá como fábrica de pruebas:

  ```java
  class CalculadoraTest {


  }
  ```

  De todas las opciones que podemos usar como tipo de retorno para `@TestFactory` los dos más fáciles de usar son los que regresan un `Stream` o un `Collection`. En este caso usaremos la primera opción y haremos que el método regrese un `Stream` de objetos de tipo `DynamicTest`. También inicializaremos el objeto calculadora que usaremos para la comprobación.

  ```java
  class CalculadoraTest {

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamInJava8() {
        Calculadora calculadora = new Calculadora();
    }
  }
  
  ```

  Lo siguiente que haremos es definir dos conjuntos de datos. El primero contiene los valores de entrada que le daremos a la calculadora. En este caso serán los números del 0 al 9999, con esto generaremos nuestras 1000 pruebas. El segundo conjunto de datos contiene los valores que estamos esperando como respuesta. Para no complicar mucho el código lo que haremos será multiplicar cada valor por 2. Eso quiere decir que probaremos que al multiplicar 0 * 2 obtenemos como resultado 0; al multiplicar 1 * 2 obtendremos como resultado 2; al multiplicar 1 * 3 obtendremos como resultado 6; y así sucesivamente. 

  ```java
  
class CalculadoraTest {

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamInJava8() {

        Calculadora calculadora = new Calculadora();
        List<Integer> entradas = IntStream.range(0, 1000).boxed().toList();
        List<Integer> resultados = IntStream.range(0, 1000).map(n -> n * 2).boxed().toList();
  
    }
}  
  
  ```

Por último creamos el `Stream` con el código dinámico de la prueba. Este tomará cada uno de los valores del primer conjunto de datos, `entradas`, aplicará la operación de multiplicación * 2 y verificará que el resultado obtenido corresponde al valor esperado en `resultados`:


  ```java
class CalculadoraTest {

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamInJava8() {

        Calculadora calculadora = new Calculadora();
        List<Integer> entradas = IntStream.range(0, 1000).boxed().toList();
        List<Integer> resultados = IntStream.range(0, 1000).map(n -> n * 2).boxed().toList();
        
        return entradas.stream()
                .map(numero -> DynamicTest.dynamicTest("multiplicando: " + numero,
                        () -> {
                            assertEquals(calculadora.multiplica(numero, 2), resultados.get(numero));
                        }));
    }
}
  ```

Al ejecutar la prueba debes obtener un resultado exitoso y un mensaje indicando que se han ejecutado las 1000 pruebas. 

![imagen](img/img_01.png)

</details>