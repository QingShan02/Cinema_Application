/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.helper;

import javax.swing.JOptionPane;
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
public class ThongBao {
    String noidung;
    int type;
    public void show(){
        int a;
        if(getType()==1){
            a = JOptionPane.ERROR_MESSAGE;
        } else{
            a = JOptionPane.INFORMATION_MESSAGE;
        }
        JOptionPane.showMessageDialog(null, getNoidung(), "Thông báo", a);
    }
}
