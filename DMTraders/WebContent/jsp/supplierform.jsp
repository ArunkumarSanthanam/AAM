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
            <div class="box-header with-border dmt_head">
              <h3 class="box-title">Manage Supplier</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form id="supplierForm" role="form" class="form-horizontal">
              <input type="hidden" id="supplierIdTemp" name="supplierIdTemp">
              <div class="box-body">
                   <div class="form-group">
                   <label for="inputPassword3" class="col-sm-2 control-label">Prefix</label>
                    <div class="col-sm-10">
                  <select id="prefix" name="prefix" class="col-sm-2 form-control select2 control-label" style="width: 10%;">
                		<option value="Ms">M/s</option>
                		<option value="Mr">Mr</option>
                		<option value="Mr">Mrs</option>
                	 </select>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Supplier Name</label>

                  <div class="col-sm-10">
                    <input name="name" id="name" type="text" style="width: 50%" class="form-control" placeholder="Customer Name">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Supplier Code</label>

                  <div class="col-sm-10">
                    <input type="text" name="supplierCode" id="supplierCode" style="width: 50%" class="form-control"  placeholder="Supplier Code">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Supplier Short Name</label>

                  <div class="col-sm-10">
                    <input type="text" name="shortName" id="shortName" style="width: 50%" class="form-control"  placeholder="Supplier Short Name">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Address Line1</label>

                  <div class="col-sm-10">
                    <input type="text" name="addressLine1" id="addressLine1" style="width: 50%" class="form-control"  placeholder="Address Line1">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Area</label>

                  <div class="col-sm-10">
                    <input type="text" name="area" id="area" style="width: 50%" class="form-control"  placeholder="Area">
                  </div>
                </div>
                <div class="form-group">
                   <label for="inputPassword3" class="col-sm-2 control-label">City</label>
                    <div class="col-sm-10">
                  <select id="cityName" name="cityName" class="col-sm-2 form-control select2 control-label" style="width: 50%;">
                	 </select>
                  </div>
                </div>
                <div class="form-group">
                   <label for="inputPassword3" class="col-sm-2 control-label">Taluk</label>
                    <div class="col-sm-10">
                  <select id="talukName" name="talukName" class="col-sm-2 form-control select2 control-label" style="width: 50%;">
                	 </select>
                  </div>
                </div>
                <div class="form-group">
                   <label for="inputPassword3" class="col-sm-2 control-label">District</label>
                    <div class="col-sm-10">
                  <select id="districtName" name="districtName" class="col-sm-2 form-control select2 control-label" style="width: 50%;">
                	 </select>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Pincode</label>

                  <div class="col-sm-10">
                    <input type="text" style="width: 50%" class="form-control" id="pincode" name="pincode" placeholder="Pincode">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Gst Number</label>

                  <div class="col-sm-10">
                    <input type="text" style="width: 50%" class="form-control" id="gstNumber" name="gstNumber" placeholder="Gst Number">
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Mobile Number</label>

                  <div class="col-sm-10">
                    <input type="text" style="width: 50%" class="form-control" id="mobile" name="mobile" placeholder="Mobile Number">
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Email</label>

                  <div class="col-sm-10">
                    <input type="text" style="width: 50%" class="form-control" id="email" name="email" placeholder="Email">
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
              <button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px" type="button" onclick="saveSupplierDetails()"  class="btn btn-block btn-primary">Save</button>
					<button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px;margin-left: 5px" type="button" onclick="loadContent('Supplier Details', 'supplierlist')" class="btn btn-block btn-primary">Close</button>
             
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
          <section class="content">
          <script type="text/javascript">
$('.select2').select2();
$( document ).ready(function() {
	$("#supplierIdTemp").val(returnCurrentValue());
	if($("#supplierIdTemp").val() != '0'){
		var supplierId  = $("#supplierIdTemp").val();
		$.ajax({
			url: "getsupplier", 
			data:{
				supplierId : supplierId
			},
			type: 'POST',
			success: function(result){
				$("#name").val(result.name);
				$("#prefix").val(result.prefix);
				$("#supplierCode").val(result.supplierCode);
				$("#shortName").val(result.shortName);
				$("#area").val(result.area);
				$("#addressLine1").val(result.addressLine1);
				$("#city").val(result.city.cityId);
				$("#taluk").val(result.taluk.talukId);
				$("#district").val(result.district.districtId);
				$("#pincode").val(result.pincode);
				$("#gstNumber").val(result.gstNumber);
				$("#mobile").val(result.mobile);
				$("#email").val(result.email);
			},error: function(result){
				alert()
			}	    
		});
	}else{
		$.ajax({
			url: "getsuppliercode", 
			type: 'POST',
			success: function(result){
				$("#supplierCode").val(result);	
			}
		});
	}
	loadDropdownData();
});


</script>
<script src="js/app/master-supplier.js"></script>

</body>
</html>