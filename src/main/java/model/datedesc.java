package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name="option")
@XmlAccessorType(XmlAccessType.FIELD)
public class datedesc implements Comparable<datedesc>{
    private String data;
    private String description;
    private int vote;

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
    public datedesc() {
    }
    public datedesc(String data, String description) {
        this.data = data;
        this.description = description;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof datedesc)) return false;
        datedesc datedesc = (datedesc) o;
        return Objects.equals(data, datedesc.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, description);
    }

    @Override
    public int compareTo(datedesc o) {
        return 0;
    }
}
