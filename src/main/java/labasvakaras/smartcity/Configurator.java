package labasvakaras.smartcity;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import freemarker.template.Configuration;
import org.bson.Document;
import static spark.Spark.setPort;

/**
 * Configuration must be:
 * <ul>
 * <li>only one and single</li>
 * <li>thread safe</li>
 * <li>publicly accessible</li>
 * </ul>
 * 
 * @author Vasilis Naskos
 */
public enum Configurator {
    
    INSTANCE;

    private final static String MONGO_URI = "mongodb://localhost";
    private final static String MONGO_DB = "smart_city";
    public final static int PORT = 8082;
    
    private final Configuration cfg;
    private final MongoClient mongoClient;
    private final MongoDatabase database;
    
    private Configurator() {
        cfg = new Configuration();
        cfg.setClassForTemplateLoading(MainController.class, "/");
        
        mongoClient = new MongoClient(new MongoClientURI(MONGO_URI));
        database = mongoClient.getDatabase(MONGO_DB);
    }

    public Configuration getConfiguration() {
        return cfg;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
    
    public MongoCollection<Document> getCollection(String tableName) {
        return database.getCollection(tableName);
    }
}
