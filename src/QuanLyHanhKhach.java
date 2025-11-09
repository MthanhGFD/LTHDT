package src;

import static src.DanhSachHanhKhach.sc;

public class QuanLyHanhKhach extends QuanLyVeMayBay {

    private DanhSachHanhKhach dshanhkhach;

    public QuanLyHanhKhach() {
        dshanhkhach = new DanhSachHanhKhach();
    }

    public QuanLyHanhKhach(DanhSachHanhKhach dshanhkhach) {
        this.dshanhkhach = dshanhkhach;
    }

    @Override
    public void menu() {
        System.out.println("+======================================================+");
        System.out.println("|                  QUAN LY HANH KHACH                  |");
        System.out.println("+======================================================+");
        System.out.println("|  1. Doc file tu danh sach                            |");
        System.out.println("|  2. Ghi danh sach len file                           |");
        System.out.println("|  3. Nhap danh sach                                   |");
        System.out.println("|  4. Them hanh khach                                  |");
        System.out.println("|  5. Xoa hanh khach                                   |");
        System.out.println("|  6. Sua thong tin hanh khach                         |");
        System.out.println("|  7. Tim hanh khach                                   |");
        System.out.println("|  8. Thong ke hanh khach theo tuoi                    |");
        System.out.println("|  9. Xuat hanh khach ra man hinh                      |");
        System.out.println("|  0. Thoat                                            |");
        System.out.println("+------------------------------------------------------+");
    }

