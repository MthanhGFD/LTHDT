package src;

import java.util.Scanner;

public class MayBay {
    private String maMayBay;
    private String loaiMayBay;
    private int sucChua;

    // Constructor không tham số
    public MayBay() {
        this.maMayBay = "";
        this.loaiMayBay = "";
        this.sucChua = 0;
    }

    // Constructor có tham số
    public MayBay(String maMayBay, String loaiMayBay, int sucChua) {
        this.maMayBay = maMayBay;
        this.loaiMayBay = loaiMayBay;
        this.sucChua = sucChua;
    }

    // Copy constructor
    public MayBay(MayBay other) {
        this.maMayBay = other.maMayBay;
        this.loaiMayBay = other.loaiMayBay;
        this.sucChua = other.sucChua;
    }

    // ======== Input / Output ========

    public void inputMayBay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã máy bay: ");
        this.maMayBay = scanner.nextLine();
       try {
            int choice;
            System.out.println("+-------------------- Loại máy bay --------------------+");
            System.out.println("|  1. Airbus A321                                      |");
            System.out.println("|  2. Airbus A350-900                                  |");
            System.out.println("|  3. Boeing 787-10                                    |");
            System.out.println("|  4. Airbus A320                                      |");
            System.out.println("+------------------------------------------------------+");
            System.out.print("Chọn loại Hành Khách: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: this.loaiMayBay = "Airbus A321"; break;
                case 2: this.loaiMayBay = "Airbus A350-900"; break;
                case 3: this.loaiMayBay = "Boeing 787-10"; break;
                case 4: this.loaiMayBay = "Airbus A320"; break;
            }
        } catch (Exception e) {
            this.loaiMayBay = "Airbus A321";
        }
        System.out.print("Nhập sức chứa: ");
        this.sucChua = Integer.parseInt(scanner.nextLine());
    }

    public void outputMayBay() {
        String fmt = "| %-15s | %-25s | %-10d |%n";
        System.out.println("+-----------------+---------------------------+------------+");
        System.out.printf(fmt, maMayBay, loaiMayBay, sucChua);
        System.out.println("+-----------------+---------------------------+------------+");
    }


    public String getMaMayBay() {
        return maMayBay;
    }

    public void setMaMayBay(String maMayBay) {
        this.maMayBay = maMayBay;
    }

    public String getLoaiMayBay() {
        return loaiMayBay;
    }

    public void setLoaiMayBay(String loaiMayBay) {
        this.loaiMayBay = loaiMayBay;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }
}
