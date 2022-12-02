package com.demo.form;

import com.raven.DAO.VeDao;
import com.raven.model.Ve;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class LineChartThang extends javax.swing.JPanel {

    List<Ve> list = new ArrayList<>();
    VeDao daoVe = new VeDao();

    public LineChartThang() {
        initUI();

    }

    private void initUI() {

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        chartPanel.setForeground(Color.WHITE);
        chartPanel.setBackground(Color.BLACK);
        add(chartPanel);
      
    }

    private XYDataset createDataset() {
        var series = new XYSeries("2022");
        list = daoVe.ThongKeThang();
        
        list.stream().forEach(s -> {
            series.add(s.getThang(), s.getTongSoVe());
        });
        
        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "SL Vé per Tháng",
                "Tháng",
                "Vé",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLACK);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        
            
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.YELLOW);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);
        
        chart.setTitle(new TextTitle("Thống Kê",
                new Font("Serif", java.awt.Font.BOLD, 18)
        )
        );

        return chart;
    }

   
}
