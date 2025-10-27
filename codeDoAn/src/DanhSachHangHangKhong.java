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
            System.out.println("Đã sửa tên hãng hàng không thành công!");
        } else {
            System.out.println("Không tìm thấy hãng hàng không cần sửa!");
        }
    }

// sửa có tham số
    public void sua(String ma) {
        int vitri = timViTri(ma);
        if (vitri != -1) {
            System.out.print("Nhập tên hãng hàng không mới: ");
            String tenMoi = sc.nextLine();
            dshanghangkhong[vitri].setTenHang(tenMoi);
            System.out.println("Đã sửa tên hãng hàng không thành công!");
        } else {
            System.out.println("Không tìm thấy hãng hàng không cần sửa!");
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
        System.out.println("+------------------Danh sách Hãng Hàng Không------------------+");
        System.out.println("|  1. Nhập danh sách hãng hàng không                         |");
        System.out.println("|  2. Thêm 1 hãng hàng không                                 |");
        System.out.println("|  3. Xóa 1 hãng hàng không                                  |");
        System.out.println("|  4. Sửa thông tin hãng hàng không                          |");
        System.out.println("|  5. Tìm hãng hàng không                                    |");
        System.out.println("|  6. Xuất danh sách hãng hàng không                         |");
        System.out.println("+-------------------------------------------------------------+");
    }

    public void choice() {
        String c;
        boolean nhapSai;

        do {
            nhapSai = false;
            menu();
            System.out.print("Mời chọn chức năng (0 để thoát): ");
            c = sc.next();

            switch (c) {
                case "0":
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;

                case "1": // Nhập DS
                    nhapDS();
                    break;

                case "2": // Thêm Hãng
                    System.out.println("+----------- Thêm Hãng Hàng Không -----------+");
                    System.out.println("|  1. Thêm hãng không có tham số             |");
                    System.out.println("|  2. Thêm hãng có tham số                   |");
                    System.out.println("+--------------------------------------------+");
                    System.out.print("Chọn kiểu thêm: ");
                    String t = sc.next();
                    sc.nextLine(); // bỏ Enter

                    if (t.equals("1")) {
                        them();
                    } else if (t.equals("2")) {
                        System.out.print("Nhập mã hãng muốn thêm: ");
                        String ma = sc.nextLine();
                        them(ma);
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case "3": // Xóa Hãng
                    System.out.println("+------------ Xóa Hãng Hàng Không -----------+");
                    System.out.println("|  1. Xóa hãng không có tham số              |");
                    System.out.println("|  2. Xóa hãng có tham số                    |");
                    System.out.println("+--------------------------------------------+");
                    System.out.print("Chọn kiểu xóa: ");
                    String x = sc.next();
                    sc.nextLine();

                    if (x.equals("1")) {
                        xoa();
                    } else if (x.equals("2")) {
                        System.out.print("Nhập mã hãng cần xóa: ");
                        String ma = sc.nextLine();
                        int vt = timViTri(ma);
                        if (vt != -1) {
                            for (int i = vt; i < dshanghangkhong.length - 1; i++) {
                                dshanghangkhong[i] = dshanghangkhong[i + 1];
                            }
                            dshanghangkhong = Arrays.copyOf(dshanghangkhong, soluong - 1);
                            soluong--;
                            System.out.println("Đã xóa hãng hàng không thành công!");
                        } else {
                            System.out.println("Không tìm thấy hãng cần xóa!");
                        }
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case "4": // Sửa Hãng
                    System.out.println("+------------ Sửa Hãng Hàng Không -----------+");
                    System.out.println("|  1. Sửa hãng không có tham số              |");
                    System.out.println("|  2. Sửa hãng có tham số                    |");
                    System.out.println("+--------------------------------------------+");
                    System.out.print("Chọn kiểu sửa: ");
                    String s = sc.next();
                    sc.nextLine();

                    if (s.equals("1")) {
                        sua();
                    } else if (s.equals("2")) {
                        System.out.print("Nhập mã hãng cần sửa: ");
                        String ma = sc.nextLine();
                        sua(ma);
                    } else {
                        System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case "5": // Tìm Hãng
                    System.out.println("+------------ Tìm Hãng Hàng Không -----------+");
                    System.out.println("|  1. Tìm hãng không có tham số              |");
                    System.out.println("|  2. Tìm hãng có tham số                    |");
                    System.out.println("|  3. Tìm vị trí hãng                        |");
                    System.out.println("+--------------------------------------------+");
                    System.out.print("Chọn kiểu tìm: ");
                    String tm = sc.next();
                    sc.nextLine();

                    switch (tm) {
                        case "1":
                            HangHangKhong h1 = tim();
                            if (h1 != null) {
                                h1.outputHangHangKhong();
                            } else {
                                System.out.println("Không tìm thấy hãng hàng không!");
                            }
                            break;

                        case "2":
                            System.out.print("Nhập mã hãng cần tìm: ");
                            String ma = sc.nextLine();
                            HangHangKhong h2 = tim(ma);
                            if (h2 != null) {
                                h2.outputHangHangKhong();
                            } else {
                                System.out.println("Không tìm thấy hãng hàng không!");
                            }
                            break;

                        case "3":
                            System.out.print("Nhập mã hãng cần tìm vị trí: ");
                            String maVT = sc.nextLine();
                            int vt = timViTri(maVT);
                            if (vt != -1) {
                                System.out.println("Hãng hàng không ở vị trí: " + vt);
                            } else {
                                System.out.println("Không tìm thấy hãng hàng không!");
                            }
                            break;

                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                    break;

                case "6": // Xuất DS
                    System.out.println("+------------ Danh Sách Hãng Hàng Không -----------+");
                    xuatDS();
                    System.out.println("+--------------------------------------------------+");
                    break;

                default:
                    System.out.println("Chọn không đúng, hãy chọn lại chức năng (0-6)");
                    nhapSai = true;
            }

            if (!nhapSai && !c.equals("0")) {
                System.out.println("Bạn có muốn thoát chương trình?");
                System.out.println("Nếu có -> (0) | Thao tác tiếp -> (1-6)");
            }

        } while (!c.equals("0"));
    }

}
