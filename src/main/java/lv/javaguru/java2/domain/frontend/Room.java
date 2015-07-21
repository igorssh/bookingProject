package lv.javaguru.java2.domain.frontend;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.14..
 */
public class Room {

   private long id;
   private int num;
   private int pcount;
   private double price_per_day;
   private String desc;
   private Date texn_repo;
   private List<Thumb> thumbs;
   private List<Rezervation> rezs;
   private ApClass aclass;
   private Apartament apt;

   public void Room(){
      this.num = 0;
      this.pcount = 0;
      this.price_per_day = 0.0;
      this.desc = "";
      this.texn_repo = null;
      this.thumbs =  new LinkedList<Thumb>();
      this.aclass = new ApClass();
      this.rezs = new LinkedList<Rezervation>();
      this.apt = new Apartament();
   }
   public void Room(int n, int p, String dsc, Date dt, ApClass ac, List<Thumb> thbs, List<Rezervation> rzs, double ppd, Apartament ap ){
      this.num = n;
      this.pcount = p;
      this.price_per_day = ppd;
      this.desc = dsc;
      this.texn_repo = dt;
      this.aclass = ac;
      this.thumbs = thbs;
      this.rezs = rzs;
      this.apt = ap;
   }

   public Apartament getApt() {
      return apt;
   }

   public void setApt(Apartament apt) {
      this.apt = apt;
   }

   public double getPrice_per_day() {
      return price_per_day;
   }

   public void setPrice_per_day(double price_per_day) {
      this.price_per_day = price_per_day;
   }

   public List<Thumb> getThumbs() {
      return thumbs;
   }

   public void setThumbs(List<Thumb> thumbs) {
      this.thumbs = thumbs;
   }

   public List<Rezervation> getRezs() {
      return rezs;
   }

   public void setRezs(List<Rezervation> rezs) {
      this.rezs = rezs;
   }

   public long getId() {
      return id;
   }

   public Date getTexn_repo() {
      return texn_repo;
   }

   public void setTexn_repo(Date texn_repo) {
      this.texn_repo = texn_repo;
   }

   public int getNum() {
      return num;
   }

   public void setNum(int num) {
      this.num = num;
   }

   public int getPcount() {
      return pcount;
   }

   public void setPcount(int pcount) {
      this.pcount = pcount;
   }

   public String getDesc() {
      return desc;
   }

   public void setDesc(String desc) {
      this.desc = desc;
   }

   public ApClass getAclass() {
      return aclass;
   }

   public void setAclass(ApClass aclass) {
      this.aclass = aclass;
   }
}
