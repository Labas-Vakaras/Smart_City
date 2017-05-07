package labasvakaras.smartcity.routes;

import java.io.IOException;

/**
 *
 * @author Vasilis Naskos
 */
public class CentralRoutesInitializer extends RoutesInitializer {

    @Override
    public void initRoutes() throws IOException {
        RoutesInitializer[] initializers = {
            new QRGeneratorRoutes(),
            new CityItemRoutes(),
            new ReportRoutes(),
            new ApiRoutes(),
            new GenericRoutes()
        };
        
        for(RoutesInitializer initializer : initializers) {
            initializer.initRoutes();
        }
    }


}
