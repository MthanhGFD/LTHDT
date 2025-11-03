package CodeClass;

import java.util.Scanner;

public abstract class Ve {
    private String mave;
    private ChuyenBay machuyenbay;
    private Ghe maghe;
    private double giave;
    private boolean phanloai; // true = 1 chiều, false = khứ hồi

    //Constructor
    public Ve() {
        mave = "";
        machuyenbay = new ChuyenBay();
        maghe = new Ghe();
        giave = 0;
        phanloai = true;
    }

    public Ve(String mave, ChuyenBay machuyenbay, Ghe maghe, double giave, boolean phanloai) {
        this.mave = mave;
        this.machuyenbay = machuyenbay;
        this.maghe = maghe;
        this.giave = giave;
        this.phanloai = phanloai;
    }

    //Get Set
    public String getMaVe() { return mave; }
    public void setMaVe(String mave) { this.mave = mave; }

    public ChuyenBay getChuyenBay() { return machuyenbay; }
    public void setChuyenBay(ChuyenBay machuyenbay) { this.machuyenbay = machuyenbay; }

    public Ghe getGhe() { return maghe; }
    public void setGhe(Ghe maghe) { this.maghe = maghe; }

    public double getGiaVe() { return giave; }
    public void setGiaVe(double giave) { this.giave = giave; }

    public boolean isPhanLoai() { return phanloai; }
    public void setPhanLoai(boolean phanloai) { this.phanloai = phanloai; }

    //Ham nhap
    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ma ve: ");
        this.mave = sc.nextLine();
        System.out.print("Nhap gia ve: ");
        this.giave = sc.nextInt();
        System.out.print("Nhap loai ve (1: 1 chieu, 0: khu hoi): ");
        this.phanloai = sc.nextInt() == 1;
        sc.nextLine(); // clear buffer
    }

    public void xuatThongTin() {
        System.out.println("Ma ve: " + mave);
        System.out.println("Gia ve: " + giave);
        System.out.println("Loai ve: " + (phanloai ? "1 chieu" : "Khu hoi"));
    }

    public abstract double tinhTien();  // Moi loai ve co cach tinh khac nhau
}
