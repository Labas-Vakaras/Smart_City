package labasvakaras.smartcity;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import labasvakaras.smartcity.routes.QRGeneratorRoute;

import static spark.Spark.get;

public class Main {
    public static void main(String[] args) {
        testMongo();
        
        /**
         * Produce QR image by resolve the given item id GET parameter
         */
        get(new QRGeneratorRoute("produce_qr"));
    }

    /**
     * Temporarily added to test MongoDB connection
     */
    public static void testMongo() {
        final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost"));
        final MongoDatabase database = mongoClient.getDatabase("smart_city");
        final MongoCollection<BasicDBObject> collection = database.getCollection("city_items", BasicDBObject.class);
        BasicDBObject data = collection.find().first();
        System.out.println(data.toJson());
    }


}
