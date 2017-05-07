import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import labasvakaras.smartcity.Configurator;
import labasvakaras.smartcity.daos.CityItemDAO;
import labasvakaras.smartcity.entities.CityItem;
import labasvakaras.smartcity.entities.Report;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.junit.*;

import java.io.*;
import java.util.Date;

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
        CityItem cityItem = new CityItem();
        CityItem.Builder cBuilder = new CityItem.Builder();

        cBuilder.description("test");
        cBuilder.type(15);
        cBuilder.latitude(12.131);
        cBuilder.longitude(16.1334);
        cityItem = cBuilder.build();

        Assert.assertTrue("Initial documents should be 4",collection.count() == 4);
        String id = CityItemDAO.insertCityItem(cityItem);
        Assert.assertTrue("Returned id should not be a negative",!id.equals("-1"));
    }

    @Test
    public void cityItemExistsTest()
    {
        BasicDBObject query1 = new BasicDBObject();
        query1.append("type","lamp4");
        BasicDBObject doc1 = collection.find(query1).first();
        BasicDBObject result1 = collection.find(doc1).first();
        Assert.assertTrue("Document should exist",result1 != null);

        BasicDBObject query2 = new BasicDBObject();
        query2.append("type","test"); // not type as test
        result1 = collection.find(query2).first();
        Assert.assertTrue("Document should not exist",result1 == null);
    }

    @Test
    public void insertReportTest()
    {
        Report.Builder rBuilder = new Report.Builder();
        rBuilder.reportDate(new Date());
        rBuilder.resolveDate(new Date());
        rBuilder.resolved(true);
        rBuilder.comment("comment99");
        rBuilder.priority("high");

        Report report = new Report();
        report = rBuilder.build();
        CityItemDAO.insertReport(report);

        BasicDBObject query = new BasicDBObject();
        query.append("report.comment","comment99");
        Document result = Configurator.INSTANCE.getDatabase().getCollection("city_items").find().first();
        Assert.assertTrue("Result should not be null",result != null);
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
