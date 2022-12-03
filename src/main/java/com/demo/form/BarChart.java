package com.demo.form;

import com.raven.DAO.VeDao;
import com.raven.model.Ve;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart extends javax.swing.JPanel {

    VeDao daove = new VeDao();
    List<Ve> listDT = new ArrayList<>();
    String P1 = "2021";

    public BarChart() {
        initUI();
    }
    private void initUI() {
        DefaultCategoryDataset dataset = creDataset();
        JFreeChart chart = creChart(dataset);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(300,300);
        add(chartPanel);
    }
    
    private DefaultCategoryDataset creDataset(){
        listDT = daove.DoanhThutheoNgay();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        listDT.stream().forEach(s -> {
            dataset.addValue(s.getGiaVe(), P1, s.getThang());
        });
        return dataset;
        
    }

    private JFreeChart creChart(DefaultCategoryDataset dataset){
        JFreeChart barChart = ChartFactory.createBarChart("Thống Kê Doanh Thu", "Ngày", "Doanh Thu(Triệu Đồng)",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot p = barChart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.RED);
        return barChart;
        
    }
}
