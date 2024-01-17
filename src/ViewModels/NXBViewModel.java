/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Hieu
 */
public class NXBViewModel {
    private int Stt;
    private int Id_NXB;
    private String Ma_NXB;
    private String TenNXB;
    private String DiaChiNXB;
    private int TrangThai;
    private String TenTrangThai;

    public NXBViewModel() {
    }

    public NXBViewModel(int Stt, int Id_NXB, String Ma_NXB, String TenNXB, String DiaChiNXB, int TrangThai, String TenTrangThai) {
        this.Stt = Stt;
        this.Id_NXB = Id_NXB;
        this.Ma_NXB = Ma_NXB;
        this.TenNXB = TenNXB;
        this.DiaChiNXB = DiaChiNXB;
        this.TrangThai = TrangThai;
        this.TenTrangThai = TenTrangThai;
    }

    public int getStt() {
        return Stt;
    }

    public void setStt(int Stt) {
        this.Stt = Stt;
    }

    public int getId_NXB() {
        return Id_NXB;
    }

    public void setId_NXB(int Id_NXB) {
        this.Id_NXB = Id_NXB;
    }

    public String getMa_NXB() {
        return Ma_NXB;
    }

    public void setMa_NXB(String Ma_NXB) {
        this.Ma_NXB = Ma_NXB;
    }

    public String getTenNXB() {
        return TenNXB;
    }

    public void setTenNXB(String TenNXB) {
        this.TenNXB = TenNXB;
    }

    public String getDiaChiNXB() {
        return DiaChiNXB;
    }

    public void setDiaChiNXB(String DiaChiNXB) {
        this.DiaChiNXB = DiaChiNXB;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getTenTrangThai() {
        return TenTrangThai;
    }

    public void setTenTrangThai(String TenTrangThai) {
        this.TenTrangThai = TenTrangThai;
    }
    
    
}
