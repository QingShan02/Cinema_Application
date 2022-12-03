/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.DAO;

import com.demo.model.CoSoVatChat;
import com.demo.model.HoaDon;
import com.raven.DAO.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daokh
 */
public class HoaDonDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;
    List<HoaDon> list;

    public int Insert(HoaDon hd) {
        try {
            pst = con.prepareStatement("insert into hoadon values(?,?,cast (? as date),?)");
            pst.setString(1, hd.getMaHD());
            pst.setInt(2, hd.getIdVe());
            pst.setString(3, hd.getNgayXuat());
            pst.setDouble(4, hd.getTongHD());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
//    public String findByIdVe(int IdVe){
//        try {
//            pst = con.prepareStatement("select mahd from hoadon where idve = ?");
//            pst.setInt(1, IdVe);
//            rs = pst.executeQuery();
//            while (rs.next()) {                
//                return rs.getString(1);
//            }
////            return pst.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(HoaDonDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "";
//    }
}
