package lv.javaguru.java2.domain.frontend;

public class Extra {
    private long id;
    private String label;
    private String desc;
    private double cost;
    private String pic;

    public Extra() {
    }

    public Extra(String label, String desc, double cost, String pic) {
        this.label = label;
        this.desc = desc;
        this.cost = cost;
        this.pic = pic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
