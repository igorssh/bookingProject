package lv.javaguru.java2.domain.backend;

//import edu.booking.core.helpers.Person;

import java.util.Date;
import lv.javaguru.java2.domain.Person;

/**
 * Created by Aleksej_home on 2015.07.15
 */

public class User extends Person{
    private String password;
    private Date pub_date;
    private Date last_modify;
  //  private Role role;

    private void User(){
        this.name = "";
        this.surname = "";
        this.email = "";
        this.phone = "";
        this.password = "";
        this.last_modify = null;
        this.pub_date = null; // need timestamp
     //   this.role = new Role();

    }

    private void User(String nm,String snm,String em,String te,String pas, Date last/*, Role ro*/){
        this.name = nm;
        this.surname = snm;
        this.email = em;
        this.phone = te;
        this.password = pas;
        this.last_modify = last;
        this.pub_date = null; // need timestamp
      //  this.role = ro;
    }

    public Date getLast_modify() {
        return last_modify;
    }

    public void setLast_modify(Date last_modify) {
        this.last_modify = last_modify;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }



    /*  public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }*/

 /*   private String toMd5(String pas){
       // byte[] bytesOfMessage = pas.getBytes("UTF-8");
        byte[] pas_byte = pas.getBytes();
       // MessageDigest md = MessageDigest.getInstance("MD5");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(pas_byte);
        pas = thedigest.toString();
        // byte[] thedigest = md.digest(bytesOfMessage);
        return pas;
    }*/

}
