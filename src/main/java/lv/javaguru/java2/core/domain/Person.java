package lv.javaguru.java2.core.domain;


import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
abstract public class Person implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    protected long id;

    @Column(name = "name")
    protected String name;

    @Column(name = "surname")
    protected String surname;

    @Column(name = "email")
    protected String email;

    @Column(name = "phone")
    protected String phone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
