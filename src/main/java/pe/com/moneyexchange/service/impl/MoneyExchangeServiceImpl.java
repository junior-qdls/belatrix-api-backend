package pe.com.moneyexchange.service.impl;

import org.springframework.stereotype.Service;
import pe.com.moneyexchange.dao.MoneyExchangeDao;
import pe.com.moneyexchange.factory.DaoFactory;
import pe.com.moneyexchange.model.entity.MoneyExchange;
import pe.com.moneyexchange.service.MoneyExchangeService;
import pe.com.moneyexchange.util.Constants;

import static pe.com.moneyexchange.util.Constants.MONGO;


@Service
public class MoneyExchangeServiceImpl implements MoneyExchangeService{


  private MoneyExchangeDao<MoneyExchange> moneyExchangeDao;

  public MoneyExchangeServiceImpl() {

    DaoFactory factory = DaoFactory.getFactory(MONGO);
    this.moneyExchangeDao = factory.getMoneyExchangeDao();

  }


  public MoneyExchange getExchange(String base, String rates) throws Exception {
    return moneyExchangeDao.getByFilter(base,rates);
  }

}
