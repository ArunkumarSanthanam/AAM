package com.dmt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashBoardController {
	
	@RequestMapping(value = "/accountlist")
    private String accountlist(HttpServletRequest request) {
    	return "accountlist";
    }
    
    @RequestMapping(value = "/accountform")
    private String accountform(HttpServletRequest request) {
    	return "accountform";
    }
    
    @RequestMapping(value = "/productlist")
    private String productlist(HttpServletRequest request) {
    	return "productlist";
    }
    
    @RequestMapping(value = "/productform")
    private String productform(HttpServletRequest request) {
    	return "productform";
    }
    
    @RequestMapping(value = "/brandlist")
    private String brandlist(HttpServletRequest request) {
    	return "brandlist";
    }
    
    @RequestMapping(value = "/brandform")
    private String brandform(HttpServletRequest request) {
    	return "brandform";
    }
    
    @RequestMapping(value = "/customerlist")
    private String customerList(HttpServletRequest request) {
    	return "customerlist";
    }
    
    @RequestMapping(value = "/customerform")
    private String customerForm(HttpServletRequest request) {
    	return "customerform";
    }
    
    @RequestMapping(value = "/cityform")
    private String cityForm(HttpServletRequest request) {
    	return "cityform";
    }
    
    @RequestMapping(value = "/citylist")
    private String cityList(HttpServletRequest request) {
    	return "citylist";
    }
    
    @RequestMapping(value = "/talukform")
    private String talukForm(HttpServletRequest request) {
    	return "talukform";
    }
    
    @RequestMapping(value = "/taluklist")
    private String talukList(HttpServletRequest request) {
    	return "taluklist";
    }
    
    @RequestMapping(value = "/districtform")
    private String districtForm(HttpServletRequest request) {
    	return "districtform";
    }
    
    @RequestMapping(value = "/districtlist")
    private String districtList(HttpServletRequest request) {
    	return "districtlist";
    }
    
    @RequestMapping(value = "/saleorderlist")
    private String SaleOrder(HttpServletRequest request) {
    	return "saleorderlist";
    }
    
    @RequestMapping(value = "/saleorderform")
    private String SaleOrderForm(HttpServletRequest request) {
    	return "saleorderform";
    }
    
    @RequestMapping(value = "/supplierlist")
    private String supplierList(HttpServletRequest request) {
    	return "supplierlist";
    }
    
    @RequestMapping(value = "/supplierform")
    private String supplierForm(HttpServletRequest request) {
    	System.out.println("called ===================== ");
    	return "supplierform";
    }
    
    @RequestMapping(value = "/discountlist")
    private String discountislt(HttpServletRequest request) {
    	return "discountlist";
    }
    
    @RequestMapping(value = "/discountform")
    private String discountForm(HttpServletRequest request) {
    	return "discountform";
    }
    
    @RequestMapping(value = "/grnform")
    private String grnForm(HttpServletRequest request) {
    	return "grnform";
    }
    
    @RequestMapping(value = "/grnlist")
    private String grnList(HttpServletRequest request) {
    	return "grnlist";
    }

    @RequestMapping(value = "/invoicelist")
    private String invoiceList(HttpServletRequest request) {
    	return "invoicelist";
    }
    
    @RequestMapping(value = "/invoiceform")
    private String invoiceForm(HttpServletRequest request) {
    	return "invoiceform";
    }

}
