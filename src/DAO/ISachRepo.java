/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import ViewModels.SachViewModel;
import java.util.List;

/**
 *
 * @author Hieu
 */
public interface ISachRepo {
    public List<SachViewModel> selectBySQL(String sql, String[] cols, Object... args);
    public List<SachViewModel> getAllData();
}
