package ma.imeneamer;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Application {


    public static void main(String[] args) throws Exception {

        /* Créer une application Java qui permet de créer un Objet Releve avec quelques opérations
           et de sérialiser ces données dans un fichier XML.*/


        Operations operations = new Operations(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021"),new SimpleDateFormat("dd/MM/yyyy").parse("30/01/2021"));
        operations.getOperation().add(new Operation(TypeOperation.CREDIT,new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2021"),9000.00,"Vers Espèce"));
        operations.getOperation().add(new Operation(TypeOperation.DEBIT,new SimpleDateFormat("dd/MM/yyyy").parse("11/01/2021"),3400.00,"Ch_que Guichet"));
        operations.getOperation().add(new Operation(TypeOperation.DEBIT,new SimpleDateFormat("dd/MM/yyyy").parse("11/01/2021"),120.00,"Prélèvement Assurance"));
        operations.getOperation().add(new Operation(TypeOperation.CREDIT,new SimpleDateFormat("dd/MM/yyyy").parse("25/01/2021"),70000.00,"Virement"));

        Releve releve = new Releve("00111122223333444455556666",new SimpleDateFormat("dd/MM/yyyy").parse("10/11/2021"),14500.00,operations);
        System.out.println(releve.toString());


        //serialization
        JAXBContext jaxbContext = JAXBContext.newInstance(Releve.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(releve, new File("releve.xml"));






    }



    }

