package src;

import static src.DanhSachHangHangKhong.sc;
import java.util.Arrays;

public class QuanLyHangHangKhong extends QuanLyVeMayBay {

    private DanhSachHangHangKhong dsHangHangKhong;

    public QuanLyHangHangKhong() {
        dsHangHangKhong = new DanhSachHangHangKhong();
    }

    public QuanLyHangHangKhong(DanhSachHangHangKhong dsHangHangKhong) {
        this.dsHangHangKhong = dsHangHangKhong;
    }

    @Override
    public void menu() {
        System.out.println("+=====================================================+");
        System.out.println("|              DANH SACH HANG HANG KHONG              |");
        System.out.println("+=====================================================+");
        System.out.println("|  1. Nhap danh sach hang hang khong                  |");
        System.out.println("|  2. Them 1 hang hang khong                          |");
        System.out.println("|  3. Xoa 1 hang hang khong                           |");
        System.out.println("|  4. Sua thong tin hang hang khong                   |");
        System.out.println("|  5. Tim hang hang khong                             |");
        System.out.println("|  6. Xuat danh sach hang hang khong                  |");
        System.out.println("+-----------------------------------------------------+");
    }

    @Override
    public void choice() {
        String c;
        boolean nhapSai;

        do {
            nhapSai = false;
            menu();
            System.out.print("Moi chon chuc nang (0 de thoat): ");
            c = sc.next();

            switch (c) {
                case "0":
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;

                case "1":
                    dsHangHangKhong.nhapDS();
                    break;

                case "2":
                    System.out.println("+======================================================+");
                    System.out.println("|                 THEM HANG HANG KHONG                 |");
                    System.out.println("+======================================================+");
                    System.out.println("|  1. Them hang khong co tham so                       |");
                    System.out.println("|  2. Them hang co tham so                             |");
                    System.out.println("+------------------------------------------------------+");
                    System.out.print("Chon kieu them: ");
                    String t = sc.next();
                    sc.nextLine();

                    if (t.equals("1")) {
                        dsHangHangKhong.them();
                    } else if (t.equals("2")) {
                        System.out.print("Nhap ma hang muon them: ");
                        String ma = sc.nextLine();
                        dsHangHangKhong.them(ma);
                    } else {
                        System.out.println("Lua chon khong hop le!");
                    }
                    break;

                case "3":
                    System.out.println("+=================================================+");
                    System.out.println("|               XOA HANG HANG KHONG               |");
                    System.out.println("+=================================================+");
                    System.out.println("|  1. Xoa hang khong co tham so                   |");
                    System.out.println("|  2. Xoa hang co tham so                         |");
                    System.out.println("+-------------------------------------------------+");
                    System.out.print("Chon kieu xoa: ");
                    String x = sc.next();
                    sc.nextLine();

                    if (x.equals("1")) {
                        dsHangHangKhong.xoa();
                    } else if (x.equals("2")) {
                        dsHangHangKhong.xoa(sc.nextLine());
                    }
                    break;

                case "4":
                    System.out.println("+=================================================+");
                    System.out.println("|               SUA HANG HANG KHONG               |");
                    System.out.println("+=================================================+");
                    System.out.println("|  1. Sua hang khong co tham so                   |");
                    System.out.println("|  2. Sua hang co tham so                         |");
                    System.out.println("+-------------------------------------------------+");
                    System.out.print("Chon kieu sua: ");
                    String s = sc.next();
                    sc.nextLine();

                    if (s.equals("1")) {
                        dsHangHangKhong.sua();
                    } else if (s.equals("2")) {
                        System.out.print("Nhap ma hang can sua: ");
                        String ma = sc.nextLine();
                        dsHangHangKhong.sua(ma);
                    } else {
                        System.out.println("Lua chon khong hop le!");
                    }
                    break;

                case "5":
                    System.out.println("+=================================================+");
                    System.out.println("|               TIM HANG HANG KHONG               |");
                    System.out.println("+=================================================+");
                    System.out.println("|  1. Tim hang khong co tham so                   |");
                    System.out.println("|  2. Tim hang co tham so                         |");
                    System.out.println("|  3. Tim vi tri hang                             |");
                    System.out.println("+-------------------------------------------------+");
                    System.out.print("Chon kieu tim: ");
                    String tm = sc.next();
                    sc.nextLine();

                    switch (tm) {
                        case "1":
                            HangHangKhong h1 = dsHangHangKhong.tim();
                            if (h1 != null) {
                                h1.nhapHangHangKhong();
                            } else {
                                System.out.println("Khong tim thay hang hang khong!");
                            }
                            break;

                        case "2":
                            System.out.print("Nhap ma hang can tim: ");
                            String ma = sc.nextLine();
                            HangHangKhong h2 = dsHangHangKhong.tim(ma);
                            if (h2 != null) {
                                h2.xuatHangHangKhong();
                            } else {
                                System.out.println("Khong tim thay hang hang khong!");
                            }
                            break;

                        case "3":
                            System.out.print("Nhap ma hang can tim vi tri: ");
                            String maVT = sc.nextLine();
                            int vt = dsHangHangKhong.timViTri(maVT);
                            if (vt != -1) {
                                System.out.println("Hang hang khong o vi tri: " + vt);
                            } else {
                                System.out.println("Khong tim thay hang hang khong!");
                            }
                            break;

                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                    break;

                case "6":
                    System.out.println("+------------ Danh Sach Hang Hang Khong -----------+");
                    dsHangHangKhong.xuatDS();
                    System.out.println("+--------------------------------------------------+");
                    break;

                default:
                    System.out.println("Chon khong dung, hay chon lai chuc nang (0-6)");
                    nhapSai = true;
            }

            if (!nhapSai && !c.equals("0")) {
                System.out.println("Ban co muon thoat chuong trinh?");
                System.out.println("Neu co -> (0) | Thao tac tiep -> (1-6)");
            }

        } while (!c.equals("0"));
    }

}
