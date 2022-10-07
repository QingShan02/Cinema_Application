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
public class Phim {

    private String MaPhim;
    private String TenPhim;
    private String DienVien;
    private int NamSX;
    private String Hinh;
    private String DaoDien;
    private String QuocGia;
    private String ThoiLuong;
    private String MoTa;
    private String Traller;

    public Phim(String MaPhim, String TenPhim, int NamSX) {
        this.MaPhim = MaPhim;
        this.TenPhim = TenPhim;
        this.NamSX = NamSX;
    }


}
