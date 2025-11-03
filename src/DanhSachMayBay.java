package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachMayBay {

    private MayBay[] dsmaybay;
    private int soluong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachMayBay() {
        dsmaybay = new MayBay[0];
        soluong = 0;
    }

    public DanhSachMayBay(MayBay[] dsmaybay, int soluong) {
        this.dsmaybay = dsmaybay;
        this.soluong = soluong;
    }

    public DanhSachMayBay(DanhSachMayBay ds) {
        dsmaybay = ds.dsmaybay;
        soluong = ds.soluong;
    }

    public void nhapDS() {
        System.out.print("Nhap so luong may bay: ");
        int sl = sc.nextInt();
        sc.nextLine();
        soluong = sl;
        for (int i = 0; i < sl; i++) {
            dsmaybay = Arrays.copyOf(dsmaybay, dsmaybay.length + 1);
            dsmaybay[i] = new MayBay();
            dsmaybay[i].nhapMayBay();
            ghiFile(dsmaybay[i]);
            System.out.println("=========================================");
        }
    }

    public void xuatDS() {
        System.out.println("+-----------------+---------------------------+--------+");
        System.out.println("|   Ma may bay    |       Loai may bay        |Suc chua|");
        System.out.println("+-----------------+---------------------------+--------+");
        for (int i = 0; i < dsmaybay.length; i++) {
            dsmaybay[i].xuatMayBay();
        }
        System.out.println("+-----------------+---------------------------+--------+");
    }

    public void docFile() {
        int i = soluong;
        try {
            File f = new File("dsMayBay.txt");
            FileReader rf = new FileReader(f);
            Scanner docf = new Scanner(f);
            while (docf.hasNextLine()) {
                String line = docf.nextLine();
                String tokens[] = line.split(",");
                dsmaybay = Arrays.copyOf(dsmaybay, dsmaybay.length + 1);
                dsmaybay[i] = new MayBay();
                dsmaybay[i].setMaMayBay(tokens[0]);
                dsmaybay[i].setLoaiMayBay(tokens[1]);
                dsmaybay[i].setSucChua(Integer.parseInt(tokens[2]));
                i++;
            }
            rf.close();
            docf.close();
            soluong = i;
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi doc file!");
        }
    }

    public void ghiFile(MayBay maybay) {
        try {
            File f = new File("dsMayBay.txt");
            FileWriter ghif = new FileWriter(f, true);
            ghif.write(maybay.toString() + "\n");
            ghif.close();
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
            dsmaybay = Arrays.copyOf(dsmaybay, soluong + 1);
            dsmaybay[soluong] = new MayBay();
            dsmaybay[soluong].setMaMayBay(ma);
            dsmaybay[soluong].nhapMayBay();
            ghiFile(dsmaybay[soluong]);
            soluong++;
        } else {
            System.out.println("May bay da ton tai!");
        }
    }

    // them may bay co tham so
    public void them(String ma) {
        if (tim(ma) == null) {
            dsmaybay = Arrays.copyOf(dsmaybay, soluong + 1);
            dsmaybay[soluong] = new MayBay();
            dsmaybay[soluong].setMaMayBay(ma);
            dsmaybay[soluong].nhapMayBay();
            ghiFile(dsmaybay[soluong]);
            soluong++;
        } else {
            System.out.println("May bay da ton tai!");
        }
    }

    // xoa may bay khong tham so
    public void xoa() {
        System.out.print("Nhap ma may bay can xoa: ");
        String ma = sc.nextLine();
        xoa(ma);
    }

    // xoa may bay co tham so
    public void xoa(String ma) {
        int vt = timViTri(ma);
        if (vt != -1) {
            for (int i = vt; i < dsmaybay.length - 1; i++) {
                dsmaybay[i] = dsmaybay[i + 1];
            }
            dsmaybay = Arrays.copyOf(dsmaybay, soluong - 1);
            soluong--;
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
            System.out.println("|  1. Sua loai may bay                                      |");
            System.out.println("|  2. Sua suc chua                                          |");
            System.out.println("+-----------------------------------------------------------+");
            System.out.print("Chon thong tin muon sua: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    System.out.print("Nhap loai may bay moi: ");
                    dsmaybay[vt].setLoaiMayBay(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Nhap suc chua moi: ");
                    dsmaybay[vt].setSucChua(sc.nextInt());
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
        for (int i = 0; i < soluong; i++) {
            if (dsmaybay[i].getMaMayBay().equals(ma)) {
                return dsmaybay[i];
            }
        }
        return null;
    }

    // tim vi tri may bay
    public int timViTri(String ma) {
        for (int i = 0; i < soluong; i++) {
            if (dsmaybay[i].getMaMayBay().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    // ds theo loai may bay
    public MayBay[] dsLoaiMayBay(String loai) {
        MayBay[] ds = new MayBay[0];
        int j = 0;
        for (int i = 0; i < dsmaybay.length; i++) {
            if (dsmaybay[i].getLoaiMayBay().equals(loai)) {
                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = dsmaybay[i];
                j++;
            }
        }
        return ds;
    }

    // thong ke theo loai may bay
    public MayBay[][] thongKeLoaiMayBay() {
        String[] loai = {"Airbus A321", "Airbus A350-900", "Boeing 787-10", "Airbus A320"};
        MayBay[][] cacds = new MayBay[loai.length][];
        for (int i = 0; i < loai.length; i++) {
            cacds[i] = dsLoaiMayBay(loai[i]);
        }
        return cacds;
    }

}
