package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachMayBay {

    private MayBay[] dsMayBay;
    private int soLuong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachMayBay() {
        dsMayBay = new MayBay[0];
        soLuong = 0;
    }

    public DanhSachMayBay(MayBay[] dsMayBay, int soLuong) {
        this.dsMayBay = dsMayBay;
        this.soLuong = soLuong;
    }

    public DanhSachMayBay(DanhSachMayBay ds) {
        dsMayBay = ds.dsMayBay;
        soLuong = ds.soLuong;
    }

    public void nhapDS() {
        System.out.print("Nhap so luong may bay: ");
        int sl = sc.nextInt();
        sc.nextLine();
        soLuong = sl;
        for (int i = 0; i < sl; i++) {
            String mamaybay;
            System.out.print("Nhap ma may bay: ");
            mamaybay = sc.nextLine();
            if (tim(mamaybay) == null) {
                dsMayBay = Arrays.copyOf(dsMayBay, dsMayBay.length + 1);
                dsMayBay[i] = new MayBay();
                dsMayBay[i].setMaMayBay(mamaybay);
                dsMayBay[i].nhapMayBay();
            } else {
                System.out.println("Ma may bay da ton tai nhap lai");
                i--;
            }
            System.out.println("=========================================");
        }
    }

    public void xuatDS() {
        System.out.println("  ================= Danh sach may bay =================");
        System.out.println("+-----------------+---------------------------+--------+");
        System.out.println("|   Ma may bay    |       Loai may bay        |Suc chua|");
        System.out.println("+-----------------+---------------------------+--------+");
        for (int i = 0; i < dsMayBay.length; i++) {
            dsMayBay[i].xuatMayBay();
        }
        System.out.println("+-----------------+---------------------------+--------+");
    }

    public void docFile() {
        int i = soLuong;
        try {
            File f = new File("dsMayBay.txt");
            FileReader rf = new FileReader(f);
            Scanner docf = new Scanner(f);
            while (docf.hasNextLine()) {
                String line = docf.nextLine();
                String tokens[] = line.split(",");
                dsMayBay = Arrays.copyOf(dsMayBay, dsMayBay.length + 1);
                dsMayBay[i] = new MayBay();
                dsMayBay[i].setMaMayBay(tokens[0]);
                dsMayBay[i].setLoaiMayBay(tokens[1]);
                dsMayBay[i].setSucChua(Integer.parseInt(tokens[2]));
                i++;
            }
            rf.close();
            docf.close();
            soLuong = i;
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi doc file!");
        }
    }

    // ghi lại danh sách mới lên file
    public void ghiFile() {
        try {
            File f = new File("dsMayBay.txt");
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < dsMayBay.length; i++) {
                fw.write(dsMayBay[i].toString() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi ghi file!");
        }
    }

    // them may bay khong tham so
    public void them() {
        System.out.print("Nhap ma may bay: ");
        String ma = sc.nextLine();
        if (tim(ma) == null) {
            dsMayBay = Arrays.copyOf(dsMayBay, soLuong + 1);
            dsMayBay[soLuong] = new MayBay();
            dsMayBay[soLuong].setMaMayBay(ma);
            dsMayBay[soLuong].nhapMayBay();
            soLuong++;
        } else {
            System.out.println("May bay da ton tai!");
        }
    }

    // them may bay co tham so
    public void them(String ma) {
        if (tim(ma) == null) {
            dsMayBay = Arrays.copyOf(dsMayBay, soLuong + 1);
            dsMayBay[soLuong] = new MayBay();
            dsMayBay[soLuong].setMaMayBay(ma);
            dsMayBay[soLuong].nhapMayBay();
            soLuong++;
        } else {
            System.out.println("May bay da ton tai!");
        }
    }

    // xoa may bay khong tham so
    public void xoa() {
        System.out.print("Nhap ma may bay can xoa: ");
        String ma = sc.nextLine();
        xoa(ma);
        ghiFile();
    }

    // xoa may bay co tham so
    public void xoa(String ma) {
        int vt = timViTri(ma);
        if (vt != -1) {
            for (int i = vt; i < dsMayBay.length - 1; i++) {
                dsMayBay[i] = dsMayBay[i + 1];
            }
            dsMayBay = Arrays.copyOf(dsMayBay, soLuong - 1);
            soLuong--;
            System.out.println("Da xoa may bay!");
        } else {
            System.out.println("Khong tim thay may bay!");
        }
    }

    // sua may bay khong tham so
    public void sua() {
        System.out.print("Nhap ma may bay can sua: ");
        String ma = sc.nextLine();
        sua(ma);
    }

    // sua may bay co tham so
    public void sua(String ma) {
        int vt = timViTri(ma);
        if (vt != -1) {
            System.out.println("+------------------- SUA THONG TIN MAY BAY -------------------+");
            System.out.println("|  1. Sua loai may bay                                        |");
            System.out.println("|  2. Sua suc chua                                            |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.print("Chon thong tin muon sua: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    System.out.print("Nhap loai may bay moi: ");
                    dsMayBay[vt].setLoaiMayBay(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Nhap suc chua moi: ");
                    dsMayBay[vt].setSucChua(sc.nextInt());
                    sc.nextLine();
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } else {
            System.out.println("Khong tim thay may bay!");
        }
    }

    // tim may bay khong tham so
    public MayBay tim() {
        System.out.print("Nhap ma may bay can tim: ");
        String ma = sc.nextLine();
        return tim(ma);
    }

    // tim may bay co tham so
    public MayBay tim(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsMayBay[i].getMaMayBay().equals(ma)) {
                return dsMayBay[i];
            }
        }
        return null;
    }

    // tim vi tri may bay
    public int timViTri(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsMayBay[i].getMaMayBay().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    // ds theo loai may bay
    public MayBay[] dsLoaiMayBay(String loai) {
        MayBay[] ds = new MayBay[0];
        int j = 0;
        for (int i = 0; i < dsMayBay.length; i++) {
            if (dsMayBay[i].getLoaiMayBay().equals(loai)) {
                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = dsMayBay[i];
                j++;
            }
        }
        return ds;
    }

    // thong ke theo loai may bay
    public MayBay[][] thongKeLoaiMayBay() {
        String[] loai = {"Airbus A321", "Airbus A350-900", "Boeing 787-10", "Airbus A320"};
        MayBay[][] tk = new MayBay[loai.length][];
        for (int i = 0; i < loai.length; i++) {
            tk[i] = dsLoaiMayBay(loai[i]);
        }
        return tk;
    }

    public MayBay[] getDsMayBay() {
        return dsMayBay;
    }

    public void setDsMayBay(MayBay[] dsMayBay) {
        this.dsMayBay = dsMayBay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
