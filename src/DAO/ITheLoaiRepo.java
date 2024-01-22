/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.TheLoai;
import java.util.List;

/**
 *
 * @author Hieu
 */
public interface ITheLoaiRepo {
    public boolean insert(TheLoai TL);
    public boolean update(TheLoai TL);
    public boolean delete(String TL);
    public List<TheLoai> selectBySQL(String sql, Object... args);
    public List<TheLoai> getAllData();
    public List<TheLoai> findTenTL(String TenTL);
}
