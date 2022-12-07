/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.demo.form;

import com.raven.DAO.NguoiDungDao;
import com.raven.main.DangNhap;
import com.raven.main.Main;
import com.raven.model.NguoiDung;
import com.raven.model.ThanhToan;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Daokh
 */
public class Form_Loading extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form Form_Loading
     */
    public ImageIcon resizeImage(String path) {
//        URL temp= null;
//        try {
//            System.out.println(path);
////            temp = new URL(path);
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(TablePhim.class.getName()).log(Level.SEVERE, null, ex);
//        }
        ImageIcon ii = new ImageIcon(path);
        
        ImageIcon imageIcon = new ImageIcon(ii.getImage().getScaledInstance(627, 659, java.awt.Image.SCALE_SMOOTH));
        return imageIcon;
    }
    public Form_Loading() {
        initComponents();
//        jLabel1.setIcon(resizeImage("src/main/resources/image/icon/loading.png"));
        Thread t = new Thread(this);
        t.start();
        setLocationRelativeTo(null);
    }
    int i = 0;
    NguoiDungDao dao = new NguoiDungDao();

    @Override
    public void run() {
        while (Boolean.TRUE) {

            try {
                if (i > 100) {
                    try {
                        if (new File("savetk.txt").length() != 0) {
                            if (new File("temp.txt").length() == 0) {
                                Form_ChonChiNhanh cn = new Form_ChonChiNhanh();
                                cn.show();
                                this.dispose();

                                return;
                            } else {
                                NguoiDung list_temp = (NguoiDung) DangNhap.readObj("savetk.txt");
                                dao.Select().stream().filter(s -> s.getEmail().equalsIgnoreCase(list_temp.getEmail())).forEach(s -> NguoiDungDao.setMaNV(s.getMaNguoiDung()));
                                ThanhToan tt = (ThanhToan) DangNhap.readObj("temp.txt");
                                Main main = new Main(tt.getMaCN());
                                main.show();
                                this.dispose();

                                return;
                            }
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    DangNhap dn = new DangNhap();
                    dn.show();
                    this.dispose();

                    break;
                }
                i += 5;
                pgbChao.setValue(i);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        pgbChao = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pgbChao.setStringPainted(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loading.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pgbChao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 659, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pgbChao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Loading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JProgressBar pgbChao;
    // End of variables declaration//GEN-END:variables
}
