package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class DanhSachHanhKhach {

    public static void main(String[] args) {
        DanhSachHanhKhach dshk = new DanhSachHanhKhach();
        dshk.docFile();
        dshk.xuatDS();
    }
    private HanhKhach dsHanhKhach[];
    private int soLuong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachHanhKhach() {
        dsHanhKhach = new HanhKhach[0];
        soLuong = 0;
    }

    public DanhSachHanhKhach(HanhKhach[] dsHanhKhach, int soLuong) {
        this.dsHanhKhach = dsHanhKhach;
        this.soLuong = soLuong;
    }

    public DanhSachHanhKhach(DanhSachHanhKhach ds) {
        dsHanhKhach = ds.dsHanhKhach;
        soLuong = ds.soLuong;
    }

    public void nhapDS() {
        int sl;
        System.out.print("Nhap so luong hanh khach: ");
        sl = sc.nextInt();
        soLuong = sl;
        sc.nextLine(); // đọc bỏ dấu xuống dòng
        for (int i = 0; i < sl; i++) {
            String ma;
            System.out.print("Nhap ma hanh khach: ");
            ma = sc.nextLine();
            if (tim(ma) == null) {
                dsHanhKhach = Arrays.copyOf(dsHanhKhach, i + 1);
                dsHanhKhach[i] = new HanhKhach();
                dsHanhKhach[i].setMaHanhKhach(ma);
                dsHanhKhach[i].nhapHanhKhach();
            } else {
                i--;
            }
        }
    }

    public void xuatDS() {
        System.out.println("                                ==================== Danh Sach Hanh Khach ==================== ");
        System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
        System.out.println("|  Ma Hanh Khach  |                Ho              |    Ten     |  Ngay Sinh | Danh Xung  |   So Can Cuoc   |  So Dien Thoai  | Loai Hanh Khach |");
        System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
        for (int i = 0; i < dsHanhKhach.length; i++) {
            dsHanhKhach[i].xuatHanhKhach();
        }
        System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
    }

    public void docFile() {
        int i = soLuong;
        try {
            FileReader f = new FileReader("dsHanhKhach.txt");
            Scanner doc = new Scanner(f);
            while (doc.hasNextLine()) { // doc tung dong
                String line = doc.nextLine();
                String[] tokens = line.split(",");
                dsHanhKhach = Arrays.copyOf(dsHanhKhach, dsHanhKhach.length + 1);
                dsHanhKhach[i] = new HanhKhach();
                dsHanhKhach[i].setMaHanhKhach(tokens[0]);
                String ho, ten;
                ten = tokens[1].substring(tokens[1].lastIndexOf(" ") + 1);
                ho = tokens[1].substring(0, tokens[1].length() - ten.length());
                dsHanhKhach[i].setHo(ho);
                dsHanhKhach[i].setTen(ten);
                dsHanhKhach[i].setNgaysinh(tokens[2]);
                dsHanhKhach[i].setDanhxung(tokens[3]);
                dsHanhKhach[i].setCccd(tokens[4]);
                dsHanhKhach[i].setSdt(tokens[5]);
                dsHanhKhach[i].setLoaiHanhKhach(tokens[6]);
                i++;
            }
            soLuong = i;
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi khi doc file!");
        }
    }

    public void ghiFile() {
        try {
            File f = new File("dsHanhKhach.txt");
            FileWriter writef = new FileWriter(f);
            for (int i = 0; i < dsHanhKhach.length; i++) {
                writef.write(dsHanhKhach[i].toString() + "\n");
            }
            writef.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (IOException e) {
            System.out.println("Loi Doc File");
        }
    }

    public void them() {
        String ma;
        System.out.print("Nhap ma hanh khach: ");
        ma = sc.nextLine();
        if (tim(ma) == null) {
            dsHanhKhach = Arrays.copyOf(dsHanhKhach, soLuong + 1);
            dsHanhKhach[soLuong] = new HanhKhach();
            dsHanhKhach[soLuong].setMaHanhKhach(ma);
            dsHanhKhach[soLuong].nhapHanhKhach();
            soLuong++;
        } else {
            System.out.println("LOI, trung ma hanh khach!!!");
        }
    }

    public void them(HanhKhach hanhkhach) {
        dsHanhKhach = Arrays.copyOf(dsHanhKhach, soLuong + 1);
        dsHanhKhach[soLuong] = new HanhKhach();
        dsHanhKhach[soLuong] = hanhkhach;
        soLuong++;
    }

    public void xoa(String maHanhKhach) {
        int vitrixoa = timViTri(maHanhKhach);
        if (vitrixoa != -1) {
            for (int i = vitrixoa; i < dsHanhKhach.length - 1; i++) {
                dsHanhKhach[i] = dsHanhKhach[i + 1];
            }
            dsHanhKhach = Arrays.copyOf(dsHanhKhach, soLuong - 1);
            soLuong--;
        } else {
            System.out.print("khong tim thay hanh khach can xoa!!!");
        }
    }

    public void xoa() {
        String maHanhKhach;
        maHanhKhach = sc.nextLine();
        int vitrixoa = timViTri(maHanhKhach);
        if (vitrixoa != -1) {
            for (int i = vitrixoa; i < dsHanhKhach.length - 1; i++) {
                dsHanhKhach[i] = dsHanhKhach[i + 1];
            }
            dsHanhKhach = Arrays.copyOf(dsHanhKhach, soLuong - 1);
            soLuong--;
        } else {
            System.out.print("khong tim thay hanh khach can xoa!!!");
        }
    }

    public void sua() {
        String maHanhKhach;
        maHanhKhach = sc.nextLine();
        int vitri = timViTri(maHanhKhach);
        if (vitri != -1) {
            String choice;
            System.out.println("+-------------------SUA THONG TIN HANH KHACH------------------+");
            System.out.println("|  1. Sua ho                                                 |");
            System.out.println("|  2. Sua ten                                                |");
            System.out.println("|  3. Sua so dien thoai                                      |");
            System.out.println("|  4. Sua loai hanh khach                                     |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.print("Chon thong tin muon sua: ");
            choice = sc.next();
            sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Moi nhap ho muon sua: ");
                    dsHanhKhach[vitri].setHo(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Moi nhap ten muon sua: ");
                    dsHanhKhach[vitri].setTen(sc.nextLine());
                    break;
                case "3":
                    System.out.print("Moi nhap so dien thoai muon sua: ");
                    dsHanhKhach[vitri].setSdt(sc.nextLine());
                    break;
                case "4":
                    System.out.print("Moi nhap loai hanh khach muon sua: ");
                    dsHanhKhach[vitri].setLoaiHanhKhach(sc.nextLine());
                    break;
            }
        } else {
            System.out.println("Khong tim thay hanh khach muon sua");
        }
    }

    public void sua(String maHanhKhach) {
        int vitri = timViTri(maHanhKhach);
        if (vitri != -1) {
            String choice;
            System.out.println("+-------------------SUA THONG TIN HANH KHACH------------------+");
            System.out.println("|  1. Sua ho                                                 |");
            System.out.println("|  2. Sua ten                                                |");
            System.out.println("|  3. Sua so dien thoai                                      |");
            System.out.println("|  4. Sua loai hanh khach                                     |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.print("Chon thong tin muon sua: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Moi nhap ho muon sua: ");
                    dsHanhKhach[vitri].setHo(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Moi nhap ten muon sua: ");
                    dsHanhKhach[vitri].setTen(sc.nextLine());
                    break;
                case "3":
                    System.out.print("Moi nhap so dien thoai muon sua: ");
                    dsHanhKhach[vitri].setSdt(sc.nextLine());
                    break;
                case "4":
                    System.out.print("Moi nhap loai hanh khach muon sua: ");
                    dsHanhKhach[vitri].setLoaiHanhKhach(sc.nextLine());
                    break;
            }
        } else {
            System.out.println("Khong tim thay hanh khach muon sua");
        }
    }

    public HanhKhach tim(String ma) {
        for (int i = 0; i < dsHanhKhach.length; i++) {
            if (dsHanhKhach[i].getMaHanhKhach().equals(ma)) {
                return dsHanhKhach[i];
            }
        }
        return null;
    }

    public HanhKhach tim() {
        String ma;
        System.out.print("Nhap ma hanh khach can tim: ");
        ma = sc.nextLine();
        for (int i = 0; i < dsHanhKhach.length; i++) {
            if (dsHanhKhach[i].getMaHanhKhach().equals(ma)) {
                return dsHanhKhach[i];
            }
        }
        return null;
    }

    public int timViTri(String ma) {
        for (int i = 0; i < dsHanhKhach.length; i++) {
            if (dsHanhKhach[i].getMaHanhKhach().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    public HanhKhach[] timTen(String ten) {
        HanhKhach[] dsTen = new HanhKhach[0];
        int j = 0;
        for (int i = 0; i < dsHanhKhach.length; i++) {
            if (dsHanhKhach[i].getTen().equalsIgnoreCase(ten)) {
                dsTen = Arrays.copyOf(dsTen, dsTen.length + 1);
                dsTen[j] = dsHanhKhach[i];
                j++;
            }
        }
        sortTen(dsTen);
        return dsTen;
    }

    public HanhKhach[] dsVip() {
        HanhKhach[] dsvip = new HanhKhach[0];
        int j = 0;
        for (int i = 0; i < dsHanhKhach.length; i++) {
            if (dsHanhKhach[i].getLoaiHanhKhach().toLowerCase().equals("vip")) {
                dsvip = Arrays.copyOf(dsvip, dsvip.length + 1);
                dsvip[j] = dsHanhKhach[i];
                j++;
            }
        }
        sortTen(dsvip);
        return dsvip;
    }

    public HanhKhach[] dsThuong() {
        HanhKhach[] dsthuong = new HanhKhach[0];
        int j = 0;
        for (int i = 0; i < dsHanhKhach.length; i++) {
            if (dsHanhKhach[i].getLoaiHanhKhach().toLowerCase().equals("thuong")) {
                dsthuong = Arrays.copyOf(dsthuong, dsthuong.length + 1);
                dsthuong[j] = dsHanhKhach[i];
                j++;
            }
        }
        sortTen(dsthuong);
        return dsthuong;
    }

    public HanhKhach[] timNgaySinh(String ngaySinh){
        HanhKhach[] ds = new HanhKhach[0];
        int j = 0;
        for (int i = 0; i < 10; i++) {
            if(dsHanhKhach[i].getNgaysinh().equals(ngaySinh)){
                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = new HanhKhach();
                ds[j] = dsHanhKhach[i];
                j++;
            }
        }
        return ds;
    }
    
    public HanhKhach timCCCD(String cccd){
        HanhKhach hk = new HanhKhach();
        int j = 0;
        for (int i = 0; i < 10; i++) {
            if(dsHanhKhach[i].getNgaysinh().equals(cccd)){
                return dsHanhKhach[i];
            }
        }
        return null;
    }
    
    public HanhKhach timSDT(String sdt){
        HanhKhach hk = new HanhKhach();
        int j = 0;
        for (int i = 0; i < 10; i++) {
            if(dsHanhKhach[i].getNgaysinh().equals(sdt)){
                return dsHanhKhach[i];
            }
        }
        return null;
    }

    public HanhKhach[] dsTuoi(int tuoi) {
        HanhKhach[] ds = new HanhKhach[0];
        int j = 0;
        for (int i = 0; i < dsHanhKhach.length; i++) {
            if (dsHanhKhach[i].tuoi() == tuoi) {
                ds = Arrays.copyOf(ds, ds.length + 1);
                ds[j] = dsHanhKhach[i];
                j++;
            }
        }
        return ds;
    }

    public int[] thongKeTuoi() {
        int slTuoi[] = new int[100];
        for (int i = 0; i < dsHanhKhach.length; i++) {
            slTuoi[dsHanhKhach[i].tuoi()]++;
        }
        return slTuoi;
    }

    private void sortTen(HanhKhach[] ds) {
        HanhKhach hk1;
        for (int i = 0; i < ds.length - 1; i++) {
            for (int j = i + 1; j < ds.length; j++) {
                if (1.0 * ds[i].getTen().charAt(0) > 1.0 * ds[j].getTen().charAt(0)) {
                    hk1 = ds[i];
                    ds[i] = ds[j];
                    ds[j] = hk1;
                }
            }
        }
    }

}
