package CodeClass;

import static CodeClass.DanhSachSanBay.sc;


public class QuanLySanBay {
    private DanhSachSanBay dssanbay;
    
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
                    dssanbay.docFile();
                    System.out.println("Da doc danh sach tu file!");
                    break;

                case "2":
                    dssanbay.nhapDS();
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
                        dssanbay.them();
                    } else if (t.equals("2")) {
                        SanBay sb = new SanBay("VDO", "San bay Van Don", "Quang Ninh");
                        dssanbay.them(sb.getMaSanBay());
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
                        dssanbay.xoa();
                    } else if (x.equals("2")) {
                        System.out.print("Nhap ma san bay can xoa: ");
                        String ma = sc.nextLine();
                        dssanbay.xoa(ma);
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
                        dssanbay.sua();
                    } else if (s.equals("2")) {
                        System.out.print("Nhap ma san bay can sua: ");
                        String ma = sc.nextLine();
                        dssanbay.sua(ma);
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
                            SanBay sb1 = dssanbay.tim();
                            if (sb1 != null) {
                                sb1.xuatSanBay();
                            } else {
                                System.out.println("Khong tim thay san bay!");
                            }
                            break;
                        case "2":
                            System.out.print("Nhap ma san bay can tim: ");
                            String ma = sc.nextLine();
                            SanBay sb2 = dssanbay.tim(ma);
                            if (sb2 != null) {
                                sb2.xuatSanBay();
                            } else {
                                System.out.println("Khong tim thay san bay!");
                            }
                            break;
                        case "3":
                            System.out.print("Nhap ma san bay can tim vi tri: ");
                            String maVT = sc.nextLine();
                            int vt = dssanbay.timViTri(maVT);
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
                    dssanbay.xuatDS();
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
