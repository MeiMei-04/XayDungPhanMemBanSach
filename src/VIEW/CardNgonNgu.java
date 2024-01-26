/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package VIEW;

import BUS.IQLSanPhamService;
import BUS.IQLThuocTinhSachService;
import BUS.QLSanPhamService;
import BUS.QLThuocTinhSachService;
import Models.NgonNguSanPham;
import Models.TacGia;
import Utilities.DiaLogMes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hieu
 */
public class CardNgonNgu extends javax.swing.JDialog {
    DiaLogMes diaLogMes;
    DefaultTableModel model;
    IQLThuocTinhSachService _iQLThuocTinhSachService;
    IQLSanPhamService _iQLSanPhamService;
    List<NgonNguSanPham> _lstNgonNguSanPham;
    /**
     * Creates new form jDiaLogNgonNgu
     */
    public CardNgonNgu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        _iQLThuocTinhSachService = new QLThuocTinhSachService();
        _iQLSanPhamService = new QLSanPhamService();
        _lstNgonNguSanPham = new ArrayList<>();
        diaLogMes = new DiaLogMes();
        _lstNgonNguSanPham = _iQLThuocTinhSachService.getDataNN();
        filltableNN();
    }
    private void refreshTableNN() {
        _lstNgonNguSanPham = _iQLThuocTinhSachService.getDataNN();
        filltableNN();
    }

    private void findTenNN() {
        String tenNN = txt_TenNN.getText();
        if (_iQLThuocTinhSachService.findTenNN(tenNN).isEmpty()) {
            diaLogMes.alert(this, "Thông Tin Hiện Tại Không Khả Dụng");
        } else {
            _lstNgonNguSanPham = _iQLThuocTinhSachService.findTenNN(tenNN);
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
        if (_iQLThuocTinhSachService.insert_NN(nn)) {
            diaLogMes.alert(this, "Thêm Thành Công");
        } else {
            diaLogMes.alert(this, "Thêm Thất Bại");
        }
    }

    private void suaNN() {
        NgonNguSanPham nn = getFormNN();
        if (_iQLThuocTinhSachService.update_NN(nn)) {
            diaLogMes.alert(this, "Sửa Thành Công");
        } else {
            diaLogMes.alert(this, "Sửa Thất Bại");
        }
    }

    private void xoaNN() {
        String maNN = txt_MaNN.getText();
        if (_iQLThuocTinhSachService.delete_NN(maNN)) {
            diaLogMes.alert(this, "Xoá Thành Công");
        } else {
            diaLogMes.alert(this, "Xoá Thất Bại");
        }
    }

    private void clickTblNN() {
        int row = tbl_NN.getSelectedRow();
        String mannn = (String) tbl_NN.getValueAt(row, 1);
        String tennn = (String) tbl_NN.getValueAt(row, 2);
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
        int stt = 1;
        if (_lstNgonNguSanPham.isEmpty()) {
            return;
        }
        for (NgonNguSanPham nn : _lstNgonNguSanPham) {
                Object[] row = {
                    stt,
                    nn.getMa_NN(),
                    nn.getTenNN(),
                    nn.TrangThaiString()
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnl_NN.setBorder(javax.swing.BorderFactory.createTitledBorder("Ngôn Ngữ"));
        pnl_NN.setOpaque(false);

        tbl_NN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Stt", "Mã NN", "Tên NN", "Trạng Thái"
            }
        ));
        tbl_NN.setOpaque(false);
        tbl_NN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NNMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_NN);
        if (tbl_NN.getColumnModel().getColumnCount() > 0) {
            tbl_NN.getColumnModel().getColumn(0).setResizable(false);
        }

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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
            .addComponent(pnl_ThongTinNN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_NNLayout.setVerticalGroup(
            pnl_NNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_NNLayout.createSequentialGroup()
                .addComponent(pnl_ThongTinNN, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_NN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 13, Short.MAX_VALUE)
                    .addComponent(pnl_NN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_NNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NNMouseClicked
        // TODO add your handling code here:
        clickTblNN();
    }//GEN-LAST:event_tbl_NNMouseClicked

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

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_MoiNN;
    private javax.swing.JButton btn_SuaNN;
    private javax.swing.JButton btn_ThemNN;
    private javax.swing.JButton btn_TimNN;
    private javax.swing.JButton btn_XoaNN;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnl_NN;
    private javax.swing.JPanel pnl_ThongTinNN;
    private javax.swing.JTable tbl_NN;
    private javax.swing.JTextField txt_MaNN;
    private javax.swing.JTextField txt_TenNN;
    // End of variables declaration//GEN-END:variables
}
