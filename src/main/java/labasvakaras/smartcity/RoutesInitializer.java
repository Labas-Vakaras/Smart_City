package labasvakaras.smartcity;

import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.Writer;
import labasvakaras.smartcity.daos.CityItemDAO;
import labasvakaras.smartcity.routes.FreemarkerBasedRoute;
import labasvakaras.smartcity.routes.QRGeneratorRoute;
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
public class RoutesInitializer {
    
    public void initialize() throws IOException {
        initIndexRoute();
        initInsertItemRoute();
        initReportRoute();
        
        get(new QRGeneratorRoute("download_qr"));
    }
    
    protected void initIndexRoute() throws IOException {
        get(new FreemarkerBasedRoute("/", "index.ftl") {
            @Override
            public void doHandle(
                    Request request, Response response, Writer writer)
                    throws IOException, TemplateException {
                SimpleHash data = new SimpleHash();
                data.put("Username", "dummy");

                template.process(data, writer);
            }
        });
    }
    
    protected void initInsertItemRoute() throws IOException {
        get(new FreemarkerBasedRoute("/insert", "insert_item.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                template.process(null, writer);
            }
        });
        
        post(new Route("insert_item") {
            @Override
            public Object handle(Request rqst, Response rspns) {
//                CityItem.Builder builder = new CityItem.Builder();
//                builder.type(Integer.parseInt(rqst.queryParams("type")));
//                builder.longitude(Double.parseDouble(rqst.queryParams("longitude")));
//                builder.latitude(Double.parseDouble(rqst.queryParams("latitude")));

                String type = rqst.queryParams("type");
                String longitude = rqst.queryParams("longitude");
                String latitude = rqst.queryParams("latitude");
                String description = rqst.queryParams("description");

                String id = CityItemDAO.insertCityItem(
                        type != null ? type : "0",
                        longitude != null ? longitude : "0",
                        latitude != null ? latitude : "0",
                        description != null ? description : "");
                
                if(id.equals("-1")) {
                    return "{\"success\": false}";
                }
                
                JSONObject jsonDataResponse = new JSONObject();
                jsonDataResponse.put("generate_link", "/download_qr?id="+id);
                JSONObject jsonResponse = new JSONObject();
                jsonResponse.put("success", true);
                jsonResponse.put("data", jsonDataResponse);
                
                return jsonResponse.toString();
            }
        });
    }
    
    protected void initReportRoute() throws IOException {
        get(new FreemarkerBasedRoute("/item/report", "report.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                String itemId = request.queryParams("id");
                
                SimpleHash data = new SimpleHash();
                data.put("id", itemId);
                
                template.process(data, writer);
            }
        });
    }
    
}
