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
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(Phim p) {
        try {
            pst = con.prepareStatement("insert into Phim values(?,?,?,?,?,?,?,?,?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(PhimDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Phim> Select() {
        List<Phim> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from Phim");
            while (rs.next()) {
                list.add(new Phim(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void UpdatePhim(String TenPhim, String DienVien, String NamSX, String Hinh, String DaoDien, String QuocGia, String ThoiLuong, String MoTa, String Traller, String MaPhim) throws SQLException {
        PreparedStatement st = con.prepareStatement("update NhanVien set TenPhim = ?, DienVien = ?, NamSX = ?, Hinh = ?, DaoDien = ?, QuocGia = ?, ThoiLuong = ?, MoTa = ?, Traller = ? where MaPhim =?");
        st.setString(1, TenPhim);
        st.setString(2, DienVien);
        st.setString(3, NamSX);
        st.setString(4, Hinh);
        st.setString(5, DaoDien);
        st.setString(6, QuocGia);
        st.setString(7, ThoiLuong);
        st.setString(8, MoTa);
        st.setString(9, Traller);
        st.setString(10, MaPhim);
        st.executeUpdate();
    }

    public static void DeletePhim(String MaPhim) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from Phim where MaPhim = ?");
            pt.setString(1, MaPhim);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
