<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>usic Without Borders Checkout</title>
<base href="<%=BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
</head>
<body>
	<jsp:include page="_header.jsp" />
	<hr>
	<div style="width: 100%; min-height: 500px">
		<table style="margin: 0 auto;">
			<tr>
				<th><b>商品</b></th>
				<th><b>商家</b></th>
				<th><b>优惠</b></th>
				<th><b>价格</b></th>
				<th><b>数量</b></th>
			</tr>
			<%Order o = web.util.RequestAttrHelper.getOrder(request);%>
			<%List<OrderItem> buylist = o.getItems();%>
			<%for (int i = 0; i < buylist.size(); i++) {%>
				<%OrderItem item = buylist.get(i);%>
				<%
					Commodity album = item.getAlbum();
				%>
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
		<form name="payForm" action="PayServlet" method="POST">
				<input type="hidden" name="action" value="pay"> 
				<div class="form-item">
					<div class="form-ctrlo" >
						<input type="submit" name="pay" value="支付" class="btn-green center-block" style="width:240px;background-color:orange;color:black;margin:5px auto;">
					</div>
				</div>
			</form>
		<p class="order-p">
			<a href ="ChatServlet?action=chat">官方客服</a>
			<a href ="tencent://message/?Menu=yes&uin=3161109788&site=在线客服&Service=200&sigT=2a0e37386280486ada2b5d5e69ee49186ccae1257fd9e1c9598af1f0b9c916067002a57aaaec8c8d" target="_blank">在线客服</a>
			<a href="home" class="ctrl-button center-block" style="width:240px;">返回首页</a>
		</p>
	</div>
			
	<jsp:include page="_bottom.jsp" />
</body>
</html>