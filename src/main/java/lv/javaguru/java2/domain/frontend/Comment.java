package lv.javaguru.java2.domain.frontend;

import java.sql.Timestamp;

public class Comment {
    private long id;
    private String head;
    private String desc;
    private Timestamp timestamp;
    private Client client;

    public Comment() {
        this.head = "";
        this.desc = "";
        this.client = new Client();
    }

    public Comment(String head, String desc, Client client) {
        this.head = head;
        this.desc = desc;
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
