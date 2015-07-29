package lv.javaguru.java2.domain.frontend;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.15
 */

public class ApClass {
    private long id;
    private short classId;
    private String desc;
    private int numId;
    private List<Extra> extras;

    public void ApClass() {
        this.classId = 0;
        this.desc = "";
        this.numId = 0;
        this.extras = new LinkedList<Extra>();
    }

    public void ApClass(short classId, String desc, int numId, List<Extra> extras) {
        this.classId = classId;
        this.desc = desc;
        this.numId = numId;
        this.extras = extras;
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public short getClassId() {
        return classId;
    }

    public void setClassId(short classId) {
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
