package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachMayBay {

    private MayBay[] dsmaybay;
    private int soluong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachMayBay() {
        dsmaybay = new MayBay[0];
        soluong = 0;
    }

    public DanhSachMayBay(MayBay[] dsmaybay, int soluong) {
        this.dsmaybay = dsmaybay;
        this.soluong = soluong;
    }

    public DanhSachMayBay(DanhSachMayBay ds) {
        dsmaybay = ds.dsmaybay;
        soluong = ds.soluong;
    }

    public void nhapDS() {
        int sl;
        System.out.print("Nhập số lượng máy bay: ");
        sl = sc.nextInt();
        soluong = sl;
        for (int i = 0; i < sl; i++) {
            dsmaybay = Arrays.copyOf(dsmaybay, dsmaybay.length + 1);
            dsmaybay[i] = new MayBay();
            dsmaybay[i].nhapMayBay();
            ghiFile(dsmaybay[i]);
            System.out.println("=========================================");
        }
    }

    public void xuatDS() {
        for (int i = 0; i < dsmaybay.length; i++) {
            dsmaybay[i].xuatMayBay();
        }
    }

    public void docFile() {
        int i = soluong;
        try {
            FileReader f = new FileReader("dsMayBay.txt");
            Scanner docf = new Scanner(f);
            while (docf.hasNextLine()) {
                String line = docf.nextLine();
                String tokens[] = line.split(",");
                dsmaybay[i].setMaMayBay(tokens[0]);
                dsmaybay[i].setLoaiMayBay(tokens[1]);
                dsmaybay[i].setSucChua(Integer.parseInt(tokens[2]));
                i++;
            }
            f.close();
            soluong = i;

        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy File!!!!");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
    }

    public void ghiFile(MayBay maybay) {
        try {
            File f = new File("dsMayBay.txt");
            FileWriter ghif = new FileWriter(f, true);
            ghif.write(maybay.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file!!");
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }

    // thêm máy bay
    // không tham số
    public void them() {
        String ma;
        System.out.print("Nhập mã máy bay: ");
        ma = sc.nextLine();
        if (tim(ma) == null) {
            dsmaybay = Arrays.copyOf(dsmaybay, soluong + 1);
            dsmaybay[soluong] = new MayBay();
            dsmaybay[soluong].setMaMayBay(ma);
            dsmaybay[soluong].nhapMayBay();
            ghiFile(dsmaybay[soluong]);
            soluong++;
        } else {
            System.out.println("Máy bay đã tồn tại");
        }
    }

    // có tham số
    public void them(String ma) {
        if (tim(ma) == null) {
            dsmaybay = Arrays.copyOf(dsmaybay, soluong + 1);
            dsmaybay[soluong] = new MayBay();
            dsmaybay[soluong].setMaMayBay(ma);
            dsmaybay[soluong].nhapMayBay();
            ghiFile(dsmaybay[soluong]);
            soluong++;
        } else {
            System.out.println("Máy bay đã tồn tại");
        }
    }

    // Xóa máy bay có tham số (truyền mã máy bay cần xóa)
    public void xoa(String maMayBay) {
        int vitrixoa = timViTri(maMayBay);
        if (vitrixoa != -1) {
            for (int i = vitrixoa; i < dsmaybay.length - 1; i++) {
                dsmaybay[i] = dsmaybay[i + 1];
            }
            dsmaybay = Arrays.copyOf(dsmaybay, soluong - 1);
            soluong--;
        } else {
            System.out.println("Không tìm thấy máy bay cần xóa!!!");
        }
    }

// Xóa máy bay không tham số (nhập mã từ bàn phím)
    public void xoa() {
        System.out.print("Nhập mã máy bay cần xóa: ");
        String maMayBay = sc.nextLine();

        int vitrixoa = timViTri(maMayBay);
        if (vitrixoa != -1) {
            for (int i = vitrixoa; i < dsmaybay.length - 1; i++) {
                dsmaybay[i] = dsmaybay[i + 1];
            }
            dsmaybay = Arrays.copyOf(dsmaybay, soluong - 1);
            soluong--;
        } else {
            System.out.println("Không tìm thấy máy bay cần xóa!!!");
        }
    }

    // sửa không tham số
    public void sua() {
        System.out.print("Nhập mã máy bay cần sửa: ");
        String maMayBay = sc.nextLine();

        // tránh lỗi trôi dòng nếu trước đó có dùng nextInt()
        if (maMayBay.isEmpty()) {
            maMayBay = sc.nextLine();
        }

        int vitri = timViTri(maMayBay);
        if (vitri != -1) {
            String choice;
            System.out.println("+-------------------SỬA THÔNG TIN MÁY BAY-------------------+");
            System.out.println("|  1. Sửa loại máy bay                                      |");
            System.out.println("|  2. Sửa sức chứa                                          |");
            System.out.println("+-----------------------------------------------------------+");
            System.out.print("Chọn thông tin bạn muốn sửa: ");
            choice = sc.next();

            switch (choice) {
                case "1":
                    System.out.print("Nhập loại máy bay mới: ");
                    dsmaybay[vitri].setLoaiMayBay(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Nhập sức chứa mới: ");
                    dsmaybay[vitri].setSucChua(sc.nextInt());
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } else {
            System.out.println("Không tìm thấy máy bay muốn sửa!");
        }
    }

// sửa có tham số
    public void sua(String maMayBay) {
        int vitri = timViTri(maMayBay);
        if (vitri != -1) {
            String choice;
            System.out.println("+-------------------SỬA THÔNG TIN MÁY BAY-------------------+");
            System.out.println("|  1. Sửa loại máy bay                                      |");
            System.out.println("|  2. Sửa sức chứa                                          |");
            System.out.println("+-----------------------------------------------------------+");
            System.out.print("Chọn thông tin bạn muốn sửa: ");
            choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.print("Nhập loại máy bay mới: ");
                    dsmaybay[vitri].setLoaiMayBay(sc.nextLine());
                    break;
                case "2":
                    System.out.print("Nhập sức chứa mới: ");
                    dsmaybay[vitri].setSucChua(sc.nextInt());
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } else {
            System.out.println("Không tìm thấy máy bay muốn sửa!");
        }
    }

    // Tìm máy bay theo mã (truyền mã trực tiếp)
    public MayBay tim(String ma) {
        for (int i = 0; i < soluong; i++) {
            if (dsmaybay[i].getMaMayBay().equals(ma)) {
                return dsmaybay[i];
            }
        }
        return null;
    }

// Tìm máy bay (nhập mã từ bàn phím)
    public MayBay tim() {
        System.out.print("Nhập mã máy bay cần tìm: ");
        String ma = sc.nextLine();

        for (int i = 0; i < soluong; i++) {
            if (dsmaybay[i].getMaMayBay().equals(ma)) {
                return dsmaybay[i];
            }
        }
        return null;
    }

// Tìm vị trí của máy bay trong mảng (phục vụ xóa/sửa)
    public int timViTri(String ma) {
        for (int i = 0; i < soluong; i++) {
            if (dsmaybay[i].getMaMayBay().equals(ma)) {
                return i;
            }
        }
        return -1;
    }
    
    public MayBay[] dsLoaiMayBay(String loaimaybay){
        MayBay ds[] = new MayBay[0];
        int j = 0;
        for (int i = 0; i < dsmaybay.length; i++) {
            if(dsmaybay[i].getLoaiMayBay().equals(loaimaybay)){
                ds = Arrays.copyOf(dsmaybay, j + 1);
                ds[j] = new MayBay();
                ds[j] = dsmaybay[i];
                j++;
            }
        }
        return ds;
    }
    
    public MayBay[][] thongKeLoaiMayBay(){
        String loai[] = {"Airbus A321", "Airbus A350-900", "Boeing 787-10", "Airbus A320"};
        MayBay[][] cacds= new MayBay[0][0];
        for (int i = 0; i < loai.length; i++) {
            cacds = Arrays.copyOf(cacds, i + 1);
            MayBay[] ds = new MayBay[dsLoaiMayBay(loai[i]).length];
            ds = dsLoaiMayBay(loai[i]);
            if(ds != null){
                cacds[i] = Arrays.copyOf(cacds[i], cacds[i].length  + ds.length);
                cacds[i] = ds;
            }
        }
        return cacds;
    }

    public void menu(){
        System.out.println("+--------------------Danh sách máy bay--------------------+");
        System.out.println("|  1. Nhập danh sách máy bay                              |");
        System.out.println("|  2. Đọc danh sách máy bay từ File                       |");
        System.out.println("|  3. Thêm 1 máy bay vào danh sách                        |");
        System.out.println("|  4. Xóa 1 máy bay khỏi danh sách                        |");
        System.out.println("|  5. Sửa thông tin máy bay                               |");
        System.out.println("|  6. Tìm máy bay                                         |");
        System.out.println("|  7. Thống kê máy bay theo loại máy bay                  |");
        System.out.println("+---------------------------------------------------------+");
    }
    
    public void choice() {
    String c;
    boolean nhapSai;

    do {
        nhapSai = false;
        menu();
        System.out.print("Mời chọn chức năng (0 để thoát): ");
        c = sc.next();

        switch (c) {
            case "0":
                System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                break;

            case "1":
                nhapDS();
                break;

            case "2":
                docFile();
                break;

            case "3": // thêm máy bay
                System.out.println("+-------------- Thêm Máy Bay --------------+");
                System.out.println("|  1. Thêm máy bay không có tham số        |");
                System.out.println("|  2. Thêm máy bay có tham số              |");
                System.out.println("+------------------------------------------+");
                System.out.print("Chọn kiểu thêm máy bay: ");
                String t = sc.next();
                sc.nextLine(); // bỏ Enter

                if (t.equals("1")) {
                    them();
                } else if (t.equals("2")) {
                    System.out.print("Nhập mã máy bay muốn thêm: ");
                    String ma = sc.nextLine();
                    them(ma);
                } else {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
                break;

            case "4": // xóa máy bay
                System.out.println("+--------------- Xóa Máy Bay ---------------+");
                System.out.println("|  1. Xóa máy bay không có tham số          |");
                System.out.println("|  2. Xóa máy bay có tham số                |");
                System.out.println("+-------------------------------------------+");
                System.out.print("Chọn kiểu xóa máy bay: ");
                String x = sc.next();
                sc.nextLine();

                if (x.equals("1")) {
                    xoa();
                } else if (x.equals("2")) {
                    System.out.print("Nhập mã máy bay cần xóa: ");
                    String ma = sc.nextLine();
                    xoa(ma);
                } else {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
                break;

            case "5": // sửa máy bay
                System.out.println("+--------------- Sửa Máy Bay ---------------+");
                System.out.println("|  1. Sửa máy bay không có tham số          |");
                System.out.println("|  2. Sửa máy bay có tham số                |");
                System.out.println("+-------------------------------------------+");
                System.out.print("Chọn kiểu sửa máy bay: ");
                String s = sc.next();
                sc.nextLine();

                if (s.equals("1")) {
                    sua();
                } else if (s.equals("2")) {
                    System.out.print("Nhập mã máy bay cần sửa: ");
                    String ma = sc.nextLine();
                    sua(ma);
                } else {
                    System.out.println("Lựa chọn không hợp lệ!");
                }
                break;

            case "6": // tìm máy bay
                System.out.println("+--------------- Tìm Máy Bay ---------------+");
                System.out.println("|  1. Tìm máy bay không có tham số          |");
                System.out.println("|  2. Tìm máy bay có tham số                |");
                System.out.println("|  3. Tìm vị trí máy bay                    |");
                System.out.println("+-------------------------------------------+");
                System.out.print("Chọn kiểu tìm: ");
                String tm = sc.next();
                sc.nextLine();

                switch (tm) {
                    case "1":
                        MayBay mb1 = tim();
                        if (mb1 != null) mb1.xuatMayBay();
                        else System.out.println("Không tìm thấy máy bay!");
                        break;

                    case "2":
                        System.out.print("Nhập mã máy bay cần tìm: ");
                        String ma = sc.nextLine();
                        MayBay mb2 = tim(ma);
                        if (mb2 != null) mb2.xuatMayBay();
                        else System.out.println("Không tìm thấy máy bay!");
                        break;

                    case "3":
                        System.out.print("Nhập mã máy bay cần tìm vị trí: ");
                        String maVT = sc.nextLine();
                        int vt = timViTri(maVT);
                        if (vt != -1)
                            System.out.println("Máy bay ở vị trí: " + vt);
                        else
                            System.out.println("Không tìm thấy máy bay!");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
                break;

            case "7": // thống kê loại máy bay
                System.out.println("+---------- Thống Kê Theo Loại Máy Bay ----------+");
                MayBay[][] tk = thongKeLoaiMayBay();
                String[] loai = {"Airbus A321", "Airbus A350-900", "Boeing 787-10", "Airbus A320"};
                
                for (int i = 0; i < tk.length; i++) {
                    System.out.println("Loại: " + loai[i]);
                    if (tk[i] != null && tk[i].length > 0) {
                        for (MayBay mb : tk[i]) {
                            mb.xuatMayBay();
                        }
                    } else {
                        System.out.println("Không có máy bay loại này.");
                    }
                    System.out.println("------------------------------------------------");
                }
                break;

            default:
                System.out.println("Chọn không đúng, hãy chọn lại chức năng (0-7)");
                nhapSai = true;
        }

        if (!nhapSai && !c.equals("0")) {
            System.out.println("Bạn có muốn thoát chương trình?");
            System.out.println("Nếu có -> (0) | Thao tác tiếp -> (1-7)");
        }

    } while (!c.equals("0"));
}

}
