package src;

import static src.DanhSachSanBay.sc;

public class QuanLySanBay extends QuanLyVeMayBay {

    private DanhSachSanBay dssanbay;

    public QuanLySanBay() {
        dssanbay = new DanhSachSanBay();
    }

    // ==================== MENU ====================
    @Override
    public void menu() {
        System.out.println("+=====================================================+");
        System.out.println("|                   QUAN LY SAN BAY                   |");
        System.out.println("+=====================================================+");
        System.out.println("|  1. Doc danh sach tu file                           |");
        System.out.println("|  2. Ghi danh sach len file                          |");
        System.out.println("|  3. Nhap danh sach moi                              |");
        System.out.println("|  4. Them san bay                                    |");
        System.out.println("|  5. Xoa san bay                                     |");
        System.out.println("|  6. Sua ten san bay                                 |");
        System.out.println("|  7. Tim san bay                                     |");
        System.out.println("|  8. Xuat danh sach ra man hinh                      |");
        System.out.println("|  0. Thoat                                           |");
        System.out.println("+-----------------------------------------------------+");
    }

    @Override
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
                    dssanbay.docFile();
                    System.out.println("Da doc danh sach tu file!");
                    break;

                case "2":
                    dssanbay.ghiFile();
                    break;
                case "3":
                    dssanbay.nhapDS();
                    break;

                case "4": {
                    String t;
                    System.out.println("+==============================================+");
                    System.out.println("|                 THEM SAN BAY                 |");
                    System.out.println("+==============================================+");
                    System.out.println("|  1. Them san bay khong co tham so             |");
                    System.out.println("|  2. Them san bay co tham so                   |");
                    System.out.println("+-----------------------------------------------+");
                    System.out.print("Chon kieu them: ");
                    t = sc.next();
                    sc.nextLine();
                    if (t.equals("1")) {
                        String ma;
                        System.out.print("Nhap ma san bay: ");
                        ma = DanhSachSanBay.sc.nextLine();
                        if (dssanbay.tim(ma) == null) {
                            SanBay sb = new SanBay();
                            sb.nhapSanBay();
                            dssanbay.them(sb);
                        } else
                            System.out.println("San bay da ton tai, nhap lai");
                    } else if (t.equals("2")) {
                        String ma;
                        System.out.print("Nhap ma san bay: ");
                        ma = DanhSachSanBay.sc.nextLine();
                        if (dssanbay.tim(ma) == null) {
                            SanBay sb = new SanBay();
                            sb.nhapSanBay();
                            dssanbay.them(sb);
                        } else
                            System.out.println("San bay da ton tai, nhap lai");

                    } else {
                        System.out.println("Lua chon khong hop le!");
                    }
                    break;
                }

                case "5": {
                    String x;
                    System.out.println("+=============================================+");
                    System.out.println("|                 XOA SAN BAY                 |");
                    System.out.println("+=============================================+");
                    System.out.println("|  1. Xoa san bay khong co tham so            |");
                    System.out.println("|  2. Xoa san bay co tham so                  |");
                    System.out.println("+---------------------------------------------+");
                    System.out.print("Chon kieu xoa: ");
                    x = sc.next();
                    sc.nextLine();
                    if (x.equals("1")) {
                        dssanbay.xoa();
                    } else if (x.equals("2")) {
                        System.out.print("Nhap ma san bay can xoa: ");
                        String ma = DanhSachSanBay.sc.nextLine();
                        dssanbay.xoa(ma);
                    } else {
                        System.out.println("Lua chon khong hop le!");
                    }
                    break;
                }

                case "6": {
                    String s;
                    System.out.println("+=============================================+");
                    System.out.println("|                 SUA SAN BAY                 |");
                    System.out.println("+=============================================+");
                    System.out.println("|  1. Sua san bay khong co tham so            |");
                    System.out.println("|  2. Sua san bay co tham so                  |");
                    System.out.println("+---------------------------------------------+");
                    System.out.print("Chon kieu sua: ");
                    s = sc.next();
                    sc.nextLine();
                    if (s.equals("1")) {
                        dssanbay.sua();
                    } else if (s.equals("2")) {
                        System.out.print("Nhap ma san bay can sua: ");
                        String ma = DanhSachSanBay.sc.nextLine();
                        dssanbay.sua(ma);
                    } else {
                        System.out.println("Lua chon khong hop le!");
                    }
                    break;
                }

                case "7": {
                    String tm;
                    System.out.println("+=============================================+");
                    System.out.println("|                 TIM SAN BAY                 |");
                    System.out.println("+=============================================+");
                    System.out.println("|  1. Tim san bay theo ma                     |");
                    System.out.println("|  2. Tim san bay theo ten san bay            |");
                    System.out.println("|  3. Tim san bay theo dia diem (tp/tinh)     |");
                    System.out.println("+---------------------------------------------+");
                    System.out.print("Chon kieu tim: ");
                    tm = sc.next();
                    sc.nextLine();
                    switch (tm) {
                        case "1":
                            System.out.print("Nhap ma san bay can tim: ");
                            String ma = DanhSachSanBay.sc.nextLine();
                            SanBay sb1 = dssanbay.tim(ma);
                            if (sb1 != null) {
                                System.out.println("+-----------------+--------------------------------+---------------------------+");
                                sb1.xuatSanBay();
                                System.out.println("+-----------------+--------------------------------+---------------------------+");
                            } else {
                                System.out.println("Khong tim thay san bay!");
                            }
                            break;
                        case "2":
                            String tenSanBay;
                            System.out.print("Nhap ten san bay can tim: ");
                            tenSanBay = DanhSachSanBay.sc.nextLine();
                            SanBay sb2 = dssanbay.timTen(tenSanBay);
                            if (sb2 != null) {
                                System.out.println("+-----------------+--------------------------------+---------------------------+");
                                sb2.xuatSanBay();
                                System.out.println("+-----------------+--------------------------------+---------------------------+");
                            } else {
                                System.out.println("Khong tim thay san bay!");
                            }
                            break;
                        case "3":
                            String diaDiem;
                            System.out.print("Nhap dia diem (thanh pho/tinh): ");
                            diaDiem = DanhSachSanBay.sc.nextLine();
                            SanBay sb3  = dssanbay.timTinh(diaDiem);
                            if (sb3 != null) {
                                System.out.println("+-----------------+--------------------------------+---------------------------+");
                                sb3.xuatSanBay();
                                System.out.println("+-----------------+--------------------------------+---------------------------+");
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

                case "8":
                    dssanbay.xuatDS();
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
