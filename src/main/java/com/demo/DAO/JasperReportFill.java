/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.PrinterName;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author Daokh
 */

public class JasperReportFill {

    private static void PrintReportToPrinter(JasperPrint jp) throws JRException {
        // TODO Auto-generated method stub
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        // printRequestAttributeSet.add(MediaSizeName.ISO_A4); //setting page size
        printRequestAttributeSet.add(new Copies(1));

        PrinterName printerName = new PrinterName("Microsoft XPS Document Writer", null); //gets printer 

        PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
        printServiceAttributeSet.add(printerName);

        JRPrintServiceExporter exporter = new JRPrintServiceExporter();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printServiceAttributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
        exporter.exportReport();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        String sourceFileName
                = "src/main/java/com/demo/DAO/baocao.jasper";
        DataBeanList DataBeanList = new DataBeanList();
        ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();


    //JasperPrintManager.printPage(jp, 0, false);
    //JasperPrint jp =reportEngine.fillReport() ;//it returns stream 
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

        Map parameters = new HashMap();
        try {
    JasperDesign jsd = JRXmlLoader.load(sourceFileName);
    JasperReport jr = JasperCompileManager.compileReport(jsd);
    JasperPrint jp = JasperFillManager.fillReport(jr, parameters, beanColDataSource);
        PrintReportToPrinter(jp);//call method

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
