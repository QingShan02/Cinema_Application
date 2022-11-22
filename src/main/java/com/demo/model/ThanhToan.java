/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.model;

import java.io.Serializable;
import java.util.List;
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
public class ThanhToan implements Serializable{
    private int MaCTGhe;
    private String MaGhe;
    private double GiaGhe;
    private String MaPhong;
    private int STT;
    private String NgayChieu;
    private String MaPhim;
    List<Topping> ListTopping;
    private String maCN;
}
