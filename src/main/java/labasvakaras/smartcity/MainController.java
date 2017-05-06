package labasvakaras.smartcity;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import labasvakaras.smartcity.routes.FreemarkerBasedRoute;

import static spark.Spark.get;
import static spark.Spark.setPort;

public class MainController {

    private final Configuration cfg;

    public static void main(String[] args) throws IOException {
        new MainController();
    }

    public MainController() {
        cfg = Configurator.INSTANCE.getConfiguration();
        setPort(8082);
        
        try {
            initializeRoutes();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Configuration createFreemarkerConfiguration() {
        Configuration retVal = new Configuration();
        retVal.setClassForTemplateLoading(MainController.class, "/");
        return retVal;
    }

    private void initializeRoutes() throws IOException {
        get(new FreemarkerBasedRoute("/", "index.ftl") {
            @Override
            public void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                String username = "test";
                //String json = collection.find().first().toJson();

                HashMap<String, String> root = new HashMap<String, String>();

                root.put("Username", "dummy");

                template.process(root, writer);
            }
        });

        get(new FreemarkerBasedRoute("/signup", "index.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer)
                    throws IOException, TemplateException {

                SimpleHash root = new SimpleHash();

                // initialize values for the form.
                root.put("username", "");
                root.put("password", "");
                root.put("email", "");
                root.put("password_error", "");
                root.put("username_error", "");
                root.put("email_error", "");
                root.put("verify_error", "");

                template.process(root, writer);
            }
        });

    }

    
}
