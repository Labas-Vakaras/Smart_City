package labasvakaras.smartcity.routes;

import labasvakaras.smartcity.daos.ReportDAO;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;

/**
 *
 * @author Vasilis Naskos
 */
public class ApiRoutes {
    
    public void initApiRoutes() {
        initReportsRoute();
    }
    
    /**
     * 
     */
    protected void initReportsRoute() {
        get(new Route("/api/reports") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                return ReportDAO.findReportsRaw().toString();
            }
        });
    }
    
}
