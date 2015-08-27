package lv.javaguru.java2.domain.frontend;

import lv.javaguru.java2.domain.Person;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "reg_num")
    private String registryNumber;
    
    @Column(name = "pers_num")
    private String personalNumber;
    
    @Column(name = "corp")
    private String corp;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "tele")
    private String phone;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "client")
    private List<Payment> payments;
    
    @Transient
    private List<Comment> comments;
    
    @Transient
    private List<Reservation> reservations;

    public Client() {
    }

    public Client(String name, String surname, String email, String phone, String corp,
                        String personalNumber, String registryNumber, List<Payment> payments,
                        List<Comment> comments, List<Reservation> reservations) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.corp = corp;
        this.personalNumber = personalNumber;
        this.registryNumber = registryNumber;
        this.payments = payments;
        this.comments = comments;
        this.reservations = reservations;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public String getCorp() {
        return corp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
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
