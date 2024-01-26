/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.ChucVu;
import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author truon
 */
public class ChucVuRepo implements IChucVuRepo {

    private String insert = "INSERT INTO ChucVu (TenCV, TrangThai) VALUES (?, 1)";
    private String update = "Update ChucVu set TenCV = ? where MA_CV = ?";
    private String delete = "Update ChucVu set TrangThai = 2 where MA_CV = ?";
    private String read = "Select * from ChucVu ORDER BY ID_CV DESC";
    private String findcv = "Select * from ChucVu where TenCV = ?";

    @Override
    public boolean insert(ChucVu CV) {
        try {
            JDBCHelper.executeUpdate(insert, CV.getTenCV());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(ChucVu CV) {
        try {
            JDBCHelper.executeUpdate(update, CV.getTenCV(), CV.getMa_CV());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String CV) {
        try {
            JDBCHelper.executeUpdate(delete, CV);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ChucVu> selectBySQL(String sql, Object... args) {
        List<ChucVu> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                ChucVu CV = new ChucVu();
                CV.setId_CV(rs.getInt("ID_CV"));
                CV.setMa_CV(rs.getString("MA_CV"));
                CV.setTenCV(rs.getString("TenCV"));
                CV.setTrangThai(rs.getInt("TrangThai"));
                list.add(CV);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ChucVu> getAllData() {
        return selectBySQL(read);
    }

    @Override
    public List<ChucVu> findTenCV(String CV) {
        return selectBySQL(findcv, CV);
    }

}
