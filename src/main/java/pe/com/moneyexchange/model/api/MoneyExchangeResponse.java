package pe.com.moneyexchange.model.api;

import java.util.Map;

public class MoneyExchangeResponse {

  private String base;
  private String date;
  private Map<String,String> rates;

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Map<String, String> getRates() {
    return rates;
  }

  public void setRates(Map<String, String> rates) {
    this.rates = rates;
  }

  public MoneyExchangeResponse(String date, String base, Map<String,String> rates) {
    this.date = date;
    this.base = base;
    this.rates = rates;
  }

  public static Builder builder() {
    return new Builder();
  }


  public static class Builder {
    private String base;
    private String date;
    private Map<String, String> rates;

    public Builder base(String base) {
      this.base = base;
      return this;
    }

    public Builder date(String date) {
      this.date = date;
      return this;
    }

    public Builder rates(Map<String, String> rates) {
      this.rates = rates;
      return this;
    }

    Builder() {

    }

    public MoneyExchangeResponse build() {
      return new MoneyExchangeResponse(date, base, rates);
    }

  }


}
