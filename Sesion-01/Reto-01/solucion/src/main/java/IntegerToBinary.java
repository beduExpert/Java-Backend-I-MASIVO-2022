public class IntegerToBinary {
  public static void main(String [] args) {
    int number = 20;

    String binary = Integer.toBinaryString(number);

    System.out.println("El número entero " + number + " en binario es: " + binary);
  }
}