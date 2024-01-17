/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utilities.JDBCHelper;
import Models.TacGia;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class TacGiaRepo implements ITacGiaRepo {

    private String insert = "INSERT INTO TacGia(TenTG,NgaySinh,QuocTich,TrangThai) Values(?,?,?,1)";
    private String update = "Update TacGia set TenTG = ?, NgaySinh = ?, QuocTich = ? where Ma_TG = ?";
    private String delete = "Update TacGia set TrangThai = 2 where Ma_TG = ?";
    private String read = "select * from TacGia ORDER BY id_TG DESC";
    private String findTenTG = "Select * from TacGia where TenTG = ?";

    @Override
    public boolean insert(TacGia TG) {
        try {
            JDBCHelper.executeUpdate(insert,
                    TG.getTenTG(),
                    TG.getNgaySinh(),
                    TG.getQuocTich()
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(TacGia TG) {
        try {
            JDBCHelper.executeUpdate(update,
                    TG.getTenTG(),
                    TG.getNgaySinh(),
                    TG.getQuocTich(),
                    TG.getMa_TG()
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String str) {
        try {
            JDBCHelper.executeUpdate(delete,str);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<TacGia> selectBySQL(String sql, Object... args) {
        List<TacGia> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                TacGia tg = new TacGia();
                tg.setId_TG(rs.getInt("id_TG"));
                tg.setMa_TG(rs.getString("MA_TG"));
                tg.setTenTG(rs.getString("TenTG"));
                tg.setNgaySinh(rs.getDate("NgaySinh"));
                tg.setQuocTich(rs.getString("QuocTich"));
                tg.setTrangThai(rs.getInt("TrangThai"));
                list.add(tg);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TacGia> getAllData() {
        return selectBySQL(read);
    }


    @Override
    public List<TacGia> findTenTG(String TenTG) {
        return selectBySQL(findTenTG, TenTG);
    }
 
}
