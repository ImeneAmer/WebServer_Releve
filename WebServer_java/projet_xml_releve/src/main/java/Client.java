import proxy.Exception_Exception;
import proxy.ReleveWS;
import proxy.WebServerReleve;

public class Client {

    public static void main(String[] args) throws Exception_Exception {


        WebServerReleve stub=new ReleveWS().getWebServerRelevePort();

        System.out.println(stub.getReleve());
    }
}
