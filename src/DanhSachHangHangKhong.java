package src;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachHangHangKhong {

    private HangHangKhong[] dsHangHangKhong;
    private int soLuong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachHangHangKhong() {
        dsHangHangKhong = new HangHangKhong[0];
        soLuong = 0;
    }

    public DanhSachHangHangKhong(HangHangKhong[] dsHangHangKhong, int soLuong) {
        this.dsHangHangKhong = dsHangHangKhong;
        this.soLuong = soLuong;
    }

    public DanhSachHangHangKhong(DanhSachHangHangKhong ds) {
        dsHangHangKhong = ds.dsHangHangKhong;
        soLuong = ds.soLuong;
    }

    public void docFile() {
        int i = 0;
        try {
            FileReader f = new FileReader("dsHangHangKhong.txt");
            Scanner fr = new Scanner(f);
            while (fr.hasNextLine()) {
                String line = fr.nextLine();
                String tokens[] = line.split(",");
                dsHangHangKhong[i].setMaHang(tokens[0]);
                dsHangHangKhong[i].setTenHang(tokens[1]);
                dsHangHangKhong[i].setQuocGia(tokens[2]);
                i++;
            }
            soLuong = i;
            f.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (IOException e) {
            System.out.println("Loi doc file");
        }
    }

    public void ghiFile() {
        try {
            FileWriter fw = new FileWriter("dsHangHangKhong.txt");
            for (int i = 0; i < dsHangHangKhong.length; i++) {
                fw.write(dsHangHangKhong[i].toString() + "\n");
            }
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("khong tim thay file");
        } catch (IOException e) {
            System.out.println("Loi doc file");
        }
    }

    public void xuatDS() {
        System.out.println("          ================== Danh Sach Hang Hang Khong ==================");
        System.out.println("+-----------------+-------------------------------------+---------------------------+");
        System.out.println("|     Ma Hang     |              Ten hang               |         Quoc gia          |");
        System.out.println("+-----------------+-------------------------------------+---------------------------+");
        for (int i = 0; i < dsHangHangKhong.length; i++) {
            dsHangHangKhong[i].xuatHangHangKhong();
        }
        System.out.println("+-----------------+-------------------------------------+---------------------------+");
    }

    // them
    // khong tham so
    public void them() {
        String ma;
        System.out.print("Nhap ma hang hang khong: ");
        ma = sc.nextLine();
        if (tim(ma) == null) {
            dsHangHangKhong = Arrays.copyOf(dsHangHangKhong, soLuong + 1);
            dsHangHangKhong[soLuong] = new HangHangKhong();
            dsHangHangKhong[soLuong].nhapHangHangKhong();
            soLuong++;
            System.out.println("Them thanh cong");
        } else {
            System.out.println("Hang hang khong da ton tai!!");
        }
    }

    // co tham so
    public void them(HangHangKhong hhk) {
        dsHangHangKhong = Arrays.copyOf(dsHangHangKhong, soLuong + 1);
        dsHangHangKhong[soLuong] = new HangHangKhong();
        dsHangHangKhong[soLuong] = hhk;
        soLuong++;
    }

    // xoa hang hang khong
    // khong tham so
    public void xoa() {
        String ma;
        System.out.print("Nhap ma hang hang khong: ");
        ma = sc.nextLine();
        int vitri = timViTri(ma);
        if (vitri != -1) {
            for (int i = vitri; i < dsHangHangKhong.length; i++) {
                dsHangHangKhong[i] = dsHangHangKhong[i + 1];
            }
            dsHangHangKhong = Arrays.copyOf(dsHangHangKhong, soLuong - 1);
            soLuong--;
            System.out.println("Xoa thanh cong");
        } else {
            System.out.println("Khong tim thay vi tri cua hang hang khong");
        }
    }

    // xóa có tham số
    public void xoa(String ma) {
        int vitri = timViTri(ma);
        if (vitri != -1) {
            for (int i = vitri; i < dsHangHangKhong.length; i++) {
                dsHangHangKhong[i] = dsHangHangKhong[i + 1];
            }
            dsHangHangKhong = Arrays.copyOf(dsHangHangKhong, soLuong - 1);
            soLuong--;
            System.out.println("Xoa thanh cong");
        } else {
            System.out.println("Khon tim thay vi tri cua hang hang khong");
        }
    }

    // sua
    // sua khong tham so
    public void sua() {
        System.out.print("Nhap ma hang hang khong: ");
        String ma = sc.nextLine();
        int vitri = timViTri(ma);
        if (vitri != -1) {
            System.out.print("Nhap ten hang hang khong moi: ");
            String tenMoi = sc.nextLine();
            dsHangHangKhong[vitri].setTenHang(tenMoi);
            System.out.println("Da sua ten hang hang khong thanh cong!");
        } else {
            System.out.println("Khong tim thay hang hang khong can sua!");
        }
    }

    // sua co tham so
    public void sua(String ma) {
        int vitri = timViTri(ma);
        if (vitri != -1) {
            System.out.print("Nhap ten hang hang khong moi: ");
            String tenMoi = sc.nextLine();
            dsHangHangKhong[vitri].setTenHang(tenMoi);
            System.out.println("Da sua ten hang hang khong thanh cong!");
        } else {
            System.out.println("Khong tim thay hang hang khong can sua!");
        }
    }

    // tim ma hang hang khong

    // co tham so
    public HangHangKhong tim(String ma) {
        for (int i = 0; i < dsHangHangKhong.length; i++) {
            if (dsHangHangKhong[i].getMaHang().equals(ma)) {
                return dsHangHangKhong[i];
            }
        }
        return null;
    }
    
    // tìm theo tên hãng
    public HangHangKhong timTheoTen(String tenHang){
        for (int i = 0; i < dsHangHangKhong.length; i++) {
            if (dsHangHangKhong[i].getMaHang().equals(tenHang)) {
                return dsHangHangKhong[i];
            }
        }
        return null;
    }
    
    // tìm theo quốc gia
    public HangHangKhong[] timTheoQuocGia(String quocGia){
        HangHangKhong[] dsHang = new HangHangKhong[0];
        int j = 0;
        for (int i = 0; i < dsHang.length; i++) {
            if(dsHangHangKhong[i].getQuocGia().equals(quocGia)){
                dsHang = Arrays.copyOf(dsHang, j + 1);
                dsHang[j] = new HangHangKhong();
                dsHang[j] = dsHangHangKhong[i];
                j++;
            }
        }
        return dsHang;
    }

    // tra ve vi tri
    public int timViTri(String ma) {
        for (int i = 0; i < dsHangHangKhong.length; i++) {
            if (dsHangHangKhong[i].getMaHang().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    public HangHangKhong[] dsTenHang(String ma) {
        HangHangKhong[] ds = new HangHangKhong[0];
        int j = 0;
        for (int i = 0; i < ds.length; i++) {
            if (dsHangHangKhong[i].getTenHang().equals(ma)) {
                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = new HangHangKhong();
                ds[j] = dsHangHangKhong[i];
                j++;
            }
        }
        return ds;
    }

    public HangHangKhong[] getDsHangHangKhong() {
        return dsHangHangKhong;
    }

    public void setDsHangHangKhong(HangHangKhong[] dsHangHangKhong) {
        this.dsHangHangKhong = dsHangHangKhong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
