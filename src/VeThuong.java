package CodeClass;

public class VeThuong extends Ve {
    
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}