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
    <section class="dmt_head content-header">
      <h1>
        Discount Details
      </h1>
      <button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px" type="button" onclick="loadContent('Discount Details', 'discountform')" class="btn btn-block btn-primary">Create</button>
    </section>

    <!-- Main content -->
      <div class="row">
        <div class="col-xs-12">
          <!-- /.box -->

          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Data Table With Full Features</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="discountTable" class="table table-bordered table-striped" style="width: 100%">
                <thead>
                <tr>
                  <th></th>
                  <th>Customer Name</th>
                  <th>Customer Code</th>
                  <th>Product Name</th>
                  <th>Discount</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
                <tfoot>
                <tr>
                  <th></th>
                  <th>Customer Name</th>
                  <th>Customer Code</th>
                  <th>Product Name</th>
                  <th>Discount</th>
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
	populateDiscountDataTable();
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
</script>
<script src="js/app/master-discount.js"></script>
</body>
</html>