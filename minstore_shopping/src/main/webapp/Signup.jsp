<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="minstore_shopping.model.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Minstore Sign up</title>
<%@include file="includes/head.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Sign up</div>
			<div class="card-body">
				<form action="sign-up" method="post" class="form-signup">
					<input name="user" type="text" id="user-name" class="form-control"
						placeholder="Full name" required="" autofocus=""> </br> 
					<input name="email" type="email" id="user-email" class="form-control"
						placeholder="Email address" required autofocus=""> </br> 
					<input name="pass" type="password" id="user-pass" class="form-control"
						placeholder="Password" required autofocus=""> </br>
					<input name="pass1" type="password" id="user-pass1" class="form-control"
						placeholder="Retype password" required autofocus=""> </br>

					<button class="btn btn-primary btn-block" type="submit">
						<i class="fas fa-user-plus"></i> Sign Up
					</button>
				</form>
				<br>
			</div>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>