package com.raven.form;

import com.demo.form.TablePhim;
import com.itextpdf.text.pdf.PdfName;
import com.raven.DAO.NgayChieuDao;
import com.raven.DAO.PhimDao;
import com.raven.DAO.PhongDao;
import com.raven.main.Main;
import com.raven.model.NgayChieu;
import com.raven.model.Phim;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Form_Home extends javax.swing.JPanel {

    PhongDao daoPhong;
    List<Object[]> list;
    List<NgayChieu> listXC;
    NgayChieuDao daoNC;
    NgayChieu nc = new NgayChieu();
    List<JPanel> listP = new ArrayList<>();
    Phim p;
    PhimDao daoPhim;
    List<Phim> listPhim;
//    JTabbedPane jTabbedPane1 = new JTabbedPane();

    public Form_Home() {
        initComponents();
        daoPhim = new PhimDao();
        daoNC = new NgayChieuDao();
        System.out.println(Main.maCN);
        listXC = daoNC.SelectGio(Main.maCN);
        System.out.println(listXC.size());
        jTabbedPane1.setTabPlacement(JTabbedPane.LEFT);

//        cn = new Form_ChoNgoi();
        JPanel panel1;
        if (listXC.size() != 0) {
            for (NgayChieu nc : listXC) {
                panel1 = new JPanel();
//                panel1.setPreferredSize(null);
//                panel1 = new JLayeredPane();
                panel1.setBackground(Color.white);
                panel1.setLayout(new GridLayout(10, 1));
                listP.add(panel1);
                JScrollPane sc = new JScrollPane(panel1);
                jTabbedPane1.addTab(nc.getGioBatDau(), sc);

            }
            jTabbedPane1.repaint();
            jTabbedPane1.revalidate();
        }

//        jTabbedPane1.setBounds(0, 0, 1000, 700);
//        add(jTabbedPane1);
//        repaint();
//        revalidate();
//                jTabbedPane1.setSelectedIndex(0);
//        else{
//            panel1.removeAll();
//            panel1.add(new JLabel("Hết lịch chiếu trong hôm nay"));
//            panel1.setLayout(new FlowLayout());
//            panel1.repaint();
//            panel1.revalidate();
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();

        setBackground(new java.awt.Color(0, 0, 0));

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        int n = jTabbedPane1.getSelectedIndex();
        String name = jTabbedPane1.getTitleAt(n);
        listPhim = daoPhim.SelectTenPhim(name);
        JScrollBar sc = new JScrollBar();
//                        JPanel panel = new JPanel();
//                        panel.setBounds(0, 0, 300, 300);
//                        sc.add(panel);  
        listP.get(n).removeAll();

        listPhim.forEach(s -> {
            listP.get(n).add(new TablePhim(s, s.getStt_xc(), name));
        });
//                                                listP.get(n).add(sc);
//                                                sc.repaint();
//                        sc.revalidate();
        listP.get(n).repaint();
        listP.get(n).validate();
        jTabbedPane1.repaint();
        jTabbedPane1.revalidate();
    }//GEN-LAST:event_jTabbedPane1StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
