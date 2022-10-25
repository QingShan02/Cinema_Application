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
public class ChiTietGhe implements Serializable{
    private int MaCTGhe;
    private String MaPhong;
    private String MaGhe;
    private String TenGhe;
    private double gia;

    public ChiTietGhe(String MaPhong, String TenGhe,int MaCTGhe) {
        this.MaCTGhe = MaCTGhe;
        this.MaPhong = MaPhong;
        this.TenGhe = TenGhe;
    }

    public ChiTietGhe(String MaPhong, String TenGhe,int MaCTGhe, String MaGhe, double gia) {
        this.MaCTGhe = MaCTGhe;
        this.MaPhong = MaPhong;
        this.MaGhe = MaGhe;
        this.TenGhe = TenGhe;
        this.gia = gia;
    }
    
    
    public ChiTietGhe(int MaCTGhe, String TenGhe) {
        this.MaCTGhe = MaCTGhe;
        this.TenGhe = TenGhe;
    }
    
}
