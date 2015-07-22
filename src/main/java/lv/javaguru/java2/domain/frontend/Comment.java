package lv.javaguru.java2.domain.frontend;

import java.util.Date;

/**
 * Created by Aleksej_home on 2015.07.15..
 */
public class Comment {
    private long id;
    private String head;
    private String desc;
    private Date timestamp;
  //  private Klient klient;



    public void Comment(){
        this.head = "";
        this.desc = "";
        this.timestamp = null;
      //  this.klient = new Klient();
    }
    public void Comment(String he,String dsc, Date tm/*, Klient kl*/){
        this.head = he;
        this.desc = dsc;
        this.timestamp = tm;
      //  this.klient = kl;
    }


 /*   public Klient getKlient() {
        return klient;
    }*/

 /*   public void setKlient(Klient klient) {
        this.klient = klient;
    }*/

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

}
