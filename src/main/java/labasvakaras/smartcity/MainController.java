package labasvakaras.smartcity;

import freemarker.template.Configuration;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.Spark;

public class MainController {

    private final Configuration cfg;

    public MainController() {
        this.cfg = Configurator.INSTANCE.getConfiguration();

        Spark.setPort(Configurator.PORT);
        Spark.staticFileLocation("/public");
        
        initializeRoutes();
    }

    private void initializeRoutes() {
        try {
            RoutesInitializer routesInitializer = new RoutesInitializer();
            routesInitializer.initialize();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws IOException {
        new MainController();
    }
}
