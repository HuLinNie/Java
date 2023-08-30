<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.dao.*,web.dao.impl.*,web.service.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交订单</title>
<base href="<%=BasePath.get(request)%>" />
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
	<hr>
	<div style="width: 100%; min-height: 500px">
		<table style="margin: 0 auto;">
			<tr>
				<th><b>商品</b></th>
				<th><b>单价</b></th>
				<th><b>数量</b></th>
				<th><b>小计</b></th>
			</tr>
				<%Cart cart = web.util.RequestAttrHelper.getCartObject(request);%>
				<%Order order = web.util.RequestAttrHelper.getOrder(request);%>
				<%Customer cu = AuthHelper.getCustomerInfoBySession(session);%>
				<%IOrderDao dao = new OrderDaoImpl(); %>
				<%OrderItem ite = new OrderItem(cu.getId(),order.getId(),cart); %>
				<%dao.inser(ite); %>
				<%List<OrderItem> buylist = cart.getItems();%>
				<% double total =0;%>
				<%
					for(int idx = 0 ; idx < buylist.size(); idx++){
							OrderItem anOrder = buylist.get(idx);
							Commodity cd = anOrder.getCommodity();
							if(cd!=null){
				%>
						<tr><td>店铺：<%=cd.getName()%>商家</td></tr>
						<tr>
							<td><b><img class="sptp" src="<%=cd.getImage()%>"/></b></td>
							<td><b><%=Numeric.toFixedDecimalString(cd.getPrice(), 2)%></b></td>
							<td><b><%=anOrder.getQuantity()%></b></td>
							<td><b><%=Numeric.toFixedDecimalString(cd.getPrice()*anOrder.getQuantity(),2) %></b></td>
							<td><form name="deleteForm" action="CartServlet" method="POST"> 
									<input type="submit" value="取消订单"> 
									<input type="hidden" name="delindex" value='<%=idx%>'>
									<input type="hidden" name="oid" value='<%=order.getId() %>'>
									<input type="hidden" name="action" value="deorder">
								</form>
							</td>
						</tr>
						<% total=total+cd.getPrice()*anOrder.getQuantity();%>
					<%}%>
				<%}%>
				
			<tr>
				<th><b>订单号</b></th>
				<th><b>日期</b></th>
				<th><b>运费</b></th>
				<th><b>总计</b></th>
			</tr>	
			<tr>
					<%double x=5;%>
					<td><b><%=order.getId() %></b></td>
					<td><b><%=order.getDate() %></b></td>
					<td><b>￥<%=x%></b></td>
					<td><b><%=Numeric.toFixedDecimalString(order.getAmount()+x, 2) %></b></td>
				</tr>
		</table>
		<form name="payForm" action="PayServlet" method="POST">
				<input type="hidden" name="action" value="pay"> 
				<div class="form-item">
					<div class="form-ctrl" >
						<input type="submit" name="pay" value="支付" class="btn-green center-block" style="width:240px;background-color:orange;color:black;margin:5px auto;">
					</div>
				</div>
			</form>
	</div>
</body>
</html>