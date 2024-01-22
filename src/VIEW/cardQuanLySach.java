/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package VIEW;

import BUS.IQLSanPhamService;
import BUS.QLThongTinKhac;
import DAO.INhaXuatBanRepo;
import Models.NhaXuatBan;
import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import ViewModels.NXBViewModel;
import Models.KhuVucLuuTru;
import Models.NgonNguSanPham;
import Models.TacGia;
import Models.TheLoai;
import Utilities.DiaLogMes;
import java.util.Date;
import java.util.HashSet;
import BUS.IQLThongTinKhacServie;
import BUS.QLSanPhamService;
import ViewModels.SachViewModel;

/**
 *
 * @author Hieu
 */
public class cardQuanLySach extends javax.swing.JPanel {

    DiaLogMes diaLogMes;
    DefaultTableModel model;
    IQLThongTinKhacServie iQLThongTinKhacService;
    IQLSanPhamService iQLSanPhamService;
    List<NhaXuatBan> lstNhaXuatBan;
    List<TacGia> lstTacGia;
    List<TheLoai> lstTheLoai;
    List<KhuVucLuuTru> lstKhuVucLuuTru;
    List<NgonNguSanPham> lstNgonNguSanPham;
    List<SachViewModel> lstSachViewModel;

    /**
     * Creates new form cardQuanLySach
     */
    public cardQuanLySach() {
        initComponents();
        iQLThongTinKhacService = new QLThongTinKhac();
        iQLSanPhamService = new QLSanPhamService();
        lstNhaXuatBan = iQLThongTinKhacService.getDataNXB();
        lstTacGia = iQLThongTinKhacService.getDataTG();
        lstTheLoai = iQLThongTinKhacService.getDataTL();
        lstKhuVucLuuTru = iQLThongTinKhacService.getDataKV();
        lstNgonNguSanPham = iQLThongTinKhacService.getDataNN();
        lstSachViewModel = iQLSanPhamService.getData();
        diaLogMes = new DiaLogMes();
        filltableNXB();
        filltableTG();
        filltableTL();
        filltableKV();
        filltableNN();
        fillcbbTG();
        fillcbbNXB();
        fillcbbTL();
        fillcbbKV();
        fillcbbNN();
        filltableSach();
    }
    private void rsCbb(){
        lstNgonNguSanPham = iQLThongTinKhacService.getDataNN();
        lstTacGia = iQLThongTinKhacService.getDataTG();
        lstKhuVucLuuTru = iQLThongTinKhacService.getDataKV();
        lstTheLoai = iQLThongTinKhacService.getDataTL();
        lstNhaXuatBan = iQLThongTinKhacService.getDataNXB();
        fillcbbTG();
        fillcbbNXB();
        fillcbbTL();
        fillcbbKV();
        fillcbbNN();
    }
    private void filltableSach() {
        model = (DefaultTableModel) tblSach.getModel();
        model.setRowCount(0);
        if (lstSachViewModel.isEmpty()) {
            return;
        }
        for (SachViewModel svm : lstSachViewModel) {
            if (svm.getTrangThai() != 2) {
                Object[] row = {
                    svm.getsTT(),
                    svm.getMaSach(),
                    svm.getTenSach(),
                    svm.getNamXuatBan(),
                    svm.getSoLuong(),
                    svm.getGia(),
                    svm.getPhandoan(),
                    svm.getSoTrang(),
                    svm.getMota(),
                    svm.getNgonNgu(),
                    svm.getTheLoai(),
                    svm.getNhaXuatBan(),
                    svm.getTacGia(),
                    svm.getKvLuuTru(),
                    svm.getTrangThai()
                };
                model.addRow(row);
            }
        }
    }
    private void fillcbbKV() {
        cbb_KVLuutru.removeAllItems();
        for (KhuVucLuuTru kv : lstKhuVucLuuTru) {
            cbb_KVLuutru.addItem(kv.getTenKV());
        }
    }

    private void fillcbbTL() {
        cbb_TL.removeAllItems();
        for (TheLoai tl : lstTheLoai) {
            cbb_TL.addItem(tl.getTenTL());
        }
    }

    private void fillcbbNN() {
        cbb_NN.removeAllItems();
        for (NgonNguSanPham nn : lstNgonNguSanPham) {
            cbb_NN.addItem(nn.getTenNN());
        }
    }
    private void fillcbbNXB() {
        cbb_NXB.removeAllItems();
        for (NhaXuatBan nxb : lstNhaXuatBan) {
            cbb_NXB.addItem(nxb.getTenNXB());
        }
    }

    private void fillcbbTG() {
        cbb_TacGia.removeAllItems();
        for (TacGia tg : lstTacGia) {
            cbb_TacGia.addItem(tg.getTenTG());
        }
    }

    private void refreshTableNN() {
        lstNgonNguSanPham = iQLThongTinKhacService.getDataNN();
        filltableNN();
    }

    private void findTenNN() {
        String tenNN = txt_TenNN.getText();
        if (iQLThongTinKhacService.findTenNN(tenNN).isEmpty()) {
            diaLogMes.alert(this, "Thông Tin Hiện Tại Không Khả Dụng");
        } else {
            lstNgonNguSanPham = iQLThongTinKhacService.findTenNN(tenNN);
            filltableNN();
        }
    }

    private void moiNN() {
        txt_MaNN.setText("");
        txt_TenNN.setText("");
        refreshTableNN();
    }

    private void themNN() {
        NgonNguSanPham nn = getFormNN();
        if (iQLThongTinKhacService.insert_NN(nn)) {
            diaLogMes.alert(this, "Thêm Thành Công");
        } else {
            diaLogMes.alert(this, "Thêm Thất Bại");
        }
    }

    private void suaNN() {
        NgonNguSanPham nn = getFormNN();
        if (iQLThongTinKhacService.update_NN(nn)) {
            diaLogMes.alert(this, "Sửa Thành Công");
        } else {
            diaLogMes.alert(this, "Sửa Thất Bại");
        }
    }

