package com.raven.form;

import com.demo.form.TablePhim;
import com.raven.DAO.NgayChieuDao;
import com.raven.DAO.PhimDao;
import com.raven.DAO.PhongDao;
import com.raven.component.Card;
import com.raven.component.Menu;
import com.raven.model.Model_Card;
import com.raven.model.NgayChieu;
import com.raven.model.Phim;
import com.raven.model.PhongChieu;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import com.toedter.components.JTitlePanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Form_Home extends javax.swing.JPanel {

    PhongDao daoPhong;
    List<Object[]> list;
    Form_ChoNgoi cn;
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

//        NgayChieuDao daoNC = new NgayChieuDao();
//        List<Phim> list = daoNC.SelectTenPhim(gio);
//        listPhim.forEach(s -> {
////            JPanel.add(s.getTenPhim(),s.getDienVien(),s.getDaoDien(),s.getQuocGia(),s.getThoiLuong(),s.getNamSX());
//            lblTenPhim.setText(s.getTenPhim());
//            lblDV.setText(s.getDienVien());
//            lblDD.setText(s.getDaoDien());
//            lblQG.setText(s.getQuocGia());
//            lblTL.setText(s.getThoiLuong());
////            lblNSX.setText(s.getNamSX());
//            lblHinh.setText(s.getHinh());
//        });
//        daoPhim = new PhimDao();
//        listPhim = daoPhim.PhimTrongNgay("2022-09-01");
        daoNC = new NgayChieuDao();
        listXC = daoNC.SelectGio();
//        cn = new Form_ChoNgoi();
        JPanel panel;
        for (NgayChieu nc : listXC) {
            panel = new JPanel();
            panel.setBackground(Color.black);
            listP.add(panel);
            jTabbedPane1.addTab(nc.getGioBatDau(), panel);
        }
//        Card card = null;
//        for (Phim phim : listPhim) {
//
//            listXC = daoPhim.GioCuaPhim(phim.getMaPhim(), "2022-09-01");
//            card = new Card();
//            card.setData(new Model_Card(new ImageIcon("src/main/resources/icon/stock.png"), (String) phim.getTenPhim(), "2022-09-01", listXC, phim.getMaPhim()), phim.getMaPhim(), phim.getNamSX());
//            card.setColor1(Color.BLACK);
//            card.setColor2(Color.BLACK);
//            panel1.add(card);
//
//        }
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
        // TODO add your handling code here:
//        String [] header = {"hehe","ten"};
//        String [][] row = {
//            {"1","Minh"}
//        };
        JTable table = new JTable();
        int temp = jTabbedPane1.getSelectedIndex();
        listP.get(temp).removeAll();
        listPhim = daoPhim.SelectTenPhim(jTabbedPane1.getTitleAt(temp));
        listPhim.forEach(s -> {
        listP.get(temp).add(new TablePhim(s));

        });

//        listP.get(temp).setLayout(new BoxLayout(table, BoxLayout.PAGE_AXIS));
//        table.setSize(1000, 400);

//        jTabbedPane1.repaint();
    }//GEN-LAST:event_jTabbedPane1StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLayeredPane panel1;
    // End of variables declaration//GEN-END:variables
}
