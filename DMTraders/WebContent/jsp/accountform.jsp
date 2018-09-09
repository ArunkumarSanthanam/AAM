<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Data Tables</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <!-- <link rel="stylesheet" href="../../bower_components/bootstrap/dist/css/bootstrap.min.css">
  Font Awesome
  <link rel="stylesheet" href="../../bower_components/font-awesome/css/font-awesome.min.css">
  Ionicons
  <link rel="stylesheet" href="../../bower_components/Ionicons/css/ionicons.min.css">
  DataTables
  <link rel="stylesheet" href="../../bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  Theme style
  <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
  AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load.
  <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css"> -->

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<section class="content">
<div class="box box-default">
        <div class="box-header with-border">
        </div>
	<div class="box-body">
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label>Minimal</label> <select class="form-control select2"
						style="width: 100%;">
						<option selected="selected">Alabama</option>
						<option>Alaska</option>
						<option>California</option>
						<option>Delaware</option>
						<option>Tennessee</option>
						<option>Texas</option>
						<option>Washington</option>
					</select>
				</div>
				<!-- /.form-group -->
				<div class="form-group">
					<label>Disabled</label> <select class="form-control select2"
						disabled="disabled" style="width: 100%;">
						<option selected="selected">Alabama</option>
						<option>Alaska</option>
						<option>California</option>
						<option>Delaware</option>
						<option>Tennessee</option>
						<option>Texas</option>
						<option>Washington</option>
					</select>
				</div>
				<!-- /.form-group -->
			</div>
			<!-- /.col -->
			<div class="col-md-6">
				<div class="form-group">
					<label>Multiple</label> <select class="form-control select2"
						multiple="multiple" data-placeholder="Select a State"
						style="width: 100%;">
						<option>Alabama</option>
						<option>Alaska</option>
						<option>California</option>
						<option>Delaware</option>
						<option>Tennessee</option>
						<option>Texas</option>
						<option>Washington</option>
					</select>
				</div>
				<!-- /.form-group -->
				<div class="form-group">
					<label>Disabled Result</label> <select class="form-control select2"
						style="width: 100%;">
						<option selected="selected">Alabama</option>
						<option>Alaska</option>
						<option disabled="disabled">California (disabled)</option>
						<option>Delaware</option>
						<option>Tennessee</option>
						<option>Texas</option>
						<option>Washington</option>
					</select>
				</div>
				<!-- /.form-group -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
		<button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px" type="button"  class="btn btn-block btn-primary">Save</button>
		<button style="float: left;width: 100px;margin-top: 5px;margin-bottom: 5px;margin-left: 5px" type="button" onclick="loadContent('Account Detail', 'accountlist')" class="btn btn-block btn-primary">Close</button>
		
	</div>
</div>
</section>
<script>
		$(function() {
			//Initialize Select2 Elements
			$('.select2').select2()

			//Datemask dd/mm/yyyy
			$('#datemask').inputmask('dd/mm/yyyy', {
				'placeholder' : 'dd/mm/yyyy'
			})
			//Datemask2 mm/dd/yyyy
			$('#datemask2').inputmask('mm/dd/yyyy', {
				'placeholder' : 'mm/dd/yyyy'
			})
			//Money Euro
			$('[data-mask]').inputmask()

			//Date range picker
			$('#reservation').daterangepicker()
			//Date range picker with time picker
			$('#reservationtime').daterangepicker({
				timePicker : true,
				timePickerIncrement : 30,
				format : 'MM/DD/YYYY h:mm A'
			})
			//Date range as a button
			$('#daterange-btn').daterangepicker(
					{
						ranges : {
							'Today' : [ moment(), moment() ],
							'Yesterday' : [ moment().subtract(1, 'days'),
									moment().subtract(1, 'days') ],
							'Last 7 Days' : [ moment().subtract(6, 'days'),
									moment() ],
							'Last 30 Days' : [ moment().subtract(29, 'days'),
									moment() ],
							'This Month' : [ moment().startOf('month'),
									moment().endOf('month') ],
							'Last Month' : [
									moment().subtract(1, 'month').startOf(
											'month'),
									moment().subtract(1, 'month')
											.endOf('month') ]
						},
						startDate : moment().subtract(29, 'days'),
						endDate : moment()
					},
					function(start, end) {
						$('#daterange-btn span').html(
								start.format('MMMM D, YYYY') + ' - '
										+ end.format('MMMM D, YYYY'))
					})

			//Date picker
			$('#datepicker').datepicker({
				autoclose : true
			})

			//iCheck for checkbox and radio inputs
			$('input[type="checkbox"].minimal, input[type="radio"].minimal')
					.iCheck({
						checkboxClass : 'icheckbox_minimal-blue',
						radioClass : 'iradio_minimal-blue'
					})
			//Red color scheme for iCheck
			$(
					'input[type="checkbox"].minimal-red, input[type="radio"].minimal-red')
					.iCheck({
						checkboxClass : 'icheckbox_minimal-red',
						radioClass : 'iradio_minimal-red'
					})
			//Flat red color scheme for iCheck
			$('input[type="checkbox"].flat-red, input[type="radio"].flat-red')
					.iCheck({
						checkboxClass : 'icheckbox_flat-green',
						radioClass : 'iradio_flat-green'
					})

			//Colorpicker
			$('.my-colorpicker1').colorpicker()
			//color picker with addon
			$('.my-colorpicker2').colorpicker()

			//Timepicker
			$('.timepicker').timepicker({
				showInputs : false
			})
		})
	</script>
</body>
</html>
