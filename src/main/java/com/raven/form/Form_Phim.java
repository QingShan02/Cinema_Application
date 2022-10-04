/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.DAO.PhimDao;
import com.raven.model.Phim;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daokh
 */
public class Form_Phim extends javax.swing.JPanel {

    /**
     * Creates new form Form_Phim
     */
    DefaultTableModel model;
    PhimDao dao;
    List<Phim> list = new ArrayList<>();
    int current;
 

    public Form_Phim() {
        initComponents();
        tblPhim.getTableHeader().setOpaque(false);
        tblPhim.getTableHeader().setBackground(Color.white);
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 15);
        Font font1 = new Font(Font.SANS_SERIF, Font.ITALIC, 12);
        tblPhim.setFont(font1);
        tblPhim.getTableHeader().setFont(font);
        dao = new PhimDao();
        FillTable();
    }

    public void FillTable() {
        list.clear();
        list = dao.Select();
        model = (DefaultTableModel) tblPhim.getModel();

        model.setRowCount(0);
        list.stream().forEach(s -> {
            model.addRow(new Object[]{s.getMaPhim(), s.getTenPhim(), s.getDienVien(), s.getNamSX(), s.getDaoDien(), s.getQuocGia(), s.getThoiLuong(), s.getMoTa()});
        });
    }

    public void showDetails() {

        txtMaPhim.setText(tblPhim.getValueAt(current, 0).toString());
        txtTenPhim.setText(tblPhim.getValueAt(current, 1).toString());
        txtDienVien.setText(tblPhim.getValueAt(current, 2).toString());
        txtNamSX.setText(tblPhim.getValueAt(current, 3).toString());
        txtDaoDien.setText(tblPhim.getValueAt(current, 5).toString());
        txtQuocGia.setText(tblPhim.getValueAt(current, 6).toString());
        txtThoiLuong.setText(tblPhim.getValueAt(current, 7).toString());
        txtMoTa.setText(tblPhim.getValueAt(current, 8).toString());

    }

    public boolean checkValidate(String Phim, int index) {
        if (index == 1) {
            if (txtMaPhim.getText().length() == 0) {
                txtMaPhim.setBackground(Color.yellow);
                lblMP.setText("Chưa nhập mã phim");
                return false;
            } else {
                txtMaPhim.setBackground(Color.white);
                lblMP.setText("");
            }
        }
        if (index == 2) {
            if (txtTenPhim.getText().length() == 0) {
                txtTenPhim.setBackground(Color.yellow);
                lblTP.setText("Chưa nhập tên phim");
                return false;
            } else {
                txtTenPhim.setBackground(Color.white);
                lblTP.setText("");
            }
        }

        if (index == 3) {
            if (txtDienVien.getText().length() == 0) {
                txtDienVien.setBackground(Color.yellow);
                lblDV.setText("Chưa nhập tên diễn viên");
                return false;

            } else {
                txtDienVien.setBackground(Color.white);
                lblDV.setText("");
            }
        }
        if (index == 4) {
            if (txtNamSX.getText().length() == 0) {
                txtNamSX.setBackground(Color.yellow);
                lblNSX.setText("Chưa nhập năm sản xuât");
                return false;

            } else {
                txtNamSX.setBackground(Color.white);
                lblNSX.setText("");
            }
        }
        if (index == 5) {
            if (txtDaoDien.getText().length() == 0) {
                txtDaoDien.setBackground(Color.yellow);
                lblDD.setText("Chưa nhập tên đạo diễn");
                return false;

            } else {
                txtDaoDien.setBackground(Color.white);
                lblDD.setText("");
            }
        }
        if (index == 6) {
            if (txtQuocGia.getText().length() == 0) {
                txtQuocGia.setBackground(Color.yellow);
                lblQG.setText("Chưa nhập tên quốc gia");
                return false;

            } else {
                txtQuocGia.setBackground(Color.white);
                lblQG.setText("");
            }
        }
        if (index == 7) {
            if (txtThoiLuong.getText().length() == 0) {
                txtDienVien.setBackground(Color.yellow);
                lblTL.setText("Chưa nhập thời lượng phim");
                return false;

            } else {
                txtThoiLuong.setBackground(Color.white);
                lblTL.setText("");
            }
        }
        if (index == 8) {
            if (txtMoTa.getText().length() == 0) {
                txtMoTa.setBackground(Color.yellow);
                lblMT.setText("Chưa nhập mô tả phim");
                return false;

            } else {
                txtMoTa.setBackground(Color.white);
                lblMT.setText("");
            }
        }

        return true;

    }


    public void Xoa() {
        txtMaPhim.setText("");
        txtTenPhim.setText("");
        txtDaoDien.setText("");
        txtDienVien.setText("");
        txtMoTa.setText("");
        txtNamSX.setText("");
        txtQuocGia.setText("");
        txtThoiLuong.setText("");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhim = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblMaPhim = new javax.swing.JLabel();
        txtMaPhim = new javax.swing.JTextField();
        lblMP = new javax.swing.JLabel();
        lblTenPhim = new javax.swing.JLabel();
        txtTenPhim = new javax.swing.JTextField();
        lblTP = new javax.swing.JLabel();
        lblDienVien = new javax.swing.JLabel();
        txtDienVien = new javax.swing.JTextField();
        lblDV = new javax.swing.JLabel();
        lblNamSX = new javax.swing.JLabel();
        txtNamSX = new javax.swing.JTextField();
        lblNSX = new javax.swing.JLabel();
        lblDaoDien = new javax.swing.JLabel();
        txtDaoDien = new javax.swing.JTextField();
        lblDD = new javax.swing.JLabel();
        lblQuocGia = new javax.swing.JLabel();
        txtQuocGia = new javax.swing.JTextField();
        lblQG = new javax.swing.JLabel();
        lblThoiLuong = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JTextField();
        lblTL = new javax.swing.JLabel();
        lblMoTa = new javax.swing.JLabel();
        lblMT = new javax.swing.JLabel();
        txtMoTa = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        tblPhim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phim", "Tên Phim", "Diễn Viên", "Năm sản xuất", "Hình", "Đạo diễn", "Quốc gia", "Thời lượng", "Mo tả"
            }
        ));
        tblPhim.setGridColor(new java.awt.Color(255, 255, 255));
        tblPhim.setShowGrid(true);
        tblPhim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhimMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhim);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnTimKiem.setBackground(new java.awt.Color(153, 0, 0));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel1.add(btnTimKiem);

        btnThem.setBackground(new java.awt.Color(153, 0, 0));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem);

        btnXoa.setBackground(new java.awt.Color(153, 0, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa);

        btnCapNhat.setBackground(new java.awt.Color(153, 0, 0));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        jPanel1.add(btnCapNhat);

        btnSapXep.setBackground(new java.awt.Color(153, 0, 0));
        btnSapXep.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSapXep.setForeground(new java.awt.Color(255, 255, 255));
        btnSapXep.setText("Sắp xếp");
        btnSapXep.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(btnSapXep);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblMaPhim.setText("Mã phim");

        txtMaPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhimActionPerformed(evt);
            }
        });

        lblMP.setForeground(new java.awt.Color(153, 0, 51));

        lblTenPhim.setText("Tên phim");

        lblDienVien.setText("Diễn viên");

        lblNamSX.setText("Năm sản xuất");

        lblDaoDien.setText("Đạo diễn");

        lblQuocGia.setText("Quốc gia");

        lblThoiLuong.setText("Thời lượng");

        lblMoTa.setText("Mô tả");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMaPhim)
                        .addGap(43, 43, 43)
                        .addComponent(txtMaPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenPhim)
                            .addComponent(lblDienVien))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtDienVien, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDV, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTenPhim, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTP, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamSX)
                            .addComponent(lblDaoDien)
                            .addComponent(lblQuocGia)
                            .addComponent(lblThoiLuong)
                            .addComponent(lblMoTa))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTL, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblQG, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtDaoDien, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDD, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNamSX, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblMT, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMaPhim)
                        .addComponent(txtMaPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMP, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTenPhim)
                        .addComponent(txtTenPhim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDienVien)
                    .addComponent(txtDienVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDV, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNamSX)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNamSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDD, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDaoDien)
                        .addComponent(txtDaoDien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblQuocGia)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQuocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblQG, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblThoiLuong)
                        .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMoTa)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(lblMT, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblPhimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhimMouseClicked
        // TODO add your handling code here:
        current = tblPhim.getSelectedRow();
        showDetails();
    }//GEN-LAST:event_tblPhimMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
      
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void txtMaPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhimActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_btnThemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDD;
    private javax.swing.JLabel lblDV;
    private javax.swing.JLabel lblDaoDien;
    private javax.swing.JLabel lblDienVien;
    private javax.swing.JLabel lblMP;
    private javax.swing.JLabel lblMT;
    private javax.swing.JLabel lblMaPhim;
    private javax.swing.JLabel lblMoTa;
    private javax.swing.JLabel lblNSX;
    private javax.swing.JLabel lblNamSX;
    private javax.swing.JLabel lblQG;
    private javax.swing.JLabel lblQuocGia;
    private javax.swing.JLabel lblTL;
    private javax.swing.JLabel lblTP;
    private javax.swing.JLabel lblTenPhim;
    private javax.swing.JLabel lblThoiLuong;
    private javax.swing.JTable tblPhim;
    private javax.swing.JTextField txtDaoDien;
    private javax.swing.JTextField txtDienVien;
    private javax.swing.JTextField txtMaPhim;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtNamSX;
    private javax.swing.JTextField txtQuocGia;
    private javax.swing.JTextField txtTenPhim;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables
}
