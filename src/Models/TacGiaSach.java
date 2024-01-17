/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class TacGiaSach {
    private int Id_TGS;
    private int Id_Sach;
    private int Id_TL;
    private String Ma_TLS;
    private int TrangThai;

    public TacGiaSach() {
    }

    public TacGiaSach(int Id_TGS, int Id_Sach, int Id_TL, String Ma_TLS, int TrangThai) {
        this.Id_TGS = Id_TGS;
        this.Id_Sach = Id_Sach;
        this.Id_TL = Id_TL;
        this.Ma_TLS = Ma_TLS;
        this.TrangThai = TrangThai;
    }

    public int getId_TGS() {
        return Id_TGS;
    }

    public void setId_TGS(int Id_TGS) {
        this.Id_TGS = Id_TGS;
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
    
}
