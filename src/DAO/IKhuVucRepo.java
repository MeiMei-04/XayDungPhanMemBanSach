/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.KhuVucLuuTru;
import java.util.List;

/**
 *
 * @author Hieu
 */
public interface IKhuVucRepo {
    public boolean insert(KhuVucLuuTru KV);
    public boolean update(KhuVucLuuTru KV);
    public boolean delete(String KV);
    public List<KhuVucLuuTru> selectBySQL(String sql, Object... args);
    public List<KhuVucLuuTru> getAllData();
    public List<KhuVucLuuTru> findTenKV(String Kv);
}
