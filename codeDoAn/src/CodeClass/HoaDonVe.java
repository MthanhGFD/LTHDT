package CodeClass;

import java.util.Scanner;

public class HoaDonVe {

    private String mahoadon, ngaynhap;
    private int soluongve;
    private String mahanhkhach;
    private String machuyenbay;

    public HoaDonVe() {
        mahoadon = "";
        ngaynhap = "";
        soluongve = 0;
        mahanhkhach = "";
        machuyenbay = "";
    }

    public HoaDonVe(String mahoadon, String ngaynhap, int soluongve, String mahanhkhach, String machuyenbay) {
        this.mahoadon = mahoadon;
        this.ngaynhap = ngaynhap;
        this.soluongve = soluongve;
        this.mahanhkhach = mahanhkhach;
        this.machuyenbay = machuyenbay;
    }

    public HoaDonVe(HoaDonVe hd1) {
        mahoadon = hd1.mahoadon;
        ngaynhap = hd1.ngaynhap;
        soluongve = hd1.soluongve;
        mahanhkhach = hd1.mahanhkhach;
        machuyenbay = hd1.machuyenbay;
    }

    public void inputHoaDonVe() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        mahoadon = sc.nextLine();
        System.out.print("Nhap ngay nhap: ");
        ngaynhap = sc.nextLine();
        System.out.print("Nhap so luong ve: ");
        soluongve = sc.nextInt();
        sc.nextLine(); // de bo enter sau khi nhap int
        System.out.print("Nhap ma hanh khach: ");
        mahanhkhach = sc.nextLine();
        System.out.print("Nhap ma chuyen bay: ");
        machuyenbay = sc.nextLine();
    }

    public void outputHoaDonVe() {
        String fmt = "| %-12s | %-10s | %-5d | %-10s | %-15s | %-15s |%n";

        System.out.println("+--------------+------------+-------+------------+-----------------+-----------------+");
        System.out.printf(fmt, mahoadon, ngaynhap, soluongve, "Tong tien", mahanhkhach, machuyenbay);
        System.out.println("+--------------+------------+-------+------------+-----------------+-----------------+");
    }
    
//    public float tongTien(){
//        // ham tinh tong tien
//    }

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

    public String getMahanhkhach() {
        return mahanhkhach;
    }

    public void setMahanhkhach(String mahanhkhach) {
        this.mahanhkhach = mahanhkhach;
    }

    public String getMachuyenbay() {
        return machuyenbay;
    }

    public void setMachuyenbay(String machuyenbay) {
        this.machuyenbay = machuyenbay;
    }
}
