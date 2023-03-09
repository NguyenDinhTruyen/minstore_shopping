<%@page import="minstore_shopping.connection.DbCon"%>
<%@page import="java.util.*"%>
<%@page import="minstore_shopping.dao.ProductDao"%>
<%@page import="minstore_shopping.model.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
	request.setAttribute("auth", auth);
}

ProductDao pd = new ProductDao(DbCon.getConnetion());
List<Product> products = pd.getAllProducts();

if(request.getAttribute("products")!=null){
	products=(List<Product>)request.getAttribute("products");
}
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}

%>
<!DOCTYPE html>
<html>
<head>
<title>Welcome to Minstore!!!</title>
<%@include file="includes/head.jsp"%>

</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			
			if (!products.isEmpty()) {
				for (Product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
					<img class="card-img-top" src="product_images/<%=p.getImage()%>"
						alt="Hình ảnh cô gái mặc váy">
					<div class="card-body">
						<h5 class="card-title"><%=p.getName()%></h5>
						<h6 class="price">
							Price:
							<%= dcf.format(p.getPrice())%>VND
						</h6>
						<h6 class="category">
							Category:
							<%=p.getCategory()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="add-to-cart?id=<%=p.getId()%>" class="btn btn-dark">Add
								to Cart</a> <a href="order-now?quantity=1&id=<%=p.getId()%>"
								class="btn btn-primary">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			}
			%>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
	<footer class="py-5 bg-dark">
		<div style="text-align: center" class="footer-widget">
			<p class="m-0 text-center text-white">Copyright by MINSTORE
				&copy; Your Website 2022</p>
			<p class="m-0 text-center text-white">Chủ sở hữu Website: Nguyễn
				Đình Truyện - So: 41A8034825 - Ngày Cấp: 25/12/2002</p>
			<p class="m-0 text-center text-white">Liên hệ SDT: 0914.374.463</p>
			<p class="m-0 text-center text-white">Gmail:
				truyennguyendinh278@gmail.com</p>
			<iframe
				src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2FTi%25E1%25BB%2587m-c%25E1%25BB%25A7a-Min-112750010367677&tabs=timeline&width=300&height=70&small_header=false&adapt_container_width=true&hide_cover=false&show_facepile=true&appId"
				width="300" height="150" style="border: none; overflow: hidden;"
				scrolling="no" frameborder="0" allowfullscreen="true"
				allow="autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share">
			</iframe>
		</div>
	</footer>
</body>
</html>