//package labasvakaras.smartcity;
//
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import spark.Request;
//import spark.Response;
//import spark.Route;
//
//import java.io.IOException;
//import java.io.StringWriter;
//import java.io.Writer;
//
///**
// * Created by Arxa on 6/5/2017.
// */
//
//
//abstract class FreemarkerBasedRoute extends Route {
//    final Template template;
//
//    protected FreemarkerBasedRoute(final String path, final String templateName) throws IOException {
//        super(path);
//        template = MainController.getCfg().getTemplate(templateName);
//    }
//
//    @Override
//    public Object handle(Request request, Response response) {
//        StringWriter writer = new StringWriter();
//        try {
//            doHandle(request, response, writer);
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.redirect("/internal_error");
//        }
//        return writer;
//    }
//
//    protected abstract void doHandle(final Request request, final Response response, final Writer writer)
//            throws IOException, TemplateException;
//
//}
//
//
