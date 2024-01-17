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
public class MaGiamGia {
    private int Id_MGG;
    private String Ma_GG;
    private String Mota;
    private int GiaTri;
    private Date NgayTao;
    private Date NgayHetHan;
    private int Soluong;
    private int DieuKien;
    private int TienGiamToiDa;
    private int TrangThai;

    public MaGiamGia() {
    }

    public MaGiamGia(int Id_MGG, String Ma_GG, String Mota, int GiaTri, Date NgayTao, Date NgayHetHan, int Soluong, int DieuKien, int TienGiamToiDa, int TrangThai) {
        this.Id_MGG = Id_MGG;
        this.Ma_GG = Ma_GG;
        this.Mota = Mota;
        this.GiaTri = GiaTri;
        this.NgayTao = NgayTao;
        this.NgayHetHan = NgayHetHan;
        this.Soluong = Soluong;
        this.DieuKien = DieuKien;
        this.TienGiamToiDa = TienGiamToiDa;
        this.TrangThai = TrangThai;
    }

    public int getId_MGG() {
        return Id_MGG;
    }

    public void setId_MGG(int Id_MGG) {
        this.Id_MGG = Id_MGG;
    }

    public String getMa_GG() {
        return Ma_GG;
    }

    public void setMa_GG(String Ma_GG) {
        this.Ma_GG = Ma_GG;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public int getGiaTri() {
        return GiaTri;
    }

    public void setGiaTri(int GiaTri) {
        this.GiaTri = GiaTri;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Date getNgayHetHan() {
        return NgayHetHan;
    }

    public void setNgayHetHan(Date NgayHetHan) {
        this.NgayHetHan = NgayHetHan;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public int getDieuKien() {
        return DieuKien;
    }

    public void setDieuKien(int DieuKien) {
        this.DieuKien = DieuKien;
    }

    public int getTienGiamToiDa() {
        return TienGiamToiDa;
    }

    public void setTienGiamToiDa(int TienGiamToiDa) {
        this.TienGiamToiDa = TienGiamToiDa;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
