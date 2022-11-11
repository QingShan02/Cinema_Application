/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.demo.form;

import com.raven.DAO.PhimDao;
import com.raven.DAO.PhongDao;
import com.raven.DAO.XuatChieuDao;
import com.raven.form.Form_ChoNgoi;
import com.raven.model.ChiTietGhe;
import com.raven.model.NgayChieu;
import com.raven.model.Phim;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daokh
 */
public class TablePhim extends javax.swing.JPanel {

    /**
     * Creates new form TablePhim
     */
    PhimDao daophim;
    List<Phim> listPhim;
    List<ChiTietGhe> ListPhong;
    PhongDao daoPhong;
    XuatChieuDao daoXC;
    List<NgayChieu> ngaychieu = new ArrayList<>();
    String maPhong;

    public TablePhim() {
        initComponents();
    }

    public TablePhim(Phim p, int stt) {
        initComponents();
//        maPhong = daoXC.SelectMaPhong(p.getMaPhim(), stt);
        lblTenPhim.setText(p.getTenPhim());
        lblDV.setText(p.getDienVien());
        lblDD.setText(p.getDaoDien());
        lblQG.setText(p.getQuocGia());
        lblTL.setText(p.getThoiLuong());
        lblNSX.setText(String.valueOf(p.getNamSX()));
//            lblHinh.setText(p.getHinh());
        lblHinh.setIcon(resizeImage("src/main/resources/poster/" + p.getHinh()));

//        });
    }
    
        public ImageIcon resizeImage(String path) {
        ImageIcon ii = new ImageIcon(path);
        ImageIcon imageIcon = new ImageIcon(ii.getImage().getScaledInstance(150, 300, java.awt.Image.SCALE_SMOOTH));
        return imageIcon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHinh = new javax.swing.JLabel();
        lblTenPhim = new javax.swing.JLabel();
        lblDienVien = new javax.swing.JLabel();
        lblDaoDien = new javax.swing.JLabel();
        lblQuocGia = new javax.swing.JLabel();
        lblThoiLuong = new javax.swing.JLabel();
        lblNamSX = new javax.swing.JLabel();
        lblDV = new javax.swing.JLabel();
        lblDD = new javax.swing.JLabel();
        lblQG = new javax.swing.JLabel();
        lblTL = new javax.swing.JLabel();
        lblNSX = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblHinh.setForeground(new java.awt.Color(255, 255, 255));

        lblTenPhim.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTenPhim.setForeground(new java.awt.Color(255, 0, 51));

        lblDienVien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblDienVien.setForeground(new java.awt.Color(255, 255, 255));
        lblDienVien.setText("Diễn viên :");

        lblDaoDien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblDaoDien.setForeground(new java.awt.Color(255, 255, 255));
        lblDaoDien.setText("Đạo diễn :");

        lblQuocGia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQuocGia.setForeground(new java.awt.Color(255, 255, 255));
        lblQuocGia.setText("Quốc gia :");

        lblThoiLuong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblThoiLuong.setForeground(new java.awt.Color(255, 255, 255));
        lblThoiLuong.setText("Thời lượng :");

        lblNamSX.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNamSX.setForeground(new java.awt.Color(255, 255, 255));
        lblNamSX.setText("Năm SX :");

        lblDV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblDV.setForeground(new java.awt.Color(255, 255, 255));

        lblDD.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblDD.setForeground(new java.awt.Color(255, 255, 255));

        lblQG.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblQG.setForeground(new java.awt.Color(255, 255, 255));

        lblTL.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTL.setForeground(new java.awt.Color(255, 255, 255));

        lblNSX.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNSX.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblQuocGia)
                        .addGap(18, 18, 18)
                        .addComponent(lblQG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDaoDien)
                        .addGap(18, 18, 18)
                        .addComponent(lblDD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDienVien)
                        .addGap(18, 18, 18)
                        .addComponent(lblDV, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTenPhim)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblThoiLuong)
                            .addComponent(lblNamSX))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTL, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTenPhim)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDienVien)
                            .addComponent(lblDV))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDaoDien)
                            .addComponent(lblDD))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQuocGia)
                            .addComponent(lblQG))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblThoiLuong)
                            .addComponent(lblTL))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNamSX)
                            .addComponent(lblNSX))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDD;
    private javax.swing.JLabel lblDV;
    private javax.swing.JLabel lblDaoDien;
    private javax.swing.JLabel lblDienVien;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblNSX;
    private javax.swing.JLabel lblNamSX;
    private javax.swing.JLabel lblQG;
    private javax.swing.JLabel lblQuocGia;
    private javax.swing.JLabel lblTL;
    private javax.swing.JLabel lblTenPhim;
    private javax.swing.JLabel lblThoiLuong;
    // End of variables declaration//GEN-END:variables
}
