/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.NgayChieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daokh
 */
public class NgayChieuDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;
    List<NgayChieu> list;

    public void insert(NgayChieu nc) {
        try {
            pst = con.prepareStatement("insert into NgayChieu values(?,?,?)");
            pst.setInt(1, nc.getStt());
            pst.setDate(2, java.sql.Date.valueOf(nc.getNgay()));
            pst.setString(3, nc.getGioBatDau());

            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(NgayChieuDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<NgayChieu> Select() {
        list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from NgayChieu");
        } catch (SQLException ex) {
            Logger.getLogger(NgayChieuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
        public List<NgayChieu> SelectGio() {
        list = new ArrayList<>();
        try {
            pst = con.prepareCall("{ call SelectGio()}");
            rs = pst.executeQuery();
              while (rs.next()) {
                list.add(new NgayChieu(rs.getInt("Stt"), rs.getString("Ngay"),rs.getString("GioBatDau")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NgayChieuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        
    public List<NgayChieu> SelectGioBatDau(String ngayChieu) {
        list = new ArrayList<>();
        
        try {
            pst = con.prepareStatement("select Stt, GioBatDau from NgayChieu where Ngay = ?");
            pst.setDate(1, java.sql.Date.valueOf(ngayChieu));
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new NgayChieu(rs.getInt("Stt"), rs.getString("GioBatDau")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NgayChieuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return list;
    }
}
