<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="minstore_shopping.model.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Minstore Login</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Sign in</div>
			<div class="card-body">
			<p class="text-danger"></p>
				<form action="user-login" method="post">
					<div class="form-group">
						<label>Email Address</label> <input type="email"
							class="form-control" name="login-email"
							placeholder="Enter Your Email" required>
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="login-password" placeholder="*******"
							required>
					</div>


					<button type="submit" class="btn btn-success btn-block">
						<i class="fas fa-sign-in-alt"></i> Sign in
					</button>
					<hr>
				<br>
				</form>
			</div>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>