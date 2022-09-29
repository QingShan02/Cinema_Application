package com.raven.form;

import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_Home extends javax.swing.JPanel {

    public Form_Home() {
        initComponents();
        card1.setData(new Model_Card( new ImageIcon("src/main/resources/icon/stock.png"), "Stock Total", "$200000", "Increased by 60%"));
        card3.setData(new Model_Card( new ImageIcon("src/main/resources/icon/profit.png"), "Total Profit", "$15000", "Increased by 25%"));
        card3.setData(new Model_Card( new ImageIcon("src/main/resources/icon/flag.png"), "Unique Visitors", "$300000", "Increased by 70%"));
        //  add row table
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JLayeredPane();
        card1 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        panel2 = new javax.swing.JLayeredPane();
        card2 = new com.raven.component.Card();
        card4 = new com.raven.component.Card();
        panel3 = new javax.swing.JLayeredPane();
        card5 = new com.raven.component.Card();
        card6 = new com.raven.component.Card();

        setBackground(new java.awt.Color(255, 255, 255));

        panel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel1.add(card1);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel1.add(card3);

        panel2.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card2.setColor1(new java.awt.Color(255, 204, 204));
        card2.setColor2(new java.awt.Color(255, 153, 153));
        panel2.add(card2);

        card4.setColor1(new java.awt.Color(255, 102, 102));
        card4.setColor2(new java.awt.Color(204, 51, 0));
        panel2.add(card4);

        panel3.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card5.setColor1(new java.awt.Color(255, 153, 102));
        card5.setColor2(new java.awt.Color(204, 153, 0));
        panel3.add(card5);

        card6.setColor1(new java.awt.Color(102, 255, 102));
        card6.setColor2(new java.awt.Color(0, 153, 51));
        panel3.add(card6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel2)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
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
    private javax.swing.JLayeredPane panel1;
    private javax.swing.JLayeredPane panel2;
    private javax.swing.JLayeredPane panel3;
    // End of variables declaration//GEN-END:variables
}
