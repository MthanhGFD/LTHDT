package src;

import java.util.Scanner;

public class SanBay {
    private String maSanBay;
    private String tenSanBay;
    private String diaDiem;


    // Constructor khong tham so
    public SanBay() {
        this.maSanBay = "";
        this.tenSanBay = "";
        this.diaDiem = "";
    }

    // Constructor co tham so
    public SanBay(String maSanBay, String tenSanBay, String diaDiem) {
        this.maSanBay = maSanBay;
        this.tenSanBay = tenSanBay;
        this.diaDiem = diaDiem;
    }

    // Copy constructor
    public SanBay(SanBay other) {
        this.maSanBay = other.maSanBay;
        this.tenSanBay = other.tenSanBay;
        this.diaDiem = other.diaDiem;
    }


    public void nhapSanBay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten san bay: ");
        this.tenSanBay = scanner.nextLine();
        System.out.print("Nhap dia diem (tinh/ thanh pho): ");
        this.diaDiem = scanner.nextLine();
    }

    public void xuatSanBay() {
        String fmt = "| %-15s | %-30s | %-25s |\n";
        System.out.println("|-----------------|--------------------------------|---------------------------|");
        System.out.printf(fmt, maSanBay, tenSanBay, diaDiem);
        System.out.println("|-----------------|--------------------------------|---------------------------|");
    }

    @Override
    public String toString() {
        return maSanBay + "," + tenSanBay + "," + diaDiem;
    }

    

    public String getMaSanBay() {
        return maSanBay;
    }

    public void setMaSanBay(String maSanBay) {
        this.maSanBay = maSanBay;
    }

    public String getTenSanBay() {
        return tenSanBay;
    }

    public void setTenSanBay(String tenSanBay) {
        this.tenSanBay = tenSanBay;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }
}
