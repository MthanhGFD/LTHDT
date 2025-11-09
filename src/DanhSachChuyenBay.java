package src;

import src.ChuyenBay;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachChuyenBay {

    private ChuyenBay dsChuyenBay[];
    private int soLuong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachChuyenBay() {
        dsChuyenBay = new ChuyenBay[0];
        soLuong = 0;
    }

    public DanhSachChuyenBay(ChuyenBay[] dsChuyenBay, int soLuong) {
        this.dsChuyenBay = dsChuyenBay;
        this.soLuong = soLuong;
    }

    public DanhSachChuyenBay(DanhSachChuyenBay ds) {
        dsChuyenBay = ds.dsChuyenBay;
        soLuong = ds.soLuong;
    }

    public void xuatDS() {
        for (int i = 0; i < soLuong; i++) {
            dsChuyenBay[i].xuatChuyenBay();
        }
    }

    public void docFile() {
        int i = soLuong;
        try {
            FileReader f = new FileReader("dsChuyenBay.txt");
            Scanner doc = new Scanner(f);
            while (doc.hasNextLine()) {
                String line = doc.nextLine();
                String tokens[] = line.split(",");
                dsChuyenBay[i].setMaChuyenBay(tokens[0]);
                dsChuyenBay[i].setDiemKhoiHanh(tokens[1]);
                dsChuyenBay[i].setNgayKhoiHanh(tokens[2]);
                dsChuyenBay[i].setGioKhoiHanh(tokens[3]);
                dsChuyenBay[i].setTinhTrang(tokens[4]);
                i++;
            }
            soLuong = i;
            f.close();
            doc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi doc file!");
        }
    }

    // ghi lại danh sách chuyến bay mới
    public void ghiFile() {
        try {
            File f = new File("dsGhe.txt");
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < dsChuyenBay.length; i++) {
                fw.write(dsChuyenBay[i].toString());
                fw.write("\n");
            }
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("file khong ton tai");

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
            dsChuyenBay = Arrays.copyOf(dsChuyenBay, soLuong + 1);
            dsChuyenBay[soLuong] = new ChuyenBay();
            dsChuyenBay[soLuong].nhapChuyenBay();
            soLuong++;
        }
    }

    // có tham số
    public void them(ChuyenBay cb) {
        dsChuyenBay = Arrays.copyOf(dsChuyenBay, soLuong + 1);
        dsChuyenBay[soLuong] = new ChuyenBay();
        dsChuyenBay[soLuong] = cb;
        soLuong++;
    }

    // không tham số
    public void xoa() {
        String ma;
        System.out.print("Nhap ma chuyen bay: ");
        ma = sc.nextLine();
        int vitri = timViTri(ma);
        if (vitri != -1) {
            for (int i = vitri; i < soLuong - 1; i++) {
                dsChuyenBay[i] = dsChuyenBay[i + 1];
            }
            dsChuyenBay = Arrays.copyOf(dsChuyenBay, soLuong - 1);
            soLuong--;
        } else {
            System.out.println("Khong tim thay ma can xoa");
        }
    }

    // có tham số
    public void xoa(String ma) {
        int vitri = timViTri(ma);
        if (vitri != -1) {
            dsChuyenBay[vitri].setTinhTrang("huy");
            for (int i = vitri; i < soLuong - 1; i++) {
                dsChuyenBay[i] = dsChuyenBay[i + 1];
            }
            dsChuyenBay = Arrays.copyOf(dsChuyenBay, soLuong - 1);
            soLuong--;

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
                System.out.println("+=====================================+");
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
                System.out.println("+=====================================+");
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

    // tìm theo mã
    public ChuyenBay tim(String ma) {
        for (int i = 0; i < dsChuyenBay.length; i++) {
            if (dsChuyenBay[i].getMaChuyenBay().equals(ma)) {
                return dsChuyenBay[i];
            }
        }
        return null;
    }

    // tìm theo điểm đến
    public ChuyenBay[] timDiemDen(String diemDen){
        ChuyenBay[] ds = new ChuyenBay[0];
        int j = 0;
        for (int i = 0; i < dsChuyenBay.length; i++) {
            if(dsChuyenBay[i].getDiemDen().equals(diemDen)){
                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = new ChuyenBay();
                ds[j] = dsChuyenBay[i];
                j++;
            }
        }
            return ds;
    }

    // tim chuyen bay theo chuyến bay cùng ngày
    public ChuyenBay[] dsNgay(String ngayKhoiHanh) {
        ChuyenBay[] ds = new ChuyenBay[0];
        int j = 0;
        for (int i = 0; i < dsChuyenBay.length; i++) {
            if (dsChuyenBay[i].getNgayKhoiHanh().equals(ngayKhoiHanh)) {
                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = new ChuyenBay();
                ds[j] = dsChuyenBay[i];
                j++;
            }
        }
        return ds;
    }

    // tìm theo  tình trạng chuyến bay
    public ChuyenBay[] dsTinhTrang(String tinhtrang) {
        ChuyenBay[] ds = new ChuyenBay[0];
        int j = 0;
        for (int i = 0; i < dsChuyenBay.length; i++) {
            if (dsChuyenBay[i].getTinhTrang().equalsIgnoreCase(tinhtrang)) {
                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = new ChuyenBay();
                ds[j] = dsChuyenBay[i];
                j++;
            }
        }
        return ds;
    }
    
     // tìm vị trí
    public int timViTri(String ma) {
        for (int i = 0; i < dsChuyenBay.length; i++) {
            if (dsChuyenBay[i].getMaChuyenBay().equals(ma)) {
                return i;
            }
        }
        return -1;
    }


}
