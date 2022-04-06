## Reto 01: Compilación y generación de JAR con Gradle

### OBJETIVO

- Compilar y generar un archivo JAR a partir de un código Java con Gradle

### DESARROLLO

Crear un programa en Java que convierta un número entero a binario, dicho programa deberá compilarse con Gradle.

<details>
  <summary>Solución</summary>

  Afortunadamente Java cuenta con un método estático en la clase Integer que convierte un número entero en binario:

  ```java
  public class IntegerToBinary {
    public static void main(String [] args) {
      int number = 20;

      String binary = Integer.toBinaryString(number);

      System.out.println("El número entero " + number + " en binario es: " + binary);
    }
  }
  ```

  Por último, basados en el Ejemplo 02 y 03 podemos crear el siguiente archivo de Gradle:

  ```groovy
  plugins {
    id 'java'
  }

  jar {
    manifest {
      attributes 'Main-Class': 'IntegerToBinary'
    }
  }
  ```

  Así al ejecutar el comando `gradle build` generará el JAR correspondiente.
</details>