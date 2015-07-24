package lv.javaguru.java2.domain.frontend;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.14..
 */
public class Apartment {

    private long id;
    private String label;
    private String address;
    private String desc;
    private List<Room> apRooms;

    public void Apartment() {
        this.label = "no img";
        this.address = "No address data";
        this.desc = "";
        this.apRooms = new LinkedList<Room>();
    }

    public void Apartment(String label, String address, String desc, List<Room> apRooms) {
        List<Room> list = new LinkedList<Room>();
        this.label = label;
        this.address = address;
        this.desc = desc;
        this.apRooms = apRooms;
    }

    public void setApRooms(List<Room> apRooms) {
        this.apRooms = apRooms;
    }

    public List<Room> getApRooms() {
        return apRooms;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
