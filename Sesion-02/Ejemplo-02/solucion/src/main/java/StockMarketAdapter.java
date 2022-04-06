public class StockMarketAdapter implements StockMarketReport {

  private StockMarket stockMarket;

  public StockMarketAdapter() {
    stockMarket = new StockMarket();
  }

  @Override
  public String download() {
    String xml = stockMarket.download();
    return convertToJson(xml);
  }

  public String convertToJson(String xml) {
    String json = "";

    // Proceso para convertir de XML a JSON
    System.out.println("Convirtiendo la información de XML a JSON...");

    return json;
  }
}
