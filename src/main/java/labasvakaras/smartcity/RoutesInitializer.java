package labasvakaras.smartcity;

import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.Writer;
import labasvakaras.smartcity.daos.CityItemDAO;
import labasvakaras.smartcity.entities.CityItem;
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
                CityItem.Builder builder = new CityItem.Builder();
                builder.type(Integer.parseInt(rqst.queryParams("type")));
                // TODO add description to frontend
                builder.longitude(Double.parseDouble(rqst.queryParams("longitude")));
                builder.latitude(Double.parseDouble(rqst.queryParams("latitude")));
                builder.description(" ");

                String id = CityItemDAO.insertCityItem(builder.build());
                
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
    }
    
}
