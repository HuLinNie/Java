<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.Product" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/form.css"/>
	<title>修改商品</title>
</head>
<body>
	<%
	Product product = (Product)request.getAttribute("product");
	%>
	<%=product.getNumber() %>
	<%=product.getName() %>
	<%=product.getPrice() %>
	<%=product.getKind() %>
	
	//System.out.println(product);
	
	<div class=div>
		<form action="UpdateProductServlet">
			编号<input type="text" name="number" value="<%=product.getNumber() %>" readonly="readonly" style="margin-top:20px"/><br/>
			名称<input type="text" name="name" value="<%=product.getName() %>"/><br/>
			价格<input type="text" name="price" value="<%=product.getPrice() %>"/><br/>
			规格<input type="text" name="kind" value="<%=product.getKind() %>"/><br/>
			<input type="submit" value="确认修改"/>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
			<a href="QueryAllProductsServlet" style="color:black;">返回</a>
			<br/>
		</form>
	</div>
</body>
</html>