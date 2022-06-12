package model;

import jdk.internal.org.xml.sax.SAXException;
import xmlworker.XMLWorker;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Objects;

@XmlRootElement(name="groupOptions")
@XmlAccessorType(XmlAccessType.FIELD)
public class listofdates {
    @XmlElement(name = "option")
    private static ArrayList<datedesc> options = new ArrayList<datedesc>();
    private static String fileName;

    public listofdates() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(
                Objects.requireNonNull(
                                classLoader.getResource("/dateoptions.xml"))
                        .getFile());
        System.out.println(file.getAbsolutePath());
        fileName="D:\\TU UNI\\Интернет Технологии\\Projects\\Kontrolno2IT\\src\\main\\resources\\dateoptions.xml";
        //fileName = file.getAbsolutePath();
    }

    public ArrayList<datedesc> getOptions() {
        setOptions(fileName);
        return options;
    }

    private void setOptions(String fileName) {
        XMLWorker worker = new XMLWorker();
        try {
            listofdates options = worker.readerFromXmlFile(fileName);
            if (options != null) {
                this.options = options.options;
            }
        } catch (FileNotFoundException  | JAXBException e) {
            e.printStackTrace();
        }
    }

    public void update(ArrayList<datedesc> theoptions) {
        this.options= new ArrayList<>(theoptions);
        XMLWorker worker = new XMLWorker();
        try {
            worker.writeToXMLFile(fileName, this);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
