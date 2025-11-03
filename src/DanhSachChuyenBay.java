package src;

import src.ChuyenBay;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachChuyenBay {

    private ChuyenBay dschuyenbay[];
    private int soluong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachChuyenBay() {
        dschuyenbay = new ChuyenBay[0];
        soluong = 0;
    }

    public DanhSachChuyenBay(ChuyenBay[] dschuyenbay, int soluong) {
        this.dschuyenbay = dschuyenbay;
        this.soluong = soluong;
    }

    public DanhSachChuyenBay(DanhSachChuyenBay ds) {
        dschuyenbay = ds.dschuyenbay;
        soluong = ds.soluong;
    }

    public void nhapDS() {
        int sl;
        System.out.print("Nhap so luong chuyen bay: ");
        sl = sc.nextInt();
        soluong = sl;
        for (int i = 0; i < sl; i++) {
            String machuyenbay;
            System.out.print("Nhap ma chuyen bay: ");
            machuyenbay = sc.nextLine();
            if (tim(machuyenbay) == null) {
                dschuyenbay = Arrays.copyOf(dschuyenbay, i + 1);
                dschuyenbay[dschuyenbay.length] = new ChuyenBay();
                dschuyenbay[i].nhapChuyenBay();
                String mamaybay, mahang, masanbay;
                System.out.print("Nhap ma may bay: ");
                mamaybay = sc.nextLine();
                System.out.print("Nhap ma hang hang khong: ");
                mahang = sc.nextLine();
                System.out.print("Nhap ma san bay: ");
                masanbay = sc.nextLine();
            } else {
                i--;
            }
        }
    }

    public void xuatDS() {
        System.out.println("+-----------------+-----------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
        System.out.println("|  Ma chuyen bay  | Diem khoi hanh  |Ngay khoi hanh|Gio khoi hanh |  Tinh trang  |   May may bay   |     Ma hang     |   Ma san bay    |");
        System.out.println("+-----------------+-----------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
        for (int i = 0; i < soluong; i++) {
            dschuyenbay[i].xuatChuyenBay();
        }
        System.out.println("+-----------------+-----------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
    }

    public void docFile() {
        int i = soluong;
        try {
            FileReader f = new FileReader("dsChuyenBay.txt");
            Scanner doc = new Scanner(f);
            while (doc.hasNextLine()) {
                String line = doc.nextLine();
                String tokens[] = line.split(",");
                dschuyenbay[i].setMaChuyenBay(tokens[0]);
                dschuyenbay[i].setDiemKhoiHanh(tokens[1]);
                dschuyenbay[i].setNgayKhoiHanh(tokens[2]);
                dschuyenbay[i].setGioKhoiHanh(tokens[3]);
                dschuyenbay[i].setTinhTrang(tokens[4]);
                i++;
            }
            soluong = i;
            f.close();
            doc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi doc file!");
        }
    }

    public void ghiFile(ChuyenBay chuyenbay) {
        try {
            FileWriter f = new FileWriter("dsChuyenBay.txt", true);
            f.write(chuyenbay.toString());
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong mo duoc file!");
        } catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }

    // thêm chuyến bay
    // không tham số
    public void them() {
        String ma;
        System.out.print("Nhap ma chuyen bay: ");
        ma = sc.nextLine();
        if (tim(ma) != null) {
            dschuyenbay = Arrays.copyOf(dschuyenbay, soluong + 1);
            dschuyenbay[soluong] = new ChuyenBay();
            dschuyenbay[soluong].nhapChuyenBay();
            soluong++;
        }
    }

    // có tham số
    public void them(String ma) {
        if (tim(ma) != null) {
            dschuyenbay = Arrays.copyOf(dschuyenbay, soluong + 1);
            dschuyenbay[soluong] = new ChuyenBay();
            dschuyenbay[soluong].nhapChuyenBay();
            soluong++;
        }
    }

    // không tham số
    public void xoa() {
        String ma;
        System.out.print("Nhap ma chuyen bay: ");
        ma = sc.nextLine();
        int vitri = timViTri(ma);
        if (vitri != -1) {
            for (int i = vitri; i < soluong - 1; i++) {
                dschuyenbay[i] = dschuyenbay[i + 1];
            }
            dschuyenbay = Arrays.copyOf(dschuyenbay, soluong - 1);
            soluong--;
        } else {
            System.out.println("Khong tim thay ma can xoa");
        }
    }

    // có tham số
    public void xoa(String ma) {
        int vitri = timViTri(ma);
        if (vitri != -1) {
            dschuyenbay[vitri].setTinhTrang("huy");
            for (int i = vitri; i < soluong - 1; i++) {
                dschuyenbay[i] = dschuyenbay[i + 1];
            }
            dschuyenbay = Arrays.copyOf(dschuyenbay, soluong - 1);
            soluong--;

        } else {
            System.out.println("Khong tim thay ma can xoa");
        }
    }

    // sửa chuyến bay
    // không tham số
    public void sua() {
        String ma;
        System.out.print("Nhap ma chuyen bay can sua: ");
        ma = sc.nextLine();
        ChuyenBay cb = new ChuyenBay();
        cb = tim(ma);
        if (cb != null) {
            String luaChon;
            do {
                System.out.println("\n+=====================================+");
                System.out.println("|        MENU SUA CHUYEN BAY          |");
                System.out.println("+=====================================+");
                System.out.println("| 1. Sua diem khoi hanh               |");
                System.out.println("| 2. Sua diem den                     |");
                System.out.println("| 3. Sua gio khoi hanh                |");
                System.out.println("| 4. Sua ngay khoi hanh               |");
                System.out.println("| 0. Thoat                            |");
                System.out.println("+-------------------------------------+");
                System.out.print("Nhap lua chon: ");
                luaChon = sc.next();
                sc.nextLine(); // doc bo dong

                switch (luaChon) {
                    case "1": {
                        System.out.print("Nhap diem khoi hanh moi: ");
                        cb.setDiemKhoiHanh(sc.nextLine());
                        System.out.println("Da cap nhat diem khoi hanh thanh: " + cb.getDiemKhoiHanh());
                        break;
                    }
                    case "2": {
                        System.out.print("Nhap diem den moi: ");
                        cb.setDiemDen(sc.nextLine());
                        System.out.println("Da cap nhat diem den thanh: " + cb.getDiemDen());
                        break;
                    }
                    case "3": {
                        System.out.print("Nhap gio khoi hanh moi: ");
                        cb.setGioKhoiHanh(sc.nextLine());
                        cb.setTinhTrang("Hoan");
                        System.out.println("Da cap nhat gio khoi hanh thanh: " + cb.getGioKhoiHanh());
                        System.out.println("Tinh trang chuyen bay da duoc cap nhat thanh: Hoan");
                        break;
                    }
                    case "4": {
                        System.out.print("Nhap ngay khoi hanh moi: ");
                        cb.setNgayKhoiHanh(sc.nextLine());
                        System.out.println("Da cap nhat ngay khoi hanh thanh: " + cb.getNgayKhoiHanh());
                        break;
                    }
                    case "0":
                        System.out.println("Thoat sua chuyen bay.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long nhap lai!");
                }

            } while (!luaChon.equals("0"));
        } else {
            System.out.println("Khong co chuyen bay can sua!");
        }

    }

    // có tham số
    public void sua(String ma) {
        ChuyenBay cb = new ChuyenBay();
        cb = tim(ma);
        if (cb != null) {
            String luaChon;
            do {
                System.out.println("\n+=====================================+");
                System.out.println("|        MENU SUA CHUYEN BAY          |");
                System.out.println("+=====================================+");
                System.out.println("| 1. Sua diem khoi hanh               |");
                System.out.println("| 2. Sua diem den                     |");
                System.out.println("| 3. Sua gio khoi hanh                |");
                System.out.println("| 4. Sua ngay khoi hanh               |");
                System.out.println("| 0. Thoat                            |");
                System.out.println("+-------------------------------------+");
                System.out.print("Nhap lua chon: ");
                luaChon = sc.next();
                sc.nextLine(); // doc bo dong

                switch (luaChon) {
                    case "1": {
                        System.out.print("Nhap diem khoi hanh moi: ");
                        cb.setDiemKhoiHanh(sc.nextLine());
                        System.out.println("Da cap nhat diem khoi hanh thanh: " + cb.getDiemKhoiHanh());
                        break;
                    }
                    case "2": {
                        System.out.print("Nhap diem den moi: ");
                        cb.setDiemDen(sc.nextLine());
                        System.out.println("Da cap nhat diem den thanh: " + cb.getDiemDen());
                        break;
                    }
                    case "3": {
                        System.out.print("Nhap gio khoi hanh moi: ");
                        cb.setGioKhoiHanh(sc.nextLine());
                        cb.setTinhTrang("Hoan");
                        System.out.println("Da cap nhat gio khoi hanh thanh: " + cb.getGioKhoiHanh());
                        System.out.println("Tinh trang chuyen bay da duoc cap nhat thanh: Hoan");
                        break;
                    }
                    case "4": {
                        System.out.print("Nhap ngay khoi hanh moi: ");
                        cb.setNgayKhoiHanh(sc.nextLine());
                        System.out.println("Da cap nhat ngay khoi hanh thanh: " + cb.getNgayKhoiHanh());
                        break;
                    }
                    case "0":
                        System.out.println("Thoat sua chuyen bay.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long nhap lai!");
                }

            } while (!luaChon.equals("0"));
        } else {
            System.out.println("Khong co chuyen bay can sua!");
        }
    }

    // tìm Chuyến bay
    // không tham số
    public ChuyenBay tim() {
        String ma;
        System.out.print("Nhap ma chuyen bay can tim:");
        ma = sc.nextLine();
        for (int i = 0; i < dschuyenbay.length; i++) {
            if (dschuyenbay[i].getMaChuyenBay().equals(ma)) {
                return dschuyenbay[i];
            }
        }
        return null;
    }

    // có tham số
    public ChuyenBay tim(String ma) {
        for (int i = 0; i < dschuyenbay.length; i++) {
            if (dschuyenbay[i].getMaChuyenBay().equals(ma)) {
                return dschuyenbay[i];
            }
        }
        return null;
    }

    // tìm vị trí
    public int timViTri(String ma) {
        for (int i = 0; i < dschuyenbay.length; i++) {
            if (dschuyenbay[i].getMaChuyenBay().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    // thống kê các chuyến bay cùng ngày
    public ChuyenBay[] dsNgay(int ngay) {
        ChuyenBay[] ds = new ChuyenBay[0];
        int j = 0;
        for (int i = 0; i < dschuyenbay.length; i++) {
            if (dschuyenbay[i].ngay() == ngay) {
                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = new ChuyenBay();
                ds[j] = dschuyenbay[i];
                j++;
            }
        }
        return ds;
    }

    public int[] thongKeNgayChuyenBay() {
        int dsngay[] = new int[32];
        for (int i = 1; i < dsngay.length; i++) {
            dsngay[i] = dsNgay(i).length;
        }
        return dsngay;
    }

    // thống kê theo tình trạng chuyến bay
    public ChuyenBay[] dsTinhTrang(String tinhtrang) {
        ChuyenBay[] ds = new ChuyenBay[0];
        int j = 0;
        for (int i = 0; i < dschuyenbay.length; i++) {
            if (dschuyenbay[i].getTinhTrang().equalsIgnoreCase(tinhtrang)) {
                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = new ChuyenBay();
                ds[j] = dschuyenbay[i];
                j++;
            }
        }
        return ds;
    }

    public ChuyenBay[][] thongKeTinhTrang() {
        ChuyenBay[][] tk = new ChuyenBay[0][0];
        String[] tinhtrang = {"Hoat dong", "Tam hoan", "Huy"};
        for (int i = 0; i < 3; i++) {
            ChuyenBay[] t = dsTinhTrang(tinhtrang[i]);
            if (t != null) {
                tk[i] = Arrays.copyOf(tk[i], tk.length + t.length);
                tk[i] = t;
            }
        }
        return tk;
    }

}
