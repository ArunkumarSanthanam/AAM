/**
 * 
 */
var brandObj = null;
var productObj = null;
var count =0;
function getGRNResponse(customerId){
	$.ajax({
		url: "getsaleorderresponse", 
		type: 'POST',
		async : false,
		data:{
			customerId : customerId
		},
		success: function(result){
			$("#taluk").val(result.supplier.taluk.talukName);
			$("#area").val(result.supplier.area);
			$("#mobile").val(result.supplier.mobile);
			$("#city").val(result.supplier.city.cityName);
			$("#addressLine1").val(result.supplier.addressLine1);
			$("#gstNumber").val(result.supplier.gstNumber);
			//$("#saleOrderNumber").val(result.saleOrderNumber);
			brandObj = result.brands;
			//loadProducts($("#brandName").val());
		}
	});
	
}


function loadProducts(brandIds){
	$('#product_'+brandIds).empty().trigger('change');
	var brandTemp = $("#brandName_"+brandIds).val();
	$.ajax({
		url: "loadproducts", 
		type: 'POST',
		async : false,
		data:{
			brandId : brandTemp
		},
		success: function(result){
			productObj = result;
			for(i=0; i<result.length; i++){
				$('#product_'+brandIds)
		         .append($("<option></option>")
		                    .attr("value",result[i].productId)
		                    .text(result[i].productName)); 
			}
		}
	});
}



function saveGRNDetails(){
	$.ajax({
		url: "savegrn", 
		data: $("#grnForm").serialize(),
		type: 'POST',
		success: function(result){
			if(result){
				swal("Success", "GRN Details Saved Successfully", "success");
				loadGRNTable();
			}
		}	    
	});
}

