package src;

import java.util.Scanner;

public class VeThuong extends Ve {
    private String 

    public VeThuong() {
        super();
    }

    public VeThuong(String mave, ChuyenBay machuyenbay, Ghe maghe, double giave, boolean phanloai) {
        super(mave, machuyenbay, maghe, giave, phanloai);
    }
    
    @Override
    public double tinhTien() {
        // Neu la ve khu hoi => giam 10%
        if (!(isPhanLoai())) {
            return getGiaVe() * 2 * 0.9; 
        }
        // Neu la ve 1 chieu
        return getGiaVe();
    }
    
    @Override
    public void xuatThongTin() {
        System.out.println("=== VE THUONG ===");
        super.xuatThongTin();
        System.out.println("Tong tien: " + tinhTien());
    }

    @Override
    public double tinhGiaVe() {
    }

    @Override
    public double tinhTienVe() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tinhTienVe'");
    }
}