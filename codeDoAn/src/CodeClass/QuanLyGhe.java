package CodeClass;

import static CodeClass.DanhSachGhe.sc;
import static CodeClass.DanhSachMayBay.sc;

public class QuanLyGhe extends QuanLyVeMayBay {

    private DanhSachGhe dsghe;
    private DanhSachMayBay dsmaybay;

    public QuanLyGhe() {
        dsghe = new DanhSachGhe();
        dsmaybay = new DanhSachMayBay();
    }

    public QuanLyGhe(DanhSachGhe dsghe, DanhSachMayBay dsmaybay) {
        this.dsghe = dsghe;
        this.dsmaybay = dsmaybay;
    }

    // Menu
    @Override
    public void menu() {
        System.out.println("+===========================================+");
        System.out.println("|                QUAN LY GHE                |");
        System.out.println("+===========================================+");
        System.out.println("|  0. Thoat                                 |");
        System.out.println("|  1. Danh sach ghe                         |");
        System.out.println("|  2. Danh sach may bay                     |");
        System.out.println("+-------------------------------------------+");
    }

    // choice
    @Override
    public void choice() {
        String chon;
        boolean nhapsai = false;
        do {
            menu();
            System.out.print("Chon thao tac: ");
            chon = DanhSachGhe.sc.next();
            if (chon.equals("1")) {
                String chondsghe;
                boolean nhapsaighe = false;
                do {
                    System.out.println("+===========================================+");
                    System.out.println("|             DANH SACH MAY GHE             |");
                    System.out.println("+===========================================+");
                    System.out.println("| 1. Doc danh sach ghe tu file              |");
                    System.out.println("| 2. Nhap danh sach ghe                     |");
                    System.out.println("| 3. Them ghe                               |");
                    System.out.println("| 4. Xoa ghe                                |");
                    System.out.println("| 5. Sua vi tri ghe                         |");
                    System.out.println("| 6. Tim ghe theo ma                        |");
                    System.out.println("| 7. Xuat danh sach ghe                     |");
                    System.out.println("| 0. Thoat chuong trinh                     |");
                    System.out.println("+-------------------------------------------+");
                    System.out.print("Chon thao tac cua danh ghe: ");
                    chondsghe = DanhSachGhe.sc.next();
                    chon = DanhSachGhe.sc.next();
                    switch (chondsghe) {
                        case "1":
                            dsghe.docFile();
                            break;
                        case "2":
                            dsghe.nhapDS();
                            break;
                        case "3":
                            String t;
                            System.out.println("+==========================================+");
                            System.out.println("|                 THEM GHE                 |");
                            System.out.println("+==========================================+");
                            System.out.println("|  1. Them ghe khong tham so               |");
                            System.out.println("|  2. Them ghe co tham so                  |");
                            System.out.println("+------------------------------------------+");
                            System.out.print("Chon kieu them ghe: ");
                            t = DanhSachGhe.sc.next();
                            if (t.equals("1")) {
                                dsghe.them();
                            } else if (t.equals("2")) {
                                Ghe g1 = new Ghe("GH01", "MB01", "A00");
                                dsghe.them(g1);
                            }
                            break;
                        case "4":
                            String x;
                            System.out.println("+==========================================+");
                            System.out.println("|                  XOA GHE                 |");
                            System.out.println("+==========================================+");
                            System.out.println("|  1. Xoa ghe khong tham so                |");
                            System.out.println("|  2. Xoa ghe co tham so                   |");
                            System.out.println("+------------------------------------------+");
                            System.out.print("Chon kieu xoa ghe: ");
                            x = DanhSachGhe.sc.next();
                            if (x.equals("1")) {
                                dsghe.xoa();
                            } else if (x.equals("2")) {
                                DanhSachGhe.sc.nextLine();
                                System.out.print("Nhap ma ghe can xoa: ");
                                dsghe.xoa(DanhSachGhe.sc.nextLine());
                            }
                            break;
                        case "5":
                            System.out.println("+==========================================+");
                            System.out.println("|                 SUA GHE                  |");
                            System.out.println("+==========================================+");
                            System.out.println("|  1. Sua ghe khong tham so                |");
                            System.out.println("|  2. Sua ghe co tham so                   |");
                            System.out.println("|  0. Quay lai                             |");
                            System.out.println("+------------------------------------------+");
                            System.out.print("Chon kieu sua ghe: ");
                            String chonsua = DanhSachGhe.sc.next();

                            switch (chonsua) {
                                case "1":
                                    dsghe.sua(); // gọi hàm không tham số
                                    break;

                                case "2":
                                    System.out.print("Nhap ma ghe can sua: ");
                                    String maGhe = DanhSachGhe.sc.nextLine();
                                    dsghe.sua(maGhe); // gọi hàm có tham số
                                    break;
                                default:
                                    System.out.println("chon sai thao tac sua ghe!!");
                            }
                            break;

                        case "6":
                            System.out.println("+==========================================+");
                            System.out.println("|                 TIM GHE                  |");
                            System.out.println("+==========================================+");
                            System.out.println("|  1. Tim ghe khong tham so                |");
                            System.out.println("|  2. Tim ghe co tham so                   |");
                            System.out.println("|  3. Tim ghe tra ve vi tri                |");
                            System.out.println("+------------------------------------------+");
                            System.out.print("Chon kieu tim ghe: ");
                            String chonTim = DanhSachGhe.sc.nextLine();

                            switch (chonTim) {
                                case "1":
                                    dsghe.tim(); // không tham số
                                    break;

                                case "2":
                                    System.out.print("Nhap ma ghe can tim: ");
                                    String maTim = DanhSachGhe.sc.nextLine();
                                    Ghe g = dsghe.tim(maTim); // có tham số
                                    if (g != null) {
                                        g.xuatGhe();
                                    } else {
                                        System.out.println("Khong tim thay ghe!");
                                    }
                                    break;

                                case "3":
                                    System.out.print("Nhap ma ghe can tim: ");
                                    String maViTri = DanhSachGhe.sc.nextLine();
                                    int vt = dsghe.timViTri(maViTri); // trả về vị trí
                                    if (vt != -1) {
                                        System.out.println("Tim thay ghe o vi tri thu " + vt);
                                    } else {
                                        System.out.println("Khong tim thay ghe trong danh sach!");
                                    }
                                    break;

                                default:
                                    System.out.println("Chon sai thao tac tim ghe!");
                                    nhapsaighe = true;
                            }
                            break;

                        case "7":
                            dsghe.xuatDS();
                            break;
                        case "0":
                            System.out.println("Cam on da su dung chuong trinh!");
                            break;
                        default:
                            System.out.println("Chon khong hop le!");
                    }
                    if (!chondsghe.equals("0") && !nhapsaighe) {
                        System.out.println("Ban co muon thoat danh sach ghe??");
                        System.out.println("Neu co --> (0) | khong --> (1-7)");
                    }
                } while (chondsghe.equals("0"));
            } else if (chon.equals("2")) {
                String chondsmaybay;
                boolean nhapsaimaybay = false;
                do {
                    System.out.println("+===========================================================+");
                    System.out.println("|                     DANH SACH MAY BAY                     |");
                    System.out.println("+===========================================================+");
                    System.out.println("|  1. Nhap danh sach may bay                                |");
                    System.out.println("|  2. Doc danh sach may bay tu file                         |");
                    System.out.println("|  3. Them 1 may bay vao danh sach                          |");
                    System.out.println("|  4. Xoa 1 may bay khoi danh sach                          |");
                    System.out.println("|  5. Sua thong tin may bay                                 |");
                    System.out.println("|  6. Tim may bay                                           |");
                    System.out.println("|  7. Thong ke may bay theo loai                            |");
                    System.out.println("|  8. Xuat danh sach may bay                                |");
                    System.out.println("+-----------------------------------------------------------+");
                    chondsmaybay = DanhSachMayBay.sc.next();
                    switch (chondsmaybay) {
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
                            System.out.println("+==============================================+");
                            System.out.println("|                 THEM MAY BAY                 |");
                            System.out.println("+==============================================+");
                            System.out.println("|  1. Them may bay khong tham so               |");
                            System.out.println("|  2. Them may bay co tham so                  |");
                            System.out.println("+----------------------------------------------+");
                            System.out.print("Chon kieu them: ");
                            String t = DanhSachMayBay.sc.nextLine();
                            if (t.equals("1")) {
                                dsmaybay.them();
                            } else if (t.equals("2")) {
                                System.out.print("Nhap ma may bay muon them: ");
                                String ma = DanhSachMayBay.sc.nextLine();
                                dsmaybay.them(ma);
                            } else {
                                System.out.println("Lua chon khong hop le!");
                            }
                            break;
                        case "4":
                            System.out.println("+=============================================+");
                            System.out.println("|                 xOA MAY BAY                 |");
                            System.out.println("+=============================================+");
                            System.out.println("|  1. Xoa may bay khong tham so               |");
                            System.out.println("|  2. Xoa may bay co tham so                  |");
                            System.out.println("+---------------------------------------------+");
                            System.out.print("Chon kieu xoa: ");
                            String x = DanhSachMayBay.sc.nextLine();
                            if (x.equals("1")) {
                                dsmaybay.xoa();
                            } else if (x.equals("2")) {
                                System.out.print("Nhap ma may bay can xoa: ");
                                String ma = DanhSachMayBay.sc.nextLine();
                                dsmaybay.xoa(ma);
                            } else {
                                System.out.println("Lua chon khong hop le!");
                            }
                            break;
                        case "5":
                            System.out.println("+=============================================+");
                            System.out.println("|                 SUA MAY BAY                 |");
                            System.out.println("+=============================================+");
                            System.out.println("|  1. Sua may bay khong tham so               |");
                            System.out.println("|  2. Sua may bay co tham so                  |");
                            System.out.println("+---------------------------------------------+");
                            System.out.print("Chon kieu sua: ");
                            String s = DanhSachMayBay.sc.nextLine();
                            if (s.equals("1")) {
                                dsmaybay.sua();
                            } else if (s.equals("2")) {
                                System.out.print("Nhap ma may bay can sua: ");
                                String ma = DanhSachMayBay.sc.nextLine();
                                dsmaybay.sua(ma);
                            } else {
                                System.out.println("Lua chon khong hop le!");
                            }
                            break;
                        case "6":
                            System.out.println("+=============================================+");
                            System.out.println("|                 TIM MAY BAY                 |");
                            System.out.println("+=============================================+");
                            System.out.println("|  1. Tim may bay khong tham so               |");
                            System.out.println("|  2. Tim may bay co tham so                  |");
                            System.out.println("|  3. Tim vi tri may bay                      |");
                            System.out.println("+---------------------------------------------+");
                            System.out.print("Chon kieu tim: ");
                            String tm = DanhSachMayBay.sc.nextLine();
                            switch (tm) {
                                case "1":
                                    MayBay mb1 = dsmaybay.tim();
                                    if (mb1 != null) {
                                        mb1.xuatMayBay();
                                    } else {
                                        System.out.println("Khong tim thay may bay!");
                                    }
                                    break;
                                case "2":
                                    System.out.print("Nhap ma may bay can tim: ");
                                    String ma = DanhSachMayBay.sc.nextLine();
                                    MayBay mb2 = dsmaybay.tim(ma);
                                    if (mb2 != null) {
                                        mb2.xuatMayBay();
                                    } else {
                                        System.out.println("Khong tim thay may bay!");
                                    }
                                    break;
                                case "3":
                                    System.out.print("Nhap ma may bay can tim vi tri: ");
                                    String maVT = DanhSachMayBay.sc.nextLine();
                                    int vt = dsmaybay.timViTri(maVT);
                                    if (vt != -1) {
                                        System.out.println("May bay o vi tri: " + vt);
                                    } else {
                                        System.out.println("Khong tim thay may bay!");
                                    }
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
                                    for (MayBay mb : tk[i]) {
                                        mb.xuatMayBay();
                                    }
                                } else {
                                    System.out.println("Khong co may bay loai nay.");
                                }
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
                            nhapsaimaybay = true;
                    }
                    if (!nhapsaimaybay && !chondsmaybay.equals("0")) {
                        System.out.println("Ban co muon thoat danh sach may bay?");
                        System.out.println("Neu co -> (0) | Thao tac tiep -> (1-8)");
                    }
                } while (chondsmaybay.equals("0"));
            }
        } while (chon.equals("0"));
        if (!nhapsai && !chon.equals("0")) {
            System.out.println("Ban co muon thoat quan ly ghe??");
            System.out.println("Neu co -> (0) | Thao tac tiep -> (1-8)");
        }
    }

}
