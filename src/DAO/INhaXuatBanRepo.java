/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.NhaXuatBan;
import Models.TacGia;
import java.util.List;

/**
 *
 * @author Hieu
 */
public interface INhaXuatBanRepo {
    public boolean insert(NhaXuatBan NXB);
    public boolean update(NhaXuatBan NXB);
    public boolean delete(String MaNXB);
    public List<NhaXuatBan> findTenNXB(String TenNXB);
    public List<NhaXuatBan> selectBySQL(String sql, Object... args);
    public List<NhaXuatBan> getAllData();
}
