/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

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
public class Ve {

    private int IdVe;
    private double GiaVe;
    private double ThueVAT;
    private int MaKH;
    private int MaCTGhe;
    private String MaNV;
    private int TongSoVe;

    
    public Ve(double GiaVe, double ThueVAT, int MaCTGhe, String MaNV) {
        this.GiaVe = GiaVe;
        this.ThueVAT = ThueVAT;
        this.MaCTGhe = MaCTGhe;
        this.MaNV = MaNV;
    }

    public Ve(int IdVe, double GiaVe, double ThueVAT, int MaKH, int MaCTGhe, String MaNV) {
        this.IdVe = IdVe;
        this.GiaVe = GiaVe;
        this.ThueVAT = ThueVAT;
        this.MaKH = MaKH;
        this.MaCTGhe = MaCTGhe;
        this.MaNV = MaNV;
    }
    
    public Ve(int SoVe, double TongGiaVe) {
        this.TongSoVe = TongSoVe;
        this.GiaVe = GiaVe;
    }

}
