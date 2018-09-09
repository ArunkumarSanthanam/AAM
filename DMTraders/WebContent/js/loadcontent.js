/**
 * 
 */

function loadContent(title,url){
	$("#wrapper").load(url);
	if(title == 'Customer Details'){
		currentCustomer = '0';
	}
	if(title == 'Product Details'){
		currentProduct = '0';
	}
	if(title == 'Brand Details'){
		currentBrand = '0';
	}
	if(title == 'Taluk Details'){
		currentTaluk = '0';
	}
	if(title == 'City Details'){
		currentCity = '0';
	}
	if(title == 'District Details'){
		currentDistrict = '0';
	}
	if(title == 'Supplier Details'){
		currentSupplier = '0';
	}
	
	if(title == 'Discount Details'){
		currentDiscount = '0';
	}
	
	if(title == 'Sale Order Details'){
		currentSaleOrder = '0';
	}
	
	if(title == 'GRN Details'){
		currentGrn = '0';
	}
}