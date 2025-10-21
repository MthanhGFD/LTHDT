package src;

public class Ghe{
    private String maghe, mamaybay, vitrighe;
    
    public Ghe(){
        maghe = "";
        mamaybay = "";
        vitrighe = "";
    }
    
    public Ghe(String maghe, String mamaybay, String vitrighe){
        this.maghe = maghe;
        this.mamaybay = mamaybay;
        this.vitrighe = vitrighe;
    }
    
    public Ghe(Ghe ghe1){
        maghe = ghe1.maghe;
        mamaybay = ghe1.mamaybay;
        vitrighe = ghe1.vitrighe;
    }

    public String getMaghe() {
        return maghe;
    }

    public void setMaghe(String maghe) {
        this.maghe = maghe;
    }

    public String getMamaybay() {
        return mamaybay;
    }

    public void setMamaybay(String mamaybay) {
        this.mamaybay = mamaybay;
    }

    public String getVitrighe() {
        return vitrighe;
    }

    public void setVitrighe(String vitrighe) {
        this.vitrighe = vitrighe;
    }
    
    
}