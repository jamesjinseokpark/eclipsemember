<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>회원정보 수정</title>

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
				<div class="card mb-1 py-1 border-bottom-danger">
					<div class="card-body">
						<p class="h4 text-gray-900 mb-1">회원정보 수정</p>
					</div>
				</div>

			</div>
			<br>
			<form action='update' method='post' class="user">
				<!-- 인스턴스명.프로퍼티(필드) -->
				<div class="form-group row">
					번호 <input type='text' name='no'
						class="form-control form-control-user" value='${member.mno }'
						readonly><br>
				</div>

				<div class="form-group row" align="center">
					이름 <input type='text' name='name'
						class="form-control form-control-user" value='${member.mname }'><br>
				</div>

				<div class="form-group row">
					이메일 <input type='text' name='email'
						class="form-control form-control-user" value='${member.email }'><br>
				</div>

				<div class="form-group row">
					패스워드 <input type='password' name='password'
						class="form-control form-control-user" value='${member.password }'><br>
				</div>

				<div class="form-group row">
					가입일 <input type='text' name='cre_date'
						class="form-control form-control-user" value='${member.cre_date }'
						readonly><br>
				</div>


				<input type='submit' value='수정'
					class="btn btn-success btn-icon-split"> <span
					class="icon text-white-50"> <i class="fas fa-check"></i>
				</span> <input type='button'
					onclick='location.href=\"delete?no=${member.mno }"\' value='삭제'
					class="btn btn-warning btn-icon-split"> <span
					class="icon text-white-50"> <i class="fas fa-check"></i>
				</span> <input type='reset' value='취소'
					class="btn btn-danger btn-icon-split"> <span
					class="icon text-white-50"> <i class="fas fa-check"></i></span>
			</form>

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