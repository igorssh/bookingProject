package lv.javaguru.java2.domain.backend;

public class Role {

    private long id;
    private String label;
    private String desc;

    public Role() {
    }

    public Role(String label, String desc) {
        this.label = label;
        this.desc = desc;
    }

    public long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public String getDesc() {
        return desc;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
