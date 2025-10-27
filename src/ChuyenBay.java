package src;

import java.util.Scanner;

public class ChuyenBay {

    private String machuyenbay, diemkhoihanh, diemden, ngaykhoihanh, giokhoihanh, tinhtrang;
    private MayBay maybay;
    private HangHangKhong hanghangkhong;
    private SanBay sanbay;

    public ChuyenBay() {
        machuyenbay = "";
        diemkhoihanh = "";
        diemden = "";
        ngaykhoihanh = "";
        giokhoihanh = "";
        tinhtrang = "";
        maybay = new MayBay();
        hanghangkhong = new HangHangKhong();
        sanbay = new SanBay();
    }

    public ChuyenBay(String machuyenbay, String diemkhoihanh, String diemden, String ngaykhoihanh, String giokhoihanh, MayBay maybay, HangHangKhong hanghangkhong, SanBay sanbay) {
        this.machuyenbay = machuyenbay;
        this.diemkhoihanh = diemkhoihanh;
        this.diemden = diemden;
        this.ngaykhoihanh = ngaykhoihanh;
        this.giokhoihanh = giokhoihanh;
        this.tinhtrang = "hoạt động";
        this.maybay = maybay;
        this.hanghangkhong = hanghangkhong;
        this.sanbay = sanbay;
    }

    public ChuyenBay(ChuyenBay cb1) {
        machuyenbay = cb1.machuyenbay;
        diemkhoihanh = cb1.diemkhoihanh;
        diemden = cb1.diemden;
        ngaykhoihanh = cb1.ngaykhoihanh;
        giokhoihanh = cb1.giokhoihanh;
        tinhtrang = cb1.tinhtrang;
        maybay = cb1.maybay;
        hanghangkhong = cb1.hanghangkhong;
        sanbay = cb1.sanbay;
    }

    public void nhapChuyenBay() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập điểm khởi hành: ");
        diemkhoihanh = sc.nextLine();
        System.out.print("Nhập ngày khởi hành(dd-mm-yy): ");
        ngaykhoihanh = sc.nextLine();
        System.out.print("Nhập giờ khởi hành(hh:pp:ss): ");
        giokhoihanh = sc.nextLine();
        System.out.print("Nhập mã hãng hàng không: ");
    }

    public void xuatChuyenBay() {
        String fmt = "| %-12s | %-15s | %-12s | %-10s | %-10s | %-15s | %-20s | %-10s |%n";
        System.out.println("|--------------|-----------------|--------------|------------|------------|-----------------|----------------------|------------|");
        System.out.printf(fmt, machuyenbay, diemkhoihanh, ngaykhoihanh, giokhoihanh, tinhtrang, maybay.getMaMayBay(), hanghangkhong.getMaHang(), sanbay.getMaSanBay());
        System.out.println("|--------------|-----------------|--------------|------------|------------|-----------------|----------------------|------------|");
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

    public MayBay getMayBay() {
        return maybay;
    }

    public void setMayBay(MayBay maybay) {
        this.maybay = maybay;
    }

    public HangHangKhong getHangHangKhong() {
        return hanghangkhong;
    }

    public void setHangHangKhong(HangHangKhong hanghangkhong) {
        this.hanghangkhong = hanghangkhong;
    }

    public SanBay getSanBay() {
        return sanbay;
    }

    public void setSanBay(SanBay sanbay) {
        this.sanbay = sanbay;
    }
}
