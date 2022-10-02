package com.raven.form;

import com.raven.DAO.PhimDao;
import com.raven.DAO.PhongDao;
import com.raven.component.Card;
import com.raven.model.Model_Card;
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

    PhongDao dao;
    List<Object[]> list;
    Form_ChoNgoi cn;

    public Form_Home() {
        initComponents();
        dao = new PhongDao();
        list = dao.fillCard();
        cn = new Form_ChoNgoi();
//        list.stream().forEach(s->System.out.println(s[0]));
//        card1.setData(new Model_Card( new ImageIcon("src/main/resources/icon/stock.png"), (String) list.get(0)[0], list.get(0)[1]+" số ghế",list.get(0)[2]+" số vé"));
//        card3.setData(new Model_Card( new ImageIcon("src/main/resources/icon/profit.png"),"b", "$15000", "Increased by 25%"));
//        card3.setData(new Model_Card( new ImageIcon("src/main/resources/icon/flag.png"), "c", "$300000", "Increased by 70%"));
        Color cl[] = new Color[]{Color.RED, Color.BLUE, Color.GRAY};;
        Card card = null;
        for (int i = 0; i <= list.size() - 1; i++) {
            card = new Card(pn);
//Check if configurations is good
            panel1.add(card);
            card.setData(new Model_Card(new ImageIcon("src/main/resources/icon/stock.png"), (String) list.get(i)[0], list.get(i)[1] + " số ghế", list.get(i)[2] + " số vé"));
            card.setColor1(cl[i]);

        }
        }
    
    JPanel pn;

    public Form_Home(JPanel pn) {
        this.pn = pn;
               dao = new PhongDao();
        list = dao.fillCard();
        cn = new Form_ChoNgoi();
//        list.stream().forEach(s->System.out.println(s[0]));
//        card1.setData(new Model_Card( new ImageIcon("src/main/resources/icon/stock.png"), (String) list.get(0)[0], list.get(0)[1]+" số ghế",list.get(0)[2]+" số vé"));
//        card3.setData(new Model_Card( new ImageIcon("src/main/resources/icon/profit.png"),"b", "$15000", "Increased by 25%"));
//        card3.setData(new Model_Card( new ImageIcon("src/main/resources/icon/flag.png"), "c", "$300000", "Increased by 70%"));
        Color cl[] = new Color[]{Color.RED, Color.BLUE, Color.GRAY};;
        Card card = null;
        for (int i = 0; i <= list.size() - 1; i++) {
            card = new Card(pn);
//Check if configurations is good
            panel1.add(card);
            card.setData(new Model_Card(new ImageIcon("src/main/resources/icon/stock.png"), (String) list.get(i)[0], list.get(i)[1] + " số ghế", list.get(i)[2] + " số vé"));
            card.setColor1(cl[i]);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(255, 255, 255));

        panel1.setLayout(new javax.swing.BoxLayout(panel1, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel1)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(318, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane panel1;
    // End of variables declaration//GEN-END:variables
}
