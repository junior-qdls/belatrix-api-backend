package pe.com.moneyexchange.dao;

public interface MoneyExchangeDao<T> {

  T getByFilter(String base, String symbols) throws Exception;

}