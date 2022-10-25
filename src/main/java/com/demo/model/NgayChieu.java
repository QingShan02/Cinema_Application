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
public class NgayChieu implements Serializable{

    private int Stt;
    private String Ngay;
    private String GioBatDau;
    public NgayChieu(String GioBatDau) {

        this.GioBatDau = GioBatDau;
    }

    public NgayChieu(int Stt, String GioBatDau) {
        this.Stt = Stt;
        this.GioBatDau = GioBatDau;
    }

}
