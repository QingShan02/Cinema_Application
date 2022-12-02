/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.LoaiGhe;
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
public class LoaiGheDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(LoaiGhe lg) {
        try {
            pst = con.prepareStatement("insert into LoaiGhe values(?,?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(LoaiGheDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<LoaiGhe> Select() {
        List<LoaiGhe> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from LoaiGhe");
            while (rs.next()) {
                list.add(new LoaiGhe(rs.getInt(1), rs.getString(2), rs.getLong(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiGheDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void Update(String TenLoai, long PhuThu, int MaLoaiGhe) throws SQLException {
        PreparedStatement st = con.prepareStatement("update LoaiGhe set TenLoai = ?, PhuThu = ? where MaLoaiGhe =?");
        st.setString(1, TenLoai);
        st.setLong(2, PhuThu);
        st.setInt(3, MaLoaiGhe);
        st.executeUpdate();
    }

    public void Delete(int MaLoaiGhe) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from LoaiGhe where MaLoaiGhe = ?");
            pt.setInt(1, MaLoaiGhe);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
