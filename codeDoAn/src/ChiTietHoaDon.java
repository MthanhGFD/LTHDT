
import java.util.Scanner;

public class ChiTietHoaDon {

    private String mahoadon, mave, machuyenbay, mahanhkhach;
    private float tienve;

    public ChiTietHoaDon() {
        mahoadon = "";
        mave = "";
        machuyenbay = "";
        mahanhkhach = "";
        tienve = 0;
    }

    public ChiTietHoaDon(String mahoadon, String mave, String machuyenbay, String mahanhkhach) {
        this.mahoadon = mahoadon;
        this.mave = mave;
        this.machuyenbay = machuyenbay;
        this.mahanhkhach = mahanhkhach;
    }

    public ChiTietHoaDon(ChiTietHoaDon cthd1) {
        mahoadon = cthd1.mahoadon;
        this.mave = cthd1.mave;
        this.machuyenbay = cthd1.machuyenbay;
        tienve = cthd1.tienve;
    }

    public void inputChiTietHoaDon() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã hóa đơn: ");
        mahoadon = sc.nextLine();
        System.out.print("Nhập mã Vé: ");
        mave = sc.nextLine();
        System.out.print("Nhập mã chuyến bay: ");
        machuyenbay = sc.nextLine();
        System.out.print("Nhập mã hành khách: ");
        mahanhkhach = sc.nextLine();
    }

    public void outputChiTietHoaDon() {
        String fmt = "| %-15s | %-15s | %-15s | %-15s | %-15.2f |%n";
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
        System.out.printf(fmt, mahoadon, mave, machuyenbay, mahanhkhach, "Tiền Vé");
        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getMaVe() {
        return mave;
    }

    public void setMaVe(String mave) {
        this.mave = mave;
    }

    public String getMaChuyenbay() {
        return machuyenbay;
    }

    public void setMaChuyenbay(String machuyenbay) {
        this.machuyenbay = machuyenbay;
    }

    public String getHanhkhach() {
        return mahanhkhach;
    }

    public void setHanhkhach(String mahanhkhach) {
        this.mahanhkhach = mahanhkhach;
    }

    public float getTienve() {
        return tienve;
    }

    public void setTienve(float tienve) {
        this.tienve = tienve;
    }
}
