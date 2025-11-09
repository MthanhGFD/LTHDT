package src;

import java.util.Arrays;

public class QuanLyGhe extends QuanLyVeMayBay {

    private DanhSachGhe dsGhe;
    private DanhSachMayBay dsMayBay;

    public QuanLyGhe() {
        dsGhe = new DanhSachGhe();
        dsMayBay = new DanhSachMayBay();  // dùng để ràng buộc mã máy bay khi nhập ghế
    }

    public QuanLyGhe(DanhSachGhe dsGhe, DanhSachMayBay dsMayBay) {
        this.dsGhe = dsGhe;
        this.dsMayBay = dsMayBay;
    }

    // ===================== MENU CHỈ CÓ GHẾ =====================
    @Override
    public void menu() {
        System.out.println("+===========================================+");
        System.out.println("|                QUAN LY GHE                |");
        System.out.println("+===========================================+");
        System.out.println("|  0. Thoat                                 |");
        System.out.println("|  1. Doc danh sach ghe tu file             |");
        System.out.println("|  2. Ghi danh sach len file                |");
        System.out.println("|  3. Nhap danh sach ghe                    |");
        System.out.println("|  4. Them ghe                              |");
        System.out.println("|  5. Xoa ghe                               |");
        System.out.println("|  6. Sua vi tri ghe                        |");
        System.out.println("|  7. Tim ghe                               |");
        System.out.println("|  8. Thong ke ghe theo tung may bay        |");
        System.out.println("|  9. Xuat danh sach ghe                    |");
        System.out.println("+-------------------------------------------+");
    }

