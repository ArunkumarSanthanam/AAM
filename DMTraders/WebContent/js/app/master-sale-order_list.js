/**
 * 
 */
var currentSaleOrder;
function loadSaleOrderDetailsTable(){
	var columnArrayLogForAcc = [ {"title":"<input name='select_all' value='1' id='example-select-all' type='checkbox' />", "class" : "td2", "width" : "10%"},
	                       {"title" : "Sale Order Number","data" : "saleOrderNumber","class" : "td2","width" : "25%"},
	                       {"title" : "Customer Name","data" : "customerName","class" : "td2","width" : "25%"},
	                       {"title" : "GST Amount","data" : "gstAmount","class" : "td2","width" : "20%"},
	                       {"title" : "Amount","data" : "amount","class" : "td2","width" : "20%"},
	                     ];
	 $('#saleOrderDetailsDT').dataTable().fnClearTable();
	    $('#saleOrderDetailsDT').dataTable().fnDestroy();
		$.ajax({
	 		url : "saleorderdetailsdt",
	 		type : 'POST',
	 		contentType: "application/json;charset=utf-8",
	        dataType: "json",
	 		async : true,		
	 		success : function(data) {
	 			 $('#saleOrderDetailsDT').DataTable( {
	 				"data": data,
	 				"columns": columnArrayLogForAcc,
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
	 			var myAccTable = $('#saleOrderDetailsDT').DataTable();
	 			 $('#saleOrderDetailsDT tbody').off();
	 				$('#saleOrderDetailsDT tbody').on('click', 'td', function() {
	 						var colIndex = $(this).index();
	 					 	var rowIndex = $(this).parent().index();
	 					 	if(colIndex != 0) {
	 					 		 $("#saleOrderIDTemp").val(myAccTable.row( this ).data().saleOrderNumber);
	 					 		 currentSaleOrder = myAccTable.row( this ).data().saleOrderNumber;
	 					 		 loadContent("Manage Sale Order", "saleorderform")
	 					 	}
	 				});
	 				 $('#example-select-all').on('click', function(){
	 				  // Get all rows with search applied
	 				  var rows = myAccTable.rows({ 'search': 'applied' }).nodes();
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

function returnSaleOrderCurrentValue(){
	return currentSaleOrder;
}