package lv.javaguru.java2.domain.frontend;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "int")
    private long id;
    
    @Column(name = "head")
    private String head;
    
    @Column(name = "desc_text", columnDefinition = "TEXT")
    private String description;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;

    public Comment() {
    }

    public Comment(String head, String description, Client client) {
        this.head = head;
        this.description = description;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

}
