package lv.javaguru.java2.domain.backend;

import lv.javaguru.java2.domain.Person;

import java.util.Date;

public class User extends Person {
    private String username;
    private String password;
    private Date lastModify;
    private Date createDate;
    private Role role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastModify() {
        return lastModify;
    }

    public void setLastModify(Date lastModify) {
        this.lastModify = lastModify;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }
    
    public long getRoleId() {
        return role.getId();
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
