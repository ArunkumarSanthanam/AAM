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
              <h3 class="box-title">Manage District</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form id="districtForm" role="form" class="form-horizontal">
              <input type="hidden" name="districtIDTemp" id="districtIDTemp">
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">District Code</label>
                  <div class="col-sm-10">
                      <input type="text" name="districtCode" id="districtCode" style="width: 50%" class="form-control"  placeholder="District Code">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">District Name</label>
                  <div class="col-sm-10">
                    <input name="districtName" id="districtName" type="text" style="width: 50%" class="form-control" placeholder="District Name">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Description</label>

                  <div class="col-sm-10">
                    <textarea name="distrctDescription" style="width: 50%"  class="form-control" id="distrctDescription" placeholder="Description"></textarea>
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
              <button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px" type="button" onclick="saveDistrictDetails()"  class="btn btn-block btn-primary">Save</button>
					<button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px;margin-left: 5px" type="button" onclick="loadContent('District Details', 'districtlist')" class="btn btn-block btn-primary">Close</button>
             
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
          <section class="content">
<script type="text/javascript">
$('.select2').select2();
function saveDistrictDetails(){
	$.ajax({
		url: "createdistrict", 
		data: $("#districtForm").serialize(),
		type: 'POST',
		success: function(result){
			if(result){
				swal("Success", "District Details Saved Successfully", "success")
			}
		}	    
	});
}
$( document ).ready(function() {
    loadBrandNames();
    $("#districtIDTemp").val(returnCurrentDistrictValue());
	if($("#districtIDTemp").val() != '0'){
		var districtId  = $("#districtIDTemp").val();
		$.ajax({
			url: "getdistrict", 
			data:{
				districtId : districtId
			},
			type: 'POST',
			success: function(result){
				console.log(result);
				$("#districtCode").val(result.districtCode);
				$("#districtName").val(result.districtName);
				$("#distrctDescription").val(result.distrctDescription);
			},error: function(result){
				alert()
			}	    
		});
	}
});
</script>
<script src="js/app/master-product.js"></script>
</body>
</html>