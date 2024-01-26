/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class NhaXuatBan {
    private int Id_NXB;
    private String Ma_NXB;
    private String TenNXB;
    private String DiaChiNXB;
    private int TrangThai;

    public NhaXuatBan() {
    }

    public NhaXuatBan(int Id_NXB, String Ma_NXB, String TenNXB, String DiaChiNXB, int TrangThai) {
        this.Id_NXB = Id_NXB;
        this.Ma_NXB = Ma_NXB;
        this.TenNXB = TenNXB;
        this.DiaChiNXB = DiaChiNXB;
        this.TrangThai = TrangThai;
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
    public String TrangThaiString(){
        String TrangThaiString = null;
        if(TrangThai == 2){
            TrangThaiString = "Đã Xoá";
        }else if(TrangThai == 1){
            TrangThaiString = "Còn Tồn Tại";
        }
        return TrangThaiString;
    }
    
}
