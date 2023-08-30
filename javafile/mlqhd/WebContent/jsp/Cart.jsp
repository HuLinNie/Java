<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page session="true" import="web.util.*,java.util.*, web.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>魅力秦皇岛</title>
<link rel="stylesheet" type="text/css" href="css/header.css" />
</head>
<body>
	<jsp:include page="_header.jsp" />
	<div id="oitemlist" style="min-height:300px;margin:0 auto;position:relative;left:160px;">
		<div style="margin:0 auto;width:90%;">
			<table>
				<tr>
					<th><b>商品</b></th>
					<th><b>商家</b></th>
					<th><b>优惠活动</b></th>
					<th><b>价格</b></th>
					<th><b>数量</b></th>
					<th></th>
				</tr>
				<%Cart cart = web.util.RequestAttrHelper.getCartObject(request);%>
				<%List<OrderItem> buylist = cart.getItems();%>
				<%
					for(int idx = 0 ; idx < buylist.size(); idx++){
							OrderItem anOrder = buylist.get(idx);
							Commodity cd = anOrder.getAlbum();
							if(cd!=null){
				%>
						<tr>
							<td><b><%=cd.getName()%></b></td>
							<td><b><%=cd.getArtist()%></b></td>
							<td><b><%=cd.getCountry()%></b></td>
							<td><b><%=Numeric.toFixedDecimalString(cd.getPrice(), 2)%></b></td>
							<td><b><%=anOrder.getQuantity()%></b></td>
							<td><form name="deleteForm" action="CartServlet" method="POST">
									<input type="submit" value="Delete"> 
									<input type="hidden" name="delindex" value='<%=idx%>'> 
									<input type="hidden" name="action" value="Delete">
								</form>
							</td>
						</tr>
					<%}%>
				<%}%>
			</table>
			<form name="checkoutForm" action="CartServlet" method="POST">
				<input type="hidden" name="action" value="Checkout"> 
				<div class="form-item">
					<div class="form-ctrl" >
						<input type="submit" name="Checkout" value="提交订单" class="btn-green center-block" style="width:240px;background-color:orange;color:black;margin:5px auto;">
					</div>
				</div>
			</form>
		</div>
		<p class="Cart-p"><a href="" class="ctrl-button center-block">返回首页</a></p>
	</div>
	<jsp:include page="_bottom.jsp" />
</body>
</html>