package src;

import java.io.FileReader;
import java.util.Scanner;

public class DanhSachChuyenBay {
    private ChuyenBay dschuyenbay[];
    private int soluong;
    static Scanner sc = new Scanner(System.in);
    public DanhSachChuyenBay(){
        dschuyenbay = new ChuyenBay[0];
        soluong = 0;
    }
    
    public DanhSachChuyenBay(ChuyenBay[] dschuyenbay, int soluong){
        this.dschuyenbay = dschuyenbay;
        this.soluong = soluong;
    }
    
    public DanhSachChuyenBay(DanhSachChuyenBay ds){
        dschuyenbay = ds.dschuyenbay;
        soluong = ds.soluong;
    }
    
    public void nhapDS(){
        int sl;
        System.out.print("Nhâp số lượng Chuyến bay: ");
        sl = sc.nextInt();
        soluong = sl;
        for (int i = 0; i < sl; i++) {
            String machuyenbay;
            System.out.print("Nhập mã chuyến bay: ");
            machuyenbay = sc.nextLine();
            if(tim(machuyenbay) == null){
                dschuyenbay[i].nhapChuyenBay();
                String mamaybay, mahang, masanbay;
                System.out.print("Nhập mã máy bay: ");
                mamaybay = sc.nextLine();
                System.out.print("Nhập mã hãng hàng không: ");
                mahang = sc.nextLine();
                System.out.print("Nhập mã sân bay: ");
                masanbay = sc.nextLine();
            }
        }
    }
    
//    public void docFile(){
//        int i = soluong;
//        try {
//            FileReader f = new FileReader("dsChuyenBay.txt");
//            Scanner doc = new Scanner(f);
//            while(doc.hasNextLine()){
//                String line = doc.nextLine();
//                String tokens[] = line.split(",");
//                dschuyenbay[i].setMachuyenbay(tokens[0]);
//                dschuyenbay[i].setDiemkhoihanh(tokens[1]);
//                dschuyenbay[i].setNgaykhoihanh(tokens[2]);
//                dschuyenbay[i].setGiokhoihanh(tokens[3]);
//                dschuyenbay[i].setTinhtrang(tokens[4]);
//                
//            }
//        } catch (Exception e) {
//        } 
//    }
    
    
    
    
    
    // tìm Chuyến bay
    // không tham số
    public ChuyenBay tim(){
        String ma;
        System.out.print("Nhập mã chuyến bay cần tìm:");
        ma = sc.nextLine();
        for (int i = 0; i < dschuyenbay.length; i++) {
            if(dschuyenbay[i].getMachuyenbay().equals(ma))
                return dschuyenbay[i];
        }
        return null;
    }
    
    // có tham số
    public ChuyenBay tim(String ma){
        for (int i = 0; i < dschuyenbay.length; i++) {
            if(dschuyenbay[i].getMachuyenbay().equals(ma))
                return dschuyenbay[i];
        }
        return null;
    }
    
    // tìm vị trí
    public int timViTri(String ma){
        for (int i = 0; i < dschuyenbay.length; i++) {
            if(dschuyenbay[i].getMachuyenbay().equals(ma))
                return i;
        }
        return -1;
    }

    // tìm máy bay trong chuyến bay
    // không tham số mã chuyến bay
    public MayBay timMayBay(String machuyenbay){
        String mamaybay;
        System.out.print("Nhập mã máy bay: ");
        mamaybay = sc.nextLine();
        for (int i = 0; i < dschuyenbay.length; i++) {
            if(dschuyenbay[i].getMaybay().getMaMayBay().equals(mamaybay) && dschuyenbay[i].getMachuyenbay().equals(machuyenbay))
                return dschuyenbay[i].getMaybay();
        }
        return null;
    }
    // có tham số mã chuyến bay
    public MayBay timMayBay(String machuyenbay, String mamaybay){
        for (int i = 0; i < dschuyenbay.length; i++) {
            if(dschuyenbay[i].getMaybay().getMaMayBay().equals(mamaybay) && dschuyenbay[i].getMachuyenbay().equals(machuyenbay))
                return dschuyenbay[i].getMaybay();
        }
        return null;
    }
    
    // tìm hãng hàng không
    // không tham số hãng hàng không
    public HangHangKhong timHangHangKhong(String machuyenbay){
        String mahanghangkhong;
        System.out.print("Nhập mã hãng hàng không: ");
        mahanghangkhong = sc.nextLine();
        for (int i = 0; i < dschuyenbay.length; i++) {
            if(dschuyenbay[i].getHanghangkhong().getMaHang().equals(mahanghangkhong) && dschuyenbay[i].getMachuyenbay().equals(machuyenbay))
                return dschuyenbay[i].getHanghangkhong();
        }
        return null;
    }
    
    // có tham số hãng hàng không
    public HangHangKhong timHangHangKhong(String machuyenbay, String mahanghangkhong){
        for (int i = 0; i < dschuyenbay.length; i++) {
            if(dschuyenbay[i].getHanghangkhong().getMaHang().equals(mahanghangkhong) && dschuyenbay[i].getMachuyenbay().equals(machuyenbay))
                return dschuyenbay[i].getHanghangkhong();
        }
        return null;
    }
    
    // tìm sân bay
    // không có tham số sân bay
    public SanBay timSanBay(String machuyenbay){
        String masanbay;
        System.out.print("Nhập mã sân bay: ");
        masanbay = sc.nextLine();
        for (int i = 0; i < dschuyenbay.length; i++) {
            if(dschuyenbay[i].getSanbay().getMaSanBay().equals(masanbay) && dschuyenbay[i].getMachuyenbay().equals(machuyenbay))
                return dschuyenbay[i].getSanbay();
        }
        return null;
    }
    
    // có tham số sân bay
    public SanBay timSanBay(String machuyenbay, String masanbay){
        for (int i = 0; i < dschuyenbay.length; i++) {
            if(dschuyenbay[i].getSanbay().getMaSanBay().equals(masanbay) && dschuyenbay[i].getMachuyenbay().equals(machuyenbay))
                return dschuyenbay[i].getSanbay();
        }
        return null;
    }
    
}
