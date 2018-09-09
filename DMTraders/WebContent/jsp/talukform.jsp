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
              <h3 class="box-title">Manage Taluk</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form id="talukForm" role="form" class="form-horizontal">
              <input type="hidden" name="talukIDTemp" id="talukIDTemp">
              <div class="box-body">
                <div class="form-group">
                  <label for="inputEmail3" class="col-sm-2 control-label">Taluk Code</label>

                  <div class="col-sm-10">
                    <input name="talukCode" id="talukCode" type="text" style="width: 50%" class="form-control" placeholder="Taluk Name">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Taluk Name</label>

                  <div class="col-sm-10">
                    <input name="talukName" id="talukName" type="text" style="width: 50%" class="form-control" placeholder="Taluk Name">
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputPassword3" class="col-sm-2 control-label">Description</label>

                  <div class="col-sm-10">
                    <textarea name="talukDescription" style="width: 50%"  class="form-control" id="talukDescription" placeholder="Description"></textarea>
                  </div>
                </div>
              </div>
              <!-- /.box-body -->
              <div class="box-footer">
              <button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px" type="button" onclick="saveTalukDetails()"  class="btn btn-block btn-primary">Save</button>
					<button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px;margin-left: 5px" type="button" onclick="loadContent('Taluk Details', 'taluklist')" class="btn btn-block btn-primary">Close</button>
             
              </div>
              <!-- /.box-footer -->
            </form>
          </div>
          <section class="content">
<script type="text/javascript">
$('.select2').select2();
function saveTalukDetails(){
	$.ajax({
		url: "createtaluk", 
		data: $("#talukForm").serialize(),
		type: 'POST',
		success: function(result){
			if(result){
				swal("Success", "Taluk Details Saved Successfully", "success")
			}
		}	    
	});
}
$( document ).ready(function() {
    $("#talukIDTemp").val(returnCurrentTalukValue());
	if($("#talukIDTemp").val() != '0'){
		var talukId  = $("#talukIDTemp").val();
		$.ajax({
			url: "gettaluk", 
			data:{
				talukId : talukId
			},
			type: 'POST',
			success: function(result){
				console.log(result);
				$("#talukCode").val(result.talukCode);
				$("#talukName").val(result.talukName);
				$("#talukDescription").val(result.talukDescription);
			},error: function(result){
				alert()
			}	    
		});
	}
});
</script>
<script src="js/app/master-taluk.js"></script>
</body>
</html>