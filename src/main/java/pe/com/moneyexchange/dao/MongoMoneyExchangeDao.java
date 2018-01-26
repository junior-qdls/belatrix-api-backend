package pe.com.moneyexchange.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import pe.com.moneyexchange.exceptions.DataNotFoundException;
import pe.com.moneyexchange.factory.mongo.MongoConnection;
import pe.com.moneyexchange.factory.mongo.MongoDaoFactory;
import pe.com.moneyexchange.model.entity.MoneyExchange;

import java.util.Map;
import java.util.Optional;

import static pe.com.moneyexchange.util.Constants.MONGO_DATABASE;
import static pe.com.moneyexchange.util.Constants.MONGO_EXCHANGE_COLLECTION;

public class MongoMoneyExchangeDao implements MoneyExchangeDao<MoneyExchange> {



  public MoneyExchange getByFilter(String base, String symbols) throws Exception {

    MongoConnection connection = MongoDaoFactory.createConnection();

    MongoDatabase database = connection.getMongo().getDatabase(MONGO_DATABASE);
    MongoCollection<Document> mongoCollection = database.getCollection(MONGO_EXCHANGE_COLLECTION);



    Document document = mongoCollection.find(Filters.and(Filters.eq("base", base),
                                                    Filters.exists(String.format("rates.%s",symbols))))
                                                    .first();

    Optional.ofNullable(document).orElseThrow( () -> new DataNotFoundException("No se encontró resultados."));
    return MoneyExchange.builder().base(document.getString("base"))
                            .date(document.getString("date"))
                              .rates(document.get("rates", Map.class)).build();


  }



}
