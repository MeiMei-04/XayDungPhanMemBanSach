/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package VIEW;

import BUS.IQLSanPhamService;
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
import BUS.IQLThuocTinhSachService;
import BUS.QLSanPhamService;
import BUS.QLThuocTinhSachService;
import Models.Sach;
import Utilities.Convert_TO;
import Utilities.FormatDuLieu;
import ViewModels.SachViewModel;
import java.util.ArrayList;

/**
 *
 * @author Hieu
 */
public class CardQuanLySach extends javax.swing.JPanel {

    DiaLogMes diaLogMes;
    DefaultTableModel model;
    IQLThuocTinhSachService _iQLThuocTinhSachService;
    IQLSanPhamService _iQLSanPhamService;
    List<NhaXuatBan> _lstNhaXuatBan;
    List<TacGia> _lstTacGia;
    List<TheLoai> _lstTheLoai;
    List<KhuVucLuuTru> _lstKhuVucLuuTru;
    List<NgonNguSanPham> _lstNgonNguSanPham;
    List<SachViewModel> _lstSachViewModel;
    CardKhuVucLuuTru _cardKhuVucLuuTru;
    CardNgonNgu _cardNgonNgu;
    CardNhaXuatBan _cardNhaXuatBan;
    CardTacGia _cardTacGia;
    CardTheLoai _cardTheLoai;
    FormatDuLieu _formatDuLieu;
    Convert_TO _convert_TO;

    /**
     * Creates new form cardQuanLySach
     */
    public CardQuanLySach() {
        initComponents();
        _iQLThuocTinhSachService = new QLThuocTinhSachService();
        _iQLSanPhamService = new QLSanPhamService();
        _lstNhaXuatBan = new ArrayList<>();
        _lstTacGia = new ArrayList<>();
        _lstTheLoai = new ArrayList<>();
        _lstKhuVucLuuTru = new ArrayList<>();
        _lstNgonNguSanPham = new ArrayList<>();
        _lstSachViewModel = new ArrayList<>();
        diaLogMes = new DiaLogMes();
        _cardKhuVucLuuTru = new CardKhuVucLuuTru(null, true);
        _cardNgonNgu = new CardNgonNgu(null, true);
        _cardNhaXuatBan = new CardNhaXuatBan(null, true);
//        _cardTacGia = new CardTacGia(null, false);
        _cardTheLoai = new CardTheLoai(null, true);
        _formatDuLieu = new FormatDuLieu();
        _convert_TO = new Convert_TO();
        getDataAll();
        fillCbb();
        filltableSach();
    }

    private int getIdTacGia() {
        int id = -1;
        int index = cbb_TacGia.getSelectedIndex();
        TacGia tg = _lstTacGia.get(index);
        id = tg.getId_TG();
        return id;
    }
    private int getIdNXB() {
        int id = -1;
        int index = cbb_NXB.getSelectedIndex();
        NhaXuatBan nxb = _lstNhaXuatBan.get(index);
        id = nxb.getId_NXB();
        return id;
    }
    private int getIdNN() {
        int id = -1;
        int index = cbb_NN.getSelectedIndex();
        NgonNguSanPham nn = _lstNgonNguSanPham.get(index);
        id = nn.getId_NN();
        return id;
    }
    private int getIdTL() {
        int id = -1;
        int index = cbb_TL.getSelectedIndex();
        TheLoai tl = _lstTheLoai.get(index);
        id = tl.getId_TL();
        return id;
    }
    private int getIdKV() {
        int id = -1;
        int index = cbb_KVLuutru.getSelectedIndex();
        KhuVucLuuTru kv = _lstKhuVucLuuTru.get(index);
        id = kv.getId_KV();
        return id;
    }

    private Sach getFormSach() {
        int namXB = 0;
        int giaTien = 0;
        int soTrang = 0;
        int id_TG = getIdTacGia();
        int id_NXB = getIdNXB();
        int id_TL = getIdTL();
        int id_KV = getIdKV();
        String tenSach = txt_TenSach.getText();
        try {
            namXB = Integer.parseInt(cbb_NamSX.getSelectedItem().toString());
            giaTien = Integer.parseInt(txt_Gia.getText());
            soTrang = Integer.parseInt(txt_Gia.getText());
        } catch (Exception e) {
            diaLogMes.alert(this, "đừng có nhập chữ nữa, t mệt mõi lắm rồi");
        }
        int soLuong = (int) spn_SoLuong.getValue();
        Sach s = new Sach();
        s.setID_TG(id_TG);
        s.setID_TL(id_TL);
        s.setId_KV(id_KV);
        s.setId_NXB(id_NXB);
        s.setTenSach(tenSach);
        s.setNamSanXuat(namXB);
        s.setSoluongSanPham(soLuong);
        s.setGiaSanPham(giaTien);
        s.setSoTrang(soTrang);
        s.setMoTa(txt_Mota.getText());
        return s;
    }

