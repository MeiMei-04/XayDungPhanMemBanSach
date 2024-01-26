/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.PhuongThucThanhToan;
import java.util.List;

/**
 *
 * @author truon
 */
public interface IPhuongThucRepo {
     public boolean insert(PhuongThucThanhToan PT);
    public boolean update(PhuongThucThanhToan PT);
    public boolean delete(String PT);
    public List<PhuongThucThanhToan> selectBySQL(String sql, Object... args);
    public List<PhuongThucThanhToan> getAllData();
    public List<PhuongThucThanhToan> findTenPT(String PT);
}
