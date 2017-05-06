import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import labasvakaras.smartcity.Configurator;
import labasvakaras.smartcity.entities.CityItem;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.junit.*;

import java.io.*;

/**
 * Created by Arxa on 6/5/2017.
 */

public class CityItemDAOTest
{
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<BasicDBObject> collection;

    @BeforeClass
    public static void beforeTests()
    {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost"));
        database = mongoClient.getDatabase("smart_city_test");
        collection = Configurator.INSTANCE.getDatabase().getCollection("city_items_test",BasicDBObject.class);
        collection.drop();
    }

    @AfterClass
    public static void afterTests() {
        mongoClient.close();
    }

    @Before
    public void beforeTest() {
        importJSON();
    }

    @After
    public void afterTest() {
        collection.drop();
    }

    @Test
    public void insertCityItem_Test()
    {
        CityItem.Builder builder = new CityItem.Builder();
        CityItem cityItem = new CityItem();


    }

    public static void importJSON()
    {
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream("C:\\Users\\Arxa\\Desktop\\Smart_City\\test\\resources\\city_items_test.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not exist, exiting");
        }
        String strLine;
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        try {
            while ((strLine = br.readLine()) != null) {
                // convert line by line to BSON
                BasicDBObject bson = (BasicDBObject) JSON.parse(strLine);
                // insert BSONs to database
                try {
                    collection.insertOne(bson);
                }
                catch (MongoException e) {
                    // duplicate key
                    e.printStackTrace();
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
