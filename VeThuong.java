package src;

import java.util.Scanner;

public class VeThuong extends Ve {
    private double phiHanhLy, phiDichVu;

    public VeThuong() {
        super();
        this.phiHanhLy = 0;
        this.phiDichVu = 0;
    }

    public VeThuong(String maVe, String maChuyenBay, String maGhe, double giaVe, String loaiVe, double phiHanhLy, double phiDichVu) {
        super(maVe, maChuyenBay, maGhe, giaVe, loaiVe);
        this.phiHanhLy = phiHanhLy;
        this.phiDichVu = phiDichVu;
    }

    public VeThuong(VeThuong other){
        this.phiHanhLy = other.phiHanhLy;
        this.phiDichVu = other.phiDichVu;
    }

    public double getPhiHanhLy(){return phiHanhLy;}
    public void setPhiHanhLy(double phiHanhLy){this.phiHanhLy = phiHanhLy;}

    public double getPhiDichVu(){return phiDichVu;}
    public void setPhiDichVu(double phiDichVu){this.phiDichVu = phiDichVu;}

    @Override
    public void nhapVe(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap phi hanh ly: "); this.phiHanhLy = sc.nextDouble();
        System.out.print("Nhap phi dich vu: "); this.phiDichVu = sc.nextDouble();
        sc.nextLine(); // clear buffer        
    }

    @Override
    public void xuatVe() {
        System.out.println("\n\t\t\t=== VE THUONG ===");
        double tongTienVe = tinhTienVe();
        super.xuatVe();
        String fmt = "| %-10f | %-10f | %-10f |%n";
        System.out.println("+------------+------------+------------+");
        System.out.printf(fmt, phiHanhLy, phiDichVu, tongTienVe);
        System.out.println("+------------+------------+------------+");
    }

    @Override
    public double tinhTienVe() {
        // Neu la ve khu hoi => giam 10%
        if (getLoaiVe().equalsIgnoreCase("Khu hoi")) {
            return getGiaVe() * 2 * 0.9; 
        }
        // Neu la ve 1 chieu
        return getGiaVe();
    }
}