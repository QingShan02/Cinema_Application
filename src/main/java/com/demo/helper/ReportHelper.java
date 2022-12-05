/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.helper;

import com.raven.model.Topping;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Ngoc Han
 */
public class ReportHelper {

    public static void exportToppingReport() {
        try {
//            ThanhToan tt = (ThanhToan) Main.readObj("temp.txt");
            Map<String, String> params = new HashMap<>();
            String name = "";
            String quantity = "";
            String price = "";
            long total = 0;
            List<Topping> tps = new ArrayList<>();
            for (Topping tp : tps) {
//            for (Topping tp : tt.getListTopping()) {
                name += tp.getTenTopping() + "\n";
                quantity += String.valueOf(tp.getSoLuongMua()) + "\n";
                price += String.valueOf(tp.getGia()) + "\n";
                total += (tp.getGia() * tp.getSoLuongMua());
            }
            params.put("name", name);
            params.put("quantity", quantity);
            params.put("price", price);
            params.put("total", String.valueOf(total));
//            Class.forName("org.apache.batik.dom.svg.SVGDocumentFactory");
//            File path = new File("src/main/java/com/demo/form/topping-report.jrxml");
            JasperReport jasperReport = JasperCompileManager
                    .compileReport("src/main/java/com/demo/form/topping-report.jrxml");

            JRDataSource dataSource = new JREmptyDataSource();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
            File outDir = new File("C:/jasperoutput");
            outDir.mkdirs();

            // Chạy báo cáo và export ra file PDF.
            JasperExportManager.exportReportToPdfFile(jasperPrint,
                    "C:/jasperoutput/StyledTextReport.pdf");

        } catch (JRException ex) {
            Logger.getLogger(ReportHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        exportToppingReport();
    }
}
