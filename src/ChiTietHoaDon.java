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
        System.out.print("Nhập mã hóa đơn: ");
        mahoadon = sc.nextLine();
        System.out.print("Nhập mã Vé: ");
        ve.setMaVe(sc.nextLine());
        System.out.print("Nhập mã chuyến bay: ");
        chuyenbay.setMaChuyenBay(sc.nextLine());
        System.out.print("Nhập mã hành khách: ");
        hanhkhach.setMaHanhKhach(sc.nextLine());
        tienve = ve.getGiaVe();
    }

    public void outputChiTietHoaDon() {
        String fmt = "| %-15s | %-15s | %-15s | %-15s | %-15.2f |%n";
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf(fmt, mahoadon, ve.getMaVe(), chuyenbay.getMachuyenbay(), hanhkhach.getMaHanhKhach(), "Tiền Vé");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public Ve getVe() {
        return ve;
    }

    public void setVe(Ve ve) {
        this.ve = ve;
    }

    public ChuyenBay getChuyenbay() {
        return chuyenbay;
    }

    public void setChuyenbay(ChuyenBay chuyenbay) {
        this.chuyenbay = chuyenbay;
    }

    public HanhKhach getHanhkhach() {
        return hanhkhach;
    }

    public void setHanhkhach(HanhKhach hanhkhach) {
        this.hanhkhach = hanhkhach;
    }

    public float getTienve() {
        return tienve;
    }

    public void setTienve(float tienve) {
        this.tienve = tienve;
    }
}
