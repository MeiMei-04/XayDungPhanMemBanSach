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
            + "    Sach.ID_Sach AS ID,\n"
            + "	Sach.Ma_SACH AS MaSach,\n"
            + "	Sach.TenSach AS TenSach,\n"
            + "	Sach.NamSanXuat AS NamXuatBan,\n"
            + "	Sach.SoLuongSanPham AS SoLuong,\n"
            + "	Sach.GiaSanPham AS Gia,\n"
            + "	Sach.PhanDoan AS PhanDoan,\n"
            + "	Sach.SoTrang AS SoTrang,\n"
            + "	Sach.MoTa AS MoTa,\n"
            + "    NgonNguSanPham.TenNN AS NgonNgu,\n"
            + "    TheLoai.Mota AS TheLoai,\n"
            + "    NhaXuatBan.TenNXB AS NhaXuatBan,\n"
            + "    TacGia.TenTG AS TacGia,\n"
            + "    KhuVucLuuTru.TenKV AS KhuVucLuuTru,\n"
            + "	Sach.TrangThai AS TrangThai\n"
            + "FROM Sach\n"
            + "    INNER JOIN NgonNguSach ON Sach.ID_Sach = NgonNguSach.ID_Sach\n"
            + "    INNER JOIN NgonNguSanPham ON NgonNguSach.ID_NN = NgonNguSanPham.ID_NN\n"
            + "    INNER JOIN TheLoaiSach ON Sach.ID_Sach = TheLoaiSach.ID_Sach\n"
            + "    INNER JOIN TheLoai ON TheLoaiSach.ID_TL = TheLoai.ID_TL\n"
            + "    INNER JOIN NhaXuatBan ON Sach.ID_NXB = NhaXuatBan.ID_NXB\n"
            + "    INNER JOIN TacGiaSach ON Sach.ID_Sach = TacGiaSach.ID_Sach\n"
            + "    INNER JOIN TacGia ON TacGiaSach.id_TG = TacGia.id_TG\n"
            + "    INNER JOIN KhuVucLuuTru ON Sach.ID_KV = KhuVucLuuTru.ID_KV";
    String col[] = {"ID", "MaSach", "TenSach", "NamXuatBan", "SoLuong", "Gia", "PhanDoan", "SoTrang", "MoTa", "NgonNgu", "TheLoai", "NhaXuatBan", "TacGia", "KhuVucLuuTru", "TrangThai"};

    @Override
    public List<SachViewModel> selectBySQL(String sql, Object... args) {
        List<SachViewModel> listSVM = new ArrayList<>();
        int stt = 1;
        try {
                 ResultSet rs = JDBCHelper.executeQuery(sql, args); 
            while (rs.next()) {
                SachViewModel svm = new SachViewModel();
                svm.setsTT(stt++);
                svm.setId_Sach(rs.getInt(1));
                svm.setMaSach(rs.getString(2));
                svm.setTenSach(rs.getString(3));
                svm.setNamXuatBan(rs.getInt(4));
                svm.setSoLuong(rs.getInt(5));
                svm.setGia(rs.getInt(6));
                svm.setPhandoan(rs.getString(7));
                svm.setSoTrang(rs.getInt(8));
                svm.setMota(rs.getString(9));
                svm.setNgonNgu(rs.getString(10));
                svm.setTheLoai(rs.getString(11));
                svm.setNhaXuatBan(rs.getString(12));
                svm.setTacGia(rs.getString(13));
                svm.setKvLuuTru(rs.getString(14));
                svm.setTrangThai(rs.getInt(15));
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
