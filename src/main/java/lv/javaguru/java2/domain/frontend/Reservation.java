package lv.javaguru.java2.domain.frontend;

//import java.util.Date;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.15..
 */
public class Reservation {

    private long id;
    private Date from;
    private Date till;
    private int placesCount;
    private Date timestamp;
    private boolean status;
    private List<Extra> extras;
    private Client client;
    private Room room;

    public void Reservation() {
        this.from = null;
        this.till = null;
        this.placesCount = 0;
        this.timestamp = null;
        this.status = false;
        this.extras = new LinkedList<Extra>();
        this.client = new Client();
        this.room = new Room();
    }

    public void Reservation(Date from, Date till, int placesCount, boolean status, List<Extra> extras, Client client, Room room) {
        this.from = from;
        this.till = till;
        this.placesCount = placesCount;
        this.timestamp = null;
        this.status = status;
        this.extras = extras;
        this.client = client;
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isStatus() {
        return status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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

    public Date getTill() {
        return till;
    }

    public void setTill(Date till) {
        this.till = till;
    }

    public int getPlacesCount() {
        return placesCount;
    }

    public void setPlacesCount(int placesCount) {
        this.placesCount = placesCount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }
}
