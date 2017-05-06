package labasvakaras.smartcity.routes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * Route responsible for QR image production
 * 
 * @author Vasilis Naskos
 */
public class QRGeneratorRoute extends Route {

    public QRGeneratorRoute(String path) {
        super(path);
    }
    
    @Override
    public Object handle(Request rqst, Response rspns) {
        String id = rqst.queryParams("id");
        System.out.println(id);

        HttpServletResponse raw = rspns.raw();
        rspns.header("Content-Disposition", "attachment; filename=image.png");
        rspns.type("application/force-download");
        try {
            Path path = Paths.get("qr.png");
            byte[] data = Files.readAllBytes(path);
            raw.getOutputStream().write(data);
            raw.getOutputStream().flush();
            raw.getOutputStream().close();
        } catch (Exception e) {
            Logger.getLogger(QRGeneratorRoute.class.getName()).log(Level.SEVERE, null, e);
        }
        return raw;
    }

    
}
