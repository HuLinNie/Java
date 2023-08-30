<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="shopping.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usic Without Borders Checkout</title>
<base href="<%=shopping.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<jsp:include page="_header.jsp" />
	<div class="body-content-height">
		<br/>
		<h1 style="text-align:center">${album.getName() }</h1>
		<table style="margin: 20px auto; width: 95%;">
			<tr>
				<th>唱片</th>
				<td>${album.getName() }</td>
			</tr>
			<tr>
				<th>艺术家</th>
				<td>${album.getArtist() }</td>
			</tr>
			<tr>
				<th>国家</th>
				<td>${album.getCountry()}</td>
			</tr>
			<tr>
				<th>价格</th>
				<td>${album.getPrice()}</td>
			</tr>
		</table>
		<div style=""><a href="home" class="ctrl-button center-block">返回首页</a></div>
	</div>
	<jsp:include page="_bottom.jsp" />
</body>
</html>