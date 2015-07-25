package lv.javaguru.java2.domain.frontend;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.14..
 */
public class Room {
   private long id;
   private int number;
   private int personsCount;
   private double pricePerDay;
   private String desc;
   private Date maintenance;
   private List<Thumb> thumbs;
   private List<Reservation> reservations;
   private ApClass apClass;
   private Apartment apartment;

   public void Room() {
      this.number = 0;
      this.personsCount = 0;
      this.pricePerDay = 0.0;
      this.desc = "";
      this.maintenance = null;
      this.thumbs =  new LinkedList<Thumb>();
      this.apClass = new ApClass();
      this.reservations = new LinkedList<Reservation>();
      this.apartment = new Apartment();
   }

   public void Room(int number, int placesCount, String desc, Date maintenance, double pricePerDay,
                    ApClass apClass, List<Thumb> thumbs, List<Reservation> reservations, Apartment apartment) {
      this.number = number;
      this.personsCount = placesCount;
      this.pricePerDay = pricePerDay;
      this.desc = desc;
      this.maintenance = maintenance;
      this.apClass = apClass;
      this.thumbs = thumbs;
      this.reservations = reservations;
      this.apartment = apartment;
   }

   public Apartment getApartment() {
      return apartment;
   }

   public void setApt(Apartment apartment) {
      this.apartment = apartment;
   }

   public double getPricePerDay() {
      return pricePerDay;
   }

   public void setPricePerDay(double pricePerDay) {
      this.pricePerDay = pricePerDay;
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

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public Date getTexn_repo() {
      return texn_repo;
   }

   public void setTexn_repo(Date texn_repo) {
      this.texn_repo = texn_repo;
   }

   public int getNumber() {
      return number;
   }

   public void setNumber(int number) {
      this.number = number;
   }

   public int getPlacesCount() {
      return placesCount;
   }

   public void setPlacesCount(int placesCount) {
      this.placesCount = placesCount;
   }

   public String getDesc() {
      return desc;
   }

   public void setDesc(String desc) {
      this.desc = desc;
   }

   public ApClass getApClass() {
      return apClass;
   }

   public void setApClass(ApClass apClass) {
      this.apClass = apClass;
   }
}
