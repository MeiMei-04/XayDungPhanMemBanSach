/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class TheLoai {

    private int Id_TL;
    private String Ma_TL;
    private String TenTL;
    private String mota;
    private int TrangThai;

    public TheLoai() {
    }

    public TheLoai(int Id_TL, String Ma_TL, String TenTL, String mota, int TrangThai) {
        this.Id_TL = Id_TL;
        this.Ma_TL = Ma_TL;
        this.TenTL = TenTL;
        this.mota = mota;
        this.TrangThai = TrangThai;
    }

    public int getId_TL() {
        return Id_TL;
    }

    public void setId_TL(int Id_TL) {
        this.Id_TL = Id_TL;
    }

    public String getMa_TL() {
        return Ma_TL;
    }

    public void setMa_TL(String Ma_TL) {
        this.Ma_TL = Ma_TL;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String TenTL) {
        this.TenTL = TenTL;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String TrangThaiString() {
        String TrangThaiString = null;
        if (TrangThai == 2) {
            TrangThaiString = "Đã Xoá";
        } else if (TrangThai == 1) {
            TrangThaiString = "Còn Tồn Tại";
        }
        return TrangThaiString;
    }

}
