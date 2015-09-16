package lv.javaguru.java2.core.domain.backend;

import javax.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;
    
    @Column(name = "label")
    private String label;
    
    @Column(name = "desc_text", columnDefinition = "TEXT")
    private String desc;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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
