/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.PhongChieu;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRA
 */
public class PhongDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(PhongChieu pc) {
        try {
            pst = con.prepareStatement("insert into Phong values(?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(PhongDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<PhongChieu> Select() {
        List<PhongChieu> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from PhongChieu");
            while (rs.next()) {
                list.add(new PhongChieu(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
    }

    public void Update(String TenPhong, String MaPhong) throws SQLException {
        PreparedStatement st = con.prepareStatement("update PhongChieu set TenPhong = ? where MaPhong =?");
        st.setString(1, TenPhong);
        st.setString(2, MaPhong);
        st.executeUpdate();
    }

    public void Delete(String MaPhong) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from PhongChieu where MaPhong = ?");
            pt.setString(1, MaPhong);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<String> SelectGheInVe(String ngay, int stt,String maphim){
        List<String> list = new ArrayList<>();
        try {
            pst = con.prepareCall("{ call SelectGheInVe(?,?,?)}");
            pst.setDate(1, java.sql.Date.valueOf("2022-09-01"));
            pst.setInt(2, stt);
            pst.setString(3, maphim);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
    }
}
