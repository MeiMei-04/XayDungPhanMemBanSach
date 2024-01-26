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
public class TaiKhoan {
    private int Id_TK;
    private String Ma_TK;
    private int Id_CV;
    private String TaiKhoan;
    private String MatKhau;
    private String Email;
    private Date NgayTao;
    private String SDT;
    private Date NgaySinh;
    private String DiaChi;
    private int TrangThai;

    public TaiKhoan() {
    }

    public TaiKhoan(int Id_TK, String Ma_TK, int Id_CV, String TaiKhoan, String MatKhau, String Email, Date NgayTao, String SDT, Date NgaySinh, String DiaChi, int TrangThai) {
        this.Id_TK = Id_TK;
        this.Ma_TK = Ma_TK;
        this.Id_CV = Id_CV;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.Email = Email;
        this.NgayTao = NgayTao;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.TrangThai = TrangThai;
    }

    public int getId_TK() {
        return Id_TK;
    }

    public void setId_TK(int Id_TK) {
        this.Id_TK = Id_TK;
    }

    public String getMa_TK() {
        return Ma_TK;
    }

    public void setMa_TK(String Ma_TK) {
        this.Ma_TK = Ma_TK;
    }

    public int getId_CV() {
        return Id_CV;
    }

    public void setId_CV(int Id_CV) {
        this.Id_CV = Id_CV;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
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
