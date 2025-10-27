
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
    
    public void inputGhe() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vị trí ghế: ");
        this.vitrighe = sc.nextLine();
        System.out.print("Nhập mã số máy bay: ");
        mamaybay = sc.nextLine();
    }

    public void outputGhe() {
        String fmt = "| %-15s | %-20s | %-20s |%\n";
        System.out.println("+-----------------+----------------------+----------------------+");
        System.out.printf(fmt, maghe, vitrighe, mamaybay );
        System.out.println("+-----------------+----------------------+----------------------+");
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