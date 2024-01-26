/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.PhuongThucThanhToan;
import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author truon
 */
public class PhuongThucRepo implements IPhuongThucRepo {

    private String insert = "INSERT INTO PhuongThucThanhToan (TenPT, TrangThai) VALUES (?, 1)";
    private String update = "Update PhuongThucThanhToan set TenPT = ? where MaKieuGD = ?";
    private String delete = "Update PhuongThucThanhToan set TrangThai = 2 where MaKieuGD = ?";
    private String read = "Select * from PhuongThucThanhToan ORDER BY ID_PTTT DESC";
    private String findpt = "Select * from PhuongThucThanhToan where TenPT = ?";

    @Override
    public boolean insert(PhuongThucThanhToan PT) {
        try {
            JDBCHelper.executeUpdate(insert, PT.getTenPT());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(PhuongThucThanhToan PT) {
        try {
            JDBCHelper.executeUpdate(update, PT.getTenPT(), PT.getMa_KieuGD());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String PT) {
        try {
            JDBCHelper.executeUpdate(delete, PT);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<PhuongThucThanhToan> selectBySQL(String sql, Object... args) {
        List<PhuongThucThanhToan> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                PhuongThucThanhToan pt = new PhuongThucThanhToan();
                pt.setId_PTTT(rs.getInt("ID_PTTT"));
                pt.setMa_KieuGD(rs.getString("MaKieuGD"));
                pt.setTenPT(rs.getString("TenPT"));
                pt.setTrangThai(rs.getInt("TrangThai"));
                list.add(pt);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PhuongThucThanhToan> getAllData() {
        return selectBySQL(read);
    }

    @Override
    public List<PhuongThucThanhToan> findTenPT(String PT) {
        return selectBySQL(findpt, PT);}

}
