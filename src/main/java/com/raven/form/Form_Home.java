package com.raven.form;

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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_Home extends javax.swing.JPanel {

    PhongDao daoPhong;
    List<Object[]> list;
    Form_ChoNgoi cn;
    PhimDao daoPhim;
    List<Phim> listPhim;
    List<NgayChieu> listXC;

    public Form_Home() {
        initComponents();

        daoPhim = new PhimDao();
        listPhim = daoPhim.PhimTrongNgay("2022-09-01");

        cn = new Form_ChoNgoi();

        Card card = null;
        for (Phim phim : listPhim) {

            listXC = daoPhim.GioCuaPhim(phim.getMaPhim(), "2022-09-01");
            card = new Card();
            card.setData(new Model_Card(new ImageIcon("src/main/resources/icon/stock.png"), (String) phim.getTenPhim(), "2022-09-01", listXC, phim.getMaPhim()), phim.getMaPhim(), phim.getNamSX());
            card.setColor1(Color.BLACK);
            card.setColor2(Color.BLACK);
            panel1.add(card);

        }
        panel1.repaint();
        panel1.revalidate();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panel1 = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(255, 255, 255));

        panel1.setLayout(new java.awt.GridLayout(0, 1, 0, 10));
        jScrollPane1.setViewportView(panel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane panel1;
    // End of variables declaration//GEN-END:variables
}
