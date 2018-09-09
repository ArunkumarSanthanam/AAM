<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section class="content " >
<div class="box box-info">
            <div class="box-header with-border dmt_head">
              <h3 class="box-title">Manage City</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form id="cityForm" role="form" class="form-horizontal">
              <input type="hidden" name="cityIDTemp" id="cityIDTemp">
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">City Code</label>

                  <div class="col-sm-10">
                    <input name="cityCode" id="cityCode" type="text" style="width: 50%" class="form-control" placeholder="City Code">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">City Name</label>

                  <div class="col-sm-10">
                    <input name="cityName" id="cityName" type="text" style="width: 50%" class="form-control" placeholder="City Name">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Description</label>

                  <div class="col-sm-10">
                    <textarea name="description" style="width: 50%"  class="form-control" id="description" placeholder="Description"></textarea>
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
              <button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px" type="button" onclick="saveCityDetails()"  class="btn btn-block btn-primary">Save</button>
					<button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px;margin-left: 5px" type="button" onclick="loadContent('City Details', 'citylist')" class="btn btn-block btn-primary">Close</button>
             
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
          <section class="content">
<script type="text/javascript">
$('.select2').select2();
function saveCityDetails(){
	$.ajax({
		url: "createcity", 
		data: $("#cityForm").serialize(),
		type: 'POST',
		success: function(result){
			if(result){
				swal("Success", "City Details Saved Successfully", "success")
			}
		}	    
	});
}
$( document ).ready(function() {
    $("#cityIDTemp").val(returnCurrentCityValue());
	if($("#cityIDTemp").val() != '0'){
		var cityID  = $("#cityIDTemp").val();
		$.ajax({
			url: "getcity", 
			data:{
				cityId : cityID
			},
			type: 'POST',
			success: function(result){
				console.log(result);
				$("#cityCode").val(result.cityCode);
				$("#cityName").val(result.cityName);
				$("#description").val(result.description);
			},error: function(result){
				alert()
			}	    
		});
	}
});
</script>
<script src="js/app/master-city.js"></script>
</body>
</html>