public class SumOfFirst100Numbers {
  public static void main(String [] args) {
    int total = 0;
    
    for (int i = 1; i <= 100; i++) {
      total += i;
    }

    System.out.println("La suma de los primeros 100 números es: " + total);
  }
}