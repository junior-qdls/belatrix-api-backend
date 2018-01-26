package pe.com.moneyexchange.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import pe.com.moneyexchange.exceptions.BadCredentialsException;
import pe.com.moneyexchange.factory.mongo.MongoConnection;
import pe.com.moneyexchange.factory.mongo.MongoDaoFactory;
import pe.com.moneyexchange.util.Constants;

import java.util.Optional;

import static pe.com.moneyexchange.util.Constants.MONGO_DATABASE;
import static pe.com.moneyexchange.util.Constants.MONGO_USER_COLLECTION;

public class MongoLoginDao implements LoginDao {

  @Override
  public boolean login(String username, String password) throws Exception {

    MongoConnection connection = MongoDaoFactory.createConnection();

    MongoDatabase database = connection.getMongo().getDatabase(MONGO_DATABASE);
    MongoCollection<Document> mongoCollection = database.getCollection(MONGO_USER_COLLECTION);

    Document document = mongoCollection.find(Filters.and(Filters.eq("user",username),
                                  Filters.eq("password",password))).first();

    Optional.ofNullable(document).orElseThrow( () -> new BadCredentialsException(
                                String.format("Usuario : %s o password no concuerdan",username)));

    return Boolean.TRUE;
  }
}
