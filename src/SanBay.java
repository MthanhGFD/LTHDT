package src;

import java.util.Scanner;

public class SanBay {
    private String maSanBay;
    private String tenSanBay;
    private String diaDiem;


    // Constructor không tham số
    public SanBay() {
        this.maSanBay = "";
        this.tenSanBay = "";
        this.diaDiem = "";
    }

    // Constructor có tham số
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


    public void inputSanBay() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sân bay: ");
        this.maSanBay = sc.nextLine();
        System.out.print("Nhập tên sân bay: ");
        this.tenSanBay = sc.nextLine();
        System.out.print("Nhập địa điểm (tỉnh/thành phố): ");
        this.diaDiem = sc.nextLine();
    }

    public void outputSanBay() {
        String fmt = "| %-15s | %-30s | %-25s |%n";
        System.out.println("+-----------------+--------------------------------+---------------------------+");
        System.out.printf(fmt, maSanBay, tenSanBay, diaDiem);
        System.out.println("+-----------------+--------------------------------+---------------------------+");
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
