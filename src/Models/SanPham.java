/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Hieu
 */
public class SanPham {
    //Trong Package Models Chỉ Tạo Ra các class  tương ứng với các bảng trong csdl
    //(Có Bao Nhiêu Bảng thì bấy nhiêu class và bấy nhiêu thuộc tính bên trong)
    private int id;
    private String tensp;

    public SanPham() {
    }

    public SanPham(int id, String tensp) {
        this.id = id;
        this.tensp = tensp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }
}
