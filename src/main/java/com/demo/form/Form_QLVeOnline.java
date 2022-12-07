/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.demo.form;

import com.demo.DAO.HoaDonDao;
import com.demo.model.HoaDon;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.raven.DAO.ConnectDB;
import com.raven.DAO.ToppingDao;
import com.raven.DAO.VeDao;
import com.raven.main.Main;
import com.raven.model.Topping;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daokh
 */
public class Form_QLVeOnline extends javax.swing.JPanel implements Runnable, ThreadFactory {

    /**
     * Creates new form Form_QLVeOnline
     */
    List<Object[]> list;
    VeDao dao;
    ToppingDao daoTP;
    HoaDonDao daoHD;
//    DataInputStream din;
//    DataOutputStream dout;
    public String a = null;
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    List<Topping> listTP;

    public Form_QLVeOnline() {
        initComponents();
        dao = new VeDao();
        daoHD = new HoaDonDao();
        FillToTable();
        daoTP = new ToppingDao();
    }

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(1);
        System.out.println(Webcam.getWebcams().size());
        webcam.setViewSize(size);
        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);
        executor.execute(this);

    }

    void FillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblVe.getModel();
        model.setRowCount(0);
        list.forEach(s -> {
            model.addRow(s);
        });
    }

    void FillTopping() {
        list.clear();
        list = dao.SelectVeOnline();

        modelTP.setRowCount(0);
        listTP.forEach(s -> {
            modelTP.addRow(new Object[]{s.getTenTopping(), s.getSoLuongMua(), s.getGia()});
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTopping = new javax.swing.JTable();

        tblVe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Vé", "Tên Khách Hàng", "Tên Phim", "Thông Tin Ghế", "Ngày Chiếu", "Giá"
            }
        ));
        tblVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVeMouseClicked(evt);
            }
        });
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

        tblTopping.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Topping", "Số lượng", "Giá"
            }
        ));
        jScrollPane2.setViewportView(tblTopping);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXuatHoaDon)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnXuatHoaDon)
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHoaDonActionPerformed
        // TODO add your handling code here:
        String a = UUID.randomUUID().toString();
        int idve = (int) list.get(tblVe.getSelectedRow())[0];
        double gia = (double) list.get(tblVe.getSelectedRow())[5];
        daoHD.Insert(new HoaDon(a, idve, java.time.LocalDate.now() + "", gia));
        Hashtable map = new Hashtable();
        map.put("maHD", a);
        ConnectDB.inHoaDon(map);
        Hashtable mapT = new Hashtable();
        map.put("idVe", idve);
        ConnectDB.inTP(mapT);
        FillToTable();
    }//GEN-LAST:event_btnXuatHoaDonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        initWebcam();
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
    DefaultTableModel modelTP;
    private void tblVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVeMouseClicked
        // TODO add your handling code here:
        modelTP = (DefaultTableModel) tblTopping.getModel();
        modelTP.setRowCount(0);
        listTP = daoTP.SelectTPofVe((int) list.get(tblVe.getSelectedRow())[0]);
        if (listTP.size() != 0) {
            FillTopping();
        }
    }//GEN-LAST:event_tblVeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblTopping;
    private javax.swing.JTable tblVe;
    // End of variables declaration//GEN-END:variables

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(opencv.class.getName()).log(Level.SEVERE, null, ex);
            }
            Result result = null;
            BufferedImage image = null;
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {
                Logger.getLogger(opencv.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("" + result);
            if (result != null) {
                a = result.getText();
                System.out.println("" + a);
                for (String w : a.split("/", 0)) {
                    System.out.println(w);
                }
                jTextField1.setText(a.split("/")[5]);

                break;
            }
        } while (true);
    }
}
