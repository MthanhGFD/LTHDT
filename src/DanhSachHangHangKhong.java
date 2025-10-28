package src;

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
                dshanghangkhong[i].inputHangHangKhong();
            } else {
                i--;
            }
        }
    }

    public void xuatDS() {
        for (int i = 0; i < dshanghangkhong.length; i++) {
            dshanghangkhong[i].outputHangHangKhong();
        }
    }

    // thêm
    // không tham số
    public void them() {
        String ma;
        System.out.print("Nhap ma hang hang khong: ");
        ma = sc.nextLine();
        if (tim(ma) == null) {
            dshanghangkhong = Arrays.copyOf(dshanghangkhong, soluong + 1);
            dshanghangkhong[soluong] = new HangHangKhong();
            dshanghangkhong[soluong].inputHangHangKhong();
            soluong++;
        } else {
            System.out.println("Hang hang khong da ton tai!!");
        }
    }

    // có tham số
    public void them(String ma) {
        if (tim(ma) == null) {
            dshanghangkhong = Arrays.copyOf(dshanghangkhong, soluong + 1);
            dshanghangkhong[soluong] = new HangHangKhong();
            dshanghangkhong[soluong].inputHangHangKhong();
            soluong++;
        } else {
            System.out.println("Hang hang khong da ton tai!!");
        }
    }

    // xóa hãng hàng không
    // không tham số
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
        }
    }

    // sửa
    // sửa không tham số
    public void sua() {
        System.out.print("Nhap ma hang hang khong: ");
        String ma = sc.nextLine();
        int vitri = timViTri(ma);
        if (vitri != -1) {
            System.out.print("Nhap ten hang hang khong: ");
            String tenMoi = sc.nextLine();
            dshanghangkhong[vitri].setTenHang(tenMoi);
            System.out.println("Đa sua ten hang hang khong.");
        } else {
            System.out.println("Khong tim thay hang hang khong.");
        }
    }

