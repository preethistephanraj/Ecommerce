<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp" %> 
</head>
<body>
List of Products
<!-- for iteration - similar to for() in Java -->
<!-- productsAttr is a model attribute, to which we have assigned List<Product> -->
<!-- 
productsAttr -> 
p = 1 1000.0 Product Description for toy car Toy Car 12
2 1300.0 Product Description Book 2
 -->
 <table class="table table-striped">
 <thead><tr><th>ProductName</th><th>Price</th><th>Action</th></tr></thead>
 <tbody>
<c:forEach items="${productsAttr }" var="p">
<tr>
<!-- p.getProductName() -->    <!-- p.getPrice() -->
<td>${p.productname }</td><td>${p.price }</td><td></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>





