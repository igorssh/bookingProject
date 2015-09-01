package lv.javaguru.java2.core.domain.frontend;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;

    @Column(name = "from_date")
    private Date from;

    @Column(name = "till_date")
    private Date till;

    @Column(name = "person_count")
    private int personsCount;

    @Column(name = "time_stamp")
    private Timestamp timestamp;

    @Column(name = "status")
    private boolean status;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "reservations")
    //@ManyToMany(fetch = FetchType.LAZY, mappedBy = "reservations")
    private List<Extra> extras;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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

    public Reservation(Date from, Date till, int placesCount, Timestamp timestamp, boolean status, List<Extra> extras, Client client, Room room) {
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