// sửa có tham số
    public void sua(String ma) {
        int vitri = timViTri(ma);
        if (vitri != -1) {
            System.out.print("Nhap ten hang hang khong moi: ");
            String tenMoi = sc.nextLine();
            dshanghangkhong[vitri].setTenHang(tenMoi);
            System.out.println("Đa sua ten hang hang khong.");
        } else {
            System.out.println("Khong tim thay hang hang khong.");
        }
    }

    // tìm mã hãng hàng không
    // không tham số
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

    // có tham số
    public HangHangKhong tim(String ma) {
        for (int i = 0; i < dshanghangkhong.length; i++) {
            if (dshanghangkhong[i].getMaHang().equals(ma)) {
                return dshanghangkhong[i];
            }
        }
        return null;
    }

    // trả về vị trí
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

    public void menu() {
        System.out.println("+------------------DANH SACH HANG HANG KHONG------------------+");
        System.out.println("|  1. Nhap danh sach hang hang khong                         |");
        System.out.println("|  2. Them 1 hang hang khong                                 |");
        System.out.println("|  3. Xoa 1 hang hang khong                                  |");
        System.out.println("|  4. Sua thong tin hang hang khong                          |");
        System.out.println("|  5. Tim hang hang khong                                    |");
        System.out.println("|  6. Xuat danh sach hang hang khong                         |");
        System.out.println("|  0. Thoat                                                  |");
        System.out.println("+-------------------------------------------------------------+");
    }

    public void choice() {
        String c;
        boolean nhapSai;

        do {
            nhapSai = false;
            menu();
            System.out.print("Moi chon chuc nang: ");
            c = sc.next();

            switch (c) {
                case "0":
                    System.out.println("Da thoat chuong trinh.");
                    break;

                case "1": // Nhập DS
                    nhapDS();
                    break;

                case "2": // Thêm Hãng
                    System.out.println("+----------- THEM HANG HANG KHONG -----------+");
                    System.out.println("|  1. Thêm hang khong co tham so             |");
                    System.out.println("|  2. Thêm hang co tham so                   |");
                    System.out.println("+--------------------------------------------+");
                    System.out.print("Chon kieu them: ");
                    String t = sc.next();
                    sc.nextLine(); // bỏ Enter

                    if (t.equals("1")) {
                        them();
                    } else if (t.equals("2")) {
                        System.out.print("Nhap ma hang hang khong: ");
                        String ma = sc.nextLine();
                        them(ma);
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;

                case "3": // Xóa Hãng
                    System.out.println("+------------ XOA HANG HANG KHONG -----------+");
                    System.out.println("|  1. Xoa hang khong co tham so              |");
                    System.out.println("|  2. Xóa hang co tham so                    |");
                    System.out.println("+--------------------------------------------+");
                    System.out.print("Chon kieu xoa: ");
                    String x = sc.next();
                    sc.nextLine();

                    if (x.equals("1")) {
                        xoa();
                    } else if (x.equals("2")) {
                        System.out.print("Nhap ma hang can xoa: ");
                        String ma = sc.nextLine();
                        int vt = timViTri(ma);
                        if (vt != -1) {
                            for (int i = vt; i < dshanghangkhong.length - 1; i++) {
                                dshanghangkhong[i] = dshanghangkhong[i + 1];
                            }
                            dshanghangkhong = Arrays.copyOf(dshanghangkhong, soluong - 1);
                            soluong--;
                            System.out.println("Đa xoa hang hang khong.");
                        } else {
                            System.out.println("Khong tim thay hang can xoa");
                        }
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;

                case "4": // Sửa Hãng
                    System.out.println("+------------ SUA HANG HANG KHONG -----------+");
                    System.out.println("|  1. Sua hang khong co tham so              |");
                    System.out.println("|  2. Sua hang co tham so                    |");
                    System.out.println("+--------------------------------------------+");
                    System.out.print("Chon kieu sua: ");
                    String s = sc.next();
                    sc.nextLine();

                    if (s.equals("1")) {
                        sua();
                    } else if (s.equals("2")) {
                        System.out.print("Nhap ma hang can sua: ");
                        String ma = sc.nextLine();
                        sua(ma);
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;

                case "5": // Tìm Hãng
                    System.out.println("+------------ TIM HANG HANG KHONG -----------+");
                    System.out.println("|  1. Tim hang khong co tham so              |");
                    System.out.println("|  2. Tim hang co tham so                    |");
                    System.out.println("|  3. Tim vi tri hang                        |");
                    System.out.println("+--------------------------------------------+");
                    System.out.print("Chon kieu tim: ");
                    String tm = sc.next();
                    sc.nextLine();

                    switch (tm) {
                        case "1":
                            HangHangKhong h1 = tim();
                            if (h1 != null) {
                                h1.outputHangHangKhong();
                            } else {
                                System.out.println("Khong tim thay hang hang khong.");
                            }
                            break;

                        case "2":
                            System.out.print("Nhap ma hang can tim: ");
                            String ma = sc.nextLine();
                            HangHangKhong h2 = tim(ma);
                            if (h2 != null) {
                                h2.outputHangHangKhong();
                            } else {
                                System.out.println("Khong tim thay hang hang khong.");
                            }
                            break;

                        case "3":
                            System.out.print("Nhap ma hang can tim vi tri: ");
                            String maVT = sc.nextLine();
                            int vt = timViTri(maVT);
                            if (vt != -1) {
                                System.out.println("Hang hang khong o vi tri: " + vt);
                            } else {
                                System.out.println("Khong tim thay hang hang khong.");
                            }
                            break;

                        default:
                            System.out.println("Lua chon khong hop le.");
                    }
                    break;

                case "6": // Xuất DS
                    System.out.println("+------------ DANH SACH HANG HANG KHONG -----------+");
                    xuatDS();
                    System.out.println("+--------------------------------------------------+");
                    break;

                default:
                    System.out.println("Chon khong hop le, moi chon lai (0-6)");
                    nhapSai = true;
            }

            if (!nhapSai && !c.equals("0")) {
                System.out.println("Ban co muon thoat?");
                System.out.println("Thoat (0) | Thao tac tiep -> (1-6)");
            }

        } while (!c.equals("0"));
    }

}