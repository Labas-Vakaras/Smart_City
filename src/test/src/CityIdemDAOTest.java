package src;

import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import freemarker.template.Configuration;
import labasvakaras.smartcity.Configurator;
import org.bson.Document;
import org.junit.*;

import javax.print.Doc;
import java.util.List;

/**
 * Created by Arxa on 6/5/2017.
 */

public class CityIdemDAOTest
{
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    @BeforeClass
    public static void beforeTests() {
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost"));
        database = mongoClient.getDatabase("smart_city_test");
        collection = Configurator.INSTANCE.getDatabase().getCollection("city_items_test");
        collection.drop();
    }

    @AfterClass
    public static void afterTests() {
        mongoClient.close();
    }

    @Before
    public void beforeTest() {
        Document doc = Document.parse("C:\\Users\\Arxa\\Desktop\\Smart_City\\src\\test\\resources\\city_items_test.json");
        collection.insertOne(doc);
    }

    @After
    public void afterTest() {
        collection.drop();
    }

    @Test
    public void testNumberOfDocuments()
    {
        Assert.assertTrue(collection.count() == 1);
    }
}
