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
    public List<SachViewModel> selectBySQL(String sql, String[] cols, Object... args) {
        int stt = 1;
        List<SachViewModel> listSVM = new ArrayList<>();
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        }
        for (Object[] obj : list) {
            SachViewModel svm = new SachViewModel();
            svm.setsTT(stt);
            svm.setId_Sach(Integer.parseInt(obj[0].toString()));
            svm.setMaSach(obj[1].toString());
            svm.setTenSach(obj[2].toString());
            svm.setNamXuatBan(Integer.parseInt(obj[3].toString()));
            svm.setSoLuong(Integer.parseInt(obj[4].toString()));
            svm.setGia(Integer.parseInt(obj[5].toString()));
            svm.setPhandoan(obj[6].toString());
            svm.setSoTrang(Integer.parseInt(obj[7].toString()));
            svm.setMota(obj[8].toString());
            svm.setNgonNgu(obj[9].toString());
            svm.setTheLoai(obj[10].toString());
            svm.setNamXuatBan(Integer.parseInt(obj[11].toString()));
            svm.setTacGia(obj[12].toString());
            svm.setKvLuuTru(obj[13].toString());
            svm.setTrangThai(Integer.parseInt(obj[14].toString()));
            listSVM.add(svm);
            stt++;
        }
        return listSVM;
    }

    @Override
    public List<SachViewModel> getAllData() {
        return selectBySQL(read,col);
    }

}
