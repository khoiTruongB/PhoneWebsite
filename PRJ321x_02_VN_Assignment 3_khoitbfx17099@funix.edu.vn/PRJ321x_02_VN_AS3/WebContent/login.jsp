<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./css/style.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />

<title>Document</title>
</head>

<body>



	<div id="myModal" class="modal">
		<!-- Modal content -->
		<div class="modal-content">
			<div class="form-aria">
				<form action="LoginController" onsubmit="return validate()"
					class="login-form" method="post">



					<table class="table-from">
						<tr>
							<td><h1>Sign in</h1></td>

						</tr>
						<tr>
							<td><p style="color: red;">${message}</p></td>

						</tr>
						<tr>
							<td><input type="text" id="username" class="input-form"
								name="mail" placeholder="Nhập username" /></td>
						</tr>
						<tr>
							<td><input type="password" id="password" class="input-form"
								name="password" placeholder="Nhập password" /></td>
						</tr>
						<tr>
							<td>Remember me?<input name="remember" type="checkbox"></td>
						</tr>
						<tr>
							<td><a href="">Forgot your password?</a></td>

						</tr>
						<tr>
							<td><input type="submit" class="login-btn" value="Login" /></td>
						</tr>
					</table>
				</form>
			</div>

			<div class="welcome-aria">
				<h1>Welcome Back!</h1>
				<p>To keep connected with us please login with your personal
					info</p>
			</div>
		</div>
	</div>


</body>
<script src="./js/modal.js"></script>
<script src="./js/validator.js"></script>
</html>
