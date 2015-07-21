package lv.javaguru.java2.domain.frontend;

//import java.awt.image.DataBufferByte;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aleksej_home on 2015.07.15..
 */
public class Mordor {
    private String label;
    private String desc;
    private String logo;
    private String office;
    private String tele;
    private String reg_num;
   // private List<Apartament> apts;

    public void Mordor(){
        this.label = "";
        this.desc = "";
        this.logo = "";
        this.office = "";
        this.tele = "";
        this.reg_num = "";
      //  this.apts = new LinkedList<Apartament>();
    }
    public void Mordor(String lb,String dsc,String lo,String of,String te,String reg, List<Apartament> apt){
        this.label = lb;
        this.desc = dsc;
        this.logo = lo;
        this.office = of;
        this.tele = te;
        this.reg_num = reg;
    //    this.apts = apt;
    }

  /*  public List<Apartament> getApts() {
        return apts;
    }

    public void setApts(List<Apartament> apts) {
        this.apts = apts;
    }*/

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

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getTele() {
        return tele;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getReg_num() {
        return reg_num;
    }

    public void setReg_num(String reg_num) {
        this.reg_num = reg_num;
    }

}
