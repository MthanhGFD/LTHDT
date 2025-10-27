package src;

import java.util.Scanner;

public class Ghe{
    private String maghe, vitrighe;
    private MayBay maybay;
    public Ghe(){
        maghe = "";
        maybay = new MayBay();
        vitrighe = "";
    }
    
    public Ghe(String maghe, MayBay maybay, String vitrighe){
        this.maghe = maghe;
        this.maybay = maybay;
        this.vitrighe = vitrighe;
    }
    
    public Ghe(Ghe ghe1){
        maghe = ghe1.maghe;
        maybay = ghe1.maybay;
        vitrighe = ghe1.vitrighe;
    }
    
    public void inputGhe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã ghế: ");
        this.maghe = scanner.nextLine();
        System.out.print("Nhập vị trí ghế: ");
        this.vitrighe = scanner.nextLine();
        System.out.print("Nhập mã số máy bay: ");
        maybay.setMaMayBay(scanner.nextLine());
    }

    public void outputGhe() {
        String fmt = "| %-15s | %-20s | %-20s |%\n";
        System.out.println("+-----------------+----------------------+----------------------+");
        System.out.printf(fmt, maghe, vitrighe, maybay.getMaMayBay() );
        System.out.println("+-----------------+----------------------+----------------------+");
    }
    
    public String getMaghe() {
        return maghe;
    }

    public void setMaghe(String maghe) {
        this.maghe = maghe;
    }

    public MayBay getMaybay() {
        return maybay;
    }

    public void setMaybay(MayBay maybay) {
        this.maybay = maybay;
    }

    public String getVitrighe() {
        return vitrighe;
    }

    public void setVitrighe(String vitrighe) {
        this.vitrighe = vitrighe;
    }
    
    
}