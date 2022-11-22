package com.raven.form;

import com.demo.form.TablePhim;
import com.raven.DAO.NgayChieuDao;
import com.raven.DAO.PhimDao;
import com.raven.DAO.PhongDao;
import com.raven.main.Main;
import com.raven.model.NgayChieu;
import com.raven.model.Phim;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JTable;

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

    public Form_Home() {
        initComponents();
        daoPhim = new PhimDao();
        daoNC = new NgayChieuDao();
        listXC = daoNC.SelectGio(Main.maCN);
        System.out.println(listXC.size());
//        cn = new Form_ChoNgoi();
        JPanel panel;
        for (NgayChieu nc : listXC) {
            panel = new JPanel();
            panel.setBackground(Color.black);
            listP.add(panel);
            jTabbedPane1.addTab(nc.getGioBatDau(), panel);
        }
        jTabbedPane1.repaint();
        jTabbedPane1.revalidate();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel1 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setBackground(new java.awt.Color(0, 0, 0));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));

        panel1.setBackground(new java.awt.Color(0, 0, 0));
        panel1.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        jTabbedPane1.setBackground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        panel1.add(jTabbedPane1);

        jScrollPane1.setViewportView(panel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged

        JTable table = new JTable();
        int temp = jTabbedPane1.getSelectedIndex();
        listP.get(temp).removeAll();
        listPhim = daoPhim.SelectTenPhim(jTabbedPane1.getTitleAt(temp));
        listPhim.forEach(s -> {
            listP.get(temp).add(new TablePhim(s,listXC.get(temp).getStt()));
            
        });
    }//GEN-LAST:event_jTabbedPane1StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLayeredPane panel1;
    // End of variables declaration//GEN-END:variables
}
