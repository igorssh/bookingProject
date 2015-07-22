package lv.javaguru.java2.domain.frontend;



import java.util.LinkedList;
import java.util.List;
import lv.javaguru.java2.domain.Person;

/**
 * Created by Aleksej_home on 2015.07.15..
 */
public class Klient extends Person{
  //  private String name;
  //  private String surname;
   // private long id;
    private String reg_num;
    private String pers_num;
    private String corp;
  //  private String email;
  //  private String tele;
 /*   private List<Paiment> paiments;
    private List<Comment> comments;
    private List<Rezervation> rez;*/

    private void Klient(){
        this.name = "";
        this.surname = "";
        this.email = "";
        this.tele = "";
        this.corp = "";
        this.pers_num = "";
        this.reg_num = "";
     /*   this.paiments = new LinkedList<Paiment>();
        this.comments = new LinkedList<Comment>();
        this.rez = new LinkedList<Rezervation>();*/
    }

    private void Klient(String nm,String snm,String em,String te,String co,String pr,String re/*, List<Paiment> pai, List<Comment> com, List<Rezervation> rezerv*/){
        this.name = nm;
        this.surname = snm;
        this.email = em;
        this.tele = te;
        this.corp = co;
        this.pers_num = pr;
        this.reg_num = re;
     /*   this.paiments = pai;
        this.comments = com;
        this.rez = rezerv;*/
    }

  /*  public List<Rezervation> getRez() {
        return rez;
    }

    public void setRez(List<Rezervation> rez) {
        this.rez = rez;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Paiment> getPaiments() {
        return paiments;
    }

    public void setPaiments(List<Paiment> paiments) {
        this.paiments = paiments;
    }*/

    public String getCorp() {
        return corp;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public String getPers_num() {
        return pers_num;
    }

    public void setPers_num(String pers_num) {
        this.pers_num = pers_num;
    }

    public String getReg_num() {
        return reg_num;
    }

    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
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
    public String getTele(){
        return tele;
    }
    public void setTele(String tele){
        this.tele = tele;
    }
}
