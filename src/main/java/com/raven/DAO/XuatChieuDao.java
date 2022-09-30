/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.XuatChieu;
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
public class XuatChieuDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(XuatChieu xc) {
        try {
            pst = con.prepareStatement("insert into XuatChieu values(?,?,?,?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(XuatChieuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<XuatChieu> Select() {
        List<XuatChieu> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from XuatChieu");
            while (rs.next()) {
                list.add(new XuatChieu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(XuatChieuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void Update(int STT, String MaPhong, String MaPhim, double GiaXuatChieu, String Ngay) throws SQLException {
        PreparedStatement st = con.prepareStatement("update XuatChieu set STT = ?, MaPhong = ?, MaPhim = ?, GiaXuatChieu = ? where Ngay =?");
        st.setInt(1, STT);
        st.setString(2, MaPhong);
        st.setString(3, MaPhim);
        st.setDouble(4, GiaXuatChieu);
        st.setString(5, Ngay);
        st.executeUpdate();
    }

    public void Delete(String Ngay) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from XuatChieu where Ngay = ?");
            pt.setString(1, Ngay);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
