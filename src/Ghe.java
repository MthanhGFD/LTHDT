package src;

import java.util.Scanner;

public class Ghe{
    private String maGhe, viTriGhe, maMayBay;
    public Ghe(){
        maGhe = "";
        maMayBay = "";
        viTriGhe = "";
    }
    
    public Ghe(String maGhe, String maMayBay, String viTriGhe){
        this.maGhe = maGhe;
        this.maMayBay = maMayBay;
        this.viTriGhe = viTriGhe;
    }
    
    public Ghe(Ghe ghe1){
        maGhe = ghe1.maGhe;
        maMayBay = ghe1.maMayBay;
        viTriGhe = ghe1.viTriGhe;
    }
    
    public void nhapGhe() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap vi tri ghe: ");
        this.viTriGhe = sc.nextLine();
        System.out.print("Nhap ma so may bay: ");
        maMayBay = sc.nextLine();
    }

    public void xuatGhe() {
        String fmt = "| %-15s | %-20s | %-15s |\n";
        System.out.printf(fmt, maGhe, viTriGhe, maMayBay );
    }
    
    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public String getMaMayBay() {
        return maMayBay;
    }

    public void setMaMayBay(String maMayBay) {
        this.maMayBay = maMayBay;
    }

    public String getViTriGhe() {
        return viTriGhe;
    }

    public void setViTriGhe(String viTriGhe) {
        this.viTriGhe = viTriGhe;
    }
    
    
}