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
public class HoaDon {
    private int Id_HD;
    private int Id_TK;
    private int Id_KH;
    private String Ma_HD;
    private String TenNguoiMua;
    private String SDTNguoiMua;
    private Date NgayTao;
    private Date NgayThanhToan;
    private int TongTienGoc;
    private int TongTienSauGiamGia;
    private int TrangThai;

    public HoaDon() {
    }

    public HoaDon(int Id_HD, int Id_TK, int Id_KH, String Ma_HD, String TenNguoiMua, String SDTNguoiMua, Date NgayTao, Date NgayThanhToan, int TongTienGoc, int TongTienSauGiamGia, int TrangThai) {
        this.Id_HD = Id_HD;
        this.Id_TK = Id_TK;
        this.Id_KH = Id_KH;
        this.Ma_HD = Ma_HD;
        this.TenNguoiMua = TenNguoiMua;
        this.SDTNguoiMua = SDTNguoiMua;
        this.NgayTao = NgayTao;
        this.NgayThanhToan = NgayThanhToan;
        this.TongTienGoc = TongTienGoc;
        this.TongTienSauGiamGia = TongTienSauGiamGia;
        this.TrangThai = TrangThai;
    }

    public int getId_HD() {
        return Id_HD;
    }

    public void setId_HD(int Id_HD) {
        this.Id_HD = Id_HD;
    }

    public int getId_TK() {
        return Id_TK;
    }

    public void setId_TK(int Id_TK) {
        this.Id_TK = Id_TK;
    }

    public int getId_KH() {
        return Id_KH;
    }

    public void setId_KH(int Id_KH) {
        this.Id_KH = Id_KH;
    }

    public String getMa_HD() {
        return Ma_HD;
    }

    public void setMa_HD(String Ma_HD) {
        this.Ma_HD = Ma_HD;
    }

    public String getTenNguoiMua() {
        return TenNguoiMua;
    }

    public void setTenNguoiMua(String TenNguoiMua) {
        this.TenNguoiMua = TenNguoiMua;
    }

    public String getSDTNguoiMua() {
        return SDTNguoiMua;
    }

    public void setSDTNguoiMua(String SDTNguoiMua) {
        this.SDTNguoiMua = SDTNguoiMua;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Date getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(Date NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }

    public int getTongTienGoc() {
        return TongTienGoc;
    }

    public void setTongTienGoc(int TongTienGoc) {
        this.TongTienGoc = TongTienGoc;
    }

    public int getTongTienSauGiamGia() {
        return TongTienSauGiamGia;
    }

    public void setTongTienSauGiamGia(int TongTienSauGiamGia) {
        this.TongTienSauGiamGia = TongTienSauGiamGia;
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
