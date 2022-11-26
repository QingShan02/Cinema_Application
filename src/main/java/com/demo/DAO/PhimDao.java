/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.DAO;

import com.raven.model.ChiTietGhe;
import com.raven.model.NgayChieu;
import com.raven.model.Phim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Daokh
 */
public class PhimDao {

    static Connection con = ConnectDB.getConnection();
    static Statement st = null;
    static PreparedStatement pst = null;
    static ResultSet rs;

    public static void DeletePhim() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Phim> SelectTenPhim(String giobatdau) {
        List<Phim> list = new ArrayList();
        try {
            pst = con.prepareCall("{call SelectTenPhim(cast(? as time))}");
            pst.setString(1, giobatdau);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Phim(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDao.class.getName()).log(Level.SEVERE, null, ex);
        }
//        list = list.stream().distinct().collect(Collectors.toList());
        return list;
    }

    public void Insert(Phim p) {
        try {
            pst = con.prepareStatement("insert into Phim values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, p.getMaPhim());
            pst.setString(2, p.getTenPhim());
            pst.setString(3, p.getDienVien());
            pst.setInt(4, p.getNamSX());
            pst.setString(5, p.getHinh());
            pst.setString(6, p.getDaoDien());
            pst.setString(7, p.getQuocGia());
            pst.setString(8, p.getThoiLuong());
            pst.setString(9, p.getMoTa());
            pst.setString(10, p.getTraller());
            int kq = pst.executeUpdate();
            System.out.println(kq);
        } catch (SQLException ex) {
            Logger.getLogger(PhimDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Phim SelectById(String maPhim) {
        Phim p = new Phim();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from Phim where MaPhim = '" + maPhim + "'");
            while (rs.next()) {
                p = new Phim(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;
    }

    public List<Phim> Select() {
        List<Phim> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from Phim");
            while (rs.next()) {
                list.add(new Phim(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PhimDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void Update(Phim p) {
        try {
            PreparedStatement st = con.prepareStatement("update Phim set TenPhim = ?, DienVien = ?, NamSX = ?, Hinh = ?, DaoDien = ?, QuocGia = ?, ThoiLuong = ?, MoTa = ?, Traller = ? where MaPhim =?");
            st.setString(1, p.getTenPhim());
            st.setString(2, p.getDienVien());
            st.setInt(3, p.getNamSX());
            st.setString(4, p.getHinh());
            st.setString(5, p.getDaoDien());
            st.setString(6, p.getQuocGia());
            st.setString(7, p.getThoiLuong());
            st.setString(8, p.getMoTa());
            st.setString(9, p.getTenPhim());
            st.setString(10, p.getMaPhim());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhimDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Delete(String MaPhim) {
        try {
            PreparedStatement pt = con.prepareStatement("delete from Phim where MaPhim = ?");
            pt.setString(1, MaPhim);
            pt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void InsertPhim(String MaPhim, String TenPhim, String DienVien, String NamSX, String DaoDien, String QuocGia, String ThoiLuong, String MoTa, String Hinh, String Traller) throws SQLException {
        PreparedStatement p = con.prepareStatement("Insert into Phim values(?,?,?,?,?,?,?,?,?,?)");
        p.setString(1, MaPhim);
        p.setString(2, TenPhim);
        p.setString(3, DienVien);
//        p.setInt(4, Integer.parseInt(p.getNamSX()));
        p.setString(5, DaoDien);
        p.setString(6, QuocGia);
        p.setString(7, ThoiLuong);
        p.setString(8, MoTa);
        p.setString(9, Hinh);
        p.setString(10, Traller);
    }

    public List<Phim> PhimTrongNgay(String ngay) {
        List<Phim> list = new ArrayList<>();
        try {
//            pst = con.prepareStatement("select p.maphim,p.tenphim,p.NamSX from XuatChieu xc join Phim p on p.maphim = xc.maphim join ngaychieu nc on nc.stt = xc.stt where xc.ngay = ? and nc.giobatdau >cast(? as time);");
            pst = con.prepareStatement("select p.maphim,p.tenphim,p.NamSX from XuatChieu xc join Phim p on p.maphim = xc.maphim join ngaychieu nc on nc.stt = xc.stt where xc.ngay = ? ");

            pst.setDate(1, java.sql.Date.valueOf(ngay));
//            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
//            LocalDateTime now = LocalDateTime.now();
//            System.out.println(dtf.format(now));
//            pst.setString(2, dtf.format(now));
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Phim(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<NgayChieu> GioCuaPhim(String maphim, String ngay) {
        List<NgayChieu> list = new ArrayList<>();
        try {
            pst = con.prepareStatement("select n.STT,GioBatDau from XuatChieu xc join NgayChieu n on n.STT = xc.STT and n.Ngay = xc.Ngay where maphim = ? and xc.ngay = ?");
            pst.setString(1, maphim);
            pst.setDate(2, java.sql.Date.valueOf(ngay));
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new NgayChieu(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<ChiTietGhe> CountVe(String maphim, String ngay, int stt) {
        List<ChiTietGhe> list = new ArrayList();
        try {
            pst = con.prepareCall("{call getCountVe(?,?,?)}");
            pst.setString(1, maphim);
            pst.setDate(2, java.sql.Date.valueOf(ngay));
            pst.setInt(3, stt);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new ChiTietGhe(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
