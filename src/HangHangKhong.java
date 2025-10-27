package src;

import java.util.Scanner;

public class HangHangKhong {
    private String maHang;          // Mã hãng (PK)
    private String tenHang;         // Tên hãng hàng không
    private String quocGia;         // Quốc gia


    // Constructor không tham số
    public HangHangKhong() {
        this.maHang = "";
        this.tenHang = "";
        this.quocGia = "";
    }

    // Constructor có tham số
    public HangHangKhong(String maHang, String tenHang, String quocGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.quocGia = quocGia;
    }

    // Copy constructor
    public HangHangKhong(HangHangKhong other) {
        this.maHang = other.maHang;
        this.tenHang = other.tenHang;
        this.quocGia = other.quocGia;
    }


    public void inputHangHangKhong() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã hãng hàng không: ");
        this.maHang = sc.nextLine();
        System.out.print("Nhập tên hãng hàng không: ");
        this.tenHang = sc.nextLine();
        System.out.print("Nhập quốc gia: ");
        this.quocGia = sc.nextLine();
    }

    public void outputHangHangKhong() {
        String fmt = "| %-15s | %-35s | %-25s |%n";
        System.out.println("+-----------------+-------------------------------------+---------------------------+");
        System.out.printf(fmt, maHang, tenHang, quocGia);
        System.out.println("+-----------------+-------------------------------------+---------------------------+");
    }


    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }
}
