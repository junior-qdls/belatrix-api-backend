package pe.com.moneyexchange.factory;

import pe.com.moneyexchange.dao.LoginDao;
import pe.com.moneyexchange.dao.MoneyExchangeDao;
import pe.com.moneyexchange.factory.mongo.MongoDaoFactory;
import pe.com.moneyexchange.util.Constants;

public abstract class DaoFactory {


  public abstract MoneyExchangeDao getMoneyExchangeDao();
  public abstract LoginDao getLoginDao();


  public static DaoFactory getFactory(int typeDB) {

    switch (typeDB) {
      case Constants.MONGO:
          return new MongoDaoFactory();
      default:
        return new MongoDaoFactory();

    }

  }



}
