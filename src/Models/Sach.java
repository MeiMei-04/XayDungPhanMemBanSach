/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class Sach {
    private int Id_Sach;
    private int Id_KV;
    private int Id_NXB;
    private String Ma_Sach;
    private String TenSach;
    private int NamSanXuat;
    private int SoluongSanPham;
    private int GiaSanPham;
    private String PhanDoan;
    private int SoTrang;
    private String MoTa;
    private int TrangThai;

    public Sach() {
    }

    public Sach(int Id_Sach, int Id_KV, int Id_NXB, String Ma_Sach, String TenSach, int NamSanXuat, int SoluongSanPham, int GiaSanPham, String PhanDoan, int SoTrang, String MoTa, int TrangThai) {
        this.Id_Sach = Id_Sach;
        this.Id_KV = Id_KV;
        this.Id_NXB = Id_NXB;
        this.Ma_Sach = Ma_Sach;
        this.TenSach = TenSach;
        this.NamSanXuat = NamSanXuat;
        this.SoluongSanPham = SoluongSanPham;
        this.GiaSanPham = GiaSanPham;
        this.PhanDoan = PhanDoan;
        this.SoTrang = SoTrang;
        this.MoTa = MoTa;
        this.TrangThai = TrangThai;
    }

    public int getId_Sach() {
        return Id_Sach;
    }

    public void setId_Sach(int Id_Sach) {
        this.Id_Sach = Id_Sach;
    }

    public int getId_KV() {
        return Id_KV;
    }

    public void setId_KV(int Id_KV) {
        this.Id_KV = Id_KV;
    }

    public int getId_NXB() {
        return Id_NXB;
    }

    public void setId_NXB(int Id_NXB) {
        this.Id_NXB = Id_NXB;
    }

    public String getMa_Sach() {
        return Ma_Sach;
    }

    public void setMa_Sach(String Ma_Sach) {
        this.Ma_Sach = Ma_Sach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public int getNamSanXuat() {
        return NamSanXuat;
    }

    public void setNamSanXuat(int NamSanXuat) {
        this.NamSanXuat = NamSanXuat;
    }

    public int getSoluongSanPham() {
        return SoluongSanPham;
    }

    public void setSoluongSanPham(int SoluongSanPham) {
        this.SoluongSanPham = SoluongSanPham;
    }

    public int getGiaSanPham() {
        return GiaSanPham;
    }

    public void setGiaSanPham(int GiaSanPham) {
        this.GiaSanPham = GiaSanPham;
    }

    public String getPhanDoan() {
        return PhanDoan;
    }

    public void setPhanDoan(String PhanDoan) {
        this.PhanDoan = PhanDoan;
    }

    public int getSoTrang() {
        return SoTrang;
    }

    public void setSoTrang(int SoTrang) {
        this.SoTrang = SoTrang;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
