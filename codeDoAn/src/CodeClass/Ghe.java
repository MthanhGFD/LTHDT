package CodeClass;

import java.util.Scanner;

public class Ghe{
    private String maghe, vitrighe, mamaybay;
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
    
    public void nhapGhe() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vi tri ghe: ");
        this.vitrighe = sc.nextLine();
        System.out.print("Nhap ma so may bay: ");
        mamaybay = sc.nextLine();
    }

    public void xuatGhe() {
        String fmt = "| %-15s | %-20s | %-20s |%\n";
        System.out.println("+-----------------+----------------------+----------------------+");
        System.out.printf(fmt, maghe, vitrighe, mamaybay );
        System.out.println("+-----------------+----------------------+----------------------+");
    }
    
    public String getMaGhe() {
        return maghe;
    }

    public void setMaGhe(String maghe) {
        this.maghe = maghe;
    }

    public String getMaMayBay() {
        return mamaybay;
    }

    public void setMaMayBay(String mamaybay) {
        this.mamaybay = mamaybay;
    }

    public String getViTriGhe() {
        return vitrighe;
    }

    public void setViTriGhe(String vitrighe) {
        this.vitrighe = vitrighe;
    }
    
    
}