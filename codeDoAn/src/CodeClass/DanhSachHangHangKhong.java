package CodeClass;

import java.util.Arrays;
import java.util.Scanner;

public class DanhSachHangHangKhong {

    private HangHangKhong[] dshanghangkhong;
    private int soluong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachHangHangKhong() {
        dshanghangkhong = new HangHangKhong[0];
        soluong = 0;
    }

    public DanhSachHangHangKhong(HangHangKhong[] dshanghangkhong, int soluong) {
        this.dshanghangkhong = dshanghangkhong;
        this.soluong = soluong;
    }

    public DanhSachHangHangKhong(DanhSachHangHangKhong ds) {
        dshanghangkhong = ds.dshanghangkhong;
        soluong = ds.soluong;
    }

    public void nhapDS() {
        int sl;
        System.out.print("Nhap so luong hang hang khong: ");
        sl = sc.nextInt();
        soluong = sl;
        for (int i = 0; i < dshanghangkhong.length; i++) {
            String ma;
            System.out.print("Nhap ma hang hang khong: ");
            ma = sc.nextLine();
            if (tim(ma) == null) {
                dshanghangkhong = Arrays.copyOf(dshanghangkhong, i + 1);
                dshanghangkhong[i] = new HangHangKhong();
                dshanghangkhong[i].nhapHangHangKhong();
            } else {
                i--;
            }
        }
    }

    public void xuatDS() {
        for (int i = 0; i < dshanghangkhong.length; i++) {
            dshanghangkhong[i].xuatHangHangKhong();
        }
    }

    // them
    // khong tham so
    public void them() {
        String ma;
        System.out.print("Nhap ma hang hang khong: ");
        ma = sc.nextLine();
        if (tim(ma) == null) {
            dshanghangkhong = Arrays.copyOf(dshanghangkhong, soluong + 1);
            dshanghangkhong[soluong] = new HangHangKhong();
            dshanghangkhong[soluong].nhapHangHangKhong();
            soluong++;
            System.out.println("Them thanh cong");
        } else {
            System.out.println("Hang hang khong da ton tai!!");
        }
    }

    // co tham so
    public void them(String ma) {
        if (tim(ma) == null) {
            dshanghangkhong = Arrays.copyOf(dshanghangkhong, soluong + 1);
            dshanghangkhong[soluong] = new HangHangKhong();
            dshanghangkhong[soluong].xuatHangHangKhong();
            soluong++;
            System.out.println("Them thanh cong");
        } else {
            System.out.println("Hang hang khong da ton tai!!");
        }
    }

    // xoa hang hang khong
    // khong tham so
    public void xoa() {
        String ma;
        System.out.print("Nhap ma hang hang khong: ");
        ma = sc.nextLine();
        int vitri = timViTri(ma);
        if (vitri != -1) {
            for (int i = vitri; i < dshanghangkhong.length; i++) {
                dshanghangkhong[i] = dshanghangkhong[i + 1];
            }
            dshanghangkhong = Arrays.copyOf(dshanghangkhong, soluong - 1);
            soluong--;
            System.out.println("Xoa thanh cong");
        } else
            System.out.println("Khong tim thay vi tri cua hang hang khong");
    }
    
    // xóa có tham số
    public void xoa(String ma){
        int vitri = timViTri(ma);
        if (vitri != -1) {
            for (int i = vitri; i < dshanghangkhong.length; i++) {
                dshanghangkhong[i] = dshanghangkhong[i + 1];
            }
            dshanghangkhong = Arrays.copyOf(dshanghangkhong, soluong - 1);
            soluong--;
            System.out.println("Xoa thanh cong");
        } else
            System.out.println("Khon tim thay vi tri cua hang hang khong");
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
            dshanghangkhong[vitri].setTenHang(tenMoi);
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
            dshanghangkhong[vitri].setTenHang(tenMoi);
            System.out.println("Da sua ten hang hang khong thanh cong!");
        } else {
            System.out.println("Khong tim thay hang hang khong can sua!");
        }
    }

    // tim ma hang hang khong
    // khong tham so
    public HangHangKhong tim() {
        String ma;
        System.out.print("Nhap ma may bay: ");
        ma = sc.nextLine();
        for (int i = 0; i < dshanghangkhong.length; i++) {
            if (dshanghangkhong[i].getMaHang().equals(ma)) {
                return dshanghangkhong[i];
            }
        }
        return null;
    }

    // co tham so
    public HangHangKhong tim(String ma) {
        for (int i = 0; i < dshanghangkhong.length; i++) {
            if (dshanghangkhong[i].getMaHang().equals(ma)) {
                return dshanghangkhong[i];
            }
        }
        return null;
    }

    // tra ve vi tri
    public int timViTri(String ma) {
        for (int i = 0; i < dshanghangkhong.length; i++) {
            if (dshanghangkhong[i].getMaHang().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    public HangHangKhong[] dsTenHang(String ma) {
        HangHangKhong[] ds = new HangHangKhong[0];
        int j = 0;
        for (int i = 0; i < ds.length; i++) {
            if (dshanghangkhong[i].getTenHang().equals(ma)) {
                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = new HangHangKhong();
                ds[j] = dshanghangkhong[i];
                j++;
            }
        }
        return ds;
    }
}
