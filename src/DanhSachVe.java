package src;

import java.io.*;
import java.util.*;

public class DanhSachVe {
    private Ve[] dsVe;
    private int soLuong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachVe(){
        this.soLuong = 0;
        this.dsVe = new Ve[soLuong];
    }
    public DanhSachVe(Ve[] dsVe, int soLuong){
        this.soLuong = soLuong;
        this.dsVe = new Ve[soLuong];
    }
    public DanhSachVe(DanhSachVe other){
        this.soLuong = other.soLuong;
        this.dsVe = Arrays.copyOf(other.dsVe, this.soLuong);
    }

    public int getSoLuong(){return soLuong;}
    public Ve[] getDSVe(){return Arrays.copyOf(dsVe, soLuong);}

    public void docFileVe() {
        try {
            FileReader f = new FileReader("dsVe.txt");
            Scanner doc = new Scanner(f);

            soLuong = 0;
            dsVe = new Ve[0];

            while (doc.hasNextLine()) { // doc tung dong
                String line = doc.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] tokens = line.split(",");
                if (tokens.length < 7) continue;

                dsVe = Arrays.copyOf(dsVe, dsVe.length + 1);

                if(tokens[0].toLowerCase().startsWith("vvip")){
                    VeVIP veVIP = new VeVIP();
                    veVIP.setMaVe(tokens[0]);
                    veVIP.setMaChuyenBay(tokens[1]);
                    veVIP.setMaGhe(tokens[2]);
                    veVIP.setGiaVe(Double.parseDouble(tokens[3]));
                    veVIP.setLoaiVe(tokens[4]);
                    veVIP.setPhongCho(tokens[5]);
                    veVIP.setQuaTang(tokens[6]);
                    dsVe[soLuong] = veVIP;
                }

                else if (tokens[0].toLowerCase().startsWith("vth")) {
                    VeThuong veThuong = new VeThuong();
                    veThuong.setMaVe(tokens[0]);
                    veThuong.setMaChuyenBay(tokens[1]);
                    veThuong.setMaGhe(tokens[2]);
                    veThuong.setGiaVe(Double.parseDouble(tokens[3]));
                    veThuong.setLoaiVe(tokens[4]);
                    veThuong.setPhiHanhLy(Double.parseDouble(tokens[5]));
                    veThuong.setPhiDichVu(Double.parseDouble(tokens[6]));
                    dsVe[soLuong] = veThuong;
                }
                
                soLuong++;
            }

            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi khi doc file!");
        } catch (Exception e) {
            System.out.println("Loi dinh dang du lieu trong file!");
        }
    }










    // PHƯƠNG THỨC GHI FILE TOÀN BỘ DANH SÁCH
    public void ghiFileVe() {
        try {
            FileWriter writef = new FileWriter("dsVe.txt");
            
            for (int i = 0; i < soLuong; i++) writef.write(dsVe[i].toString() + "\n");
            
            writef.close();
            System.out.println("Da luu danh sach ve vao file thanh cong!");
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi khi doc file!");
        }
    }
    // PHƯƠNG THỨC GHI FILE TỪNG THAO TÁC
    public void ghiFileVe(Ve ve) {
        try {
            File f = new File("dsVe.txt");
            FileWriter writef = new FileWriter(f, true);

            if (f.length() > 0) writef.write("\n");

            writef.write(ve.toString());

            writef.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi khi doc file!");
        }
    }





    




    public Ve timVe() {
        String maVe;
        System.out.print("Nhap ma ve can tim: ");
        maVe = sc.nextLine();

        return timVe(maVe);
    }
    public Ve timVe(String maVe) {
        for (int i = 0; i < soLuong; i++) if (dsVe[i].getMaVe().equalsIgnoreCase(maVe)) return dsVe[i];
        
        return null;
    }










    public int timViTriVe() {
        String maVe;
        System.out.print("Nhap ma ve can tim: ");
        maVe = sc.nextLine();

        return timViTriVe(maVe);
    }
    public int timViTriVe(String maVe) {
        for (int i = 0; i < soLuong; i++) if (dsVe[i].getMaVe().equalsIgnoreCase(maVe)) return i;

        return -1;
    }










    public void nhapDSVe() {
        System.out.print("Nhap so luong ve: "); this.soLuong = sc.nextInt();
        sc.nextLine(); // đọc bỏ dấu xuống dòng, xóa phím Enter thừa
        this.dsVe = new Ve[soLuong];

        for (int i = 0; i < soLuong; i++) {
            System.out.println("\n\t\t\tNhap thong tin ve thu " + i + ":");
            
            String choice;
            while (true) {
                System.out.println("+==================== Loai Ve ===================+");
                System.out.println("|  v. VE VIP                                      |");
                System.out.println("|  t. VE THUONG                                   |");
                System.out.println("+=================================================+");
                System.out.print("Chon loai ve (v. VE VIP; t. VE THUONG): ");
                
                choice = sc.nextLine().toLowerCase();
                
                if (choice.equalsIgnoreCase("v") || choice.equalsIgnoreCase("t")) break;

                System.out.println("Lua chon khong hop le! Vui long chon v hoac t.");
            }

            String maVe;
            while (true) {
                System.out.print("Nhap ma ve: ");
                maVe = sc.nextLine();
                
                if (timVe(maVe) == null) break;

                System.out.println("Ma ve da ton tai! Vui long nhap ma ve khac.");
            }

            try {
                if (choice.equalsIgnoreCase("v")) {
                    dsVe[i] = new VeVIP();
                    dsVe[i].setMaVe(maVe);
                    dsVe[i].nhapVe();
                } else {
                    dsVe[i] = new VeThuong();
                    dsVe[i].setMaVe(maVe);
                    dsVe[i].nhapVe();
                }
            } catch (Exception e) {
                System.out.println("Loi nhap du lieu! Vui long nhap lai.");
                i--;
                sc.nextLine(); // clear buffer
            }
        }
        // GHI FILE SAU KHI NHẬP TOÀN BỘ
        ghiFileVe();
    }
    
    








    public void xuatDSVe() {
        System.out.println("So Luong: " + soLuong);

        if (soLuong == 0){
            System.out.println("\n\t\t\t ====> Khong tim thay ket qua nao! Danh sach ve trong!");
            return;
        }
        
        System.out.println("\n\t\t\t=== DANH SACH VE THUONG ===");
        System.out.println("+=================+=================+=================+============+=================+============+============+============+");
        System.out.println("|      Ma Ve      |  Ma Chuyen Bay  |      Ma Ghe     |   Gia Ve   |      Loai Ve    |Phi Hanh Ly |Phi Dich Vu |Tong Tien Ve|");
        System.out.println("+=================+=================+=================+============+=================+============+============+============+");

        for (int i = 0; i < soLuong; i++)
            if (dsVe[i] instanceof VeThuong){
                dsVe[i].xuatVe();

                System.out.println("+-----------------+-----------------+-----------------+------------+-----------------+------------+------------+------------+");
            }           

        System.out.println("\n\t\t\t=== DANH SACH VE VIP ===");
        System.out.println("+=================+=================+=================+============+=================+=================+=================+============+");
        System.out.println("|      Ma Ve      |  Ma Chuyen Bay  |      Ma Ghe     |   Gia Ve   |      Loai Ve    |    Phong Cho    |     Qua Tang    |Tong Tien Ve|");
        System.out.println("+=================+=================+=================+============+=================+=================+=================+============+");

        for (int i = 0; i < soLuong; i++)
            if (dsVe[i] instanceof VeVIP){
                dsVe[i].xuatVe();

                System.out.println("+-----------------+-----------------+-----------------+------------+-----------------+-----------------+-----------------+------------+");
            }
    }










    public void themVe(){
        System.out.println("\n\t\t\t=== NHAP THONG TIN VE MOI ===");

        String choice;
        while (true) {
            System.out.println("+==================== Loai Ve ===================+");
            System.out.println("|  v. VE VIP                                      |");
            System.out.println("|  t. VE THUONG                                   |");
            System.out.println("+=================================================+");
            System.out.print("Chon loai ve (v. VE VIP; t. VE THUONG): ");
            
            choice = sc.nextLine().toLowerCase();
            
            if (choice.equalsIgnoreCase("v") || choice.equalsIgnoreCase("t")) break;

            System.out.println("Lua chon khong hop le! Vui long chon v hoac t.");
        }

        String maVe;
        while (true) {
            System.out.print("Nhap ma ve can them: ");
            maVe = sc.nextLine();
            
            if (timVe(maVe) == null) break;

            System.out.println("Ma ve da ton tai! Vui long nhap ma ve khac.");
        }

        try {
            if (choice.equalsIgnoreCase("v")) {
                dsVe = Arrays.copyOf(dsVe, soLuong + 1);
                dsVe[soLuong] = new VeVIP();
                dsVe[soLuong].setMaVe(maVe);
                dsVe[soLuong].nhapVe();
            } else {
                dsVe = Arrays.copyOf(dsVe, soLuong + 1);
                dsVe[soLuong] = new VeThuong();
                dsVe[soLuong].setMaVe(maVe);
                dsVe[soLuong].nhapVe();
            }
            soLuong++;
            System.out.println("\n\t\t\t ====> Da them ve moi thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi nhap du lieu! Vui long nhap lai.");
        }
    }
    public void themVe(Ve ve) {
        if (timVe(ve.getMaVe()) != null){
            System.out.println("Ma ve da ton tai! Khong the them.");
            return;
        }

        dsVe = Arrays.copyOf(dsVe, soLuong + 1);
        dsVe[soLuong] = ve;
        soLuong++;
        System.out.println("\n\t\t\t ====> Da them ve moi thanh cong!");
    }










    public void xoaVe() {
        String maVe;
        System.out.print("Nhap ma ve can xoa: ");
        maVe = sc.nextLine();

        int viTriXoa = timViTriVe(maVe);

        if (viTriXoa != -1) {
            for (int i = viTriXoa; i < soLuong - 1; i++) dsVe[i] = dsVe[i + 1];
            
            // dsVe[soLuong - 1] = null;
            
            dsVe = Arrays.copyOf(dsVe, soLuong - 1);
            
            soLuong--;
            
            System.out.println("Da xoa ve thanh cong!");
        } else System.out.print("khong tim thay ve can xoa!!!");
    }
    public void xoaVe(String maVe) {
        int viTriXoa = timViTriVe(maVe);
        
        if (viTriXoa != -1) {
            for (int i = viTriXoa; i < soLuong - 1; i++) dsVe[i] = dsVe[i + 1];
            
            // dsVe[soLuong - 1] = null;
            
            dsVe = Arrays.copyOf(dsVe, soLuong - 1);
            
            soLuong--;
            
            System.out.println("Da xoa ve thanh cong!");
        } else System.out.print("khong tim thay ve can xoa!!!");
    }










    public void suaVe() {
        String maVe;
        System.out.print("Nhap ma ve can sua: ");
        maVe = sc.nextLine();

        Ve veCanSua = timVe(maVe);
        
        if (veCanSua != null) {
            if (veCanSua.getMaVe().toUpperCase().startsWith("VVIP")) {
                // Menu sửa vé VIP
                veVIPCanSua((VeVIP) veCanSua); // KHAI BÁO HÀM LOẠI PRIVATE VÌ CHỈ GỌI KHI ĐÃ KIỂM TRA
            } else if (veCanSua.getMaVe().toUpperCase().startsWith("VTH")) {
                // Menu sửa vé Thường
                veThuongCanSua((VeThuong) veCanSua); // KHAI BÁO HÀM LOẠI PRIVATE VÌ CHỈ GỌI KHI ĐÃ KIỂM TRA
            } else {
                System.out.println("Khong ho tro loai ve nay!");
            }
        } else {
            System.out.println("Khong tim thay ve can sua!!!");
        }
    }
    public void suaVe(String maVe) {
        Ve veCanSua = timVe(maVe);
        
        if (veCanSua != null) {
            if (veCanSua.getMaVe().toUpperCase().startsWith("VVIP")) {
                // Menu sửa vé VIP
                veVIPCanSua((VeVIP) veCanSua); // KHAI BÁO HÀM LOẠI PRIVATE VÌ CHỈ GỌI KHI ĐÃ KIỂM TRA
            } else if (veCanSua.getMaVe().toUpperCase().startsWith("VTH")) {
                // Menu sửa vé Thường
                veThuongCanSua((VeThuong) veCanSua); // KHAI BÁO HÀM LOẠI PRIVATE VÌ CHỈ GỌI KHI ĐÃ KIỂM TRA
            } else {
                System.out.println("Khong ho tro loai ve nay!");
            }
        } else {
            System.out.println("Khong tim thay ve can sua!!!");
        }
    }

    // PHƯƠNG THỨC HỖ TRỢ - SỬA VÉ VIP
    private void veVIPCanSua(VeVIP veVIP) {
        int luaChon;
        do {
            System.out.println("\n\t\t\t=== MENU SUA VE VIP ===");
            System.out.println("+===========================================+");
            System.out.println("|  0. Thoat                                 |");
            System.out.println("|  1. Sua Loai Ve                           |");
            System.out.println("|  2. Sua Gia Ve                            |");
            System.out.println("|  3. Sua Phong Cho                         |");
            System.out.println("|  4. Sua Qua Tang                          |");
            System.out.println("+===========================================+");
            System.out.print("Nhap lua chon cua ban: ");
            
            try {
                luaChon = sc.nextInt();
                
                switch (luaChon) {
                    case 0:
                        System.out.println("Thoat menu sua ve VIP!");
                        break;
                        
                    case 1:
                        suaLoaiVe(veVIP);
                        break;
                        
                    case 2:
                        System.out.print("Nhap gia ve moi: ");
                        double giaVeMoi = sc.nextDouble();
                        veVIP.setGiaVe(giaVeMoi);
                        System.out.println("Da cap nhat gia ve thanh cong!");
                        break;
                        
                    case 3:
                        System.out.print("Nhap phong cho moi: ");
                        String phongChoMoi = sc.nextLine();
                        veVIP.setPhongCho(phongChoMoi);
                        System.out.println("Da cap nhat phong cho thanh cong!");
                        break;
                        
                    case 4:
                        System.out.print("Nhap qua tang moi: ");
                        String quaTangMoi = sc.nextLine();
                        veVIP.setQuaTang(quaTangMoi);
                        System.out.println("Da cap nhat qua tang thanh cong!");
                        break;
                        
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon tu 0 den 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen!");
                luaChon = -1;
            } catch (Exception e) {
                System.out.println("Co loi xay ra: " + e.getMessage());
                luaChon = -1;
            }
            
        } while (luaChon != 0);
    }

    // PHƯƠNG THỨC HỖ TRỢ - SỬA VÉ THƯỜNG
    private void veThuongCanSua(VeThuong veThuong) {
        int luaChon;
        do {
            System.out.println("\n\t\t\t=== MENU SUA VE THUONG ===");
            System.out.println("+===========================================+");
            System.out.println("|  0. Thoat                                 |");
            System.out.println("|  1. Sua Loai Ve                           |");
            System.out.println("|  2. Sua Gia Ve                            |");
            System.out.println("|  3. Sua Phi Hanh Ly                       |");
            System.out.println("|  4. Sua Phi Dich Vu                       |");
            System.out.println("+===========================================+");
            System.out.print("Nhap lua chon cua ban: ");
            
            try {
                luaChon = sc.nextInt();
                
                switch (luaChon) {
                    case 0:
                        System.out.println("Thoat menu sua ve thuong!");
                        break;
                        
                    case 1:
                        suaLoaiVe(veThuong);
                        break;
                        
                    case 2:
                        System.out.print("Nhap gia ve moi: ");
                        double giaVeMoi = sc.nextDouble();
                        veThuong.setGiaVe(giaVeMoi);
                        System.out.println("Da cap nhat gia ve thanh cong!");
                        break;
                        
                    case 3:
                        System.out.print("Nhap phi hanh ly moi: ");
                        double phiHanhLyMoi = sc.nextDouble();
                        veThuong.setPhiHanhLy(phiHanhLyMoi);
                        System.out.println("Da cap nhat phi hanh ly thanh cong!");
                        break;
                        
                    case 4:
                        System.out.print("Nhap phi dich vu moi: ");
                        double phiDichVuMoi = sc.nextDouble();
                        veThuong.setPhiDichVu(phiDichVuMoi);
                        System.out.println("Da cap nhat phi dich vu thanh cong!");
                        break;
                        
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon tu 0 den 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen!");
                luaChon = -1;
            } catch (Exception e) {
                System.out.println("Co loi xay ra: " + e.getMessage());
                luaChon = -1;
            }
            
        } while (luaChon != 0);
    }

    // PHƯƠNG THỨC HỖ TRỢ - SỬA LOẠI VÉ VÀ CẬP NHẬT GIÁ TỰ ĐỘNG
    private void suaLoaiVe(Ve ve) {
        int choice;
        String loaiVeMoi = "";
        double giaVeMoi = ve.tinhTienVe();
        
        do {
            System.out.println("\n\t\t\t=== CHON LOAI VE MOI ===");
            System.out.println("+===========================================+");
            System.out.println("|  1. Mot Chieu                             |");
            System.out.println("|  2. Khu Hoi                               |");
            System.out.println("+===========================================+");
            System.out.print("Nhap lua chon: ");
            
            try {
                choice = sc.nextInt();
                
                switch (choice) {
                    case 1:
                        loaiVeMoi = "Mot Chieu";
                        // Nếu đang là khứ hồi chuyển sang một chiều, giảm giá đi 50%
                        if (ve.getLoaiVe().equalsIgnoreCase("Khu Hoi")) {
                            giaVeMoi = (ve.tinhTienVe() / 0.9) * 0.5;
                        }
                        break;
                        
                    case 2:
                        loaiVeMoi = "Khu Hoi";
                        // Nếu đang là một chiều chuyển sang khứ hồi, tăng giá lên gấp 2 nhưng theo chính sách được giảm 10%
                        if (ve.getLoaiVe().equalsIgnoreCase("Mot Chieu")) {
                            giaVeMoi = ve.tinhTienVe() * 2.0 * 0.9;
                        }
                        break;
                        
                    default:
                        System.out.println("Lua chon khong hop le! Vui long chon 1 hoac 2.");
                        continue;
                }
                
                // Cập nhật loại vé và giá vé mới
                ve.setLoaiVe(loaiVeMoi);
                ve.setGiaVe(giaVeMoi);
                
                System.out.println("Da cap nhat loai ve thanh: " + loaiVeMoi);
                System.out.println("Gia ve da duoc cap nhat tu dong: " + giaVeMoi);
                break;
                
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so nguyen!");
                choice = -1;
            }
            
        } while (choice != 1 && choice != 2);
    }










public void menuTimKiemVe() {
    int luaChon;
    
    do {
        System.out.println("\n\n\t\t\t=== MENU TIM KIEM VE ===");
        System.out.println("+=================================================+");
        System.out.println("|  0. Thoat menu tim kiem                         |");
        System.out.println("|  1. Tim theo ma ve                              |");
        System.out.println("|  2. Tim theo ma chuyen bay                      |");
        System.out.println("|  3. Tim theo ma ghe                             |");
        System.out.println("|  4. Tim theo gia ve                             |");
        System.out.println("|  5. Tim theo loai ve                            |");
        System.out.println("|  6. Tim theo phong cho (VIP)                    |");
        System.out.println("|  7. Tim theo qua tang (VIP)                     |");
        System.out.println("|  8. Tim theo phi hanh ly (Thuong)               |");
        System.out.println("|  9. Tim theo phi dich vu (Thuong)               |");
        System.out.println("+=================================================+");
        System.out.print("Nhap lua chon cua ban: ");
        
        try {
            luaChon = sc.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Vui long nhap so nguyen!");
            luaChon = -1;
            continue;
        }
        
        switch (luaChon) {
            case 0:
                System.out.println("Thoat menu tim kiem ve!");
                break;
                
            case 1:
                DanhSachVe ketQua1 = timMaVe();
                ketQua1.xuatKetQuaTimKiem("THEO MA VE");
                break;
                
            case 2:
                DanhSachVe ketQua2 = timMaChuyenBay();
                ketQua2.xuatKetQuaTimKiem("THEO MA CHUYEN BAY");
                break;
                
            case 3:
                DanhSachVe ketQua3 = timMaGhe();
                ketQua3.xuatKetQuaTimKiem("THEO MA GHE");
                break;
                
            case 4:
                DanhSachVe ketQua4 = timGiaVe();
                ketQua4.xuatKetQuaTimKiem("THEO GIA VE");
                break;
                
            case 5:
                DanhSachVe ketQua5 = timLoaiVe();
                ketQua5.xuatKetQuaTimKiem("THEO LOAI VE");
                break;
                
            case 6:
                DanhSachVe ketQua6 = timPhongCho();
                ketQua6.xuatKetQuaTimKiem("THEO PHONG CHO");
                break;
                
            case 7:
                DanhSachVe ketQua7 = timQuaTang();
                ketQua7.xuatKetQuaTimKiem("THEO QUA TANG");
                break;
                
            case 8:
                DanhSachVe ketQua8 = timPhiHanhLy();
                ketQua8.xuatKetQuaTimKiem("THEO PHI HANH LY");
                break;
                
            case 9:
                DanhSachVe ketQua9 = timPhiDichVu();
                ketQua9.xuatKetQuaTimKiem("THEO PHI DICH VU");
                break;
                
            default:
                System.out.println("Lua chon khong hop le! Vui long chon tu 0 den 10.");
                break;
        }
        
    } while (luaChon != 0);
}

// ==================== PHƯƠNG THỨC TÌM KIẾM VÉ ====================

    // Tìm vé theo mã vé
    public DanhSachVe timMaVe() {
        System.out.print("Nhap ma ve can tim: ");
        String maVe = sc.nextLine();
        return timMaVe(maVe);
    }

    public DanhSachVe timMaVe(String maVe) {
        DanhSachVe ketQua = new DanhSachVe();
        for (int i = 0; i < soLuong; i++) {
            if (dsVe[i].getMaVe().equalsIgnoreCase(maVe)) {
                ketQua.themVe(dsVe[i]);
            }
        }
        return ketQua;
    }

    // Tìm vé theo mã chuyến bay
    public DanhSachVe timMaChuyenBay() {
        System.out.print("Nhap ma chuyen bay can tim: ");
        String maChuyenBay = sc.nextLine();
        return timMaChuyenBay(maChuyenBay);
    }

    public DanhSachVe timMaChuyenBay(String maChuyenBay) {
        DanhSachVe ketQua = new DanhSachVe();
        for (int i = 0; i < soLuong; i++) {
            if (dsVe[i].getMaChuyenBay().equalsIgnoreCase(maChuyenBay)) {
                ketQua.themVe(dsVe[i]);
            }
        }
        return ketQua;
    }

    // Tìm theo mã ghế
    public DanhSachVe timMaGhe() {
        System.out.print("Nhap ma ghe can tim: ");
        String maGhe = sc.nextLine();
        return timMaGhe(maGhe);
    }

    public DanhSachVe timMaGhe(String maGhe) {
        DanhSachVe ketQua = new DanhSachVe();
        for (int i = 0; i < soLuong; i++) {
            if (dsVe[i].getMaGhe().equalsIgnoreCase(maGhe)) {
                ketQua.themVe(dsVe[i]);
            }
        }
        return ketQua;
    }

    // Tìm theo giá vé
    public DanhSachVe timGiaVe() {
        System.out.print("Nhap gia ve can tim: ");
        double giaVe = sc.nextDouble();
        return timGiaVe(giaVe);
    }

    public DanhSachVe timGiaVe(double giaVe) {
        DanhSachVe ketQua = new DanhSachVe();
        for (int i = 0; i < soLuong; i++) {
            if (dsVe[i].getGiaVe() == giaVe) {
                ketQua.themVe(dsVe[i]);
            }
        }
        return ketQua;
    }

    // Tìm theo loại vé
    public DanhSachVe timLoaiVe() {
        System.out.print("Nhap loai ve can tim (Mot Chieu/Khu Hoi): ");
        String loaiVe = sc.nextLine();
        return timLoaiVe(loaiVe);
    }

    public DanhSachVe timLoaiVe(String loaiVe) {
        DanhSachVe ketQua = new DanhSachVe();
        for (int i = 0; i < soLuong; i++) {
            if (dsVe[i].getLoaiVe().equalsIgnoreCase(loaiVe)) {
                ketQua.themVe(dsVe[i]);
            }
        }
        return ketQua;
    }

    // Tìm theo phòng chờ (chỉ áp dụng cho vé VIP)
    public DanhSachVe timPhongCho() {
        System.out.print("Nhap phong cho can tim: ");
        String phongCho = sc.nextLine();
        return timPhongCho(phongCho);
    }

    public DanhSachVe timPhongCho(String phongCho) {
        DanhSachVe ketQua = new DanhSachVe();
        for (int i = 0; i < soLuong; i++) {
            if (dsVe[i] instanceof VeVIP) {
                VeVIP veVIP = (VeVIP) dsVe[i];
                if (veVIP.getPhongCho().equalsIgnoreCase(phongCho)) {
                    ketQua.themVe(veVIP);
                }
            }
        }
        return ketQua;
    }

    // Tìm theo quà tặng (chỉ áp dụng cho vé VIP)
    public DanhSachVe timQuaTang() {
        System.out.print("Nhap qua tang can tim: ");
        String quaTang = sc.nextLine();
        return timQuaTang(quaTang);
    }

    public DanhSachVe timQuaTang(String quaTang) {
        DanhSachVe ketQua = new DanhSachVe();
        for (int i = 0; i < soLuong; i++) {
            if (dsVe[i] instanceof VeVIP) {
                VeVIP veVIP = (VeVIP) dsVe[i];
                if (veVIP.getQuaTang().equalsIgnoreCase(quaTang)) {
                    ketQua.themVe(veVIP);
                }
            }
        }
        return ketQua;
    }

    // Tìm theo phí hành lý (chỉ áp dụng cho vé thường)
    public DanhSachVe timPhiHanhLy() {
        System.out.print("Nhap phi hanh ly can tim: ");
        double phiHanhLy = sc.nextDouble();
        return timPhiHanhLy(phiHanhLy);
    }

    public DanhSachVe timPhiHanhLy(double phiHanhLy) {
        DanhSachVe ketQua = new DanhSachVe();
        for (int i = 0; i < soLuong; i++) {
            if (dsVe[i] instanceof VeThuong) {
                VeThuong veThuong = (VeThuong) dsVe[i];
                if (veThuong.getPhiHanhLy() == phiHanhLy) {
                    ketQua.themVe(veThuong);
                }
            }
        }
        return ketQua;
    }

    // Tìm theo phí dịch vụ (chỉ áp dụng cho vé thường)
    public DanhSachVe timPhiDichVu() {
        System.out.print("Nhap phi dich vu can tim: ");
        double phiDichVu = sc.nextDouble();
        return timPhiDichVu(phiDichVu);
    }

    public DanhSachVe timPhiDichVu(double phiDichVu) {
        DanhSachVe ketQua = new DanhSachVe();
        for (int i = 0; i < soLuong; i++) {
            if (dsVe[i] instanceof VeThuong) {
                VeThuong veThuong = (VeThuong) dsVe[i];
                if (veThuong.getPhiDichVu() == phiDichVu) {
                    ketQua.themVe(veThuong);
                }
            }
        }
        return ketQua;
    }

// ==================== PHƯƠNG THỨC HỖ TRỢ ====================

    // Phương thức hiển thị kết quả tìm kiếm
    public void xuatKetQuaTimKiem(String tieuDe) {
        System.out.println("\n\t\t\t=== KET QUA TIM KIEM: " + tieuDe + " ===");
        xuatDSVe();
    }









    public double tinhGiaVeTrungBinh(){
        if (soLuong == 0) return 0;
        double tongGiaVe = 0;
        for(int i = 0; i < soLuong; i++) tongGiaVe += dsVe[i].tinhTongTien();
        return tongGiaVe / soLuong;
    }

}