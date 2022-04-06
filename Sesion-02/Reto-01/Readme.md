## Reto 01: Patrón Adapter

### OBJETIVO

- Resolver un problema utilizando el patrón Adapter.

### DESARROLLO

Un motor para un carro clásico debe implementar las siguientes operaciones:

```java
public abstract class Motor {

  public abstract void encender();

  public abstract void acelerar();

  public abstract void apagar();
}
```

Por ejemplo la siguiente clase es la implementación de un motor común:

```java
public class MotorComun extends Motor {

  public MotorComun() {
    super();
    System.out.println("Creando el motor comun");
  }

  @Override
  public void encender() {
    System.out.println("encendiendo motor comun");
  }

  @Override
  public void acelerar() {
    System.out.println("acelerando el motor comun");
  }

  @Override
  public void apagar() {
    System.out.println("Apagando motor comun");
  }
}
```

El dueño de este carro ha comprado un motor eléctrico, el cual tiene las siguientes operaciones:

```java
public class MotorElectrico {

  private boolean conectado = false;

  public MotorElectrico() {
    System.out.println("Creando motor electrico");
    this.conectado = false;
  }

  public void conectar() {
    System.out.println("Conectando motor electrico");
    this.conectado = true;
  }

  public void activar() {
    if (!this.conectado) {
      System.out.println(
        "No se puede activar porque no " + "esta conectado el motor electrico"
      );
    } else {
      System.out.println("Esta conectado, activando motor" + " electrico....");
    }
  }

  public void moverMasRapido() {
    if (!this.conectado) {
      System.out.println(
        "No se puede mover rapido el motor " +
        "electrico porque no esta conectado..."
      );
    } else {
      System.out.println("Moviendo mas rapido...aumentando voltaje");
    }
  }

  public void detener() {
    if (!this.conectado) {
      System.out.println(
        "No se puede detener motor electrico" + " porque no esta conectado"
      );
    } else {
      System.out.println("Deteniendo motor electrico");
    }
  }

  public void desconectar() {
    System.out.println("Desconectando motor electrico...");
    this.conectado = false;
  }
}
```

Como podemos ver, el motor eléctrico tiene más operaciones que un motor común, por lo cual son incompatibles.

Utiliza el patrón Adapter para implementar una clase que haga compatible el carro con el motor eléctrico.

<details>
  <summary>Solución</summary>

  Creamos la clase `MotorElectricoAdapter` que implementa los métodos de la clase abstracta `Motor`:

  ```java
  public class MotorElectricoAdapter extends Motor {

  private MotorElectrico motorElectrico;

  public MotorElectricoAdapter() {
    super();
    this.motorElectrico = new MotorElectrico();
    System.out.println("Creando motor Electrico adapter");
  }

  @Override
  public void encender() {
    System.out.println("Encendiendo motorElectricoAdapter");
    this.motorElectrico.conectar();
    this.motorElectrico.activar();
  }

  @Override
  public void acelerar() {
    System.out.println("Acelerando motor electrico...");
    this.motorElectrico.moverMasRapido();
  }

  @Override
  public void apagar() {
    System.out.println("Apagando motor electrico");
    this.motorElectrico.detener();
    this.motorElectrico.desconectar();
  }
}
```

Con esto, hemos hecho que el motor eléctrico sea totalmente compatible con el carro (dado que implementa la clase abstracta Motor).

Por lo tanto escribiremos el siguiente código para probar nuestra implementación:

```java
public class Application {

  public static void main(String [] args) {
    Motor motor = new MotorElectricoAdapter();
    motor.encender();
    motor.acelerar();
    motor.apagar();
  }
}
```

> 💡 *Nota: Recuerda que todos los ejemplos y retos de esta sesión utilizarán la misma configuración de Gradle, cambiando únicamente la clase principal del proyecto*

```groovy
plugins {
  id 'application'
}

application {
  mainClass = "Application"
}
```
</details>