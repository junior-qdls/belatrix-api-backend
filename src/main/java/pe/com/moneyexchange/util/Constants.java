package pe.com.moneyexchange.util;

public class Constants {

  public static final String MONGO_URI = "mongodb://admin:admin@cluster0-shard-00-00-12o8h.mongodb.net:27017," +
    "cluster0-shard-00-01-12o8h.mongodb.net:27017," +
    "cluster0-shard-00-02-12o8h.mongodb.net:27017" +
    "/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin";

  public static final int MONGO = 1;

  public static final String MONGO_DATABASE = "dbMoneyExchange";

  public static final String MONGO_EXCHANGE_COLLECTION = "MoneyExchangeCollection";
  public static final String MONGO_USER_COLLECTION = "UserLoginCollection";

}
