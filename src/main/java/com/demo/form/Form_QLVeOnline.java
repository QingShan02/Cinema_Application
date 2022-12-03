/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.demo.form;

import com.demo.DAO.HoaDonDao;
import com.demo.model.HoaDon;
import com.raven.DAO.ConnectDB;
import com.raven.DAO.VeDao;
import com.raven.main.Main;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daokh
 */
public class Form_QLVeOnline extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form Form_QLVeOnline
     */
    List<Object[]> list;
    VeDao dao;
    HoaDonDao daoHD;
    DataInputStream din;
    DataOutputStream dout;

    public Form_QLVeOnline() {
        initComponents();
        dao = new VeDao();
        daoHD = new HoaDonDao();
        list = dao.SelectVeOnline();
        FillToTable();

    }

    void FillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblVe.getModel();
        model.setRowCount(0);
        list.forEach(s -> {
            model.addRow(s);
        });
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
        tblVe = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnXuatHoaDon = new javax.swing.JButton();

        tblVe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Vé", "Tên Khách Hàng", "Tên Phim", "Thông Tin Ghế", "Ngày Chiếu", "Giá", "Topping", "Số lượng"
            }
        ));
        jScrollPane1.setViewportView(tblVe);

        jTextField1.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                jTextField1HierarchyChanged(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnXuatHoaDon.setText("Xuất hóa đơn");
        btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXuatHoaDon)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnXuatHoaDon)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHoaDonActionPerformed
        // TODO add your handling code here:
        String a = UUID.randomUUID().toString();
        int idve = (int) list.get(tblVe.getSelectedRow())[0];
        double gia = (double) list.get(tblVe.getSelectedRow())[4];
        daoHD.Insert(new HoaDon(a, idve, java.time.LocalDate.now() + "", gia));
        Hashtable map = new Hashtable();
        map.put("maHD", a);
        ConnectDB.inHoaDon(map);
    }//GEN-LAST:event_btnXuatHoaDonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ServerSocket ss;
        try {
            ss = new ServerSocket(3333);
            Thread t = new Thread(this);
            t.start();
            System.out.println("1");
            opencv op = new opencv();
            System.out.println("2");
            Socket s = ss.accept();
            System.out.println("3");
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            op.show();

        } catch (IOException ex) {
            Logger.getLogger(Form_QLVeOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        tblVe.clearSelection();
    }//GEN-LAST:event_jTextField1KeyPressed
    String temp = "";
    private void jTextField1HierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jTextField1HierarchyChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1HierarchyChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        temp = jTextField1.getText();
        for (int i = 0; i < list.size(); i++) {
            if ((int) list.get(i)[0] == Integer.parseInt(temp)) {
                tblVe.setRowSelectionInterval(i, i);
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblVe;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {
            try {
                if (din != null) {
                    if (din.readUTF() != "") {
                        System.out.println("" + din.readUTF());
                        jTextField1.setText(din.readUTF());
                        break;
                    }
                    System.out.println(">>" + din.readUTF());
                }
                System.out.println("hehe");
//            try {
//                if (list.size() != dao.SelectVeOnline().size()) {
//                    Main.mainF.removeAll();
//                    Main.mainF.add(new Form_QLVeOnline());
//                    Main.mainF.repaint();
//                    Main.mainF.revalidate();
//                    break;
//                }
                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Form_QLVeOnline.class.getName()).log(Level.SEVERE, null, ex);
//            }
            } catch (IOException ex) {
                Logger.getLogger(Form_QLVeOnline.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Form_QLVeOnline.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
