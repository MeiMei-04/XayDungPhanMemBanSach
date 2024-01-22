/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BUS;

import Models.KhuVucLuuTru;
import Models.NgonNguSanPham;
import Models.NhaXuatBan;
import Models.TacGia;
import Models.TheLoai;
import ViewModels.NXBViewModel;
import com.toedter.calendar.JDateChooser;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Hieu
 */
public interface IQLThongTinKhacServie {

    //nxb
    public boolean insert_NXB(NhaXuatBan nxb);

    public boolean update_NXB(NhaXuatBan nxb);

    public boolean delete_NXB(String MaNXB);

    public List<NhaXuatBan> findTenNXB(String TenNXB);

    public List<NhaXuatBan> getDataNXB();

    //tg
    public boolean insert_TG(TacGia tg);

    public boolean update_TG(TacGia tg);

    public boolean delete_TG(String MaTG);

    public List<TacGia> findTenTG(String TenTG);

    public List<TacGia> getDataTG();

    //tl
    public boolean insert_TL(TheLoai Tl);

    public boolean update_TL(TheLoai Tl);

    public boolean delete_TL(String MaTl);

    public List<TheLoai> findTenTL(String TenTL);

    public List<TheLoai> getDataTL();

    //kv
    public boolean insert_KV(KhuVucLuuTru KV);

    public boolean update_KV(KhuVucLuuTru KV);

    public boolean delete_KV(String MaKV);

    public List<KhuVucLuuTru> findTenKV(String TenKV);

    public List<KhuVucLuuTru> getDataKV();

    //nn
    public boolean insert_NN(NgonNguSanPham NN);

    public boolean update_NN(NgonNguSanPham NN);

    public boolean delete_NN(String maNN);

    public List<NgonNguSanPham> findTenNN(String TenNN);

    public List<NgonNguSanPham> getDataNN();
}
