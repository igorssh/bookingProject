package lv.javaguru.java2.domain.frontend;

/**
 * Created by Aleksej_home on 2015.07.15..
 */
public class Extra {
    private long id;
    private String label;
    private String desc;
    private double cost;
    private String pic;

    public void Extra(){
        this.label = "";
        this.desc = "";
        this.cost = 0.0;
        this.pic = "";
    }
    public void Extra(String lb, String dsc,String pc, double ct){
        this.label = lb;
        this.desc = dsc;
        this.cost = ct;
        this.pic = pc;
    }

    public long getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
