/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Hieu
 */
public class Convert_TO {
    public Date intConvertToDate(int i){
        // Convert the int to an Instant
        Instant instant = Instant.ofEpochSecond(i);

        // Convert the Instant to a Date
        Date date = Date.from(instant);
        return date;
    }
    public String intConvertToSring(int i){
        String TrangThai = null;
        if(i == 0){
            TrangThai = "Đã Xoá";
        }
        return TrangThai;
    }
}
