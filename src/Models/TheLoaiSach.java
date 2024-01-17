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
    private String TrangThai;

    public TheLoaiSach() {
    }

    public TheLoaiSach(int Id_TLS, int Id_Sach, int Id_TL, String Ma_TLS, String TrangThai) {
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

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
