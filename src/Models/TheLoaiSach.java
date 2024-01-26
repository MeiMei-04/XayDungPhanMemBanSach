/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class TheLoaiSach {

    private int Id_TLS;
    private int Id_Sach;
    private int Id_TL;
    private String Ma_TLS;
    private int TrangThai;

    public TheLoaiSach() {
    }

    public TheLoaiSach(int Id_TLS, int Id_Sach, int Id_TL, String Ma_TLS, int TrangThai) {
        this.Id_TLS = Id_TLS;
        this.Id_Sach = Id_Sach;
        this.Id_TL = Id_TL;
        this.Ma_TLS = Ma_TLS;
        this.TrangThai = TrangThai;
    }

    public int getId_TLS() {
        return Id_TLS;
    }

    public void setId_TLS(int Id_TLS) {
        this.Id_TLS = Id_TLS;
    }

    public int getId_Sach() {
        return Id_Sach;
    }

    public void setId_Sach(int Id_Sach) {
        this.Id_Sach = Id_Sach;
    }

    public int getId_TL() {
        return Id_TL;
    }

    public void setId_TL(int Id_TL) {
        this.Id_TL = Id_TL;
    }

    public String getMa_TLS() {
        return Ma_TLS;
    }

    public void setMa_TLS(String Ma_TLS) {
        this.Ma_TLS = Ma_TLS;
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
