/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ISanPhamRepo;
import DAO.SanPhamRepo;
import Models.SanPham;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Hieu
 */
public class QLSanPhamService implements IQLSanPhamService{
//  Là Nơi Gọi Đến Các Service Ở Tầng DAO 
//  Không Được Phép Gọi Trực Tiếp Các File Ở Class Các Tầng
//  Phải Gọi Thông quá interface
    ISanPhamRepo iSanPhamRepo;
    List<SanPham> lstSanPham;
    public QLSanPhamService() {
        iSanPhamRepo = new SanPhamRepo();
        lstSanPham = iSanPhamRepo.getData();
    }
    @Override
    public String addSanPham(){
        iSanPhamRepo.insert();
        System.out.println(iSanPhamRepo.insert());
        return "Thêm Thành Công";
    }

    @Override
    public List<SanPham> getData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
