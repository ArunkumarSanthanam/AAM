package com.dmt.dao;

import java.util.List;

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

public interface ConfigurationDao {
	
	public boolean createBrand(Brand brand);
	
	public List<Brand> getBrands();
	
	public boolean saveProductDetails(Product product);
	
	public CustomerResponse loadCustomerDropdown();
	
	public boolean saveCustomerDetails(Customer customer);
	
	public List<ProductDO> productList();
	
	public Product getProduct(String productID);
	
	public List<Brand> brandList();

	public Brand getBrand(String brandId);
	
	public List<City> cityList();

	public City getCity(String cityId);
	
	public boolean createCity(City city);
	
	public District getDistrict(String districtId);

	public List<District> districtList();

	public boolean createDistrict(District district);

	public Taluk getTaluk(String talukId);

	public boolean createTaluk(Taluk taluk);

	public List<Taluk> talukList();

	public int getProductCode();
	
	public int getCustomerCode();

	public SaleOrderResponse getSaleOrderResponse(String customerId);
	
	public int getSupplierCode();
	
	public Supplier getSupplier(String supplierId);
	
	public List<SupplierDTO> supplierList();
	
	public boolean saveSupplierDetails(Supplier supplier);
	
	public List<DiscountDTO> discountList();
	
	public SaleOrderResponse getdiscountDD();	
	
	public boolean saveDiscountDetails(Discount discount);
	
	public Discount getDiscount(String discountId);
	
	public List<Product> loadProducts(String brandId);
	
	public int getPickingQuantity(String orderQty, String productName);

	public String loadSellingPrice(String productName);	
	
	public boolean saveSaleOrder(SaleOrderDTO saleOrderDTO);
	
	public List<SaleOrderDTO> getSaleOrders(String saleOrderNumber);
	
	public List<SaleOrderDTO> getSaleOrderDetailsDt();
	
	public SaleOrderAccount findSaleOrder(String saleOrderNumber);	
	
	public int getSaleorderCode();	
	
	public boolean saveGrnDetails(GRNResponse grnResponse);	
	
	public boolean saveGRN(GrnDTO grnDto);
	
	public List<SaleOrderDTO> getGrnDetails(String grnNumber);

	public int getGrnCode();	
	
	public GrnAccount findGrn(String grnNumber);
	
	public List<SaleOrderDTO> getGrnDetailsDt();
	
	public List<SaleOrderDTO> getInvoiceDetailsDt(String status);
	
	public List<SaleOrderDTO> getInvoices(String saleOrderNumber);
	
	public SaleOrderDTO getInvoicePopUp(String saleOrderNumber);

	public boolean updateSaleOrderAndInvoiceDetails(String saleOrderNumber);
}
