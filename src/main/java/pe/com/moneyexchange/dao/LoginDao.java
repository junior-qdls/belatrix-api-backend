package pe.com.moneyexchange.dao;

public interface LoginDao {

  boolean login(String username, String password) throws Exception;
}
