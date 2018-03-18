<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/style.css">
</head>
<body>
	<h2>List of available products</h2>
	<!-- div for apply styling to table -->
	<div class="datagrid">
		<table>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Cost($)</th>
				<th>Operations</th>
			</tr>
			<!-- loop over and print our customers -->
			<c:forEach var="product" items="${products }">
				<tr>
					<td>${product.productID } </td>
					<td>${product.productName }</td>
					<td>${product.cost}</td>
					<td><a href="${pageContext.request.contextPath}/updateProductForm/?id=${product.productID }">Update</a>|
					<a href="${pageContext.request.contextPath}/deleteProduct/?id=${product.productID }" onclick="if(!(confirm('Are you sure to delete the Product?')))return false">Delete</a>  </td>
				</tr>
				
			</c:forEach>
		</table>
		<p/>
		<input type="button" value="Add Poduct" onclick="window.location.href='addProductForm'; return false;">
	
	</div>

</body>
</html>