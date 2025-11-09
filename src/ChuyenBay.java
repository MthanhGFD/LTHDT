package src;

import java.time.LocalDate;
import java.util.Scanner;

public class ChuyenBay {

    private String maChuyenBay, diemKhoiHanh, diemDen, ngayKhoiHanh, gioKhoiHanh, tinhTrang, maMayBay, maHangHangKhong, maSanBay;

    public ChuyenBay() {
        maChuyenBay = "";
        diemKhoiHanh = "";
        diemDen = "";
        ngayKhoiHanh = "";
        gioKhoiHanh = "";
        tinhTrang = "";
        maMayBay = "";
        maHangHangKhong = "";
        maSanBay = "";
    }

    public ChuyenBay(String maChuyenBay, String diemKhoiHanh, String diemDen, String ngayKhoiHanh, String gioKhoiHanh, String maMayBay, String maHangHangKhong, String maSanBay) {
        this.maChuyenBay = maChuyenBay;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.gioKhoiHanh = gioKhoiHanh;
        this.tinhTrang = "hoat dong";
        this.maMayBay = maMayBay;
        this.maHangHangKhong = maHangHangKhong;
        this.maSanBay = maSanBay;
    }

    public ChuyenBay(ChuyenBay cb1) {
        maChuyenBay = cb1.maChuyenBay;
        diemKhoiHanh = cb1.diemKhoiHanh;
        diemDen = cb1.diemDen;
        ngayKhoiHanh = cb1.ngayKhoiHanh;
        gioKhoiHanh = cb1.gioKhoiHanh;
        tinhTrang = cb1.tinhTrang;
        maMayBay = cb1.maMayBay;
        maHangHangKhong = cb1.maHangHangKhong;
        maSanBay = cb1.maSanBay;
    }

    private boolean ngayDung() {
        return Integer.parseInt(ngayKhoiHanh.substring(0, 2)) >= 1 && Integer.parseInt(ngayKhoiHanh.substring(0, 2)) <= 31
                && Integer.parseInt(ngayKhoiHanh.substring(3, 5)) >= 1 && Integer.parseInt(ngayKhoiHanh.substring(3, 5)) <= 12
                && Integer.parseInt(ngayKhoiHanh.substring(6)) >= 0 && Integer.parseInt(ngayKhoiHanh.substring(6)) <= LocalDate.now().getYear();
    }

    private boolean gioDung() {
        return Integer.parseInt(gioKhoiHanh.substring(0, 2)) >= 0 && Integer.parseInt(gioKhoiHanh.substring(0, 2)) <= 24
                && Integer.parseInt(gioKhoiHanh.substring(3, 5)) >= 1 && Integer.parseInt(gioKhoiHanh.substring(3, 5)) <= 59
                && Integer.parseInt(gioKhoiHanh.substring(6, 8)) >= 1 && Integer.parseInt(gioKhoiHanh.substring(6)) <= 59;
    }

    public void nhapChuyenBay() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma chuyen bay: ");
        maChuyenBay = sc.nextLine();
        System.out.print("Nhap diem khoi hanh: ");
        diemKhoiHanh = sc.nextLine();
        do {
            System.out.print("Nhap ngay khoi hanh (dd-mm-yyyy): ");
            ngayKhoiHanh = sc.nextLine();
            if (!ngayDung()) {
                System.out.println("Ngay khong hop le. Nhap lai!");
            }
        } while (!ngayDung());

        do {
            System.out.print("Nhap gio khoi hanh (HH:mm:ss): ");
            gioKhoiHanh = sc.nextLine();
            if (!gioDung()) {
                System.out.println("Gio khong hop le. Nhap lai!");
            }
        } while (!gioDung());
        System.out.print("Nhap ma may bay: ");
        maMayBay = sc.nextLine();
        System.out.print("Nhap ma hang hang khong: ");
        maHangHangKhong = sc.nextLine();
        System.out.print("Nhap ma san bay: ");
        maSanBay = sc.nextLine();

    }

    public void xuatChuyenBay() {
        String fmt = "| %-15s | %-20s | %-20s| %-12s | %-12s | %-12s | %-15s | %-15s | %-15s |\n";
        System.out.printf(fmt, maChuyenBay, diemKhoiHanh, diemDen, ngayKhoiHanh, gioKhoiHanh, tinhTrang, maMayBay, maHangHangKhong, maSanBay);
    }

    @Override
    public String toString() {
        return maChuyenBay + "," + diemKhoiHanh + "," + diemDen + "," + ngayKhoiHanh + "," + gioKhoiHanh + "," + tinhTrang + "," + maMayBay + "," + maHangHangKhong + "," + maSanBay;
    }

    
    
    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getDiemKhoiHanh() {
        return diemKhoiHanh;
    }

    public void setDiemKhoiHanh(String diemKhoiHanh) {
        this.diemKhoiHanh = diemKhoiHanh;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getGioKhoiHanh() {
        return gioKhoiHanh;
    }

    public void setGioKhoiHanh(String gioKhoiHanh) {
        this.gioKhoiHanh = gioKhoiHanh;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getMaMayBay() {
        return maMayBay;
    }

    public void setMaMayBay(String maMayBay) {
        this.maMayBay = maMayBay;
    }

    public String getMaHangHangKhong() {
        return maHangHangKhong;
    }

    public void setMaHangHangKhong(String maHangHangKhong) {
        this.maHangHangKhong = maHangHangKhong;
    }

    public String getMaSanBay() {
        return maSanBay;
    }

    public void setMaSanBay(String maSanBay) {
        this.maSanBay = maSanBay;
    }

}
