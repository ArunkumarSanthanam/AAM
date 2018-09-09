package com.dmt.daoimpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dmt.constant.DmtConstant;
import com.dmt.dao.ConfigurationDao;
import com.dmt.helper.DMTHelper;
import com.dmt.modal.Brand;
import com.dmt.modal.City;
import com.dmt.modal.Customer;
import com.dmt.modal.Discount;
import com.dmt.modal.District;
import com.dmt.modal.DmtInvoice;
import com.dmt.modal.DmtSaleOrder;
import com.dmt.modal.GRN;
import com.dmt.modal.GrnAccount;
import com.dmt.modal.InvoiceAccount;
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

@Repository
public class ConfigurationDaoImpl implements ConfigurationDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	DMTHelper helper;
	
	private Session openSession(){
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public boolean createBrand(Brand brand) {
		try{
			if (Integer.parseInt(brand.getBrandIdTemp())>0){
				brand.setBrandId(Integer.parseInt(brand.getBrandIdTemp()));
			}
			openSession().saveOrUpdate(brand);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> getBrands() {
		List<Brand> brands = new ArrayList<Brand>();
		try{
			brands = openSession().createCriteria(Brand.class).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return brands;
	}

	@Override
	public boolean saveProductDetails(Product product) {

		try {
			
			if (Integer.parseInt(product.getProductIDTemp())>0){
				product.setProductId(Integer.parseInt(product.getProductIDTemp()));
			}
			if (product.getBrandName() != null && product.getProductName().trim().length() != 0) {
				Brand brand = (Brand) openSession().createCriteria(Brand.class)
						.add(Restrictions.eq("brandId", Integer.parseInt(product.getBrandName()))).uniqueResult();
				System.out.println("Brand name === " + brand.getBrandName());
				if (brand != null) {
					product.setBrand(brand);
				}
				openSession().saveOrUpdate(product);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public CustomerResponse loadCustomerDropdown() {
		CustomerResponse response = new CustomerResponse();
		try{
			List<City> cities = openSession().createCriteria(City.class).list();
			List<District> districts = openSession().createCriteria(District.class).list();
			List<Taluk> taluks = openSession().createCriteria(Taluk.class).list();
			response.setDistricts(districts);
			response.setTaluks(taluks);
			response.setCities(cities);
		}catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public boolean saveCustomerDetails(Customer customer) {
		try {
			if (Integer.parseInt(customer.getCustomerIdTemp()) > 0) {
				System.out.println("Temp ID --- "+customer.getCustomerIdTemp());
				customer.setCustomerId(Integer.parseInt(customer.getCustomerIdTemp()));
			}
			if (customer.getCityName() != null && customer.getCityName().trim().length() != 0) {
				City city = (City) openSession().createCriteria(City.class)
						.add(Restrictions.eq("cityId", Integer.parseInt(customer.getCityName()))).uniqueResult();
				System.out.println("Brand name === " + city.getCityName());
				if (city != null) {
					customer.setCity(city);
				}
			}
			if (customer.getDistrictName() != null && customer.getDistrictName().trim().length() != 0) {
				District district = (District) openSession().createCriteria(District.class)
						.add(Restrictions.eq("districtId", Integer.parseInt(customer.getDistrictName()))).uniqueResult();
				if (district != null) {
					customer.setDistrict(district);				}
			}
			if (customer.getTalukName() != null && customer.getTalukName().trim().length() != 0) {
				Taluk taluk = (Taluk) openSession().createCriteria(Taluk.class)
						.add(Restrictions.eq("talukId", Integer.parseInt(customer.getTalukName()))).uniqueResult();
				if (taluk != null) {
					customer.setTaluk(taluk);				}
			}
				openSession().saveOrUpdate(customer);
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProductDO> productList() {
		List<ProductDO> productDOs = new ArrayList<ProductDO>();
		try{
			List<Product> products = openSession().createCriteria(Product.class).list();
			productDOs = helper.generateProductDOList(products);
		}catch(Exception e){
			e.printStackTrace();
		}
		return productDOs;
	}

	@Override
	public Product getProduct(String productID) {
		Product product = new Product();
		try{
			product = (Product) openSession().createCriteria(Product.class).
					add(Restrictions.eq("productId", Integer.parseInt(productID))).uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Brand> brandList() {
		List<Brand> brands = new ArrayList<Brand>();
		try{
			brands = openSession().createCriteria(Brand.class).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return brands;
	}

	@Override
	public Brand getBrand(String brandId) {
		Brand brand = new Brand();
		try{
			brand = (Brand) openSession().createCriteria(Brand.class)
					.add(Restrictions.eq("brandId", Integer.parseInt(brandId))).uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return brand;
	}

	@Override
	public List<City> cityList() {
		List<City> cities = new ArrayList<City>();
		try{
			cities = openSession().createCriteria(City.class).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return cities;
	}

	@Override
	public City getCity(String cityId) {
		City city = new City();
		try{
			city = (City) openSession().createCriteria(City.class)
					.add(Restrictions.eq("cityId", Integer.parseInt(cityId))).uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return city;
	}

	@Override
	public boolean createCity(City city) {
		try{
			if (Integer.parseInt(city.getCityIDTemp())>0){
				city.setCityId(Integer.parseInt(city.getCityIDTemp()));
			}
			openSession().saveOrUpdate(city);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public District getDistrict(String districtId) {
		District district = new District();
		try{
			district = (District) openSession().createCriteria(District.class)
					.add(Restrictions.eq("districtId", Integer.parseInt(districtId))).uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return district;
	}

	@Override
	public List<District> districtList() {
		List<District> districts = new ArrayList<District>();
		try{
			districts = openSession().createCriteria(District.class).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return districts;
	}

	@Override
	public boolean createDistrict(District district) {
		try{
			if (Integer.parseInt(district.getDistrictIDTemp())>0){
				district.setDistrictId(Integer.parseInt(district.getDistrictIDTemp()));
			}
			openSession().saveOrUpdate(district);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Taluk getTaluk(String talukId) {
		Taluk taluk = new Taluk();
		try{
			taluk = (Taluk) openSession().createCriteria(Taluk.class)
					.add(Restrictions.eq("talukId", Integer.parseInt(talukId))).uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return taluk;
	}

	@Override
	public boolean createTaluk(Taluk taluk) {
		try{
			if (Integer.parseInt(taluk.getTalukIDTemp())>0){
				taluk.setTalukId(Integer.parseInt(taluk.getTalukIDTemp()));
			}
			openSession().saveOrUpdate(taluk);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Taluk> talukList() {
		List<Taluk> taluks = new ArrayList<Taluk>();
		try{
			taluks = openSession().createCriteria(Taluk.class).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return taluks;
	}

	@Override
	public int getProductCode() {
		Integer productCode = 0; 
		try{
			Integer lastId = (Integer)openSession().createSQLQuery("SELECT product_id FROM product ORDER BY product_id DESC LIMIT 1")
								.uniqueResult();
			if(lastId != null){
				productCode += lastId;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return productCode+1;
	}

	@Override
	public int getCustomerCode() {
		Integer customerCode = 0; 
		try{
			Integer lastId = (Integer)openSession().createSQLQuery("SELECT customer_id FROM customer ORDER BY customer_id DESC LIMIT 1")
								.uniqueResult();
			if(lastId != null){
				customerCode += lastId;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return customerCode+1;
	}

	@Override
	public SaleOrderResponse getSaleOrderResponse(String customerId) {
		SaleOrderResponse saleOrderResponse = new SaleOrderResponse();
		try{
			Integer saleOrderCode = 0;
			Integer lastId = (Integer) openSession()
					.createSQLQuery("SELECT sale_order_id FROM dmt_sale_order ORDER BY sale_order_id DESC LIMIT 1").uniqueResult();
			if (lastId != null) {
				saleOrderCode += lastId;
			}
			Customer customer = (Customer) openSession().createCriteria(Customer.class)
					.add(Restrictions.eq("customerId",Integer.parseInt(customerId))).uniqueResult();
			
			Supplier supplier = (Supplier) openSession().createCriteria(Supplier.class)
					.add(Restrictions.eq("supplierId",Integer.parseInt(customerId))).uniqueResult();
			if(supplier !=null)
				saleOrderResponse.setSupplier(supplier);
			if(customer !=null)
				saleOrderResponse.setCustomer(customer);
			List<Product> products = openSession().createCriteria(Product.class).list();
			saleOrderResponse.setProducts(products);
			saleOrderCode = saleOrderCode+1;
			saleOrderResponse.setSaleOrderNumber(saleOrderCode.toString());
			List<Brand> brands = openSession().createCriteria(Brand.class).list();
			saleOrderResponse.setBrands(brands);
		}catch(Exception e){
			e.printStackTrace();
		}
		return saleOrderResponse;
	}

	@Override
	public int getSupplierCode() {
		Integer supplierCode = 0; 
		try{
			Integer lastId = (Integer)openSession().createSQLQuery("SELECT supplier_id FROM supplier ORDER BY supplier_id DESC LIMIT 1")
								.uniqueResult();
			if(lastId != null){
				supplierCode += lastId;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return supplierCode+1;
	}

	@Override
	public Supplier getSupplier(String supplierId) {
		Supplier supplier = new Supplier();
		try {
			supplier = (Supplier) openSession().createCriteria(Supplier.class)
					.add(Restrictions.eq("supplierId", Integer.parseInt(supplierId))).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return supplier;
	}

	@Override
	public List<SupplierDTO> supplierList() {
		List<SupplierDTO> supplierDTOs = new ArrayList<SupplierDTO>();
		try{
			List<Supplier> suppliers = openSession().createCriteria(Supplier.class).list();
			for (Supplier supplier : suppliers) {
				SupplierDTO supplierDTO = new SupplierDTO();
				supplierDTO.setSupplierId(supplier.getSupplierId());
				supplierDTO.setSupplierCode(supplier.getSupplierCode());
				supplierDTO.setSupplierName(supplier.getName());
				supplierDTO.setAddress(supplier.getAddressLine1());
				supplierDTO.setArea(supplier.getArea());
				supplierDTO.setCity(supplier.getCity().getCityName());
				supplierDTOs.add(supplierDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return supplierDTOs;
	}

	@Override
	public boolean saveSupplierDetails(Supplier supplier) {
		try {
			if (Integer.parseInt(supplier.getSupplierIdTemp()) > 0) {
				supplier.setSupplierId(Integer.parseInt(supplier.getSupplierIdTemp()));
			}
			if (supplier.getCityName() != null && supplier.getCityName().trim().length() != 0) {
				City city = (City) openSession().createCriteria(City.class)
						.add(Restrictions.eq("cityId", Integer.parseInt(supplier.getCityName()))).uniqueResult();
				if (city != null) {
					supplier.setCity(city);
				}
			}
			if (supplier.getDistrictName() != null && supplier.getDistrictName().trim().length() != 0) {
				District district = (District) openSession().createCriteria(District.class)
						.add(Restrictions.eq("districtId", Integer.parseInt(supplier.getDistrictName()))).uniqueResult();
				if (district != null) {
					supplier.setDistrict(district);				}
			}
			if (supplier.getTalukName() != null && supplier.getTalukName().trim().length() != 0) {
				Taluk taluk = (Taluk) openSession().createCriteria(Taluk.class)
						.add(Restrictions.eq("talukId", Integer.parseInt(supplier.getTalukName()))).uniqueResult();
				if (taluk != null) {
					supplier.setTaluk(taluk);				
				}
			}
				openSession().saveOrUpdate(supplier);
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<DiscountDTO> discountList() {
		List<DiscountDTO> discountDTOs = new ArrayList<DiscountDTO>();
		try{
			List<Discount> discounts = openSession().createCriteria(Discount.class).list();
			for (Discount discount : discounts) {
				DiscountDTO discountDTO = new DiscountDTO();
				discountDTO.setDiscountId(discount.getDiscountId());
				discountDTO.setDiscount(discount.getDiscount());
				discountDTO.setProductName(discount.getProduct().getProductName());
				discountDTO.setCustomerCode(discount.getCustomer().getCustomerCode());
				discountDTO.setCustomerName(discount.getCustomer().getName());
				discountDTOs.add(discountDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return discountDTOs;
	}

	@Override
	public SaleOrderResponse getdiscountDD() {
		SaleOrderResponse saleOrderResponse = new SaleOrderResponse();
		try{
			List<Customer> customers = openSession().createCriteria(Customer.class).list();
			List<Product> products = openSession().createCriteria(Product.class).list();
			saleOrderResponse.setCustomers(customers);
			saleOrderResponse.setProducts(products);
		}catch(Exception e){
			e.printStackTrace();
		}
		return saleOrderResponse;
	}

	@Override
	public boolean saveDiscountDetails(Discount discount) {
		try {

			if (Integer.parseInt(discount.getDiscountIdTemp()) > 0) {
				discount.setDiscountId(Integer.parseInt(discount.getDiscountIdTemp()));
			}
			if (discount.getCustomerName() != null && discount.getCustomerName().trim().length() != 0) {
				Customer customer = (Customer) openSession().createCriteria(Customer.class)
						.add(Restrictions.eq("customerId", Integer.parseInt(discount.getCustomerName()))).uniqueResult();
				if (customer != null) {
					discount.setCustomer(customer);
				}
			}
			
			if (discount.getProductName() != null && discount.getProductName().trim().length() != 0) {
				Product product = (Product) openSession().createCriteria(Product.class)
						.add(Restrictions.eq("productId", Integer.parseInt(discount.getProductName()))).uniqueResult();
				if (product != null) {
					discount.setProduct(product);
				}
			}
			openSession().saveOrUpdate(discount);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Discount getDiscount(String discountId) {
		Discount discount = new Discount();
		try{
			discount = (Discount) openSession().createCriteria(Discount.class).add(Restrictions.eq("discountId",Integer.parseInt(discountId))).uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return discount;
	}

	@Override
	public List<Product> loadProducts(String brandId) {
		List<Product> products = new ArrayList<Product>();
		try{
			Brand brand = new Brand();
			if(brandId != null && brandId.trim().length() > 0){
				brand.setBrandId(Integer.parseInt(brandId));
			}
			products = openSession().createCriteria(Product.class).add(Restrictions.eq("brand", brand)).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public int getPickingQuantity(String orderQty,String productName) {
		int pickingQuantity = 0;
		try{
			if(productName != null && productName.trim().length() > 0){
				Product product = (Product) openSession().createCriteria(Product.class).
						add(Restrictions.eq("productId", Integer.parseInt(productName))).uniqueResult();
				
				if(product != null && product.getQtyInHand() != null){
					int stock = Integer.parseInt(product.getQtyInHand());
					
					int orderQuantity = Integer.parseInt(orderQty);
					
					int difference = stock - orderQuantity;
					if((difference) >0 ){
						pickingQuantity = orderQuantity;
					}else{
						pickingQuantity = stock;
					}
				}else
					pickingQuantity = 0;
						
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pickingQuantity;
	}

	@Override
	public String loadSellingPrice(String productName) {
		String sellingPrice = "";
		try{
			Product product = (Product) openSession().createCriteria(Product.class).
					add(Restrictions.eq("productId", Integer.parseInt(productName))).uniqueResult();
			
			sellingPrice = product.getSellingPrice();
		}catch(Exception e){
			e.printStackTrace();
		}
		return sellingPrice;
	}

	@Override
	public boolean saveSaleOrder(SaleOrderDTO saleOrderDTO) {
		boolean flag = false;
		try{
			System.out.println(saleOrderDTO.getInvoiceIdTemp());
			 
			System.out.println(" ================================== ");
			
			Product product = (Product) openSession().createCriteria(Product.class).
					add(Restrictions.eq("productId",Integer.parseInt(saleOrderDTO.getProductName()))).uniqueResult();
			
			BigDecimal qtyInHand = new BigDecimal(product.getQtyInHand()!=null?product.getQtyInHand():"0");
			
			
			Customer customer = (Customer) openSession().createCriteria(Customer.class)
					.add(Restrictions.eq("customerId", Integer.parseInt(saleOrderDTO.getCustomerName()))).uniqueResult();
			
			Discount discount = (Discount) openSession().createCriteria(Discount.class).
					add(Restrictions.eq("customer", customer)).add(Restrictions.eq("product", product)).uniqueResult();
			
			int orderQuantity = Integer.parseInt(saleOrderDTO.getOrderQuantity());
			int pickingQuantity = Integer.parseInt(saleOrderDTO.getPickingQuantity());
			BigDecimal discountPercentage = new BigDecimal(discount != null? discount.getDiscount() : "0");
			BigDecimal billQuantity = new BigDecimal(saleOrderDTO.getBillQuantity());
			BigDecimal orderQty = new BigDecimal(saleOrderDTO.getOrderQuantity());
			BigDecimal sellingPrice = new BigDecimal(saleOrderDTO.getSellingPrice()); 
			BigDecimal cgstPercentage = new BigDecimal(product.getCgst());
			BigDecimal sgstPercentage = new BigDecimal(product.getSgst());
			BigDecimal grossTotal = sellingPrice.multiply(orderQty);
			if(discountPercentage.compareTo(BigDecimal.ZERO) != 0)
				grossTotal = (grossTotal.multiply(discountPercentage)).divide(new BigDecimal(100)).setScale(2,RoundingMode.HALF_DOWN);
			BigDecimal cgstAmount = (grossTotal.multiply(cgstPercentage)).divide(new BigDecimal(100)).setScale(2,RoundingMode.HALF_DOWN);
			BigDecimal sgstAmount = (grossTotal.multiply(sgstPercentage)).divide(new BigDecimal(100)).setScale(2,RoundingMode.HALF_DOWN);
			
			BigDecimal netCgstAmount = (sellingPrice.multiply(cgstPercentage)).divide(new BigDecimal(100)).setScale(2,RoundingMode.HALF_DOWN);
			BigDecimal netSgstAmount = (sellingPrice.multiply(sgstPercentage)).divide(new BigDecimal(100)).setScale(2,RoundingMode.HALF_DOWN);
		
			BigDecimal totalTax = netCgstAmount.add(netSgstAmount);
			BigDecimal netRate = sellingPrice.add(totalTax).setScale(2,RoundingMode.HALF_DOWN);
			BigDecimal amount = netRate.add(grossTotal).setScale(2,RoundingMode.HALF_DOWN);

			DmtSaleOrder dmtSaleOrder = new DmtSaleOrder();
			dmtSaleOrder.setAmount(amount.toString());
			dmtSaleOrder.setBillQty(billQuantity.toString());
			dmtSaleOrder.setCgstAmount(cgstAmount.toString());
			dmtSaleOrder.setCustomer(customer);
			dmtSaleOrder.setDateCreated(new Timestamp(new Date().getTime()));
			dmtSaleOrder.setGrossTotal(grossTotal.toString());
			dmtSaleOrder.setNetRate(netRate.toString());
			dmtSaleOrder.setOrderQty(saleOrderDTO.getOrderQuantity());
			dmtSaleOrder.setPickingQty(saleOrderDTO.getPickingQuantity());
			dmtSaleOrder.setProduct(product);
			dmtSaleOrder.setSaleOrderNumber(saleOrderDTO.getSaleOrderNumber());
			dmtSaleOrder.setSgstAmount(sgstAmount.toString());
			dmtSaleOrder.setDiscount(discountPercentage.toString());
			
			DmtInvoice dmtInvoice = new DmtInvoice();
			dmtInvoice.setAmount(amount.toString());
			dmtInvoice.setBillQty(billQuantity.toString());
			dmtInvoice.setCgstAmount(cgstAmount.toString());
			dmtInvoice.setCustomer(customer);
			dmtInvoice.setDateCreated(new Timestamp(new Date().getTime()));
			dmtInvoice.setGrossTotal(grossTotal.toString());
			dmtInvoice.setNetRate(netRate.toString());
			dmtInvoice.setOrderQty(saleOrderDTO.getOrderQuantity());
			dmtInvoice.setPickingQty(saleOrderDTO.getPickingQuantity());
			dmtInvoice.setProduct(product);
			dmtInvoice.setSaleOrderNumber(saleOrderDTO.getSaleOrderNumber());
			dmtInvoice.setSgstAmount(sgstAmount.toString());
			dmtInvoice.setDiscount(discountPercentage.toString());
			openSession().save(dmtSaleOrder);
			openSession().save(dmtInvoice);
			
			/*BigDecimal picQty =  new BigDecimal(saleOrderDTO.getPickingQuantity());
			
			BigDecimal finalInHand = qtyInHand.subtract(picQty);
			
			product.setQtyInHand(finalInHand.toString());*/
			
			SaleOrderAccount account = (SaleOrderAccount) openSession().createCriteria(SaleOrderAccount.class)
					.add(Restrictions.eq("saleOrderNumber", saleOrderDTO.getSaleOrderNumber())).uniqueResult();
			
			
			InvoiceAccount invoiceAccount = (InvoiceAccount) openSession().createCriteria(InvoiceAccount.class)
					.add(Restrictions.eq("saleOrderNumber", saleOrderDTO.getSaleOrderNumber())).uniqueResult();
			
			if(account != null){
				account.setAmount(amount.add(new BigDecimal(account.getAmount()).setScale(2,RoundingMode.HALF_DOWN)).toString());
				account.setGstAmount(netRate.add(new BigDecimal(account.getGstAmount()).setScale(2,RoundingMode.HALF_DOWN)).toString());
			}else{
				SaleOrderAccount saleOrderAccount = new SaleOrderAccount();
				saleOrderAccount.setCustomer(customer);
				saleOrderAccount.setGstAmount(netRate.toString());
				saleOrderAccount.setSaleOrderNumber(saleOrderDTO.getSaleOrderNumber());
				saleOrderAccount.setAmount(amount.toString());
				openSession().save(saleOrderAccount);
			}
			
			if(invoiceAccount != null){
				invoiceAccount.setAmount(amount.add(new BigDecimal(account.getAmount()).setScale(2,RoundingMode.HALF_DOWN)).toString());
				invoiceAccount.setGst(netRate.add(new BigDecimal(account.getGstAmount()).setScale(2,RoundingMode.HALF_DOWN)).toString());
			}else{
				InvoiceAccount invAcc = new InvoiceAccount();
				invAcc.setGst(netRate.toString());
				invAcc.setSaleOrderNumber(saleOrderDTO.getSaleOrderNumber());
				invAcc.setAmount(amount.toString());
				openSession().save(invAcc);
			}
			
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaleOrderDTO> getSaleOrders(String saleOrderNumber) {
		List<SaleOrderDTO> saleOrderDTOs = new ArrayList<SaleOrderDTO>();
		try{
			List<DmtSaleOrder> dmtSaleOrders = openSession().createCriteria(DmtSaleOrder.class)
					.add(Restrictions.eq("saleOrderNumber", saleOrderNumber)).list();
			
			SaleOrderAccount saleOrderAccount = (SaleOrderAccount) openSession().createCriteria(SaleOrderAccount.class)
					.add(Restrictions.eq("saleOrderNumber", saleOrderNumber)).uniqueResult();
			
			for (DmtSaleOrder dmtSaleOrder : dmtSaleOrders) {
				SaleOrderDTO saleOrderDTO = new SaleOrderDTO();
				saleOrderDTO.setFooterAmount(saleOrderAccount != null ? saleOrderAccount.getAmount() : "0.0");
				saleOrderDTO.setFooterGst(saleOrderAccount != null ? saleOrderAccount.getGstAmount() : "0.0");
				saleOrderDTO.setAmount(dmtSaleOrder.getAmount());
				saleOrderDTO.setBillQuantity(dmtSaleOrder.getBillQty());
				saleOrderDTO.setProductName(dmtSaleOrder.getProduct().getProductName());
				saleOrderDTO.setCustomerName(dmtSaleOrder.getCustomer().getName());
				saleOrderDTO.setSaleOrderNumber(dmtSaleOrder.getSaleOrderNumber());
				saleOrderDTO.setOrderQuantity(dmtSaleOrder.getOrderQty());
				BigDecimal cgstAmount = new BigDecimal(dmtSaleOrder.getCgstAmount());
				BigDecimal sgstAmount = new BigDecimal(dmtSaleOrder.getSgstAmount());
				saleOrderDTO.setGstAmount(cgstAmount.add(sgstAmount).toString());
				saleOrderDTO.setDiscount(dmtSaleOrder.getDiscount());
				saleOrderDTOs.add(saleOrderDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return saleOrderDTOs;
	}

	@Override
	public List<SaleOrderDTO> getSaleOrderDetailsDt() {
		List<SaleOrderDTO> saleOrderDTOs = new ArrayList<SaleOrderDTO>();
		try{
			List<SaleOrderAccount> saleOrderAccounts = openSession().createCriteria(SaleOrderAccount.class).list();
			for (SaleOrderAccount saleOrderAccount : saleOrderAccounts) {
				SaleOrderDTO saleOrderDTO = new SaleOrderDTO();
				saleOrderDTO.setCustomerName(saleOrderAccount.getCustomer().getName());
				saleOrderDTO.setSaleOrderNumber(saleOrderAccount.getSaleOrderNumber());
				saleOrderDTO.setGstAmount(saleOrderAccount.getGstAmount());
				saleOrderDTO.setAmount(saleOrderAccount.getAmount());
				saleOrderDTOs.add(saleOrderDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return saleOrderDTOs;
	}

	@Override
	public SaleOrderAccount findSaleOrder(String saleOrderNumber) {
		SaleOrderAccount saleOrderAccount = new SaleOrderAccount();
		try{
			saleOrderAccount = (SaleOrderAccount) openSession().createCriteria(SaleOrderAccount.class)
					.add(Restrictions.eq("saleOrderNumber", saleOrderNumber)).uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return saleOrderAccount;
	}

	@Override
	public int getSaleorderCode() {
		Integer saleOrderCode = 0;
		Integer lastId = (Integer) openSession()
				.createSQLQuery("SELECT order_id FROM sale_order_accounts ORDER BY order_id DESC LIMIT 1").uniqueResult();
		if (lastId != null) {
			saleOrderCode += lastId;
		}
		System.out.println("Last ID ============= "+lastId);
		saleOrderCode = saleOrderCode+1;
		return saleOrderCode;
	}

	@Override
	public boolean saveGrnDetails(GRNResponse grnResponse) {
		boolean flag = false;
		
		try{
			Product product = (Product) openSession().createCriteria(Product.class)
					.add(Restrictions.eq("productId", Integer.parseInt(grnResponse.getProductName()))).uniqueResult();
			
			BigDecimal qty = new BigDecimal(product.getQtyInHand()!=null ? product.getQtyInHand() : "0");
			
			BigDecimal val =  qty.add(new BigDecimal(grnResponse.getQuantity()));
			
			product.setQtyInHand(val.toString());
			
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean saveGRN(GrnDTO grnDto) {
		boolean flag = false;
		try{
			Product product = (Product) openSession().createCriteria(Product.class).
					add(Restrictions.eq("productId",Integer.parseInt(grnDto.getProductName()))).uniqueResult();
			
			Supplier supplier = (Supplier) openSession().createCriteria(Supplier.class)
					.add(Restrictions.eq("supplierId", Integer.parseInt(grnDto.getDistributorName()))).uniqueResult();
			
			//BigDecimal rateDiscount = new BigDecimal(grnDto.getRateDiscount()!=null?grnDto.getRateDiscount():"0" );
			//BigDecimal schemeDiscount = new BigDecimal(grnDto.getSchemeDiscount()!=null?grnDto.getSchemeDiscount():"0");
			//BigDecimal cashDiscount = new BigDecimal(grnDto.getCashDiscount()!=null ?grnDto.getCashDiscount():"0");
			//BigDecimal freight = new BigDecimal(grnDto.getFreight()!=null?grnDto.getFreight():"0");
			BigDecimal purchaseQuantity = new BigDecimal(grnDto.getPurchaseQty());
			BigDecimal purchasePrice = new BigDecimal(grnDto.getPurchaseRate()); 
			BigDecimal cgstPercentage = new BigDecimal(product.getCgst());
			BigDecimal sgstPercentage = new BigDecimal(product.getSgst());
			BigDecimal grossTotal = purchasePrice.multiply(purchaseQuantity);
			BigDecimal cgstAmount = (grossTotal.multiply(cgstPercentage)).divide(new BigDecimal(100)).setScale(2,RoundingMode.HALF_DOWN);
			BigDecimal sgstAmount = (grossTotal.multiply(sgstPercentage)).divide(new BigDecimal(100)).setScale(2,RoundingMode.HALF_DOWN);
			BigDecimal netRate = cgstAmount.add(sgstAmount).setScale(2,RoundingMode.HALF_DOWN);
			BigDecimal amount = netRate.add(grossTotal).setScale(2,RoundingMode.HALF_DOWN);
			
			/*if(cashDiscount != null){
				amount = amount.subtract(cashDiscount);
			}
			
			if(schemeDiscount != null){
				amount = amount.subtract(schemeDiscount);
			}
			
			if(freight != null){
				amount = amount.add(freight);
			}*/
			
			String grnNumber = grnDto.getGrnNumber();
			BigDecimal invoiceAmount = new BigDecimal(grnDto.getInvoiceAmount());
			String invoiceNumber = grnDto.getInvoiceNumber();
			
			SimpleDateFormat dateFormat =new SimpleDateFormat("MM/dd/yyyy");
			Date invoiceDate = dateFormat.parse(grnDto.getInvoiceDate()); 
			Timestamp invoiceTimeStamp = new java.sql.Timestamp(invoiceDate.getTime());
			
			Date grnDate = dateFormat.parse(grnDto.getGrnDate()); 
			Timestamp grnTimeStamp = new java.sql.Timestamp(grnDate.getTime());
			
			Date expiryDate = dateFormat.parse(grnDto.getExpiryDate()); 
			Timestamp expiryTimeStamp = new java.sql.Timestamp(expiryDate.getTime());
			
			GRN grn = new GRN();
			grn.setAmount(amount.toString());
			grn.setExpiryDate(expiryTimeStamp);
			grn.setGrnAmount(amount.toString());
			grn.setGrnDate(grnTimeStamp);
			grn.setGrnNumber(grnNumber);
			grn.setGrossAmount(amount.toString());
			grn.setGst(netRate.toString());
			grn.setInvoiceAmount(invoiceAmount.toString());
			grn.setInvoiceDate(invoiceTimeStamp);
			grn.setInvoiceNumber(invoiceNumber);
			grn.setProduct(product);
			grn.setPurchaseQuantity(purchaseQuantity.toString());
			grn.setPurchaseRate(purchasePrice.toString());
			grn.setSupplier(supplier);
			//grn.setSchemeDiscount(schemeDiscount.toString());

			
			openSession().save(grn);
			BigDecimal qtyInHand = new BigDecimal(product.getQtyInHand()!=null ? product.getQtyInHand() : "0");
			product.setQtyInHand(qtyInHand.add(purchaseQuantity).toString());
			GrnAccount account = (GrnAccount) openSession().createCriteria(GrnAccount.class)
					.add(Restrictions.eq("grnNumber", grnDto.getGrnNumber())).uniqueResult();
			
			if(account != null){
				account.setAmount(amount.add(new BigDecimal(account.getAmount()).setScale(2,RoundingMode.HALF_DOWN)).toString());
				account.setGst(netRate.add(new BigDecimal(account.getGst()).setScale(2,RoundingMode.HALF_DOWN)).toString());
			}else{
				GrnAccount grnAccount = new GrnAccount();
				grnAccount.setSupplier(supplier);
				grnAccount.setGst(netRate.toString());
				grnAccount.setGrnNumber(grnDto.getGrnNumber());
				grnAccount.setAmount(amount.toString());
				openSession().save(grnAccount);
			}
			
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<SaleOrderDTO> getGrnDetails(String grnNumber) {
		List<SaleOrderDTO> saleOrderDTOs = new ArrayList<SaleOrderDTO>();
		try{
			List<GRN> grns = openSession().createCriteria(GRN.class)
					.add(Restrictions.eq("grnNumber", grnNumber)).list();
			
			GrnAccount grnAccount = (GrnAccount) openSession().createCriteria(GrnAccount.class)
					.add(Restrictions.eq("grnNumber", grnNumber)).uniqueResult();
			int i =0;
			for (GRN grn : grns) {
				i++;
				SaleOrderDTO saleOrderDTO = new SaleOrderDTO();
				saleOrderDTO.setFooterAmount(grnAccount != null ? grnAccount.getAmount() : "0.0");
				saleOrderDTO.setFooterGst(grnAccount != null ? grnAccount.getGst() : "0.0");
				saleOrderDTO.setAmount(grn.getAmount());
				saleOrderDTO.setGstAmount(grn.getGst());
				saleOrderDTO.setBillQuantity(grn.getPurchaseQuantity());
				saleOrderDTO.setSellingPrice(grn.getPurchaseRate());
				saleOrderDTO.setProductName(grn.getProduct().getProductId()+"");
				saleOrderDTO.setsNo(i+"");
				saleOrderDTO.setExpiryDate(grn.getExpiryDate());
				saleOrderDTO.setBrandName(grn.getProduct().getBrand().getBrandId()+"");
				saleOrderDTO.setGrnId(grn.getGrnId().toString());
				saleOrderDTOs.add(saleOrderDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return saleOrderDTOs;
	}

	@Override
	public int getGrnCode() {
		Integer grnCode = 0;
		Integer lastId = (Integer) openSession()
				.createSQLQuery("SELECT grn_account_id FROM grn_account ORDER BY grn_account_id DESC LIMIT 1").uniqueResult();
		if (lastId != null) {
			grnCode += lastId;
		}
		grnCode = grnCode+1;
		return grnCode;
	}

	@Override
	public GrnAccount findGrn(String grnNumber) {
		GrnAccount grnAccount = new GrnAccount();
		try{
			grnAccount = (GrnAccount) openSession().createCriteria(GrnAccount.class)
					.add(Restrictions.eq("grnNumber", grnNumber)).uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return grnAccount;
	}

	@Override
	public List<SaleOrderDTO> getGrnDetailsDt() {
		List<SaleOrderDTO> saleOrderDTOs = new ArrayList<SaleOrderDTO>();
		try{
			List<GrnAccount> grnAccounts = openSession().createCriteria(GrnAccount.class).list();
			for (GrnAccount account : grnAccounts) {
				SaleOrderDTO saleOrderDTO = new SaleOrderDTO();
				saleOrderDTO.setCustomerName(account.getSupplier().getName());
				saleOrderDTO.setGrnNumber(account.getGrnNumber());
				saleOrderDTO.setGstAmount(account.getGst());
				saleOrderDTO.setAmount(account.getAmount());
				saleOrderDTOs.add(saleOrderDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return saleOrderDTOs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SaleOrderDTO> getInvoiceDetailsDt(String status) {
		String applicationStatus = status;
		List<SaleOrderDTO> saleOrderDTOs = new ArrayList<SaleOrderDTO>();
		List<SaleOrderAccount> saleOrderAccounts = new ArrayList<SaleOrderAccount>();
		try{
			System.out.println("common status =========== "+status);
			if(status.trim().equalsIgnoreCase("UNBILLED")){
				System.out.println("celledd application status");
				saleOrderAccounts = openSession().createCriteria(SaleOrderAccount.class)
						.add(Restrictions.isNull("status")).list();
			}else if(status.trim().equalsIgnoreCase("BILLED")){
				System.out.println("status ============== "+status);
				saleOrderAccounts = openSession().createCriteria(SaleOrderAccount.class)
							.add(Restrictions.eq("status", status).ignoreCase()).list();
			}
			
			System.out.println("List size ================= "+saleOrderAccounts.size());
			for (SaleOrderAccount saleOrderAccount : saleOrderAccounts) {
				System.out.println("For each loop called ");
				SaleOrderDTO saleOrderDTO = new SaleOrderDTO();
				saleOrderDTO.setCustomerName(saleOrderAccount.getCustomer().getName());
				saleOrderDTO.setSaleOrderNumber(saleOrderAccount.getSaleOrderNumber());
				InvoiceAccount invoiceAccount = (InvoiceAccount) openSession().createCriteria(InvoiceAccount.class)
						.add(Restrictions.eq("saleOrderNumber", saleOrderAccount.getSaleOrderNumber())).uniqueResult();
				if(invoiceAccount!=null){
					saleOrderDTO.setGstAmount(invoiceAccount.getGst());
					saleOrderDTO.setAmount(invoiceAccount.getAmount());	
				}else{
					saleOrderDTO.setGstAmount(saleOrderAccount.getGstAmount());
					saleOrderDTO.setAmount(saleOrderAccount.getAmount());
				}
				saleOrderDTOs.add(saleOrderDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return saleOrderDTOs;
	}

	@Override
	public List<SaleOrderDTO> getInvoices(String saleOrderNumber) {
		List<SaleOrderDTO> saleOrderDTOs = new ArrayList<SaleOrderDTO>();
		try{
			List<DmtInvoice> dmtInvoices = openSession().createCriteria(DmtInvoice.class)
					.add(Restrictions.eq("saleOrderNumber", saleOrderNumber)).list();
			
			SaleOrderAccount saleOrderAccount = (SaleOrderAccount) openSession().createCriteria(SaleOrderAccount.class)
					.add(Restrictions.eq("saleOrderNumber", saleOrderNumber)).uniqueResult();
			
			for (DmtInvoice dmtInvoice : dmtInvoices) {
				SaleOrderDTO saleOrderDTO = new SaleOrderDTO();
				saleOrderDTO.setFooterAmount(saleOrderAccount != null ? saleOrderAccount.getAmount() : "0.0");
				saleOrderDTO.setFooterGst(saleOrderAccount != null ? saleOrderAccount.getGstAmount() : "0.0");
				saleOrderDTO.setAmount(dmtInvoice.getAmount());
				saleOrderDTO.setBillQuantity(dmtInvoice.getBillQty());
				saleOrderDTO.setPickingQuantity(dmtInvoice.getPickingQty());
				saleOrderDTO.setProductName(dmtInvoice.getProduct().getProductName());
				saleOrderDTO.setCustomerName(dmtInvoice.getCustomer().getName());
				saleOrderDTO.setSaleOrderNumber(dmtInvoice.getSaleOrderNumber());
				saleOrderDTO.setOrderQuantity(dmtInvoice.getOrderQty());
				saleOrderDTO.setInvoiceId(dmtInvoice.getInvoiceId().toString());
				BigDecimal cgstAmount = new BigDecimal(dmtInvoice.getCgstAmount());
				BigDecimal sgstAmount = new BigDecimal(dmtInvoice.getSgstAmount());
				saleOrderDTO.setGstAmount(cgstAmount.add(sgstAmount).toString());
				saleOrderDTO.setDiscount(dmtInvoice.getDiscount());
				saleOrderDTOs.add(saleOrderDTO);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return saleOrderDTOs;
	}

	@Override
	public SaleOrderDTO getInvoicePopUp(String invoiceId) {
		SaleOrderDTO saleOrderDTO = new SaleOrderDTO();
		try{
			DmtInvoice dmtInvoice = (DmtInvoice) openSession().createCriteria(DmtInvoice.class)
					.add(Restrictions.eq("invoiceId", Integer.parseInt(invoiceId))).uniqueResult();
			
			if(dmtInvoice != null){
				saleOrderDTO.setProductName(dmtInvoice.getProduct().getProductId().toString());
				System.out.println("Product Id "+saleOrderDTO.getProductName());
				saleOrderDTO.setOrderQuantity(dmtInvoice.getOrderQty());
				saleOrderDTO.setPickingQuantity(dmtInvoice.getPickingQty());
				saleOrderDTO.setBillQuantity(dmtInvoice.getBillQty());
				saleOrderDTO.setSellingPrice(dmtInvoice.getProduct().getSellingPrice());
				saleOrderDTO.setBrandName(dmtInvoice.getProduct().getBrand().getBrandId().toString());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return saleOrderDTO;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean updateSaleOrderAndInvoiceDetails(String saleOrderNumber) {
		boolean flag = false;
		
		try{
			SaleOrderAccount saleOrderAccount = (SaleOrderAccount) openSession().createCriteria(SaleOrderAccount.class)
					.add(Restrictions.eq("saleOrderNumber", saleOrderNumber)).uniqueResult();
			saleOrderAccount.setStatus(DmtConstant.BILLED);
			
			List<DmtInvoice> dmtInvoices = openSession().createCriteria(DmtInvoice.class)
					.add(Restrictions.eq("saleOrderNumber", saleOrderNumber)).list();
			
			for (DmtInvoice dmtInvoice : dmtInvoices) {
				BigDecimal billingQuantity = new BigDecimal(dmtInvoice.getBillQty());
				BigDecimal productQuantity = new BigDecimal(dmtInvoice.getProduct().getQtyInHand());
				BigDecimal finalValue = productQuantity.subtract(billingQuantity);
				dmtInvoice.getProduct().setQtyInHand(finalValue.toString());
			}
			
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
