/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.form;

import com.raven.DAO.GheDao;
import com.raven.DAO.PhongDao;
import com.raven.model.ChiTietGhe;
import com.raven.model.Model_Ghe;
import com.raven.model.PhongChieu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Daokh
 */
public class Form_ChoNgoi extends javax.swing.JPanel {

    PhongDao daoPhong;
    GheDao daoGhe;
    List<PhongChieu> ListPhong = new ArrayList<>();
    List<ChiTietGhe> ListGhe = new ArrayList<>();

    /**
     * Creates new form Form_ChoNgoi
     */
    public Form_ChoNgoi() {
        initComponents();
        daoPhong = new PhongDao();
        daoGhe = new GheDao();
        ListPhong = daoPhong.Select();
        ListGhe = daoGhe.Select();
        ListPhong.stream().forEach(s -> {
            cboPhong.addItem(s.getTenPhong());
        });
//        SodoGhe();
    }

    public void SodoGhe() {
        Color cl;
        int i = 0;

        List<ChiTietGhe> List = ListGhe.stream().filter(s -> s.getMaPhong().equalsIgnoreCase(ListPhong.get(cboPhong.getSelectedIndex()).getMaPhong())).limit(108).collect(Collectors.toList());
        for (ChiTietGhe s : List) {
            i++;
            if (Character.compare(s.getTenGhe().charAt(0), 'G') == 0) {
                cl = Color.red;
            } else if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
                cl = Color.PINK;
            } else {
                cl = Color.GREEN;
            }

            Model_Ghe ghe = new Model_Ghe(cl, s.getTenGhe());
            ghe.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                   
                    if (e.getComponent().getBackground().equals(Color.GRAY)) {
                        if (Character.compare(s.getTenGhe().charAt(0), 'G') == 0) {
                            e.getComponent().setBackground(Color.RED);
                        } else if (Character.compare(s.getTenGhe().charAt(0), 'H') == 0) {
                            e.getComponent().setBackground(Color.PINK);
                        } else {
                            e.getComponent().setBackground(Color.GREEN);
                        }
                    } else {
                        e.getComponent().setBackground(Color.GRAY);
                    }
                }
            });
            Sodochongoi3.add(ghe);

        }

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

        jLabel1 = new javax.swing.JLabel();
        cboPhong = new javax.swing.JComboBox<>();
        Sodochongoi3 = new javax.swing.JPanel();

        jLabel1.setText("Tên Phòng");

        cboPhong.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPhongItemStateChanged(evt);
            }
        });
        cboPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboPhongMouseClicked(evt);
            }
        });

        Sodochongoi3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Sodochongoi3.setFocusCycleRoot(true);
        Sodochongoi3.setPreferredSize(new java.awt.Dimension(3, 3));
        Sodochongoi3.setLayout(new java.awt.GridLayout(8, 12, 1, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cboPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sodochongoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sodochongoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboPhongMouseClicked
//        Sodochongoi3.removeAll();
//        SodoGhe();
    }//GEN-LAST:event_cboPhongMouseClicked

    private void cboPhongItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPhongItemStateChanged
        // TODO add your handling code here:
        Sodochongoi3.removeAll();
        SodoGhe();

    }//GEN-LAST:event_cboPhongItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Sodochongoi3;
    private javax.swing.JComboBox<String> cboPhong;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
