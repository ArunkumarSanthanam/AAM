<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
  <!-- Content Wrapper. Contains page content -->
    <!-- Content Header (Page header) -->
    <section class="content-header dmt_head">
      <h1>
        Invoice Details
      </h1>
<!--       <button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px" type="button" onclick="loadContent('Sale Order Details', 'saleorderform')" class="btn btn-block btn-primary">Create</button>
 -->    </section>

    <!-- Main content -->
      <div class="row">
        <div class="col-xs-12">
          <!-- /.box -->

          <div class="box">
            <div style="float: right;" class="box-header">
            	    <label class="switch">
    	<input class="switch-input"  id="status" type="checkbox" checked="checked" />
    	<span class="switch-label" data-on="Un-Billed" data-off="Billed"></span> 
    	<span class="switch-handle"></span> 
    </label>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="saleOrderDetailsDT" class="table table-bordered table-striped" style="width: 100%">
                <thead>
                <tr>
                  <th></th>
                  <th>Sale Order Number</th>
                  <th>Customer Name</th>
                  <th>GST Amount</th>
                  <th>Total Amount</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
                <tfoot>
                <tr>
                  <th></th>
                  <th>Sale Order Number</th>
                  <th>Customer Name</th>
                  <th>GST Amount</th>
                  <th>Total Amount</th>
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
<script>
  $(function () {
		var status = "";
	  if($("#status"). prop("checked") == true){
	  	status = "UNBILLED";
	  }else{
		  status = "BILLED";
	  }
	  loadInvoiceDetails(status);
    $('#example1').DataTable()
    $('#example2').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
  })
  
 $('#status').change(function() {
	 if($("#status"). prop("checked") == true){
		  	status = "UNBILLED";
		  }else{
			  status = "BILLED";
		  }
		  loadInvoiceDetails(status);
}) 
</script>
<script src="js/app/master-invoice-list.js"></script>
</body>
</html>