package CodeClass;

import static CodeClass.DanhSachMayBay.sc;

public class QuanLyMayBay {
    private DanhSachMayBay dsmaybay;
    
    public void menu() {
        System.out.println("+-------------------- DANH SACH MAY BAY --------------------+");
        System.out.println("|  1. Nhap danh sach may bay                                 |");
        System.out.println("|  2. Doc danh sach may bay tu file                           |");
        System.out.println("|  3. Them 1 may bay vao danh sach                            |");
        System.out.println("|  4. Xoa 1 may bay khoi danh sach                            |");
        System.out.println("|  5. Sua thong tin may bay                                    |");
        System.out.println("|  6. Tim may bay                                             |");
        System.out.println("|  7. Thong ke may bay theo loai                               |");
        System.out.println("|  8. Xuat danh sach may bay                                   |");
        System.out.println("+-------------------------------------------------------------+");
    }

    public void choice() {
        String c;
        boolean nhapSai;
        do {
            nhapSai = false;
            menu();
            System.out.print("Moi chon chuc nang (0 de thoat): ");
            c = sc.nextLine();

            switch (c) {
                case "0":
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    break;
                case "1":
                    dsmaybay.nhapDS();
                    break;
                case "2":
                    dsmaybay.docFile();
                    break;
                case "3":
                    System.out.println("+-------------- THEM MAY BAY --------------+");
                    System.out.println("|  1. Them may bay khong tham so          |");
                    System.out.println("|  2. Them may bay co tham so             |");
                    System.out.println("+-----------------------------------------+");
                    System.out.print("Chon kieu them: ");
                    String t = sc.nextLine();
                    if (t.equals("1")) {
                        dsmaybay.them();
                    } else if (t.equals("2")) {
                        System.out.print("Nhap ma may bay muon them: ");
                        String ma = sc.nextLine();
                        dsmaybay.them(ma);
                    } else {
                        System.out.println("Lua chon khong hop le!");
                    }
                    break;
                case "4":
                    System.out.println("+--------------- XOA MAY BAY ---------------+");
                    System.out.println("|  1. Xoa may bay khong tham so             |");
                    System.out.println("|  2. Xoa may bay co tham so                |");
                    System.out.println("+------------------------------------------+");
                    System.out.print("Chon kieu xoa: ");
                    String x = sc.nextLine();
                    if (x.equals("1")) {
                        dsmaybay.xoa();
                    } else if (x.equals("2")) {
                        System.out.print("Nhap ma may bay can xoa: ");
                        String ma = sc.nextLine();
                        dsmaybay.xoa(ma);
                    } else {
                        System.out.println("Lua chon khong hop le!");
                    }
                    break;
                case "5":
                    System.out.println("+--------------- SUA MAY BAY ---------------+");
                    System.out.println("|  1. Sua may bay khong tham so             |");
                    System.out.println("|  2. Sua may bay co tham so                |");
                    System.out.println("+------------------------------------------+");
                    System.out.print("Chon kieu sua: ");
                    String s = sc.nextLine();
                    if (s.equals("1")) {
                        dsmaybay.sua();
                    } else if (s.equals("2")) {
                        System.out.print("Nhap ma may bay can sua: ");
                        String ma = sc.nextLine();
                        dsmaybay.sua(ma);
                    } else {
                        System.out.println("Lua chon khong hop le!");
                    }
                    break;
                case "6":
                    System.out.println("+--------------- TIM MAY BAY ---------------+");
                    System.out.println("|  1. Tim may bay khong tham so             |");
                    System.out.println("|  2. Tim may bay co tham so                |");
                    System.out.println("|  3. Tim vi tri may bay                     |");
                    System.out.println("+------------------------------------------+");
                    System.out.print("Chon kieu tim: ");
                    String tm = sc.nextLine();
                    switch (tm) {
                        case "1":
                            MayBay mb1 = dsmaybay.tim();
                            if (mb1 != null) mb1.xuatMayBay();
                            else System.out.println("Khong tim thay may bay!");
                            break;
                        case "2":
                            System.out.print("Nhap ma may bay can tim: ");
                            String ma = sc.nextLine();
                            MayBay mb2 = dsmaybay.tim(ma);
                            if (mb2 != null) mb2.xuatMayBay();
                            else System.out.println("Khong tim thay may bay!");
                            break;
                        case "3":
                            System.out.print("Nhap ma may bay can tim vi tri: ");
                            String maVT = sc.nextLine();
                            int vt = dsmaybay.timViTri(maVT);
                            if (vt != -1) System.out.println("May bay o vi tri: " + vt);
                            else System.out.println("Khong tim thay may bay!");
                            break;
                        default:
                            System.out.println("Lua chon khong hop le!");
                    }
                    break;
                case "7":
                    System.out.println("+---------- THONG KE THEO LOAI MAY BAY ----------+");
                    MayBay[][] tk = dsmaybay.thongKeLoaiMayBay();
                    String[] loai = {"Airbus A321", "Airbus A350-900", "Boeing 787-10", "Airbus A320"};
                    for (int i = 0; i < tk.length; i++) {
                        System.out.println("Loai: " + loai[i]);
                        if (tk[i] != null && tk[i].length > 0) {
                            for (MayBay mb : tk[i]) mb.xuatMayBay();
                        } else System.out.println("Khong co may bay loai nay.");
                        System.out.println("------------------------------------------------");
                    }
                    break;
                case "8":
                    System.out.println("+------------ DANH SACH MAY BAY ----------------+");
                    dsmaybay.xuatDS();
                    System.out.println("+-----------------------------------------------+");
                    break;
                default:
                    System.out.println("Lua chon khong dung, vui long chon lai (0-8)");
                    nhapSai = true;
            }
            if (!nhapSai && !c.equals("0")) {
                System.out.println("Ban co muon thoat chuong trinh?");
                System.out.println("Neu co -> (0) | Thao tac tiep -> (1-8)");
            }
        } while (!c.equals("0"));
    }
}
