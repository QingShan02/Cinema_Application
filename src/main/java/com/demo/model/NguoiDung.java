/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Daokh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NguoiDung implements Serializable{
    private String MaNguoiDung;
    private String TenNguoiDung;
    private String MatKhau;
    private String Email;
    private String MaCN;
   

    public NguoiDung(String MatKhau, String Email) {
        this.MatKhau = MatKhau;
        this.Email = Email;
    }
    
}
