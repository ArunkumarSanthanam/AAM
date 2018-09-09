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
<div class="box box-default">
        <div class="box-header with-border">
         <h3 class="box-title dmt_head">Manage Brand</h3>
        </div>
	<div class="box-body">
		<div class="row">
			<div class="col-md-12">
				<form id="BrandForm"  role="form">
					<input type="hidden" name="brandIdTemp" id="brandIdTemp">
              		<div class="box-body">
		               <div class="form-group">
		                 <label for="exampleInputEmail1">Brand Name</label>
		                 <input type="text" class="form-control" id="brandName" name="brandName" placeholder="Brand Name">
		               </div>
		               <div class="form-group">
		                 <label for="exampleInputPassword1">Brand Description</label>
		                 <textarea class="form-control" id="brandDescription" name="brandDescription" placeholder="Brand Description"></textarea>
		               </div>
		             </div>
		             <!-- /.box-body -->
		             <div class="box-footer">
		              <button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px" type="button" onclick="createBrand()"  class="btn btn-block btn-primary">Save</button>
					<button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px;margin-left: 5px" type="button" onclick="loadContent('Brand Details', 'brandlist')" class="btn btn-block btn-primary">Close</button>
		             </div>
           		</form>
			</div>
		</div>
		<!-- /.row -->
	</div>
</div>
</section>
<script>
	function createBrand(){
		$.ajax({
			url: "createbrand", 
			data: $("#BrandForm").serialize(),
			type: 'POST',
			success: function(result){
				if(result){
					swal("Success", "Brand Details Saved Successfully", "success")
				}
			}	    
		});
	}
	
	$( document ).ready(function() {
		$("#brandIdTemp").val(returnBrandCurrentValue());
		if($("#brandIdTemp").val() != '0'){
			var brandId  = $("#brandIdTemp").val();
			$.ajax({
				url: "getbrand", 
				data:{
					brandId : brandId
				},
				type: 'POST',
				success: function(result){
					console.log(result);
					$("#brandName").val(result.brandName);
					$("#brandDescription").val(result.brandDescription);
				},error: function(result){
					alert()
				}	    
			});
		}
	});
</script>
<script src="js/app/master-brand.js"></script>
</body>
</html>