package lv.javaguru.java2.domain.frontend;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.14..
 */
public class Apartament {

    private long id;
    private String label;
    private String adress;
    private String desc;
  //  private List<Room>  ap_rooms;

    public void Apartament(){
        this.label = "no img";
        this.adress = "No adress data";
        this.desc = "";
     //   this.ap_rooms = new LinkedList<Room>();
    }

    public void Apartament(String lb, String adr, String dsc/*, List<Room> ap */){
       // List<Room> list = new LinkedList<Room>();
        this.label = lb;
        this.adress = adr;
        this.desc = dsc;
    //    this.ap_rooms = ap;
    }

/*
    public void setAp_rooms(List<Room> ap_rooms) {
        this.ap_rooms = ap_rooms;
    }*/

 /*   public List<Room> getAp_rooms() {
        return ap_rooms;
    }*/

    public String getDesc() {
        return desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

}
