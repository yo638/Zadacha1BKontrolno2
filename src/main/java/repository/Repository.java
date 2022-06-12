package repository;

import model.datedesc;
import model.listofdates;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@XmlRootElement(name="groupOptions")
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository {
  //  @XmlElementWrapper(name = "optionList")

    private static Repository instance = null;
    @XmlElement(name = "option")
    private static ArrayList<datedesc> options = new ArrayList<datedesc>();

    public Repository() {
        listofdates list=new listofdates();
        options= list.getOptions();
    }
    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public static void setOptions(ArrayList<datedesc> options) {
        Repository.options = options;
    }

    public ArrayList<datedesc> getOptions() {
        return options;
    }

    public boolean contains(datedesc o) {
        return options.contains(o);
    }

    public static void add(datedesc datedesc) {
        options.add(datedesc);
        listofdates list=new listofdates();
        list.update(options);
    }

    public static boolean remove(Object o) {
        return options.remove(o);
    }

    public static boolean addAll(Collection<? extends datedesc> c) {
        return options.addAll(c);
    }
    public void addVote(datedesc o) {
        for(int i=0;i< options.size();i++){
            if(options.get(i).equals(o)) options.get(i).setVote(options.get(i).getVote()+1);
        }
        listofdates list=new listofdates();
        list.update(options);
    }
}
