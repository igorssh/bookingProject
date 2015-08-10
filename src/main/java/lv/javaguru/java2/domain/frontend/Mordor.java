package lv.javaguru.java2.domain.frontend;

//import java.awt.image.DataBufferByte;
import java.util.LinkedList;
import java.util.List;

public class Mordor {
    private String label;
    private String desc;
    private String logo;
    private String office;
    private String phone;
    private String registryNumber;
    private List<Hotel> hotels;

    public Mordor() {
        this.label = "";
        this.desc = "";
        this.logo = "";
        this.office = "";
        this.phone = "";
        this.registryNumber = "";
        this.hotels = new LinkedList<Hotel>();
    }

    public Mordor(String label, String desc, String logo, String office, String phone,
                       String registryNumber, List<Hotel> hotels) {
        this.label = label;
        this.desc = desc;
        this.logo = logo;
        this.office = office;
        this.phone = phone;
        this.registryNumber = registryNumber;
        this.hotels = hotels;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public String getDesc() {
        return desc;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(String registryNumber) {
        this.registryNumber = registryNumber;
    }
}
