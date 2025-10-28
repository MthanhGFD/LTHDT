package CodeClass;

import static CodeClass.DanhSachHanhKhach.sc;

public class QuanLiHanhKhach {
    private DanhSachHanhKhach dshanhkhach;
    
    public void menu() {
        System.out.println("+------------Quan Li Danh Sach Hanh Khach------------+");
        System.out.println("|  1. doc file tu danh sach                          |");
        System.out.println("|  2. Nhap danh sach                                 |");
        System.out.println("|  3. Them hanh khach                                |");
        System.out.println("|  4. Xoa hanh khach                                 |");
        System.out.println("|  5. Sua thong tin hanh khach                       |");
        System.out.println("|  6. Tim hanh khach theo ma                         |");
        System.out.println("|  7. Tim hanh khach theo ten                        |");
        System.out.println("|  8. Thong ke loai hanh khach                       |");
        System.out.println("|  9. Thong ke hanh khach theo tuoi                  |");
        System.out.println("|  10. Xuat hanh khach ra man hinh                   |");
        System.out.println("|  0. Thoa                                          |");
        System.out.println("+--------------------------------- ------------------+");
    }

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
                    dshanhkhach.nhapDS();
                    break;
                case "3":
                    String t;
                    System.out.println("+-------------- Them hanh khach --------------+");
                    System.out.println("|  1. Them hanh khach khong tham so           |");
                    System.out.println("|  2. Them hanh khach co tham so              |");
                    System.out.println("+---------------------------------------------+");
                    System.out.print("Chon kieu them hanh khach ");
                    t = sc.next();
                    if (t.equals("1")) {
                        dshanhkhach.them();
                    }
                    if (t.equals("2")) {
                        HanhKhach hk1 = new HanhKhach("A01", "Nguyễn Văn", "Tèo", "01-01-2005", "Ông", "0892001", "0357522", "Vip");
                        dshanhkhach.them(hk1);
                    }
                    break;
                case "4":
                    String x;
                    System.out.println("+--------------- Xoa hanh khach ---------------+");
                    System.out.println("|  1. Xoa hanh khach khong tham so             |");
                    System.out.println("|  2. Xoa hanh khach co tham so                |");
                    System.out.println("+----------------------------------------------+");
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
                case "5":
                    String s;
                    System.out.println("+--------------- Sua hanh khach ---------------+");
                    System.out.println("|  1. Sua hanh khach khong tham so             |");
                    System.out.println("|  2. Sua hanh khach co tham so                |");
                    System.out.println("+----------------------------------------------+");
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
                case "6":
                    String tm;
                    System.out.println("+--------------- Tim hanh khach ---------------+");
                    System.out.println("|  1. Tim hanh khach khong tham so             |");
                    System.out.println("|  2. Tim hanh khach co tham so                |");
                    System.out.println("|  3. Tim vi tri hanh khach                    |");
                    System.out.println("+----------------------------------------------+");
                    System.out.print("Chon kieu tim hanh khach: ");
                    tm = sc.next();
                    switch (tm) {
                        case "1":
                            if (dshanhkhach.tim() != null) {
                                dshanhkhach.tim().xuatHanhKhach();
                            } else {
                                System.out.println("Khong co hanh khach can tim");
                            }
                        case "2":
                            String ma;
                            System.out.print("nhap ma hanh khach can tim: ");
                            ma = sc.nextLine();
                            if (dshanhkhach.tim(ma) != null) {
                                dshanhkhach.tim(ma).xuatHanhKhach();
                            } else {
                                System.out.println("Khong thay ma can tim");
                            }
                        case "3":
                            String mahk;
                            System.out.println("Nhap ma hanh khach can tim: ");
                            mahk = sc.nextLine();
                            if (dshanhkhach.timViTri(mahk) != -1) {
                                System.out.println("Hanh khach o vi tri " + dshanhkhach.timViTri(mahk) + " trong danh sach");
                            } else {
                                System.out.println("Khong tim thay vi tri trong danh sach");
                            }

                        case "7":
                            String tt;
                            System.out.println("+--------------- Danh sach ten ---------------+");
                            System.out.println("|  1. Tim theo ten khong tham so              |");
                            System.out.println("|  2. Tim theo ten co tham so                 |");
                            System.out.println("+---------------------------------------------+");
                            System.out.print("Chon kieu tim ten: ");
                            tt = sc.nextLine();
                            HanhKhach[] ds;
                            switch (tt) {
                                case "1":
                                    ds = dshanhkhach.timTen();
                                    if (ds != null) {
                                        System.out.println("Số lượng hành khách có tên " + tt + " là: ");
                                        for (int i = 0; i < ds.length; i++) {
                                            ds[i].xuatHanhKhach();
                                        }
                                    } else {
                                        System.out.println("Không có hành khách nào tên " + tt);
                                    }
                                    break;
                                case "2":
                                    String ten;
                                    System.out.print("Nhập tên cần tìm: ");
                                    ten = sc.nextLine();
                                    ds = dshanhkhach.timTen(ten);
                                    if (ds != null) {
                                        System.out.println("Số lượng hành khách có tên " + tt + " là: ");
                                        for (int i = 0; i < ds.length; i++) {
                                            ds[i].xuatHanhKhach();
                                        }
                                    } else {
                                        System.out.println("Không có hành khách nào tên " + tt);
                                    }
                                    break;
                                case "8":
                                    dshanhkhach.thongKeLoaiHanhKhach();
                                    break;
                                case "9":
                                    int[] tk = dshanhkhach.thongKeTuoi();
                                    for (int i = 0; i < tk.length; i++) {
                                        System.out.println("Số lượng hành khách có tuổi " + i + " là " + tk[i]);
                                    }
                                    break;
                                case "10":
                                    System.out.println("+---------------------------- Danh sách Hành Khách ----------------------------+");
                                    dshanhkhach.xuatDS();
                                    System.out.println("+---------------------------- Danh sách Hành Khách ----------------------------+");
                                    break;
                                default:
                                    System.out.println("Chọn không đúng, hãy chọn lại cho đúng chức năng (0-10): ");
                                    nhapSai = true;
                            }
                    }
            }
            if (!nhapSai && !c.equals("0")) {
                System.out.println("Bạn có muốn thoát chương trình??");
                System.out.println("Nếu có -> (0) | thao tác tiếp -> (1-10)");
            }
        } while (!c.equals("0"));
    }
}
