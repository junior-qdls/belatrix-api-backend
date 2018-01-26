package pe.com.moneyexchange.factory.mongo;

import pe.com.moneyexchange.dao.LoginDao;
import pe.com.moneyexchange.dao.MoneyExchangeDao;
import pe.com.moneyexchange.dao.MongoLoginDao;
import pe.com.moneyexchange.dao.MongoMoneyExchangeDao;
import pe.com.moneyexchange.factory.DaoFactory;

public class MongoDaoFactory extends DaoFactory {

  public static MongoConnection createConnection() throws Exception {

    MongoConnection connection = null;

    try {
      connection = MongoConnection.getInstance();
    } catch (Exception e) {
      throw new Exception("An error occoured when connecting to MongoDB");
    }
    return connection;
  }


  @Override
  public MoneyExchangeDao getMoneyExchangeDao() {

    return new MongoMoneyExchangeDao();

  }

  @Override
  public LoginDao getLoginDao() {
    return new MongoLoginDao();
  }
}
