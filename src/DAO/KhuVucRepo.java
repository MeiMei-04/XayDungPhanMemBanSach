/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.KhuVucLuuTru;
import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Hieu
 */
public class KhuVucRepo implements IKhuVucRepo {

    private String insert = "INSERT INTO KhuVucLuuTru(TenKV,TrangThai) Values(?,1)";
    private String update = "Update KhuVucLuuTru set TenKV = ? where Ma_KV = ?";
    private String delete = "Update KhuVucLuuTru set TrangThai = 2 where Ma_KV = ?";
    private String read = "select * from KhuVucLuuTru ORDER BY ID_KV DESC";
    private String findTenKV = "Select * from KhuVucLuuTru where TenKV = ?";

    @Override
    public boolean insert(KhuVucLuuTru KV) {
        try {
            JDBCHelper.executeUpdate(insert, KV.getTenKV());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(KhuVucLuuTru KV) {
        try {
            JDBCHelper.executeUpdate(update, KV.getTenKV(),KV.getMa_KV());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(String KV) {
        try {
            JDBCHelper.executeUpdate(delete, KV);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<KhuVucLuuTru> selectBySQL(String sql, Object... args) {
        List<KhuVucLuuTru> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                KhuVucLuuTru kv = new KhuVucLuuTru();
                kv.setId_KV(rs.getInt("ID_KV"));
                kv.setMa_KV(rs.getString("Ma_KV"));
                kv.setTenKV(rs.getString("TenKV"));
                kv.setTrangThai(rs.getInt("TrangThai"));
                list.add(kv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<KhuVucLuuTru> getAllData() {
        return selectBySQL(read);
    }

    @Override
    public List<KhuVucLuuTru> findTenKV(String TenKv) {
        return selectBySQL(findTenKV, TenKv);
    }

}
