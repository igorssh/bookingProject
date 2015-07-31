package lv.javaguru.java2.domain.frontend;

//import edu.booking.core.backend.PaymentListener;

import java.util.Date;

public class Payment {

    private long id;
    private double amount;
    private String description;
    private int paymentType;
    private Date timestamp;
    private String referent;
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

    //    private PaymentListener listener;

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

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
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

/*    public void setListener(PaymentListener listener) {
        this.listener = listener;
    }*/
}
