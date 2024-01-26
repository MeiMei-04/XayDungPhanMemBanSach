/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.NgonNguSach;
import java.util.List;

/**
 *
 * @author Hieu
 */
public interface INgonNguSachRepo {
    public boolean insert(NgonNguSach nns);
    public boolean update(NgonNguSach nns);
    public boolean delete(String Mnns);
    public List<NgonNguSach> selectBySQL(String sql, Object... args);
    public List<NgonNguSach> getAllData();
    public List<NgonNguSach> findTenNNS(String nns);
}
