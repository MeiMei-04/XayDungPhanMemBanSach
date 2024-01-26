/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utilities.JDBCHelper;
import ViewModels.SachViewModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Hieu
 */
public class SachRepo implements ISachRepo {

    String read = "SELECT \n"
            + "    Sach.Ma_SACH AS MaSach,\n"
            + "    Sach.TenSach AS TenSach,\n"
            + "    Sach.NamSanXuat AS NamXuatBan,\n"
            + "    Sach.SoLuongSanPham AS SoLuong,\n"
            + "    Sach.GiaSanPham AS Gia,\n"
            + "    Sach.SoTrang AS SoTrang,\n"
            + "    Sach.MoTa AS MoTa,\n"
            + "	NgonNguSanPham.TenNN,\n"
            + "	TheLoai.TenTL AS Theloai,\n"
            + "    NhaXuatBan.TenNXB AS NhaXuatBan,\n"
            + "    TacGia.TenTG,\n"
            + "    KhuVucLuuTru.TenKV AS KhuVucLuuTru,\n"
            + "    Sach.TrangThai AS TrangThai\n"
            + "FROM Sach\n"
            + "    INNER JOIN NgonNguSach ON Sach.ID_Sach = NgonNguSach.ID_Sach\n"
            + "    INNER JOIN NgonNguSanPham ON NgonNguSach.ID_NN = NgonNguSanPham.ID_NN\n"
            + "    INNER JOIN TheLoai ON Sach.ID_TL = TheLoai.ID_TL\n"
            + "    INNER JOIN NhaXuatBan ON Sach.ID_NXB = NhaXuatBan.ID_NXB\n"
            + "    INNER JOIN TacGia ON Sach.id_TG = TacGia.id_TG\n"
            + "    INNER JOIN KhuVucLuuTru ON Sach.ID_KV = KhuVucLuuTru.ID_KV";

    @Override
    public List<SachViewModel> selectBySQL(String sql, Object... args) {
        List<SachViewModel> listSVM = new ArrayList<>();
        int stt = 1;
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                SachViewModel svm = new SachViewModel();
                svm.setsTT(stt++);
                svm.setMaSach(rs.getString(1));
                svm.setTenSach(rs.getString(2));
                svm.setNamXuatBan(rs.getInt(3));
                svm.setSoLuong(rs.getInt(4));
                svm.setGia(rs.getInt(5));
                svm.setSoTrang(rs.getInt(6));
                svm.setMota(rs.getString(7));
                svm.setNgonNgu(rs.getString(8));
                svm.setTheLoai(rs.getString(9));
                svm.setNhaXuatBan(rs.getString(10));
                svm.setTacGia(rs.getString(11));
                svm.setKvLuuTru(rs.getString(12));
                svm.setTrangThai(rs.getInt(13));
                listSVM.add(svm);
            }
            rs.getStatement().getConnection().close();
            return listSVM;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<SachViewModel> getAllData() {
        return selectBySQL(read);
    }

}
