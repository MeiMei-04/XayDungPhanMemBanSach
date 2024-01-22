/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.IKhuVucRepo;
import DAO.INgonNguSanPhamRepo;
import DAO.INhaXuatBanRepo;
import DAO.ITacGiaRepo;
import DAO.NhaXuatBanRepo;
import DAO.TacGiaRepo;
import DAO.ITheLoaiRepo;
import DAO.KhuVucRepo;
import DAO.NgonNguSanPhamRepo;
import DAO.TheLoaiRepo;
import Models.KhuVucLuuTru;
import Models.NgonNguSanPham;
import Models.NhaXuatBan;
import Models.TacGia;
import Models.TheLoai;
import ViewModels.NXBViewModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieu
 */
public class QLThongTinKhac implements IQLThongTinKhacServie {

    DefaultTableModel model;
    INhaXuatBanRepo iNhaXuatBanRepo;
    ITacGiaRepo iTacGiaRepo;
    ITheLoaiRepo iTheLoaiRepo;
    IKhuVucRepo iKhuVucRepo;
    INgonNguSanPhamRepo iNgonNguSanPhamRepo;
    List<NXBViewModel> lstNhaXuatBanView;
    NhaXuatBan nxb;
    TacGia tg;

    public QLThongTinKhac() {
        iNhaXuatBanRepo = new NhaXuatBanRepo();
        iTacGiaRepo = new TacGiaRepo();
        iTheLoaiRepo = new TheLoaiRepo();
        iKhuVucRepo = new KhuVucRepo();
        iNgonNguSanPhamRepo = new NgonNguSanPhamRepo();
    }

    @Override
    public boolean insert_NXB(NhaXuatBan nxb) {
            if(nxb.getTenNXB().isEmpty()){
                System.out.println("Thieu Ten");
                return false;
            }
            if(iNhaXuatBanRepo.insert(nxb)){
                return true;
            }else{
                return false;
            }
            

        
    }

    @Override
    public boolean update_NXB(NhaXuatBan nxb) {
        return iNhaXuatBanRepo.update(nxb);
    }

    @Override
    public boolean delete_NXB(String MaNXB) {
        return iNhaXuatBanRepo.delete(MaNXB);
    }

//    @Override
//    public List<NXBViewModel> getDataNXBV() {
//        if (iNhaXuatBanRepo.getAllData().isEmpty()) {
//            return new ArrayList<>();
//        }
//        lstNhaXuatBanView = new ArrayList<>();
//        int stt = 1;
//        for (NhaXuatBan x : iNhaXuatBanRepo.getAllData()) {
//            NXBViewModel y = new NXBViewModel();
//            y.setStt(stt);
//            y.setId_NXB(x.getId_NXB());
//            y.setMa_NXB(x.getMa_NXB());
//            y.setTenNXB(x.getTenNXB());
//            y.setDiaChiNXB(x.getDiaChiNXB());
//            y.setTrangThai(x.getTrangThai());
//            y.setTenTrangThai(x.getTrangThai()==1?"Hoạt Động":"Không Hoạt Động");
//            lstNhaXuatBanView.add(y);
//            stt++;
//        }
//        return lstNhaXuatBanView;
//    }

    @Override
    public List<NhaXuatBan> getDataNXB() {
        return iNhaXuatBanRepo.getAllData();
    }

    @Override
    public List<NhaXuatBan> findTenNXB(String TenNXB) {
        return iNhaXuatBanRepo.findTenNXB(TenNXB);
    }

    @Override
    public boolean insert_TG(TacGia tg) {
        return iTacGiaRepo.insert(tg);
    }

    @Override
    public boolean update_TG(TacGia tg) {
        return iTacGiaRepo.update(tg);
    }

    @Override
    public boolean delete_TG(String MaTG) {
        return iTacGiaRepo.delete(MaTG);
    }

    @Override
    public List<TacGia> findTenTG(String TenTG) {
        return iTacGiaRepo.findTenTG(TenTG);
    }

    @Override
    public List<TacGia> getDataTG() {
        return iTacGiaRepo.getAllData();
    }

    @Override
    public boolean insert_TL(TheLoai Tl) {
        return iTheLoaiRepo.insert(Tl);
    }

    @Override
    public boolean update_TL(TheLoai Tl) {
        return iTheLoaiRepo.insert(Tl);
    }

    @Override
    public boolean delete_TL(String MaTl) {
        return iTheLoaiRepo.delete(MaTl);
    }

    @Override
    public List<TheLoai> findTenTL(String TenTL) {
        return iTheLoaiRepo.findTenTL(TenTL);
    }

    @Override
    public List<TheLoai> getDataTL() {
        return iTheLoaiRepo.getAllData();
    }

    @Override
    public boolean insert_KV(KhuVucLuuTru KV) {
        return iKhuVucRepo.insert(KV);
    }

    @Override
    public boolean update_KV(KhuVucLuuTru KV) {
        return iKhuVucRepo.insert(KV);
    }

    @Override
    public boolean delete_KV(String MaKV) {
        return iKhuVucRepo.delete(MaKV);
    }

    @Override
    public List<KhuVucLuuTru> findTenKV(String TenKV) {
        return iKhuVucRepo.findTenKV(TenKV);
    }

    @Override
    public List<KhuVucLuuTru> getDataKV() {
        return iKhuVucRepo.getAllData();
    }

    @Override
    public boolean insert_NN(NgonNguSanPham NN) {
        return iNgonNguSanPhamRepo.insert(NN);
    }

    @Override
    public boolean update_NN(NgonNguSanPham NN) {
        return iNgonNguSanPhamRepo.update(NN);
    }

    @Override
    public boolean delete_NN(String maNN) {
        return iNgonNguSanPhamRepo.delete(maNN);
    }

    @Override
    public List<NgonNguSanPham> findTenNN(String TenNN) {
        return iNgonNguSanPhamRepo.findTenKV(TenNN);
    }

    @Override
    public List<NgonNguSanPham> getDataNN() {
        return iNgonNguSanPhamRepo.getAllData();
    }

}
