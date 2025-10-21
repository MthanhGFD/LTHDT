package src;

import java.util.Scanner;

public class HanhKhach {
    
    public static void main(String[] args) {
        HanhKhach h1 = new HanhKhach();
        h1.inputHanhKhach();
        h1.outputHanhKhach();
    }

    private String maHanhKhach, ho, ten, danhxung, cccd, sdt, loaiHanhKhach;

    public HanhKhach() {
        this.maHanhKhach = "";
        this.ho = "";
        this.ten = "";
        this.danhxung = "";
        this.cccd = "";
        this.sdt = "";
        this.loaiHanhKhach = "";
    }

    public HanhKhach(String maHanhKhach, String ho, String ten, String danhxung, String cccd, String sdt, String loaiHanhKhach) {
        this.maHanhKhach = maHanhKhach;
        this.ho = ho;
        this.ten = ten;
        this.danhxung = danhxung;
        this.cccd = cccd;
        this.sdt = sdt;
        this.loaiHanhKhach = loaiHanhKhach;
    }

    public HanhKhach(HanhKhach other) {
        this.maHanhKhach = other.maHanhKhach;
        this.ho = other.ho;
        this.ten = other.ten;
        this.danhxung = other.danhxung;
        this.cccd = other.cccd;
        this.sdt = other.sdt;
        this.loaiHanhKhach = other.loaiHanhKhach;
    }

    public void inputHanhKhach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã Hành Khách: ");
        this.maHanhKhach = scanner.nextLine();
        System.out.print("Nhập họ: ");
        this.ho = scanner.nextLine();
        System.out.print("Nhập tên: ");
        this.ten = scanner.nextLine();
        System.out.print("Nhập danh xưng: ");
        this.danhxung = scanner.nextLine();
        System.out.print("Nhập căn cước công dân: ");
        this.cccd = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.sdt = scanner.nextLine();
        System.out.print("Nhập loại Hành Khách: ");
        this.loaiHanhKhach = scanner.nextLine();
    }

    public void outputHanhKhach() {
        String fmt = "| %-15s | %-40s | %-10s | %-10s | %-15s | %-15s | %-15s |%n";
        System.out.println("+-----------------+------------------------------------------+------------+------------+-----------------+-----------------+-----------------+");
        System.out.printf(fmt, maHanhKhach, ho, ten, danhxung, cccd, sdt, loaiHanhKhach);
        System.out.println("+-----------------+------------------------------------------+------------+------------+-----------------+-----------------+-----------------+");
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

    public String getDanhxung() {
        return danhxung;
    }

    public void setDanhxung(String danhxung) {
        this.danhxung = danhxung;
    }

    public String getCCCD() {
        return cccd;
    }

    public void setCCCD(String cccd) {
        this.cccd = cccd;
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
