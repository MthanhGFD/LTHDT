package src;

import java.util.Scanner;

public class QuanLyVeMayBay {

    private QuanLyHanhKhach qlHanhKhach;
    private QuanLyMayBay qlMayBay;
    private QuanLyHangHangKhong qlHangHngKhong;
    private QuanLySanBay qlSanBay;
    private QuanLyGhe qlGhe;
    private QuanLyChuyenBay qlChuyenBay;
    private QuanLyVe qlVe;
    private QuanLyHoaDon qlHoaDon;

    public void menu() {
        System.out.println("+------------------- Quan ly ve may bay -------------------+");
        System.out.println("|  1. Quan ly hanh khach                                   |");
        System.out.println("|  2. Quan ly may bay                                      |");
        System.out.println("|  3. Quan ly hang hang khong                              |");
        System.out.println("|  4. Quan ly san bay                                      |");
        System.out.println("|  5. Quan ly ghe                                          |");
        System.out.println("|  6. Quan ly chuyen bay                                   |");
        System.out.println("|  7. Quan ly ve                                           |");
        System.out.println("|  8. Quan ly hoa don                                      |");
        System.out.println("|  0. Thoat                                                |");
        System.out.println("+----------------------------------------------------------+");
    }

    public void choice() {
        Scanner sc = new Scanner(System.in);
        String chon;
        boolean chonsai = false;
        do {
            menu();
            System.out.print("Moi chon chuc nang quan ly");
            chon = sc.next();
            switch (chon) {
                case "1":
                    qlHanhKhach.choice();
                    break;
                case "2":
                    qlMayBay.choice();
                    break;
                case "3":
                    qlMayBay.choice();
                    break;
                case "4":
                    qlMayBay.choice();
                    break;
                case "5":
                    qlMayBay.choice();
                    break;
                case "6":
                    qlMayBay.choice();
                    break;
                case "7":
                    qlMayBay.choice();
                    break;
                case "8":
                    qlMayBay.choice();
                    break;
                default:
                    System.out.println("Chon sai thao tac, moi chon lai");
                    chonsai = true;
            }
            
            if(!chon.equals("0") && !chonsai){
                System.out.println("Ban co muon thoat chuong trinh khong??");
                System.out.println("Neu co --> (0), Khong --> (1-8)");
            }
        } while (chon.equals("0"));
    }
}
