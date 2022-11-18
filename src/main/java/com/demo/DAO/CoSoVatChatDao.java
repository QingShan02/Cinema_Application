/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.DAO;

import com.demo.model.CoSoVatChat;
import com.raven.DAO.ConnectDB;
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
 * @author hohoa
 */
public class CoSoVatChatDao {
    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;
    List<CoSoVatChat> csvc_list;
    public void Insert(String macsvc, String tencsvc, String hinh) {
        try {
            pst = con.prepareStatement("insert into csvc values(?,?,?)");
            pst.setString(1, macsvc);
            pst.setString(2, tencsvc);
            pst.setString(3, hinh);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<CoSoVatChat> Select() {
        CoSoVatChat c;
        csvc_list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from csvc");
            while (rs.next()) { 
                c = new CoSoVatChat();
                c.setMacsvc(rs.getString("macsvc"));
                c.setTencsvc(rs.getString("tencsvc"));
                c.setHinh(rs.getString("hinh"));
                csvc_list.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return csvc_list;
    }
    
    public CoSoVatChat SelectById(int macsvc){
        CoSoVatChat c = new CoSoVatChat();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select csvc.*, ct_csvc.soluong, ct_csvc.maphong from csvc join ct_csvc on csvc.macsvc = ct_csvc.macsvc where csvc.macsvc = "+ macsvc);
            while (rs.next()) {                
                c.setMacsvc(rs.getString("macsvc"));
                c.setTencsvc(rs.getString("tencsvc"));
                c.setHinh(rs.getString("hinh"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }
    
    public void Update(String macsvc, String tencsvc, String hinh) throws SQLException {
        PreparedStatement st = con.prepareStatement("update csvc set tencsvc = ?, hinh = ?  where macsvc =?");
        st.setString(1, tencsvc);
        st.setString(2, hinh);
        st.setString(3, macsvc);
        st.executeUpdate();
    }

    public void Delete(String macsvc) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from csvc where macsvc = ?");
            pt.setString(1, macsvc);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<CoSoVatChat> SelectAll() {
        List<CoSoVatChat> a = new ArrayList<>();
        try {
            PreparedStatement pt = con.prepareCall("{ call SelectCSVC()}");
            rs = pt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1)+","+rs.getString(2));
                a.add(new CoSoVatChat(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoSoVatChatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    public void InsertCTCSVC(String macn, String maphong, int soluong) {
        try {
            pst = con.prepareStatement("insert into ct_csvc values(?, ?, ?)");
            pst.setString(1, macn);
            pst.setString(2, maphong);
            pst.setInt(3, soluong);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoSoVatChatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateCTCSVC(String macsvc, String maphong, int soluong) throws SQLException {
        PreparedStatement st = con.prepareStatement("update ct_csvc set maphong = ?, soluong = ?  where macsvc =?");
        st.setString(1, maphong);
        st.setInt(2, soluong);
        st.setString(3, macsvc);
        st.executeUpdate();
    }
}
