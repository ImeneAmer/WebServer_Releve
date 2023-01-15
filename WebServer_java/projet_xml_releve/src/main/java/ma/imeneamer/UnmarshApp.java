package ma.imeneamer;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.List;

public class UnmarshApp {

    public static void main(String[] args) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(Releve.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Releve releve = (Releve) unmarshaller.unmarshal(new File("releve.xml"));
        List<Operation> operationList = releve.getOperations().getOperation();

        System.out.println(releve.toString());
        for (Operation o:operationList){

            System.out.println(o.toString());
        }


    }

    }

