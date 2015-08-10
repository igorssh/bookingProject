package lv.javaguru.java2.domain.frontend;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class Reservation {

    private long id;
    private Timestamp from;
    private Timestamp till;
    private int personsCount;
    private Timestamp timestamp;
    private boolean status;
    private List<Extra> extras;
    private Client client;
    private Room room;

    public Reservation() {
        this.from = null;
        this.till = null;
        this.personsCount = 0;
        this.timestamp = null;
        this.status = false;
        this.extras = new LinkedList<Extra>();
        this.client = new Client();
        this.room = new Room();
    }

    public Reservation(Timestamp from, Timestamp till, int placesCount, Timestamp timestamp, boolean status, List<Extra> extras, Client client, Room room) {
        this.from = from;
        this.till = till;
        this.personsCount = placesCount;
        this.timestamp = timestamp;
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

    public boolean getStatus() {
        return status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getFrom() {
        return from;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getTill() {
        return till;
    }

    public void setTill(Timestamp till) {
        this.till = till;
    }

    public int getPersonsCount() {
        return personsCount;
    }

    public void setPersonsCount(int placesCount) {
        this.personsCount = placesCount;
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
