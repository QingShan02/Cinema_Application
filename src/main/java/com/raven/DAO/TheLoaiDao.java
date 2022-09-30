/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.TheLoai;
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
 * @author TRA
 */
public class TheLoaiDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(TheLoai tl) {
        try {
            pst = con.prepareStatement("insert into TheLoai values(?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(TheLoaiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<TheLoai> Select() {
        List<TheLoai> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from TheLoai");
            while (rs.next()) {
                list.add(new TheLoai(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TheLoai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void UpdateTheLoai(String TenTheLoai, String MaTheLoai) throws SQLException {
        PreparedStatement st = con.prepareStatement("update TheLoai set TenTheLoai = ? where MaTheLoai =?");
        st.setString(1, TenTheLoai);
        st.setString(2, MaTheLoai);
        st.executeUpdate();
    }

    public static void DeleteTheLoai(String MaTheLoai) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from TheLoai where MaTheLoai = ?");
            pt.setString(1, MaTheLoai);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