    // ===================== CHOICE – CHỈ GHẾ =====================
    @Override
    public void choice() {
        String chon;
        boolean chonsai = false;

        do {
            menu();
            System.out.print("Chon thao tac: ");
            chon = DanhSachGhe.sc.next();

            switch (chon) {

                case "1":
                    dsGhe.docFile();
                    break;

                case "2":
                    dsGhe.ghiFile();
                    break;

                case "3":
                    int sl;
                    System.out.print("Nhap so luong ghe: ");
                    sl = DanhSachGhe.sc.nextInt();
                    DanhSachGhe.sc.nextLine();

                    for (int i = 0; i < sl; i++) {

                        Ghe g = new Ghe();
                        g.nhapGhe();

                        // kiểm tra trùng mã ghế
                        if (dsGhe.tim(g.getMaGhe()) != null) {
                            System.out.println("Ghe da ton tai. Moi nhap lai!");
                            i--;
                            continue;
                        }

                        // kiểm tra mã máy bay hợp lệ
                        if (dsMayBay.tim(g.getMaMayBay()) == null) {
                            System.out.println("Ma may bay khong ton tai. Nhap lai!");
                            i--;
                            continue;
                        }

                        dsGhe.them(g);
                        System.out.println("==================================");
                    }

                    dsGhe.ghiFile();
                    break;

                case "4":
                    System.out.println("+==========================================+");
                    System.out.println("|                 THEM GHE                 |");
                    System.out.println("+==========================================+");
                    System.out.println("|  1. Them ghe khong tham so               |");
                    System.out.println("|  2. Them ghe co tham so                  |");
                    System.out.println("+------------------------------------------+");
                    System.out.print("Chon kieu them ghe: ");

                    String t = DanhSachGhe.sc.next();

                    if (t.equals("1") || t.equals("2")) {
                        Ghe g = new Ghe();
                        g.nhapGhe();

                        if (dsGhe.tim(g.getMaGhe()) != null) {
                            System.out.println("Ghe da ton tai. Moi nhap lai!");
                            break;
                        }

                        if (dsMayBay.tim(g.getMaMayBay()) == null) {
                            System.out.println("Ma may bay khong ton tai. Moi nhap lai!");
                            break;
                        }

                        dsGhe.them(g);
                    } else {
                        System.out.println("Chon sai thao tac them ghe!");
                    }

                    break;

                case "5":
                    System.out.println("+==========================================+");
                    System.out.println("|                  XOA GHE                 |");
                    System.out.println("+==========================================+");
                    System.out.println("|  1. Xoa ghe khong tham so                |");
                    System.out.println("|  2. Xoa ghe co tham so                   |");
                    System.out.println("+------------------------------------------+");
                    System.out.print("Chon kieu xoa ghe: ");
                    String x = DanhSachGhe.sc.next();

                    if (x.equals("1")) {
                        dsGhe.xoa();
                    } else if (x.equals("2")) {
                        DanhSachGhe.sc.nextLine();
                        System.out.print("Nhap ma ghe can xoa: ");
                        dsGhe.xoa(DanhSachGhe.sc.nextLine());
                    } else {
                        System.out.println("Chon sai thao tac xoa!");
                    }
                    break;

                case "6":
                    System.out.println("+==========================================+");
                    System.out.println("|                 SUA GHE                  |");
                    System.out.println("+==========================================+");
                    System.out.println("|  1. Sua ghe khong tham so                |");
                    System.out.println("|  2. Sua ghe co tham so                   |");
                    System.out.println("+------------------------------------------+");
                    System.out.print("Chon kieu sua ghe: ");
                    String chonsua = DanhSachGhe.sc.next();

                    if (chonsua.equals("1")) {
                        dsGhe.sua();
                    } else if (chonsua.equals("2")) {
                        DanhSachGhe.sc.nextLine();
                        System.out.print("Nhap ma ghe can sua: ");
                        dsGhe.sua(DanhSachGhe.sc.nextLine());
                    } else {
                        System.out.println("chon sai thao tac sua ghe!!");
                    }
                    break;

                case "7":
                    System.out.println("+==========================================+");
                    System.out.println("|                 TIM GHE                  |");
                    System.out.println("+==========================================+");
                    System.out.println("|  1. Tim theo ma                          |");
                    System.out.println("|  2. Tim theo vi tri                      |");
                    System.out.println("|  3  Tim theo trang thai                  |");
                    System.out.println("+------------------------------------------+");
                    System.out.print("Chon kieu tim ghe: ");

                    DanhSachGhe.sc.nextLine();
                    String chonTim = DanhSachGhe.sc.nextLine();

                    switch (chonTim) {
                        case "1":
                            String maGhe;
                            System.out.print("Nhap ma ghe can tim: ");
                            maGhe = DanhSachGhe.sc.nextLine();
                            Ghe g = dsGhe.tim(maGhe);
                            if (g != null) {
                                System.out.println("+-----------------+----------------------+--------------+-----------------+");
                                g.xuatGhe();
                                System.out.println("+-----------------+----------------------+--------------+-----------------+");
                            } else {
                                System.out.println("Khong tim thay ghe!");
                            }
                        case "2":
                            String viTriGhe;
                            System.out.println("Nhap vi tri ghe can tim: ");
                            viTriGhe = DanhSachGhe.sc.nextLine();
                            Ghe g1 = dsGhe.tim(viTriGhe);
                            if (g1 != null) {
                                System.out.println("+-----------------+----------------------+--------------+-----------------+");
                                g1.xuatGhe();
                                System.out.println("+-----------------+----------------------+--------------+-----------------+");
                            } else {
                                System.out.println("Khong tim thay ghe!");
                            }
                            break;
                        case "3":
                            Ghe[] dsgheTrong = dsGhe.gheTrong();
                            Ghe[] dsgheDaDat = dsGhe.gheDaDat();
                            if (dsgheTrong != null) {
                                System.out.println("            ================== Danh Sach ghe trong ==================");
                                System.out.println("+-----------------+----------------------+--------------+-----------------+");
                                System.out.println("|     Ma ghe      |      Vi tri ghe      |  Trang thai  |   May may bay   |");
                                System.out.println("+-----------------+----------------------+--------------+-----------------+");
                                for (int i = 0; i < dsgheTrong.length; i++) {
                                    dsgheTrong[i].xuatGhe();
                                }
                                System.out.println("+-----------------+----------------------+--------------+-----------------+");
                            } else {
                                System.out.println("Khong co ghe trong");
                            }
                            if (dsgheDaDat != null) {
                                System.out.println("            ================== Danh Sach ghe da dat ==================");
                                System.out.println("+-----------------+----------------------+--------------+-----------------+");
                                System.out.println("|     Ma ghe      |      Vi tri ghe      |  Trang thai  |   May may bay   |");
                                System.out.println("+-----------------+----------------------+--------------+-----------------+");
                                for (int i = 0; i < dsgheDaDat.length; i++) {
                                    dsgheDaDat[i].xuatGhe();
                                }
                                System.out.println("+-----------------+----------------------+--------------+-----------------+");
                            } else {
                                System.out.println("Khong co ghe nao duoc dat");
                            }
                            break;
                        default:
                            System.out.println("Chon sai thao tac tim!");
                    }
                    break;

                case "8":
                    for (int i = 0; i < dsMayBay.getSoLuong(); i++) {
                        System.out.printf("        ================== May Bay: %15s ==================\n", dsMayBay.getDsMayBay()[i].getMaMayBay());
                        System.out.println("+-----------------+----------------------+--------------+-----------------+");
                        System.out.println("|     Ma ghe      |      Vi tri ghe      |  Trang thai  |   May may bay   |");
                        System.out.println("+-----------------+----------------------+--------------+-----------------+");
                        for (int j = 0; j < dsGhe.getSoLuong(); j++) {
                            if (dsGhe.getDsGhe()[j].getMaMayBay().equals(dsMayBay.getDsMayBay()[i].getMaMayBay())) {
                                dsGhe.getDsGhe()[i].xuatGhe();
                            }
                        }
                    }
                case "9":
                    dsGhe.xuatDS();
                    break;

                case "0":
                    System.out.println("Thoat quan ly ghe.");
                    break;

                default:
                    System.out.println("Chon sai thao tac!");
                    chonsai = true;
            }

            if (!chonsai && !chon.equals("0")) {
                System.out.println("Ban co muon thoat chuong trinh??");
                System.out.println("Neu co --> (0) , Khong --> (1-7)");
            }
        } while (!chon.equals("0"));
    }
}
