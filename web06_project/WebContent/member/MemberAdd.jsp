<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>회원 추가</title>
<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">

		<div class="p-5">
			<div class="text-center">
			<div class="card mb-1 py-1 border-bottom-primary">
                <div class="card-body">
                 <p class="h4 text-gray-900 mb-1">회원정보 수정</p>
                </div>
              </div>
			</div>
			<form action="add" method="post" class="user">
				<div class="form-group row">
					
						<input type="text" name="name" class="form-control form-control-user"
							id="exampleFirstName" placeholder="Name">
					</div>
				
				<div class="form-group">
					
						<input type="email" name="email" class="form-control form-control-user"
							id="exampleInputEmail" placeholder="Email Address">
				
				</div>
				<div class="form-group row">
					
						<input type="password" name="password" class="form-control form-control-user"
							id="exampleInputPassword" placeholder="Password">
				

				</div>
				<input type='submit' value='추가' class="btn btn-primary btn-user btn-block">
				
				<hr>
				<a href="list" class="btn btn-primary btn-user btn-block">
					list로 돌아가기 </a>
				<hr>
				
			</form>
			<hr>
			<div class="text-center">
				<a class="small" href="forgot-password.html">Forgot Password?</a>
			</div>
			<div class="text-center">
				<a class="small" href="login.html">Already have an account?
					Login!</a>
			</div>
		</div>



	</div>


<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/chart-area-demo.js"></script>
	<script src="js/demo/chart-pie-demo.js"></script>


</body>
</html>