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
        System.out.print("Nhập số lượng Hành Khách: ");
        sl = sc.nextInt();
        soluong = sl;
        for (int i = 0; i < sl; i++) {
            String ma;
            System.out.print("Nhập mã hành khách: ");
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
            System.out.println("Không tìm thấy file!");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file!");
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
            System.out.println("LỖI, trùng mã hành khách!!!");
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
            System.out.print("không tìm thấy hành khách cần xóa!!!");
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
            System.out.print("không tìm thấy hành khách cần xóa!!!");
        }
    }

    // sửa không tham số
    public void sua() {
        String mahanhkhach;
        mahanhkhach = sc.nextLine();
        int vitri = timViTri(mahanhkhach);
        if (vitri != -1) {
            String choice;
            System.out.println("+-------------------SỬA THÔNG TIN HÀNH KHÁCH------------------+");
            System.out.println("|  1. Sửa họ                                                  |");
            System.out.println("|  2. Sửa tên                                                 |");
            System.out.println("|  3. Sửa số điện thoại                                       |");
            System.out.println("|  4. Sửa loại hành khách                                     |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.print("Chọn thông tin bạn muốn sửa: ");
            choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.print("Mòi nhập họ muốn sửa: ");
                    dshanhkhach[vitri].setHo(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Mòi nhập tên muốn sửa: ");
                    dshanhkhach[vitri].setTen(sc.nextLine());
                    break;
                case "3":
                    System.out.print("Mòi nhập số điện thoại muốn sửa: ");
                    dshanhkhach[vitri].setSdt(sc.nextLine());
                    break;
                case "4":
                    System.out.print("Mòi nhập loại hành khách muốn sửa: ");
                    dshanhkhach[vitri].setLoaiHanhKhach(sc.nextLine());
                    break;
            }
        } else {
            System.out.println("Không tìm thấy hành khách muốn sửa");
        }

    }

    // sửa có tham số
    public void sua(String mahanhkhach) {
        int vitri = timViTri(mahanhkhach);
        if (vitri != -1) {
            String choice;
            System.out.println("+-------------------SỬA THÔNG TIN HÀNH KHÁCH------------------+");
            System.out.println("|  1. Sửa họ                                                  |");
            System.out.println("|  2. Sửa tên                                                 |");
            System.out.println("|  3. Sửa số điện thoại                                       |");
            System.out.println("|  4. Sửa loại hành khách                                     |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.print("Chọn thông tin bạn muốn sửa: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Mòi nhập họ muốn sửa: ");
                    dshanhkhach[vitri].setHo(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Mòi nhập tên muốn sửa: ");
                    dshanhkhach[vitri].setTen(sc.nextLine());
                    break;
                case "3":
                    System.out.print("Mòi nhập số điện thoại muốn sửa: ");
                    dshanhkhach[vitri].setSdt(sc.nextLine());
                    break;
                case "4":
                    System.out.print("Mòi nhập loại hành khách muốn sửa: ");
                    dshanhkhach[vitri].setLoaiHanhKhach(sc.nextLine());
                    break;
            }
        } else {
            System.out.println("Không tìm thấy hành khách muốn sửa");
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
        System.out.print("Nhập mã hành khách cần tìm: ");
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
        System.out.print("Nhập tên cần tìm: ");
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
        System.out.println("+------------QUẢN LÝ DANH SÁCH HÀNH KHÁCH------------+");
        System.out.println("|  1. Đọc danh sách từ file                          |");
        System.out.println("|  2. Nhập danh sách mới                             |");
        System.out.println("|  3. Thêm hành khách                                |");
        System.out.println("|  4. Xóa hành khách                                 |");
        System.out.println("|  5. Sửa thông tin hành khách                       |");
        System.out.println("|  6. Tìm hành khách theo mã                         |");
        System.out.println("|  7. Tìm hành khách theo tên                        |");
        System.out.println("|  8. Thống kê loại hành khách                       |");
        System.out.println("|  9. Thống kê tuổi từng hành khách                  |");
        System.out.println("|  10. Xuất danh sách ra màn hình                    |");
        System.out.println("|  0. Thoát                                          |");
        System.out.println("+--------------------------------- ------------------+");
    }

    public void choice() {
        String c;
        boolean nhapSai = false;
        do {
            menu();
            System.out.print("Mời chọn chức năng: ");
            c = sc.next();
            switch (c) {
                case "0":
                    System.out.println("cảm ơn đã sử dụng chương trình!!!");
                    break;
                case "1":
                    docFile();
                    break;
                case "2":
                    nhapDS();
                    break;
                case "3":
                    String t;
                    System.out.println("+-------------- Thêm Hành Khách --------------+");
                    System.out.println("|  1. Thêm hành khách không có tham số        |");
                    System.out.println("|  2. Thêm hành khách có tham số              |");
                    System.out.println("+---------------------------------------------+");
                    System.out.print("Chọn kiểu thêm hành khách: ");
                    t = sc.next();
                    if (t.equals("1")) {
                        them();
                    }
                    if (t.equals("2")) {
                        HanhKhach hk1 = new HanhKhach("A01", "Nguyễn Văn", "Tèo", "01-01-2005", "Ông", "0892001", "0357522", "Vip");
                        them(hk1);
                    }
                    break;
                case "4":
                    String x;
                    System.out.println("+--------------- Xóa Hành Khách ---------------+");
                    System.out.println("|  1. Xóa hành khách không có tham số          |");
                    System.out.println("|  2. Xóa hành khách có tham số                |");
                    System.out.println("+----------------------------------------------+");
                    System.out.print("Chọn kiểu xóa hành khách: ");
                    x = sc.next();
                    if (x.equals("1")) {
                        xoa();
                    }
                    if (x.equals("2")) {
                        System.out.print("Nhập mã hành khách cần xóa: ");
                        xoa(sc.nextLine());
                    }
                    break;
                case "5":
                    String s;
                    System.out.println("+--------------- Sửa Hành Khách ---------------+");
                    System.out.println("|  1. Sửa hành khách không có tham số          |");
                    System.out.println("|  2. Sửa hành khách có tham số                |");
                    System.out.println("+----------------------------------------------+");
                    System.out.print("Chọn kiểu Sửa hành khách: ");
                    s = sc.next();
                    if (s.equals("1")) {
                        sua();
                    }
                    if (s.equals("2")) {
                        System.out.print("Nhập mã hành khách cần sửa: ");
                        sua(sc.nextLine());
                    }
                    break;
                case "6":
                    String tm;
                    System.out.println("+--------------- Tìm Hành Khách ---------------+");
                    System.out.println("|  1. Tìm hành khách không có tham số          |");
                    System.out.println("|  2. Tìm hành khách có tham số                |");
                    System.out.println("|  3. Tìm vị trí của hành khách                |");
                    System.out.println("+----------------------------------------------+");
                    System.out.print("Chọn kiểu Tìm hành khách: ");
                    tm = sc.next();
                    switch (tm) {
                        case "1":
                            if (tim() != null) {
                                tim().xuatHanhKhach();
                            } else {
                                System.out.println("Không có hành khách cần tìm");
                            }
                        case "2":
                            String ma;
                            System.out.print("Nhập mã hành khách cần tìm: ");
                            ma = sc.nextLine();
                            if (tim(ma) != null) {
                                tim(ma).xuatHanhKhach();
                            } else {
                                System.out.println("Không tìm thấy mã cần tìm");
                            }
                        case "3":
                            String mahk;
                            System.out.println("Nhập mã hành khách cần tìm: ");
                            mahk = sc.nextLine();
                            if (timViTri(mahk) != -1) {
                                System.out.println("Hành khách ở vị trí " + timViTri(mahk) + " trong danh sách");
                            } else {
                                System.out.println("Không tìm thấy vị trí hành khách");
                            }

                        case "7":
                            String tt;
                            System.out.println("+--------------- Danh sách tên ---------------+");
                            System.out.println("|  1. Tìm theo tên không tham số              |");
                            System.out.println("|  2. Tìm theo tên có tham số                 |");
                            System.out.println("+---------------------------------------------+");
                            System.out.print("Chọn kiểu tìm tên: ");
                            tt = sc.nextLine();
                            HanhKhach[] ds;
                            switch (tt) {
                                case "1":
                                    ds = timTen();
                                    if (ds != null) {
                                        System.out.println("Số lượng hành khách có tên " + tt + " là: ");
                                        for (int i = 0; i < ds.length; i++) {
                                            ds[i].xuatHanhKhach();
                                        }
                                    } else {
                                        System.out.println("Không có hành khách nào tên " + tt);
                                    }
                                    break;
                                case "2":
                                    String ten;
                                    System.out.print("Nhập tên cần tìm: ");
                                    ten = sc.nextLine();
                                    ds = timTen(ten);
                                    if (ds != null) {
                                        System.out.println("Số lượng hành khách có tên " + tt + " là: ");
                                        for (int i = 0; i < ds.length; i++) {
                                            ds[i].xuatHanhKhach();
                                        }
                                    } else {
                                        System.out.println("Không có hành khách nào tên " + tt);
                                    }
                                    break;
                                case "8":
                                    thongKeLoaiHanhKhach();
                                    break;
                                case "9":
                                    int[] tk = thongKeTuoi();
                                    for (int i = 0; i < tk.length; i++) {
                                        System.out.println("Số lượng hành khách có tuổi " + i + " là " + tk[i]);
                                    }
                                    break;
                                case "10":
                                    xuatDS();
                                    break;
                                default:
                                    System.out.println("Chọn không đúng, hãy chọn lại cho đúng chức năng (0-10): ");
                                    nhapSai = true;
                            }
                    }
            }
            if (!nhapSai && !c.equals("0")) {
                System.out.println("Bạn có muốn thoát chương trình??");
                System.out.println("Nếu có -> (0) | thao tác tiếp -> (1-10)");
            }
        } while (!c.equals("0"));
    }
}
