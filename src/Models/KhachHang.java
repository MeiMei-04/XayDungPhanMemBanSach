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
public class KhachHang {
    private int Id_KH;
    private String Ma_KH;
    private String TenKH;
    private String SDT;
    private String DiaChi;
    private int GioiTinh;
    private Date NgayTao;
    private int TrangThai;

    public KhachHang() {
    }

    public KhachHang(int Id_KH, String Ma_KH, String TenKH, String SDT, String DiaChi, int GioiTinh, Date NgayTao, int TrangThai) {
        this.Id_KH = Id_KH;
        this.Ma_KH = Ma_KH;
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
    }

    public int getId_KH() {
        return Id_KH;
    }

    public void setId_KH(int Id_KH) {
        this.Id_KH = Id_KH;
    }

    public String getMa_KH() {
        return Ma_KH;
    }

    public void setMa_KH(String Ma_KH) {
        this.Ma_KH = Ma_KH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
