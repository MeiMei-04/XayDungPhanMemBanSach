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
import ViewModels.SachViewModel;
import java.util.ArrayList;

/**
 *
 * @author Hieu
 */
public class cardQuanLySach extends javax.swing.JPanel {

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

    /**
     * Creates new form cardQuanLySach
     */
    public cardQuanLySach() {
        initComponents();
        _iQLThuocTinhSachService = new QLThuocTinhSachService();
        _iQLSanPhamService = new QLSanPhamService();
        _lstNhaXuatBan = new ArrayList<>();
        _lstTacGia = new ArrayList<>();
        _lstTheLoai = new ArrayList<>();
        _lstKhuVucLuuTru = new ArrayList<>();
        _lstNgonNguSanPham = new ArrayList<>();
        _lstSachViewModel = new ArrayList<>();
        _lstNhaXuatBan = _iQLThuocTinhSachService.getDataNXB();
        _lstTacGia = _iQLThuocTinhSachService.getDataTG();
        _lstTheLoai = _iQLThuocTinhSachService.getDataTL();
        _lstKhuVucLuuTru = _iQLThuocTinhSachService.getDataKV();
        _lstNgonNguSanPham = _iQLThuocTinhSachService.getDataNN();
        _lstSachViewModel = _iQLSanPhamService.getData();
        diaLogMes = new DiaLogMes();
        fillcbbTG();
        fillcbbNXB();
        fillcbbTL();
        fillcbbKV();
        fillcbbNN();
        filltableSach();
    }

    private void rsCbb() {
        _lstNgonNguSanPham = _iQLThuocTinhSachService.getDataNN();
        _lstTacGia = _iQLThuocTinhSachService.getDataTG();
        _lstKhuVucLuuTru = _iQLThuocTinhSachService.getDataKV();
        _lstTheLoai = _iQLThuocTinhSachService.getDataTL();
        _lstNhaXuatBan = _iQLThuocTinhSachService.getDataNXB();
        fillcbbTG();
        fillcbbNXB();
        fillcbbTL();
        fillcbbKV();
        fillcbbNN();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbb_KVLuutru;
    private javax.swing.JComboBox<String> cbb_NN;
    private javax.swing.JComboBox<String> cbb_NXB;
    private javax.swing.JComboBox<String> cbb_TL;
    private javax.swing.JComboBox<String> cbb_TacGia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tblSach;
    // End of variables declaration//GEN-END:variables
}
