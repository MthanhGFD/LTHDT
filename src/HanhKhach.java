package src;

import java.time.LocalDate;
import java.util.Scanner;

public class HanhKhach {

    private String maHanhKhach, ho, ten, ngaysinh, danhxung, cccd, sdt, loaiHanhKhach;

    public HanhKhach() {
        this.maHanhKhach = "";
        this.ho = "";
        this.ten = "";
        this.ngaysinh = "";
        this.danhxung = "";
        this.cccd = "";
        this.sdt = "";
        this.loaiHanhKhach = "";
    }

    public HanhKhach(String maHanhKhach, String ho, String ten, String ngaysinh, String danhxung, String cccd, String sdt, String loaiHanhKhach) {
        this.maHanhKhach = maHanhKhach;
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.danhxung = danhxung;
        this.cccd = cccd;
        this.sdt = sdt;
        this.loaiHanhKhach = loaiHanhKhach;
    }

    public HanhKhach(HanhKhach other) {
        this.maHanhKhach = other.maHanhKhach;
        this.ho = other.ho;
        this.ten = other.ten;
        this.ngaysinh = other.ngaysinh;
        this.danhxung = other.danhxung;
        this.cccd = other.cccd;
        this.sdt = other.sdt;
        this.loaiHanhKhach = other.loaiHanhKhach;
    }

    public void nhapHanhKhach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hanh khach (HK...): ");
        this.maHanhKhach = sc.nextLine();
        System.out.print("Nhap ho: ");
        this.ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        this.ten = sc.nextLine();
        System.out.print("Nhap ngay sinh(dd-mm-yy): ");
        this.ngaysinh = sc.nextLine();
        System.out.print("Nhap danh xung (Ong/Ba): ");
        this.danhxung = sc.nextLine();
        System.out.print("Nhap can cuoc cong dan: ");
        this.cccd = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        this.sdt = sc.nextLine();
        // cho phep nhap loai hanh khach
        System.out.println("===================================");
    }

    public void xuatHanhKhach() {
        String fmt = "| %-15s | %-30s | %-10s | %-10s | %-10s | %-15s | %-15s | %-15s |\n";
        System.out.printf(fmt, maHanhKhach, ho, ten, ngaysinh, danhxung, cccd, sdt, loaiHanhKhach);
    }

    public int tuoi() {
        return LocalDate.now().getYear() - Integer.parseInt(ngaysinh);
    }

    @Override
    public String toString() {
        return maHanhKhach + "," + ho + " " + ten + "," + ngaysinh + "," + danhxung + "," + cccd + "," + sdt + "," + loaiHanhKhach;
    }

    public String getMaHanhKhach() {
        return maHanhKhach;
    }

    public void setMaHanhKhach(String maHanhKhach) {
        this.maHanhKhach = maHanhKhach;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDanhxung() {
        return danhxung;
    }

    public void setDanhxung(String danhxung) {
        this.danhxung = danhxung;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getLoaiHanhKhach() {
        return loaiHanhKhach;
    }

    public void setLoaiHanhKhach(String loaiHanhKhach) {
        this.loaiHanhKhach = loaiHanhKhach;
    }
}
