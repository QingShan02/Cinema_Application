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
            System.out.println("aaaa");
            pst.setInt(1, kh.getMaKH());
            pst.setString(2, kh.getTenKH());
            pst.setString(3, kh.getMatKhau());
            pst.setString(4, kh.getEmail());
            pst.setString(6, kh.getDiaChi());
            pst.setString(5, kh.getSoDT());
            pst.setInt(7, kh.getGioiTinh());   
            System.out.println("bbb");
            int kq = pst.executeUpdate();
            System.out.println("cccc");
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

    public void UpdateKhachHang(String TenKH, String MatKhau, String Email, String SoDT, String DiaChi, int GioiTinh, int MaKH) throws SQLException {
        try {
        PreparedStatement st = con.prepareStatement("update KhachHang set TenKH = ?, MatKhau = ?, Email = ?, SoDT = ?, DiaChi = ?,GioiTinh = ?  where MaKH =?");
        st.setString(1, TenKH);
        st.setString(2, MatKhau);
        st.setString(3, Email);
        st.setString(4, SoDT);
        st.setString(5, DiaChi);
        st.setInt(6, GioiTinh);
        st.setInt(7, MaKH);
        st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteKhachHang(Integer MaKH) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from KhachHang where MaKH = ?");
            pt.setInt(1, MaKH);
            pt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
