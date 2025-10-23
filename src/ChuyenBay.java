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

    public ChuyenBay(String machuyenbay, String diemkhoihanh, String diemden, String ngaykhoihanh, String giokhoihanh, String tinhtrang, MayBay maybay, HangHangKhong hanghangkhong, SanBay sanbay) {
        this.machuyenbay = machuyenbay;
        this.diemkhoihanh = diemkhoihanh;
        this.diemden = diemden;
        this.ngaykhoihanh = ngaykhoihanh;
        this.giokhoihanh = giokhoihanh;
        this.tinhtrang = tinhtrang;
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

    public void inputChuyenBay() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã chuyến bay: ");
        machuyenbay = sc.nextLine();
        System.out.print("Nhập điểm khởi hành: ");
        diemkhoihanh = sc.nextLine();
        System.out.print("Nhập ngày khởi hành(dd-mm-yy): ");
        ngaykhoihanh = sc.nextLine();
        System.out.print("Nhập giờ khởi hành(hh:pp:ss): ");
        giokhoihanh = sc.nextLine();
//        System.out.print("Nhập tình trạng: ");
//        tinhtrang = sc.nextLine();
        System.out.print("Nhập mã máy bay:");
        maybay.setMaMayBay(sc.nextLine());
        System.out.print("Nhập mã hãng hàng không: ");
        hanghangkhong.setMaHang(sc.nextLine());
        System.out.print("nhập mã sân bay: ");
        sanbay.setMaSanBay(sc.nextLine());
        
    }

    public void outputChuyenBay() {
        String fmt = "| %-12s | %-15s | %-12s | %-10s | %-10s | %-15s | %-20s | %-10s |%n";
        System.out.println("+--------------+-----------------+--------------+------------+------------+-----------------+----------------------+------------+");
        System.out.printf(fmt, machuyenbay, diemkhoihanh, ngaykhoihanh, giokhoihanh, tinhtrang, maybay.getMaMayBay(), hanghangkhong.getMaHang(), sanbay.getMaSanBay());
        System.out.println("+--------------+-----------------+--------------+------------+------------+-----------------+----------------------+------------+");
    }

    public String getMachuyenbay() {
        return machuyenbay;
    }

    public void setMachuyenbay(String machuyenbay) {
        this.machuyenbay = machuyenbay;
    }

    public String getDiemkhoihanh() {
        return diemkhoihanh;
    }

    public void setDiemkhoihanh(String diemkhoihanh) {
        this.diemkhoihanh = diemkhoihanh;
    }

    public String getDiemden() {
        return diemden;
    }

    public void setDiemden(String diemden) {
        this.diemden = diemden;
    }

    public String getNgaykhoihanh() {
        return ngaykhoihanh;
    }

    public void setNgaykhoihanh(String ngaykhoihanh) {
        this.ngaykhoihanh = ngaykhoihanh;
    }

    public String getGiokhoihanh() {
        return giokhoihanh;
    }

    public void setGiokhoihanh(String giokhoihanh) {
        this.giokhoihanh = giokhoihanh;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public MayBay getMaybay() {
        return maybay;
    }

    public void setMaybay(MayBay maybay) {
        this.maybay = maybay;
    }

    public HangHangKhong getHanghangkhong() {
        return hanghangkhong;
    }

    public void setHanghangkhong(HangHangKhong hanghangkhong) {
        this.hanghangkhong = hanghangkhong;
    }

    public SanBay getSanbay() {
        return sanbay;
    }

    public void setSanbay(SanBay sanbay) {
        this.sanbay = sanbay;
    }
}
