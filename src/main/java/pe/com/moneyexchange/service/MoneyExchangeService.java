package pe.com.moneyexchange.service;

import pe.com.moneyexchange.model.entity.MoneyExchange;

public interface MoneyExchangeService {

  MoneyExchange getExchange(String base, String rates) throws Exception;


}
