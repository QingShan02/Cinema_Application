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
    List<ChiTietGhe> ListGhe = new ArrayList<>();
    List<Model_Ghe> lModelGhe = new ArrayList<>();
    PhongChieu phg;
    Model_Ghe ghe;
    GheDao daoGhe;
    PhongDao daoPhong;
    String maPhongChieu, maPhimChieu;

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

    //Cái này bản cũ chưa xóa
    public Form_ChoNgoi(PhongChieu phg, NgayChieu nc, List<ChiTietGhe> listGheCV) {
        initComponents();
//        this.listGheCV = listGheCV;
        this.phg = phg;
        daoGhe = new GheDao();
        ListGhe = daoGhe.Select(this.phg.getMaPhong(), nc.getStt());
        lblTenPhong.setText(lblTenPhong.getText() + " " + this.phg.getTenPhong());
        lblGio.setText(nc.getGioBatDau());
        SodoGhe();
    }

    //Cái này mới sử dụng cái này
    public Form_ChoNgoi(String maphong, String maPhim, int sttngay, String gioBatDau) {
        initComponents();
        daoGhe = new GheDao();
        daoPhong = new PhongDao();
        ListGhe = daoGhe.Select(maphong, sttngay);
        listGheCV = daoPhong.Selectghecove(maPhim, sttngay, gioBatDau);
        maPhongChieu = maphong;
        maPhimChieu = maPhim;
        ListGhe.stream().forEach(s -> {
            s.getMaGhe();
        });
        SodoGhe();
    }

    public void SodoGhe() {
        int id = Integer.parseInt(maPhongChieu.substring(2));
        List = listGheCV.stream().limit(96).collect(Collectors.toList());
        System.out.println(listGheCV.size());

        for (ChiTietGhe s : List) {

            if (s.getIdVe() != 0) {
                ghe = new Model_Ghe(Color.GRAY, s.getTenGhe());
            } else {
                if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
                    cl = Color.PINK;
                } else {
                    cl = Color.GREEN;
                }
                ghe = new Model_Ghe(cl, s.getTenGhe());
                ghe.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            ThanhToan tt = (ThanhToan) readObj("temp.txt");
                            tt.setMaCTGhe(s.getMaCTGhe());
//                        tt.setMaPhong(maPhongChieu);
//                        tt.setMaPhim(maPhimChieu);
                            tt.setMaGhe(s.getMaGhe());
                            new PrintWriter("temp.txt").close();
                            writeObj("temp.txt", tt);
                            System.out.println(tt.getMaPhong());
                        } catch (IOException ex) {
                            Logger.getLogger(Form_ChoNgoi.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Form_ChoNgoi.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (e.getComponent().getBackground().equals(Color.YELLOW)) {
                            if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
                                e.getComponent().setBackground(Color.PINK);
                            } else {
                                e.getComponent().setBackground(Color.GREEN);
                            }
                        } else {
                            e.getComponent().setBackground(Color.YELLOW);
                        }
                    }
                });
            }

            Sodochongoi3.add(ghe);
            lModelGhe.add(ghe);

        }
        if (id >= 5) {
            List2 = listGheCV.stream().skip(96).collect(Collectors.toList());
            for (ChiTietGhe s : List2) {
                if (Character.compare(s.getTenGhe().charAt(0), 'J') == 0) {
                    cl = Color.RED;
                }
                if (s.getIdVe() != 0) {
                    ghe = new Model_Ghe(Color.GRAY, s.getTenGhe());
                } else {
                    if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
                        cl = Color.PINK;
                    } else if (Character.compare(s.getTenGhe().charAt(0), 'J') == 0) {
                        cl = Color.RED;
                    } else {
                        cl = Color.GREEN;
                    }
                }
                ghe = new Model_Ghe(cl, s.getTenGhe());
                lModelGhe.add(ghe);
                ghe.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.getComponent().getBackground().equals(Color.YELLOW)) {
                            if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
                                e.getComponent().setBackground(Color.PINK);
                            } else if (Character.compare(s.getTenGhe().charAt(0), 'J') == 0) {
                                e.getComponent().setBackground(Color.RED);
                            } else {
                                e.getComponent().setBackground(Color.GREEN);
                            }
                        } else {
                            e.getComponent().setBackground(Color.YELLOW);
                        }
                    }
                });
                Sodochongoivip.add(ghe);
                lModelGhe.add(ghe);

            }
        }
