package lv.javaguru.java2.domain.frontend;

import java.util.List;

public class HotelClass {
    private long id;
    private int classId;
    private String desc;
    private int numId;
    private List<Extra> extras;

    public HotelClass() {
    }

    public HotelClass(int classId, String desc) {
        this.classId = classId;
        this.desc = desc;
        this.numId = 1;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
