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
public class NhanVien implements Serializable{
    private String MaNV;
    private String HoTen;
    private int GioiTinh;
    private String MatKhau;
    private String NgaySinh;
    private String SoDT;
    private String MaCV;
    @Override
    public String toString(){
        return "NhanVien{"+getMaNV()+","+getHoTen()+"}";
    }

    public NhanVien(String MatKhau, String SoDT) {
        this.MatKhau = MatKhau;
        this.SoDT = SoDT;
    }
    
}
