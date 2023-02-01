## Reto 02: Patrón Command

### OBJETIVO

- Resolver un problema utilizando el patrón Command.

### DESARROLLO

Tenemos un programa que manipula una variable entera llamada `counter` a través de un menú de opciones. Utiliza el patrón Command y modifica el código según sea necesario para implementar la opción de "deshacer" cambios.

> 💡 *Nota 1: Los comandos además de un método execute pueden implementar un método unexecute.*

> 💡 *Nota 2: Utiliza la clase Stack para llevar el control y saber el último comando ejecutado.* 

> 💡 *Nota 3: ¡Ten cuidado! Si el stack está vació entonces lanzará un EmptyStackException al intentar tomar un elemento.*

```java
import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int counter = 0;

    int option = 0;

    while (option != 5) {
      System.out.println("\nValor actual: " + counter);
      System.out.println("Elige alguna opción:");
      System.out.println("1. Incrementa en uno el contador");
      System.out.println("2. Multiplica por 2 el contador");
      System.out.println("3. Añade 10 al contador");
      System.out.println("4. Deshacer último cambio");
      System.out.println("5. Salir");

      option = sc.nextInt();

      switch (option) {
        case 1:
          counter += 1;
          break;
        case 2:
          counter *= 2;
          break;
        case 3:
          counter += 10;
          break;
        case 4:
          // No implementado...
          break;
      }
    }
  }
}
```

<details>
  <summary>Solución</summary>

  El primer paso será mover cada una de las operaciones a un comando:

  ```java
  public interface Command {
    public int execute(int counter);
    public int unexecute(int counter);
  }
  ```

  ```java
  public class Add10Command implements Command {

    public int execute(int counter) {
      return counter + 10;
    }

    public int unexecute(int counter) {
      return counter - 10;
    }
  }
  ```

  ```java
  public class IncrementCommand implements Command {

      public int execute(int counter) {
        return counter + 1;
      }

      public int unexecute(int counter) {
        return counter - 1;
      }
    }
    ```

    ```java
    public class MultiplyBy2Command implements Command {

    public int execute(int counter) {
      return counter * 2;
    }

    public int unexecute(int counter) {
      return counter / 2;
    }
  }
  ```

  Por último modificamos el código original de la clase `Application` para que utilice los comandos en vez de la operación directa, así como ir almacenando los comandos en el stack.

  Para implementar la opción de *deshacer cambios* basta con tomar el último elemento del stack con el método `pop` y ejecutar su método `unexecute`:

  ```java
  import java.util.EmptyStackException;
  import java.util.Scanner;
  import java.util.Stack;

  public class Application {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      Stack<Command> stack = new Stack<>();

      Command add10Command = new Add10Command();
      Command multiplyBy2Command = new MultiplyBy2Command();
      Command incrementCommand = new IncrementCommand();

      int counter = 0;

      int option = 0;

      while (option != 5) {
        System.out.println("\nValor actual: " + counter);
        System.out.println("Elige alguna opción:");
        System.out.println("1. Incrementa en uno el contador");
        System.out.println("2. Multiplica por 2 el contador");
        System.out.println("3. Añade 10 al contador");
        System.out.println("4. Deshacer último cambio");
        System.out.println("5. Salir");

        option = sc.nextInt();

        switch (option) {
          case 1:
            counter = incrementCommand.execute(counter);
            stack.add(incrementCommand);
            break;
          case 2:
            counter = multiplyBy2Command.execute(counter);
            stack.add(multiplyBy2Command);
            break;
          case 3:
            counter = add10Command.execute(counter);
            stack.add(add10Command);
            break;
          case 4:
            try {
              Command undo = stack.pop();
              if (undo != null) {
                counter = undo.unexecute(counter);
              }
            } catch (EmptyStackException e) {
              System.out.println("No hay más operaciones por deshacer");
            }
            break;
        }
      }
    }
  }
  ```

  > 💡 *Nota: Recuerda que todos los ejemplos y retos de esta sesión utilizarán la misma configuración de Gradle, cambiando únicamente la clase principal del proyecto*

  En esta ocasión hemos añadido unas líneas que permiten la ejecución de éste programa como línea de comandos.

  ```groovy
  plugins {
    id 'application'
  }

  application {
    mainClass = "Application"
  }

  run {
    standardInput = System.in
  }
  ```
</details>


<br>

[**`Siguiente`** -> postwork](../Postwork/)

[**`Siguiente`** -> sesión 03](../../Sesion-03/)

[**`Regresar`**](../)