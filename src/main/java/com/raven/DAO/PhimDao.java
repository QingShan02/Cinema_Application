/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.Phim;
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
public class PhimDao {
    static Connection con = ConnectDB.getConnection();
    static Statement st =null;
    static PreparedStatement pst = null;
    static ResultSet rs;
    
    public List<Phim> Select(){
        List<Phim> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from Phim");
            while(rs.next()){
                list.add(new Phim(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
