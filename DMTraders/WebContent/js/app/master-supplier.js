/**
 * 
 */
var currentSupplier;
var fields = [ "","customerCode","name","addressLine1","area","city.cityName" ];

var columnArrayLog = [ {"title":"<input name='select_all' value='1' id='example-select-all' type='checkbox' />", "class" : "td2", "width" : "5%"},
                       {"title" : "Supplier Code","data" : "supplierCode","class" : "td2","width" : "20%"},
                       {"title" : "Supplier Name","data" : "supplierName","class" : "td2","width" : "20%"},
                       {"title" : "Address","data" : "address","class" : "td2","width" : "20%"},
                       {"title" : "Area","data" : "area","class" : "td2","width" : "20%"}, 
                       {"title" : "City","data" : "city","class" : "td2","width" : "10%"}];

/**
 * Function to populate the data table.
 */
function populateSupplierDataTable(){
	$.ajax({
 		url : "supplierlist",
 		type : 'POST',
 		contentType: "application/json;charset=utf-8",
        dataType: "json",
 		async : true,		
 		success : function(data) {
 			console.log(data);
 			 $('#supplierTable').DataTable( {
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
 			var myTable = $('#supplierTable').DataTable();
 			 $('#supplierTable tbody').off();
 				$('#supplierTable tbody').on('click', 'td', function() {
 						var colIndex = $(this).index();
 					 	var rowIndex = $(this).parent().index();
 					 	if(colIndex != 0) {
 					 		//$("#productIDTemp").val(myTable.row( this ).data().productId);
 					 		currentSupplier = myTable.row( this ).data().supplierId;
 					 		loadContent("Manage Supplier", "supplierform")
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

function loadDropdownData(){
	$.ajax({
		url: "loadcustomerdropdown", 
		type: 'POST',
		success: function(result){
			console.log(result);
			for(i=0; i<result.cities.length; i++){
				$('#cityName')
		         .append($("<option></option>")
		                    .attr("value",result.cities[i].cityId)
		                    .text(result.cities[i].cityName)); 
			}
			for(i=0; i<result.districts.length; i++){
				$('#districtName')
		         .append($("<option></option>")
		                    .attr("value",result.districts[i].districtId)
		                    .text(result.districts[i].districtName)); 
			}
			for(i=0; i<result.taluks.length; i++){
				$('#talukName')
		         .append($("<option></option>")
		                    .attr("value",result.taluks[i].talukId)
		                    .text(result.taluks[i].talukName)); 
			}
		}	    
	});
}

function saveSupplierDetails(){
	$.ajax({
		url: "savesupplierdetails", 
		data: $("#supplierForm").serialize(),
		type: 'POST',
		success: function(result){
			if(result){
				swal("Success", "Supplier Details Saved Successfully", "success")
			}
		}	    
	});
}

function returnCurrentValue(){
	return currentSupplier;
}