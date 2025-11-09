package src;

import java.time.LocalDate;
import java.util.Scanner;

public class HanhKhach {

    private String maHanhKhach, ho, ten, ngaySinh, danhXung, cccd, sdt, loaiHanhKhach;

    public HanhKhach() {
        this.maHanhKhach = "";
        this.ho = "";
        this.ten = "";
        this.ngaySinh = "";
        this.danhXung = "";
        this.cccd = "";
        this.sdt = "";
        this.loaiHanhKhach = "";
    }

    public HanhKhach(String maHanhKhach, String ho, String ten, String ngaysinh, String danhxung, String cccd, String sdt, String loaiHanhKhach) {
        this.maHanhKhach = maHanhKhach;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaysinh;
        this.danhXung = danhxung;
        this.cccd = cccd;
        this.sdt = sdt;
        this.loaiHanhKhach = loaiHanhKhach;
    }

    public HanhKhach(HanhKhach other) {
        this.maHanhKhach = other.maHanhKhach;
        this.ho = other.ho;
        this.ten = other.ten;
        this.ngaySinh = other.ngaySinh;
        this.danhXung = other.danhXung;
        this.cccd = other.cccd;
        this.sdt = other.sdt;
        this.loaiHanhKhach = other.loaiHanhKhach;
    }

    private boolean ngayDung() {
        return Integer.parseInt(ngaySinh.substring(0, 2)) >= 1 && Integer.parseInt(ngaySinh.substring(0, 2)) <= 31
                && Integer.parseInt(ngaySinh.substring(3, 5)) >= 1 && Integer.parseInt(ngaySinh.substring(3, 5)) <= 12
                && Integer.parseInt(ngaySinh.substring(6)) >= 0 && Integer.parseInt(ngaySinh.substring(6)) <= LocalDate.now().getYear();
    }

    public void nhapHanhKhach() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho: ");
        this.ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        this.ten = sc.nextLine();
        do {
            System.out.print("Nhap ngay sinh (dd-mm-yyyy): ");
            this.ngaySinh = sc.nextLine();
            
            if (!ngayDung()) {
                System.out.println("Ngay sinh khong hop le. Vui long nhap lai!");
            }
        } while (!ngayDung());
        this.ngaySinh = sc.nextLine();
        System.out.print("Nhap danh xung (Ong/Ba): ");
        this.danhXung = sc.nextLine();
        System.out.print("Nhap can cuoc cong dan: ");
        this.cccd = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        this.sdt = sc.nextLine();
        // cho phep nhap loai hanh khach
        System.out.println("===================================");
    }

    public void xuatHanhKhach() {
        String fmt = "| %-15s | %-30s | %-10s | %-10s | %-10s | %-15s | %-15s | %-15s |\n";
        System.out.printf(fmt, maHanhKhach, ho, ten, ngaySinh, danhXung, cccd, sdt, loaiHanhKhach);
    }

    public int tuoi() {
        return LocalDate.now().getYear() - Integer.parseInt(ngaySinh);
    }

    @Override
    public String toString() {
        return maHanhKhach + "," + ho + " " + ten + "," + ngaySinh + "," + danhXung + "," + cccd + "," + sdt + "," + loaiHanhKhach;
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
        return ngaySinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaySinh = ngaysinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDanhxung() {
        return danhXung;
    }

    public void setDanhxung(String danhxung) {
        this.danhXung = danhxung;
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
