/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.KhuVucLuuTru;
import Models.NgonNguSanPham;
import Utilities.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class NgonNguSanPhamRepo implements INgonNguSanPhamRepo {

    private String insert = "INSERT INTO NgonNguSanPham(TenNN,TrangThai) Values(?,1)";
    private String update = "Update NgonNguSanPham set TenNN = ? where Ma_NN = ?";
    private String delete = "Update NgonNguSanPham set TrangThai = 2 where Ma_NN = ?";
    private String read = "select * from NgonNguSanPham ORDER BY ID_NN DESC";
    private String findTenKV = "Select * from NgonNguSanPham where TenNN = ?";

    @Override
    public boolean insert(NgonNguSanPham NN) {
        try {
            JDBCHelper.executeUpdate(insert, NN.getTenNN());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(NgonNguSanPham NN) {
        try {
            JDBCHelper.executeUpdate(update, NN.getTenNN(),NN.getMa_NN());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(String NN) {
        try {
            JDBCHelper.executeUpdate(delete, NN);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<NgonNguSanPham> selectBySQL(String sql, Object... args) {
        List<NgonNguSanPham> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                NgonNguSanPham nn = new NgonNguSanPham();
                nn.setId_NN(rs.getInt("ID_NN"));
                nn.setMa_NN(rs.getString("Ma_NN"));
                nn.setTenNN(rs.getString("TenNN"));
                nn.setTrangThai(rs.getInt("TrangThai"));
                list.add(nn);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public List<NgonNguSanPham> getAllData() {
        return selectBySQL(read);
    }

    @Override
    public List<NgonNguSanPham> findTenKV(String NN) {
        return selectBySQL(findTenKV, NN);
    }

}
