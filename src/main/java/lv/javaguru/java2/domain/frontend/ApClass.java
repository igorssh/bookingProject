package lv.javaguru.java2.domain.frontend;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.15..
 */
public class ApClass {
    private long id;
    private short classId;
    private String desc;
  //  private List<Extra> extras;

    public void ApClass(){
        this.classId = 0;
        this.desc = "";

    }

    public void ApClass(short in, String dsc){
        this.classId = in;
        this.desc = dsc;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}