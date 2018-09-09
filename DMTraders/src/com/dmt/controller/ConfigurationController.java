package com.dmt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dmt.modal.Brand;
import com.dmt.modal.City;
import com.dmt.modal.Customer;
import com.dmt.modal.Discount;
import com.dmt.modal.District;
import com.dmt.modal.GrnAccount;
import com.dmt.modal.Product;
import com.dmt.modal.SaleOrderAccount;
import com.dmt.modal.Supplier;
import com.dmt.modal.Taluk;
import com.dmt.response.CustomerResponse;
import com.dmt.response.DiscountDTO;
import com.dmt.response.GRNResponse;
import com.dmt.response.GrnDTO;
import com.dmt.response.ProductDO;
import com.dmt.response.SaleOrderDTO;
import com.dmt.response.SaleOrderResponse;
import com.dmt.response.SupplierDTO;
import com.dmt.service.ConfigurationService;

@Controller
public class ConfigurationController {
	
	@Autowired
	ConfigurationService configurationService;
	
	@RequestMapping(value = "/createbrand", method = RequestMethod.POST)
	@ResponseBody
	private boolean createBrand(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute Brand brand) {
		return configurationService.createBrand(brand);
	}
	
	@RequestMapping(value = "/getbrands", method = RequestMethod.POST)
	@ResponseBody
	private List<Brand> getBrands(HttpServletRequest request, HttpServletResponse response) {
		return configurationService.getBrands();
	}
	
	@RequestMapping(value = "/saveproductdetails", method = RequestMethod.POST)
	@ResponseBody
	private boolean saveProductDetails(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute Product product) {
		boolean flag = false;
		flag = configurationService.saveProductDetails(product);
		System.out.println(flag);
		return flag;
	}
	
	@RequestMapping(value = "/loadcustomerdropdown", method = RequestMethod.POST)
	@ResponseBody
	private CustomerResponse loadCustomerDropdown(HttpServletRequest request, HttpServletResponse response) {
		return configurationService.loadCustomerDropdown();
	}
	
	@RequestMapping(value = "/savecustomerdetails", method = RequestMethod.POST)
	@ResponseBody
	private boolean saveCustomerDetails(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute Customer customer) {
		boolean flag = false;
		flag = configurationService.saveCustomerDetails(customer);
		System.out.println(flag);
		return flag;
	}
	
	@RequestMapping(value = "/productlist", method = RequestMethod.POST)
	@ResponseBody
	private List<ProductDO> productList(HttpServletRequest request, HttpServletResponse response) {
		List<ProductDO> productDOs = configurationService.productList();
		return productDOs;
	}
	
	@RequestMapping(value = "/getproduct", method = RequestMethod.POST)
	@ResponseBody
	private Product getProduct(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("productID") String productID) {
		return configurationService.getProduct(productID);
	}	
	
	@RequestMapping(value = "/brandlist", method = RequestMethod.POST)
	@ResponseBody
	private List<Brand> brandList(HttpServletRequest request, HttpServletResponse response) {
		List<Brand> brands = configurationService.brandList();
		return brands;
	}
	
	@RequestMapping(value = "/getbrand", method = RequestMethod.POST)
	@ResponseBody
	private Brand getBrand(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("brandId") String brandId) {
		Brand brand = configurationService.getBrand(brandId);
		return brand;
	}
	
	@RequestMapping(value = "/citylist", method = RequestMethod.POST)
	@ResponseBody
	private List<City> cityList(HttpServletRequest request, HttpServletResponse response) {
		List<City> cities = configurationService.cityList();
		return cities;
	}
	
	@RequestMapping(value = "/taluklist", method = RequestMethod.POST)
	@ResponseBody
	private List<Taluk> talukList(HttpServletRequest request, HttpServletResponse response) {
		List<Taluk> taluks = configurationService.talukList();
		return taluks;
	}
	
	@RequestMapping(value = "/getcity", method = RequestMethod.POST)
	@ResponseBody
	private City getCity(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("cityId") String cityId) {
		City city = configurationService.getCity(cityId);
		return city;
	}
	
	@RequestMapping(value = "/createtaluk", method = RequestMethod.POST)
	@ResponseBody
	private boolean createTaluk(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute Taluk taluk) {
		return configurationService.createTaluk(taluk);
	}
	
	@RequestMapping(value = "/gettaluk", method = RequestMethod.POST)
	@ResponseBody
	private Taluk getTaluk(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("talukId") String talukId) {
		Taluk taluk = configurationService.getTaluk(talukId);
		return taluk;
	}
	
