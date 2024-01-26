/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class ChiTietHoaDon {
    private int Id_CTHD;
    private String Ma_CTHD;
    private int Id_HD;
    private int Id_Sach;
    private int Soluong;
    private int Gia;
    private int TrangThai;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int Id_CTHD, String Ma_CTHD, int Id_HD, int Id_Sach, int Soluong, int Gia, int TrangThai) {
        this.Id_CTHD = Id_CTHD;
        this.Ma_CTHD = Ma_CTHD;
        this.Id_HD = Id_HD;
        this.Id_Sach = Id_Sach;
        this.Soluong = Soluong;
        this.Gia = Gia;
        this.TrangThai = TrangThai;
    }

    public int getId_CTHD() {
        return Id_CTHD;
    }

    public void setId_CTHD(int Id_CTHD) {
        this.Id_CTHD = Id_CTHD;
    }

    public String getMa_CTHD() {
        return Ma_CTHD;
    }

    public void setMa_CTHD(String Ma_CTHD) {
        this.Ma_CTHD = Ma_CTHD;
    }

    public int getId_HD() {
        return Id_HD;
    }

    public void setId_HD(int Id_HD) {
        this.Id_HD = Id_HD;
    }

    public int getId_Sach() {
        return Id_Sach;
    }

    public void setId_Sach(int Id_Sach) {
        this.Id_Sach = Id_Sach;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
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
