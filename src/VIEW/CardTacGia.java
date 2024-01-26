/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package VIEW;

import BUS.IQLSanPhamService;
import BUS.QLSanPhamService;
import BUS.QLThuocTinhSachService;
import Models.TacGia;
import Utilities.DiaLogMes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import BUS.IQLThuocTinhSachService;

/**
 *
 * @author HieuCute
 */
public class CardTacGia extends javax.swing.JDialog {

    DiaLogMes diaLogMes;
    DefaultTableModel model;
    IQLThuocTinhSachService _iQLThuocTinhSachService;
    IQLSanPhamService _iQLSanPhamService;
    List<TacGia> _lstTacGia;

    /**
     * Creates new form jDialogTacGia
     */
    public CardTacGia(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        _iQLThuocTinhSachService = new QLThuocTinhSachService();
        _iQLSanPhamService = new QLSanPhamService();
        _lstTacGia = new ArrayList<>();
        diaLogMes = new DiaLogMes();
        _lstTacGia = _iQLThuocTinhSachService.getDataTG();
        filltableTG();
    }

    private void refreshTableTG() {
        _lstTacGia = _iQLThuocTinhSachService.getDataTG();
        filltableTG();
    }

    private void findTenTG() {
        String tentg = txt_TenTG.getText();
        if (_iQLThuocTinhSachService.findTenTG(tentg).isEmpty()) {
            diaLogMes.alert(this, "Thông Tin Hiện Tại Không Khả Dụng");
        } else {
            _lstTacGia = _iQLThuocTinhSachService.findTenTG(tentg);
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
        if (_iQLThuocTinhSachService.insert_TG(tg)) {
            diaLogMes.alert(this, "Thêm Thành Công");
        } else {
            diaLogMes.alert(this, "Thêm Thất Bại");
        }
    }

    private void suaTG() {
        TacGia tg = getFormTG();
        if (_iQLThuocTinhSachService.update_TG(tg)) {
            diaLogMes.alert(this, "Sửa Thành Công");
        } else {
            diaLogMes.alert(this, "Sửa Thất Bại");
        }
    }

    private void xoaTG() {
        String maTG = txt_MaTG.getText();
        if (_iQLThuocTinhSachService.delete_TG(maTG)) {
            diaLogMes.alert(this, "Xoá Thành Công");
        } else {
            diaLogMes.alert(this, "Xoá Thất Bại");
        }
    }

    private void clickTblTG() {
        int row = tbl_TacGia.getSelectedRow();
        String mantg = (String) tbl_TacGia.getValueAt(row, 1);
        String tentg = (String) tbl_TacGia.getValueAt(row, 2);
        Date ngaySinh = (Date) tbl_TacGia.getValueAt(row, 3);
        String quocTich = (String) tbl_TacGia.getValueAt(row, 4);
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
        int stt = 1;
        if (_lstTacGia.isEmpty()) {
            return;
        }
        for (TacGia tg : _lstTacGia) {
                Object[] row = {
                    stt,
                    tg.getMa_TG(),
                    tg.getTenTG(),
                    tg.getNgaySinh(),
                    tg.getQuocTich(),
                    tg.TrangThaiString()
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pnl_TacGIa.setBorder(javax.swing.BorderFactory.createTitledBorder("Tác Giả"));
        pnl_TacGIa.setOpaque(false);

        tbl_TacGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Stt", "Mã TG", "Tên TG", "Ngày Sinh", "Quốc Tịch", "Trạng Thái"
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
                .addComponent(pnl_ThongTinTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        );
        pnl_TacGIaLayout.setVerticalGroup(
            pnl_TacGIaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_TacGIaLayout.createSequentialGroup()
                .addComponent(pnl_ThongTinTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(pnl_TacGIa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_TacGIa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_TacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TacGiaMouseClicked
        // TODO add your handling code here:
        clickTblTG();
    }//GEN-LAST:event_tbl_TacGiaMouseClicked

    private void btn_ThemTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemTGActionPerformed
        // TODO add your handling code here:
        themTG();
    }//GEN-LAST:event_btn_ThemTGActionPerformed

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

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_MoiTG;
    private javax.swing.JButton btn_ThemTG;
    private javax.swing.JButton btn_TimTG;
    private javax.swing.JButton btn_XoaTG;
    private javax.swing.JButton btn__SuaTG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl_TacGIa;
    private javax.swing.JPanel pnl_ThongTinTacGia;
    private javax.swing.JTable tbl_TacGia;
    private javax.swing.JTextField txt_MaTG;
    private com.toedter.calendar.JDateChooser txt_NgaySinh;
    private javax.swing.JTextField txt_QuocTich;
    private javax.swing.JTextField txt_TenTG;
    // End of variables declaration//GEN-END:variables
}
