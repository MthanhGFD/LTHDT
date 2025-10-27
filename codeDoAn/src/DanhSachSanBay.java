package src;

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
        for (int i = 0; i < dssanbay.length; i++) {
            dssanbay[i].xuatSanBay();
        }
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

    // ==================== MENU ====================
    public void menu() {
        System.out.println("+----------------- QUAN LY DANH SACH SAN BAY -----------------+");
        System.out.println("|  1. Doc danh sach tu file                                  |");
        System.out.println("|  2. Nhap danh sach moi                                     |");
        System.out.println("|  3. Them san bay                                           |");
        System.out.println("|  4. Xoa san bay                                            |");
        System.out.println("|  5. Sua ten san bay                                        |");
        System.out.println("|  6. Tim san bay                                            |");
        System.out.println("|  7. Xuat danh sach ra man hinh                             |");
        System.out.println("|  0. Thoat                                                  |");
        System.out.println("+-------------------------------------------------------------+");
    }

    public void choice() {
        String c;
        boolean nhapSai = false;
        do {
            menu();
            System.out.print("Moi chon chuc nang: ");
            c = sc.next();
            sc.nextLine(); // bỏ dòng thừa sau next()

            switch (c) {
                case "0":
                    System.out.println("Cam on da su dung chuong trinh!!!");
                    break;

                case "1":
                    docFile();
                    System.out.println("Da doc danh sach tu file!");
                    break;

                case "2":
                    nhapDS();
                    break;

                case "3": {
                    String t;
                    System.out.println("+----------------- Them San Bay -----------------+");
                    System.out.println("|  1. Them san bay khong co tham so              |");
                    System.out.println("|  2. Them san bay co tham so                    |");
                    System.out.println("+------------------------------------------------+");
                    System.out.print("Chon kieu them: ");
                    t = sc.next();
                    sc.nextLine();
                    if (t.equals("1")) {
                        them();
                    } else if (t.equals("2")) {
                        SanBay sb = new SanBay("VDO", "San bay Van Don", "Quang Ninh");
                        them(sb.getMaSanBay());
                    } else {
                        System.out.println("Lua chon khong hop le!");
                    }
                    break;
                }

                case "4": {
                    String x;
                    System.out.println("+----------------- Xoa San Bay -----------------+");
                    System.out.println("|  1. Xoa san bay khong co tham so              |");
                    System.out.println("|  2. Xoa san bay co tham so                    |");
                    System.out.println("+-----------------------------------------------+");
                    System.out.print("Chon kieu xoa: ");
                    x = sc.next();
                    sc.nextLine();
                    if (x.equals("1")) {
                        xoa();
                    } else if (x.equals("2")) {
                        System.out.print("Nhap ma san bay can xoa: ");
                        String ma = sc.nextLine();
                        xoa(ma);
                    } else {
                        System.out.println("Lua chon khong hop le!");
                    }
                    break;
                }

                case "5": {
                    String s;
                    System.out.println("+----------------- Sua San Bay -----------------+");
                    System.out.println("|  1. Sua san bay khong co tham so              |");
                    System.out.println("|  2. Sua san bay co tham so                    |");
                    System.out.println("+-----------------------------------------------+");
                    System.out.print("Chon kieu sua: ");
                    s = sc.next();
                    sc.nextLine();
                    if (s.equals("1")) {
                        sua();
                    } else if (s.equals("2")) {
                        System.out.print("Nhap ma san bay can sua: ");
                        String ma = sc.nextLine();
                        sua(ma);
                    } else {
                        System.out.println("Lua chon khong hop le!");
                    }
                    break;
                }

                case "6": {
                    String tm;
                    System.out.println("+----------------- Tim San Bay -----------------+");
                    System.out.println("|  1. Tim san bay khong co tham so              |");
                    System.out.println("|  2. Tim san bay co tham so                    |");
                    System.out.println("|  3. Tim vi tri san bay                        |");
                    System.out.println("+-----------------------------------------------+");
                    System.out.print("Chon kieu tim: ");
                    tm = sc.next();
                    sc.nextLine();
                    switch (tm) {
                        case "1":
                            SanBay sb1 = tim();
                            if (sb1 != null) {
                                sb1.xuatSanBay();
                            } else {
                                System.out.println("Khong tim thay san bay!");
                            }
                            break;
                        case "2":
                            System.out.print("Nhap ma san bay can tim: ");
                            String ma = sc.nextLine();
                            SanBay sb2 = tim(ma);
                            if (sb2 != null) {
                                sb2.xuatSanBay();
                            } else {
                                System.out.println("Khong tim thay san bay!");
                            }
                            break;
                        case "3":
                            System.out.print("Nhap ma san bay can tim vi tri: ");
                            String maVT = sc.nextLine();
                            int vt = timViTri(maVT);
                            if (vt != -1) {
                                System.out.println("San bay o vi tri thu " + vt);
                            } else {
                                System.out.println("Khong tim thay vi tri!");
                            }
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                            break;
                    }
                    break;
                }

                case "7":
                    System.out.println("+----------------- Danh Sach San Bay -----------------+");
                    xuatDS();
                    System.out.println("+-----------------------------------------------------+");
                    break;

                default:
                    System.out.println("Chon khong dung, vui long chon lai (0-7)");
                    nhapSai = true;
            }

            if (!nhapSai && !c.equals("0")) {
                System.out.println("\nBan co muon thoat chuong trinh??");
                System.out.println("Neu co -> (0) | Tiep tuc -> (1-7)");
            }
        } while (!c.equals("0"));
    }

}
