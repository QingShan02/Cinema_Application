/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.NguoiDung;
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
public class NguoiDungDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;
    static String MaNV;

    public static void setMaNV(String MaNV){
        NguoiDungDao.MaNV = MaNV;
        }
    
    public void Insert(NguoiDung nv) {
        try {
            pst = con.prepareStatement("insert into NguoiDung values(?,?,?,?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<NguoiDung> Select() {
        List<NguoiDung> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from NguoiDung");
            while (rs.next()) {
                list.add(new NguoiDung(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void UpdateNhanVien(String HoTen, int GioiTinh, String MatKhau, String NgaySinh, String SoDT, String MaCV, String MaNV) throws SQLException {
        PreparedStatement st = con.prepareStatement("update NguoiDung set TenNguoiDung = ?, MatKhau = ?, SoDT = ?, MaCN = ? where MaNguoiDung =?");
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
            PreparedStatement pt = con.prepareStatement("delete from NguoiDung where MaNguoiDung = ?");
            pt.setString(1, MaNV);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public static void UpdateNV(String MK) throws SQLException {
        PreparedStatement pt = con.prepareStatement("UPDATE NhanVien SET MatKhau = ? WHERE MaNV = '" + MaNV + "'");
        pt.setString(1, MK);
        pt.executeUpdate();
        System.out.println(MaNV);

    }
}
