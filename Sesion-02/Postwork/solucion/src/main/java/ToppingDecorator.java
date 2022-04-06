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