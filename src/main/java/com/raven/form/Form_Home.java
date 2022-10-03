package com.raven.form;

import com.raven.DAO.PhimDao;
import com.raven.DAO.PhongDao;
import com.raven.model.Model_Card;
import com.raven.model.PhongChieu;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_Home extends javax.swing.JPanel {
    PhongDao dao;
    List<Object[]> list;
    public Form_Home() {
        initComponents();
        dao = new PhongDao();
        list = dao.fillCard();
//        list.stream().forEach(s->System.out.println(s[0]));
        card1.setData(new Model_Card( new ImageIcon("src/main/resources/icon/stock.png"), (String) list.get(0)[0], list.get(0)[1]+" số ghế",list.get(0)[2]+" số vé"));
        card3.setData(new Model_Card( new ImageIcon("src/main/resources/icon/profit.png"),"b", "$15000", "Increased by 25%"));
        card3.setData(new Model_Card( new ImageIcon("src/main/resources/icon/flag.png"), "c", "$300000", "Increased by 70%"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JLayeredPane();
        card1 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        card8 = new com.raven.component.Card();
        panel2 = new javax.swing.JLayeredPane();
        card2 = new com.raven.component.Card();
        card4 = new com.raven.component.Card();
        card7 = new com.raven.component.Card();
        panel3 = new javax.swing.JLayeredPane();
        card5 = new com.raven.component.Card();
        card6 = new com.raven.component.Card();
        card9 = new com.raven.component.Card();

        setBackground(new java.awt.Color(255, 255, 255));

        panel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel1.add(card1);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel1.add(card3);

        card8.setColor1(new java.awt.Color(241, 208, 62));
        card8.setColor2(new java.awt.Color(211, 184, 61));
        panel1.add(card8);

        panel2.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card2.setColor1(new java.awt.Color(255, 204, 204));
        card2.setColor2(new java.awt.Color(255, 153, 153));
        panel2.add(card2);

        card4.setColor1(new java.awt.Color(255, 102, 102));
        card4.setColor2(new java.awt.Color(204, 51, 0));
        panel2.add(card4);

        card7.setColor1(new java.awt.Color(255, 102, 102));
        card7.setColor2(new java.awt.Color(204, 51, 0));
        panel2.add(card7);

        panel3.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card5.setColor1(new java.awt.Color(255, 153, 102));
        card5.setColor2(new java.awt.Color(204, 153, 0));
        panel3.add(card5);

        card6.setColor1(new java.awt.Color(102, 255, 102));
        card6.setColor2(new java.awt.Color(0, 153, 51));
        panel3.add(card6);

        card9.setColor1(new java.awt.Color(102, 255, 102));
        card9.setColor2(new java.awt.Color(0, 153, 51));
        panel3.add(card9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1242, Short.MAX_VALUE)
                    .addComponent(panel1)
                    .addComponent(panel3))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private com.raven.component.Card card4;
    private com.raven.component.Card card5;
    private com.raven.component.Card card6;
    private com.raven.component.Card card7;
    private com.raven.component.Card card8;
    private com.raven.component.Card card9;
    private javax.swing.JLayeredPane panel1;
    private javax.swing.JLayeredPane panel2;
    private javax.swing.JLayeredPane panel3;
    // End of variables declaration//GEN-END:variables
}
