package lv.javaguru.java2.core.domain.backend;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;
    
    @Column(name = "label")
    private String label;
    
    @Column(name = "desc_text", columnDefinition = "TEXT")
    private String desc;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "role")
    private List<Permission> permissions;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<User> users;

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
