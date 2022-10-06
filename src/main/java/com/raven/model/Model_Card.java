package com.raven.model;

import java.util.List;
import javax.swing.Icon;
import javax.swing.JPanel;

public class Model_Card {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
List<NgayChieu> nc;

    public List<NgayChieu> getNc() {
        return nc;
    }

    public void setNc(List<NgayChieu> nc) {
        this.nc = nc;
    }
    JPanel mainpJPanel;
    public Model_Card(Icon icon, String title, String values, List<NgayChieu> nc, JPanel mainpJPanel) {
        this.icon = icon;
        this.title = title;
        this.values = values;
        this.nc = nc;
        this.mainpJPanel = mainpJPanel;
    }

    public JPanel getMainpJPanel() {
        return mainpJPanel;
    }

    public void setMainpJPanel(JPanel mainpJPanel) {
        this.mainpJPanel = mainpJPanel;
    }
    
    public Model_Card() {
    }

    private Icon icon;
    private String title;
    private String values;
    private String description;
}
