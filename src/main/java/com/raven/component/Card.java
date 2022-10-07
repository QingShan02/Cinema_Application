package com.raven.component;

import com.raven.DAO.PhimDao;
import com.raven.DAO.PhongDao;
import com.raven.form.Form_ChoNgoi;
import com.raven.form.Form_Home;
import com.raven.form.Form_Phim;
import com.raven.main.DangNhap;
import com.raven.main.Main;
import com.raven.model.Model_Card;
import com.raven.model.NgayChieu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends javax.swing.JPanel {

    private JButton btnGioChieu;

    public Card() {
        initComponents();
        setOpaque(false);

    }
    JPanel mainPanel;

    public Card(String tenPhim, String ngay, List<NgayChieu> gioChieu) {
        initComponents();
        lbTitle.setText(tenPhim);
        lbValues.setText(ngay);
//        this.mainPanel = mainPanel;
        for (NgayChieu gc : gioChieu) {
            btnGioChieu = new JButton();
            btnGioChieu.setText(gc.getGioBatDau());
            pnlGioChieu.add(btnGioChieu);

        }

    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    private Color color1;
    private Color color2;
    PhongDao daoPhong;

    public void setData(Model_Card data, String img, int namSX) {
        //lbIcon.setIcon(data.getIcon());
        lbTitle.setText(data.getTitle());
        lbValues.setText(data.getValues());
        pnlGioChieu.removeAll();

        data.getNc().stream().forEach(s -> {

            JButton btn = new JButton(s.getGioBatDau());
            btn.setBackground(Color.GRAY);
            pnlGioChieu.add(btn);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    data.getMainpJPanel().removeAll();
                    daoPhong = new PhongDao();
                    System.out.println(data.getMaPhim());
                    System.out.println(data.getValues());
                    System.out.println(s.getStt());
                    String maPhong = daoPhong.SelectMaPhong(data.getMaPhim(), data.getValues(), s.getStt());
                    
                    data.getMainpJPanel().add(new Form_ChoNgoi(maPhong,s.getGioBatDau()));
                    data.getMainpJPanel().repaint();
                    data.getMainpJPanel().revalidate();
                }

            });

        });
        pnlGioChieu.repaint();
        pnlGioChieu.revalidate();
        //lbDescription.setText(data.getDescription());
        lbImg.setIcon(resizeImage("src/main/resources/poster/" + img + ".png"));
        lbNamSX.setText(String.valueOf(namSX));
    }

    public ImageIcon resizeImage(String path) {
        ImageIcon ii = new ImageIcon(path);
        ImageIcon imageIcon = new ImageIcon(ii.getImage().getScaledInstance(130, 200, java.awt.Image.SCALE_SMOOTH));
        return imageIcon;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbValues = new javax.swing.JLabel();
        pnlGioChieu = new javax.swing.JPanel();
        lbImg = new javax.swing.JLabel();
        lbNamSX = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setText("Title");

        lbValues.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbValues.setForeground(new java.awt.Color(255, 255, 255));
        lbValues.setText("NgayChieu");

        pnlGioChieu.setBackground(new java.awt.Color(51, 51, 51));
        pnlGioChieu.setForeground(new java.awt.Color(255, 255, 255));
        pnlGioChieu.setLayout(new java.awt.GridLayout(1, 5));

        lbNamSX.setText("Nam sx");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbValues)
                    .addComponent(lbTitle)
                    .addComponent(lbNamSX)
                    .addComponent(pnlGioChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbValues)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbNamSX)
                .addGap(31, 31, 31)
                .addComponent(pnlGioChieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
            .addComponent(lbImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbImg;
    private javax.swing.JLabel lbNamSX;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValues;
    private javax.swing.JPanel pnlGioChieu;
    // End of variables declaration//GEN-END:variables
}
