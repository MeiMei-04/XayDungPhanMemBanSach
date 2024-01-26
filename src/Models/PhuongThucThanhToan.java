/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class PhuongThucThanhToan {
    private int Id_PTTT;
    private String Ma_KieuGD;
    private String TenPT;
    private int TrangThai;

    public PhuongThucThanhToan() {
    }

    public PhuongThucThanhToan(int Id_PTTT, String Ma_KieuGD, String TenPT, int TrangThai) {
        this.Id_PTTT = Id_PTTT;
        this.Ma_KieuGD = Ma_KieuGD;
        this.TenPT = TenPT;
        this.TrangThai = TrangThai;
    }

    public int getId_PTTT() {
        return Id_PTTT;
    }

    public void setId_PTTT(int Id_PTTT) {
        this.Id_PTTT = Id_PTTT;
    }

    public String getMa_KieuGD() {
        return Ma_KieuGD;
    }

    public void setMa_KieuGD(String Ma_KieuGD) {
        this.Ma_KieuGD = Ma_KieuGD;
    }

    public String getTenPT() {
        return TenPT;
    }

    public void setTenPT(String TenPT) {
        this.TenPT = TenPT;
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
