/**
 * 
 */
var currentDiscount;

var columnArrayLog = [ {"title":"<input name='select_all' value='1' id='example-select-all' type='checkbox' />", "class" : "td2", "width" : "10%"},
                       {"title" : "Customer Code","data" : "customerCode","class" : "td2","width" : "10%"},
                       {"title" : "Customer Name","data" : "customerName","class" : "td2","width" : "30%"},
                       {"title" : "Product Name","data" : "productName","class" : "td2","width" : "30%"},
                       {"title" : "Discount","data" : "discount","class" : "td2","width" : "20%"},
                     ];


function populateDiscountDataTable(){
	$.ajax({
 		url : "discountlist",
 		type : 'POST',
 		contentType: "application/json;charset=utf-8",
        dataType: "json",
 		async : true,		
 		success : function(data) {
 			 $('#discountTable').DataTable( {
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
 			var myDiscountTable = $('#discountTable').DataTable();
 			 $('#discountTable tbody').off();
 				$('#discountTable tbody').on('click', 'td', function() {
 						var colIndex = $(this).index();
 					 	var rowIndex = $(this).parent().index();
 					 	if(colIndex != 0) {
 					 		//$("#productIDTemp").val(myDiscountTable.row( this ).data().productId);
 					 		console.log(myDiscountTable.row( this ).data());
 					 		currentDiscount = myDiscountTable.row( this ).data().discountId;
 					 		loadContent("Manage Discount", "discountform")
 					 	}
 				});
 				 $('#example-select-all').on('click', function(){
 				  // Get all rows with search applied
 				  var rows = myDiscountTable.rows({ 'search': 'applied' }).nodes();
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

function saveDiscountDetails(){
	$.ajax({
		url: "savediscountdetails", 
		data: $("#discountForm").serialize(),
		type: 'POST',
		success: function(result){
			if(result){
				swal("Success", "Discount Details Saved Successfully", "success")
			}
		}	    
	});
}
function returnCurrentDicountValue(){
	return currentDiscount;
}