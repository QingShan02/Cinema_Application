/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;

import com.demo.form.Form_Loading;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.raven.model.ThanhToan;
import javax.swing.UIManager;

/**
 *
 * @author Daokh
 */
public class RunMain {

    public static void main(String[] args) {
        try {
            FlatDarculaLaf.setup();
            UIManager.put("Button.arc", 999);
            UIManager.put("Component.arc", 999);
            UIManager.put("ProgressBar.arc", 999);
            UIManager.put("TextComponent.arc", 999);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Form_Loading().show();
        
    }
}
