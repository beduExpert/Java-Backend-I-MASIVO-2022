## Postwork Sesión 2: Patrón Decorador

### 🎯 OBJETIVO

- Resolver un problema utilizando patrones de diseño
- Construir la solución utilizando Gradle

### DESARROLLO

En esta sesión aprendimos la importancia de los patrones de diseño en el desarrollo y el cómo pueden facilitarnos la solución de diversos problemas a través de la Programación Orientada a Objetos. 

Recuerda que todo lo trabajado en tu prework, así como durante la sesión, puede ser aplicado a tu proyecto personal. 

El postwork se realizará en equipo, los cuales serán formados previamente a la sesión uno.

**Asegúrate de comprender:**
1. Cómo construir una solución utilizando Gradle
2. Las diferentes categorías de Patrones de Diseño
3. En qué casos utilizar un patrón de diseño determinado


**Indicaciones generales:**

Una cadena de helados muy famosa en el país ha solicitado tu ayuda para implementar una nueva versión de su sistema actual. Sus productos disponibles son los siguientes:


- Helado Suave	**$30**
- Con Cobertura	**$20 extra**
- Con Granola 	**$10 extra**
- Con Topping	**$20 extra**

El sistema actualmente está diseñado con Programación Orientada a Objetos usando el lenguaje Java y tienen una clase por cada variante de los productos, como se muestra a continuación:

```java
class HeladoSuave {
  //...
}

class HeladoSuaveConCobertura {
  // ...
}

class HeladoSuaveConGranola {
  // ...
}

class HeladoSuaveConTopping {
  // ...
}

class HeladoSuaveConCoberturaYToping {
  // ...
}

class HeladoSuaveConToppingYGranola {
  // ...
}

class HeladoSuaveConCoberturaYGranola {
  // ...
}
```

La cadena busca agregar nuevos extras:

- Con Mermelada	**$10 extra**
- Con Galleta		**$15 extra**
 
La inclusión de estos productos complica el desarrollo del sistema actual debido a que habría que agregar todas las variantes de los productos viejos con los nuevos. Por lo tanto el sistema **no es mantenible**.

Tú misión será crear la nueva versión del sistema utilizando el patrón Decorador de los patrones estructurales, así como un programa que permita probar la nueva implementación.

A continuación te dejamos una lista de recursos donde podrás estudiar más acerca de este patrón:
- [https://refactoring.guru/es/design-patterns/decorator](https://refactoring.guru/es/design-patterns/decorator)
- [https://www.javacodegeeks.com/2015/09/decorator-design-pattern.html](https://www.javacodegeeks.com/2015/09/decorator-design-pattern.html)
- [https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/](https://www.geeksforgeeks.org/decorator-design-pattern-in-java-with-example/)


<details>
  <summary>Solución</summary>

  Comenzamos creando una interfaz llamada `Helado` que es la definición de nuestro producto base:

  ```java
  public interface Helado {
    public String getDescription();
    public int getPrice();
  }
  ```

  Ahora implementaremos el helado más sencillo que es el helado suave:

  ```java
  public class HeladoSuave implements Helado {
  
    @Override
    public String getDescription() {
      return "Helado Suave";
    }

    @Override
    public int getPrice() {
      return 30;
    }
  }
  ```

  A continuación implementaremos cada uno de los extras como un decorador:

  ```java
  public class CoberturaDecorator implements Helado {

    private Helado helado;

    public CoberturaDecorator(Helado helado) {
      this.helado = helado;
    }

    @Override
    public String getDescription() {
      return helado.getDescription() + ", con Cobertura extra";
    }

    @Override
    public int getPrice() {
      return helado.getPrice() + 20;
    }
  }
  ```

  ```java
  public class GalletaDecorator implements Helado {

    private Helado helado;

    public GalletaDecorator(Helado helado) {
      this.helado = helado;
    }

    @Override
    public String getDescription() {
      return helado.getDescription() + ", con Galleta extra";
    }

    @Override
    public int getPrice() {
      return helado.getPrice() + 15;
    }
  }
  ```

  ```java
  public class GranolaDecorator implements Helado {

    private Helado helado;

    public GranolaDecorator(Helado helado) {
      this.helado = helado;
    }

    @Override
    public String getDescription() {
      return helado.getDescription() + ", con Granola extra";
    }

    @Override
    public int getPrice() {
      return helado.getPrice() + 10;
    }
  }
  ```

  ```java
  public class MermeladaDecorator implements Helado {

    private Helado helado;

    public MermeladaDecorator(Helado helado) {
      this.helado = helado;
    }

    @Override
    public String getDescription() {
      return helado.getDescription() + ", con Mermelada extra";
    }

    @Override
    public int getPrice() {
      return helado.getPrice() + 10;
    }
  }
  ```

  ```java
  public class ToppingDecorator implements Helado {

    private Helado helado;

    public ToppingDecorator(Helado helado) {
      this.helado = helado;
    }

    @Override
    public String getDescription() {
      return helado.getDescription() + ", con Topping extra";
    }

    @Override
    public int getPrice() {
      return helado.getPrice() + 20;
    }
  }
  ```

  Por último implementaremos nuestra clase principal que simulará la compra de un helado con todos los extras:

  ```java
  public class Heladeria {

    public static void main(String [] args) {
      Helado suave = new HeladoSuave();

      suave = new CoberturaDecorator(suave);
      suave = new GranolaDecorator(suave);
      suave = new ToppingDecorator(suave);
      suave = new MermeladaDecorator(suave);
      suave = new GalletaDecorator(suave);

      System.out.println("[Ticket de compra]");
      System.out.println(suave.getDescription());
      System.out.println("$" + suave.getPrice());
    }
  }
  ```

  > 💡 *Nota: Recuerda que todos los ejemplos y retos de esta sesión utilizarán la misma configuración de Gradle, cambiando únicamente la clase principal del proyecto*

  ```groovy
  plugins {
    id 'application'
  }

  application {
    mainClass = "Heladeria"
  }
  ```
</details>


<br>

[**`Siguiente`** -> sesión 03](../../Sesion-03/)

[**`Regresar`**](../)