/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class NgonNguSach {
    private int Id_NNS;
    private int Id_NN;
    private int Id_Sach;
    private String Ma_NNS;
    private int TrangThai;

    public NgonNguSach() {
    }

    public NgonNguSach(int Id_NNS, int Id_NN, int Id_Sach, String Ma_NNS, int TrangThai) {
        this.Id_NNS = Id_NNS;
        this.Id_NN = Id_NN;
        this.Id_Sach = Id_Sach;
        this.Ma_NNS = Ma_NNS;
        this.TrangThai = TrangThai;
    }

    public int getId_NNS() {
        return Id_NNS;
    }

    public void setId_NNS(int Id_NNS) {
        this.Id_NNS = Id_NNS;
    }

    public int getId_NN() {
        return Id_NN;
    }

    public void setId_NN(int Id_NN) {
        this.Id_NN = Id_NN;
    }

    public int getId_Sach() {
        return Id_Sach;
    }

    public void setId_Sach(int Id_Sach) {
        this.Id_Sach = Id_Sach;
    }

    public String getMa_NNS() {
        return Ma_NNS;
    }

    public void setMa_NNS(String Ma_NNS) {
        this.Ma_NNS = Ma_NNS;
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
