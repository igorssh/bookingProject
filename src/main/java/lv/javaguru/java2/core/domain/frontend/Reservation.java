package lv.javaguru.java2.core.domain.frontend;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;

    @Column(name = "from_date", columnDefinition = "DATE")
    private Date from;

    @Column(name = "till_date", columnDefinition = "DATE")
    private Date till;

    @Column(name = "person_count")
    private int personsCount;

    @Column(name = "status")
    private boolean status;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "reservations")
    private List<Extra> extras;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Room room;

    public Reservation() {
    }

    public Reservation(LocalDate from, LocalDate till, int placesCount, boolean status, List<Extra> extras, Client client, Room room) {
        this.from = Date.valueOf(from);
        this.till = Date.valueOf(till);
        this.personsCount = placesCount;
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

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getFrom() {
        return from.toLocalDate();
    }

    public void setFrom(LocalDate from) {
        this.from = Date.valueOf(from);
    }

    public LocalDate getTill() {
        return till.toLocalDate();
    }

    public void setTill(LocalDate till) {
        this.till = Date.valueOf(till);
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
