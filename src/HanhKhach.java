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
        System.out.print("Nhập mã Hành Khách: ");
        this.maHanhKhach = sc.nextLine();
        System.out.print("Nhập họ: ");
        this.ho = sc.nextLine();
        System.out.print("Nhập tên: ");
        this.ten = sc.nextLine();
        System.out.print("Nhập ngày sinh(dd-mm-yy): ");
        this.ngaysinh = sc.nextLine();
        System.out.print("Nhập danh xưng: ");
        this.danhxung = sc.nextLine();
        System.out.print("Nhập căn cước công dân: ");
        this.cccd = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.sdt = sc.nextLine();
        // chổ này là làm loại hành khách
        System.out.println("===================================");
    }

    public void xuatHanhKhach() {
        String fmt = "| %-15s | %-30s | %-10s | %-10s | %-10s | %-15s | %-15s | %-15s |%n";
        System.out.println("+-----------------+------------------------------------------+------------+------------+-----------------+-----------------+-----------------+");
        System.out.printf(fmt, maHanhKhach, ho, ten, ngaysinh, danhxung, cccd, sdt, loaiHanhKhach);
        System.out.println("+-----------------+------------------------------------------+------------+------------+-----------------+-----------------+-----------------+");
    }

    public int tuoi() {
        return LocalDate.now().getYear() - Integer.parseInt(ngaysinh);
    }

    @Override
    public String toString() {
        return maHanhKhach + "," + ho + "," + ten + "," + ngaysinh + "," + danhxung + "," + cccd + "," + sdt + "," + loaiHanhKhach;
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
