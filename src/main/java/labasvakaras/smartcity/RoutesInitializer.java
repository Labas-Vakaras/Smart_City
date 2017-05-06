package labasvakaras.smartcity;

import freemarker.template.SimpleHash;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.Writer;
import labasvakaras.smartcity.routes.FreemarkerBasedRoute;
import labasvakaras.smartcity.routes.QRGeneratorRoute;
import spark.Request;
import spark.Response;
import static spark.Spark.get;

/**
 *
 * @author Vasilis Naskos
 */
public class RoutesInitializer {
    
    public void initialize() throws IOException {
        initIndexRoute();
        
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
    
}
