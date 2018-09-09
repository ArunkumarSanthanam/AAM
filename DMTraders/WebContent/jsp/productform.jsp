<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section class="content">
<div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title dmt_head">Manage Product</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form id="productForm" role="form" class="form-horizontal">
              <input type="hidden" name="productIDTemp" id="productIDTemp">
              
              <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Category</label>

                  <div class="col-sm-10">
                    <input name="category" id="category" type="text" style="width: 50%" class="form-control" placeholder="Category">
                  </div>
              </div>
              
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Brand Name</label>

                  <div class="col-sm-10">
                     <select id="brandName" name="brandName" class="col-md-6 form-control select2" style="width: 50%;">
                	</select>
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Product Code</label>

                  <div class="col-sm-10">
                    <input type="text" name="productNumber" id="productNumber" style="width: 50%" class="form-control"  placeholder="Product Code">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Product Name</label>

                  <div class="col-sm-10">
                    <input name="productName" id="productName" type="text" style="width: 50%" class="form-control" placeholder="Product Name">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">HSN Number</label>

                  <div class="col-sm-10">
                    <input type="text" name="hsnCode" id="hsnCode" style="width: 50%" class="form-control"  placeholder="HSN Number">
                  </div>
                </div>
              <!--   <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Quantity In Hand</label>

                  <div class="col-sm-10">
                    <input type="text" name="qtyInHand" id="qtyInHand" style="width: 50%" class="form-control"  placeholder="Quantity In Hand">
                  </div> 
                </div>-->
                 <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Landing Price</label>

                  <div class="col-sm-10">
                    <input type="text" style="width: 50%" class="form-control" id="landingPrice" name="landingPrice" placeholder="Landing Price">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">MRP</label>

                  <div class="col-sm-10">
                    <input type="text" name="mrp" id="mrp" style="width: 50%" class="form-control"  placeholder="MRP">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Basic Price</label>
                  <div class="col-sm-10">
                    <input type="text" name="sellingPrice" id="sellingPrice" style="width: 50%" class="form-control"  placeholder="Selling Price">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">CGST</label>

                  <div class="col-sm-10">
                    <input type="text" style="width: 50%" class="form-control" id="cgst" name="cgst" placeholder="CGST">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">SGST</label>

                  <div class="col-sm-10">
                    <input type="text" style="width: 50%" class="form-control" id="sgst" name="sgst" placeholder="SGST">
                  </div>
                </div>
               <!--   <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Description</label>

                  <div class="col-sm-10">
                    <textarea name="description" style="width: 50%"  class="form-control" id="description" placeholder="Description"></textarea>
                  </div>
                </div> -->
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
              <button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px" type="button" onclick="saveProductDetails()"  class="btn btn-block btn-primary">Save</button>
					<button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px;margin-left: 5px" type="button" onclick="loadContent('Brand Details', 'productlist')" class="btn btn-block btn-primary">Close</button>
             
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
          <section class="content">
<script type="text/javascript">
$('.select2').select2();
$( document ).ready(function() {
    loadBrandNames();
    $("#productIDTemp").val(returnCurrentValue());
	if($("#productIDTemp").val() != '0'){
		var productID  = $("#productIDTemp").val();
		$.ajax({
			url: "getproduct", 
			data:{
				productID : productID
			},
			type: 'POST',
			success: function(result){
				console.log(result);
				$("#brandName").val(result.brand.brandId);
				$("#productName").val(result.productName);
				$("#productNumber").val(result.productNumber);
				$("#hsnCode").val(result.hsnCode);
				//$("#qtyInHand").val(result.qtyInHand);
				$("#mrp").val(result.mrp);
				$("#landingPrice").val(result.landingPrice);
				$("#sellingPrice").val(result.sellingPrice);
				$("#cgst").val(result.cgst);
				$("#sgst").val(result.sgst);
			},error: function(result){
				alert()
			}	    
		});
	}else{
		$.ajax({
			url: "getproductcode", 
			type: 'POST',
			success: function(result){
				$("#productNumber").val(result);	
			}
		});
	}
});
</script>
<script src="js/app/master-product.js"></script>
</body>
</html>