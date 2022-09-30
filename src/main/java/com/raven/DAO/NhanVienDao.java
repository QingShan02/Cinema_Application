/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.NhanVien;
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
public class NhanVienDao {
    static Connection con = ConnectDB.getConnection();
    static Statement st =null;
    static PreparedStatement pst = null;
    static ResultSet rs;
    
    public void Insert(NhanVien nv){
        try {
            pst = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<NhanVien> Select(){
        List<NhanVien> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from NhanVien");
            while(rs.next()){
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
