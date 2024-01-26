/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class AnhSach {
    private int Id_Anh;
    private String Ma_Anh;
    private String Id_Sach;
    private String TenAnh;
    private int TrangThai;

    public AnhSach() {
    }

    public AnhSach(int Id_Anh, String Ma_Anh, String Id_Sach, String TenAnh, int TrangThai) {
        this.Id_Anh = Id_Anh;
        this.Ma_Anh = Ma_Anh;
        this.Id_Sach = Id_Sach;
        this.TenAnh = TenAnh;
        this.TrangThai = TrangThai;
    }

    public int getId_Anh() {
        return Id_Anh;
    }

    public void setId_Anh(int Id_Anh) {
        this.Id_Anh = Id_Anh;
    }

    public String getMa_Anh() {
        return Ma_Anh;
    }

    public void setMa_Anh(String Ma_Anh) {
        this.Ma_Anh = Ma_Anh;
    }

    public String getId_Sach() {
        return Id_Sach;
    }

    public void setId_Sach(String Id_Sach) {
        this.Id_Sach = Id_Sach;
    }

    public String getTenAnh() {
        return TenAnh;
    }

    public void setTenAnh(String TenAnh) {
        this.TenAnh = TenAnh;
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
