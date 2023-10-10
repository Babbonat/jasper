package com.bezkoder.spring.jpa.h2.jasper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRSaver;

import java.io.FileInputStream;

public class JasperCompiler
{
    private JasperReport jasperReport;

    public JasperCompiler()
    {
        jasperReport = null;
    }

    public void compileReport(){
        try {
            FileInputStream tutorialReportStream = new FileInputStream("template.jrxml");//getClass().getResourceAsStream("/template.jrxml");
            jasperReport = JasperCompileManager.compileReport(tutorialReportStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printReport()
    {
        try {
            JRSaver.saveObject(jasperReport, "tutorialReport.jasper");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
