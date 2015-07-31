package lv.javaguru.java2.domain.frontend;

import java.util.List;

public class Room {
    private long id;
    private int roomNumber;
    private int personCount;
    private double pricePerDay;
    private String description;
    private List<Thumb> thumbs;
    private List<Reservation> reservations;
    private HotelClass hotelClass;
    private Hotel hotel;

    public Room() {
    }

    public Room(int roomNumber, int personCount, double pricePerDay, String description, HotelClass hotelClass, Hotel hotel) {
        this.roomNumber = roomNumber;
        this.personCount = personCount;
        this.pricePerDay = pricePerDay;
        this.description = description;
        this.hotelClass = hotelClass;
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

    public HotelClass getHotelClass() {
        return hotelClass;
    }

    public void setHotelClass(HotelClass hotelClass) {
        this.hotelClass = hotelClass;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
