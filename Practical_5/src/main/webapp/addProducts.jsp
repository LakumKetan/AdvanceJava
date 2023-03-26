
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="connection.DbCon"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<title>Add Product</title>
</head>
<body >
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">E-Commerce Cart</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart</a></li>
			    <li class="nav-item"><a class="nav-link" href="addProducts.jsp">Add Products</a></li>
			</ul>
		</div>
	</div>
</nav>

<div class="container">

<h1>Add Product to Database</h1>

    <form method="post" action="AddProduct">
<div class="form-floating mb-3">
  <label for="floatingInput"> Product Id</label>
  <input type="number" name="id" class="form-control" required >

</div>
<div class="form-floating">
  <label>Product Name</label>
  <input type="text" class="form-control" name="name" required>
</div>

<div class="form-floating mb-3">
  <label> Product Category</label>
  <input type="text" class="form-control" name="category" required>

</div>
<div class="form-floating">
  <label>Product Price</label>
  <input type="password" class="form-control" name="price" required>
</div>

<div class="form-floating mb-3">
  <label> Product Image link</label>
  <input type="text" class="form-control" name="image" required>

</div>
  <div class="col-12">
    <button type="submit" class="btn btn-primary">Add to Database</button>
  </div>
</form>
</div>

</body>
</html>