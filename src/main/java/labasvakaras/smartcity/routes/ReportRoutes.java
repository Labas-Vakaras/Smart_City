package labasvakaras.smartcity.routes;

import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import labasvakaras.smartcity.daos.CityItemDAO;
import labasvakaras.smartcity.daos.ReportDAO;
import labasvakaras.smartcity.entities.CityItem;
import labasvakaras.smartcity.entities.Report;
import labasvakaras.smartcity.entities.ReportViewObject;
import org.json.JSONObject;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 *
 * @author Vasilis Naskos
 */
public class ReportRoutes extends RoutesInitializer {
    
    @Override
    public void initRoutes() throws IOException {
        initReportRoute();
        initReportsRoute();
    }

    protected void initReportRoute() throws IOException {
        get(new FreemarkerBasedRoute("/item/report", "report.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                String itemId = request.queryParams("id");
                
                CityItem cityItem = CityItemDAO.getCityItem(itemId);
                
                SimpleHash data = new SimpleHash();
                data.put("id", itemId);
                data.put("type", cityItem.getTypeAsString());
                data.put("description", cityItem.getDescription());
                data.put("lat", cityItem.getLatitude());
                data.put("lng", cityItem.getLongitude());
                
                template.process(data, writer);
            }
        });
        
        post(new Route("/item/report") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                Report.Builder b = new Report.Builder();
                b.cityItemId(rqst.queryParams("id"))
                        .comment(rqst.queryParams("comment"))
                        .priority(Integer.parseInt(rqst.queryParams("priority")))
                        .reportDate(new Date())
                        .resolved(false);
                
                ReportDAO.insertReport(b.build());
                
                JSONObject jsonResult = new JSONObject();
                jsonResult.put("success", true);
                return jsonResult.toString();
            }
        });
    }
    
    protected void initReportsRoute() throws IOException {
        get(new FreemarkerBasedRoute("reports", "reports.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                Map<String, Object> input = new HashMap<>();
                
                List<ReportViewObject> reports = ReportDAO.findReportsForView();
                
                input.put("reports", reports);
                template.process(input, writer);
            }
        });
    }
    
}
