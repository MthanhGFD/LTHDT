package src;

import java.util.Scanner;

public class ChiTietHoaDon {

    private String mahoadon;
    private Ve ve;
    private ChuyenBay chuyenbay;
    private HanhKhach hanhkhach;
    private float tienve;

    public ChiTietHoaDon() {
        mahoadon = "";
        ve = new Ve();
        chuyenbay = new ChuyenBay();
        hanhkhach = new HanhKhach();
        tienve = 0;
    }

    public ChiTietHoaDon(String mahoadon, Ve ve, ChuyenBay chuyenbay, HanhKhach hanhkhach) {
        this.mahoadon = mahoadon;
        this.ve = ve;
        this.chuyenbay = chuyenbay;
        this.hanhkhach = hanhkhach;
        this.tienve = ve.getGiaVe();
    }

    public ChiTietHoaDon(ChiTietHoaDon cthd1) {
        mahoadon = cthd1.mahoadon;
        ve = cthd1.ve;
        chuyenbay = cthd1.chuyenbay;
        hanhkhach = cthd1.hanhkhach;
        tienve = cthd1.tienve;
    }

    public void inputChiTietHoaDon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        mahoadon = sc.nextLine();
        System.out.print("Nhap ma ve: ");
        ve.setMaVe(sc.nextLine());
        System.out.print("Nhap ma chuyen bay: ");
        chuyenbay.setMaChuyenBay(sc.nextLine());
        System.out.print("Nhap ma hanh khach: ");
        hanhkhach.setMaHanhKhach(sc.nextLine());
        tienve = ve.getGiaVe();
    }

    public void outputChiTietHoaDon() {
        String fmt = "| %-15s | %-15s | %-15s | %-15s | %-15.2f |%n";
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf(fmt, mahoadon, ve.getMaVe(), chuyenbay.getMaChuyenBay(), hanhkhach.getMaHanhKhach(), "Tiền Vé");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
    }

    public String getMaHoaDon() {
        return mahoadon;
    }

    public void setMaHoaDon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public Ve getVe() {
        return ve;
    }

    public void setVe(Ve ve) {
        this.ve = ve;
    }

    public ChuyenBay getChuyenBay() {
        return chuyenbay;
    }

    public void setChuyenBay(ChuyenBay chuyenbay) {
        this.chuyenbay = chuyenbay;
    }

    public HanhKhach getHanhKhach() {
        return hanhkhach;
    }

    public void setHanhKhach(HanhKhach hanhkhach) {
        this.hanhkhach = hanhkhach;
    }

    public float getTienVe() {
        return tienve;
    }

    public void setTienVe(float tienve) {
        this.tienve = tienve;
    }
}
