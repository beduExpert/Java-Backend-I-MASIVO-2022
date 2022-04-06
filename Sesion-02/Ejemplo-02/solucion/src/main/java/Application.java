public class Application {

  public static void main(String [] args) throws Exception {
    StockMarketReport report = new StockMarketAdapter();
    String json = report.download();

    AnalysisLibrary library = new AnalysisLibrary();
    library.analyzeInformation(json);
  }
}