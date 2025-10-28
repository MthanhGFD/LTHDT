package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class DanhSachHanhKhach {

    private HanhKhach dshanhkhach[];
    private int soluong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachHanhKhach() {
        dshanhkhach = new HanhKhach[0];
        soluong = 0;
    }

    public DanhSachHanhKhach(HanhKhach[] dshanhkhach, int soluong) {
        this.dshanhkhach = dshanhkhach;
        this.soluong = soluong;
    }

    public DanhSachHanhKhach(DanhSachHanhKhach ds) {
        dshanhkhach = ds.dshanhkhach;
        soluong = ds.soluong;
    }

    public void nhapDS() {
        int sl;
        System.out.print("Nhap so luong Hanh Khach: ");
        sl = sc.nextInt();
        soluong = sl;
        for (int i = 0; i < sl; i++) {
            String ma;
            System.out.print("Nhap ma hanh khach: ");
            ma = sc.nextLine();
            if (tim(ma) != null) {
                dshanhkhach = Arrays.copyOf(dshanhkhach, i + 1);
                dshanhkhach[i] = new HanhKhach();
                dshanhkhach[i].setMaHanhKhach(ma);
                dshanhkhach[i].nhapHanhKhach();
                ghiFile(dshanhkhach[i]);
            } else {
                i--;
            }
        }
    }

    public void xuatDS() {
        for (int i = 0; i < dshanhkhach.length; i++) {
            dshanhkhach[i].xuatHanhKhach();
        }
    }

    public void docFile() {
        int i = soluong;
        try {
            FileReader f = new FileReader("dsHanhKhach.txt");
            Scanner doc = new Scanner(f);
            while (doc.hasNextLine()) { // đọc từng dòng
                String line = doc.nextLine();
                String[] tokens = line.split(",");
                dshanhkhach = Arrays.copyOf(dshanhkhach, dshanhkhach.length + 1);
                dshanhkhach[i] = new HanhKhach();
                dshanhkhach[i].setMaHanhKhach(tokens[0]);
                // tách họ và tên thành 2
                String ho, ten;
                ten = tokens[1].substring(tokens[1].lastIndexOf(" ") + 1);
                ho = tokens[1].substring(0, tokens[1].length() - ten.length());
                dshanhkhach[i].setHo(ho);
                dshanhkhach[i].setTen(ten);
                dshanhkhach[i].setNgaysinh(tokens[2]);
                dshanhkhach[i].setDanhxung(tokens[3]);
                dshanhkhach[i].setCccd(tokens[4]);
                dshanhkhach[i].setSdt(tokens[5]);
                dshanhkhach[i].setLoaiHanhKhach(tokens[6]);
                i++;
            }
            soluong = i;
            f.close(); // đóng file
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file.");
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

    // thêm không tham số
    public void them() {
        String ma;
        System.out.print("Nhập mã hành khách: ");
        ma = sc.nextLine();
        if (tim(ma) == null) {
            dshanhkhach = Arrays.copyOf(dshanhkhach, soluong + 1);
            dshanhkhach[soluong] = new HanhKhach();
            dshanhkhach[soluong].setMaHanhKhach(ma);
            dshanhkhach[soluong].nhapHanhKhach();
            ghiFile(dshanhkhach[soluong]);
            soluong++;
        } else
            System.out.println("Loi ma hanh khach.");
    }

    // thêm có tham số
    public void them(HanhKhach hanhkhach) {
        dshanhkhach = Arrays.copyOf(dshanhkhach, soluong + 1);
        dshanhkhach[soluong] = new HanhKhach();
        dshanhkhach[soluong] = hanhkhach;
        ghiFile(dshanhkhach[soluong]);
        soluong++;
    }

    // xóa không tham số
    public void xoa(String mahanhkhach) {
        int vitrixoa = timViTri(mahanhkhach);
        if (vitrixoa != -1) {
            for (int i = vitrixoa; i < dshanhkhach.length - 1; i++) {
                dshanhkhach[i] = dshanhkhach[i + 1];
            }
            dshanhkhach = Arrays.copyOf(dshanhkhach, soluong - 1);
            soluong--;
        } else {
            System.out.print("Khong tim thay hanh khach can xoa");
        }
    }

    // xóa có tham số
    public void xoa() {
        String mahanhkhach;
        mahanhkhach = sc.nextLine();
        int vitrixoa = timViTri(mahanhkhach);
        if (vitrixoa != -1) {
            for (int i = vitrixoa; i < dshanhkhach.length - 1; i++) {
                dshanhkhach[i] = dshanhkhach[i + 1];
            }
            dshanhkhach = Arrays.copyOf(dshanhkhach, soluong - 1);
            soluong--;
        } else {
            System.out.print("Khong tim thay hanh khach can xoa");
        }
    }

    // sửa không tham số
    public void sua() {
        String mahanhkhach;
        mahanhkhach = sc.nextLine();
        int vitri = timViTri(mahanhkhach);
        if (vitri != -1) {
            String choice;
            System.out.println("+-------------------SUA THONG TIN HANH KHACH------------------+");
            System.out.println("|  1. Sua ho                                                  |");
            System.out.println("|  2. Sua ten                                                 |");
            System.out.println("|  3. Sua so dien thoai                                       |");
            System.out.println("|  4. Sua loai hanh khach                                     |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.print("Chon thong tin muon sua: ");
            choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.print("Moi nhap ho muon sua: ");
                    dshanhkhach[vitri].setHo(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Moi nhap ten muon sua: ");
                    dshanhkhach[vitri].setTen(sc.nextLine());
                    break;
                case "3":
                    System.out.print("Moi nhap so dien thoai muon sua: ");
                    dshanhkhach[vitri].setSdt(sc.nextLine());
                    break;
                case "4":
                    System.out.print("Moi nhap loai hanh khach muon sua: ");
                    dshanhkhach[vitri].setLoaiHanhKhach(sc.nextLine());
                    break;
            }
        } else {
            System.out.println("Khong tim thay hanh khach muon sua");
        }

    }

    // sửa có tham số
    public void sua(String mahanhkhach) {
        int vitri = timViTri(mahanhkhach);
        if (vitri != -1) {
            String choice;
            System.out.println("+-------------------SUA THONG TIN HANH KHACH------------------+");
            System.out.println("|  1. Sua ho                                                  |");
            System.out.println("|  2. Sua ten                                                 |");
            System.out.println("|  3. Sua so dien thoai                                       |");
            System.out.println("|  4. Sua loai hanh khach                                     |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.print("Chon thong tin muon sua: ");
            choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.print("Moi nhap ho muon sua: ");
                    dshanhkhach[vitri].setHo(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Moi nhap ten muon sua: ");
                    dshanhkhach[vitri].setTen(sc.nextLine());
                    break;
                case "3":
                    System.out.print("Moi nhap so dien thoai muon sua: ");
                    dshanhkhach[vitri].setSdt(sc.nextLine());
                    break;
                case "4":
                    System.out.print("Moi nhap loai hanh khach muon sua: ");
                    dshanhkhach[vitri].setLoaiHanhKhach(sc.nextLine());
                    break;
            }
        } else {
            System.out.println("Khong tim thay hanh khach muon sua");
        }

    }

    // tìm hành khách
    public HanhKhach tim(String ma) {
        for (int i = 0; i < dshanhkhach.length; i++) {
            if (dshanhkhach[i].getMaHanhKhach().equals(ma)) {
                return dshanhkhach[i];
            }
        }
        return null;
    }

    public HanhKhach tim() {
        String ma;
        System.out.print("Nhap ma hanh khach can tim: ");
        ma = sc.nextLine();
        for (int i = 0; i < dshanhkhach.length; i++) {
            if (dshanhkhach[i].getMaHanhKhach().equals(ma)) {
                return dshanhkhach[i];
            }
        }
        return null;
    }

    public int timViTri(String ma) {
        for (int i = 0; i < dshanhkhach.length; i++) {
            if (dshanhkhach[i].getMaHanhKhach().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    // tìm theo tên không tham số
    public HanhKhach[] timTen() {
        HanhKhach[] dsTen = new HanhKhach[0];
        int j = 0;
        String ten;
        System.out.print("Nhap ten can tim: ");
        ten = sc.nextLine();
        for (int i = 0; i < dshanhkhach.length; i++) {
            if (dshanhkhach[i].getTen().equalsIgnoreCase(ten)) {
                dsTen = Arrays.copyOf(dsTen, dsTen.length + 1);
                dsTen[j] = new HanhKhach();
                dsTen[j] = dshanhkhach[i];
                j++;
            }
        }
        sortTen(dsTen);
        return dsTen;
    }

    // tìm theo tên có tham số
    public HanhKhach[] timTen(String ten) {
        HanhKhach[] dsTen = new HanhKhach[0];
        int j = 0;
        for (int i = 0; i < dshanhkhach.length; i++) {
            if (dshanhkhach[i].getTen().equalsIgnoreCase(ten)) {
                dsTen = Arrays.copyOf(dsTen, dsTen.length + 1);
                dsTen[j] = new HanhKhach();
                dsTen[j] = dshanhkhach[i];
                j++;
            }
        }
        sortTen(dsTen);
        return dsTen;
    }

    // thống kê hành khách theo loại vé
    // vé vip
    public HanhKhach[] dsVip() {
        HanhKhach[] dsvip = new HanhKhach[0];
        int j = 0;
        for (int i = 0; i < dshanhkhach.length; i++) {
            if (dshanhkhach[i].getLoaiHanhKhach().toLowerCase().equals("vip")) {
                dsvip = Arrays.copyOf(dsvip, dsvip.length + 1);
                dsvip[j] = new HanhKhach();
                dsvip[j] = dshanhkhach[i];
                j++;
            }
        }
        sortTen(dsvip);
        return dsvip;
    }

    // vé thường
    public HanhKhach[] dsThuong() {
        HanhKhach[] dsthuong = new HanhKhach[0];
        int j = 0;
        for (int i = 0; i < dshanhkhach.length; i++) {
            if (dshanhkhach[i].getLoaiHanhKhach().toLowerCase().equals("thuong")) {
                dsthuong = Arrays.copyOf(dsthuong, dsthuong.length + 1);
                dsthuong[j] = new HanhKhach();
                dsthuong[j] = dshanhkhach[i];
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
        for (int i = 0; i < ds.length; i++) {
            if (dshanhkhach[i].tuoi() == tuoi) {
                ds = Arrays.copyOf(ds, i + 1);
                ds[j] = new HanhKhach();
                ds[j] = dshanhkhach[i];
                j++;
            }
        }
        return ds;
    }

    public int[] thongKeTuoi() {
        int slTuoi[] = new int[100];
        for (int i = 0; i < dshanhkhach.length; i++) {
            slTuoi[dshanhkhach[i].tuoi()]++;
        }
        return slTuoi;
    }

    // sort theo tên cho dễ nhìn
    private void sortTen(HanhKhach[] ds) {
        HanhKhach hk1 = new HanhKhach();
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
        System.out.println("+--------------------------------- ------------------+");
    }

    public void choice() {
        String c;
        boolean nhapSai = false;
        do {
            menu();
            System.out.print("Moi chon chuc nang: ");
            c = sc.next();
            switch (c) {
                case "0":
                    System.out.println("Da thoat chuong trinh.");
                    break;
                case "1":
                    docFile();
                    break;
                case "2":
                    nhapDS();
                    break;
                case "3":
                    String t;
                    System.out.println("+-------------- THEM HANH KHACH --------------+");
                    System.out.println("|  1. Them hanh khach khong co tham so        |");
                    System.out.println("|  2. Them hanh khach co tham so              |");
                    System.out.println("+---------------------------------------------+");
                    System.out.print("Chon kieu \"Them hanh khach\": ");
                    t = sc.next();
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
                    System.out.println("+--------------- XOA HANH KHACH ---------------+");
                    System.out.println("|  1. Xóa hành khách không có tham số          |");
                    System.out.println("|  2. Xóa hành khách có tham số                |");
                    System.out.println("+----------------------------------------------+");
                    System.out.print("Chon kieu \"Xoa hanh khach\": ");
                    x = sc.next();
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
                    System.out.println("+---------- SUA THONG TIN HANH KHACH ----------+");
                    System.out.println("|  1. Sua khong co tham so                     |");
                    System.out.println("|  2. Sửa co tham so                           |");
                    System.out.println("+----------------------------------------------+");
                    System.out.print("Chon kieu \"Sua hanh khach\": ");
                    s = sc.next();
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
                    System.out.println("+--------------- TIM HANH KHACH ---------------+");
                    System.out.println("|  1. Tim hanh khach khong co tham so          |");
                    System.out.println("|  2. Tim hanh khach co tham so                |");
                    System.out.println("|  3. Tim vi tri cua hanh khach                |");
                    System.out.println("+----------------------------------------------+");
                    System.out.print("Chon kieu \"Tim hanh khach\": ");
                    tm = sc.next();
                    switch (tm) {
                        case "1":
                            if (tim() != null) {
                                tim().xuatHanhKhach();
                            } else {
                                System.out.println("Khong co hanh khach can tim");
                            }
                        case "2":
                            String ma;
                            System.out.print("Nhap ma hanh khach can tim: ");
                            ma = sc.nextLine();
                            if (tim(ma) != null) {
                                tim(ma).xuatHanhKhach();
                            } else {
                                System.out.println("Khong tim thay ma can tim");
                            }
                        case "3":
                            String mahk;
                            System.out.println("Nhap ma hanh khach can tim: ");
                            mahk = sc.nextLine();
                            if (timViTri(mahk) != -1) {
                                System.out.println("Hanh khach o vi tri " + timViTri(mahk) + " trong danh sach");
                            } else {
                                System.out.println("Khong tim thay vi tri hanh khach");
                            }

                        case "7":
                            String tt;
                            System.out.println("+--------------- DANH SACH TEN ---------------+");
                            System.out.println("|  1. Tim theo ten khong tham so              |");
                            System.out.println("|  2. Tim theo ten co tham so                 |");
                            System.out.println("+---------------------------------------------+");
                            System.out.print("Chon kieu tim ten: ");
                            tt = sc.nextLine();
                            HanhKhach[] ds;
                            switch (tt) {
                                case "1":
                                    ds = timTen();
                                    if (ds != null) {
                                        System.out.println("So luong hanh khach co ten " + tt + " la: ");
                                        for (int i = 0; i < ds.length; i++) {
                                            ds[i].xuatHanhKhach();
                                        }
                                    } else {
                                        System.out.println("Khong co hanh khach nao ten " + tt);
                                    }
                                    break;
                                case "2":
                                    String ten;
                                    System.out.print("Nhap ten can tim: ");
                                    ten = sc.nextLine();
                                    ds = timTen(ten);
                                    if (ds != null) {
                                        System.out.println("So luong hanh khach co ten " + tt + " la: ");
                                        for (int i = 0; i < ds.length; i++) {
                                            ds[i].xuatHanhKhach();
                                        }
                                    } else {
                                        System.out.println("Khong co hanh khach nao ten " + tt);
                                    }
                                    break;
                                case "8":
                                    thongKeLoaiHanhKhach();
                                    break;
                                case "9":
                                    int[] tk = thongKeTuoi();
                                    for (int i = 0; i < tk.length; i++) {
                                        System.out.println("So luong hanh khach co tuoi " + i + " la " + tk[i]);
                                    }
                                    break;
                                case "10":
                                    xuatDS();
                                    break;
                                default:
                                    System.out.println("Chon khong dung, moi chon lai: ");
                                    nhapSai = true;
                            }
                    }
            }
            if (!nhapSai && !c.equals("0")) {
                System.out.println("Ban co muon thoat chuong trinh?");
                System.out.println("Thoat chuong trinh (0) | thao tac tiep -> (1-10)");
            }
        } while (!c.equals("0"));
    }
}
