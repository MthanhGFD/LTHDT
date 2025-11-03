package src;

import java.util.Scanner;

public class ChiTietHoaDon {

    private String maHoaDon, maVe, maChuyenBay, maHanhKhach;
    private float tienVe;

    public ChiTietHoaDon() {
        maHoaDon = "";
        maVe = "";
        maChuyenBay = "";
        maHanhKhach = "";
        tienVe = 0;
    }

    public ChiTietHoaDon(String maHoaDon, String maVe, String maChuyenBay, String maHanhKhach) {
        this.maHoaDon = maHoaDon;
        this.maVe = maVe;
        this.maChuyenBay = maChuyenBay;
        this.maHanhKhach = maHanhKhach;
    }

    public ChiTietHoaDon(ChiTietHoaDon cthd1) {
        maHoaDon = cthd1.maHoaDon;
        this.maVe = cthd1.maVe;
        this.maChuyenBay = cthd1.maChuyenBay;
        tienVe = cthd1.tienVe;
    }

    public void nhapChiTietHoaDon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        maHoaDon = sc.nextLine();
        System.out.print("Nhap ma ve: ");
        maVe = sc.nextLine();
        System.out.print("Nhap ma chuyen bay: ");
        maChuyenBay = sc.nextLine();
        System.out.print("Nhap ma hanh khach: ");
        maHanhKhach = sc.nextLine();
    }

    public void xuatChiTietHoaDon() {
        String fmt = "| %-15s | %-15s | %-15s | %-15s | %-15.2f |\n";
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf(fmt, maHoaDon, maVe, maChuyenBay, maHanhKhach);
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getHanhkhach() {
        return maHanhKhach;
    }

    public void setHanhkhach(String maHanhKhach) {
        this.maHanhKhach = maHanhKhach;
    }

    public double getTienVe() {
        return tienVe;
    }

    public void setTienVe(float tienVe) {
        this.tienVe = tienVe;
    }
}
