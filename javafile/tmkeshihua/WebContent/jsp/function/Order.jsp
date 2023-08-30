<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.service.*,web.dao.*,web.dao.impl.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有订单</title>
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
				
				<th><b>日期</b></th>
				<th><b>订单号</b></th>
				<th><b>总价</b></th>
			</tr>
			<%Customer cu = AuthHelper.getCustomerInfoBySession(session); %>
			<%int customerid=cu.getId(); %>
			<%IOrderDao  idao = new  OrderDaoImpl(); %>
			<%List<Order> orderlist = idao.loadByCustomer(customerid); %>
			<tr><td><b>我的ID：<%=customerid%></b></td></tr>
			<%for (int i = 0; i < orderlist.size(); i++) {%>
				<%Order order = orderlist.get(i);%>
				<tr>
					
					<td><b><%=order.getDate()%></b></td>
					<td><b><%=order.getId()%></b></td>
					<td><b><%=Numeric.toFixedDecimalString(order.getAmount(), 2)%></b></td>	
				</tr>
					<%String oid1 = order.getId(); %>
					<%Cart cart = idao.load1(oid1);%>
					<%List<OrderItem> buylist = cart.getItems();%>
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
						</tr>
						
					<%}%>
				<%}%>
			<%}%>
		</table>
	</div>
</body>
</html>