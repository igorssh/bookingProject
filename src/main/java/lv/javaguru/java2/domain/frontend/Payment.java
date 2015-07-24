package lv.javaguru.java2.domain.frontend;

//import edu.booking.core.backend.PaymentListener;

import java.util.Date;

/**
 * Created by Aleksej_home on 2015.07.15..
 */
public class Payment {

    private long id;
    private double money;
    private String desc;
    private short paymentType;
    private Date timestamp;
    private String referent;
    private Client client;

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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public short getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(short paymentType) {
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
