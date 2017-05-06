package labasvakaras.smartcity.routes;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import labasvakaras.smartcity.Configurator;
import spark.Request;
import spark.Response;
import spark.Route;

public abstract class FreemarkerBasedRoute extends Route {

    protected final Template template;

    protected FreemarkerBasedRoute(String path, String templateName)
            throws IOException {
        super(path);
        Configuration cfg = Configurator.INSTANCE.getConfiguration();
        template = cfg.getTemplate(templateName);
    }

    @Override
    public Object handle(Request request, Response response) {
        StringWriter writer = new StringWriter();

        try {
            doHandle(request, response, writer);
        } catch (IOException | TemplateException ex) {
            Logger.getLogger(FreemarkerBasedRoute.class.getName()).log(Level.SEVERE, null, ex);
            response.redirect("/internal_error");
        }
        
        return writer;
    }

    protected abstract void doHandle(final Request request,
            final Response response, final Writer writer)
            throws IOException, TemplateException;

}
