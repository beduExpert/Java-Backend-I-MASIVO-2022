public class Application {

  public static void main(String [] args) {
    Motor motor = new MotorElectricoAdapter();
    motor.encender();
    motor.acelerar();
    motor.apagar();
  }
}