/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.NhaXuatBan;
import Models.TacGia;
import Utilities.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class NhaXuatBanRepo implements INhaXuatBanRepo{
    private String insert = "INSERT INTO NhaXuatBan (TenNXB, DiaChiNXB, TrangThai) VALUES (?,?,1)";
    private String update = "Update NhaXuatBan set TenNXB = ?, DiaChiNXB = ? where Ma_NXB = ?";
    private String delete = "Update NhaXuatBan set TrangThai = 2 where Ma_NXB = ?";
    private String read = "Select * from NhaXuatBan ORDER BY ID_NXB DESC";
    private String findMaNXB = "Select * from NhaXuatBan where TenNXB = ?";
    @Override
    public boolean insert(NhaXuatBan NXB) {
        try {
            JDBCHelper.executeUpdate(insert, NXB.getTenNXB(),NXB.getDiaChiNXB());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }

    @Override
    public boolean update(NhaXuatBan NXB) {
        try {
            JDBCHelper.executeUpdate(update, NXB.getTenNXB(),NXB.getDiaChiNXB(),NXB.getMa_NXB());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String TG) {
        try {
            JDBCHelper.executeUpdate(delete, TG);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<NhaXuatBan> selectBySQL(String sql, Object... args) {
        List<NhaXuatBan> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setId_NXB(rs.getInt("ID_NXB"));
                nxb.setMa_NXB(rs.getString("Ma_NXB"));
                nxb.setTenNXB(rs.getString("TenNXB"));
                nxb.setDiaChiNXB(rs.getString("DiaChiNXB"));
                nxb.setTrangThai(rs.getInt("TrangThai"));
                list.add(nxb);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<NhaXuatBan> getAllData() {
        return selectBySQL(read);
    }

    @Override
    public List<NhaXuatBan> findTenNXB(String TenNXB) {
        return selectBySQL(findMaNXB, TenNXB);
    }
    
}
