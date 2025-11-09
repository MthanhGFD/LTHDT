package src;

import java.util.Scanner;

public class Ghe{
    private String maGhe, viTriGhe, trangThai, maMayBay;
    public Ghe(){
        maGhe = "";
        viTriGhe = "";
        trangThai = "";
        maMayBay = "";
        
    }
    
    public Ghe(String maGhe, String viTriGhe, String trangThai, String maMayBay){
        this.maGhe = maGhe;
        this.trangThai = trangThai;
        this.viTriGhe = viTriGhe;
        this.maMayBay = maMayBay;
    }
    
    public Ghe(Ghe ghe1){
        maGhe = ghe1.maGhe;
        this.trangThai = ghe1.trangThai;
        viTriGhe = ghe1.viTriGhe;
        maMayBay = ghe1.maMayBay;
    }
    
    public void nhapGhe() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vi tri ghe: ");
        this.viTriGhe = sc.nextLine();
        this.trangThai = "Trong";
    }

    public void xuatGhe() {
        String fmt = "| %-15s | %-20s | %-10s | %-15s |\n";
        System.out.printf(fmt, maGhe, viTriGhe,trangThai, maMayBay );
    }

    @Override
    public String toString() {
        return  maGhe + "," + viTriGhe + "," + trangThai + "," + maMayBay;
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}