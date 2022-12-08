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
public class Topping implements Serializable{
    private String MaTopping;
    private String TenTopping;
    private int SoLuongDangCo;
    private double Gia;
    private String hinh;
    private int SoLuongMua;

    public Topping(String MaTopping, String TenTopping, double Gia, String hinh) {
        this.MaTopping = MaTopping;
        this.TenTopping = TenTopping;
        this.Gia = Gia;
        this.hinh = hinh;
    }

    public Topping(String MaTopping, String TenTopping, int SoLuongMua) {
        this.MaTopping = MaTopping;
        this.TenTopping = TenTopping;
        this.SoLuongMua = SoLuongMua;
    }

    public Topping(String MaTopping, String TenTopping, int SoLuongMua , double Gia) {
        this.MaTopping = MaTopping;
        this.TenTopping = TenTopping;
        this.Gia = Gia;
    this.SoLuongMua = SoLuongMua;
    }

 
    
}
