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
    protected static ArrayList<datedesc> options = new ArrayList<datedesc>();
    private static String fileName="D:\\TU UNI\\Интернет Технологии\\Projects\\Kontrolno2IT\\src\\main\\resources\\dateoptions.xml";;

    public listofdates() {
        this.setOptions(fileName);
    }

    public ArrayList<datedesc> getOptions() {
        return options;
    }

    public void setOptions(String fileName) {
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
            e.printStackTrace();
        }
    }

}
