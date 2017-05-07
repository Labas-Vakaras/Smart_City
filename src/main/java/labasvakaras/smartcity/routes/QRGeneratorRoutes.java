package labasvakaras.smartcity.routes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import labasvakaras.smartcity.qrutils.QRGenerator;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;

/**
 * Registers routes responsible for QR image production
 * 
 * @author Vasilis Naskos
 */
public class QRGeneratorRoutes extends RoutesInitializer {

    @Override
    public void initRoutes() throws IOException {
        initDefaultQrGeneratorRoute();
    }
    
    protected void initDefaultQrGeneratorRoute() {
        get(new Route("download_qr") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                HttpServletResponse raw = rspns.raw();
                rspns.header("Content-Disposition", "attachment; filename=image.png");
                rspns.type("application/force-download");
                try {
                    String id = rqst.queryParams("id");
                    QRGenerator qrGenerator = new QRGenerator(id);
                    String qrImagePath = qrGenerator.generate();

                    Path path = Paths.get(qrImagePath);
                    byte[] data = Files.readAllBytes(path);
                    raw.getOutputStream().write(data);
                    raw.getOutputStream().flush();
                    raw.getOutputStream().close();
                } catch (Exception e) {
                    Logger.getLogger(QRGeneratorRoutes.class.getName()).log(Level.SEVERE, null, e);
                }
                return raw;
            }
        });
    }
    
}
