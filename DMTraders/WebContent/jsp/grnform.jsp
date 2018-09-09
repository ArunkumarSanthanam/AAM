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
		<div class="box-header with-border">
			<h3 class="box-title dmt_head">Manage GRN</h3>
			<form action="generategrnreport" method="get">
				<input type="hidden" id="grnNumberTemp"  name="grnNumberTemp">
				<button
						style="float: right; width: 100px; margin-top: 5px; margin-bottom: 5px; margin-left: 5px"
						type="submit"
						class="btn btn-block btn-primary">Invoice</button>
			</form>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form id="grnForm" role="form" class="form-horizontal">
			<input type="hidden" name="grnNumberTemp" id="grnNumberTemp">
			<div class="box-body">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">GRN
						Number</label>

					<div class="col-sm-10">
						<input name="grnNumber" id="grnNumber" type="text"
							style="width: 50%" class="form-control"
							placeholder="GRN Number">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Distributor
						Name</label>
					<div class="col-sm-10">
						<select id="distributorName" name="distributorName" onchange="getGRNResponse(this.value)"
							class="col-md-6 form-control select2" style="width: 50%;">
						</select>
					</div>
				</div>
				<div class="box-body">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Distributor Address</label>
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
              
                <div class="form-group">
                <label>GRN Date</label>
               <div style="width: 75%"  class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input type="text" class="form-control pull-right" id="grnDate" name="grnDate">
                </div>
							
              </div>
              
               <div class="form-group">
                <label>Invoice Number</label>
                <input name="invoiceNumber" id="invoiceNumber" type="text"
							style="width: 75%" class="form-control"
							placeholder="Invoice Number">
              </div>
              
              <div class="form-group">
                <label>Invoice Date</label>
                 <div style="width: 75%"  class="input-group date">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input type="text" class="form-control pull-right" id="invoiceDate" name="invoiceDate">
                </div>
              </div>
              
              <div class="form-group">
                <label>Rate Discount</label>
                <input name="rateDiscount" id="rateDiscount" type="text"
							style="width: 75%" class="form-control"
							placeholder="Rate Discount">
              </div>
              
              <div class="form-group">
                <label>Cash Discount</label>
                <input name="cashDiscount" id="cashDiscount" type="text"
							style="width: 75%" class="form-control"
							placeholder="Cash Discount">
              </div>
              
              
              <div class="form-group">
                <label>Freight</label>
                <input name="freight" id="freight" type="text"
							style="width: 75%" class="form-control"
							placeholder="Freight">
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
               <div class="form-group">
                <label>GRN Amount</label>
                <input name="grnAmount" id="grnAmount" type="text"
							style="width: 75%" class="form-control"
							placeholder="GRN Amount">
              </div>
              
              <div class="form-group">
                <label>Invoice Amount</label>
                <input name="invoiceAmount" id="invoiceAmount" type="text"
							style="width: 75%" class="form-control"
							placeholder="Invoice Amount">
              </div>
              
               <div class="form-group">
                <label>Gross Amount</label>
                <input name="grossAmount" id="grossAmount" type="text"
							style="width: 75%" class="form-control"
							placeholder="Gross Amount">
              </div>
              
              
              <div class="form-group">
                <label>Scheme Discount</label>
                <input name="schemeDiscount" id="schemeDiscount" type="text"
							style="width: 75%" class="form-control"
							placeholder="Scheme Discount">
              </div>
              
              
              <div class="form-group">
                <label>GST</label>
                <input name="gst" id="gst" type="text"
							style="width: 75%" class="form-control"
							placeholder="GST">
              </div>
              
              
              <div class="form-group">
                <label>Rounded Off</label>
                <input name="roundedOff" id="roundedOff" type="text"
							style="width: 75%" class="form-control"
							placeholder="Rounded Off">
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
          <div class="box-body" style="overflow: auto;">
              <table id="grnTable" class="table table-bordered table-striped"  style="width: 130%;overflow: auto;">
                <thead>
                <tr>
                   <th><input name='select_all' value='1' id='example-select-all' type='checkbox' /></th>
                  <th>S.No</th>
                  <th>Brand Name</th>
                  <th>Product Name</th>
                  <th>Purchase Qty</th>
                  <th>Purchase Rate</th>
                  <th>Expiry Date</th>
                  <th>GST</th>
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
						onclick="loadContent('GRN Details', 'grnlist')"
						class="btn btn-block btn-primary">Close</button>

				</div>
				<!-- <div id="myModal" class="modal fade" role="dialog">
					<div class="modal-dialog modal-lg">

						Modal content
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
									<select id="brandName" name="brandName" onchange="loadProducts(this.value)"
										class="col-md-6 form-control select2" style="width: 50%;">
									</select>
								</div>
							</div>

							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Product
									Name</label>
								<div class="col-sm-10">
									<select id="productName" name="productName"
										class="col-md-6 form-control select2" style="width: 50%;">
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Product
									Code</label>

								<div class="col-sm-10">
									<input type="text" name="productNumber" id="productNumber"
										style="width: 50%" class="form-control"
										placeholder="Product Code">
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Purchase Quantity
									</label>
								<div class="col-sm-10">
									<input type="text" name="purchaseQty" id="purchaseQty"
										style="width: 50%" class="form-control"
										placeholder="Purchase Quantity">
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Expiry Date
									</label>
										<div  class="date col-sm-10">
											<input type="text" class="form-control"
												id="expiryDate" name="expiryDate" style="width: 50%;">
										</div>

									</div>
							
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-2 control-label">Purchase Rate
									</label>
								<div class="col-sm-10">
									<input type="text" name="purchaseRate" id="purchaseRate"
										style="width: 50%" class="form-control"
										placeholder="Purchase Rate">
								</div>
							</div>
							
							</div>
							<div class="modal-footer">
							<button type="button" id="saveModal" onclick="saveGRNDetails()" style="float: left;" class="btn btn-default"
									>Save</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div> -->
				
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
		var flag = false;
		$('#grnDate').datepicker({
		      autoclose: true
		    });	
		
		$('#invoiceDate').datepicker({
		      autoclose: true
		    });
		
		$('#expiryDate').datepicker({
		      autoclose: true
		    });
		
		$("#grnDate").datepicker().datepicker("setDate", new Date());
		$("#invoiceDate").datepicker().datepicker("setDate", new Date());
		
			$.ajax({
				url: "getallsuppliers", 
				type: 'POST',
				async : false,	
				success: function(result){
					for(i=0; i<result.length; i++){
						$('#distributorName')
				         .append($("<option></option>")
				                    .attr("value",result[i].supplierId)
				                    .text(result[i].name +" - "+result[i].supplierCode)); 
					}
					var supplierId = $('#distributorName').val();
					getGRNResponse(supplierId);
				},error: function(result){
				}	    
			});
			
			$("#grnNumberTemp").val(returnGRNCurrentValue());
			if($("#grnNumberTemp").val() != '0'){
				var grnNumber  = $("#grnNumberTemp").val();
				$.ajax({
					url: "findgrn", 
					data:{
						grnNumber : grnNumber
					},
					type: 'POST',
					success: function(result){
						$("#grnNumber").val(grnNumber);
						$("#grnNumber").val(grnNumber);
						$("#distributorName option[value='"+result.supplier.supplierId+"']").attr("selected", "selected").trigger("change");
						loadGRNTable();
					}
				});
			}else{
				$.ajax({
					url: "getgrncode", 
					type: 'POST',
					success: function(result){
						$("#grnNumber").val(result);	
						$("#grnNumberTemp").val(result);
					}
				});
				loadGRNTable();
			}
				
	});
</script> 
<script type="text/javascript" src="js/app/master-grn.js"></script>
<script type="text/javascript" src="js/app/master-grn-list.js"></script>
</body>
</html>