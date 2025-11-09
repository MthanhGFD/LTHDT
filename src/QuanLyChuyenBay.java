package src;

import static src.DanhSachChuyenBay.sc;

public class QuanLyChuyenBay extends QuanLyVeMayBay {

    private DanhSachChuyenBay dsChuyenBay;
    private DanhSachMayBay dsMayBay;
    private DanhSachHangHangKhong dsHangHangKhong;
    private DanhSachSanBay dsSanBay;

    public QuanLyChuyenBay() {
        dsChuyenBay = new DanhSachChuyenBay();
        dsMayBay = new DanhSachMayBay();
        dsHangHangKhong = new DanhSachHangHangKhong();
        dsSanBay = new DanhSachSanBay();
    }

    public QuanLyChuyenBay(DanhSachChuyenBay dsChuyenBay, DanhSachMayBay dsMayBay, DanhSachHangHangKhong dsHangHangKhong, DanhSachSanBay dsSanBay) {
        this.dsChuyenBay = dsChuyenBay;
        this.dsMayBay = dsMayBay;
        this.dsHangHangKhong = dsHangHangKhong;
        this.dsSanBay = dsSanBay;
    }

    // ===================== MENU CHUYẾN BAY =====================
    @Override
    public void menu() {
        System.out.println("+==========================================+");
        System.out.println("|            QUAN LY CHUYEN BAY            |");
        System.out.println("+==========================================+");
        System.out.println("|  0. Thoat                                |");
        System.out.println("|  1. Doc danh sach chuyen bay tu file     |");
        System.out.println("|  2. Ghi danh sach len file               |");
        System.out.println("|  3  Nhap danh sach chuyen bay            |");
        System.out.println("|  4. Them chuyen bay                      |");
        System.out.println("|  5. Xoa chuyen bay                       |");
        System.out.println("|  6. Sua chuyen bay                       |");
        System.out.println("|  7. Tim chuyen bay                       |");
        System.out.println("|  8. Xuat danh sach chuyen bay            |");
        System.out.println("+------------------------------------------+");
    }

// ===================== CHOICE - CHUYẾN BAY =====================
    @Override
    public void choice() {
        String chon;
        boolean chonsai = false;

        do {
            menu();
            System.out.print("Chon thao tac: ");
            chon = sc.next();

            switch (chon) {
                case "1":
                    dsChuyenBay.docFile();
                    break;

                case "2":
                    dsChuyenBay.ghiFile();
                    break;
                case "3":
                    int sl;
                    System.out.print("Nhap so luong chuyen bay: ");
                    sl = DanhSachChuyenBay.sc.nextInt();
                    sc.nextLine(); // đọc bỏ dòng

                    for (int i = 0; i < sl; i++) {
                        ChuyenBay cb = new ChuyenBay();
                        cb.nhapChuyenBay();

                        // kiểm tra trùng mã chuyến bay
                        if (dsChuyenBay.tim(cb.getMaChuyenBay()) != null) {
                            System.out.println("Chuyen bay da ton tai. Moi nhap lai!");
                            i--;
                            continue;
                        }

                        if (dsMayBay.tim(cb.getMaMayBay()) == null) {
                            System.out.println("May bay khong ton tai, moi nhap lai!");
                            i--;
                            continue;
                        }

                        if (dsHangHangKhong.tim(cb.getMaHangHangKhong()) == null) {
                            System.out.println("Hang Hang khong khong ton tai, moi nhap lai!");
                            i--;
                            continue;
                        }

                        if (dsSanBay.tim(cb.getMaSanBay()) == null) {
                            System.out.println("San bay khong ton tai, moi nhap lai!");
                            i--;
                            continue;
                        }

                        dsChuyenBay.them(cb);
                        System.out.println("==================================");
                    }
                    break;

                case "4":
                    System.out.println("+===========================================+");
                    System.out.println("|              THEM CHUYEN BAY              |");
                    System.out.println("+===========================================+");
                    System.out.println("|  1. Them chuyen bay khong tham so         |");
                    System.out.println("|  2. Them chuyen bay co tham so            |");
                    System.out.println("+-------------------------------------------+");
                    System.out.print("Chon kieu them chuyen bay: ");

                    String t = sc.next();

                    if (t.equals("1")) {
                        ChuyenBay cb = new ChuyenBay();
                        cb.nhapChuyenBay();

                        if (dsChuyenBay.tim(cb.getMaChuyenBay()) != null) {
                            System.out.println("Chuyen bay da ton tai. Moi nhap lai!");
                            break;
                        }

                        if (dsMayBay.tim(cb.getMaMayBay()) == null) {
                            System.out.println("May bay khong ton tai, moi nhap lai!");
                            break;
                        }

                        if (dsHangHangKhong.tim(cb.getMaHangHangKhong()) == null) {
                            System.out.println("Hang Hang khong khong ton tai, moi nhap lai!");
                            break;
                        }

                        if (dsSanBay.tim(cb.getMaSanBay()) == null) {
                            System.out.println("San bay khong ton tai, moi nhap lai!");
                            break;
                        }
                        dsChuyenBay.them(cb);
                    } else if (t.equals("2")) {
                        ChuyenBay cb = new ChuyenBay();
                        cb.nhapChuyenBay();

                        if (dsChuyenBay.tim(cb.getMaChuyenBay()) != null) {
                            System.out.println("Chuyen bay da ton tai. Moi nhap lai!");
                            break;
                        }

                        if (dsMayBay.tim(cb.getMaMayBay()) == null) {
                            System.out.println("May bay khong ton tai, moi nhap lai!");
                            break;
                        }

                        if (dsHangHangKhong.tim(cb.getMaHangHangKhong()) == null) {
                            System.out.println("Hang Hang khong khong ton tai, moi nhap lai!");
                            break;
                        }

                        if (dsSanBay.tim(cb.getMaSanBay()) == null) {
                            System.out.println("San bay khong ton tai, moi nhap lai!");
                            break;
                        }

                        dsChuyenBay.them(cb);
                    } else {
                        System.out.println("Chon sai thao tac them chuyen bay!");
                    }
                    break;

                case "5":
                    System.out.println("+==========================================+");
                    System.out.println("|              XOA CHUYEN BAY             |");
                    System.out.println("+==========================================+");
                    System.out.println("|  1. Xoa chuyen bay khong tham so         |");
                    System.out.println("|  2. Xoa chuyen bay co tham so           |");
                    System.out.println("+------------------------------------------+");
                    System.out.print("Chon kieu xoa chuyen bay: ");
                    String x = DanhSachChuyenBay.sc.next();

                    if (x.equals("1")) {
                        dsChuyenBay.xoa();
                    } else if (x.equals("2")) {
                        DanhSachChuyenBay.sc.nextLine();
                        System.out.print("Nhap ma chuyen bay can xoa: ");
                        dsChuyenBay.xoa(sc.nextLine());
                    } else {
                        System.out.println("Chon sai thao tac xoa!");
                    }
                    break;

                case "6":
                    System.out.println("+==========================================+");
                    System.out.println("|              SUA CHUYEN BAY              |");
                    System.out.println("+==========================================+");
                    System.out.println("|  1. Sua chuyen bay khong tham so         |");
                    System.out.println("|  2. Sua chuyen bay co tham so            |");
                    System.out.println("+------------------------------------------+");
                    System.out.print("Chon kieu sua chuyen bay: ");
                    String chonsua = sc.next();

                    if (chonsua.equals("1")) {
                        dsChuyenBay.sua();
                    } else if (chonsua.equals("2")) {
                        sc.nextLine();
                        System.out.print("Nhap ma chuyen bay can sua: ");
                        dsChuyenBay.sua(sc.nextLine());
                    } else {
                        System.out.println("chon sai thao tac sua chuyen bay!!");
                    }
                    break;

                case "7":
                    System.out.println("+==========================================+");
                    System.out.println("|              TIM CHUYEN BAY              |");
                    System.out.println("+==========================================+");
                    System.out.println("|  1. Tim theo ma                          |");
                    System.out.println("|  2. Tim theo diem den                    |");
                    System.out.println("|  3. Tim theo ngay khoi hanh              |");
                    System.out.println("|  4. Tim theo tinh trang                  |");
                    System.out.println("+------------------------------------------+");
                    System.out.print("Chon kieu tim chuyen bay: ");

                    sc.nextLine();
                    String chonTim = DanhSachChuyenBay.sc.nextLine();

                    switch (chonTim) {
                        case "1":
                            String ma;
                            System.out.print("Nhap ma can tim: ");
                            ma = DanhSachChuyenBay.sc.nextLine();
                            ChuyenBay cb1 = dsChuyenBay.tim(ma);
                            if (cb1 != null) {
                                System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                                cb1.xuatChuyenBay();
                                System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                            } else {
                                System.out.println("Khong tim thay chuyen bay!");
                            }
                            break;
                        case "2":
                            String diemDen;
                            System.out.print("Nhap diem den: ");
                            diemDen = DanhSachChuyenBay.sc.nextLine();
                            ChuyenBay[] ds1 = dsChuyenBay.timDiemDen(diemDen);
                            if (ds1 != null) {
                                System.out.println("                                                  +===============================================================+");
                                System.out.printf("                                                  |               Chuyen bay cung ngay %20s       |", diemDen);
                                System.out.println("                                                  +===============================================================+");
                                System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                                System.out.println("|  Ma chuyen bay  |    Diem khoi hanh    |       Diem den       |Ngay khoi hanh|Gio khoi hanh |  Tinh trang  |   Ma may bay    |     ma hang     |   Ma san bay    |");
                                System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                                for (int i = 0; i < ds1.length; i++) {
                                    ds1[i].xuatChuyenBay();
                                }
                                System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                            } else {
                                System.out.println("Khong tim thay chuyen bay!");
                            }
                            break;
                        case "3":
                            String ngayKhoiHanh;
                            System.out.print("Nhap ngay khoi hanh: ");
                            ngayKhoiHanh = DanhSachChuyenBay.sc.nextLine();
                            ChuyenBay[] ds2 = dsChuyenBay.dsNgay(ngayKhoiHanh);
                            if (ds2 != null) {
                                System.out.println("                                                  +======================================================+");
                                System.out.printf("                                                  |               Chuyen bay cung ngay %8s       |", ngayKhoiHanh);
                                System.out.println("                                                  +======================================================+");
                                System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                                System.out.println("|  Ma chuyen bay  |    Diem khoi hanh    |       Diem den       |Ngay khoi hanh|Gio khoi hanh |  Tinh trang  |   Ma may bay    |     ma hang     |   Ma san bay    |");
                                System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                                for (int i = 0; i < ds2.length; i++) {
                                    ds2[i].xuatChuyenBay();
                                }
                                System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                            } else {
                                System.out.println("Khong tim thay chuyen bay");
                            }

                            break;
                        case "4":
                            String tinhTrang;
                            System.out.print("Nhap tinh trang (Khoi hanh/Hoan/Huy): ");
                            tinhTrang = DanhSachChuyenBay.sc.nextLine();
                            ChuyenBay[] ds3 = dsChuyenBay.dsTinhTrang(tinhTrang);
                            if (ds3 != null) {
                                System.out.println("                                                  +=======================================================+");
                                System.out.printf("                                                  |               Chuyen bay cung ngay %12s       |", tinhTrang);
                                System.out.println("                                                  +=======================================================+");
                                System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                                System.out.println("|  Ma chuyen bay  |    Diem khoi hanh    |       Diem den       |Ngay khoi hanh|Gio khoi hanh |  Tinh trang  |   Ma may bay    |     ma hang     |   Ma san bay    |");
                                System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                                for (int i = 0; i < ds3.length; i++) {
                                    ds3[i].xuatChuyenBay();
                                }
                                System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                            } else {
                                System.out.println("Khong tim thay chuyen bay");
                            }
                        default:
                            System.out.println("Chon sai thao tac tim!");
                    }
                    break;

                case "8":
                    System.out.println("                                           ================== Danh sach chuyen bay ==================");
                    System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                    System.out.println("|  Ma chuyen bay  |    Diem khoi hanh    |       Diem den       |Ngay khoi hanh|Gio khoi hanh |  Tinh trang  |   Ma may bay    |     ma hang     |   Ma san bay    |");
                    System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");
                    dsChuyenBay.xuatDS();
                    System.out.println("+-----------------+----------------------+----------------------+--------------+--------------+--------------+-----------------+-----------------+-----------------+");

                    break;
                case "0":
                    System.out.println("Cam on da su dung chuong trinh!");
                default:
                    System.out.println("Chon sai thao tac!");
                    chonsai = true;
            }

            if (!chonsai && !chon.equals("0")) {
                System.out.println("Ban co muon thoat chuong trinh??");
                System.out.println("Neu co --> (0) , Khong --> (1-9)");
            }
        } while (!chon.equals("0"));
    }
}
