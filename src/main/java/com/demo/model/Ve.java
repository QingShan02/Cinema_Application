/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
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
    private int stt_xc;
    private int TongSoVe;
    private int Thang;
    private Date Ngay;
    
    public Ve(double GiaVe, double ThueVAT, int MaCTGhe, int stt_xc) {
        this.GiaVe = GiaVe;
        this.ThueVAT = ThueVAT;
        this.MaCTGhe = MaCTGhe;
        this.stt_xc = stt_xc;
    }

    public Ve(double GiaVe, double ThueVAT, int MaKH, int MaCTGhe, int stt_xc) {
        this.GiaVe = GiaVe;
        this.ThueVAT = ThueVAT;
        this.MaKH = MaKH;
        this.MaCTGhe = MaCTGhe;
        this.stt_xc = stt_xc;
    }
    
    public Ve(int TongSoVe, double GiaVe) {
        this.TongSoVe = TongSoVe;
        this.GiaVe = GiaVe;
    }
 public Ve(int TongSoVe, double GiaVe, int Thang){
        this.TongSoVe = TongSoVe;
        this.GiaVe = GiaVe;
        this.Thang = Thang;
    }
 public Ve(Date Ngay, int TongSoVe, double GiaVe) {
        this.Ngay = Ngay;
        this.TongSoVe = TongSoVe;
        this.GiaVe = GiaVe;
    }
}
