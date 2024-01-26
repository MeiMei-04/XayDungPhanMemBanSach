/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.ChucVu;
import java.util.List;

/**
 *
 * @author truon
 */
public interface IChucVuRepo {
    public boolean insert(ChucVu CV);
    public boolean update(ChucVu CV);
    public boolean delete(String CV);
    public List<ChucVu> selectBySQL(String sql, Object... args);
    public List<ChucVu> getAllData();
    public List<ChucVu> findTenCV(String CV);
}
