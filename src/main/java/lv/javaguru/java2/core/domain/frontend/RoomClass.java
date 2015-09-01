package lv.javaguru.java2.core.domain.frontend;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "roomclasses")
public class RoomClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;

    @Column(name = "class_id", columnDefinition = "tinyint")
    private byte classId;

    @Column(name = "class_name")
    private String className;

    @Column(name = "desc_text", columnDefinition = "TEXT")
    private String desc;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "roomClass")
    private List<Room> rooms;

    public RoomClass() {
    }

    public RoomClass(byte classId, String desc, String className) {
        this.classId = classId;
        this.desc = desc;
        this.className = className;
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

    public void setClassId(byte classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

}