    private void xoaNN() {
        String maNN = txt_MaNN.getText();
        if (iQLThongTinKhacService.delete_NN(maNN)) {
            diaLogMes.alert(this, "Xoá Thành Công");
        } else {
            diaLogMes.alert(this, "Xoá Thất Bại");
        }
    }

    private void clickTblNN() {
        int row = tbl_NN.getSelectedRow();
        String mannn = (String) tbl_NN.getValueAt(row, 0);
        String tennn = (String) tbl_NN.getValueAt(row, 1);
        txt_MaNN.setText(mannn);
        txt_TenNN.setText(tennn);

    }

    private NgonNguSanPham getFormNN() {
        NgonNguSanPham nn = new NgonNguSanPham();
        try {
            nn.setMa_NN(txt_MaNN.getText());
            nn.setTenNN(txt_TenNN.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nn;
    }

    private void filltableNN() {
        model = (DefaultTableModel) tbl_NN.getModel();
        model.setRowCount(0);
        if (lstNgonNguSanPham.isEmpty()) {
            return;
        }
        for (NgonNguSanPham nn : lstNgonNguSanPham) {
            if (nn.getTrangThai() != 2) {
                Object[] row = {
                    nn.getMa_NN(),
                    nn.getTenNN(),
                    nn.getTrangThai()
                };
                model.addRow(row);
            }
        }
    }

    private void refreshTableKV() {
        lstKhuVucLuuTru = iQLThongTinKhacService.getDataKV();
        filltableKV();
    }

    private void findTenKV() {
        String tenKV = txt_TenKV.getText();
        if (iQLThongTinKhacService.findTenTL(tenKV).isEmpty()) {
            diaLogMes.alert(this, "Thông Tin Hiện Tại Không Khả Dụng");
        } else {
            lstKhuVucLuuTru = iQLThongTinKhacService.findTenKV(tenKV);
            filltableKV();
        }
    }

    private void moiKV() {
        txt_MaKV.setText("");
        txt_TenKV.setText("");
        refreshTableKV();
    }

    private void themKV() {
        KhuVucLuuTru kv = getFormKV();
        if (iQLThongTinKhacService.insert_KV(kv)) {
            diaLogMes.alert(this, "Thêm Thành Công");
        } else {
            diaLogMes.alert(this, "Thêm Thất Bại");
        }
    }

    private void suaKV() {
        KhuVucLuuTru kv = getFormKV();
        if (iQLThongTinKhacService.update_KV(kv)) {
            diaLogMes.alert(this, "Sửa Thành Công");
        } else {
            diaLogMes.alert(this, "Sửa Thất Bại");
        }
    }

    private void xoaKV() {
        String maKV = txt_MaKV.getText();
        if (iQLThongTinKhacService.delete_KV(maKV)) {
            diaLogMes.alert(this, "Xoá Thành Công");
        } else {
            diaLogMes.alert(this, "Xoá Thất Bại");
        }
    }

    private void clickTblKV() {
        int row = tblKhuVucLT.getSelectedRow();
        String mankv = (String) tblKhuVucLT.getValueAt(row, 0);
        String tenkv = (String) tblKhuVucLT.getValueAt(row, 1);
        txt_MaKV.setText(mankv);
        txt_TenKV.setText(tenkv);

    }

    private KhuVucLuuTru getFormKV() {
        KhuVucLuuTru kv = new KhuVucLuuTru();
        try {
            kv.setMa_KV(txt_MaKV.getText());
            kv.setTenKV(txt_TenKV.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kv;
    }

    private void filltableKV() {
        model = (DefaultTableModel) tblKhuVucLT.getModel();
        model.setRowCount(0);
        if (lstKhuVucLuuTru.isEmpty()) {
            return;
        }
        for (KhuVucLuuTru kv : lstKhuVucLuuTru) {
            if (kv.getTrangThai() != 2) {
                Object[] row = {
                    kv.getMa_KV(),
                    kv.getTenKV(),
                    kv.getTrangThai()
                };
                model.addRow(row);
            }
        }
    }

    private void refreshTableTl() {
        lstTheLoai = iQLThongTinKhacService.getDataTL();
        filltableTL();
    }

    private void findTenTL() {
        String tentl = txt_TenTL.getText();
        if (iQLThongTinKhacService.findTenTL(tentl).isEmpty()) {
            diaLogMes.alert(this, "Thông Tin Hiện Tại Không Khả Dụng");
        } else {
            lstTheLoai = iQLThongTinKhacService.findTenTL(tentl);
            filltableTL();
        }
    }

    private void moiTL() {
        txt_MaTl.setText("");
        txt_TenTL.setText("");
        txt_Mota.setText("");
        refreshTableTl();
    }

    private void themTL() {
        TheLoai TL = getFormTL();
        if (iQLThongTinKhacService.insert_TL(TL)) {
            diaLogMes.alert(this, "Thêm Thành Công");
        } else {
            diaLogMes.alert(this, "Thêm Thất Bại");
        }
    }

    private void suaTL() {
        TheLoai TL = getFormTL();
        if (iQLThongTinKhacService.update_TL(TL)) {
            diaLogMes.alert(this, "Sửa Thành Công");
        } else {
            diaLogMes.alert(this, "Sửa Thất Bại");
        }
    }

    private void xoaTL() {
        String maTL = txt_MaTl.getText();
        if (iQLThongTinKhacService.delete_TL(maTL)) {
            diaLogMes.alert(this, "Xoá Thành Công");
        } else {
            diaLogMes.alert(this, "Xoá Thất Bại");
        }
    }

    private void clickTblTL() {
        int row = tblTheLoai.getSelectedRow();
        String mantl = (String) tblTheLoai.getValueAt(row, 0);
        String tentl = (String) tblTheLoai.getValueAt(row, 1);
        String mota = (String) tblTheLoai.getValueAt(row, 2);
        txt_MaTl.setText(mantl);
        txt_TenTL.setText(tentl);
        txt_Mota.setText(mota);

    }

    private TheLoai getFormTL() {
        TheLoai TL = new TheLoai();
        try {
            TL.setMa_TL(txt_MaTl.getText());
            TL.setTenTL(txt_TenTL.getText());
            TL.setMota(txt_Mota.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TL;
    }

    private void filltableTL() {
        model = (DefaultTableModel) tblTheLoai.getModel();
        model.setRowCount(0);

        if (lstTheLoai.isEmpty()) {
            return;
        }
        for (TheLoai TL : lstTheLoai) {
            if (TL.getTrangThai() != 2) {
                Object[] row = {
                    TL.getMa_TL(),
                    TL.getTenTL(),
                    TL.getMota(),
                    TL.getTrangThai()
                };
                model.addRow(row);
            }
        }
    }

    private void refreshTableTNXB() {
        lstNhaXuatBan = iQLThongTinKhacService.getDataNXB();
        filltableNXB();
    }

    private void findTenNXB() {
        String tennxb = txt_TenNXB.getText();
        if (iQLThongTinKhacService.findTenNXB(tennxb).isEmpty()) {
            diaLogMes.alert(this, "Thông Tin Hiện Tại Không Khả Dụng");
        } else {
            lstNhaXuatBan = iQLThongTinKhacService.findTenNXB(tennxb);
            filltableNXB();
        }
    }

    private void moiNXB() {
        txt_MaNXB.setText("");
        txt_TenNXB.setText("");
        txt_DiaChiNXB.setText("");
        refreshTableTNXB();
    }

    private void themNXB() {
        NhaXuatBan nxb = getFormNXB();
        if (iQLThongTinKhacService.insert_NXB(nxb)) {
            diaLogMes.alert(this, "Thêm Thành Công");
        } else {
            diaLogMes.alert(this, "Thêm Thất Bại");
        }
    }

    private void suaNXB() {
        NhaXuatBan nxb = getFormNXB();
        if (iQLThongTinKhacService.update_NXB(nxb)) {
            diaLogMes.alert(this, "Sửa Thành Công");
        } else {
            diaLogMes.alert(this, "Sửa Thất Bại");
        }
    }

    private void xoaNXB() {
        String maNXB = txt_MaNXB.getText();
        if (iQLThongTinKhacService.delete_NXB(maNXB)) {
            diaLogMes.alert(this, "Xoá Thành Công");
        } else {
            diaLogMes.alert(this, "Xoá Thất Bại");
        }
    }

    private void clickTblNXB() {
        int row = tbl_NXB.getSelectedRow();
        String manxb = (String) tbl_NXB.getValueAt(row, 0);
        String tennxb = (String) tbl_NXB.getValueAt(row, 1);
        String diachi = (String) tbl_NXB.getValueAt(row, 2);
        txt_MaNXB.setText(manxb);
        txt_TenNXB.setText(tennxb);
        txt_DiaChiNXB.setText(diachi);

    }

    private NhaXuatBan getFormNXB() {
        NhaXuatBan nxb = new NhaXuatBan();
        try {
            nxb.setMa_NXB(txt_MaNXB.getText());
            nxb.setTenNXB(txt_TenNXB.getText());
            nxb.setDiaChiNXB(txt_DiaChiNXB.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nxb;
    }

    private void filltableNXB() {
        model = (DefaultTableModel) tbl_NXB.getModel();
        model.setRowCount(0);

        if (lstNhaXuatBan.isEmpty()) {
            return;
        }
        for (NhaXuatBan nxb : lstNhaXuatBan) {
            if (nxb.getTrangThai() != 2) {
                Object[] row = {
                    nxb.getMa_NXB(),
                    nxb.getTenNXB(),
                    nxb.getDiaChiNXB(),
                    nxb.getTrangThai()
                };
                model.addRow(row);
            }
        }
    }

    private void refreshTableTG() {
        lstTacGia = iQLThongTinKhacService.getDataTG();
        filltableTG();
    }

    private void findTenTG() {
        String tentg = txt_TenTG.getText();
        if (iQLThongTinKhacService.findTenTG(tentg).isEmpty()) {
            diaLogMes.alert(this, "Thông Tin Hiện Tại Không Khả Dụng");
        } else {
            lstTacGia = iQLThongTinKhacService.findTenTG(tentg);
            filltableTG();
        }
    }

    private void moiTG() {
        txt_MaTG.setText("");
        txt_TenTG.setText("");
        txt_NgaySinh.setDate(new Date());
        txt_QuocTich.setText("");
        refreshTableTG();
    }

    private void themTG() {
        TacGia tg = getFormTG();
        if (iQLThongTinKhacService.insert_TG(tg)) {
            diaLogMes.alert(this, "Thêm Thành Công");
        } else {
            diaLogMes.alert(this, "Thêm Thất Bại");
        }
    }

    private void suaTG() {
        TacGia tg = getFormTG();
        if (iQLThongTinKhacService.update_TG(tg)) {
            diaLogMes.alert(this, "Sửa Thành Công");
        } else {
            diaLogMes.alert(this, "Sửa Thất Bại");
        }
    }

    private void xoaTG() {
        String maTG = txt_MaTG.getText();
        if (iQLThongTinKhacService.delete_TG(maTG)) {
            diaLogMes.alert(this, "Xoá Thành Công");
        } else {
            diaLogMes.alert(this, "Xoá Thất Bại");
        }
    }

    private void clickTblTG() {
        int row = tbl_TacGia.getSelectedRow();
        String mantg = (String) tbl_TacGia.getValueAt(row, 0);
        String tentg = (String) tbl_TacGia.getValueAt(row, 1);
        Date ngaySinh = (Date) tbl_TacGia.getValueAt(row, 2);
        String quocTich = (String) tbl_TacGia.getValueAt(row, 3);
        txt_MaTG.setText(mantg);
        txt_TenTG.setText(tentg);
        txt_NgaySinh.setDate(ngaySinh);
        txt_QuocTich.setText(quocTich);
    }

    private TacGia getFormTG() {
        TacGia tg = new TacGia();
        try {
            tg.setTenTG(txt_TenTG.getText());
            tg.setNgaySinh(txt_NgaySinh.getDate());
            tg.setQuocTich(txt_QuocTich.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tg;
    }

    private void filltableTG() {
        model = (DefaultTableModel) tbl_TacGia.getModel();
        model.setRowCount(0);

        if (lstTacGia.isEmpty()) {
            return;
        }
        for (TacGia tg : lstTacGia) {
            if (tg.getTrangThai() != 2) {
                Object[] row = {
                    tg.getMa_TG(),
                    tg.getTenTG(),
                    tg.getNgaySinh(),
                    tg.getQuocTich(),
                    tg.getTrangThai()
                };
                model.addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        pnl_TacGIa = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_TacGia = new javax.swing.JTable();
        pnl_ThongTinTacGia = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_TenTG = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_QuocTich = new javax.swing.JTextField();
        txt_NgaySinh = new com.toedter.calendar.JDateChooser();
        txt_MaTG = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btn_ThemTG = new javax.swing.JButton();
        btn__SuaTG = new javax.swing.JButton();
        btn_XoaTG = new javax.swing.JButton();
        btn_MoiTG = new javax.swing.JButton();
        btn_TimTG = new javax.swing.JButton();
        pnl_NXB = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_NXB = new javax.swing.JTable();
        pnl_ThongTinNXB = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_TenNXB = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txt_DiaChiNXB = new javax.swing.JTextArea();
        txt_MaNXB = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btn_ThemNXb = new javax.swing.JButton();
        btn_SuaNxb = new javax.swing.JButton();
        btn_XoaNXb = new javax.swing.JButton();
        btn_MoiNxb = new javax.swing.JButton();
        btn_TimNXb = new javax.swing.JButton();
        pnl_NN = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_NN = new javax.swing.JTable();
        pnl_ThongTinNN = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_TenNN = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        btn_ThemNN = new javax.swing.JButton();
        btn_SuaNN = new javax.swing.JButton();
        btn_XoaNN = new javax.swing.JButton();
        btn_MoiNN = new javax.swing.JButton();
        btn_TimNN = new javax.swing.JButton();
        txt_MaNN = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pnl_TheLoai = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTheLoai = new javax.swing.JTable();
        pnl_ThongTinTL = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_TenTL = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        txt_Mota = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        btn_ThemTL = new javax.swing.JButton();
        btn_SuaTL = new javax.swing.JButton();
        btn_XoaTL = new javax.swing.JButton();
        btn_MoiTL = new javax.swing.JButton();
        btn_TimTL = new javax.swing.JButton();
        txt_MaTl = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        pnl_KVLuuTru = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKhuVucLT = new javax.swing.JTable();
        pnl_ThongTinKVLT = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_TenKV = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        btn_ThemKV = new javax.swing.JButton();
        btn_SuaKV = new javax.swing.JButton();
        btn_XoaKV = new javax.swing.JButton();
        btn_MoiKV = new javax.swing.JButton();
        btn_TimKV = new javax.swing.JButton();
        txt_MaKV = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        pnl_AnhSach = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblAnhSach = new javax.swing.JTable();
        pnl_ThongTinAnhSach = new javax.swing.JPanel();
        cbb_Sach = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        lbl_Anh = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        btn_ThemA = new javax.swing.JButton();
        btn_SuaA = new javax.swing.JButton();
        btn_XoaA = new javax.swing.JButton();
        btn_MoiA = new javax.swing.JButton();
        btn_TimA = new javax.swing.JButton();
        btn_ChonANh = new javax.swing.JButton();
        txt_MaAnh = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txt_TenAnh = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        cbb_TacGia = new javax.swing.JComboBox<>();
        cbb_NXB = new javax.swing.JComboBox<>();
        cbb_NN = new javax.swing.JComboBox<>();
        cbb_TL = new javax.swing.JComboBox<>();
        cbb_KVLuutru = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_TacGIa.setBorder(javax.swing.BorderFactory.createTitledBorder("Tác Giả"));
        pnl_TacGIa.setOpaque(false);

        tbl_TacGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã TG", "Tên TG", "Ngày Sinh", "Quốc Tịch", "Trạng Thái"
            }
        ));
        tbl_TacGia.setOpaque(false);
        tbl_TacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TacGiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_TacGia);

        pnl_ThongTinTacGia.setOpaque(false);
        pnl_ThongTinTacGia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tên Tác Giả");
        pnl_ThongTinTacGia.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        pnl_ThongTinTacGia.add(txt_TenTG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, -1));

        jLabel2.setText("Ngày Sinh");
        pnl_ThongTinTacGia.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel3.setText("Quốc Tịch");
        pnl_ThongTinTacGia.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        pnl_ThongTinTacGia.add(txt_QuocTich, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 180, -1));
        pnl_ThongTinTacGia.add(txt_NgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 200, -1));

        txt_MaTG.setEnabled(false);
        pnl_ThongTinTacGia.add(txt_MaTG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 180, -1));

        jLabel9.setText("Mã TG");
        pnl_ThongTinTacGia.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        btn_ThemTG.setText("Thêm");
        btn_ThemTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemTGActionPerformed(evt);
            }
        });
        jPanel11.add(btn_ThemTG);

        btn__SuaTG.setText("Sửa");
        btn__SuaTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn__SuaTGActionPerformed(evt);
            }
        });
        jPanel11.add(btn__SuaTG);

        btn_XoaTG.setText("Xoá");
        btn_XoaTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaTGActionPerformed(evt);
            }
        });
        jPanel11.add(btn_XoaTG);

        btn_MoiTG.setText("Mới");
        btn_MoiTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiTGActionPerformed(evt);
            }
        });
        jPanel11.add(btn_MoiTG);

        btn_TimTG.setText("Tìm");
        btn_TimTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimTGActionPerformed(evt);
            }
        });
        jPanel11.add(btn_TimTG);

        pnl_ThongTinTacGia.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 310, 30));

        javax.swing.GroupLayout pnl_TacGIaLayout = new javax.swing.GroupLayout(pnl_TacGIa);
        pnl_TacGIa.setLayout(pnl_TacGIaLayout);
        pnl_TacGIaLayout.setHorizontalGroup(
            pnl_TacGIaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_TacGIaLayout.createSequentialGroup()
                .addComponent(pnl_ThongTinTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnl_TacGIaLayout.setVerticalGroup(
            pnl_TacGIaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_TacGIaLayout.createSequentialGroup()
                .addComponent(pnl_ThongTinTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(pnl_TacGIa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 620));

        pnl_NXB.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhà Xuất Bản"));
        pnl_NXB.setOpaque(false);

        tbl_NXB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã NXB", "Tên NXB", "Địa Chỉ", "Trạng Thái"
            }
        ));
        tbl_NXB.setOpaque(false);
        tbl_NXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NXBMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_NXB);

        pnl_ThongTinNXB.setOpaque(false);
        pnl_ThongTinNXB.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Tên Nhà Xuất bản");
        pnl_ThongTinNXB.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        pnl_ThongTinNXB.add(txt_TenNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, -1));

        jLabel5.setText("Địa Chỉ Nhà Xuất bản");
        pnl_ThongTinNXB.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txt_DiaChiNXB.setColumns(20);
        txt_DiaChiNXB.setRows(5);
        jScrollPane7.setViewportView(txt_DiaChiNXB);

        pnl_ThongTinNXB.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 60));

        txt_MaNXB.setEnabled(false);
        pnl_ThongTinNXB.add(txt_MaNXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 180, -1));

        jLabel11.setText("Mã NXB");
        pnl_ThongTinNXB.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        btn_ThemNXb.setText("Thêm");
        btn_ThemNXb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemNXbActionPerformed(evt);
            }
        });
        jPanel12.add(btn_ThemNXb);

        btn_SuaNxb.setText("Sửa");
        btn_SuaNxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaNxbActionPerformed(evt);
            }
        });
        jPanel12.add(btn_SuaNxb);

        btn_XoaNXb.setText("Xoá");
        btn_XoaNXb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaNXbActionPerformed(evt);
            }
        });
        jPanel12.add(btn_XoaNXb);

        btn_MoiNxb.setText("Mới");
        btn_MoiNxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiNxbActionPerformed(evt);
            }
        });
        jPanel12.add(btn_MoiNxb);

        btn_TimNXb.setText("Tìm");
        btn_TimNXb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimNXbActionPerformed(evt);
            }
        });
        jPanel12.add(btn_TimNXb);

        pnl_ThongTinNXB.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 310, 30));

        javax.swing.GroupLayout pnl_NXBLayout = new javax.swing.GroupLayout(pnl_NXB);
        pnl_NXB.setLayout(pnl_NXBLayout);
        pnl_NXBLayout.setHorizontalGroup(
            pnl_NXBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pnl_ThongTinNXB, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        pnl_NXBLayout.setVerticalGroup(
            pnl_NXBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_NXBLayout.createSequentialGroup()
                .addComponent(pnl_ThongTinNXB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(pnl_NXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 350, 620));

        pnl_NN.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngôn Ngữ"));
        pnl_NN.setOpaque(false);

        tbl_NN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã NN", "Tên NN", "Trạng Thái"
            }
        ));
        tbl_NN.setOpaque(false);
        tbl_NN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NNMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_NN);

        pnl_ThongTinNN.setOpaque(false);
        pnl_ThongTinNN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Tên Ngôn Ngữ");
        pnl_ThongTinNN.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        pnl_ThongTinNN.add(txt_TenNN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, -1));

        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        btn_ThemNN.setText("Thêm");
        btn_ThemNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemNNActionPerformed(evt);
            }
        });
        jPanel13.add(btn_ThemNN);

        btn_SuaNN.setText("Sửa");
        btn_SuaNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaNNActionPerformed(evt);
            }
        });
        jPanel13.add(btn_SuaNN);

        btn_XoaNN.setText("Xoá");
        btn_XoaNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaNNActionPerformed(evt);
            }
        });
        jPanel13.add(btn_XoaNN);

        btn_MoiNN.setText("Mới");
        btn_MoiNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiNNActionPerformed(evt);
            }
        });
        jPanel13.add(btn_MoiNN);

        btn_TimNN.setText("Tìm");
        btn_TimNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimNNActionPerformed(evt);
            }
        });
        jPanel13.add(btn_TimNN);

        pnl_ThongTinNN.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 310, 30));

        txt_MaNN.setEnabled(false);
        pnl_ThongTinNN.add(txt_MaNN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 180, -1));

        jLabel12.setText("Mã NN");
        pnl_ThongTinNN.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        javax.swing.GroupLayout pnl_NNLayout = new javax.swing.GroupLayout(pnl_NN);
        pnl_NN.setLayout(pnl_NNLayout);
        pnl_NNLayout.setHorizontalGroup(
            pnl_NNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pnl_ThongTinNN, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        pnl_NNLayout.setVerticalGroup(
            pnl_NNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_NNLayout.createSequentialGroup()
                .addComponent(pnl_ThongTinNN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(pnl_NN, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 350, 620));

        jTabbedPane1.addTab("Thông  Tin Khác", jPanel3);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_TheLoai.setBorder(javax.swing.BorderFactory.createTitledBorder("Thể Loại"));
        pnl_TheLoai.setOpaque(false);

        tblTheLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã TL", "Tên TL", "Mô Tả", "Trạng Thái"
            }
        ));
        tblTheLoai.setOpaque(false);
        tblTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTheLoaiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTheLoai);

        pnl_ThongTinTL.setOpaque(false);
        pnl_ThongTinTL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Tên Thể Loại");
        pnl_ThongTinTL.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        pnl_ThongTinTL.add(txt_TenTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, -1));

        jLabel8.setText("Mô Tả");
        pnl_ThongTinTL.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txt_Mota.setColumns(20);
        txt_Mota.setRows(5);
        jScrollPane8.setViewportView(txt_Mota);

        pnl_ThongTinTL.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jPanel14.setLayout(new java.awt.GridLayout(1, 0));

        btn_ThemTL.setText("Thêm");
        btn_ThemTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemTLActionPerformed(evt);
            }
        });
        jPanel14.add(btn_ThemTL);

        btn_SuaTL.setText("Sửa");
        btn_SuaTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaTLActionPerformed(evt);
            }
        });
        jPanel14.add(btn_SuaTL);

        btn_XoaTL.setText("Xoá");
        btn_XoaTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaTLActionPerformed(evt);
            }
        });
        jPanel14.add(btn_XoaTL);

        btn_MoiTL.setText("Mới");
        btn_MoiTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiTLActionPerformed(evt);
            }
        });
        jPanel14.add(btn_MoiTL);

        btn_TimTL.setText("Tìm");
        btn_TimTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimTLActionPerformed(evt);
            }
        });
        jPanel14.add(btn_TimTL);

        pnl_ThongTinTL.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 310, 30));

        txt_MaTl.setEnabled(false);
        pnl_ThongTinTL.add(txt_MaTl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 180, -1));

        jLabel13.setText("Mã TL");
        pnl_ThongTinTL.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        javax.swing.GroupLayout pnl_TheLoaiLayout = new javax.swing.GroupLayout(pnl_TheLoai);
        pnl_TheLoai.setLayout(pnl_TheLoaiLayout);
        pnl_TheLoaiLayout.setHorizontalGroup(
            pnl_TheLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pnl_ThongTinTL, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        pnl_TheLoaiLayout.setVerticalGroup(
            pnl_TheLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_TheLoaiLayout.createSequentialGroup()
                .addComponent(pnl_ThongTinTL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.add(pnl_TheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 620));

        pnl_KVLuuTru.setBorder(javax.swing.BorderFactory.createTitledBorder("Khu Vực Lưu Trữ"));
        pnl_KVLuuTru.setOpaque(false);

        tblKhuVucLT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MaKV", "TenKV", "Trạng Thái"
            }
        ));
        tblKhuVucLT.setOpaque(false);
        tblKhuVucLT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuVucLTMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblKhuVucLT);

        pnl_ThongTinKVLT.setOpaque(false);
        pnl_ThongTinKVLT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("Tên Khu Vực");
        pnl_ThongTinKVLT.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        pnl_ThongTinKVLT.add(txt_TenKV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, -1));

        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        btn_ThemKV.setText("Thêm");
        btn_ThemKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemKVActionPerformed(evt);
            }
        });
        jPanel15.add(btn_ThemKV);

        btn_SuaKV.setText("Sửa");
        btn_SuaKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaKVActionPerformed(evt);
            }
        });
        jPanel15.add(btn_SuaKV);

        btn_XoaKV.setText("Xoá");
        btn_XoaKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaKVActionPerformed(evt);
            }
        });
        jPanel15.add(btn_XoaKV);

        btn_MoiKV.setText("Mới");
        btn_MoiKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MoiKVActionPerformed(evt);
            }
        });
        jPanel15.add(btn_MoiKV);

        btn_TimKV.setText("Tìm");
        btn_TimKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKVActionPerformed(evt);
            }
        });
        jPanel15.add(btn_TimKV);

        pnl_ThongTinKVLT.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 310, 30));

        txt_MaKV.setEnabled(false);
        pnl_ThongTinKVLT.add(txt_MaKV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 180, -1));

        jLabel14.setText("Mã KV");
        pnl_ThongTinKVLT.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        javax.swing.GroupLayout pnl_KVLuuTruLayout = new javax.swing.GroupLayout(pnl_KVLuuTru);
        pnl_KVLuuTru.setLayout(pnl_KVLuuTruLayout);
        pnl_KVLuuTruLayout.setHorizontalGroup(
            pnl_KVLuuTruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pnl_ThongTinKVLT, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        pnl_KVLuuTruLayout.setVerticalGroup(
            pnl_KVLuuTruLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_KVLuuTruLayout.createSequentialGroup()
                .addComponent(pnl_ThongTinKVLT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.add(pnl_KVLuuTru, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 350, 620));

        pnl_AnhSach.setBorder(javax.swing.BorderFactory.createTitledBorder("Ảnh Sách"));
        pnl_AnhSach.setOpaque(false);
        pnl_AnhSach.setPreferredSize(new java.awt.Dimension(350, 560));

        tblAnhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Ảnh", "ID Sách", "Tên Ảnh", "Trạng Thái"
            }
        ));
        tblAnhSach.setOpaque(false);
        jScrollPane6.setViewportView(tblAnhSach);

        pnl_ThongTinAnhSach.setOpaque(false);
        pnl_ThongTinAnhSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbb_Sach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbb_Sach.setOpaque(false);
        pnl_ThongTinAnhSach.add(cbb_Sach, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, -1));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setOpaque(false);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Anh, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_Anh, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );

        pnl_ThongTinAnhSach.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 130, 180));

        jPanel16.setLayout(new java.awt.GridLayout(1, 0));

        btn_ThemA.setText("Thêm");
        jPanel16.add(btn_ThemA);

        btn_SuaA.setText("Sửa");
        jPanel16.add(btn_SuaA);

        btn_XoaA.setText("Xoá");
        jPanel16.add(btn_XoaA);

        btn_MoiA.setText("Mới");
        jPanel16.add(btn_MoiA);

        btn_TimA.setText("Tìm");
        jPanel16.add(btn_TimA);

        pnl_ThongTinAnhSach.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 310, 30));

        btn_ChonANh.setText("Chọn ảnh");
        pnl_ThongTinAnhSach.add(btn_ChonANh, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        txt_MaAnh.setEnabled(false);
        pnl_ThongTinAnhSach.add(txt_MaAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 180, -1));

        jLabel15.setText("Mã Ảnh");
        pnl_ThongTinAnhSach.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));
        pnl_ThongTinAnhSach.add(txt_TenAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 180, -1));

        jLabel16.setText("Tên Ảnh");
        pnl_ThongTinAnhSach.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        javax.swing.GroupLayout pnl_AnhSachLayout = new javax.swing.GroupLayout(pnl_AnhSach);
        pnl_AnhSach.setLayout(pnl_AnhSachLayout);
        pnl_AnhSachLayout.setHorizontalGroup(
            pnl_AnhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pnl_ThongTinAnhSach, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        pnl_AnhSachLayout.setVerticalGroup(
            pnl_AnhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_AnhSachLayout.createSequentialGroup()
                .addComponent(pnl_ThongTinAnhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.add(pnl_AnhSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 350, 620));

        jTabbedPane1.addTab("Thông Tin Khác", jPanel6);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sách", "Tên Sách", "Năm Xuất Bản", "So Luong", "Giá", "Phân Đoạn", "Số Trang", "Mô Tả", "Ngôn Ngữ", "Thể Loại", "Nhà Xuất Bản", "Tác Giả", "Khu Vực Lưu Trữ", "Trạng Thái"
            }
        ));
        jScrollPane9.setViewportView(tblSach);

        jPanel2.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 297, 1070, 310));

        cbb_TacGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbb_TacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, -1));

        cbb_NXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbb_NXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 200, -1));

        cbb_NN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbb_NN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 200, -1));

        cbb_TL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbb_TL, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 200, -1));

        cbb_KVLuutru.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbb_KVLuutru, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 200, -1));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 0, 200, -1));

        jLabel17.setText("Mã Sách");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 3, -1, -1));

        jLabel18.setText("Tên Sách");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 38, -1, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 35, 200, -1));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 70, 200, -1));

        jLabel19.setText("Năm Xuất Bản");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 73, -1, -1));

        jLabel20.setText("Số Lượng");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 105, -1, -1));
        jPanel2.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 105, 100, -1));

        jLabel21.setText("Giá");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 143, -1, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 140, 200, -1));

        jLabel22.setText("Phân Đoạn");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 3, -1, -1));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 0, 200, -1));

        jLabel23.setText("Số trang");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 38, -1, -1));
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 35, 200, -1));

        jLabel24.setText("Mô Tả");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(624, 70, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane10.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, 76, 200, -1));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("Mới");
        jPanel1.add(jButton1);

        jButton2.setText("jButton2");
        jPanel1.add(jButton2);

        jButton4.setText("jButton4");
        jPanel1.add(jButton4);

        jButton5.setText("jButton5");
        jPanel1.add(jButton5);

        jButton3.setText("jButton3");
        jPanel1.add(jButton3);

        jButton6.setText("jButton6");
        jPanel1.add(jButton6);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 390, 39));

        jLabel25.setText("Tác Giả");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jLabel26.setText("Nhà Xuất Bản");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel27.setText("Ngôn Ngữ");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel28.setText("Thể Loại");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel29.setText("Khu Vực Lưu Trữ");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jTabbedPane1.addTab("Sách", jPanel2);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_TacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TacGiaMouseClicked
        // TODO add your handling code here:
        clickTblTG();
    }//GEN-LAST:event_tbl_TacGiaMouseClicked

    private void tbl_NXBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NXBMouseClicked
        // TODO add your handling code here:
        clickTblNXB();
    }//GEN-LAST:event_tbl_NXBMouseClicked

    private void btn_ThemTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemTGActionPerformed
        // TODO add your handling code here:
        themTG();

    }//GEN-LAST:event_btn_ThemTGActionPerformed

    private void btn_ThemNXbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemNXbActionPerformed
        // TODO add your handling code here:
        themNXB();
    }//GEN-LAST:event_btn_ThemNXbActionPerformed

    private void btn_SuaNxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaNxbActionPerformed
        // TODO add your handling code here:
        suaNXB();
    }//GEN-LAST:event_btn_SuaNxbActionPerformed

    private void btn_XoaNXbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaNXbActionPerformed
        // TODO add your handling code here:
        xoaNXB();
    }//GEN-LAST:event_btn_XoaNXbActionPerformed

    private void btn_MoiNxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiNxbActionPerformed
        // TODO add your handling code here:
        moiNXB();
    }//GEN-LAST:event_btn_MoiNxbActionPerformed

    private void btn_TimNXbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimNXbActionPerformed
        // TODO add your handling code here:
        findTenNXB();
    }//GEN-LAST:event_btn_TimNXbActionPerformed

    private void btn__SuaTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn__SuaTGActionPerformed
        // TODO add your handling code here:
        suaTG();
    }//GEN-LAST:event_btn__SuaTGActionPerformed

    private void btn_XoaTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaTGActionPerformed
        // TODO add your handling code here:
        xoaTG();
    }//GEN-LAST:event_btn_XoaTGActionPerformed

    private void btn_MoiTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiTGActionPerformed
        // TODO add your handling code here:
        moiTG();
    }//GEN-LAST:event_btn_MoiTGActionPerformed

    private void btn_TimTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimTGActionPerformed
        // TODO add your handling code here:
        findTenTG();
    }//GEN-LAST:event_btn_TimTGActionPerformed

    private void btn_ThemTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemTLActionPerformed
        // TODO add your handling code here:
        themTL();
    }//GEN-LAST:event_btn_ThemTLActionPerformed

    private void btn_SuaTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaTLActionPerformed
        // TODO add your handling code here:
        suaTL();
    }//GEN-LAST:event_btn_SuaTLActionPerformed

    private void btn_XoaTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaTLActionPerformed
        // TODO add your handling code here:
        xoaTL();
    }//GEN-LAST:event_btn_XoaTLActionPerformed

    private void btn_MoiTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiTLActionPerformed
        // TODO add your handling code here:
        moiTL();
    }//GEN-LAST:event_btn_MoiTLActionPerformed

    private void btn_TimTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimTLActionPerformed
        // TODO add your handling code here:
        findTenTL();
    }//GEN-LAST:event_btn_TimTLActionPerformed

    private void tblTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTheLoaiMouseClicked
        // TODO add your handling code here:
        clickTblTL();
    }//GEN-LAST:event_tblTheLoaiMouseClicked

    private void btn_ThemKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemKVActionPerformed
        // TODO add your handling code here:
        themKV();
    }//GEN-LAST:event_btn_ThemKVActionPerformed

    private void btn_SuaKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaKVActionPerformed
        // TODO add your handling code here:
        suaKV();
    }//GEN-LAST:event_btn_SuaKVActionPerformed

    private void btn_XoaKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaKVActionPerformed
        // TODO add your handling code here:
        xoaKV();
    }//GEN-LAST:event_btn_XoaKVActionPerformed

    private void btn_MoiKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiKVActionPerformed
        // TODO add your handling code here:
        moiKV();
    }//GEN-LAST:event_btn_MoiKVActionPerformed

    private void btn_TimKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKVActionPerformed
        // TODO add your handling code here:
        filltableKV();
    }//GEN-LAST:event_btn_TimKVActionPerformed

    private void tblKhuVucLTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuVucLTMouseClicked
        // TODO add your handling code here:
        clickTblKV();
    }//GEN-LAST:event_tblKhuVucLTMouseClicked

    private void btn_ThemNNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemNNActionPerformed
        // TODO add your handling code here:
        themNN();
    }//GEN-LAST:event_btn_ThemNNActionPerformed

    private void btn_SuaNNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaNNActionPerformed
        // TODO add your handling code here:
        suaNN();
    }//GEN-LAST:event_btn_SuaNNActionPerformed

    private void btn_XoaNNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaNNActionPerformed
        // TODO add your handling code here:
        xoaNN();
    }//GEN-LAST:event_btn_XoaNNActionPerformed

    private void btn_MoiNNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MoiNNActionPerformed
        // TODO add your handling code here:
        moiNN();
    }//GEN-LAST:event_btn_MoiNNActionPerformed

    private void btn_TimNNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimNNActionPerformed
        // TODO add your handling code here:
        findTenNN();
    }//GEN-LAST:event_btn_TimNNActionPerformed

    private void tbl_NNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NNMouseClicked
        // TODO add your handling code here:
        clickTblNN();
    }//GEN-LAST:event_tbl_NNMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ChonANh;
    private javax.swing.JButton btn_MoiA;
    private javax.swing.JButton btn_MoiKV;
    private javax.swing.JButton btn_MoiNN;
    private javax.swing.JButton btn_MoiNxb;
    private javax.swing.JButton btn_MoiTG;
    private javax.swing.JButton btn_MoiTL;
    private javax.swing.JButton btn_SuaA;
    private javax.swing.JButton btn_SuaKV;
    private javax.swing.JButton btn_SuaNN;
    private javax.swing.JButton btn_SuaNxb;
    private javax.swing.JButton btn_SuaTL;
    private javax.swing.JButton btn_ThemA;
    private javax.swing.JButton btn_ThemKV;
    private javax.swing.JButton btn_ThemNN;
    private javax.swing.JButton btn_ThemNXb;
    private javax.swing.JButton btn_ThemTG;
    private javax.swing.JButton btn_ThemTL;
    private javax.swing.JButton btn_TimA;
    private javax.swing.JButton btn_TimKV;
    private javax.swing.JButton btn_TimNN;
    private javax.swing.JButton btn_TimNXb;
    private javax.swing.JButton btn_TimTG;
    private javax.swing.JButton btn_TimTL;
    private javax.swing.JButton btn_XoaA;
    private javax.swing.JButton btn_XoaKV;
    private javax.swing.JButton btn_XoaNN;
    private javax.swing.JButton btn_XoaNXb;
    private javax.swing.JButton btn_XoaTG;
    private javax.swing.JButton btn_XoaTL;
    private javax.swing.JButton btn__SuaTG;
    private javax.swing.JComboBox<String> cbb_KVLuutru;
    private javax.swing.JComboBox<String> cbb_NN;
    private javax.swing.JComboBox<String> cbb_NXB;
    private javax.swing.JComboBox<String> cbb_Sach;
    private javax.swing.JComboBox<String> cbb_TL;
    private javax.swing.JComboBox<String> cbb_TacGia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lbl_Anh;
    private javax.swing.JPanel pnl_AnhSach;
    private javax.swing.JPanel pnl_KVLuuTru;
    private javax.swing.JPanel pnl_NN;
    private javax.swing.JPanel pnl_NXB;
    private javax.swing.JPanel pnl_TacGIa;
    private javax.swing.JPanel pnl_TheLoai;
    private javax.swing.JPanel pnl_ThongTinAnhSach;
    private javax.swing.JPanel pnl_ThongTinKVLT;
    private javax.swing.JPanel pnl_ThongTinNN;
    private javax.swing.JPanel pnl_ThongTinNXB;
    private javax.swing.JPanel pnl_ThongTinTL;
    private javax.swing.JPanel pnl_ThongTinTacGia;
    private javax.swing.JTable tblAnhSach;
    private javax.swing.JTable tblKhuVucLT;
    private javax.swing.JTable tblSach;
    private javax.swing.JTable tblTheLoai;
    private javax.swing.JTable tbl_NN;
    private javax.swing.JTable tbl_NXB;
    private javax.swing.JTable tbl_TacGia;
    private javax.swing.JTextArea txt_DiaChiNXB;
    private javax.swing.JTextField txt_MaAnh;
    private javax.swing.JTextField txt_MaKV;
    private javax.swing.JTextField txt_MaNN;
    private javax.swing.JTextField txt_MaNXB;
    private javax.swing.JTextField txt_MaTG;
    private javax.swing.JTextField txt_MaTl;
    private javax.swing.JTextArea txt_Mota;
    private com.toedter.calendar.JDateChooser txt_NgaySinh;
    private javax.swing.JTextField txt_QuocTich;
    private javax.swing.JTextField txt_TenAnh;
    private javax.swing.JTextField txt_TenKV;
    private javax.swing.JTextField txt_TenNN;
    private javax.swing.JTextField txt_TenNXB;
    private javax.swing.JTextField txt_TenTG;
    private javax.swing.JTextField txt_TenTL;
    // End of variables declaration//GEN-END:variables
}
