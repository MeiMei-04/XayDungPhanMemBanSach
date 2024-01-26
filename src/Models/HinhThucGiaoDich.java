/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class HinhThucGiaoDich {
    private int Id_HTGD;
    private int Id_HD;
    private int Id_PTTT;
    private String Ma_GD;
    private int TienThanhToan;
    private int TrangThai;

    public HinhThucGiaoDich() {
    }

    public HinhThucGiaoDich(int Id_HTGD, int Id_HD, int Id_PTTT, String Ma_GD, int TienThanhToan, int TrangThai) {
        this.Id_HTGD = Id_HTGD;
        this.Id_HD = Id_HD;
        this.Id_PTTT = Id_PTTT;
        this.Ma_GD = Ma_GD;
        this.TienThanhToan = TienThanhToan;
        this.TrangThai = TrangThai;
    }

    public int getId_HTGD() {
        return Id_HTGD;
    }

    public void setId_HTGD(int Id_HTGD) {
        this.Id_HTGD = Id_HTGD;
    }

    public int getId_HD() {
        return Id_HD;
    }

    public void setId_HD(int Id_HD) {
        this.Id_HD = Id_HD;
    }

    public int getId_PTTT() {
        return Id_PTTT;
    }

    public void setId_PTTT(int Id_PTTT) {
        this.Id_PTTT = Id_PTTT;
    }

    public String getMa_GD() {
        return Ma_GD;
    }

    public void setMa_GD(String Ma_GD) {
        this.Ma_GD = Ma_GD;
    }

    public int getTienThanhToan() {
        return TienThanhToan;
    }

    public void setTienThanhToan(int TienThanhToan) {
        this.TienThanhToan = TienThanhToan;
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
