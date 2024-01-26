/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.KhachHang;
import java.util.List;

/**
 *
 * @author truon
 */
public interface IKhachHangRepo {
     public boolean insert(KhachHang KH);
    public boolean update(KhachHang KH);
    public boolean delete(String KH);
    public List<KhachHang> selectBySQL(String sql, Object... args);
    public List<KhachHang> getAllData();
    public List<KhachHang> findTenKH(String KH);
}
