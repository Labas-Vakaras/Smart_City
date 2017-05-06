package labasvakaras.smartcity.daos;

;import com.mongodb.BasicDBObject;
import com.mongodb.DuplicateKeyException;
import com.mongodb.client.MongoCollection;
import labasvakaras.smartcity.Configurator;
import org.bson.Document;

/**
 * Created by Arxa on 6/5/2017.
 */

public class CityItemDAO
{
    private static final String COLLECTION = "city_items";


    public static boolean insertCityItem(String type, String location_x, String location_y, String description)
    {
        Document post = new Document();
        post.put("type",type);
        post.put("location",new Document("x",location_x).append("y",location_y));
        post.put("description",description);
        MongoCollection<Document> collection = Configurator.INSTANCE.getDatabase().getCollection(COLLECTION);
        try {
            collection.insertOne(post);
            return true;
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean cityItemExists(String id)
    {
        MongoCollection<BasicDBObject> collection = Configurator.INSTANCE.getDatabase().getCollection(COLLECTION,BasicDBObject.class);

        BasicDBObject query = new BasicDBObject();
        query.append("_id",id);
        BasicDBObject result = collection.find(query).first();
        return !result.isEmpty();
    }
}
