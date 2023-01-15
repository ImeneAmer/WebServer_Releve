package relevewsdl;

import jakarta.xml.ws.Endpoint;
import ma.imeneamer.UnmarshApp;

public class ReleveGenerateWsdl {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9191/",new WebServerReleve());
        System.out.println("web service déployé sur http://localhost:9191/");
    }

}
