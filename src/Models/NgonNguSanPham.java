/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class NgonNguSanPham {
    private int Id_NN;
    private String Ma_NN;
    private String TenKV;
    private int TrangThai;

    public NgonNguSanPham() {
    }

    public NgonNguSanPham(int Id_NN, String Ma_NN, String TenKV, int TrangThai) {
        this.Id_NN = Id_NN;
        this.Ma_NN = Ma_NN;
        this.TenKV = TenKV;
        this.TrangThai = TrangThai;
    }

    public int getId_NN() {
        return Id_NN;
    }

    public void setId_NN(int Id_NN) {
        this.Id_NN = Id_NN;
    }

    public String getMa_NN() {
        return Ma_NN;
    }

    public void setMa_NN(String Ma_NN) {
        this.Ma_NN = Ma_NN;
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
    
}
