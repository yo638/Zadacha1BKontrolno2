package repository;

import model.datedesc;
import model.listofdates;

import java.util.ArrayList;
import java.util.Collection;

public class Repository extends listofdates{

    private static Repository instance = null;
    //private static listofdates varListdate;

    public Repository() {
        super();
    }
    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    //public static void setOptions(ArrayList<datedesc> options) {Repository.options = options;}

    public ArrayList<datedesc> getOptions() { return options;}

    public boolean contains(datedesc o) {
        return options.contains(o);
    }

    public void add(datedesc datedesc) {
        options.add(datedesc);
        update(options);
    }

    public static boolean remove(Object o) {
        return options.remove(o);
    }

    public boolean addAll(Collection<? extends datedesc> c) {
        return options.addAll(c);
    }
    public void addVote(datedesc o) {
        for(int i=0;i< options.size();i++){
            if(options.get(i).equals(o)) options.get(i).setVote(options.get(i).getVote()+1);
        }
        update(options);
    }
}
