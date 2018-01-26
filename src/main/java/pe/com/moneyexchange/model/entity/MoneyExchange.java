package pe.com.moneyexchange.model.entity;

import java.util.Map;

public class MoneyExchange {

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

  MoneyExchange(String date, String base, Map<String,String> rates) {

    this.setRates(rates);
    this.setBase(base);
    this.setDate(date);

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

    public MoneyExchange build() {
      return new MoneyExchange(date, base, rates);
    }

  }

}
