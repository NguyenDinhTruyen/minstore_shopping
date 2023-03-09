<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="minstore_shopping.dao.ProductDao"%>
<%@page import="minstore_shopping.connection.DbCon"%>
<%@page import="java.util.*"%>
<%@page import="minstore_shopping.model.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
ProductDao pd = new ProductDao(DbCon.getConnetion());
List<Product> products = pd.getAllProducts();

if (request.getAttribute("products") != null) {
	products = (List<Product>) request.getAttribute("products");
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ADD-EDIT-DELETE</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/manager.css" rel="stylesheet" type="text/css" />
<style>
img {
	width: 100px;
	height: 150px;
}
</style>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Manager <b>Product</b>
						</h2>
					</div>
					 <div style="text-align: right" class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons"></i> 
							<span>Add New Product</span>
						</a> 
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Category</th>
						<th>Image</th>
						<th>Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<%
					if (!products.isEmpty()) {
						for (Product p : products) {
					%>
					<tr>
						<td><%=p.getId()%></td>
						<td><%=p.getName()%></td>
						<td><%=p.getCategory()%></td>
						<td><img src="product_images/<%=p.getImage()%>"></td>
						<td><%=dcf.format(p.getPrice())%>VND</td>
						<td><a href="loadProduct?pid=<%=p.getId()%>" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i> </a> 
						<a href="delete?pid=<%=p.getId()%>" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
		</div>
		<a href="index.jsp"><button type="button" class="btn btn-primary">Back to home</button></a>
	</div>
	<!-- Edit Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="AddProduct" method="get">
					<div class="modal-header">
						<h4 class="modal-title">Add Product</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Name</label> <input name="name" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Category</label> <select name="category"
								class="form-select" aria-label="Default select example">
								<%
								if (!products.isEmpty()) {
									for (Product p : products) {
								%>
								<option><%=p.getCategory()%></option>
								<%
								}
								}
								%>
							</select>
						</div>
						<div class="form-group"><label>Price</label> 
							<input name="price" type="text" class="form-control" required>
						</div>
						<div class="form-group"><label>Image</label> 
							<input name="image" type="text" class="form-control" required>
						</div>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-success" data-dismiss="modal" value="Cancel"> 
						<input type="submit" class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>