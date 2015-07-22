package lv.javaguru.java2.domain.frontend;

//import edu.booking.core.backend.PaimentListiner;

import java.util.Date;

/**
 * Created by Aleksej_home on 2015.07.15..
 */
public class Paiment {

    private long id;
    private double money;
    private String desc;
    private short pay_type;
    private Date timestamp;
    private String referent;
  //  private Klient klient;

   // private PaimentListiner listiner;

 /*   public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }
*/
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

    public short getPay_type() {
        return pay_type;
    }

    public void setPay_type(short pay_type) {
        this.pay_type = pay_type;
    }

    public String getReferent() {
        return referent;
    }

    public void setReferent(String referent) {
        this.referent = referent;
    }

   /* public void setListiner(PaimentListiner listiner) {
        this.listiner = listiner;
    }*/
}
