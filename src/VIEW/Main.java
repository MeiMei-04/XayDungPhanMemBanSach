/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VIEW;

import BUS.IQLSanPhamService;
import BUS.QLSanPhamService;
import Models.SanPham;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class Main {
    static IQLSanPhamService iQLSanPhamService;
    static List<SanPham> lstSanPham;
    public Main() {
        lstSanPham = iQLSanPhamService.getData();
    }
    
    public static void main(String[] args) {
        iQLSanPhamService = new QLSanPhamService();
        System.out.println(iQLSanPhamService.addSanPham());
    }
}
