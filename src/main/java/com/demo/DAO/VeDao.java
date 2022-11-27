/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import static com.raven.DAO.PhongDao.con;
import static com.raven.DAO.PhongDao.pst;
import static com.raven.DAO.PhongDao.rs;
import com.raven.main.DangNhap;
import com.raven.main.Main;
import com.raven.model.ChiTietGhe;
import com.raven.model.Ve;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRA
 */
public class VeDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public void Insert(Ve v) {
        try {
            pst = con.prepareStatement("insert into Ve(GiaVe, ThueVat, MaCTGhe,NgayMuaVe) values(?,?,?,cast (? as date))");
//            pst.setInt(1, v.getIdVe());
            pst.setDouble(1, v.getGiaVe());
            pst.setDouble(2, v.getThueVAT());
//            pst.setInt(3, v.getMaKH());
            pst.setInt(3, v.getMaCTGhe());
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            pst.setString(4,dateFormat.format(cal.getTime()));
            int kq = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int findMaxId() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(idVe) from Ve");
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<Ve> Select() {
        List<Ve> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from Ve");
            while (rs.next()) {
                list.add(new Ve(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void Update(double TongGiaVe, double ThueVAT, int MaKH, int MaCTGhe, String MaNV, int IdVe) {
        try {
            PreparedStatement st = con.prepareStatement("update Ve set GiaVe = ?, ThueVAT = ?, MaKH = ?, MaCTGhe = ?, MaNV = ? where IdVe =?");
            st.setDouble(1, TongGiaVe);
            st.setDouble(2, ThueVAT);
            st.setInt(3, MaKH);
            st.setInt(4, MaCTGhe);
            st.setString(5, MaNV);
            st.setInt(6, IdVe);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Delete(int IdVe) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from Ve where IdVe = ?");
            pt.setInt(1, IdVe);
            pt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Ve> ThongKeNgay(String ngayThongKe) {
        List<Ve> list = new ArrayList();
        try {
            pst = con.prepareCall("{ call thongKetheongay(cast(? as date))}");
            pst.setString(1, ngayThongKe);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Ve(rs.getInt(1), rs.getDouble(2)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
    }
        public List<Object[]> SelectVeOnline() {
        List<Object[]> list = new ArrayList();
        try {
            pst = con.prepareCall("{ call SelectVeOnline(?)}");
            pst.setString(1, Main.maCN);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;
    }
}
