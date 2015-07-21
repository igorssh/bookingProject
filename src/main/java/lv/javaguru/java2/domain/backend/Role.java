package lv.javaguru.java2.domain.backend;

/**
 * Created by Aleksej_home on 2015.07.15..
 */
import java.util.List;
import java.util.LinkedList;

public class Role {

    private long id;
    private String label;
    private String desc;
   // private List<Function> funks;

    public void Role() {
        this.label = "";
        this.desc = "";
     //   this.funks = new LinkedList<Function>();
    }

    public void Role(String label, String desc/*, List<Function> funks*/) {
        this.label = label;
        this.desc = desc;
     //   this.funks = funks;
    }

    public long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getDesc() {
        return desc;
    }

   /* public List<Function> getFunks() {
        return funks;
    }*/

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

  /*  public void setFunks(List<Function> funks) {
        this.funks = funks;
    }*/
}
