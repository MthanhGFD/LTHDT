package src;

import java.util.Scanner;

public class QuanLyVe extends QuanLyChuyenBay {

    private DanhSachVe dsVe;
    private DanhSachChuyenBay dsChuyenBay;

    public QuanLyVe() {
        dsVe = new DanhSachVe();
        dsChuyenBay = new DanhSachChuyenBay();
    }

    public QuanLyVe(DanhSachVe dsVe, DanhSachChuyenBay dsChuyenBay) {
        this.dsVe = dsVe;
        this.dsChuyenBay = dsChuyenBay;
    }

    // ===================== MENU VÉ =====================
    @Override
    public void menu() {
        System.out.println("+==========================================+");
        System.out.println("|               QUAN LY VE                 |");
        System.out.println("+==========================================+");
        System.out.println("|  0. Thoat                                |");
        System.out.println("|  1. Doc danh sach ve tu file              |");
        System.out.println("|  2. Ghi danh sach ve len file             |");
        System.out.println("|  3. Nhap danh sach ve                      |");
        System.out.println("|  4. Them ve                               |");
        System.out.println("|  5. Xoa ve                                |");
        System.out.println("|  6. Sua ve                                |");
        System.out.println("|  7. Tim ve                                |");
        System.out.println("|  8. Xuat danh sach ve                     |");
        System.out.println("+------------------------------------------+");
    }

    // ===================== CHOICE - VÉ =====================
    @Override
    public void choice() {
        Scanner sc = new Scanner(System.in);
        String chon;

        do {
            menu();
            System.out.print("Chon thao tac: ");
            chon = sc.next();

            switch (chon) {
                case "1":
                    dsVe.docFileVe();
                    break;

                case "2":
                    dsVe.ghiFileVe();
                    break;

                case "3":
                    int sl;
                    System.out.print("Nhap so luong ve: ");
                    sl = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < sl; i++) {
                        Ve ve = new VeThuong(); // hoặc VeKhuHoi nếu muốn mặc định
                        ve.nhapVe();

                        // Kiểm tra trùng mã vé
                        if (dsVe.timVe(ve.getMaVe()) != null) {
                            System.out.println("Ma ve da ton tai. Moi nhap lai!");
                            i--;
                            continue;
                        }

                        // Kiểm tra chuyến bay tồn tại
                        if (dsChuyenBay.tim(ve.getMaChuyenBay()) == null) {
                            System.out.println("Chuyen bay khong ton tai, moi nhap lai!");
                            i--;
                            continue;
                        }

                        dsVe.themVe(ve);
                        System.out.println("==================================");
                    }
                    break;

                case "4":
                    System.out.println("+===========================================+");
                    System.out.println("|                 THEM VE                   |");
                    System.out.println("+===========================================+");

                    System.out.println("Chon loai ve can them:");
                    System.out.println("1. Ve Thuong");
                    System.out.println("2. Ve VIP");
                    System.out.print("Lua chon (1/2): ");
                    int loai = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    Ve ve;
                    if (loai == 1) {
                        ve = new VeThuong();
                    } else if (loai == 2) {
                        ve = new VeVIP();
                    } else {
                        System.out.println("Lua chon khong hop le! Mac dinh Ve Thuong.");
                        ve = new VeThuong();
                    }

                    // Nhap thong tin ve
                    ve.nhapVe();

                    // Kiem tra ma ve da ton tai
                    if (dsVe.timVe(ve.getMaVe()) != null) {
                        System.out.println("Ma ve da ton tai!");
                        break;
                    }

                    // Kiem tra chuyen bay ton tai
                    if (dsChuyenBay.tim(ve.getMaChuyenBay()) == null) {
                        System.out.println("Chuyen bay khong ton tai!");
                        break;
                    }

                    dsVe.themVe(ve);
                    System.out.println("Them ve thanh cong!");
                    break;

                case "5":
                    sc.nextLine();
                    System.out.print("Nhap ma ve can xoa: ");
                    dsVe.xoaVe(sc.nextLine());
                    break;

                case "6":
                    sc.nextLine();
                    System.out.print("Nhap ma ve can sua: ");
                    dsVe.suaVe(sc.nextLine());
                    break;

                case "7":
                    sc.nextLine();
                    System.out.print("Nhap ma ve can tim: ");
                    String maVe = sc.nextLine();
                    Ve v = dsVe.timVe(maVe);
                    if (v != null) {
                        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
                        System.out.println("| Ma Ve           | Ma Chuyen Bay   | Ma Ghe          | Gia Ve           | Loai Ve         |");
                        System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
                        v.xuatVe();
                        System.out.println("\n+-----------------+-----------------+-----------------+-----------------+-----------------+");
                    } else {
                        System.out.println("Khong tim thay ve!");
                    }
                    break;

                case "8":
                    System.out.println("                   ================== Danh sach ve ==================");
                    System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
                    System.out.println("| Ma Ve           | Ma Chuyen Bay   | Ma Ghe          | Gia Ve           | Loai Ve         |");
                    System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
                    dsVe.xuatDSVe();
                    System.out.println("+-----------------+-----------------+-----------------+-----------------+-----------------+");
                    break;

                case "0":
                    System.out.println("Cam on da su dung chuong trinh!");
                    break;

                default:
                    System.out.println("Chon sai thao tac!");
            }

        } while (!chon.equals("0"));
    }
}
