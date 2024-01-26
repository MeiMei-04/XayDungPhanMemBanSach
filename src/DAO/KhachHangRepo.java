/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.KhachHang;
import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author truon
 */
public class KhachHangRepo implements IKhachHangRepo {

    private String insert = "INSERT INTO KhachHang (TenKH, SDT, DiaChi, GioiTinh, NgayTao, TrangThai) VALUES (?, ?, ?, ?, ?, 1)";
    private String update = "Update KhachHang set TenKH = ?, SDT = ?, DiaChi = ?, GioiTinh = ? where Ma_KH = ?";
    private String delete = "Update KhachHang set TrangThai = 2 where Ma_KH = ?";
    private String read = "Select * from KhachHang ORDER BY ID_KH DESC";
    private String findKH = "Select * from KhachHang where TenKH = ?";

    @Override
    public boolean insert(KhachHang KH) {
        try {
            JDBCHelper.executeUpdate(insert, KH.getTenKH(), KH.getSDT(), KH.getDiaChi(), KH.getGioiTinh(), KH.getNgayTao());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(KhachHang KH) {
        try {
            JDBCHelper.executeUpdate(update, KH.getTenKH(),KH.getSDT(),KH.getDiaChi(),KH.getGioiTinh(),KH.getNgayTao(),KH.getTrangThai());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }}

    @Override
    public boolean delete(String KH) {
     try {
            JDBCHelper.executeUpdate(delete, KH);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }}

    @Override
    public List<KhachHang> selectBySQL(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                KhachHang nxb = new KhachHang();
                nxb.setId_KH(rs.getInt("ID_KH"));
                nxb.setMa_KH(rs.getString("Ma_KH"));
                nxb.setTenKH(rs.getString("TenKH"));
                nxb.setSDT(rs.getString("SDT"));
                nxb.setDiaChi(rs.getString("DiaChi"));
                nxb.setGioiTinh(rs.getInt("GioiTinh"));
                nxb.setNgayTao(rs.getDate("NgayTao"));
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
    public List<KhachHang> getAllData() {
      return selectBySQL(read); }

    @Override
    public List<KhachHang> findTenKH(String KH) {
       return selectBySQL(findKH, KH);}

}
