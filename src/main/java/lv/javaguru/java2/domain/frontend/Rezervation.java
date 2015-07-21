package lv.javaguru.java2.domain.frontend;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.15..
 */
public class Rezervation {

    private long id;
    private Date from;
    private Date to;
    private int p_count;
    private Date timestamp;
    private boolean status;
   /* private List<Extra> extras;
    private Klient klient;
    private Room room;*/

    public void Rezervation(){
        this.from = null;
        this.to = null;
        this.p_count = 0;
        this.timestamp = null;
        this.status = false;
      /*  this.extras = new LinkedList<Extra>();
        this.klient = new Klient();
        this.room = new Room();*/

    }
    public void Rezervation(Date fr, Date t, int p, boolean st/*, List<Extra> ext, Klient kl, Room rm */){
        this.from = fr;
        this.to = t;
        this.p_count = p;
        this.timestamp = null;
        this.status = st;
       /* this.extras = ext;
        this.klient = kl;
        this.room = rm;*/
    }

  /*  public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }*/

    public boolean isStatus() {
        return status;
    }

    public long getId() {
        return id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public int getP_count() {
        return p_count;
    }

    public void setP_count(int p_count) {
        this.p_count = p_count;
    }

 /*   public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }*/
}
