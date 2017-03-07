<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		
		//$("#record_table").load("./register")
	
  $.ajax({
		type : "post",
		url : './register',
		data : {
			purpose : 'table_data'
		},
		success : function(data) {
			response = $.parseJSON(data);
			var trHTML='';
			$(function() {
				$.each(response, function(i, item) {

					trHTML = trHTML+'<tr><td>' + item.FirstName + '</td><td>' + item.LastName + '</td><td>' + item.Email + '</td><td>' + item.Password + '</td><td>' + item.Repassword + '</td><td>' + item.Country + '</td><td>' + item.Gender + '</td><td><button id="delete" type="button" onclick="deleterow(' + item.FirstName + ')" class="btn btn-primary btn-block">Delete</button></td></tr>';
					
				});
				 $('#record_table').append(trHTML);
			});

		}
	}); 
		
		$("#repassword").blur(function() {
			var password = $("#password").val();
			var rePassword = $("#repassword").val();
			if (password != rePassword) {
				alert("Passwords do not match");
				
			} else {
				alert("Passwords match");
				
			}
		});
		
			
		$("#register").click(function() {
			$.ajax({
				type : "post",
				url : './register',
				data : {
					purpose : 'register',
					firstName : $("#firstName").val(),
					lastName : $("#lastName").val(),
					email : $("#email").val(),
					password : $("#password").val(),
					repassword : $("#repassword").val(),
					country : $("#country").val(),
					gender : $("#gender").val()
				},
				success : function(data) {
					alert("Registration Successfully Done")
				}
			});
		});
		
		function deleterow(FirstName)
		{
			$.ajax({
			
				type : "post",
				url : './register',
				data : {
					purpose : 'delete',
						firstName : FirstName
						},
					
						success : function(data)
						{
							alert("Record Deleted")
						}
			});	
		}
	});
</script>
<body>

	<div class="container" >
<div class="col-md-6">
		<h2>User Registration</h2>
		<div class="form-group">
			<label for="firstName" class="col-sm-3 control-label">Fisrt Name</label>
			<div class="col-sm-4">
				<input type="text" id="firstName" placeholder="First Name" class="form-control" autofocus>
			</div>
		</div>
		<div class="form-group">
			<label for="lastName" class="col-sm-3 control-label">Last Name</label>
			<div class="col-sm-4">
				<input type="text" id="lastName" placeholder="last Name" class="form-control" autofocus>
			</div>

		</div>

		<div class="form-group">
			<label for="email" class="col-sm-3 control-label">Email</label>
			<div class="col-sm-4">
				<input type="email" id="email" placeholder="Email" class="form-control">
			</div>
		</div>

		<div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Password</label>
				<div class="col-sm-4">
					<input type="password" id="password" placeholder="Password" class="form-control">
				</div>
			</div>
		</div>

		<div>
			<div class="form-group">
				<label for="repassword" class="col-sm-3 control-label">ReEnter Password</label>
				<div class="col-sm-4">
					<input type="password" id="repassword" placeholder="RePassword" class="form-control">
				</div>
			</div>
		</div>


		<div class="form-group">
			<label for="country" class="col-sm-3 control-label">Country</label>
			<div class="col-sm-4">
				<select id="country" class="form-control">
					<option>India</option>
					<option>U.S.</option>
					<option>ShriLanka</option>
				</select>
			</div>
		</div>

		<div class="form-group">
			<label for="gender" class="col-sm-3 control-label">Gender</label>
			<div class="col-sm-4">
				<select id="gender" class="form-control">
					<option>Male</option>
					<option>Female</option>
					<option>Other</option>
				</select>
			</div>
		</div>
		<br>

		<div class="row" style="padding: 10px;">
			<div class="form-group">
				<input id="register" name="save" placeholder="" class="btn btn-success" type="submit" value="save"> <input id="cancel" name="cancel" placeholder="" class="btn btn-danger" type="reset" value="Reset">
			</div>
		</div>
		<br>
</div>
		<div>
			<table class="table" border="1" id="record_table">
			</table>
		</div>
	</div>

</body>
</html>