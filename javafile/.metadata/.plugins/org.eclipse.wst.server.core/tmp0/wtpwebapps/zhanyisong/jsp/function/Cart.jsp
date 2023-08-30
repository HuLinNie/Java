<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page session="true" import="web.util.*,java.util.*, web.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="css/header.css" />
<style>
	.sptp{width:80x;
	height:80px;}
	.total{
	margin-left:35%;
	height:20px;}
</style>
</head>
<body>
	<jsp:include page="../template/_header.jsp" />
	<div id="oitemlist" style="min-height:300px;margin:0 auto;position:relative;left:160px;">
		<div style="margin:0 auto;width:90%;">
			<table>
				<tr>
					<th><b></b></th>
					<th><b>商品</b></th>
					<th><b>单价</b></th>
					<th><b>数量</b></th>
					<th><b>价格</b></th>
					<th><b>删除</b></th>
				</tr>
				<%Cart cart = web.util.RequestAttrHelper.getCartObject(request);%>
				<%List<OrderItem> buylist = cart.getItems();%>
				<% double total =0;%>
				<%
					for(int idx = 0 ; idx < buylist.size(); idx++){
							OrderItem anOrder = buylist.get(idx);
							Commodity cd = anOrder.getCommodity();
							if(cd!=null){
				%>
						<tr>
							<td><b><img class="sptp" src="<%=cd.getImage()%>"/></b></td>
							<td><b><%=cd.getName()%></b></td>
							<td><b><%=Numeric.toFixedDecimalString(cd.getPrice(), 2)%></b></td>
							<td><b><%=anOrder.getQuantity()%></b></td>
							<td><b><%=Numeric.toFixedDecimalString(cd.getPrice()*anOrder.getQuantity(),2) %></b></td>
							<td><form name="deleteForm" action="CartServlet" method="POST"> 
									<input type="submit" value="Delete"> 
									<input type="hidden" name="delindex" value='<%=idx%>'> 
									<input type="hidden" name="action" value="Delete">
								</form>
							</td>
						</tr>
						<% total=total+cd.getPrice()*anOrder.getQuantity();%>
					<%}%>
				<%}%>
			</table>
			<div class="total">合计￥<%=total %></div>
			<form name="checkoutForm" action="CartServlet" method="POST">
				<input type="hidden" name="action" value="Checkout"> 
				<div class="form-item">
					<div class="form-ctrl" >
						<input type="submit" name="Checkout" value="去结算" class="btn-green center-block" style="width:240px;background-color:orange;color:black;margin:5px auto;">
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../template/_bottom.jsp" />
</body>
</html>