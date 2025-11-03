package CodeClass;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanBay {

    private SanBay[] dssanbay;
    private int soluong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachSanBay() {
        dssanbay = new SanBay[0];
        soluong = 0;
    }

    public DanhSachSanBay(String dssanbay, int soluong) {
        this.dssanbay = this.dssanbay;
        this.soluong = soluong;
    }

    public DanhSachSanBay(DanhSachSanBay ds) {
        dssanbay = ds.dssanbay;
        soluong = ds.soluong;
    }

    // nhập danh sách sân bay
    public void nhapDS() {
        int sl;
        System.out.print("Nhap so luong san bay: ");
        sl = sc.nextInt();
        sc.nextLine();
        soluong = sl;
        dssanbay = new SanBay[soluong];
        for (int i = 0; i < soluong; i++) {
            String ma;
            System.out.println("Nhap ma san bay: ");
            ma = sc.nextLine();
            if (tim(ma) == null) {
                dssanbay[i] = new SanBay();
                dssanbay[i].nhapSanBay();
            } else {
                i--;
            }

        }
    }

    // xuất danh sách sân bay
    public void xuatDS() {
        System.out.println("+-----------------+--------------------------------+---------------------------+");
        System.out.println("|   Ma san bay    |          Ten san bay           |         Dia diem          |");
        System.out.println("+-----------------+--------------------------------+---------------------------+");
        for (int i = 0; i < dssanbay.length; i++) {
            dssanbay[i].xuatSanBay();
        }
        System.out.println("+-----------------+--------------------------------+---------------------------+");
    }

    // đọc file
    public void docFile() {
        int i = 0;
        try {
            FileReader f = new FileReader("dsSanBay.txt");
            Scanner docf = new Scanner(f);
            while (docf.hasNextLine()) {
                String line = docf.nextLine();
                String tokens[] = line.split(",");
                dssanbay[i].setMaSanBay(tokens[0]);
                dssanbay[i].setTenSanBay(tokens[1]);
                dssanbay[i].setDiaDiem(tokens[2]);
                i++;
            }
            f.close();
            soluong = i;
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
    }

    // ghi file
    public void ghiFile(SanBay sanbay) {
        try {
            FileWriter f = new FileWriter("dsSanBay.txt", true);
            dssanbay = Arrays.copyOf(dssanbay, soluong + 1);
            dssanbay[soluong] = new SanBay();
            dssanbay[soluong] = sanbay;
            f.write(sanbay.toString());
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("khong tim thay file");
        } catch (IOException e) {
            System.out.println("lỗi ghi file");
        }

    }

    // thêm sân bay - không tham số
    public void them() {
        String ma;
        System.out.print("Nhap ma san bay: ");
        ma = sc.nextLine();
        if (tim(ma) == null) {
            dssanbay = Arrays.copyOf(dssanbay, soluong + 1);
            dssanbay[soluong] = new SanBay();
            dssanbay[soluong].nhapSanBay();
            ghiFile(dssanbay[soluong]);
            soluong++;
        } else {
            System.out.println("San bay da ton tai!!");
        }
    }

    // thêm sân bay - có tham số
    public void them(String ma) {
        if (tim(ma) == null) {
            dssanbay = Arrays.copyOf(dssanbay, soluong + 1);
            dssanbay[soluong] = new SanBay();
            dssanbay[soluong].nhapSanBay();
            ghiFile(dssanbay[soluong]);
            soluong++;
        } else {
            System.out.println("San bay da ton tai!!");
        }
    }

    // xóa sân bay - không tham số
    public void xoa() {
        System.out.print("Nhap ma san bay can xoa: ");
        String ma = sc.nextLine();
        int vitri = timViTri(ma);
        if (vitri != -1) {
            for (int i = vitri; i < dssanbay.length - 1; i++) {
                dssanbay[i] = dssanbay[i + 1];
            }
            dssanbay = Arrays.copyOf(dssanbay, soluong - 1);
            soluong--;
        } else {
            System.out.println("Khong tim thay san bay can xoa!");
        }
    }

    // xóa sân bay - có tham số
    public void xoa(String ma) {
        int vitri = timViTri(ma);
        if (vitri != -1) {
            for (int i = vitri; i < dssanbay.length - 1; i++) {
                dssanbay[i] = dssanbay[i + 1];
            }
            dssanbay = Arrays.copyOf(dssanbay, soluong - 1);
            soluong--;
        } else {
            System.out.println("Khong tim thay san bay can xoa!");
        }
    }

    // sửa tên sân bay - không tham số
    public void sua() {
        System.out.print("Nhap ma san bay can sua: ");
        String ma = sc.nextLine();
        int vitri = timViTri(ma);
        if (vitri != -1) {
            System.out.print("Nhap ten san bay moi: ");
            String tenMoi = sc.nextLine();
            dssanbay[vitri].setTenSanBay(tenMoi);
            System.out.println("Da sua ten san bay thanh cong!");
        } else {
            System.out.println("Khong tim thay san bay can sua!");
        }
    }

    // sửa tên sân bay - có tham số
    public void sua(String ma) {
        int vitri = timViTri(ma);
        if (vitri != -1) {
            System.out.print("Nhap ten san bay moi: ");
            String tenMoi = sc.nextLine();
            dssanbay[vitri].setTenSanBay(tenMoi);
            System.out.println("Da sua ten san bay thanh cong!");
        } else {
            System.out.println("Khong tim thay san bay can sua!");
        }
    }

    // tìm sân bay - không tham số
    public SanBay tim() {
        System.out.print("Nhap ma san bay: ");
        String ma = sc.nextLine();
        for (int i = 0; i < dssanbay.length; i++) {
            if (dssanbay[i].getMaSanBay().equals(ma)) {
                return dssanbay[i];
            }
        }
        return null;
    }

    // tìm sân bay - có tham số
    public SanBay tim(String ma) {
        for (int i = 0; i < dssanbay.length; i++) {
            if (dssanbay[i].getMaSanBay().equals(ma)) {
                return dssanbay[i];
            }
        }
        return null;
    }

    // tìm vị trí
    public int timViTri(String ma) {
        for (int i = 0; i < dssanbay.length; i++) {
            if (dssanbay[i].getMaSanBay().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

}
