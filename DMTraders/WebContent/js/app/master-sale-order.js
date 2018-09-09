/**
 * 
 */

function getSaleOrderResponse(customerId){
	$.ajax({
		url: "getsaleorderresponse", 
		type: 'POST',
		data:{
			customerId : customerId
		},
		success: function(result){
			$("#taluk").val(result.customer.taluk.talukName);
			$("#area").val(result.customer.area);
			$("#mobile").val(result.customer.mobile);
			$("#city").val(result.customer.city.cityName);
			$("#addressLine1").val(result.customer.addressLine1);
			$("#gstNumber").val(result.customer.gstNumber);
			//$("#saleOrderNumber").val(result.saleOrderNumber);
			for(i=0; i<result.brands.length; i++){
				$('#brandName')
		         .append($("<option></option>")
		                    .attr("value",result.brands[i].brandId)
		                    .text(result.brands[i].brandName)); 
			}
			
			loadProducts($("#brandName").val());
			
			
		}
	});
	
}


function loadProducts(brandId){
	$('#productName').empty().trigger('change');
	$.ajax({
		url: "loadproducts", 
		type: 'POST',
		data:{
			brandId : brandId
		},
		success: function(result){
			for(i=0; i<result.length; i++){
				$('#productName')
		         .append($("<option></option>")
		                    .attr("value",result[i].productId)
		                    .text(result[i].productName)); 
			}
		}
	});
}

function getPickingQuantity(){
	var orderQuantity = $("#orderQuantity").val();
	var productName = $("#productName").val();
	$.ajax({
		url: "getpickingquantity", 
		type: 'POST',
		data:{
			orderQuantity : orderQuantity,
			productName : productName
		},
		success: function(result){
			$("#pickingQuantity").val(result);
			$("#billQuantity").val(result);
		}
	});	
}

function loadSellingPrice(productId){
	var productName = productId;
	$.ajax({
		url: "loadsellingprice", 
		type: 'POST',
		data:{
			productName : productName
		},
		success: function(result){
			$("#sellingPrice").val(result);
		}
	});	
}

function saveSaleOrderDetails(){
	$.ajax({
		url: "savesaleorder", 
		data: $("#saleOrderForm").serialize(),
		type: 'POST',
		success: function(result){
			if(result){
				swal("Success", "Sale Details Saved Successfully", "success");
				loadSaleOrderTable();
			}
		}	    
	});
}

function loadSaleOrderTable(){
	var saleOrderNumber = $("#saleOrderNumber").val();
	var columnArrayLog = [ {"title":"<input name='select_all' value='1' id='example-select-all' type='checkbox' />", "class" : "td2", "width" : "5%"},
	                       {"title" : "Sale Order Number","data" : "saleOrderNumber","class" : "td2","width" : "5%"},
	                       {"title" : "Customer Name","data" : "customerName","class" : "td2","width" : "20%"},
	                       {"title" : "Product Name","data" : "productName","class" : "td2","width" : "20%"},
	                       {"title" : "Order Quantity","data" : "orderQuantity","class" : "td2","width" : "10%"},
	                       {"title" : "Discount","data" : "discount","class" : "td2","width" : "10%"},
	                       {"title" : "GST Amount","data" : "gstAmount","class" : "td2","width" : "15%"},
	                       {"title" : "Amount","data" : "amount","class" : "td2","width" : "15%"},
	                     ];
	$('#saleOrderTable').dataTable().fnClearTable();
	    $('#saleOrderTable').dataTable().fnDestroy();
console.log("Inside"+saleOrderNumber);
		$.ajax({
	 		url : "saleorders?saleOrderNumber="+saleOrderNumber,
	 		type : 'POST',
	 		contentType: "application/json;charset=utf-8",
	        dataType: "json",
	 		async : true,		
	 		success : function(data) {
	 			if(data.length > 0){
	 				$("#gstFoot").text(data[0].footerGst);
		 			$("#amountFoot").text(data[0].footerAmount);
	 			}else{
	 				$("#gstFoot").text("0.0");
		 			$("#amountFoot").text("0.0");
	 			}
	 			 $('#saleOrderTable').DataTable( {
	 				"data": data,
	 				"columns": columnArrayLog,
	 				        "searching": true,
	 	 			    	 searchDelay: 1000,
	 				        'columnDefs': [{
	 							 'targets': 0,
	 							 'searchable': false,
	 							 'orderable': false,
	 							 'className': 'dt-body-center',
	 							 'render': function (data, type, full, meta){
	 								 return '<input type="checkbox" name="id[]" value="' + $('<div/>').text(data).html() + '">';
	 							 }
	 						  }],
	 	 					dom: 'Blfrtip',
	 		    } );
	 			var myTable = $('#saleOrderTable').DataTable();
	 			 $('#saleOrderTable tbody').off();
	 				$('#saleOrderTable tbody').on('click', 'td', function() {
	 						var colIndex = $(this).index();
	 					 	var rowIndex = $(this).parent().index();
	 					 	if(colIndex != 0) {
	 					 		//$("#productIDTemp").val(myTable.row( this ).data().productId);
	 					 		//currentBrand = myTable.row( this ).data().brandId;
	 					 		//loadContent("Manage Brand", "brandform")
	 					 	}
	 				});
	 				 $('#example-select-all').on('click', function(){
	 				  // Get all rows with search applied
	 				  var rows = myTable.rows({ 'search': 'applied' }).nodes();
	 				  // Check/uncheck checkboxes for all rows in the table
	 				  $('input[type="checkbox"]', rows).prop('checked', this.checked);
	 			});

	 			// Handle click on checkbox to set state of "Select all" control
	 			$('#example tbody').on('change', 'input[type="checkbox"]', function(){
	 				  // If checkbox is not checked
	 				  if(!this.checked){
	 					 var el = $('#example-select-all').get(0);
	 					 // If "Select all" control is checked and has 'indeterminate' property
	 					 if(el && el.checked && ('indeterminate' in el)){
	 						// Set visual state of "Select all" control
	 						// as 'indeterminate'
	 						el.indeterminate = true;
	 					 }
	 				  }
	 			});
	 		},error : function(data){
	 			console.log(data);
	 			console.log("Error");
	 		}
		
		});
		
}