function loadGRNTable(){
	var grnNumber = $("#grnNumber").val();
	var columnArrayLog = [ {"title":"<input name='select_all' value='1' id='example-select-all' type='checkbox' />", "class" : "td2", "width" : "5%"},
	                       {"title" : "S.No","data" : "sNo","class" : "td2","width" : "10%"},
	                       {"title" : "Product Name","data" : "productName","class" : "td2","width" : "30%"},
	                       {"title" : "Quantity","data" : "billQuantity","class" : "td2","width" : "15%"},
	                       {"title" : "Purchase Rate","data" : "sellingPrice","class" : "td2","width" : "20%"},
	                       {"title" : "GST Amount","data" : "gstAmount","class" : "td2","width" : "10%"},
	                       {"title" : "Amount","data" : "amount","class" : "td2","width" : "10%"},
	                     ];
	$('#grnTable').dataTable().fnClearTable();
	    $('#grnTable').dataTable().fnDestroy();
		$.ajax({
	 		url : "grndetails?grnNumber="+grnNumber,
	 		type : 'POST',
	 		contentType: "application/json;charset=utf-8",
	        dataType: "json",
	 		async : true,		
	 		success : function(data) {
	 			if(data.length > 0){
	 				$("#gstFoot").text(data[0].footerGst);
		 			$("#amountFoot").text(data[0].footerAmount);
		 			$("#grnAmount").text(data[0].amount);
		 			$("#grossAmount").text(data[0].amount);
	 			}else{
	 				$("#gstFoot").text("0.0");
		 			$("#amountFoot").text("0.0");
	 			}
	 			
	 			if(data.length > 0){
    				count = count+data.length;
    				for ( var i in data) {
    					var tag = '';
	    				tag = '<tr>';
	    				tag +='<td><input type="checkbox" name="id[]"></td>';
	    				tag += '<td><span style="width:10%">'+data[i].sNo+'</span></td>';
	    				tag += '<td><select style="width:100%"  id="brandName_'
								+ data[i].sNo
								+ '" class="cellCountry inputs form-control" name="brandName" value="'+ data[i].brandName+'" required="required" onchange="javascript:loadProducts('
								+ data[i].sNo
								+ ');"><option></option></select></td>';
						tag += '<td><select style="width:100%"  id="product_'
								+ data[i].sNo
								+ '" class="cellState inputs form-control" name="productName" value="'+ data[i].productName+'" required="required" class="form-control"><option></option></select></td>';
						tag += '<td><input style="width:50%" type="text" class="cellName inputs form-control" value="'+ data[i].billQuantity+'" name="billQuantity_"  id="billQuantity_'+ data[i].sNo+'" /></td>';
						tag += '<td><input style="width:50%" type="text" class="cellCity inputs form-control" name="purchaseRate_" value="'+ data[i].sellingPrice+'" id="purchaseRate_' + data[i].sNo + '" /></td>';
						tag += '<td><input style="width:70%" type="text" class="cellCity inputs lst form-control" name="expiryDate" id="expiryDate_' + data[i].sNo + '" /></td>';
						tag += '<td><span style="width:10%">'+data[i].gstAmount+'</span></td>';
						tag += '<td><span style="width:10%">'+data[i].amount+'</span></td>';
						tag += '</tr>';
						//$("#countryId_"+count).children().remove();
						$('#grnTable').append(tag);
						formatDate(data[i].expiryDate,data[i].sNo);
						$('#expiryDate_'+data[i].sNo).datepicker({
						      autoclose: true
						    });	
						for ( var k in brandObj) {
							var id = brandObj[k].brandId;
							var name = brandObj[k].brandName;
							$("#brandName_"+data[i].sNo).append(
									"<option value ="+id+">" + name + "</option>");
						} 
						$("#brandName_"+data[i].sNo).val(data[i].brandName);
						loadProducts(data[i].sNo);
						$("#product_"+data[i].sNo).val(data[i].productName);
					} 
    			}
	 			
	 			
	 			var myTable = $('#grnTable').DataTable();
	 			 $('#grnTable tbody').off();
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

function formatDate(expiryDate,sNo){
	alert(expiryDate);
	var expiryDate = new Date(expiryDate);
	var month = expiryDate.getMonth()+1;
	var date = expiryDate.getDate();
	var year = expiryDate.getFullYear();
	$("#expiryDate_"+sNo).val(month+"/"+date+"/"+year);
}

$(document)
.on(
		'keydown',
		'.lst',
		function(e) {
			alert("called");
			var code = (e.keyCode ? e.keyCode : e.which);
			if (code == 13) {
				
				if(count === 0){
					count = 1;
				}else if(count > 0){
					count = $('#grnTable tr').length -1;
				}
				var tag = '';
				tag = '<tr>';
				tag +='<td><input type="checkbox" name="id[]"></td>';
				tag += '<td><span style="width:10%">'+count+'</span></td>';
				tag += '<td><select style="width:100%"  id="brandName_'
						+count
						+ '" class="cellCountry inputs form-control" name="brandName"  required="required" onchange="javascript:loadProducts('
						+count
						+ ');"><option></option></select></td>';
				tag += '<td><select style="width:100%"  id="product_'
						+count
						+ '" class="cellState inputs form-control" name="productName"  required="required" class="form-control"><option></option></select></td>';
				tag += '<td><input style="width:50%" type="text" class="cellName inputs form-control"  name="billQuantity_"  id="billQuantity_'+count+'" /></td>';
				tag += '<td><input style="width:50%" type="text" class="cellCity inputs form-control" name="purchaseRate" id="purchaseRate_' +count + '" /></td>';
				tag += '<td><input style="width:70%" type="text" class="cellExp inputs lst form-control" name="expiryDate" id="expiryDate_' +count + '" /></td>';
				tag += '<td><span style="width:10%"></span></td>';
				tag += '<td><span style="width:10%"></span></td>';
				tag += '</tr>';
				$("#brandName_"+count).children().remove();
				$('#grnTable').append(tag);
				$(this).focus().select();
				$('#expiryDate_'+count).datepicker({
				      autoclose: true
				    });	
				for ( var k in brandObj) {
					var id = brandObj[k].brandId;
					var name = brandObj[k].brandName;
					$("#brandName_"+count).append(
							"<option value ="+id+">" + name + "</option>");
				} 
				$("#brandName_"+count).focus();
				//$("#brandName_"+count).trigger("click");
				$('.ui-datepicker-calender').css("display","none");
				
			}
		});

$(document).on('keydown', '.inputs', function(e) {
var code = (e.keyCode ? e.keyCode : e.which);
if (code == 13) {
var index = $('.inputs').index(this) + 1;
$('.inputs').eq(index).focus();
}
});
