/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TacGia;
import Models.TheLoai;
import java.util.List;
import Utilities.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hieu
 */
public class TheLoaiRepo implements ITheLoaiRepo {

    private String insert = "INSERT INTO TheLoai(TenTL,Mota,TrangThai) Values(?,?,1)";
    private String update = "Update TheLoai set TenTL = ?, Mota = ? where Ma_TL = ?";
    private String delete = "Update TheLoai set TrangThai = 2 where Ma_TL = ?";
    private String read = "select * from TheLoai ORDER BY ID_TL DESC";
    private String findTenTL = "Select * from TheLoai where TenTL = ?";

    @Override
    public boolean insert(TheLoai TL) {
        try {
            JDBCHelper.executeUpdate(insert, TL.getTenTL(), TL.getMota());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(TheLoai TL) {
        try {
            JDBCHelper.executeUpdate(update, TL.getTenTL(), TL.getMota(),TL.getMa_TL());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(String TL) {
        try {
            JDBCHelper.executeUpdate(delete, TL);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<TheLoai> selectBySQL(String sql, Object... args) {
        List<TheLoai> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                TheLoai tl = new TheLoai();
                tl.setId_TL(rs.getInt("ID_TL"));
                tl.setMa_TL(rs.getString("Ma_TL"));
                tl.setTenTL(rs.getString("TenTL"));
                tl.setMota(rs.getString("Mota"));
                tl.setTrangThai(rs.getInt("TrangThai"));
                list.add(tl);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TheLoai> getAllData() {
        return selectBySQL(read);
    }

    @Override
    public List<TheLoai> findTenTL(String TenTL) {
        return selectBySQL(findTenTL, TenTL);
    }

}
