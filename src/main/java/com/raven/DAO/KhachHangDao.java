/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.KhachHang;
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
public class KhachHangDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(KhachHang kh) {
        try {
            pst = con.prepareStatement("insert into KhachHang values(?,?,?,?,?,?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<KhachHang> Select() {
        List<KhachHang> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from KhachHang");
            while (rs.next()) {
                list.add(new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void UpdateKhachHang(String TenKH, String MatKhau, String Email, String SoDT, String DiaChi, int GioiTinh, int MaKH) throws SQLException {
        PreparedStatement st = con.prepareStatement("update KhachHang set TenKH = ?, MatKhau = ?, Email = ?, SoDT = ?, DiaChi = ?,GioiTinh = ?  where MaKH =?");
        st.setString(1, TenKH);
        st.setString(2, MatKhau);
        st.setString(3, Email);
        st.setString(4, SoDT);
        st.setString(5, DiaChi);
        st.setInt(6, GioiTinh);
        st.setInt(7, MaKH);
        st.executeUpdate();
    }

    public static void DeleteKhachHang(String MaKH) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from KhachHang where MaKH = ?");
            pt.setString(1, MaKH);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
