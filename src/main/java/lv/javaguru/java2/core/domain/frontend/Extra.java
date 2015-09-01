package lv.javaguru.java2.core.domain.frontend;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "extras")
public class Extra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @Column(name = "label")
    private String label;
    
    @Column(name = "desc_text", columnDefinition = "TEXT")
    private String desc;
    
    @Column(name = "cost")
    private double cost;
    
    @Column(name = "pic")
    private String pic;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "extra_reservation_relations", joinColumns = @JoinColumn(name = "extra_id",
            referencedColumnName = "id",
            columnDefinition = "int"),
            inverseJoinColumns = @JoinColumn(name = "res_id", referencedColumnName = "id", columnDefinition = "int"))
    private List<Reservation> reservations;

    public Extra() {
    }

    public Extra(String label, String desc, double cost, String pic) {
        this.label = label;
        this.desc = desc;
        this.cost = cost;
        this.pic = pic;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
