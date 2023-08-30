<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page session="true" import="shopping.util.*,java.util.*, shopping.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>音乐无界</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<jsp:include page="_header.jsp" />
	<div id="oitemlist" style="min-height:700px;margin:10px 5px;">
		<div style="margin:0 auto;width:90%;">
			<table>
				<tr>
					<th><b>唱片</b></th>
					<th><b>演唱</b></th>
					<th><b>国家</b></th>
					<th><b>价格</b></th>
					<th><b>数量</b></th>
					<th></th>
				</tr>
				<%Cart cart = shopping.util.RequestAttrHelper.getCartObject(request);%>
				<%List<OrderItem> buylist = cart.getItems();%>
				<%for(int idx = 0 ; idx < buylist.size(); idx++){
					OrderItem anOrder = buylist.get(idx);
					Album cd = anOrder.getAlbum();
					if(cd!=null){%>
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
						<input type="submit" name="Checkout" value="Checkout" class="btn-green center-block" style="width:240px;background-color:orange;color:black;margin:5px auto;">
					</div>
				</div>
			</form>
		</div>
		<a href="" class="ctrl-button center-block" style="width:240px;">返回首页</a>
	</div>
	<jsp:include page="_bottom.jsp" />
</body>
</html>