    private void clickTblSach() {
        int row = tblSach.getSelectedRow();
        String maSach = (String) tblSach.getValueAt(row, 1);
        String tenSach = (String) tblSach.getValueAt(row, 2);
        int namSX = (int) tblSach.getValueAt(row, 3);
        int soLuong = (int) tblSach.getValueAt(row, 4);
        int giaTien = (int) tblSach.getValueAt(row, 5);
        int soTrang = (int) tblSach.getValueAt(row, 6);
        String moTa = (String) tblSach.getValueAt(row, 7);
        String ngonNgu = (String) tblSach.getValueAt(row, 8);
        String theLoai = (String) tblSach.getValueAt(row, 9);
        String nhaXB = (String) tblSach.getValueAt(row, 10);
        String tacGia = (String) tblSach.getValueAt(row, 11);
        String kvLuuTru = (String) tblSach.getValueAt(row, 12);

        txt_MaSach.setText(maSach);
        txt_TenSach.setText(tenSach);
        String namSXString = String.valueOf(namSX);
        spn_SoLuong.setValue(soLuong);

        // Convert int to String
        String giaTienString = _formatDuLieu.formatMoney(giaTien);
        txt_Gia.setText(giaTienString);
        String soTrangString = String.valueOf(soTrang);
        txt_SoTrang.setText(soTrangString + " Trang");
        txt_Mota.setText(moTa);
        cbb_TL.setSelectedItem(theLoai);
        cbb_NN.setSelectedItem(ngonNgu);
        cbb_NXB.setSelectedItem(nhaXB);
        cbb_TacGia.setSelectedItem(tacGia);
        cbb_KVLuutru.setSelectedItem(kvLuuTru);
        cbb_NamSX.setSelectedItem(String.valueOf(namSX));
    }

    private void themKV() {
        _cardKhuVucLuuTru.setVisible(true);
    }

    private void themNXb() {
        _cardNhaXuatBan.setVisible(true);
    }

    private void themTl() {
        _cardTheLoai.setVisible(true);
    }

    private void themTG() {
        _cardTacGia = new CardTacGia(null, false);
        _cardTacGia.setVisible(true);
    }

    private void getDataAll() {
        _lstNhaXuatBan = _iQLThuocTinhSachService.getDataNXB();
        _lstTacGia = _iQLThuocTinhSachService.getDataTG();
        _lstTheLoai = _iQLThuocTinhSachService.getDataTL();
        _lstKhuVucLuuTru = _iQLThuocTinhSachService.getDataKV();
        _lstNgonNguSanPham = _iQLThuocTinhSachService.getDataNN();
        _lstSachViewModel = _iQLSanPhamService.getData();
    }

    private void fillCbb() {
        fillcbbTG();
        fillcbbNXB();
        fillcbbTL();
        fillcbbKV();
        fillcbbNN();
        fillcbbNamSX();
    }

    private void filltableSach() {
        model = (DefaultTableModel) tblSach.getModel();
        model.setRowCount(0);
        if (_lstSachViewModel.isEmpty()) {
            return;
        }
        for (SachViewModel svm : _lstSachViewModel) {
            if (svm.getTrangThai() != 2) {
                Object[] row = {
                    svm.getsTT(),
                    svm.getMaSach(),
                    svm.getTenSach(),
                    svm.getNamXuatBan(),
                    svm.getSoLuong(),
                    svm.getGia(),
                    svm.getSoTrang(),
                    svm.getMota(),
                    svm.getNgonNgu(),
                    svm.getTheLoai(),
                    svm.getNhaXuatBan(),
                    svm.getTacGia(),
                    svm.getKvLuuTru(),
                    svm.TrangThaiString()
                };
                model.addRow(row);
            }
        }
    }
    private void fillcbbNamSX() {
        cbb_NamSX.removeAllItems();
        for(int i = 1990;i<2025;i++){
            cbb_NamSX.addItem(String.valueOf(i));
        }
    }
    private void fillcbbKV() {
        cbb_KVLuutru.removeAllItems();
        for (KhuVucLuuTru kv : _lstKhuVucLuuTru) {
            cbb_KVLuutru.addItem(kv.getTenKV());
        }
    }

    private void fillcbbTL() {
        cbb_TL.removeAllItems();
        for (TheLoai tl : _lstTheLoai) {
            cbb_TL.addItem(tl.getTenTL());
        }
    }

    private void fillcbbNN() {
        cbb_NN.removeAllItems();
        for (NgonNguSanPham nn : _lstNgonNguSanPham) {
            cbb_NN.addItem(nn.getTenNN());
        }
    }

    private void fillcbbNXB() {
        cbb_NXB.removeAllItems();
        for (NhaXuatBan nxb : _lstNhaXuatBan) {
            cbb_NXB.addItem(nxb.getTenNXB());
        }
    }

