package labasvakaras.smartcity.routes;

import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.Writer;
import spark.Request;
import spark.Response;
import static spark.Spark.get;

/**
 *
 * @author Vasilis Naskos
 */
public class GenericRoutes extends RoutesInitializer {

    @Override
    public void initRoutes() throws IOException {
        initAboutRoute();
    }

    protected void initAboutRoute() throws IOException {
        get(new FreemarkerBasedRoute("/about", "about.ftl") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                template.process(null, writer);
            }
        });
    }
}
