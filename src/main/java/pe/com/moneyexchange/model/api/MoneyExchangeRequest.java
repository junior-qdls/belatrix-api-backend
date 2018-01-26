package pe.com.moneyexchange.model.api;


public class MoneyExchangeRequest {

  private String base;


  private String symbols;

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public String getSymbols() {
    return symbols;
  }

  public void setSymbols(String symbols) {
    this.symbols = symbols;
  }
}
