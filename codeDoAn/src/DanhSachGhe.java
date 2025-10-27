
import java.io.*;
import java.util.*;
import src.HanhKhach;

public class DanhSachGhe {

    private Ghe[] dsghe;
    private int soluong;
    static Scanner sc = new Scanner(System.in);

    public DanhSachGhe() {
        dsghe = new Ghe[0];
        soluong = 0;
    }

    public DanhSachGhe(Ghe[] dsghe, int soluong) {
        this.dsghe = dsghe;
        this.soluong = soluong;
    }

    public DanhSachGhe(DanhSachGhe ds) {
        dsghe = ds.dsghe;
        soluong = ds.soluong;
    }

    // Đọc file
    public void docFile() {
        try {
            FileReader f = new FileReader("dsGhe.txt");
            Scanner doc = new Scanner(f);
            while (doc.hasNextLine()) {
                String line = doc.nextLine();
                String[] tokens = line.split(",");
                dsghe = Arrays.copyOf(dsghe, dsghe.length + 1);
                dsghe[dsghe.length - 1] = new Ghe(tokens[0], tokens[1], tokens[2]);
            }
            soluong = dsghe.length;
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println("khong tim thay file!");
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
            fw.write(ghe.getMaghe() + "," + ghe.getMamaybay() + "," + ghe.getVitrighe());
            fw.close();
        } catch (IOException e) {
            System.out.println("Loi ghi file!");
        }
    }

    public void nhapDS(){
        int sl;
        System.out.print("Nhap so luong ghe: ");
        sl = sc.nextInt();
        soluong = sl;
        for (int i = 0; i < soluong; i++) {
           dsghe = Arrays.copyOf(dsghe, i + 1);
           dsghe[i] = new Ghe();
           dsghe[i].inputGhe();
           ghiFile(dsghe[i]);
           System.out.println("=================================="); 
        }
    }
    
    // Xuất danh sách
    public void xuatDS() {
        System.out.println("+-----------------+----------------------+----------------------+");
        System.out.printf("| %-15s | %-20s | %-20s |\n", "Mã ghế", "Mã máy bay", "Vị trí ghế");
        System.out.println("+-----------------+----------------------+----------------------+");
        for (int i = 0; i < soluong; i++) {
            System.out.printf("| %-15s | %-20s | %-20s |\n",
                    dsghe[i].getMaghe(),
                    dsghe[i].getMamaybay(),
                    dsghe[i].getVitrighe());
        }
        System.out.println("+-----------------+----------------------+----------------------+");
    }

    // Tìm vị trí
    public int timViTri(String maghe) {
        for (int i = 0; i < soluong; i++) {
            if (dsghe[i].getMaghe().equalsIgnoreCase(maghe)) {
                return i;
            }
        }
        return -1;
    }

    // Tìm ghế
    public Ghe tim(String maghe) {
        int vt = timViTri(maghe);
        if (vt != -1) {
            return dsghe[vt];
        }
        return null;
    }

    // Thêm ghế (không tham số)
    public void them() {
        System.out.print("Nhập mã ghế: ");
        String ma = sc.nextLine();
        if (tim(ma) == null) {
            dsghe = Arrays.copyOf(dsghe, soluong + 1);
            dsghe[soluong] = new Ghe();
            dsghe[soluong].inputGhe();
            ghiFile(dsghe[soluong]);
            soluong++;
        } else {
            System.out.println("Mã ghế đã tồn tại!");
        }
    }

    // Thêm có tham số
    public void them(Ghe ghe) {
        if (tim(ghe.getMaghe()) == null) {
            dsghe = Arrays.copyOf(dsghe, soluong + 1);
            dsghe[soluong] = ghe;
            ghiFile(ghe);
            soluong++;
        } else {
            System.out.println("Ghế đã tồn tại!");
        }
    }

    // Xóa (có tham số)
    public void xoa(String maghe) {
        int vt = timViTri(maghe);
        if (vt != -1) {
            for (int i = vt; i < soluong - 1; i++) {
                dsghe[i] = dsghe[i + 1];
            }
            dsghe = Arrays.copyOf(dsghe, soluong - 1);
            soluong--;
            System.out.println("Đã xóa ghế thành công!");
        } else {
            System.out.println("Không tìm thấy mã ghế!");
        }
    }

    // Xóa (không tham số)
    public void xoa() {
        sc.nextLine();
        System.out.print("Nhập mã ghế cần xóa: ");
        String ma = sc.nextLine();
        xoa(ma);
    }

    // Sửa
    public void sua() {
        sc.nextLine();
        System.out.print("Nhập mã ghế cần sửa: ");
        String ma = sc.nextLine();
        int vt = timViTri(ma);
        if (vt != -1) {
            String vitrighe;
            System.out.print("Nhap vi tri ghe moi: ");
            vitrighe = sc.nextLine();
            dsghe[vt].setVitrighe(vitrighe);
            System.out.println("Đã sửa thành công!");
        } else {
            System.out.println("Không tìm thấy mã ghế!");
        }
    }

    // Menu
    public void menu() {
        System.out.println("+---------------QUẢN LÝ DANH SÁCH GHẾ---------------+");
        System.out.println("|  1. Đọc danh sách ghế từ file                      |");
        System.out.println("|  2. Thêm ghế                                       |");
        System.out.println("|  3. Xóa ghế                                        |");
        System.out.println("|  4. Sửa ghế                                        |");
        System.out.println("|  5. Tìm ghế theo mã                                |");
        System.out.println("|  6. Xuất danh sách ghế                             |");
        System.out.println("|  0. Thoát                                          |");
        System.out.println("+---------------------------------------------------+");
    }

    public void choice() {
        String chon;
        do {
            menu();
            System.out.print("Chọn chức năng: ");
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
                    System.out.println("+------------------ Them Ghe ------------------+");
                    System.out.println("|  1. Them ghe khong tham so                   |");
                    System.out.println("|  2. Them ghe co tham so                      |");
                    System.out.println("+----------------------------------------------+");
                    System.out.print("Chon kieu them ghe: ");
                    t = sc.next();
                    if (t.equals("1")) {
                        them();
                    }
                    if (t.equals("2")) {
                        Ghe gh1 = new Ghe("GH01", "MB01", "A00");
                        them(gh1);
                    }
                    break;
                case "4":
                    String x;
                    System.out.println("+----------------- Xoa ghe-----------------+");
                    System.out.println("|  1. Xoa ghe khong tham so                |");
                    System.out.println("|  2. Xoa ghe co tham so                   |");
                    System.out.println("+------------------------------------------+");
                    System.out.print("Chon kieu xoa ghe: ");
                    x = sc.next();
                    if (x.equals("1")) {
                        xoa();
                    }
                    if (x.equals("2")) {
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
                        g.outputGhe();
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
                    System.out.println("chon khong hop le");
            }
        } while (!chon.equals("0"));
    }
}
