/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.ChiTietGhe;
import com.raven.model.PhongChieu;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRA
 */
public class PhongDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(PhongChieu pc) {
        try {
            pst = con.prepareStatement("insert into Phong values(?,?)");
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(PhongDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<PhongChieu> Select() {
        List<PhongChieu> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from PhongChieu");
            while (rs.next()) {
                list.add(new PhongChieu(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
    }
    public PhongChieu SelectPhong(String MaPhim, int Ngay){
        PhongChieu phg = null;
        try {
            System.out.println(">>"+MaPhim+","+Ngay);
            pst = con.prepareStatement("select x.MaPhong,TenPhong from XuatChieu x join PhongChieu p on p.MaPhong = x.MaPhong where MaPhim = ? and x.Ngay = ?");
            pst.setString(1, MaPhim);
//            pst.setDate(2,java.sql.Date.valueOf(NgayChieu));
            pst.setInt(2, Ngay);
            rs = pst.executeQuery();
            while(rs.next()){
                phg=new PhongChieu(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phg;
    }

    public void Update(String TenPhong, String MaPhong) throws SQLException {
         pst = con.prepareStatement("update PhongChieu set TenPhong = ? where MaPhong =?");
        pst.setString(1, TenPhong);
        pst.setString(2, MaPhong);
        pst.executeUpdate();
    }

    public void Delete(String MaPhong) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from PhongChieu where MaPhong = ?");
            pt.setString(1, MaPhong);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<ChiTietGhe> Selectghecove(String maPhim,String gioBatDau){
        List<ChiTietGhe> list = new ArrayList<>();
        try {
            pst = con.prepareCall("{ call Selectghecove(?,cast(? as time))}");
            pst.setString(1, maPhim);
//            pst.setInt(1, sttngay);
            pst.setString(2, gioBatDau);
//            pst.setString(3, );
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new ChiTietGhe(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("size:"+list.size());

        }
        return list;
    }
}
