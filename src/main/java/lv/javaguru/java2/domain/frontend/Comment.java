package lv.javaguru.java2.domain.frontend;

import java.sql.Timestamp;

/**
 * Created by Aleksej_home on 2015.07.15
 */
public class Comment {
    private long id;
    private String head;
    private String desc;
    private Timestamp timestamp;
    private Client client;

    public void Comment() {
        this.head = "";
        this.desc = "";
        this.timestamp = null;
        this.client = new Client();
    }

    public void Comment(String head, String desc, Timestamp timestamp, Client client) {
        this.head = head;
        this.desc = desc;
        this.timestamp = timestamp;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

}
