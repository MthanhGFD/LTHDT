package src;

import static src.DanhSachChuyenBay.sc;

public class QuanLyChuyenBay extends QuanLyVeMayBay {
    private DanhSachChuyenBay dschuyenbay;

    public QuanLyChuyenBay() {
        dschuyenbay = new DanhSachChuyenBay();
    }

    public QuanLyChuyenBay(DanhSachChuyenBay dschuyenbay) {
        this.dschuyenbay = dschuyenbay;
    }

    // ====================== MENU CHINH ======================
    @Override
    public void menu() {
        System.out.println("+========================================================+");
        System.out.println("|                   QUAN LY cHUYEN BAY                   |");
        System.out.println("+========================================================+");
        System.out.println("|  1. Doc danh sach tu file                              |");
        System.out.println("|  2. Ghi danh sach xuong file                           |");
        System.out.println("|  3. Nhap danh sach chuyen bay                          |");
        System.out.println("|  4. Them chuyen bay                                    |");
        System.out.println("|  5. Xoa chuyen bay                                     |");
        System.out.println("|  6. Sua thong tin chuyen bay                           |");
        System.out.println("|  7. Tim kiem chuyen bay                                |");
        System.out.println("|  8. Thong ke chuyen bay                                |");
        System.out.println("|  9. Xuat danh sach chuyen bay                          |");
        System.out.println("|  0. Thoat chuong trinh                                 |");
        System.out.println("+--------------------------------------------------------+");
        System.out.print("Nhap lua chon: ");
    }

    @Override
    public void choice() {
        String c;
        boolean chonsai = false;
        do {
            menu();
            c = sc.nextLine();

            switch (c) {
                case "1":
                    dschuyenbay.docFile();
                    break;
                case "2":
                    dschuyenbay.nhapDS();
                    break;

                case "3": {
                    System.out.println("+=====================================================+");
                    System.out.println("|                   THEM CHUYEN BAY                   |");
                    System.out.println("+=====================================================+");
                    System.out.println("|  1. Them khong tham so                              |");
                    System.out.println("|  2. Them co tham so                                 |");
                    System.out.println("+-----------------------------------------------------+");
                    System.out.print("Chon kieu them: ");
                    String t = sc.nextLine();
                    if (t.equals("1")) {
                        dschuyenbay.them();
                    } else if (t.equals("2")) {
                        System.out.print("Nhap ma chuyen bay: ");
                        String ma = sc.nextLine();
                        dschuyenbay.them(ma);
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;
                }

                case "4": {
                    System.out.println("+====================================================+");
                    System.out.println("|                   XOA CHUYEN BAY                   |");
                    System.out.println("+====================================================+");
                    System.out.println("|  1. Xoa khong tham so                              |");
                    System.out.println("|  2. Xoa co tham so                                 |");
                    System.out.println("+----------------------------------------------------+");
                    System.out.print("Chon kieu xoa: ");
                    String x = sc.nextLine();
                    if (x.equals("1")) {
                        dschuyenbay.xoa();
                    } else if (x.equals("2")) {
                        System.out.print("Nhap ma chuyen bay can xoa: ");
                        String ma = sc.nextLine();
                        dschuyenbay.xoa(ma);
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;
                }

                case "5": {
                    System.out.println("+====================================================+");
                    System.out.println("|                   SUA CHUYEN BAY                   |");
                    System.out.println("+====================================================+");
                    System.out.println("|  1. Sua khong tham so                              |");
                    System.out.println("|  2. Sua co tham so                                 |");
                    System.out.println("+----------------------------------------------------+");
                    System.out.print("Chon kieu sua: ");
                    String s = sc.nextLine();
                    if (s.equals("1")) {
                        dschuyenbay.sua();
                    } else if (s.equals("2")) {
                        System.out.print("Nhap ma chuyen bay can sua: ");
                        String ma = sc.nextLine();
                        dschuyenbay.sua(ma);
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;
                }

                case "6": {
                    System.out.println("+====================================================+");
                    System.out.println("|                   TIM CHUYEN BAY                   |");
                    System.out.println("+====================================================+");
                    System.out.println("|  1. Tim khong tham so                              |");
                    System.out.println("|  2. Tim co tham so                                 |");
                    System.out.println("|  3. Tim vi tri chuyen bay                          |");
                    System.out.println("+----------------------------------------------------+");
                    System.out.print("Chon kieu tim: ");
                    String tm = sc.nextLine();
                    if (tm.equals("1")) {
                        ChuyenBay cb = dschuyenbay.tim();
                        if (cb != null) {
                            cb.xuatChuyenBay();
                        } else {
                            System.out.println("Khong tim thay chuyen bay.");
                        }
                    } else if (tm.equals("2")) {
                        System.out.print("Nhap ma chuyen bay can tim: ");
                        String ma = sc.nextLine();
                        ChuyenBay cb = dschuyenbay.tim(ma);
                        if (cb != null) {
                            cb.xuatChuyenBay();
                        } else {
                            System.out.println("Khong tim thay chuyen bay.");
                        }
                    } else if (tm.equals("3")) {
                        System.out.print("Nhap ma chuyen bay can tim vi tri: ");
                        String ma = sc.nextLine();
                        int vt = dschuyenbay.timViTri(ma);
                        if (vt != -1) {
                            System.out.println("Chuyen bay o vi tri: " + vt);
                        } else {
                            System.out.println("Khong tim thay chuyen bay.");
                        }
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;
                }

                case "7": {
                    System.out.println("+====================================================+");
                    System.out.println("|                      THONG KE                      |");
                    System.out.println("+====================================================+");
                    System.out.println("|  1. Thong ke so chuyen bay theo ngay               |");
                    System.out.println("|  2. Thong ke theo tinh trang                       |");
                    System.out.println("+----------------------------------------------------+");
                    System.out.print("Chon kieu thong ke: ");
                    String tk = sc.nextLine();
                    if (tk.equals("1")) {
                        int[] ds = dschuyenbay.thongKeNgayChuyenBay();
                        for (int i = 1; i < ds.length; i++) {
                            if (ds[i] > 0) {
                                System.out.println("Ngay " + i + " co " + ds[i] + " chuyen bay.");
                            }
                        }
                    } else if (tk.equals("2")) {
                        System.out.println("+------------------ THONG KE THEO TINH TRANG ------------------+");
                        String[] tinhtrang = {"Hoat dong", "Tam hoan", "Huy"};
                        ChuyenBay[][] tkTT = dschuyenbay.thongKeTinhTrang();

                        for (int i = 0; i < tinhtrang.length; i++) {
                            System.out.println("\nTinh trang: " + tinhtrang[i]);
                            if (tkTT[i].length == 0) {
                                System.out.println("   Khong co chuyen bay nao o tinh trang nay.");
                            } else {
                                for (ChuyenBay cb : tkTT[i]) {
                                    cb.xuatChuyenBay();
                                }
                            }
                        }
                    } else {
                        System.out.println("Lua chon khong hop le.");
                    }
                    break;
                }
                case "9":
                    dschuyenbay.xuatDS();
                    break;

                case "0":
                    System.out.println("Ket thuc chuong trinh.");
                    break;

                default:
                    chonsai = true;
                    System.out.println("Lua chon khong hop le, vui long nhap lai.");
            }

            if (!c.equals("0") && !chonsai) {
                System.out.println();
                System.out.println("Nhan Enter de tiep tuc...");
                sc.nextLine();
            }

        } while (!c.equals("0"));
    }
}
