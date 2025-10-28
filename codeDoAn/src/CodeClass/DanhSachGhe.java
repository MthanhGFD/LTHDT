package CodeClass;

import java.io.*;
import java.util.*;
import src.HanhKhach;

public class DanhSachGhe {

    private Ghe[] dsGhe;
    private int soLuong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachGhe() {
        dsGhe = new Ghe[0];
        soLuong = 0;
    }

    public DanhSachGhe(Ghe[] dsGhe, int soLuong) {
        this.dsGhe = dsGhe;
        this.soLuong = soLuong;
    }

    public DanhSachGhe(DanhSachGhe ds) {
        dsGhe = ds.dsGhe;
        soLuong = ds.soLuong;
    }

    // Doc file
    public void docFile() {
        try {
            FileReader f = new FileReader("dsGhe.txt");
            Scanner doc = new Scanner(f);
            while (doc.hasNextLine()) {
                String dong = doc.nextLine();
                String[] tach = dong.split(",");
                dsGhe = Arrays.copyOf(dsGhe, dsGhe.length + 1);
                dsGhe[dsGhe.length - 1] = new Ghe(tach[0], tach[1], tach[2]);
            }
            soLuong = dsGhe.length;
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi doc file!");
        }
    }

    // Ghi file
    public void ghiFile(Ghe ghe) {
        try {
            File f = new File("dsGhe.txt");
            FileWriter fw = new FileWriter(f, true);
            if (f.length() != 0) {
                fw.write("\n");
            }
            fw.write(ghe.getMaGhe() + "," + ghe.getMaMayBay() + "," + ghe.getViTriGhe());
            fw.close();
        } catch (IOException e) {
            System.out.println("Loi ghi file!");
        }
    }

    // Nhap danh sach ghe
    public void nhapDS() {
        int sl;
        System.out.print("Nhap so luong ghe: ");
        sl = sc.nextInt();
        soLuong = sl;
        for (int i = 0; i < soLuong; i++) {
            dsGhe = Arrays.copyOf(dsGhe, i + 1);
            dsGhe[i] = new Ghe();
            dsGhe[i].nhapGhe();
            ghiFile(dsGhe[i]);
            System.out.println("==================================");
        }
    }

    // Xuat danh sach ghe
    public void xuatDS() {
        System.out.println("+-----------------+----------------------+----------------------+");
        System.out.printf("| %-15s | %-20s | %-20s |\n", "Ma ghe", "Ma may bay", "Vi tri ghe");
        System.out.println("+-----------------+----------------------+----------------------+");
        for (int i = 0; i < soLuong; i++) {
            System.out.printf("| %-15s | %-20s | %-20s |\n",
                    dsGhe[i].getMaGhe(),
                    dsGhe[i].getMaMayBay(),
                    dsGhe[i].getViTriGhe());
        }
        System.out.println("+-----------------+----------------------+----------------------+");
    }

    // Tim vi tri ghe
    public int timViTri(String maGhe) {
        for (int i = 0; i < soLuong; i++) {
            if (dsGhe[i].getMaGhe().equalsIgnoreCase(maGhe)) {
                return i;
            }
        }
        return -1;
    }

    // Tim ghe theo ma
    public Ghe tim(String maGhe) {
        int vt = timViTri(maGhe);
        if (vt != -1) {
            return dsGhe[vt];
        }
        return null;
    }

    // Them ghe (khong tham so)
    public void them() {
        sc.nextLine();
        System.out.print("Nhap ma ghe: ");
        String ma = sc.nextLine();
        if (tim(ma) == null) {
            dsGhe = Arrays.copyOf(dsGhe, soLuong + 1);
            dsGhe[soLuong] = new Ghe();
            dsGhe[soLuong].nhapGhe();
            ghiFile(dsGhe[soLuong]);
            soLuong++;
            System.out.println("Da them ghe thanh cong!");
        } else {
            System.out.println("Ma ghe da ton tai!");
        }
    }

    // Them ghe (co tham so)
    public void them(Ghe ghe) {
        if (tim(ghe.getMaGhe()) == null) {
            dsGhe = Arrays.copyOf(dsGhe, soLuong + 1);
            dsGhe[soLuong] = ghe;
            ghiFile(ghe);
            soLuong++;
            System.out.println("Da them ghe thanh cong!");
        } else {
            System.out.println("Ghe da ton tai!");
        }
    }

