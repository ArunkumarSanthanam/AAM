/**
 * 
 */
var currentGrn;
function loadGRNAccountDetailsTable(){
	var columnArrayLogForAcc = [ {"title":"<input name='select_all' value='1' id='example-select-all' type='checkbox' />", "class" : "td2", "width" : "10%"},
	                       {"title" : "Grn Number","data" : "grnNumber","class" : "td2","width" : "25%"},
	                       {"title" : "Supplier Name","data" : "customerName","class" : "td2","width" : "25%"},
	                       {"title" : "GST Amount","data" : "gstAmount","class" : "td2","width" : "20%"},
	                       {"title" : "Amount","data" : "amount","class" : "td2","width" : "20%"},
	                     ];
	 $('#grnAccountsDT').dataTable().fnClearTable();
	    $('#grnAccountsDT').dataTable().fnDestroy();
		$.ajax({
	 		url : "grndetailsdt",
	 		type : 'POST',
	 		contentType: "application/json;charset=utf-8",
	        dataType: "json",
	 		async : true,		
	 		success : function(data) {
	 			 $('#grnAccountsDT').DataTable( {
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
	 			var myAccTable = $('#grnAccountsDT').DataTable();
	 			 $('#grnAccountsDT tbody').off();
	 				$('#grnAccountsDT tbody').on('click', 'td', function() {
	 						var colIndex = $(this).index();
	 					 	var rowIndex = $(this).parent().index();
	 					 	if(colIndex != 0) {
	 					 		 $("#saleOrderIDTemp").val(myAccTable.row( this ).data().grnNumber);
	 					 		 currentGrn = myAccTable.row( this ).data().grnNumber;
	 					 		 loadContent("Manage GRN", "grnform")
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

function returnGRNCurrentValue(){
	return currentGrn;
}