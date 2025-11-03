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

    public void nhapChuyenBay() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap diem khoi hanh: ");
        diemKhoiHanh = sc.nextLine();
        System.out.print("Nhap ngay khoi hanh(dd-mm-yy): ");
        ngayKhoiHanh = sc.nextLine();
        System.out.print("Nhap gio khoi hanh(hh:pp:ss): ");
        gioKhoiHanh = sc.nextLine();
        System.out.print("Nhap hang hang khong: ");
    }

    public void xuatChuyenBay() {
        String fmt = "| %-15s | %-15s | %-12s | %-12s | %-12s | %-15s | %-15s | %-15s |\n";
        System.out.printf(fmt, maChuyenBay, diemKhoiHanh, ngayKhoiHanh, gioKhoiHanh, tinhTrang, maMayBay, maHangHangKhong, maSanBay);
    }
    
    // ngày chuyến bay
    public int ngay(){
        return LocalDate.now().getDayOfMonth() - Integer.parseInt(ngayKhoiHanh.substring(0, 2));
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
