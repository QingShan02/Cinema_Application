package com.demo.form;

import com.raven.DAO.VeDao;
import com.raven.main.Main;
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

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.jfree.chart.axis.DateAxis;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class LineChartNgay extends javax.swing.JPanel  {

    static List<Ve> list = new ArrayList<>();
    static VeDao daoVe = new VeDao();
    static String ngay = "";

    public LineChartNgay() {
        initUI();

    }

    private void initUI() {

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        chartPanel.setForeground(Color.WHITE);
        chartPanel.setBackground(Color.BLACK);
        add(chartPanel);
       
        
    }

    private static XYDataset createDataset() {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-YYYY");
        TimeSeries series = new TimeSeries("Ngày");
       
        list = daoVe.ThongKeNgay(Main.maCN);
         
        list.stream().forEach(n -> {
            ngay = f.format(n.getNgay());
           series.add(new Day(n.getNgay()), n.getTongSoVe());
        });
        
        XYDataset dataset =  new TimeSeriesCollection(series);
        return dataset;
    }

    private static JFreeChart createChart(final XYDataset dataset) {
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-YYYY");
        f.setCalendar(Calendar.getInstance());
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Vé", "Ngày", "Vé", dataset, true, true, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer r = (XYLineAndShapeRenderer) plot.getRenderer();
        r.setDefaultEntityRadius(10);

        DateAxis domain = (DateAxis) plot.getDomainAxis();
        domain.setDateFormatOverride(f);
        domain.setVerticalTickLabels(true);
        return chart;
    }

    
    
}
