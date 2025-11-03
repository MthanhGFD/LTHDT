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
            if (tim(ma) != null) {
                dsHanhKhach = Arrays.copyOf(dsHanhKhach, i + 1);
                dsHanhKhach[i] = new HanhKhach();
                dsHanhKhach[i].setMaHanhKhach(ma);
                dsHanhKhach[i].nhapHanhKhach();
                ghiFile(dsHanhKhach[i]);
            } else {
                i--;
            }
        }
    }

    public void xuatDS() {
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

    public void ghiFile(HanhKhach hanhkhach) {
        try {
            File f = new File("dsHanhKhach.txt");
            FileWriter writef = new FileWriter(f, true);
            if (f.length() != 0) {
                writef.write("\n");
            }
            writef.write(hanhkhach.toString());
            writef.close();
        } catch (IOException e) {
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
            ghiFile(dsHanhKhach[soLuong]);
            soLuong++;
        } else {
            System.out.println("LOI, trung ma hanh khach!!!");
        }
    }

    public void them(HanhKhach hanhkhach) {
        dsHanhKhach = Arrays.copyOf(dsHanhKhach, soLuong + 1);
        dsHanhKhach[soLuong] = new HanhKhach();
        dsHanhKhach[soLuong] = hanhkhach;
        ghiFile(dsHanhKhach[soLuong]);
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

    public HanhKhach[] timTen() {
        HanhKhach[] dsTen = new HanhKhach[0];
        int j = 0;
        String ten;
        System.out.print("Nhap ten can tim: ");
        ten = sc.nextLine();
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

    public void thongKeLoaiHanhKhach() {
        HanhKhach[] dsvip = dsVip();
        HanhKhach[] dsthuong = dsThuong();
        if (dsvip != null) {
            for (int i = 0; i < dsvip.length; i++) {
                dsvip[i].xuatHanhKhach();
            }
        }
        if (dsthuong != null) {
            for (int i = 0; i < dsthuong.length; i++) {
                dsthuong[i].xuatHanhKhach();
            }
        }
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

    public void menu() {
        System.out.println("+------------QUAN LY DANH SACH HANH KHACH------------+");
        System.out.println("|  1. Doc danh sach tu file                          |");
        System.out.println("|  2. Nhap danh sach moi                             |");
        System.out.println("|  3. Them hanh khach                                |");
        System.out.println("|  4. Xoa hanh khach                                 |");
        System.out.println("|  5. Sua thong tin hanh khach                       |");
        System.out.println("|  6. Tim hanh khach theo ma                         |");
        System.out.println("|  7. Tim hanh khach theo ten                        |");
        System.out.println("|  8. Thong ke loai hanh khach                       |");
        System.out.println("|  9. Thong ke tuoi tung hanh khach                  |");
        System.out.println("|  10. Xuat danh sach ra man hinh                    |");
        System.out.println("|  0. Thoat                                          |");
        System.out.println("+----------------------------------------------------+");
    }

    public void choice() {
        String c;
        boolean nhapSai = false;
        do {
            menu();
            System.out.print("Moi chon chuc nang: ");
            c = sc.next();
            sc.nextLine(); // đọc bỏ dấu xuống dòng
            switch (c) {
                case "0":
                    System.out.println("Cam on da su dung chuong trinh!!!");
                    break;
                case "1":
                    docFile();
                    break;
                case "2":
                    nhapDS();
                    break;
                case "3":
                    String t;
                    System.out.println("+-------------- Them Hanh Khach --------------+");
                    System.out.println("|  1. Them hanh khach khong co tham so        |");
                    System.out.println("|  2. Them hanh khach co tham so              |");
                    System.out.println("+---------------------------------------------+");
                    System.out.print("Chon kieu them hanh khach: ");
                    t = sc.next();
                    sc.nextLine();
                    if (t.equals("1")) {
                        them();
                    }
                    if (t.equals("2")) {
                        HanhKhach hk1 = new HanhKhach("A01", "Nguyen Van", "Teo", "01-01-2005", "Ong", "0892001", "0357522", "Vip");
                        them(hk1);
                    }
                    break;
                case "4":
                    String x;
                    System.out.println("+--------------- Xoa Hanh Khach ---------------+");
                    System.out.println("|  1. Xoa hanh khach khong co tham so          |");
                    System.out.println("|  2. Xoa hanh khach co tham so                |");
                    System.out.println("+----------------------------------------------+");
                    System.out.print("Chon kieu xoa hanh khach: ");
                    x = sc.next();
                    sc.nextLine();
                    if (x.equals("1")) {
                        xoa();
                    }
                    if (x.equals("2")) {
                        System.out.print("Nhap ma hanh khach can xoa: ");
                        xoa(sc.nextLine());
                    }
                    break;
                case "5":
                    String s;
                    System.out.println("+--------------- Sua Hanh Khach ---------------+");
                    System.out.println("|  1. Sua hanh khach khong co tham so          |");
                    System.out.println("|  2. Sua hanh khach co tham so                |");
                    System.out.println("+----------------------------------------------+");
                    System.out.print("Chon kieu sua hanh khach: ");
                    s = sc.next();
                    sc.nextLine();
                    if (s.equals("1")) {
                        sua();
                    }
                    if (s.equals("2")) {
                        System.out.print("Nhap ma hanh khach can sua: ");
                        sua(sc.nextLine());
                    }
                    break;
                case "6":
                    String tm;
                    System.out.println("+--------------- Tim Hanh Khach ---------------+");
                    System.out.println("|  1. Tim hanh khach khong co tham so          |");
                    System.out.println("|  2. Tim hanh khach co tham so                |");
                    System.out.println("|  3. Tim vi tri cua hanh khach                |");
                    System.out.println("+----------------------------------------------+");
                    System.out.print("Chon kieu tim hanh khach: ");
                    tm = sc.next();
                    sc.nextLine();
                    switch (tm) {
                        case "1":
                            if (tim() != null) {
                                tim().xuatHanhKhach();
                            } else {
                                System.out.println("Khong co hanh khach can tim");
                            }
                            break;
                        case "2":
                            String ma;
                            System.out.print("Nhap ma hanh khach can tim: ");
                            ma = sc.nextLine();
                            if (tim(ma) != null) {
                                tim(ma).xuatHanhKhach();
                            } else {
                                System.out.println("Khong tim thay ma can tim");
                            }
                            break;
                        case "3":
                            String mahk;
                            System.out.print("Nhap ma hanh khach can tim: ");
                            mahk = sc.nextLine();
                            if (timViTri(mahk) != -1) {
                                System.out.println("Hanh khach o vi tri " + timViTri(mahk) + " trong danh sach");
                            } else {
                                System.out.println("Khong tim thay vi tri hanh khach");
                            }
                            break;
                    }
                    break;
                case "7":
                    String tt;
                    System.out.println("+--------------- Danh sach ten ---------------+");
                    System.out.println("|  1. Tim theo ten khong tham so              |");
                    System.out.println("|  2. Tim theo ten co tham so                 |");
                    System.out.println("+---------------------------------------------+");
                    System.out.print("Chon kieu tim ten: ");
                    tt = sc.nextLine();
                    HanhKhach[] ds;
                    switch (tt) {
                        case "1":
                            ds = timTen();
                            if (ds != null && ds.length > 0) {
                                System.out.println("So luong hanh khach co ten can tim la: ");
                                for (int i = 0; i < ds.length; i++) {
                                    ds[i].xuatHanhKhach();
                                }
                            } else {
                                System.out.println("Khong co hanh khach nao ten can tim");
                            }
                            break;
                        case "2":
                            String ten;
                            System.out.print("Nhap ten can tim: ");
                            ten = sc.nextLine();
                            ds = timTen(ten);
                            if (ds != null && ds.length > 0) {
                                System.out.println("So luong hanh khach co ten can tim la: ");
                                for (int i = 0; i < ds.length; i++) {
                                    ds[i].xuatHanhKhach();
                                }
                            } else {
                                System.out.println("Khong co hanh khach nao ten can tim");
                            }
                            break;
                    }
                    break;
                case "8":
                    thongKeLoaiHanhKhach();
                    break;
                case "9":
                    int[] tk = thongKeTuoi();
                    for (int i = 0; i < tk.length; i++) {
                        if (tk[i] > 0) {
                            System.out.println("So luong hanh khach co tuoi " + i + " la " + tk[i]);
                        }
                    }
                    break;
                case "10":
                    System.out.println("+---------------------------- Danh sach Hanh Khach ----------------------------+");
                    xuatDS();
                    System.out.println("+---------------------------- Danh sach Hanh Khach ----------------------------+");
                    break;
                default:
                    System.out.println("Chon khong dung, hay chon lai cho dung chuc nang (0-10)");
                    nhapSai = true;
            }
            if (!nhapSai && !c.equals("0")) {
                System.out.println("Ban co muon thoat chuong trinh??");
                System.out.println("Neu co -> (0) | thao tac tiep -> (1-10)");
            }
        } while (!c.equals("0"));
    }

}
