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
        System.out.print("Nhap ma hoa don: ");
        mahoadon = sc.nextLine();
        System.out.print("Nhap ngay nhap: ");
        ngaynhap = sc.nextLine();
        System.out.print("Nhap so luong ve: ");
        soluongve = sc.nextInt();
        System.out.print("Nhap ma hanh khach: ");
        hanhkhach.setMaHanhKhach(sc.nextLine());
        System.out.print("Nhap ma chuyen bay: ");
        chuyenbay.setMaChuyenBay(sc.nextLine());
    }

    public void outputHoaDonVe() {
        String fmt = "| %-12s | %-10s | %-5d | %-8.3f | %-15s | %-15s |%n";

        System.out.println("+--------------+--------------+------------+------------+-----------------+");
        System.out.printf(fmt, mahoadon, ngaynhap, soluongve, "Tong tien", hanhkhach.getMaHanhKhach(), chuyenbay.getMaChuyenBay());
        System.out.println("+--------------+--------------+------------+------------+-----------------+");
    }
    
    // public float tongTien(){
        
    // }

    public String getMaHoaDon() {
        return mahoadon;
    }

    public void setMaHoaDon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getNgayNhap() {
        return ngaynhap;
    }

    public void setNgayNhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getSoLuongVe() {
        return soluongve;
    }

    public void setSoLuongVe(int soluongve) {
        this.soluongve = soluongve;
    }

    public HanhKhach getHanhKhach() {
        return hanhkhach;
    }

    public void setHanhKhach(HanhKhach hanhkhach) {
        this.hanhkhach = hanhkhach;
    }

    public ChuyenBay getChuyenBay() {
        return chuyenbay;
    }

    public void setChuyenBay(ChuyenBay chuyenbay) {
        this.chuyenbay = chuyenbay;
    }
    
    
}
