package src;

import java.util.Scanner;

public class VeVIP extends Ve{
    private String phongCho, quaTang;

    public VeVIP() {
        super();
        this.phongCho = "";
        this.quaTang = "";
    }

    public VeVIP(String maVe, String maChuyenBay, String maGhe, double giaVe, String loaiVe, String phongCho, String quaTang) {
        super(maVe, maChuyenBay, maGhe, giaVe, loaiVe);
        this.phongCho = phongCho;
        this.quaTang = quaTang;
    }

    public VeVIP(VeVIP other){
        super(other);
        this.phongCho = other.phongCho;
        this.quaTang = other.quaTang;
    }

    public String getPhongCho(){return phongCho;}
    public void setPhongCho(String phongCho){this.phongCho = phongCho;}

    public String getQuaTang(){return quaTang;}
    public void setQuaTang(String quaTang){this.quaTang = quaTang;}


    @Override
    public void nhapVe(){
        super.nhapVe();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap phong cho: "); this.phongCho = sc.nextLine();
        System.out.print("Nhap qua tang: "); this.quaTang = sc.nextLine();
    }

    @Override
    public void xuatVe() {
        double tongTienVe = tinhTienVe();

        super.xuatVe();
        String fmt = "| %-15s | %-15s | %-10.0f |%n";
        System.out.printf(fmt, phongCho, quaTang, tongTienVe);
    }

    public double tinhTienVe() {
        // Neu la ve khu hoi => giam 10%
        if (getLoaiVe().equalsIgnoreCase("Khu hoi")) {
            return getGiaVe() * 2 * 0.9; 
        }
        // Neu la ve 1 chieu
        return getGiaVe();
    }

    @Override
    public String toString() {
        return super.toString() + "," + phongCho + "," + quaTang;
    }
}