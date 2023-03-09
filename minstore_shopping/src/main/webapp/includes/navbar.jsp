<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp" title="Đây là tên Shop"><img
			src="product_images/logo.png" class="logo" alt="ảnh lỗi"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>


		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto"> 
				<%
				//search
				%>
				<form action="search" method="post" class="form-inline my-2 my-lg-0">
					<div class="input-group input-group-sm">
						<input name="txt" type="text" class="form-control"
							aria-label="Small" aria-describedby="inputGroup-sizing-sm"
							placeholder="Search" />
						<div class="input-group-append">
							<button type="submit">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</div>
				</form>
				
				<c:if test="${sessionScope.auth != null}">
					<li class="nav-item active"><a class="nav-link"
						href="index.jsp" title="Trang chủ">Home</a></li>
				</c:if>
				
				<c:if test="${sessionScope.auth != null}">
					<li class="nav-item"><a class="nav-link" href="cart.jsp"
						title="Đây là giỏ hàng">Cart<span
							class="badge badge-danger px-1">${ cart_list.size()}</span></a></li>
				</c:if>
				
				<c:if test="${sessionScope.auth.isAdmin == 1}">
					<li class="nav-item"><a class="nav-link" href="manager-product">Manager Product</a></li>
				</c:if>
				
				<c:if test="${sessionScope.auth != null}">
					<li class="nav-item"><a class="nav-link" href="orders.jsp"
						title="Đặt hàng tại đây">Orders</a></li>
				</c:if>
				

				<c:if test="${sessionScope.auth != null}">
					<li class="nav-item"><a class="nav-link" href="log-out" title="Đăng xuất">Logout</a>
					</li>
				</c:if>
				
				
				<c:if test="${sessionScope.auth == null}">
					<li class="nav-item"><a class="nav-link" href="login.jsp"
						title="Đăng nhập">Login</a></li>
				</c:if>		

				<c:if test="${sessionScope.auth == null}">
				<li class="nav-item"><a class="nav-link" href="Signup.jsp"
					title="Đăng ký">Signup</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>