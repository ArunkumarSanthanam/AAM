/**
 * 
 */
var currentTaluk;

var columnArrayLog = [ {"title":"<input name='select_all' value='1' id='example-select-all' type='checkbox' />", "class" : "td2", "width" : "10%"},
                       {"title" : "Taluk Code","data" : "talukCode","class" : "td2","width" : "20%"},
                       {"title" : "Taluk Name","data" : "talukName","class" : "td2","width" : "30%"},
                       {"title" : "Talulk Description","data" : "talukDescription","class" : "td2","width" : "40%"},
                     ];


function populateTalukDataTable(){
	$.ajax({
 		url : "taluklist",
 		type : 'POST',
 		contentType: "application/json;charset=utf-8",
        dataType: "json",
 		async : true,		
 		success : function(data) {
 			 $('#talukTable').DataTable( {
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
 			var myTable = $('#talukTable').DataTable();
 			 $('#talukTable tbody').off();
 				$('#talukTable tbody').on('click', 'td', function() {
 						var colIndex = $(this).index();
 					 	var rowIndex = $(this).parent().index();
 					 	if(colIndex != 0) {
 					 		//$("#productIDTemp").val(myTable.row( this ).data().productId);
 					 		currentTaluk = myTable.row( this ).data().talukId;
 					 		loadContent("Manage Taluk", "talukform")
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

function returnCurrentTalukValue(){
	return currentTaluk;
}