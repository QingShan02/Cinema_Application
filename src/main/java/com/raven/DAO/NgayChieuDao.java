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

    public List<NgayChieu> Select() {
        List<NgayChieu> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from NgayChieu");
        } catch (SQLException ex) {
            Logger.getLogger(NgayChieuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
