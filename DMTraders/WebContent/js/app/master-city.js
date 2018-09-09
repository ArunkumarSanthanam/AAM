/**
 * 
 */
var currentCity;

var columnArrayLog = [ {"title":"<input name='select_all' value='1' id='example-select-all' type='checkbox' />", "class" : "td2", "width" : "10%"},
                       {"title" : "City Code","data" : "cityCode","class" : "td2","width" : "20%"},
                       {"title" : "City Name","data" : "cityName","class" : "td2","width" : "30%"},
                       {"title" : "Description","data" : "description","class" : "td2","width" : "40%"}
                     ];


function populateCityDataTable(){
	$.ajax({
 		url : "citylist",
 		type : 'POST',
 		contentType: "application/json;charset=utf-8",
        dataType: "json",
 		async : true,		
 		success : function(data) {
 			console.log(data);
 			 $('#cityDataTable').DataTable( {
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
 			var myTable = $('#cityDataTable').DataTable();
 			 $('#cityDataTable tbody').off();
 				$('#cityDataTable tbody').on('click', 'td', function() {
 						var colIndex = $(this).index();
 					 	var rowIndex = $(this).parent().index();
 					 	if(colIndex != 0) {
 					 		//$("#productIDTemp").val(myTable.row( this ).data().productId);
 					 		currentCity = myTable.row( this ).data().cityId;
 					 		loadContent("Manage City", "cityform")
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

function returnCurrentCityValue(){
	return currentCity;
}