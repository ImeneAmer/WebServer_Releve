package relevewsdl;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlTransient;
import ma.imeneamer.Releve;

import java.io.File;

@WebService(serviceName = "releveWS")

public class WebServerReleve {


        @WebMethod
        @XmlTransient
        public Releve getReleve() throws Exception {


            JAXBContext jaxbContext = JAXBContext.newInstance(Releve.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Releve releve = (Releve) unmarshaller.unmarshal(new File("releve.xml"));


            return releve;

        }
    }