	@RequestMapping(value = "/createdistrict", method = RequestMethod.POST)
	@ResponseBody
	private boolean createDistrict(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute District district) {
		return configurationService.createDistrict(district);
	}
	
	@RequestMapping(value = "/districtlist", method = RequestMethod.POST)
	@ResponseBody
	private List<District> districtList(HttpServletRequest request, HttpServletResponse response) {
		List<District> districts = configurationService.districtList();
		return districts;
	}
	
	@RequestMapping(value = "/getdistrict", method = RequestMethod.POST)
	@ResponseBody
	private District getDistrict(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("districtId") String districtId) {
		District district = configurationService.getDistrict(districtId);
		return district;
	}
	
	@RequestMapping(value = "/getproductcode", method = RequestMethod.POST)
	@ResponseBody
	private int getProductCode(HttpServletRequest request, HttpServletResponse response) {
		int productCode = configurationService.getProductCode();
		return productCode;
	}

	@RequestMapping(value = "/getcustomercode", method = RequestMethod.POST)
	@ResponseBody
	private int getCustomerCode(HttpServletRequest request, HttpServletResponse response) {
		int customerCode = configurationService.getCustomerCode();
		return customerCode;
	}
	
	@RequestMapping(value = "/getsaleorderresponse", method = RequestMethod.POST)
	@ResponseBody
	private SaleOrderResponse getSaleOrderResponse(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("customerId") String customerId) {
		SaleOrderResponse saleOrderResponse = configurationService.getSaleOrderResponse(customerId);
		return saleOrderResponse;
	}
	
	@RequestMapping(value = "/getsuppliercode", method = RequestMethod.POST)
	@ResponseBody
	private int getSupplierCode(HttpServletRequest request, HttpServletResponse response) {
		int supplierCode = configurationService.getSupplierCode();
		return supplierCode;
	}
	
	@RequestMapping(value = "/getsupplier", method = RequestMethod.POST)
	@ResponseBody
	private Supplier getSupplier(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("supplierId") String supplierId) {
		return configurationService.getSupplier(supplierId);
	}	
	
	@RequestMapping(value = "/supplierlist", method = RequestMethod.POST)
	@ResponseBody
	private List<SupplierDTO> supplierList(HttpServletRequest request, HttpServletResponse response) {
		return configurationService.supplierList();
	}
	
	@RequestMapping(value = "/savesupplierdetails", method = RequestMethod.POST)
	@ResponseBody
	private boolean saveSupplierDetails(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute Supplier supplier) {
		boolean flag = false;
		flag = configurationService.saveSupplierDetails(supplier);
		System.out.println(flag);
		return flag;
	}
	
	@RequestMapping(value = "/discountlist", method = RequestMethod.POST)
	@ResponseBody
	private List<DiscountDTO> discountList(HttpServletRequest request, HttpServletResponse response) {
		List<DiscountDTO> discountDTOs = new ArrayList<DiscountDTO>();
		discountDTOs = configurationService.discountList();
		return discountDTOs;
	}
	
	@RequestMapping(value = "/getdiscountDD", method = RequestMethod.POST)
	@ResponseBody
	private SaleOrderResponse getdiscountDD(HttpServletRequest request, HttpServletResponse response) {
		SaleOrderResponse saleOrderResponse = new SaleOrderResponse();
		saleOrderResponse = configurationService.getdiscountDD();
		return saleOrderResponse;
	}
	
	
	@RequestMapping(value = "/savediscountdetails", method = RequestMethod.POST)
	@ResponseBody
	private boolean saveDiscountDetails(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute Discount discount) {
		boolean flag = false;
		flag = configurationService.saveDiscountDetails(discount);
		System.out.println(flag);
		return flag;
	}
	
	@RequestMapping(value = "/getdiscount", method = RequestMethod.POST)
	@ResponseBody
	private Discount getDiscount(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("discountId") String discountId) {
		Discount discount = configurationService.getDiscount(discountId);
		return discount;
	}
	
	@RequestMapping(value = "/loadproducts", method = RequestMethod.POST)
	@ResponseBody
	private List<Product> loadProducts(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("brandId") String brandId) {
		List<Product> products = configurationService.loadProducts(brandId);
		return products;
	}
	
	@RequestMapping(value = "/getpickingquantity", method = RequestMethod.POST)
	@ResponseBody
	private int getPickingQuantity(HttpServletRequest request, HttpServletResponse response
			,@RequestParam("orderQuantity") String orderQuantity,@RequestParam("productName") String productName) {
		System.out.println("Order Quantity =================== "+orderQuantity);
		int pickingQty = 0;
		if(orderQuantity != null && orderQuantity.trim().length() > 0){
			System.out.println("Inside");
			pickingQty = configurationService.getPickingQuantity(orderQuantity,productName);
			System.out.println(pickingQty);
		}
		return pickingQty;
	}
	
