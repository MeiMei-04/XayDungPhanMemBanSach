/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class ChucVu {
    private int Id_CV;
    private String Ma_CV;
    private String TenCV;
    private int TrangThai;

    public ChucVu() {
    }

    public ChucVu(int Id_CV, String Ma_CV, String TenCV, int TrangThai) {
        this.Id_CV = Id_CV;
        this.Ma_CV = Ma_CV;
        this.TenCV = TenCV;
        this.TrangThai = TrangThai;
    }

    public int getId_CV() {
        return Id_CV;
    }

    public void setId_CV(int Id_CV) {
        this.Id_CV = Id_CV;
    }

    public String getMa_CV() {
        return Ma_CV;
    }

    public void setMa_CV(String Ma_CV) {
        this.Ma_CV = Ma_CV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String TenCV) {
        this.TenCV = TenCV;
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
