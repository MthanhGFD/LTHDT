package src;

import java.util.Scanner;

public abstract class Ve implements IVe {
    private String maVe, maChuyenBay, maGhe, loaiVe;
    private double giaVe;

    //Constructor
    public Ve() {
        maVe = "";
        maChuyenBay = "";
        maGhe = "";
        giaVe = 0;
        loaiVe = "";
    }

    public Ve(String maVe, String maChuyenBay, String maGhe, double giaVe, String loaiVe) {
        this.maVe = maVe;
        this.maChuyenBay = maChuyenBay;
        this.maGhe = maGhe;
        this.giaVe = giaVe;
        this.loaiVe = loaiVe;
    }

    public Ve(Ve other){
        this.maVe = other.maVe;
        this.maChuyenBay = other.maChuyenBay;
        this.maGhe = other.maGhe;
        this.giaVe = other.giaVe;
        this.loaiVe = other.loaiVe;
    }

    //Get Set
    @Override
    public String getMaVe() { return maVe; }
    @Override
    public void setMaVe(String maVe) { this.maVe = maVe; }

    @Override
    public String getMaChuyenBay() { return maChuyenBay; }
    @Override
    public void setMaChuyenBay(String maChuyenBay) { this.maChuyenBay = maChuyenBay;}

    @Override
    public String getMaGhe() { return maGhe; }
    @Override
    public void setMaGhe(String maGhe) { this.maGhe = maGhe; }

    public double getGiaVe() { return giaVe; }
    public void setGiaVe(double giaVe) { this.giaVe = giaVe; }

    @Override
    public String getLoaiVe() { return loaiVe; }
    @Override
    public void setLoaiVe(String loaiVe) { this.loaiVe = loaiVe; }

    //Ham nhap
    public void nhapVe() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma chuyen bay: "); this.maChuyenBay = sc.nextLine();
        System.out.print("Nhap ma ghe: "); this.maGhe = sc.nextLine();
        System.out.print("Nhap gia ve (VND): "); this.giaVe = sc.nextDouble();
        try {
            System.out.println("+-------------------- Loai Ve --------------------+");
            System.out.println("|  1. Mot Chieu                                   |");
            System.out.println("|  2. Khu Hoi                                     |");
            System.out.println("+-------------------------------------------------+");
            System.out.print("Chon loai ve (1: Mot Chieu; 2: Khu Hoi): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: this.loaiVe = "Mot Chieu"; break;
                case 2: this.loaiVe = "Khu Hoi "; break;
                default: this.loaiVe = "Mot Chieu";
            }
        } catch (Exception e) {
            this.loaiVe = "Mot Chieu";
        }
        sc.nextLine(); // clear buffer
    }

    //Ham xuat
    public void xuatVe() {
        String fmt = "| %-15s | %-15s | %-15s | %-10.0f | %-15s ";
        System.out.printf(fmt, maVe, maChuyenBay, maGhe, giaVe, loaiVe);
    }

    public abstract double tinhTienVe();  // Moi loai ve co cach tinh khac nhau
    
    @Override
    public String toString() {
        return maVe + "," + maChuyenBay + "," + maGhe + "," + giaVe + "," + loaiVe;
    }

    @Override
    public void hienThiThongTin() {
        xuatVe();
    }

    @Override
    public double tinhTongTien() {
        return tinhTienVe();
    }
}