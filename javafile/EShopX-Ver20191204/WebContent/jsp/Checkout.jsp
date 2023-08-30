<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, shopping.bean.*,shopping.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usic Without Borders Checkout</title>
<base href="<%=BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<jsp:include page="_header.jsp" />
	<hr>
	<div style="width: 100%; min-height: 500px">
		<table style="margin: 0 auto;">
			<tr>
				<th><b>唱片</b></th>
				<th><b>演唱</b></th>
				<th><b>国家</b></th>
				<th><b>价格</b></th>
				<th><b>数量</b></th>
			</tr>
			<%Order o = shopping.util.RequestAttrHelper.getOrder(request);%>
			<%List<OrderItem> buylist = o.getItems();%>
			<%for (int i = 0; i < buylist.size(); i++) {%>
				<%OrderItem item = buylist.get(i);%>
				<%Album album = item.getAlbum(); %>
				<tr>
					<td><b><%=album.getName()%></b></td>
					<td><b><%=album.getArtist()%></b></td>
					<td><b><%=album.getCountry()%></b></td>
					<td><b><%=Numeric.toFixedDecimalString(album.getPrice(), 2)%></b></td>
					<td><b><%=item.getQuantity()%></b></td>
				</tr>
			<%}%>
			<tr>
				<td></td>
				<td></td>
				<td><b>合计</b></td>
				<td><b>￥<%=Numeric.toFixedDecimalString(o.getAmount(), 2)%></b></td>
				<td></td>
			</tr>
		</table>
		<a href="home" class="ctrl-button center-block" style="width:240px;">返回首页</a>
	</div>
	<jsp:include page="_bottom.jsp" />
</body>
</html>