/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ISachRepo;
import DAO.ISanPhamRepo;
import DAO.SachRepo;
import DAO.SanPhamRepo;
import Models.SanPham;
import ViewModels.SachViewModel;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Hieu
 */
public class QLSanPhamService implements IQLSanPhamService{
    ISachRepo iSachRepo;
    public QLSanPhamService() {
        iSachRepo = new SachRepo();
    }

    
    @Override
    public List<SachViewModel> getData() {
        return iSachRepo.getAllData();
    }

}
