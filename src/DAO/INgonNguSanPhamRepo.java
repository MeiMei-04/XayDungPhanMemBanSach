/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.NgonNguSanPham;
import java.util.List;

/**
 *
 * @author Hieu
 */
public interface INgonNguSanPhamRepo {
    public boolean insert(NgonNguSanPham NN);
    public boolean update(NgonNguSanPham NN);
    public boolean delete(String NN);
    public List<NgonNguSanPham> selectBySQL(String sql, Object... args);
    public List<NgonNguSanPham> getAllData();
    public List<NgonNguSanPham> findTenKV(String NN);
}
