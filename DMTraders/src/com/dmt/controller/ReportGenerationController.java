package com.dmt.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmt.service.ConfigurationService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class ReportGenerationController {
	
	@Autowired
	ConfigurationService configurationService;
	
	@RequestMapping(value="/generateReport", method=RequestMethod.GET)
	public void generateReport(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("saleOrderNumberTemp")String saleOrderNumberTemp) throws IOException, SQLException, ClassNotFoundException{
		String sourceFileName = "D:\\DMTraders\\Sample_bkp.jrxml";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("billNo",saleOrderNumberTemp);
		parameters.put("SALE_ORDER_NUMBER",saleOrderNumberTemp);
		try {
			JasperCompileManager.compileReportToFile(sourceFileName);
			sourceFileName = "D:\\DMTraders\\Sample_bkp.jasper";
			JasperReport report = (JasperReport) JRLoader.loadObjectFromLocation(sourceFileName);
	        String databaseURL = "jdbc:postgresql://localhost:5432/dmt?user=postgres&password=root";
	        Connection conn = null;
	        Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection(databaseURL);
	        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, conn);
			if (jasperPrint != null) {
				byte[] pdfReport = JasperExportManager
						.exportReportToPdf(jasperPrint);
				response.reset();
				response.setContentType("application/pdf");
				response.setHeader("Cache-Control", "no-store");
				response.setHeader("Cache-Control", "private");
				response.setHeader("Pragma", "no-store");
				response.setContentLength(pdfReport.length);
				response.getOutputStream().write(pdfReport);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
}
		catch (JRException e) {
			e.printStackTrace();
			
		}

	
}
	
	@RequestMapping(value="/generateinvoicereport", method=RequestMethod.GET)
	public void generateInvoiceRport(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("saleOrderNumberTemp")String saleOrderNumberTemp) throws IOException, SQLException, ClassNotFoundException{
		String sourceFileName = "D:\\DMTraders\\Invoice\\invoice.jrxml";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("billNo",saleOrderNumberTemp);
		parameters.put("SALE_ORDER_NUMBER",saleOrderNumberTemp);
		boolean flag = configurationService.updateSaleOrderAndInvoiceDetails(saleOrderNumberTemp);
		try {
			JasperCompileManager.compileReportToFile(sourceFileName);
			sourceFileName = "D:\\DMTraders\\Invoice\\invoice.jasper";
			JasperReport report = (JasperReport) JRLoader.loadObjectFromLocation(sourceFileName);
	        String databaseURL = "jdbc:postgresql://localhost:5432/dmt?user=postgres&password=root";
	        Connection conn = null;
	        Class.forName("org.postgresql.Driver");
	        conn = DriverManager.getConnection(databaseURL);
	        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, conn);
			if (jasperPrint != null) {
				byte[] pdfReport = JasperExportManager
						.exportReportToPdf(jasperPrint);
				response.reset();
				response.setContentType("application/pdf");
				response.setHeader("Cache-Control", "no-store");
				response.setHeader("Cache-Control", "private");
				response.setHeader("Pragma", "no-store");
				response.setContentLength(pdfReport.length);
				response.getOutputStream().write(pdfReport);
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
}
		catch (JRException e) {
			e.printStackTrace();
			
		}

	
}
}
