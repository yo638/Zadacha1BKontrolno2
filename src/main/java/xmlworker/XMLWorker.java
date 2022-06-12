package xmlworker;

import model.listofdates;
import repository.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XMLWorker {
    //private String xmlFile = "D:\\TU UNI\\Интернет Технологии\\Projects\\Kontrolno2IT\\src\\main\\webapp\\dateoptions.xml";
    public void writeToXMLFile(String xmlFile, listofdates list) throws JAXBException {
        // Създаване на JAXB контекст
        JAXBContext context = JAXBContext.newInstance(listofdates.class);
        // Създаване на marshaller инстанция
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // Записване в System.out
        m.marshal(list, System.out);
        // Записване във файл
        m.marshal(list, new File(xmlFile));

    }
    public listofdates readerFromXmlFile(String xmlFile) throws JAXBException, FileNotFoundException {
        // Създаване на JAXB контекст
        JAXBContext context = JAXBContext.newInstance(listofdates.class);
        // Създаване на unmarshaller инстанция
        Unmarshaller um = context.createUnmarshaller();
        listofdates list = (listofdates) um.unmarshal(new FileReader(xmlFile));
        return list;
    }
}
