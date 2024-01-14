/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.SanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class SanPhamRepo implements ISanPhamRepo{
    //Tại Tầng DAO Đây là nơi sẽ code Các câu lệnh sql vào các bảng
//    Có bao nhiêu bảng thì có bấy nhiêu class
//    Đặt tên class là tên bảng + Repo
//    public String insert(){
//        return "Thêm Thành Công";
//    }
    public String update(){
        return "Thêm Thành Công";
    }
    public String delete(){
        return "Thêm Thành Công";
    }
    @Override
    public List<SanPham> getData(){
    List<SanPham> list = new ArrayList<>();
        return list;
    }

    @Override
    public String insert() {
        return "DAO";
    }
}