	@RequestMapping(value = "/loadsellingprice", method = RequestMethod.POST)
	@ResponseBody
	private String loadSellingPrice(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("productName") String productName) {
		String sellingPrice = "";
		if(productName != null && productName.trim().length() > 0){
			sellingPrice = configurationService.loadSellingPrice(productName);
		}
		return sellingPrice;
	}
	
	@RequestMapping(value = "/createcity", method = RequestMethod.POST)
	@ResponseBody
	private boolean createCity(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute City city) {
		return configurationService.createCity(city);
	}
	
	
	@RequestMapping(value = "/savesaleorder", method = RequestMethod.POST)
	@ResponseBody
	private boolean saveSaleOrder(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute SaleOrderDTO saleOrderDTO) {
		return configurationService.saveSaleOrder(saleOrderDTO);
	}
	
	@RequestMapping(value = "/saleorders", method = RequestMethod.POST)
	@ResponseBody
	private List<SaleOrderDTO> getSaleOrders(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("saleOrderNumber") String saleOrderNumber) {
		return configurationService.getSaleOrders(saleOrderNumber);
	}
	
	@RequestMapping(value = "/saleorderdetailsdt", method = RequestMethod.POST)
	@ResponseBody
	private List<SaleOrderDTO> getSaleOrderDetailsDt(HttpServletRequest request, HttpServletResponse response) {
		return configurationService.getSaleOrderDetailsDt();
	}
	
	@RequestMapping(value = "/findsaleorder", method = RequestMethod.POST)
	@ResponseBody
	private SaleOrderAccount findSaleOrder(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("saleOrderNumber") String saleOrderNumber) {
		return configurationService.findSaleOrder(saleOrderNumber);
	}
	
	@RequestMapping(value = "/getsaleordercode", method = RequestMethod.POST)
	@ResponseBody
	private int getSaleorderCode(HttpServletRequest request, HttpServletResponse response) {
		return configurationService.getSaleorderCode();
	}
	
	@RequestMapping(value = "/savegrndetails", method = RequestMethod.POST)
	@ResponseBody
	private boolean saveGrnDetails(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute GRNResponse grnResponse) {
		return configurationService.saveGrnDetails(grnResponse);
	}
	
	@RequestMapping(value = "/savegrn", method = RequestMethod.POST)
	@ResponseBody
	private boolean saveGRN(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute GrnDTO grnDto) {
		return configurationService.saveGRN(grnDto);
	}
	
	
	@RequestMapping(value = "/grndetails", method = RequestMethod.POST)
	@ResponseBody
	private List<SaleOrderDTO> getGrnDetails(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("grnNumber") String grnNumber) {
		return configurationService.getGrnDetails(grnNumber);
	}
	
	@RequestMapping(value = "/getgrncode", method = RequestMethod.POST)
	@ResponseBody
	private int getGrnCode(HttpServletRequest request, HttpServletResponse response) {
		return configurationService.getGrnCode();
	}
	
	@RequestMapping(value = "/findgrn", method = RequestMethod.POST)
	@ResponseBody
	private GrnAccount findGrn(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("grnNumber") String grnNumber) {
		return configurationService.findGrn(grnNumber);
	}
	
	@RequestMapping(value = "/grndetailsdt", method = RequestMethod.POST)
	@ResponseBody
	private List<SaleOrderDTO> getGrnDetailsDt(HttpServletRequest request, HttpServletResponse response) {
		return configurationService.getGrnDetailsDt();
	}
	
	@RequestMapping(value = "/invoicedetailsdt", method = RequestMethod.POST)
	@ResponseBody
	private List<SaleOrderDTO> getInvoiceDetailsDt(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("status") String status) {
		return configurationService.getInvoiceDetailsDt(status);
	}
	
	@RequestMapping(value = "/invoises", method = RequestMethod.POST)
	@ResponseBody
	private List<SaleOrderDTO> getInvoices(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("saleOrderNumber") String saleOrderNumber) {
		return configurationService.getInvoices(saleOrderNumber);
	}
	
	@RequestMapping(value = "/getinvoicepopup", method = RequestMethod.POST)
	@ResponseBody
	private SaleOrderDTO getInvoicePopUp(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("invoiceId") String invoiceId) {
		return configurationService.getInvoicePopUp(invoiceId);
	}
}
