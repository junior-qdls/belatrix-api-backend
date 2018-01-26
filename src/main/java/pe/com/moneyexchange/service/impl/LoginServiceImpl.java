package pe.com.moneyexchange.service.impl;

import org.springframework.stereotype.Service;
import pe.com.moneyexchange.dao.LoginDao;
import pe.com.moneyexchange.factory.DaoFactory;
import pe.com.moneyexchange.service.LoginService;
import pe.com.moneyexchange.util.Constants;

@Service
public class LoginServiceImpl implements LoginService {

  private final LoginDao loginDao;

  public LoginServiceImpl() {

    DaoFactory factory = DaoFactory.getFactory(Constants.MONGO);
    this.loginDao = factory.getLoginDao();

  }


  public boolean isLoginValid(String username, String password) throws Exception {
    return loginDao.login(username,password);
  }
}