////        if (listGheCV.size() == 96 || listGheCV.size() == 110) {
////            btnNext.setEnabled(false);
////        }
//        for (ChiTietGhe g : listGheCV) {
//            if (g.getIdVe() != 0) {
//                ghe.setBackground(Color.GRAY);
//            }
//        }
//        for (int i = 0; i < ListGhe.size(); i++) {
//            ChiTietGhe s = ListGhe.get(i);
//            ghe = lModelGhe.get(i);
//            if (!ghe.getBackground().equals(Color.GRAY)) {
//                ghe.addMouseListener(new MouseAdapter() {
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//
//                        if (e.getComponent().getBackground().equals(Color.YELLOW)) {
//                            if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
//                                e.getComponent().setBackground(Color.PINK);
//                                lblGiaGhe.setText("Giá:");
//                            } else {
//                                e.getComponent().setBackground(Color.GREEN);
//                                lblGiaGhe.setText("Giá:");
//                            }
//                        } else {
//                            
//                            try {
//                                ThanhToan tt = (ThanhToan) readObj("temp.txt");
//                                tt.setMaCTGhe(s.getMaCTGhe());
//                                tt.setMaGhe(s.getMaGhe());
//                                tt.setGiaGhe(s.getGia());
//                                new PrintWriter("temp.txt").close();
//                                writeObj("temp.txt", tt);
//
//                            } catch (IOException ex) {
//                                Logger.getLogger(Form_ChoNgoi.class.getName()).log(Level.SEVERE, null, ex);
//                            } catch (ClassNotFoundException ex) {
//                                Logger.getLogger(Form_ChoNgoi.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            e.getComponent().setBackground(Color.YELLOW);
//                            lblGiaGhe.setText(lblGiaGhe.getText()+" "+s.getGia()+" VND");
//                        }
//                    }
//
//                });
//            }
//
//        }
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

        jButton2 = new javax.swing.JButton();
        lblTenPhong = new javax.swing.JLabel();
        Sodochongoi3 = new javax.swing.JPanel();
        Sodochongoivip = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblGio = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        lblGiaGhe = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Sodochongoivip1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTenPhong.setText("Tên Phòng:");

        Sodochongoi3.setBackground(new java.awt.Color(255, 255, 255));
        Sodochongoi3.setFocusCycleRoot(true);
        Sodochongoi3.setPreferredSize(new java.awt.Dimension(3, 3));
        Sodochongoi3.setLayout(new java.awt.GridLayout(8, 12, 4, 4));

        Sodochongoivip.setBackground(new java.awt.Color(255, 255, 255));
        Sodochongoivip.setLayout(new java.awt.GridLayout(1, 14, 4, 4));

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

        jButton1.setBackground(new java.awt.Color(0, 255, 0));

        jButton3.setBackground(new java.awt.Color(255, 0, 255));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));

        jButton5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Ghế Đã Đặt");

        Sodochongoivip1.setBackground(new java.awt.Color(255, 255, 255));
        Sodochongoivip1.setLayout(new java.awt.GridLayout(1, 14, 4, 4));

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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(lblGiaGhe)
                        .addGap(84, 84, 84)
                        .addComponent(btnNext)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(Sodochongoivip1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(15, 15, 15)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenPhong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sodochongoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sodochongoivip, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnNext)
                                    .addComponent(lblGiaGhe))
                                .addGap(13, 13, 13))
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(387, Short.MAX_VALUE)
                    .addComponent(Sodochongoivip1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(97, 97, 97)))
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
    private javax.swing.JPanel Sodochongoivip1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblGiaGhe;
    private javax.swing.JLabel lblGio;
    private javax.swing.JLabel lblTenPhong;
    // End of variables declaration//GEN-END:variables
}
