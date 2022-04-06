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
