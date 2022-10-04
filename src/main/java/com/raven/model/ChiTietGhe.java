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
public class ChiTietGhe {
    private int MaCTGhe;
    private String MaPhong;
    private String MaGhe;
    private String TenGhe;

    public ChiTietGhe(String MaPhong, String TenGhe) {
        this.MaPhong = MaPhong;
        this.TenGhe = TenGhe;
    }
    
}
