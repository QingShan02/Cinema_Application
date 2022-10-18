/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.DAO.GheDao;
import com.raven.DAO.PhongDao;
import com.raven.main.Main;
import com.raven.model.ChiTietGhe;
import com.raven.model.Ghe;
import com.raven.model.Model_Ghe;
import com.raven.model.NgayChieu;
import com.raven.model.PhongChieu;
import com.raven.model.ThanhToan;
import com.raven.model.XuatChieu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Daokh
 */
public class Form_ChoNgoi extends javax.swing.JPanel {

    GheDao daoGhe;
    List<ChiTietGhe> ListGhe = new ArrayList<>();

    /**
     * Creates new form Form_ChoNgoi
     */
    public Form_ChoNgoi() {
        initComponents();
    }
    Color cl;
    List<ChiTietGhe> List;
    List<ChiTietGhe> List2;
    List<ChiTietGhe> listGheCV;
    PhongChieu phg;

    public static Object readObj(String path) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        if (ois == null) {
            return null;
        }
        return ois.readObject();
    }

    public static void writeObj(String path, Object data) throws FileNotFoundException, IOException {
        try (
                 FileOutputStream fos = new FileOutputStream(path);  ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(data);
        }
    }

    public Form_ChoNgoi(PhongChieu phg, NgayChieu nc, List<ChiTietGhe> listGheCV) {
        initComponents();
        this.listGheCV = listGheCV;
        this.phg = phg;
        daoGhe = new GheDao();
        ListGhe = daoGhe.Select(this.phg.getMaPhong(),nc.getStt());
        lblTenPhong.setText(lblTenPhong.getText() + " " + this.phg.getTenPhong());
        lblGio.setText(nc.getGioBatDau());
        SodoGhe();
    }
    List<Model_Ghe> lModelGhe = new ArrayList<>();
    Model_Ghe ghe;

    public void SodoGhe() {
        List = ListGhe.stream().limit(96).collect(Collectors.toList());
        for (ChiTietGhe s : List) {
            if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
                cl = Color.PINK;
            } else {
                cl = Color.GREEN;
            }

            ghe = new Model_Ghe(cl, s.getTenGhe());
//            ghe.addMouseListener(new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    try {
//                        ThanhToan tt = (ThanhToan) readObj("temp.txt");
//                        tt.setMaCTGhe(s.getMaCTGhe());
//                        tt.setMaGhe(s.getMaGhe());
//                        new PrintWriter("temp.txt").close();
//                        writeObj("temp.txt", tt);
//
//                    } catch (IOException ex) {
//                        Logger.getLogger(Form_ChoNgoi.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (ClassNotFoundException ex) {
//                        Logger.getLogger(Form_ChoNgoi.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                    if (e.getComponent().getBackground().equals(Color.YELLOW)) {
//                        if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
//                            e.getComponent().setBackground(Color.PINK);
//                        } else {
//                            e.getComponent().setBackground(Color.GREEN);
//                        }
//                    } else {
//                        e.getComponent().setBackground(Color.YELLOW);
//                    }
//                }
//
//            });
            Sodochongoi3.add(ghe);
            lModelGhe.add(ghe);

        }
        int id = Integer.parseInt(phg.getMaPhong().substring(2));
        if (id >= 5) {
            List2 = ListGhe.stream().skip(96).collect(Collectors.toList());
            for (ChiTietGhe s : List2) {
                if (Character.compare(s.getTenGhe().charAt(0), 'J') == 0) {
                    cl = Color.RED;
                }
                ghe = new Model_Ghe(cl, s.getTenGhe());

                lModelGhe.add(ghe);

                lModelGhe.add(ghe);

//                ghe.addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//                        if (e.getComponent().getBackground().equals(Color.YELLOW)) {
//                            if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
//                                e.getComponent().setBackground(Color.PINK);
//                            } else if (Character.compare(s.getTenGhe().charAt(0), 'J') == 0) {
//                                e.getComponent().setBackground(Color.RED);
//                            } else {
//                                e.getComponent().setBackground(Color.GREEN);
//                            }
//                        } else {
//                            e.getComponent().setBackground(Color.YELLOW);
//                        }
//                    }
//                });
                Sodochongoivip.add(ghe);
                lModelGhe.add(ghe);

            }

        }
        if (listGheCV.size() == 96 || listGheCV.size() == 110) {
            btnNext.setEnabled(false);
        }
        for (int i = 0; i < ListGhe.size(); i++) {
            ChiTietGhe s = ListGhe.get(i);
            ghe = lModelGhe.get(i);
            for (ChiTietGhe g : listGheCV) {
                if (g.getMaCTGhe() == s.getMaCTGhe()) {
                    ghe.setBackground(Color.GRAY);
                    break;
                }

            }
        }
        for (int i = 0; i < ListGhe.size(); i++) {
            ChiTietGhe s = ListGhe.get(i);
            ghe = lModelGhe.get(i);
            if (!ghe.getBackground().equals(Color.GRAY)) {
                ghe.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        if (e.getComponent().getBackground().equals(Color.YELLOW)) {
                            if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
                                e.getComponent().setBackground(Color.PINK);
                                lblGiaGhe.setText("Giá:");
                            } else {
                                e.getComponent().setBackground(Color.GREEN);
                                lblGiaGhe.setText("Giá:");
                            }
                        } else {
                            
                            try {
                                ThanhToan tt = (ThanhToan) readObj("temp.txt");
                                tt.setMaCTGhe(s.getMaCTGhe());
                                tt.setMaGhe(s.getMaGhe());
                                tt.setGiaGhe(s.getGia());
                                new PrintWriter("temp.txt").close();
                                writeObj("temp.txt", tt);

                            } catch (IOException ex) {
                                Logger.getLogger(Form_ChoNgoi.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Form_ChoNgoi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            e.getComponent().setBackground(Color.YELLOW);
                            lblGiaGhe.setText(lblGiaGhe.getText()+" "+s.getGia()+" VND");
                        }
                    }

                });
            }

        }
        Sodochongoivip.repaint();
        Sodochongoivip.revalidate();
        Sodochongoi3.repaint();
        Sodochongoi3.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTenPhong = new javax.swing.JLabel();
        Sodochongoi3 = new javax.swing.JPanel();
        Sodochongoivip = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblGio = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        lblGiaGhe = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTenPhong.setText("Tên Phòng:");

        Sodochongoi3.setBackground(new java.awt.Color(255, 255, 255));
        Sodochongoi3.setFocusCycleRoot(true);
        Sodochongoi3.setPreferredSize(new java.awt.Dimension(3, 3));
        Sodochongoi3.setLayout(new java.awt.GridLayout(8, 12, 1, 1));

        Sodochongoivip.setBackground(new java.awt.Color(255, 255, 255));
        Sodochongoivip.setLayout(new java.awt.GridLayout(1, 14, 1, 1));

        jPanel5.setBackground(new java.awt.Color(255, 102, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Ghế Thường");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ghế Đôi");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Ghế Vip");

        btnNext.setText("Tiếp theo");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblGiaGhe.setText("Giá: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Sodochongoivip, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTenPhong)
                                        .addGap(341, 341, 341)
                                        .addComponent(lblGio, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Sodochongoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGiaGhe)
                        .addGap(105, 105, 105)
                        .addComponent(btnNext)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenPhong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Sodochongoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Sodochongoivip, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnNext)
                                .addComponent(lblGiaGhe))))
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        Main.mainF.removeAll();
        Main.mainF.add(new Form_ChonTopping());
        Main.mainF.repaint();
        Main.mainF.revalidate();
//        Main.mainF.add();
    }//GEN-LAST:event_btnNextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Sodochongoi3;
    private javax.swing.JPanel Sodochongoivip;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lblGiaGhe;
    private javax.swing.JLabel lblGio;
    private javax.swing.JLabel lblTenPhong;
    // End of variables declaration//GEN-END:variables
}
