package labasvakaras.smartcity.daos;

;import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import labasvakaras.smartcity.Configurator;
import labasvakaras.smartcity.entities.CityItem;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONObject;

import labasvakaras.smartcity.entities.Report;

/**
 * Created by Arxa on 6/5/2017.
 */
public class CityItemDAO
{
    private static final String COLLECTION = "city_items";

    /**
     *
     * @param cityItem Wrapper object for JSON values
     * @return id of inserted document
     */
    public static String insertCityItem(CityItem cityItem)
    {
        ObjectId id = new ObjectId();
        Document post = new Document();
        post.put("_id",id);
        post.put("type", Integer.toString(cityItem.getType()));
        post.put("location",new Document("x",String.valueOf(cityItem.getLongitude())).append("y",String.valueOf(cityItem.getLatitude())));
//        post.put("report", new Document("priority",cityItem.getPriority())
//                .append("comment",cityItem.getComment())
//                .append("resolved",String.valueOf(cityItem.isResolved()))
//                .append("report_date",cityItem.getReport_date().getTime())
//                .append("resolve_date",cityItem.getResolve_date().getTime()));
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
        query.append("_id",new ObjectId(id));
        BasicDBObject result = collection.find(query).first();
        JSONObject json = new JSONObject(result.toJson());
        CityItem.Builder builder = new CityItem.Builder();

        builder.id(id);
        builder.type(json.getInt("type"));
        builder.description(json.getString("description"));

        JSONObject location = json.getJSONObject("location");
        builder.longitude(location.getDouble("x"));
        builder.latitude(location.getDouble("y"));

//        JSONObject report = json.getJSONObject("report");
//        builder.priority(report.getString("priority"));
//        builder.comment(report.getString("comment"));
//        builder.resolved(report.getBoolean("resolved"));
//        builder.report_date(new Date(report.getLong("report_date")));
//        builder.resolve_date(new Date(report.getLong("resolve_date")));

        return builder.build();
    }

    public static void insertReport(Report report)
    {
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("priority",report.getComment())
                .append("comment",report.getComment())
                .append("resolved",report.isResolved());
        
        if(report.getReportDate() != null) {
            newDocument.append("report_date",report.getReportDate().getTime());
        }
        if(report.getResolveDate() != null) {
            newDocument.append("resolve_date",report.getResolveDate().getTime());
        }
                
        BasicDBObject searchQuery = new BasicDBObject()
                .append("_id", new ObjectId(report.getCityItemId()));
        MongoDatabase db = Configurator.INSTANCE.getDatabase();
        MongoCollection collection = db.getCollection(COLLECTION);
        collection.updateOne(searchQuery, Updates.addToSet("reports", newDocument)); //TODO check if succeeds
    }
}
