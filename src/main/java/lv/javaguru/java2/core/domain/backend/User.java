package lv.javaguru.java2.core.domain.backend;

import lv.javaguru.java2.core.domain.Person;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User extends Person {
    
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
