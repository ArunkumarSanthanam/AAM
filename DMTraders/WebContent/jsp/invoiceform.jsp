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
			<h3 class="box-title">Manage Invoice</h3>
			<form action="generateinvoicereport" method="get">
				<input type="hidden" id="saleOrderNumberTemp"  name="saleOrderNumberTemp">
				<button
						style="float: right; width: 100px; margin-top: 5px; margin-bottom: 5px; margin-left: 5px"
						type="submit"
						class="btn btn-block btn-primary">Invoice</button>
			</form>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form id="saleOrderForm" role="form" class="form-horizontal">
			<input type="hidden" name="saleOrderIDTemp" id="saleOrderIDTemp">
			<div class="box-body">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Sale
						Order Number</label>

					<div class="col-sm-10">
						<input name="saleOrderNumber" id="saleOrderNumber" type="text"
							style="width: 50%" class="form-control"
							placeholder="Sale Order Number ">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Customer
						Name</label>
					<div class="col-sm-10">
						<select id="customerName" name="customerName" onchange="getSaleOrderResponse(this.value)"
							class="col-md-6 form-control select2" style="width: 50%;">
						</select>
					</div>
				</div>
				<div class="box-body">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Customer Address</label>
                <input name="addressLine1" id="addressLine1" type="text"
							style="width: 75%" class="form-control"
							placeholder="Address Line 1">
              </div>
              <!-- /.form-group -->
              <div class="form-group">
                <label>Area</label>
                <input name="area" id="area" type="text"
							style="width: 75%" class="form-control"
							placeholder="Area">
              </div>
              <div class="form-group">
                <label>Gst Number</label>
                <input name="gstNumer" id="gstNumber" type="text"
							style="width: 75%" class="form-control"
							placeholder="GST Number">
              </div>
              <!-- /.form-group -->
            </div>
            <!-- /.col -->
            <div class="col-md-6">
              <div class="form-group">
                <label>City</label>
                <input name="city" id="city" type="text"
							style="width: 75%" class="form-control"
							placeholder="City">
              </div>
              <!-- /.form-group -->
              <div class="form-group">
                <label>Taluk</label>
                <input name="taluk" id="taluk" type="text"
							style="width: 75%" class="form-control"
							placeholder="Taluk">
              </div>
               <div class="form-group">
                <label>Mobile Number</label>
                <input name="mobile" id="mobile" type="text"
							style="width: 75%" class="form-control"
							placeholder="Mobile Number">
              </div>
              <!-- /.form-group -->
            </div>
            
             <div class="col-md-6">
              
              <!-- /.form-group -->
             
              <!-- /.form-group -->
            </div>
            <!-- /.col -->
            <button id="addSaleProduct" type="button" style="width: 100px;float: right;margin-left: 5px" class="btn btn-block btn-primary" data-toggle="modal" data-target="#myModal">Add Product</button>
          </div>
          <div class="box-body">
              <table id="saleOrderTable" class="table table-bordered table-striped" style="width: 100%">
                <thead>
                <tr>
                   <th></th>
                  <th>Product Name</th>
                  <th>Order Quantity</th>
                  <th>Stock Quantity</th>
                  <th>Bill Quantity</th>
                  <th>Discount</th>
                  <th>GST Amount</th>
                  <th>Amount</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
                <tfoot>
                <tr>
                   <th></th>
                  <th></th>
                  <th></th>
                  <th></th>
                  <th></th>
				  <th></th>                  
                  <th id="gstFoot"></th>
                  <th id="amountFoot"></th>
                </tr>
                </tfoot>
              </table>
            </div>
          
				
				<div class="box-footer">
					<!-- <button
						style="float: left; width: 100px; margin-top: 5px; margin-bottom: 5px"
						type="button" onclick="saveProductDetails()"
						class="btn btn-block btn-primary">Save</button> -->
					<button
						style="float: left; width: 100px; margin-top: 5px; margin-bottom: 5px; margin-left: 5px"
						type="button"
						onclick="loadContent('Sale Order Details', 'saleorderlist')"
						class="btn btn-block btn-primary">Close</button>

				</div>
				<div id="myModal" class="modal fade" role="dialog">
					<div class="modal-dialog modal-lg">
						<input type="hidden" id="invoiceIdTemp" name="invoiceIdTemp">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Product Details</h4>
							</div>
							<div class="modal-body">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">Brand
									Name</label>
								<div class="col-sm-10">
									<select id="brandName" name="brandName" onchange=""
										class="col-md-6 form-control select2" style="width: 50%;">
									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Product
									Name</label>
								<div class="col-sm-10">
									<select id="productName" name="productName" onchange="loadSellingPrice(this.value)"
										class="col-md-6 form-control select2" style="width: 50%;">
									</select>
								</div>
							</div>
							
							<!-- <div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Product
									Code</label>

								<div class="col-sm-10">
									<input type="text" name="productNumber" id="productNumber"
										style="width: 50%" class="form-control"
										placeholder="Product Code">
								</div>
							</div> -->
							
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Order Quantity
									</label>
								<div class="col-sm-10">
									<input type="text" name="orderQuantity" id="orderQuantity"
										style="width: 50%" class="form-control" onfocusout="getPickingQuantity()"
										placeholder="Order Quantity">
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Stock Quantity
									</label>
								<div class="col-sm-10">
									<input type="text" name="pickingQuantity" id="pickingQuantity"
										style="width: 50%" class="form-control"
										placeholder="Picking Quantity">
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Bill
									Quantity</label>
								<div class="col-sm-10">
									<input type="text" name="billQuantity" id="billQuantity"
										style="width: 50%" class="form-control"
										placeholder="Bill Quantity">
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Basic Price
									</label>
								<div class="col-sm-10">
									<input type="text" name="sellingPrice" id="sellingPrice"
										style="width: 50%" class="form-control"
										placeholder="Selling Price">
								</div>
							</div>
							</div>
							<div class="modal-footer">
							<button type="button" id="saveModal" onclick="saveSaleOrderDetails()" style="float: left;" class="btn btn-default"
									>Save</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>
				
				<!-- /.box-footer -->
		</form>
		
			</div>
	<section class="content">
	 
	 <script>
	 $('.select2').select2();
	 
	 $("#productName").select2({
		placeholder: "Select a Product",
		allowClear : true
	 });
	$( document ).ready(function() {
			$.ajax({
				url: "getallcustomers", 
				type: 'POST',
				success: function(result){
					for(i=0; i<result.length; i++){
						$('#customerName')
				         .append($("<option></option>")
				                    .attr("value",result[i].customerId)
				                    .text(result[i].name +" - "+result[i].customerCode)); 
					}
					var customerId = $('#customerName').val();
					getSaleOrderResponse(customerId);
				},error: function(result){
				}	    
			});
			
			$("#saleOrderIDTemp").val(returnSaleOrderCurrentValue());
			if($("#saleOrderIDTemp").val() != '0'){
				$("#addSaleProduct").hide();
				var saleOrderNumber  = $("#saleOrderIDTemp").val();
				$.ajax({
					url: "findsaleorder", 
					data:{
						saleOrderNumber : saleOrderNumber
					},
					type: 'POST',
					success: function(result){
						$("#saleOrderNumber").val(saleOrderNumber);
						$("#saleOrderNumberTemp").val(saleOrderNumber);
						$("#customerName option[value='"+result.customer.customerId+"']").attr("selected", "selected").trigger("change");
						loadInvoiceTable();
					}
				});
			}else{
				$.ajax({
					url: "getsaleordercode", 
					type: 'POST',
					success: function(result){
						$("#saleOrderNumber").val(result);	
						$("#saleOrderNumberTemp").val(result);
					}
				});
				loadInvoiceTable();
			}
				
	});
	
	$( "#myModal" ).on('shown.bs.modal', function (e) {
		/* $("#brandName").empty().trigger('change');
		$("#productName").empty().trigger('change');
		getSaleOrderResponse(); */
		$("#brandName").attr( "disabled" , "disabled" );
		$("#productName").attr( "disabled" , "disabled" );
	});
</script> 
<script src="js/app/master-invoice.js"></script>
<script src="js/app/master-invoice-list.js"></script>
</body>
</html>