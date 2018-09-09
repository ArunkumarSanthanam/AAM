/**
 * 
 */
var currentCustomer;
var fields = [ "","customerCode","name","addressLine1","area","city.cityName" ];

var columnArrayLog = [ {"title":"<input name='select_all' value='1' id='example-select-all' type='checkbox' />", "class" : "td2", "width" : "5%"},
                       {"title" : "Customer Code","data" : "customerCode","class" : "td2","width" : "20%"},
                       {"title" : "Customer Name","data" : "customerName","class" : "td2","width" : "20%"},
                       {"title" : "Address","data" : "address","class" : "td2","width" : "20%"},
                       {"title" : "Area","data" : "area","class" : "td2","width" : "20%"}, 
                       {"title" : "City","data" : "city","class" : "td2","width" : "10%"}];

/**
 * Function to populate the data table.
 */
function populateCustomerDataTable(){
	var $myTable = $("#customerTable").dataTable();
    $myTable.fnDestroy();
	$myTable.fnClearTable();
	$myTable.fnDraw();

	var searchParams={};
 	
 	searchParams.start=0;
 	searchParams.length=10;
 	searchParams.order="name"
 	searchParams.direction="asc"

 	$.ajax({
 		url : "customerlist",
 		type : 'POST',
 		data :JSON.stringify(searchParams),
 		contentType: "application/json;charset=utf-8",
        dataType: "json",
 		async : true,		
 		success : function(data) {
 				var totalRecords = data.count;
 			    table = $('#customerTable').dataTable({
 			    	deferLoading:totalRecords,
 			    	"bSortable": true,
 			    	"data": data.customerList,
 			    	"columns": columnArrayLog,
 			    	"bAutoWidth": true,
 			    	"searching": true,
 			    	 searchDelay: 1000,
 			    	 "order": [[ 1, "asc" ]],
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
 					lengthMenu: [
 			            [ 10, 25, 50, -1 ],
 			            [ '10 rows', '25 rows', '50 rows', 'Show all' ]
 			        ],			       
 					buttons: [						          
 			            'pageLength',			     			                     		                  			            
 			        ],
 			        "processing": true,
 					"serverSide": true,
 					"ajax": function (data, callback, settings) {
 						var searchCriteria={};
 						searchCriteria.start=data.start;
 						searchCriteria.length=data.length;
 						searchCriteria.order=data.order;
 						if(data.order.length>0){	
 							searchCriteria.order=fields[data.order[0].column];
 							if(data.order[0].dir == 'asc'){
 								searchCriteria.direction="asc";
 							}
 							else{
 								searchCriteria.direction="desc";
 							} 	
 							
 						}else{
 							searchCriteria.order='name';
 							searchCriteria.direction="asc";
 						}
 						var searchColumns={};
 						for(var i=1;i<fields.length;i++){
 							searchColumns[fields[i]]=data.columns[i]["search"]["value"];
 						}
 						searchCriteria.search=searchColumns;
 						$.ajax({
 							url : "customerlist",
 							type : 'POST',
 							data :JSON.stringify(searchCriteria),
 							contentType: "application/json",
 							async : false,
 							success : function(data) {
 								console.log(data);
 								totalRecords=data.count;
 								var resultData={};
 								resultData['draw']=data['draw'];
 								resultData['recordsTotal']=totalRecords;
 								resultData['recordsFiltered']=totalRecords;
 								resultData['data']=data.customerList;
 								callback(resultData);
 							}
 						
 						});
 					}
 				});
 			    
 			    
 			   var myTable = $('#customerTable').DataTable();
 			   $('#customerTable tbody').off();
 				$('#customerTable tbody').on('click', 'td', function() {
 						var colIndex = $(this).index();
 					 	var rowIndex = $(this).parent().index();
 					 	if(colIndex != 0) {
 					 		currentCustomer = myTable.row( this ).data().customerId;
							loadContent("Manage Customer", "customerform")
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
			
			   var i = 0, j = 0;
	 			  $('#customerTable tfoot th').each( function () {
	 				 var title = $(this).text();
				        if( title != null &&  title.length > 0){
				        		    $(this).html( '<input type="text" name="search" onkeyup="searchFunction('+i+')" class="column-search form-control col-md-7 col-xs-12"  id="search_'+i+'" placeholder="Search '+title+'" />' );
				        }
				        i++;
				    } );
				    
				    myTable.columns().every( function () {
				    	thatProperty[j] = this;
						j++;
				    } );
				     
				     searchFunctionOnLoad();
			   $('#customerTable tfoot tr').insertBefore($('#customerTable thead tr'))
 		}
 	});
 	
}


var thatProperty = [];
function searchFunction(id){
	var value = $("#search_"+id).val();
	if ( thatProperty[id].search() !== value ) {
	    thatProperty[id].search( value ).draw();
	}
}

function searchFunctionOnLoad(){
	var searchElements = document.getElementsByName("search");
	for (var i = 0; i < searchElements.length; i++) {
		if($(searchElements[i]).val() ){
			thatProperty[i+1].search( $(searchElements[i]).val() ).draw();
		}
	}
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

function saveCustomerDetails(){
	$.ajax({
		url: "savecustomerdetails", 
		data: $("#customerForm").serialize(),
		type: 'POST',
		success: function(result){
			console.log(result);
			if(result){
				swal("Success", "Customer Details Saved Successfully", "success")
			}
		}	    
	});
}

function returnCurrentValue(){
	return currentCustomer;
}