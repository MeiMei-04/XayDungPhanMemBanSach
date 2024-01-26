/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Hieu
 */
public class SachViewModel {
    private int sTT;
    private String maSach;
    private String tenSach;
    private int namXuatBan;
    private int soLuong;
    private int gia;
    private int soTrang;
    private String mota;
    private String ngonNgu;
    private String theLoai;
    private String nhaXuatBan;
    private String tacGia;
    private String kvLuuTru;
    private int trangThai;

    public SachViewModel() {
    }

    public SachViewModel(int sTT, String maSach, String tenSach, int namXuatBan, int soLuong, int gia, int soTrang, String mota, String ngonNgu, String theLoai, String nhaXuatBan, String tacGia, String kvLuuTru, int trangThai) {
        this.sTT = sTT;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
        this.gia = gia;
        this.soTrang = soTrang;
        this.mota = mota;
        this.ngonNgu = ngonNgu;
        this.theLoai = theLoai;
        this.nhaXuatBan = nhaXuatBan;
        this.tacGia = tacGia;
        this.kvLuuTru = kvLuuTru;
        this.trangThai = trangThai;
    }

    public int getsTT() {
        return sTT;
    }

    public void setsTT(int sTT) {
        this.sTT = sTT;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getKvLuuTru() {
        return kvLuuTru;
    }

    public void setKvLuuTru(String kvLuuTru) {
        this.kvLuuTru = kvLuuTru;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    public String TrangThaiString() {
        String TrangThaiString = null;
        if (trangThai == 2) {
            TrangThaiString = "Đã Xoá";
        } else if (trangThai == 1) {
            TrangThaiString = "Còn Hàng";
        }else if(trangThai == 3){
            TrangThaiString = "Hết Hàng";
        }
        return TrangThaiString;
    }
    
    
}
