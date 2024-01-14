/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Models.SanPham;
import java.util.List;

/**
 *
 * @author Hieu
 */
public interface ISanPhamRepo {
    public String insert();
    public List<SanPham> getData();
}
