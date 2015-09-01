package lv.javaguru.java2.domain.frontend;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotelclasses")
public class HotelClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;

    @Column(name = "classRating")
    private int classId;

    @Column(name = "desc_text", columnDefinition = "TEXT")
    private String desc;

    @Column(name = "num_id")
    private int numId;

    @Transient
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
