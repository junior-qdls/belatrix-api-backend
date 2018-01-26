package pe.com.moneyexchange.factory.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static pe.com.moneyexchange.util.Constants.MONGO_URI;

public class MongoConnection {

  final static Logger logger = LoggerFactory.getLogger(MongoConnection.class);

  private static MongoConnection instance = new MongoConnection();



  private MongoClient mongo = null;

  private MongoConnection() {}

  public MongoClient getMongo() throws Exception {
    if (mongo == null) {

      MongoClientOptions.Builder options = MongoClientOptions.builder()
        .connectionsPerHost(20)
        .maxConnectionIdleTime((60 * 1_000))
        .maxConnectionLifeTime((120 * 1_000));

      MongoClientURI uri = new MongoClientURI(MONGO_URI, options);

      try {
        mongo = new MongoClient(uri);
      } catch (Exception me) {
        logger.error("An error occoured", me);
        throw new Exception("Error connecting to MongoDb");
      }
    }
    return mongo;
  }


  protected static MongoConnection getInstance() {
    return instance;
  }
}
