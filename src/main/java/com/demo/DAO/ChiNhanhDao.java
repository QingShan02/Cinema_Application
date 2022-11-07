/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.DAO;

import com.demo.model.ChiNhanh;
import com.raven.DAO.ConnectDB;
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
public class ChiNhanhDao {
    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;
    public List<ChiNhanh> select(){
        List<ChiNhanh> list = new ArrayList<>();
        try {
            st =con.createStatement();
            rs = st.executeQuery("select * from ChiNhanh");
            while(rs.next()){
                list.add(new ChiNhanh(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanhDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
