/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author Hieu
 */
public class MaGiamGiaHoaDon {
    private int Id_MGGHD;
    private int Id_HD;
    private int Id_MGG;
    private Date NgaySuDung;
    private int TrangThai;

    public MaGiamGiaHoaDon() {
    }

    public MaGiamGiaHoaDon(int Id_MGGHD, int Id_HD, int Id_MGG, Date NgaySuDung, int TrangThai) {
        this.Id_MGGHD = Id_MGGHD;
        this.Id_HD = Id_HD;
        this.Id_MGG = Id_MGG;
        this.NgaySuDung = NgaySuDung;
        this.TrangThai = TrangThai;
    }

    public int getId_MGGHD() {
        return Id_MGGHD;
    }

    public void setId_MGGHD(int Id_MGGHD) {
        this.Id_MGGHD = Id_MGGHD;
    }

    public int getId_HD() {
        return Id_HD;
    }

    public void setId_HD(int Id_HD) {
        this.Id_HD = Id_HD;
    }

    public int getId_MGG() {
        return Id_MGG;
    }

    public void setId_MGG(int Id_MGG) {
        this.Id_MGG = Id_MGG;
    }

    public Date getNgaySuDung() {
        return NgaySuDung;
    }

    public void setNgaySuDung(Date NgaySuDung) {
        this.NgaySuDung = NgaySuDung;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