    private void fillcbbTG() {
        cbb_TacGia.removeAllItems();
        for (TacGia tg : _lstTacGia) {
            cbb_TacGia.addItem(tg.getTenTG());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        cbb_TacGia = new javax.swing.JComboBox<>();
        cbb_NXB = new javax.swing.JComboBox<>();
        cbb_NN = new javax.swing.JComboBox<>();
        cbb_TL = new javax.swing.JComboBox<>();
        cbb_KVLuutru = new javax.swing.JComboBox<>();
        txt_MaSach = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_TenSach = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        spn_SoLuong = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        txt_Gia = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_SoTrang = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txt_Mota = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btn_ThemKV = new javax.swing.JButton();
        btn_ThemNXb = new javax.swing.JButton();
        btn_ThemTacGia = new javax.swing.JButton();
        btn_ThemNN = new javax.swing.JButton();
        btn_ThemTL = new javax.swing.JButton();
        cbb_NamSX = new javax.swing.JComboBox<>();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sách", "Tên Sách", "Năm Xuất Bản", "So Luong", "Giá", "Số Trang", "Mô Tả", "Ngôn Ngữ", "Thể Loại", "Nhà Xuất Bản", "Tác Giả", "Khu Vực Lưu Trữ", "Trạng Thái"
            }
        ));
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
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
        jPanel2.add(txt_MaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 200, -1));

        jLabel17.setText("Mã Sách");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 3, -1, -1));

        jLabel18.setText("Tên Sách");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));
        jPanel2.add(txt_TenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 200, -1));

        jLabel19.setText("Năm Xuất Bản");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 73, -1, -1));

        jLabel20.setText("Số Lượng");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 105, -1, -1));

        spn_SoLuong.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(spn_SoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 200, -1));

        jLabel21.setText("Giá");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 143, -1, -1));
        jPanel2.add(txt_Gia, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 200, -1));

        jLabel23.setText("Số trang");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, -1));
        jPanel2.add(txt_SoTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 200, -1));

        jLabel24.setText("Mô Tả");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        txt_Mota.setColumns(20);
        txt_Mota.setRows(5);
        jScrollPane10.setViewportView(txt_Mota);

        jPanel2.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 200, -1));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("Mới");
        jPanel1.add(jButton1);

        jButton2.setText("Thêm");
        jPanel1.add(jButton2);

        jButton4.setText("Sửa");
        jPanel1.add(jButton4);

        jButton5.setText("Xoá");
        jPanel1.add(jButton5);

        jButton3.setText("Tìm");
        jPanel1.add(jButton3);

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

        btn_ThemKV.setText("+");
        btn_ThemKV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemKVActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ThemKV, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        btn_ThemNXb.setText("+");
        btn_ThemNXb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemNXbActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ThemNXb, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        btn_ThemTacGia.setText("+");
        btn_ThemTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemTacGiaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ThemTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        btn_ThemNN.setText("+");
        btn_ThemNN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemNNActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ThemNN, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        btn_ThemTL.setText("+");
        btn_ThemTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemTLActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ThemTL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        cbb_NamSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbb_NamSX, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 200, -1));

        jTabbedPane1.addTab("Sách", jPanel2);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemKVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemKVActionPerformed
        // TODO add your handling code here:
        themKV();
    }//GEN-LAST:event_btn_ThemKVActionPerformed

    private void btn_ThemNXbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemNXbActionPerformed
        // TODO add your handling code here:
        themNXb();
    }//GEN-LAST:event_btn_ThemNXbActionPerformed

    private void btn_ThemTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemTacGiaActionPerformed
        // TODO add your handling code here:
        themTG();
    }//GEN-LAST:event_btn_ThemTacGiaActionPerformed

    private void btn_ThemNNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemNNActionPerformed
        // TODO add your handling code here:
        themTl();
    }//GEN-LAST:event_btn_ThemNNActionPerformed

    private void btn_ThemTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemTLActionPerformed
        // TODO add your handling code here:
        themTl();
    }//GEN-LAST:event_btn_ThemTLActionPerformed

    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        // TODO add your handling code here:
        clickTblSach();
    }//GEN-LAST:event_tblSachMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ThemKV;
    private javax.swing.JButton btn_ThemNN;
    private javax.swing.JButton btn_ThemNXb;
    private javax.swing.JButton btn_ThemTL;
    private javax.swing.JButton btn_ThemTacGia;
    private javax.swing.JComboBox<String> cbb_KVLuutru;
    private javax.swing.JComboBox<String> cbb_NN;
    private javax.swing.JComboBox<String> cbb_NXB;
    private javax.swing.JComboBox<String> cbb_NamSX;
    private javax.swing.JComboBox<String> cbb_TL;
    private javax.swing.JComboBox<String> cbb_TacGia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner spn_SoLuong;
    private javax.swing.JTable tblSach;
    private javax.swing.JTextField txt_Gia;
    private javax.swing.JTextField txt_MaSach;
    private javax.swing.JTextArea txt_Mota;
    private javax.swing.JTextField txt_SoTrang;
    private javax.swing.JTextField txt_TenSach;
    // End of variables declaration//GEN-END:variables
}
