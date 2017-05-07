package labasvakaras.smartcity.routes;

import java.io.IOException;
import labasvakaras.smartcity.daos.ReportDAO;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;

/**
 *
 * @author Vasilis Naskos
 */
public class ApiRoutes extends RoutesInitializer {
    
    @Override
    public void initRoutes() throws IOException {
        initReportsRoute();
    }
    
    protected void initReportsRoute() {
        get(new Route("/api/reports") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                return ReportDAO.findReportsRaw().toString();
            }
        });
    }
}
