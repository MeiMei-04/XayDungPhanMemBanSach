/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BUS;

import Models.SanPham;
import ViewModels.SachViewModel;
import java.util.List;

/**
 *
 * @author Hieu
 */
public interface IQLSanPhamService {
//  Interface Không Có body code;
//  Trong interface Mặc Đinh là public không thể sử dụng private;
//  Hiểu đơn giản interface là phần xác mà chưa có hồn
    
    public List<SachViewModel> getData();
    
}
