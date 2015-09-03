package lv.javaguru.java2.core.domain.frontend;

import javax.persistence.*;


@Entity
@Table(name = "thumbs")
public class Thumb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;

    @Column(name = "label")
    private String label;

    @Column(name = "desc_text", columnDefinition = "TEXT")
    private String desc;

    @Column(name = "orig")
    private String orig;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Room room;

    public Thumb() {
    }

    public Thumb(String label, String desc, String orig, Room room) {
        this.label = label;
        this.desc = desc;
        this.orig = orig;
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }
}
