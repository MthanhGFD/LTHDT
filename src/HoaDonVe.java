package src;

import java.util.Scanner;

public class HoaDonVe {

    private String mahoadon, ngaynhap;
    private int soluongve;
    private HanhKhach hanhkhach;
    private ChuyenBay chuyenbay;

    public HoaDonVe() {
        mahoadon = "";
        ngaynhap = "";
        soluongve = 0;
        hanhkhach = new HanhKhach();
        chuyenbay = new ChuyenBay();
    }

    public HoaDonVe(String mahoadon, String ngaynhap, int soluongve, HanhKhach hanhkhach, ChuyenBay chuyenbay) {
        this.mahoadon = mahoadon;
        this.ngaynhap = ngaynhap;
        this.soluongve = soluongve;
        this.hanhkhach = hanhkhach;
        this.chuyenbay = chuyenbay;
    }

    public HoaDonVe(HoaDonVe hd1) {
        mahoadon = hd1.mahoadon;
        ngaynhap = hd1.ngaynhap;
        soluongve = hd1.soluongve;
        hanhkhach = hd1.hanhkhach;
        chuyenbay = hd1.chuyenbay;
    }

    public void inputHoaDonVe() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã hóa đơn: ");
        mahoadon = sc.nextLine();
        System.out.print("Nhập ngày nhập: ");
        ngaynhap = sc.nextLine();
        System.out.print("Nhập số lượng vé: ");
        soluongve = sc.nextInt();
        System.out.print("Nhập mã hành khách: ");
        hanhkhach.setMaHanhKhach(sc.nextLine());
        System.out.print("Nhập mà chuyến bay: ");
        chuyenbay.setMachuyenbay(sc.nextLine());
    }

    public void outputHoaDonVe() {
        String fmt = "| %-12s | %-10s | %-5d | %-8.3f | %-15s | %-15s |%n";

        System.out.println("+--------------+--------------+------------+------------+-----------------+");
        System.out.printf(fmt, mahoadon, ngaynhap, soluongve, "Tổng tiền", hanhkhach.getMaHanhKhach(), chuyenbay.getMachuyenbay());
        System.out.println("+--------------+--------------+------------+------------+-----------------+");
    }
    
    public float tongTien(){
        
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getSoluongve() {
        return soluongve;
    }

    public void setSoluongve(int soluongve) {
        this.soluongve = soluongve;
    }

    public HanhKhach getHanhkhach() {
        return hanhkhach;
    }

    public void setHanhkhach(HanhKhach hanhkhach) {
        this.hanhkhach = hanhkhach;
    }

    public ChuyenBay getChuyenbay() {
        return chuyenbay;
    }

    public void setChuyenbay(ChuyenBay chuyenbay) {
        this.chuyenbay = chuyenbay;
    }
    
    
}
