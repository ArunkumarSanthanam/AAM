/**
 * 
 */
var currentProduct;
function loadBrandNames(){
	$.ajax({
		url: "getbrands", 
		type: 'POST',
		success: function(result){
			for(i=0; i<result.length; i++){
				$('#brandName')
		         .append($("<option></option>")
		                    .attr("value",result[i].brandId)
		                    .text(result[i].brandName)); 
			}
		}	    
	});
}

function saveProductDetails(){
	$.ajax({
		url: "saveproductdetails", 
		data: $("#productForm").serialize(),
		type: 'POST',
		success: function(result){
			console.log(result);
			if(result){
				swal("Success", "Product Details Saved Successfully", "success")
			}
		}	    
	});
}

function populateProductDataTable(){
	$.ajax({
 		url : "productlist",
 		type : 'POST',
 		contentType: "application/json;charset=utf-8",
        dataType: "json",
 		async : true,		
 		success : function(data) {
 			 $('#productTable').DataTable( {
 				"data": data,
 				  "columns": [
 				             { "data": ""},
 				             { "data": "brand" },
 				             { "data": "productName" },
 				             { "data": "productCode" },
 				             { "data": "hsnCode" },
 				             { "data": "quantityInHand" }
 				         ],
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
 			var myTable = $('#productTable').DataTable();
 			 $('#productTable tbody').off();
 				$('#productTable tbody').on('click', 'td', function() {
 						var colIndex = $(this).index();
 					 	var rowIndex = $(this).parent().index();
 					 	if(colIndex != 0) {
 					 		//$("#productIDTemp").val(myTable.row( this ).data().productId);
 					 		currentProduct = myTable.row( this ).data().productId;
 					 		loadContent("Manage Product", "productform")
 					 		/*currentCustomer = myTable.row( this ).data().customerId;
 							loadContent("Manage Customer", "customerform")*/
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
 		}
	
	});
	
}

function returnCurrentValue(){
	return currentProduct;
}
