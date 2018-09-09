package com.dmt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dmt.dao.ConfigurationDao;
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

@Service
@Transactional
public class ConfigurationServiceImpl implements ConfigurationService{
	
	@Autowired
	ConfigurationDao configurationDao;
	
	@Override
	public boolean createBrand(Brand brand) {
		return configurationDao.createBrand(brand);
	}

	@Override
	public List<Brand> getBrands() {
		return configurationDao.getBrands();
	}

	@Override
	public boolean saveProductDetails(Product product) {
		return configurationDao.saveProductDetails(product);
	}

	@Override
	public CustomerResponse loadCustomerDropdown() {
		return configurationDao.loadCustomerDropdown();
	}

	@Override
	public boolean saveCustomerDetails(Customer customer) {
		return configurationDao.saveCustomerDetails(customer);
	}

	@Override
	public List<ProductDO> productList() {
		return configurationDao.productList();
	}

	@Override
	public Product getProduct(String productID) {
		return configurationDao.getProduct(productID);
	}

	@Override
	public List<Brand> brandList() {
		return configurationDao.brandList();
	}

	@Override
	public Brand getBrand(String brandId) {
		return configurationDao.getBrand(brandId);
	}

	@Override
	public List<City> cityList() {
		return configurationDao.cityList();
	}

	@Override
	public City getCity(String cityId) {
		return configurationDao.getCity(cityId);
	}

	@Override
	public boolean createCity(City city) {
		return configurationDao.createCity(city);
	}

	@Override
	public District getDistrict(String districtId) {
		return configurationDao.getDistrict(districtId);
	}

	@Override
	public List<District> districtList() {
		return configurationDao.districtList();
	}

	@Override
	public boolean createDistrict(District district) {
		return configurationDao.createDistrict(district);
	}

	@Override
	public Taluk getTaluk(String talukId) {
		return configurationDao.getTaluk(talukId);
	}

	@Override
	public boolean createTaluk(Taluk taluk) {
		return configurationDao.createTaluk(taluk);
	}

	@Override
	public List<Taluk> talukList() {
		return configurationDao.talukList();
	}

	@Override
	public int getProductCode() {
		return configurationDao.getProductCode();
	}

	@Override
	public int getCustomerCode() {
		return configurationDao.getCustomerCode();
	}

	@Override
	public SaleOrderResponse getSaleOrderResponse(String customerId) {
		return configurationDao.getSaleOrderResponse(customerId);
	}

	@Override
	public int getSupplierCode() {
		return configurationDao.getSupplierCode();
	}

	@Override
	public Supplier getSupplier(String supplierId) {
		return configurationDao.getSupplier(supplierId);
	}

	@Override
	public List<SupplierDTO> supplierList() {
		return configurationDao.supplierList();
	}

	@Override
	public boolean saveSupplierDetails(Supplier supplier) {
		return configurationDao.saveSupplierDetails(supplier);
	}

	@Override
	public List<DiscountDTO> discountList() {
		return configurationDao.discountList();
	}

	@Override
	public SaleOrderResponse getdiscountDD() {
		return configurationDao.getdiscountDD();
	}

	@Override
	public boolean saveDiscountDetails(Discount discount) {
		return configurationDao.saveDiscountDetails(discount);
	}

	@Override
	public Discount getDiscount(String discountId) {
		return configurationDao.getDiscount(discountId);
	}

	@Override
	public List<Product> loadProducts(String brandId) {
		return configurationDao.loadProducts(brandId);
	}

	@Override
	public int getPickingQuantity(String orderQty,String productName) {
		return configurationDao.getPickingQuantity(orderQty,productName);
	}

	@Override
	public String loadSellingPrice(String productName) {
		return configurationDao.loadSellingPrice(productName);
	}

	@Override
	public boolean saveSaleOrder(SaleOrderDTO saleOrderDTO) {
		return configurationDao.saveSaleOrder(saleOrderDTO);
	}

	@Override
	public List<SaleOrderDTO> getSaleOrders(String saleOrderNumber) {
		return configurationDao.getSaleOrders(saleOrderNumber);
	}

	@Override
	public List<SaleOrderDTO> getSaleOrderDetailsDt() {
		return configurationDao.getSaleOrderDetailsDt();
	}

	@Override
	public SaleOrderAccount findSaleOrder(String saleOrderNumber) {
		return configurationDao.findSaleOrder(saleOrderNumber);
	}

	@Override
	public int getSaleorderCode() {
		return configurationDao.getSaleorderCode();
	}

	@Override
	public boolean saveGrnDetails(GRNResponse grnResponse) {
		return configurationDao.saveGrnDetails(grnResponse);
	}

	@Override
	public boolean saveGRN(GrnDTO grnDto) {
		return configurationDao.saveGRN(grnDto);
	}

	@Override
	public List<SaleOrderDTO> getGrnDetails(String grnNumber) {
		return configurationDao.getGrnDetails(grnNumber);
	}

	@Override
	public int getGrnCode() {
		return configurationDao.getGrnCode();
	}

	@Override
	public GrnAccount findGrn(String grnNumber) {
		return configurationDao.findGrn(grnNumber);
	}

	@Override
	public List<SaleOrderDTO> getGrnDetailsDt() {
		return configurationDao.getGrnDetailsDt();
	}

	@Override
	public List<SaleOrderDTO> getInvoiceDetailsDt(String status) {
		return configurationDao.getInvoiceDetailsDt(status);
	}

	@Override
	public List<SaleOrderDTO> getInvoices(String saleOrderNumber) {
		return configurationDao.getInvoices(saleOrderNumber);
	}

	@Override
	public SaleOrderDTO getInvoicePopUp(String invoiceId) {
		return configurationDao.getInvoicePopUp(invoiceId);
	}

	@Override
	public boolean updateSaleOrderAndInvoiceDetails(String saleOrderNumber) {
		return configurationDao.updateSaleOrderAndInvoiceDetails(saleOrderNumber);
	}

}
