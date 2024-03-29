/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package VIEW;

import BUS.IQLSanPhamService;
import BUS.IQLThuocTinhSachService;
import BUS.QLSanPhamService;
import BUS.QLThuocTinhSachService;
import Models.NhaXuatBan;
import Models.TacGia;
import Utilities.DiaLogMes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieu
 */
public class CardNhaXuatBan extends javax.swing.JDialog {

    DiaLogMes diaLogMes;
    DefaultTableModel model;
    IQLThuocTinhSachService _iQLThuocTinhSachService;
    IQLSanPhamService _iQLSanPhamService;
    List<NhaXuatBan> _lstNhaXuatBan;

    /**
     * Creates new form JDiaLogNhaXuatBan
     */
    public CardNhaXuatBan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        _iQLThuocTinhSachService = new QLThuocTinhSachService();
        _iQLSanPhamService = new QLSanPhamService();
        _lstNhaXuatBan = new ArrayList<>();
        diaLogMes = new DiaLogMes();
        _lstNhaXuatBan = _iQLThuocTinhSachService.getDataNXB();
        filltableNXB();
    }
    private void refreshTableTNXB() {
        _lstNhaXuatBan = _iQLThuocTinhSachService.getDataNXB();
        filltableNXB();
    }

    private void findTenNXB() {
        String tennxb = txt_TenNXB.getText();
        if (_iQLThuocTinhSachService.findTenNXB(tennxb).isEmpty()) {
            diaLogMes.alert(this, "Thông Tin Hiện Tại Không Khả Dụng");
        } else {
            _lstNhaXuatBan = _iQLThuocTinhSachService.findTenNXB(tennxb);
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
        if (_iQLThuocTinhSachService.insert_NXB(nxb)) {
            diaLogMes.alert(this, "Thêm Thành Công");
        } else {
            diaLogMes.alert(this, "Thêm Thất Bại");
        }
    }

    private void suaNXB() {
        NhaXuatBan nxb = getFormNXB();
        if (_iQLThuocTinhSachService.update_NXB(nxb)) {
            diaLogMes.alert(this, "Sửa Thành Công");
        } else {
            diaLogMes.alert(this, "Sửa Thất Bại");
        }
    }

    private void xoaNXB() {
        String maNXB = txt_MaNXB.getText();
        if (_iQLThuocTinhSachService.delete_NXB(maNXB)) {
            diaLogMes.alert(this, "Xoá Thành Công");
        } else {
            diaLogMes.alert(this, "Xoá Thất Bại");
        }
    }

    private void clickTblNXB() {
        int row = tbl_NXB.getSelectedRow();
        String manxb = (String) tbl_NXB.getValueAt(row, 1);
        String tennxb = (String) tbl_NXB.getValueAt(row, 2);
        String diachi = (String) tbl_NXB.getValueAt(row, 3);
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
        int stt =1;
        if (_lstNhaXuatBan.isEmpty()) {
            return;
        }
        for (NhaXuatBan nxb : _lstNhaXuatBan) {
                Object[] row = {
                    stt,
                    nxb.getMa_NXB(),
                    nxb.getTenNXB(),
                    nxb.getDiaChiNXB(),
                    nxb.TrangThaiString()
                };
                model.addRow(row);
                stt++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnl_NXB.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhà Xuất Bản"));
        pnl_NXB.setOpaque(false);

        tbl_NXB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Stt", "Mã NXB", "Tên NXB", "Địa Chỉ", "Trạng Thái"
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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
            .addComponent(pnl_ThongTinNXB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_NXBLayout.setVerticalGroup(
            pnl_NXBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_NXBLayout.createSequentialGroup()
                .addComponent(pnl_ThongTinNXB, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_NXB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_NXB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_NXBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NXBMouseClicked
        // TODO add your handling code here:
        clickTblNXB();
    }//GEN-LAST:event_tbl_NXBMouseClicked

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

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_MoiNxb;
    private javax.swing.JButton btn_SuaNxb;
    private javax.swing.JButton btn_ThemNXb;
    private javax.swing.JButton btn_TimNXb;
    private javax.swing.JButton btn_XoaNXb;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel pnl_NXB;
    private javax.swing.JPanel pnl_ThongTinNXB;
    private javax.swing.JTable tbl_NXB;
    private javax.swing.JTextArea txt_DiaChiNXB;
    private javax.swing.JTextField txt_MaNXB;
    private javax.swing.JTextField txt_TenNXB;
    // End of variables declaration//GEN-END:variables
}
