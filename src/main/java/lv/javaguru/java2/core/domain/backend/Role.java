package lv.javaguru.java2.core.domain.backend;

import java.util.List;

public class Role {

    private long id;
    private String label;
    private String desc;
    private List<Permission> permissions;

    public Role() {
    }

    public Role(String label, String desc) {
        this.label = label;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
