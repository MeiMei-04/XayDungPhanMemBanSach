/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.TacGia;
import java.util.List;

/**
 *
 * @author Hieu
 */
public interface ITacGiaRepo {
    public boolean insert(TacGia TG);
    public boolean update(TacGia TG);
    public boolean delete(String TG);
    public List<TacGia> selectBySQL(String sql, Object... args);
    public List<TacGia> getAllData();
    public List<TacGia> findTenTG(String TenTG);
}
