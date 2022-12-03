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
    
    public List<CoSoVatChat> SelectAll(String maCN) {
        List<CoSoVatChat> csvcList = new ArrayList<>();
        try {
            PreparedStatement pt = con.prepareCall("{ call SelectCSVC(? :: text)}");
            pt.setString(1, maCN);
            rs = pt.executeQuery();
            while (rs.next()) {
                csvcList.add(new CoSoVatChat(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoSoVatChatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return csvcList;
    }
    
    public void InsertCTCSVC(String macn, String maphong, int soluong, int trangthai) {
        try {
            pst = con.prepareStatement("insert into ct_csvc values(?, ?, ?, ? :: bit)");
            pst.setString(1, macn);
            pst.setString(2, maphong);
            pst.setInt(3, soluong);
            pst.setInt(4, trangthai);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoSoVatChatDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateCTCSVC(String macsvc, String maphong, int soluong, int trangthai) throws SQLException {
        PreparedStatement st = con.prepareStatement("update ct_csvc set soluong = ?, trangthai = ? :: bit  where macsvc =?");
        st.setInt(1, soluong);
        st.setInt(2, trangthai);
        st.setString(3, macsvc);
        st.executeUpdate();
    }
}
