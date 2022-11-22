/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.main;

import com.demo.form.Form_ChonChiNhanh;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.raven.DAO.NguoiDungDao;
import com.raven.model.NguoiDung;
import com.raven.model.ThanhToan;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Daokh
 */
public class RunMain {

    public static void main(String[] args) {
        NguoiDungDao dao = new NguoiDungDao();
        try {
            FlatDarculaLaf.setup();
            UIManager.put("Button.arc", 999);
            UIManager.put("Component.arc", 999);
            UIManager.put("ProgressBar.arc", 999);
            UIManager.put("TextComponent.arc", 999);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (new File("savetk.txt").length() != 0) {
                if (new File("temp.txt").length() == 0) {
                    Form_ChonChiNhanh cn = new Form_ChonChiNhanh();
                    cn.show();
                    return;
                } else {
                    NguoiDung list_temp = (NguoiDung) DangNhap.readObj("savetk.txt");
                    dao.Select().stream().filter(s -> s.getSoDT().equalsIgnoreCase(list_temp.getSoDT())).forEach(s -> NguoiDungDao.setMaNV(s.getMaNguoiDung()));
                    ThanhToan tt = (ThanhToan) DangNhap.readObj("temp.txt");
                    Main main = new Main(tt.getMaCN());
                    main.show();
                    return;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        DangNhap dn = new DangNhap();
        dn.show();
    }
}
