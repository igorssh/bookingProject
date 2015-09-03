package lv.javaguru.java2.core.domain.frontend;


//import lv.javaguru.java2.core.Services.DBBehaviorImpl;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;

    @Column(name = "room_number")
    private int roomNumber;

    @Column(name = "person_count")
    private int personCount;

    @Column(name = "price_per_day")
    private double pricePerDay;

    @Column(name = "description_text", columnDefinition = "TEXT")
    private String description;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "room")
    private List<Thumb> thumbs;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "room")
    private List<Reservation> reservations;
    
    @ManyToOne(optional = false)
    private RoomClass roomClass;

    @ManyToOne(optional = false)
    private Hotel hotel;

    public Room() {
    }

    public Room(int roomNumber, int personCount, double pricePerDay, String description, RoomClass roomClass, Hotel hotel) {
        this.roomNumber = roomNumber;
        this.personCount = personCount;
        this.pricePerDay = pricePerDay;
        this.description = description;
        this.roomClass = roomClass;
        this.hotel = hotel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPersonCount() {
        return personCount;
    }

    public void setPersonCount(int personCount) {
        this.personCount = personCount;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Thumb> getThumbs() {
        return thumbs;
    }

    public void setThumbs(List<Thumb> thumbs) {
        this.thumbs = thumbs;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public RoomClass getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(RoomClass roomClass) {
        this.roomClass = roomClass;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
