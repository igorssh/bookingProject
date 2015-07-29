package lv.javaguru.java2.domain.backend;

public class Permission {

    private long id;
    private String label;
    private String desc;
    private Role role;

    public Permission() {

    }

    public Permission(String label, String desc, Role role) {
        this.label = label;
        this.desc = desc;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public long getRoleId() {
        return role.getId();
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
}
