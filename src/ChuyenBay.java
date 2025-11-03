package CodeClass;

import java.time.LocalDate;
import java.util.Scanner;

public class ChuyenBay {

    private String machuyenbay, diemkhoihanh, diemden, ngaykhoihanh, giokhoihanh, tinhtrang, mamaybay, mahanghangkhong, masanbay;

    public ChuyenBay() {
        machuyenbay = "";
        diemkhoihanh = "";
        diemden = "";
        ngaykhoihanh = "";
        giokhoihanh = "";
        tinhtrang = "";
        mamaybay = "";
        mahanghangkhong = "";
        masanbay = "";
    }

    public ChuyenBay(String machuyenbay, String diemkhoihanh, String diemden, String ngaykhoihanh, String giokhoihanh, String mamaybay, String mayhanghangkhong, String masanbay) {
        this.machuyenbay = machuyenbay;
        this.diemkhoihanh = diemkhoihanh;
        this.diemden = diemden;
        this.ngaykhoihanh = ngaykhoihanh;
        this.giokhoihanh = giokhoihanh;
        this.tinhtrang = "hoat dong";
        this.mamaybay = mamaybay;
        this.mahanghangkhong = mahanghangkhong;
        this.masanbay = masanbay;
    }

    public ChuyenBay(ChuyenBay cb1) {
        machuyenbay = cb1.machuyenbay;
        diemkhoihanh = cb1.diemkhoihanh;
        diemden = cb1.diemden;
        ngaykhoihanh = cb1.ngaykhoihanh;
        giokhoihanh = cb1.giokhoihanh;
        tinhtrang = cb1.tinhtrang;
        mamaybay = cb1.mamaybay;
        mahanghangkhong = cb1.mahanghangkhong;
        masanbay = cb1.masanbay;
    }

    public void nhapChuyenBay() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap diem khoi hanh: ");
        diemkhoihanh = sc.nextLine();
        System.out.print("Nhap ngay khoi hanh(dd-mm-yy): ");
        ngaykhoihanh = sc.nextLine();
        System.out.print("Nhap gio khoi hanh(hh:pp:ss): ");
        giokhoihanh = sc.nextLine();
        System.out.print("Nhap hang hang khong: ");
    }

    public void xuatChuyenBay() {
        String fmt = "| %-15s | %-15s | %-12s | %-12s | %-12s | %-15s | %-15s | %-15s |\n";
        System.out.printf(fmt, machuyenbay, diemkhoihanh, ngaykhoihanh, giokhoihanh, tinhtrang, mamaybay, mahanghangkhong, masanbay);
    }
    
    // ngày chuyến bay
    public int ngay(){
        return LocalDate.now().getDayOfMonth() - Integer.parseInt(ngaykhoihanh.substring(0, 2));
    }

    public String getMaChuyenBay() {
        return machuyenbay;
    }

    public void setMaChuyenBay(String machuyenbay) {
        this.machuyenbay = machuyenbay;
    }

    public String getDiemKhoiHanh() {
        return diemkhoihanh;
    }

    public void setDiemKhoiHanh(String diemkhoihanh) {
        this.diemkhoihanh = diemkhoihanh;
    }

    public String getDiemDen() {
        return diemden;
    }

    public void setDiemDen(String diemden) {
        this.diemden = diemden;
    }

    public String getNgayKhoiHanh() {
        return ngaykhoihanh;
    }

    public void setNgayKhoiHanh(String ngaykhoihanh) {
        this.ngaykhoihanh = ngaykhoihanh;
    }

    public String getGioKhoiHanh() {
        return giokhoihanh;
    }

    public void setGioKhoiHanh(String giokhoihanh) {
        this.giokhoihanh = giokhoihanh;
    }

    public String getTinhTrang() {
        return tinhtrang;
    }

    public void setTinhTrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getMamaybay() {
        return mamaybay;
    }

    public void setMamaybay(String mamaybay) {
        this.mamaybay = mamaybay;
    }

    public String getMahanghangkhong() {
        return mahanghangkhong;
    }

    public void setMahanghangkhong(String mahanghangkhong) {
        this.mahanghangkhong = mahanghangkhong;
    }

    public String getMasanbay() {
        return masanbay;
    }

    public void setMasanbay(String masanbay) {
        this.masanbay = masanbay;
    }

    
}
