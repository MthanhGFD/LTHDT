package src;

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
        int i = 0;
        try {
            FileReader f = new FileReader("dsGhe.txt");
            Scanner doc = new Scanner(f);
            while (doc.hasNextLine()) {
                String dong = doc.nextLine();
                String[] tach = dong.split(",");
                dsGhe = Arrays.copyOf(dsGhe, i + 1);
                dsGhe[i] = new Ghe(tach[0], tach[1], tach[2], tach[3]);
            }
            soLuong = i;
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file!");
        } catch (IOException e) {
            System.out.println("Loi doc file!");
        }
    }

    // ghi lại toàn bộ ds mới
    public void ghiFile() {
        try {
            File f = new File("dsGhe.txt");
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < dsGhe.length; i++) {
                fw.write(dsGhe[i].toString());
                fw.write("\n");
            }
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("file khong ton tai");

        } catch (IOException e) {
            System.out.println("Loi ghi file");
        }
    }

    // Xuat danh sach ghe
    public void xuatDS() {
        System.out.println("            ================== Danh Sach ghe ==================");
        System.out.println("+-----------------+----------------------+--------------+-----------------+");
        System.out.println("|     Ma ghe      |      Vi tri ghe      |  Trang thai  |   May may bay   |");
        System.out.println("+-----------------+----------------------+--------------+-----------------+");
        for (int i = 0; i < soLuong; i++) {
            dsGhe[i].xuatGhe();
        }
        System.out.println("+-----------------+----------------------+--------------+-----------------+");
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
            soLuong++;
            System.out.println("Da them ghe thanh cong!");
        } else {
            System.out.println("Ma ghe da ton tai!");
        }
    }

    // Them ghe (co tham so)
    public void them(Ghe ghe) {
        dsGhe = Arrays.copyOf(dsGhe, soLuong + 1);
        dsGhe[soLuong] = ghe;
        soLuong++;
        System.out.println("Da them ghe thanh cong!");
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

    // Tim ghe theo ma
    public Ghe tim(String maghe) {
        for (int i = 0; i < dsGhe.length; i++) {
            if (dsGhe[i].getMaGhe().equals(maghe)) {
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

    public Ghe timViTriGhe(String viTri){
        for (int i = 0; i < dsGhe.length; i++) {
            if(dsGhe[i].getViTriGhe().equals(viTri))
                return dsGhe[i];
        }
        return null;
    }
    
    public Ghe[] gheTrong() {
        Ghe[] ds = new Ghe[0];
        int j = 0;
        for (int i = 0; i < dsGhe.length; i++) {
            if (dsGhe[i].getTrangThai().equals("Trong")) {
                ds = Arrays.copyOf(dsGhe, j + 1);
                ds[j] = new Ghe();
                ds[j] = dsGhe[i];
                j++;
            }
        }
        return ds;
    }

    public Ghe[] gheDaDat() {
        Ghe[] ds = new Ghe[0];
        int j = 0;
        for (int i = 0; i < dsGhe.length; i++) {
            if (dsGhe[i].getTrangThai().equals("Da dat")) {
                ds = Arrays.copyOf(dsGhe, j + 1);
                ds[j] = new Ghe();
                ds[j] = dsGhe[i];
                j++;
            }
        }
        return ds;
    }

    public int[] thongKeTrangThaiGhe() {
        int tk[] = new int[2];
        tk[0] = gheTrong().length;
        tk[1] = gheDaDat().length;
        return tk;
    }

    public Ghe[] getDsGhe() {
        return dsGhe;
    }
    
    public void setDsGhe(Ghe[] dsGhe) {
        this.dsGhe = dsGhe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
