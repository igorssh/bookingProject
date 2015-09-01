package lv.javaguru.java2.core.domain.frontend;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;
    
    @Column(name = "amount")
    private double amount;
    
    @Column(name = "desc_text", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "pay_type")
    private int paymentType;
    
    @Column(name = "referent")
    private String referent;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    public Payment() {
    }

    public Payment(double amount, String description, int paymentType, String referent, Client client) {
        this.amount = amount;
        this.description = description;
        this.paymentType = paymentType;
        this.referent = referent;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getReferent() {
        return referent;
    }

    public void setReferent(String referent) {
        this.referent = referent;
    }
}
