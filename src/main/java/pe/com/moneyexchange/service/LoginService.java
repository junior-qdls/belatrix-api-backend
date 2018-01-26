package pe.com.moneyexchange.service;

public interface LoginService {

  boolean isLoginValid(String username, String password) throws Exception;
}
