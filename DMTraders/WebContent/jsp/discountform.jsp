<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<section class="content">
	<div class="box box-info">
		<div class="box-header with-border dmt_head">
			<h3 class="box-title">Manage Discount</h3>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form id="discountForm" role="form" class="form-horizontal">
			<input type="hidden" name="discountIdTemp" id="discountIdTemp">
			<div class="box-body">
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Customer
						Name</label>
					<div class="col-sm-10">
						<select id="customerName" name="customerName"
							class="col-md-6 form-control select2" style="width: 50%;">
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Product Name</label>
					<div class="col-sm-10">
						<select id="productName" name="productName" 
							class="col-md-6 form-control select2" style="width: 50%;">
						</select>
					</div>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Discount
						</label>

					<div class="col-sm-10">
						<input name="discount" id="discount" type="text"
							style="width: 50%" class="form-control"
							placeholder="Discount">
					</div>
				</div>
				
				<div class="box-footer">
					<button
						style="float: left; width: 100px; margin-top: 5px; margin-bottom: 5px"
						type="button" onclick="saveDiscountDetails()"
						class="btn btn-block btn-primary">Save</button>
					<button
						style="float: left; width: 100px; margin-top: 5px; margin-bottom: 5px; margin-left: 5px"
						type="button"
						onclick="loadContent('Discount Details', 'discountlist')"
						class="btn btn-block btn-primary">Close</button>

				</div>
				<!-- /.box-footer -->
		</form>
	</div>
	<section class="content">
	 
	 <script>
	 $('.select2').select2();
	$( document ).ready(function() {
		loadDropDown();
			  $("#discountIdTemp").val(returnCurrentDicountValue());
				if($("#discountIdTemp").val() != '0'){
					var discountId  = $("#discountIdTemp").val();
					$.ajax({
						url: "getdiscount", 
						data:{
							discountId : discountId
						},
						type: 'POST',
						success: function(result){
							$("#discount").val(result.discount);
							$("#customerName option[value='"+result.customer.customerId+"']").attr("selected", "selected").trigger("change");
							$("#productName option[value='"+result.product.productId+"']").attr("selected", "selected").trigger("change");
						},error: function(result){
							alert()
						}	    
					});
				}
			
	});
	
	function loadDropDown(){
		$.ajax({
			url: "getdiscountDD", 
			type: 'POST',
			success: function(result){
				for(i=0; i<result.customers.length; i++){
					$('#customerName')
			         .append($("<option></option>")
			                    .attr("value",result.customers[i].customerId)
			                    .text(result.customers[i].name +" - "+result.customers[i].customerCode));
				}
				for(i=0; i<result.products.length; i++){
					$('#productName')
			         .append($("<option></option>")
			                    .attr("value",result.products[i].productId)
			                    .text(result.products[i].productName)); 
				}
			},error: function(result){
				alert();
			}	    
		});
	}
	
</script> 
<script src="js/app/master-discount.js"></script>
</body>
</html>