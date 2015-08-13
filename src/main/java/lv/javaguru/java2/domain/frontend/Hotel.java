package lv.javaguru.java2.domain.frontend;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;
    
    @Column(name = "label")
    private String label;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "desc_text", columnDefinition = "TEXT")
    private String description;
    
    @Transient
    private List<Room> hotelRooms;

    public Hotel() {
    }

    public Hotel(String label, String address, String description) {
        this.label = label;
        this.address = address;
        this.description = description;
    }

    public void setHotelRooms(List<Room> hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    public List<Room> getHotelRooms() {
        return hotelRooms;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
