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