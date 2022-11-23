/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.main;

import com.demo.form.Form_CSVC;
import com.demo.form.Form_ThongKeChiNhanh;
import com.demo.form.Setting;
import com.raven.DAO.NguoiDungDao;
import com.raven.DAO.PhongDao;
import com.raven.event.EventMenuSelected;
import com.raven.form.Form_ChoNgoi;
//import com.raven.form.Form_ChonPhim;
import com.raven.form.Form_DoiMatKhau;
import com.raven.form.Form_KhachHang;
import com.raven.form.Form_Home;
import com.raven.form.Form_Phim;
import com.raven.form.Form_QLPhong;
import com.raven.form.Form_QuanLyLichChieu;
import com.raven.form.Form_Topping;
import com.raven.form.Form_XacThuc;
import com.raven.model.ChiTietGhe;
import com.raven.model.NgayChieu;
import com.raven.model.NguoiDung;
import com.raven.model.PhongChieu;
import com.raven.swing.MenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author RAVEN
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public static JPanel mainF;
    public static String maCN;
    PhongDao daoPhong;
    public Main(String macn){
        initComponents();
        mainF = mainPanel;
        maCN = macn;
        setBackground(new Color(0, 0, 0, 0));
        daoPhong = new PhongDao();
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(new Form_Home());
                }
                else if (index == 1) {
                    setForm(new Form_CSVC());
                } else if (index == 2) {
                    setForm(new Form_Topping());
                } else if (index == 3) {
                    setForm(new Form_ThongKeChiNhanh());
                }
//                else if (index == 4) {
//                    setForm(new );
//                }
                else if (index == 5) {
                    setForm(new Setting());
                }
                else if (index == 6) {
                    setForm(new Form_XacThuc());
                } else if (index == 7) {
                    DangXuat();
                }

            }
        }
        );
        setForm(new Form_Home());
    }
    public Main() {
        initComponents();
        mainF = mainPanel;
        setBackground(new Color(0, 0, 0, 0));
        daoPhong = new PhongDao();
        menu.initMoving(Main.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(new Form_Home());
                }else if (index == 1) {
                    setForm(new Form_CSVC());
                } else if (index == 2) {
                    setForm(new Form_Topping());
                } else if (index == 3) {
                    setForm(new Form_ThongKeChiNhanh());
                }
                else if (index == 5) {
                    setForm(new Setting());
                }
//                else if (index == 5) {
//                    setForm(new Form_DoiMatKhau());
//                } 
                else if (index == 6) {
                    setForm(new Form_XacThuc());
                } else if (index == 7) {
                    setForm(new Form_XacThuc());
                } else if (index == 8) {
                    DangXuat();
                }

            }
        }
        );
        setForm(new Form_Home());
        JMenuItem mn = new JMenuItem("refresh");
        mn.setActionCommand("refresh");
        MenuItemListener menuItemListener = new MenuItemListener();
        mn.addActionListener(menuItemListener);
        jPopupMenu1.add(mn);

        mainPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
//                    System.out.println("1");
                    jPopupMenu1.show(mainPanel, e.getX(), e.getY());
                }
            }
        });
    }

    class MenuItemListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
                    mainPanel.removeAll();
        System.out.println(">>5");
        mainPanel.add(cp);
        mainPanel.repaint();
        mainPanel.revalidate();
        }
    }

    public void DangXuat() {
        File f = new File("savetk.txt");

        if (f.exists()) {
            try {
                new FileOutputStream(f).close();
                DangNhap dn = new DangNhap();
                dn.show();
                this.dispose();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        System.out.println(">>4");
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        panelBorder1 = new com.raven.swing.PanelBorder();
        menu = new com.raven.component.Menu();
        header2 = new com.raven.component.Header();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });

        header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        mainPanel.setOpaque(false);
        mainPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                mainPanelComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                mainPanelComponentRemoved(evt);
            }
        });
        mainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                mainPanelComponentMoved(evt);
            }
        });
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_menuMouseClicked
    JComponent cp;

    public static Object readObj(String path) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        if (ois == null) {
            return null;
        }
        return ois.readObject();
    }
    private void mainPanelComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_mainPanelComponentAdded
        
//        cp = (JComponent) evt.getChild();
    }//GEN-LAST:event_mainPanelComponentAdded

    private void mainPanelComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_mainPanelComponentMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_mainPanelComponentMoved

    private void mainPanelComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_mainPanelComponentRemoved
        // TODO add your handling code here:
                Object[] obj = new Object[]{};
//        try {
//            // TODO add your handling code here:
//            if (new File("bonho.txt").length() != 0) {
//                
//                obj = (Object[]) readObj("bonho.txt");
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        if (evt.getChild().getClass() == Form_ChoNgoi.class) {
//            List<ChiTietGhe> listGheCV = daoPhong.Selectghecove((String) obj[3],"2022-11-10","18:00:00");

//            cp = new Form_ChoNgoi((PhongChieu) obj[0], (NgayChieu) obj[1],listGheCV);
        }   
    }//GEN-LAST:event_mainPanelComponentRemoved

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Header header2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPanel mainPanel;
    private com.raven.component.Menu menu;
    private com.raven.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
