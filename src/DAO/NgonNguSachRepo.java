/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.NgonNguSach;
import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author Hieu
 */
public class NgonNguSachRepo implements INgonNguSachRepo {

    private String insert = "INSERT INTO NgonNguSach(ID_NN,ID_Sach,TrangThai) Values(?,?,1)";
    private String update = "Update NgonNguSach set ID_NN = ?,ID_Sach = ? where MaNNS = ?";
    private String delete = "Update NgonNguSach set TrangThai = 2 where MaNNS = ?";
    private String read = "select * from NgonNguSach ORDER BY ID_NNS DESC";
//    private String findTenKV = "Select * from NgonNguSach where TenKV = ?";

    @Override
    public boolean insert(Models.NgonNguSach nns) {
        try {
            JDBCHelper.executeUpdate(insert, nns.getId_NN(), nns.getId_Sach());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Models.NgonNguSach nns) {
        try {
            JDBCHelper.executeUpdate(update, nns.getId_NN(), nns.getId_Sach(), nns.getMa_NNS());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String Mnns) {
        try {
            JDBCHelper.executeUpdate(delete, Mnns);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Models.NgonNguSach> selectBySQL(String sql, Object... args) {
        List<NgonNguSach> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                NgonNguSach nns = new NgonNguSach();
                nns.setId_NNS(rs.getInt("ID_NNS"));
                nns.setId_NN(rs.getInt("ID_NN"));
                nns.setId_Sach(rs.getInt("ID_Sach"));
                nns.setMa_NNS(rs.getString("MaNNS"));
                nns.setTrangThai(rs.getInt("TrangThai"));
                list.add(nns);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Models.NgonNguSach> getAllData() {
        return selectBySQL(read);
    }

    @Override
    public List<Models.NgonNguSach> findTenNNS(String nns) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
