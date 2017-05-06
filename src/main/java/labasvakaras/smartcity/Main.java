package labasvakaras.smartcity;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import static spark.Spark.get;

public class Main {
    public static void main(String[] args)
    {
        /*
        Database has already one simple document in it

        HOW TO EXPORT DATABASE:
        type the following command in the desired path location in the shell
        * NOT 'inside' the mongod shell
        mongoexport -d smart_city -c city_items -o city_items.json

        HOW TO IMPORT:
        mongoimport --drop -d smart_city -c city_items city_items.json
         */
        final MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost"));
        final MongoDatabase database = mongoClient.getDatabase("smart_city");
        final MongoCollection<BasicDBObject> collection = database.getCollection("city_items",BasicDBObject.class);

        /*
        Getting the first entry in our collection
         */
        BasicDBObject data = collection.find().first();

        System.out.println(data.toJson());


        get("/hello", (req, res) -> "Hello World");
    }




}
