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
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;
    private static String SoDT;

    public static void setSoDT(String SoDT){
        NhanVienDao.SoDT = SoDT;
        }
    
    public void Insert(NhanVien nv) {
        try {
            pst = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<NhanVien> Select() {
        List<NhanVien> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from NhanVien");
            while (rs.next()) {
                list.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void UpdateNhanVien(String HoTen, int GioiTinh, String MatKhau, String NgaySinh, String SoDT, String MaCV, String MaNV) throws SQLException {
        PreparedStatement st = con.prepareStatement("update NhanVien set HoTen = ?, GioiTinh = ? , MatKhau = ?, NgaySinh = ?, SoDT = ?, MaCV = ? where MaNV =?");
        st.setString(1, HoTen);
        st.setInt(2, GioiTinh);
        st.setString(3, MatKhau);
        st.setString(4, NgaySinh);
        st.setString(5, SoDT);
        st.setString(6, MaCV);
        st.setString(7, MaNV);
        st.executeUpdate();
    }
    
    public static void DeleteNhanVien(String MaNV){
        try {
            PreparedStatement pt = con.prepareStatement("delete from NhanVien where MaNV = ?");
            pt.setString(1, MaNV);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  public static void UpdateNhanVien(String MatKhau) throws SQLException {

        PreparedStatement pt = con.prepareStatement("update NhanVien set MatKhau = ? where SoDT = '" + SoDT + "'");
        pt.setString(1, MatKhau);
        pt.executeUpdate();
        System.out.println(SoDT);
    }
}
