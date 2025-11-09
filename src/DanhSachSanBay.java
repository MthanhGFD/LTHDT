package src;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachSanBay {

    private SanBay[] dsSanBay;
    private int soLuong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachSanBay() {
        dsSanBay = new SanBay[0];
        soLuong = 0;
    }

    public DanhSachSanBay(SanBay[] dsSanBay, int soLuong) {
        this.dsSanBay = dsSanBay;
        this.soLuong = soLuong;
    }

    public DanhSachSanBay(DanhSachSanBay ds) {
        dsSanBay = ds.dsSanBay;
        soLuong = ds.soLuong;
    }

    // nhập danh sách sân bay
    public void nhapDS() {
        int sl;
        System.out.print("Nhap so luong san bay: ");
        sl = sc.nextInt();
        sc.nextLine();
        soLuong = sl;
        dsSanBay = new SanBay[soLuong];
        for (int i = 0; i < soLuong; i++) {
            String ma;
            System.out.println("Nhap ma san bay: ");
            ma = sc.nextLine();
            if (tim(ma) == null) {
                dsSanBay[i] = new SanBay();
                dsSanBay[i].setMaSanBay(ma);
                dsSanBay[i].nhapSanBay();
            } else {
                i--;
            }

        }
    }

    // xuất danh sách sân bay
    public void xuatDS() {
        System.out.println("             ================== Danh Sach San Bay ==================");
        System.out.println("+-----------------+--------------------------------+---------------------------+");
        System.out.println("|   Ma san bay    |          Ten san bay           |         Dia diem          |");
        System.out.println("+-----------------+--------------------------------+---------------------------+");
        for (int i = 0; i < dsSanBay.length; i++) {
            dsSanBay[i].xuatSanBay();
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
                dsSanBay[i].setMaSanBay(tokens[0]);
                dsSanBay[i].setTenSanBay(tokens[1]);
                dsSanBay[i].setDiaDiem(tokens[2]);
                i++;
            }
            f.close();
            soLuong = i;
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
    }
    
    // ghi danh sách mới lên file
    public void ghiFile(){
        try {
            FileWriter fw = new FileWriter("dsSanBay.txt");
            for (int i = 0; i < dsSanBay.length; i++) {
                fw.write(dsSanBay[i].toString() + "\n");
            }
            fw.close();
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
            dsSanBay = Arrays.copyOf(dsSanBay, soLuong + 1);
            dsSanBay[soLuong] = new SanBay();
            dsSanBay[soLuong].nhapSanBay();
            soLuong++;
        } else {
            System.out.println("San bay da ton tai!!");
        }
    }

    // thêm sân bay - có tham số
    public void them(SanBay sb) {
        if (tim(sb.getMaSanBay()) == null) {
            dsSanBay = Arrays.copyOf(dsSanBay, soLuong + 1);
            dsSanBay[soLuong] = new SanBay();
            dsSanBay[soLuong].nhapSanBay();
            soLuong++;
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
            for (int i = vitri; i < dsSanBay.length - 1; i++) {
                dsSanBay[i] = dsSanBay[i + 1];
            }
            dsSanBay = Arrays.copyOf(dsSanBay, soLuong - 1);
            soLuong--;
        } else {
            System.out.println("Khong tim thay san bay can xoa!");
        }
    }

    // xóa sân bay - có tham số
    public void xoa(String ma) {
        int vitri = timViTri(ma);
        if (vitri != -1) {
            for (int i = vitri; i < dsSanBay.length - 1; i++) {
                dsSanBay[i] = dsSanBay[i + 1];
            }
            dsSanBay = Arrays.copyOf(dsSanBay, soLuong - 1);
            soLuong--;
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
            dsSanBay[vitri].setTenSanBay(tenMoi);
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
            dsSanBay[vitri].setTenSanBay(tenMoi);
            System.out.println("Da sua ten san bay thanh cong!");
        } else {
            System.out.println("Khong tim thay san bay can sua!");
        }
    }

    // tìm sân bay - có tham số
    public SanBay tim(String ma) {
        for (int i = 0; i < dsSanBay.length; i++) {
            if (dsSanBay[i].getMaSanBay().equals(ma)) {
                return dsSanBay[i];
            }
        }
        return null;
    }

    // tìm sân bay theo tên
    public SanBay timTen(String ten){
        for (int i = 0; i < dsSanBay.length; i++) {
            if (dsSanBay[i].getMaSanBay().equals(ten)) {
                return dsSanBay[i];
            }
        }
        return null;
    }
    
    // tìm sân bay theo địa điểm (tỉnh/ thành phố)
    public SanBay timTinh(String tinh){
        for (int i = 0; i < dsSanBay.length; i++) {
            if (dsSanBay[i].getMaSanBay().equals(tinh)) {
                return dsSanBay[i];
            }
        }
        return null;
    }
    
    // tìm vị trí
    public int timViTri(String ma) {
        for (int i = 0; i < dsSanBay.length; i++) {
            if (dsSanBay[i].getMaSanBay().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

}
