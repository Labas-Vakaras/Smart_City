package labasvakaras.smartcity.daos;

;import com.mongodb.BasicDBObject;
import com.mongodb.DuplicateKeyException;
import com.mongodb.client.MongoCollection;
import labasvakaras.smartcity.Configurator;
import labasvakaras.smartcity.entities.CityItem;
import netscape.javascript.JSObject;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONObject;

/**
 * Created by Arxa on 6/5/2017.
 */

public class CityItemDAO
{
    private static final String COLLECTION = "city_items";


    public static String insertCityItem(String type, String location_x, String location_y, String description)
    {
        ObjectId id = new ObjectId();
        Document post = new Document();
        post.put("_id",id);
        post.put("type",type);
        post.put("location",new Document("x",location_x).append("y",location_y));
        post.put("description",description);
        MongoCollection<Document> collection = Configurator.INSTANCE.getDatabase().getCollection(COLLECTION);
        try {
            collection.insertOne(post);
            return id.toString();
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return "-1";
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

    public static CityItem getCityItem(String id)
    {
        MongoCollection<BasicDBObject> collection = Configurator.INSTANCE.getDatabase().getCollection(COLLECTION,BasicDBObject.class);
        BasicDBObject query = new BasicDBObject();
        query.append("_id",id);
        BasicDBObject result = collection.find(query).first();
        JSONObject json = new JSONObject(result.toJson());
        CityItem.Builder builder = new CityItem.Builder();

        builder.id(json.getString("id"));
        builder.type(json.getInt("type"));
        builder.longitude(json.getDouble("x"));
        builder.latitude(json.getDouble("y"));
        // TODO Add Description
        return builder.build();
    }
}
