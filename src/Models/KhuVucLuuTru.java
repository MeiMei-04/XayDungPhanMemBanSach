/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class KhuVucLuuTru {
    private int Id_KV;
    private String Ma_KV;
    private String TenKV;
    private int TrangThai;

    public KhuVucLuuTru() {
    }

    public KhuVucLuuTru(int Id_KV, String Ma_KV, String TenKV, int TrangThai) {
        this.Id_KV = Id_KV;
        this.Ma_KV = Ma_KV;
        this.TenKV = TenKV;
        this.TrangThai = TrangThai;
    }

    public int getId_KV() {
        return Id_KV;
    }

    public void setId_KV(int Id_KV) {
        this.Id_KV = Id_KV;
    }

    public String getMa_KV() {
        return Ma_KV;
    }

    public void setMa_KV(String Ma_KV) {
        this.Ma_KV = Ma_KV;
    }

    public String getTenKV() {
        return TenKV;
    }

    public void setTenKV(String TenKV) {
        this.TenKV = TenKV;
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
