/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.ChiTietTopping;
import com.raven.model.Topping;
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
public class ToppingDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(Topping tp) {
        try {
            pst = con.prepareStatement("insert into Topping values(?,?,?,?,?)");
            pst.setString(1, tp.getMaTopping());
            pst.setString(2, tp.getTenTopping());
            pst.setInt(3, tp.getSoLuongDangCo());
            pst.setFloat(4, (float) tp.getGia());
            pst.setString(5, tp.getHinh());
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(ToppingDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Topping> Select() {
        List<Topping> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from Topping");
            while (rs.next()) {
                list.add(new Topping(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4),rs.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToppingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public void InsertCT(ChiTietTopping t){
        try {
            pst = con.prepareStatement("insert into ChiTietTopping values(?,?,?)");
            pst.setInt(1, t.getIdVe());
            pst.setString(2, t.getMaTopping());
            pst.setInt(3, t.getSoLuongMua());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ToppingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void update(Topping tp) {
        try {
            PreparedStatement st = con.prepareStatement("update Topping set TenTopping = ?, SoLuongDangCo = ? , Gia = ?, Hinh=? where MaTopping =?");
            st.setString(1, tp.getTenTopping());
            st.setInt(2, tp.getSoLuongDangCo());
            st.setDouble(3, tp.getGia());
            st.setString(4, tp.getHinh());
            st.setString(5, tp.getMaTopping());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ToppingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(String MaTopping) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from Topping where MaTopping = ?");
            pt.setString(1, MaTopping);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
