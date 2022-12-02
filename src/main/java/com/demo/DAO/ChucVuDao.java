/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.ChucVu;
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
public class ChucVuDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(ChucVu cv) {
        try {
            pst = con.prepareStatement("insert into ChucVu values(?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ChucVu> Select() {
        List<ChucVu> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from ChucVu");
            while (rs.next()) {
                list.add(new ChucVu(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChucVuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void Update(String MaCV, String TenCV) throws SQLException {
        PreparedStatement st = con.prepareStatement("update ChucVu set TenCV = ? where MaCV =?");
        st.setString(1, TenCV);
        st.setString(2, MaCV);
        st.executeUpdate();
    }

    public void Delete(String MaCV) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from ChucVu where MaCV = ?");
            pt.setString(1, MaCV);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
