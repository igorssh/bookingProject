package lv.javaguru.java2.domain.frontend;

import java.util.LinkedList;
import java.util.List;
import lv.javaguru.java2.domain.Person;

/**
 * Created by Aleksej_home on 2015.07.15
 */

public class Client extends Person {
    private String name;
    private String surname;
    private long id;
    private String registryNumber;
    private String personalNumber;
    private String corp;
    private String email;
    private String phone;
    private List<Payment> payments;
    private List<Comment> comments;
    private List<Reservation> reservations;

    public void Client() {
        this.name = "";
        this.surname = "";
        this.email = "";
        this.phone = "";
        this.corp = "";
        this.personalNumber = "";
        this.registryNumber = "";
        this.payments = new LinkedList<Payment>();
        this.comments = new LinkedList<Comment>();
        this.reservations = new LinkedList<Reservation>();
    }

    public void Client(String name, String surname, String email, String phone, String corp,
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
