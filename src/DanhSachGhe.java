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
        System.out.println("+-----------------+----------------------+-----------------+");
        System.out.println("|     Ma ghe      |      Vi tri ghe      |   May may bay   |" );
        System.out.println("+-----------------+----------------------+-----------------+");
        for (int i = 0; i < soLuong; i++) {
            dsGhe[i].xuatGhe();
        }
        System.out.println("+-----------------+----------------------+----------------------+");
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

    public void sua(String ma) {
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

    // Tim ghe khong tham so
    public Ghe tim() {
        String maghe;
        System.out.print("Nhap ma ghe can tim: ");
        maghe = sc.nextLine();
        for (int i = 0; i < dsGhe.length; i++) {
            if (dsGhe[i].equals(maghe)) {
                return dsGhe[i];
            }
        }
        return null;
    }

    // Tim ghe theo ma
    public Ghe tim(String maghe) {
        for (int i = 0; i < dsGhe.length; i++) {
            if (dsGhe[i].equals(maghe)) {
                return dsGhe[i];
            }
        }
        return null;
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

}
