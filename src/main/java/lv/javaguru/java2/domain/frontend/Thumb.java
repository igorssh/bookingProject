package lv.javaguru.java2.domain.frontend;

/**
 * Created by Aleksej_home on 2015.07.14..
 */
    public class Thumb {

    private long id;
    private String label;
    private String desc;
    private String orig;
  //  private Room room;

    public void Thumb(){
        this.label = "";
        this.desc = "";
        this.orig = "";
     //   this.room = new Room();
    }
    public void Thumb(String la,String dsc,String or/*, Room rm*/){
        this.label = la;
        this.desc = dsc;
        this.orig = or;
     //   this.room = rm;
    }

  /*  public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }
}
