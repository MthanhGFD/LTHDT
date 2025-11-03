package src;

import java.util.Scanner;

public abstract class Ve {
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
    public String getMaVe() { return maVe; }
    public void setMaVe(String maVe) { this.maVe = maVe; }

    public String getChuyenBay() { return maChuyenBay; }
    public void setChuyenBay(String maChuyenBay) { this.maChuyenBay = maChuyenBay;}

    public String getGhe() { return maGhe; }
    public void setGhe(String maGhe) { this.maGhe = maGhe; }

    public double getGiaVe() { return giaVe; }
    public void setGiaVe(double giaVe) { this.giaVe = giaVe; }

    public String getPhanLoai() { return loaiVe; }
    public void setPhanLoai(String loaiVe) { this.loaiVe = loaiVe; }

    //Ham nhap
    public void nhapVe() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma ve (MV001): "); this.maVe = sc.nextLine();
        System.out.print("Nhap gia ve (VND): "); this.giaVe = sc.nextDouble();
        try {
            int choice;
            System.out.println("+-------------------- Loai Ve --------------------+");
            System.out.println("|  0. Khu hoi                                     |");
            System.out.println("|  1. 1 chieu                                     |");
            System.out.println("+-------------------------------------------------+");
            System.out.print("Chon loai ve (0: Khu hoi, 1: 1 chieu): ");
            choice = sc.nextInt();

            switch (choice) {
                case 0: this.loaiVe = "Khu hoi "; break;
                case 1: this.loaiVe = "1 chieu"; break;
            }
        } catch (Exception e) {
            this.loaiVe = "1 chieu";
        }
        sc.nextLine(); // clear buffer
    }

    public void xuatVe() {
        String fmt = "| %-15s | %-15s | %-15s | %-10f | %-3s |\n";
        System.out.printf(fmt, maVe, maChuyenBay, maGhe, giaVe, loaiVe);
    }

    public abstract double tinhTienVe();  // Moi loai ve co cach tinh khac nhau
}