    // Xoa ghe (co tham so)
    public void xoa(String maGhe) {
        int vt = timViTri(maGhe);
        if (vt != -1) {
            for (int i = vt; i < soLuong - 1; i++) {
                dsGhe[i] = dsGhe[i + 1];
            }
            dsGhe = Arrays.copyOf(dsGhe, soLuong - 1);
            soLuong--;
            System.out.println("Da xoa ghe thanh cong!");
        } else {
            System.out.println("Khong tim thay ma ghe!");
        }
    }

    // Xoa ghe (khong tham so)
    public void xoa() {
        sc.nextLine();
        System.out.print("Nhap ma ghe can xoa: ");
        String ma = sc.nextLine();
        xoa(ma);
    }

    // Sua vi tri ghe
    public void sua() {
        sc.nextLine();
        System.out.print("Nhap ma ghe can sua: ");
        String ma = sc.nextLine();
        int vt = timViTri(ma);
        if (vt != -1) {
            System.out.print("Nhap vi tri ghe moi: ");
            String viTriMoi = sc.nextLine();
            dsGhe[vt].setViTriGhe(viTriMoi);
            System.out.println("Da sua thanh cong!");
        } else {
            System.out.println("Khong tim thay ma ghe!");
        }
    }

    // Menu
    public void menu() {
        System.out.println("+--------------- QUAN LY DANH SACH GHE ---------------+");
        System.out.println("| 1. Doc danh sach ghe tu file                        |");
        System.out.println("| 2. Nhap danh sach ghe                               |");
        System.out.println("| 3. Them ghe                                         |");
        System.out.println("| 4. Xoa ghe                                          |");
        System.out.println("| 5. Sua vi tri ghe                                   |");
        System.out.println("| 6. Tim ghe theo ma                                  |");
        System.out.println("| 7. Xuat danh sach ghe                               |");
        System.out.println("| 0. Thoat chuong trinh                               |");
        System.out.println("+-----------------------------------------------------+");
    }

    // Lua chon chuc nang
    public void choice() {
        String chon;
        do {
            menu();
            System.out.print("Chon chuc nang: ");
            chon = sc.next();
            switch (chon) {
                case "1":
                    docFile();
                    break;
                case "2":
                    nhapDS();
                    break;
                case "3":
                    String t;
                    System.out.println("+------------------ THEM GHE ------------------+");
                    System.out.println("| 1. Them ghe khong tham so                   |");
                    System.out.println("| 2. Them ghe co tham so                      |");
                    System.out.println("+---------------------------------------------+");
                    System.out.print("Chon kieu them ghe: ");
                    t = sc.next();
                    if (t.equals("1")) {
                        them();
                    } else if (t.equals("2")) {
                        Ghe g1 = new Ghe("GH01", "MB01", "A00");
                        them(g1);
                    }
                    break;
                case "4":
                    String x;
                    System.out.println("+------------------ XOA GHE ------------------+");
                    System.out.println("| 1. Xoa ghe khong tham so                   |");
                    System.out.println("| 2. Xoa ghe co tham so                      |");
                    System.out.println("+--------------------------------------------+");
                    System.out.print("Chon kieu xoa ghe: ");
                    x = sc.next();
                    if (x.equals("1")) {
                        xoa();
                    } else if (x.equals("2")) {
                        sc.nextLine();
                        System.out.print("Nhap ma ghe can xoa: ");
                        xoa(sc.nextLine());
                    }
                    break;
                case "5":
                    sua();
                    break;
                case "6":
                    sc.nextLine();
                    System.out.print("Nhap ma ghe can tim: ");
                    String ma = sc.nextLine();
                    Ghe g = tim(ma);
                    if (g != null) {
                        g.xuatGhe();
                    } else {
                        System.out.println("Khong tim thay ghe!");
                    }
                    break;
                case "7":
                    xuatDS();
                    break;
                case "0":
                    System.out.println("Cam on da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Chon khong hop le!");
            }
        } while (!chon.equals("0"));
    }
}
