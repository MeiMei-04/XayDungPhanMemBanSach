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
public class TacGia {
    private int Id_TG;
    private String Ma_TG;
    private String TenTG;
    private Date NgaySinh;
    private String QuocTich;
    private int TrangThai;

    public TacGia() {
    }

    public TacGia(int Id_TG, String Ma_TG, String TenTG, Date NgaySinh, String QuocTich, int TrangThai) {
        this.Id_TG = Id_TG;
        this.Ma_TG = Ma_TG;
        this.TenTG = TenTG;
        this.NgaySinh = NgaySinh;
        this.QuocTich = QuocTich;
        this.TrangThai = TrangThai;
    }

    public int getId_TG() {
        return Id_TG;
    }

    public void setId_TG(int Id_TG) {
        this.Id_TG = Id_TG;
    }

    public String getMa_TG() {
        return Ma_TG;
    }

    public void setMa_TG(String Ma_TG) {
        this.Ma_TG = Ma_TG;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String TenTG) {
        this.TenTG = TenTG;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getQuocTich() {
        return QuocTich;
    }

    public void setQuocTich(String QuocTich) {
        this.QuocTich = QuocTich;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