    @Override
    public void choice() {
        String c;
        boolean nhapSai = false;
        do {
            menu();
            System.out.print("Moi chọn chuc nang: ");
            c = sc.next();
            switch (c) {
                case "0":
                    System.out.println("Cam on da su dung chuong trinh!!!");
                    break;
                case "1":
                    dshanhkhach.docFile();
                    break;
                case "2":
                    dshanhkhach.ghiFile();
                    break;
                case "3":
                    dshanhkhach.nhapDS();
                    break;
                case "4":
                    String t;
                    System.out.println("+=====================================================+");
                    System.out.println("|                   THEM HANH KHACH                   |");
                    System.out.println("+=====================================================+");
                    System.out.println("|  1. Them hanh khach khong tham so                   |");
                    System.out.println("|  2. Them hanh khach co tham so                      |");
                    System.out.println("+-----------------------------------------------------+");
                    System.out.print("Chon kieu them hanh khach ");
                    t = DanhSachHanhKhach.sc.next();
                    if (t.equals("1")) {
                        dshanhkhach.them();
                    }
                    if (t.equals("2")) {
                        HanhKhach hk1 = new HanhKhach("A01", "Nguyen Van", "Teo", "01-01-2005", "Ong", "0892001", "0357522", "Vip");
                        dshanhkhach.them(hk1);
                    }
                    break;
                case "5":
                    String x;
                    System.out.println("+====================================================+");
                    System.out.println("|                   XOA HANH KHACH                   |");
                    System.out.println("+====================================================+");
                    System.out.println("|  1. Xoa hanh khach khong tham so                   |");
                    System.out.println("|  2. Xoa hanh khach co tham so                      |");
                    System.out.println("+----------------------------------------------------+");
                    System.out.print("Chon kieu xoa hanh khach: ");
                    x = sc.next();
                    if (x.equals("1")) {
                        dshanhkhach.xoa();
                    }
                    if (x.equals("2")) {
                        System.out.print("Nhap ma hanh khach can xoa: ");
                        dshanhkhach.xoa(sc.nextLine());
                    }
                    break;
                case "6":
                    String s;
                    System.out.println("+====================================================+");
                    System.out.println("|                   SUA HANH KHACH                   |");
                    System.out.println("+====================================================+");
                    System.out.println("|  1. Sua hanh khach khong tham so                   |");
                    System.out.println("|  2. Sua hanh khach co tham so                      |");
                    System.out.println("+----------------------------------------------------+");
                    System.out.print("Chon kieu sua hanh khach: ");
                    s = sc.next();
                    if (s.equals("1")) {
                        dshanhkhach.sua();
                    }
                    if (s.equals("2")) {
                        System.out.print("Nhap hanh khach can sua: ");
                        dshanhkhach.sua(sc.nextLine());
                    }
                    break;
                case "7":

                    System.out.println("+====================================================+");
                    System.out.println("|                   TIM HANH KHACH                   |");
                    System.out.println("+====================================================+");
                    System.out.println("|  1. Tim theo ma                                    |");
                    System.out.println("|  2. Tim theo ten                                   |");
                    System.out.println("|  3. Tim theo ngay sinh                             |");
                    System.out.println("|  4. Tim theo can cuoc cong dan                     |");
                    System.out.println("|  5. Tim theo so dien thoai                         |");
                    System.out.println("|  6. Tim theo loai hanh khach                       |");
                    System.out.println("+----------------------------------------------------+");
                    System.out.print("Moi chon thao tac tim:");
                    c = sc.next();
                    switch (c) {
                        case "1":
                            String ma;
                            System.out.print("Moi nhap ma hanh khach can tim: ");
                            ma = DanhSachHanhKhach.sc.nextLine();
                            HanhKhach hk = dshanhkhach.tim(ma);
                            if (hk != null) {
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                                hk.xuatHanhKhach();
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                            } else {
                                System.out.println("Khong tim thay hanh khach");
                            }

                            break;
                        case "2":
                            String ten;
                            System.out.print("Moi nhap ten hanh khach can tim: ");
                            ten = DanhSachHanhKhach.sc.nextLine();
                            HanhKhach dsTen[] = dshanhkhach.timTen(ten);
                            if (dsTen != null) {
                                System.out.println("                                ==================== Danh Sach Theo Ten ==================== ");
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                                System.out.println("|  Ma Hanh Khach  |                Ho              |    Ten     |  Ngay Sinh | Danh Xung  |   So Can Cuoc   |  So Dien Thoai  | Loai Hanh Khach |");
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                                for (int i = 0; i < dsTen.length; i++) {
                                    dsTen[i].xuatHanhKhach();
                                }
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                            } else {
                                System.out.println("Khong tim thay hanh khach ");
                            }
                            break;
                        case "3":
                            String ngaySinh;
                            System.out.print("Nhap ngay sinh khach hang can tim: ");
                            ngaySinh = DanhSachHanhKhach.sc.nextLine();
                            HanhKhach[] dsNgaySinh = dshanhkhach.timNgaySinh(ngaySinh);
                            if (dsNgaySinh != null) {
                                System.out.println("                                ==================== Danh Sach Theo Ngay Sinh ==================== ");
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                                System.out.println("|  Ma Hanh Khach  |                Ho              |    Ten     |  Ngay Sinh | Danh Xung  |   So Can Cuoc   |  So Dien Thoai  | Loai Hanh Khach |");
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                                for (int i = 0; i < dsNgaySinh.length; i++) {
                                    dsNgaySinh[i].xuatHanhKhach();
                                }
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                            } else {
                                System.out.println("Khong tim thay hanh khach ");
                            }
                            break;

                        case "4":
                            String cccd;
                            System.out.print("Moi nhap cccd cua hanh khach can tim: ");
                            cccd = DanhSachHanhKhach.sc.nextLine();
                            HanhKhach hk1 = dshanhkhach.timCCCD(cccd);
                            if (hk1 != null) {
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                                hk1.xuatHanhKhach();
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                            } else {
                                System.out.println("Khong tim thay hanh khach");
                            }
                            break;
                         
                        case "5":
                            String sdt;
                            System.out.print("Moi nhap sdt cua hanh khach can tim: ");
                            sdt = DanhSachHanhKhach.sc.nextLine();
                            HanhKhach hk2 = dshanhkhach.timSDT(sdt);
                            if (hk2 != null) {
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                                hk2.xuatHanhKhach();
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                            } else {
                                System.out.println("Khong tim thay hanh khach");
                            }
                            break;
                        case "6":
                            HanhKhach[] dsvip = dshanhkhach.dsVip();
                            HanhKhach[] dsthuong = dshanhkhach.dsThuong();
                            if (dsvip != null) {
                                System.out.println("                                ==================== Danh Sach Vip ==================== ");
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                                System.out.println("|  Ma Hanh Khach  |                Ho              |    Ten     |  Ngay Sinh | Danh Xung  |   So Can Cuoc   |  So Dien Thoai  | Loai Hanh Khach |");
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                                for (int i = 0; i < dsvip.length; i++) {
                                    dsvip[i].xuatHanhKhach();
                                }
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                            } else
                                System.out.println("Khong co khach vip");
                            if(dsthuong != null){
                                System.out.println("                                ==================== Danh Sach Thuong ==================== ");
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                                System.out.println("|  Ma Hanh Khach  |                Ho              |    Ten     |  Ngay Sinh | Danh Xung  |   So Can Cuoc   |  So Dien Thoai  | Loai Hanh Khach |");
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                                for (int i = 0; i < dsthuong.length; i++) {
                                    dsthuong[i].xuatHanhKhach();
                                }
                                System.out.println("+-----------------+--------------------------------+------------+------------+------------+-----------------+-----------------+-----------------+");
                            } else
                                System.out.println("Khong co khach thuong");
                            break;
                        default:
                            System.out.println("Chon sai thao tac tim hanh khach");;
                    }
                    break;
                case "8":
                    int[] tk = dshanhkhach.thongKeTuoi();
                    for (int i = 0; i < tk.length; i++) {
                        System.out.println("So luong hanh khach tuoi " + i + " la: " + tk[i]);
                    }
                    break;
                case "9":
                    dshanhkhach.xuatDS();
                    break;
                default:
                    System.out.println("Chon khong dung, hay chon lai chuc nang (0-10): ");
                    nhapSai = true;
            }

            if (!nhapSai && !c.equals("0")) {
                System.out.println("Ban co muon thoat chuong trinh??");
                System.out.println("Neu co -> (0) | thao tac tiep -> (1-10)");
            }
        } while (!c.equals("0"));
    }
}
