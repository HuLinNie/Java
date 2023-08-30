<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, java.io.*,web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>山海关大樱桃详情页</title>
<base href="<%=web.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<style type="text/css">
	.p-image img{
	width:120px;
	height:120px;
	margin-left:35%;}
	
	.weizhi{
	height:350px;
	overflow:hidden;
	float:left;
	margin-left:50px;}
	#weizhi1{
	margin-left:20%;
	}
	
	
</style>
</head>
<body>
<jsp:include page="../template/_header.jsp" /> 
							<%List<Commodity> cdlist= web.util.RequestAttrHelper.getCommodity(request); %>
	 						<%for (int i=0;i<cdlist.size();i++){ %>
	 						<%	Commodity cd = cdlist.get(i); %>
	 						<div class="weizhi">
                              <div class="p-image"><img src="<%=cd.getImage()%>" /></div>    
                                  	 <div class="head" id="weizhi1"><%=cd.getName() %> <%=cd.getPrice()%>/kg
                                  	 	<a class="person" id="toCart" href="CartServlet?action=add&id=<%=cd.getId()%>">加入购物车</a>
                                  	 </div>                 
                                <table>
                                <tr><th>商品</th>
                                <th>累计评价</th>
                                </tr>
                                
                                <% String nam = cd.getName();%>
                                <%ICommentDao dao1= new CommentDaoImpl();List<Comment> cdlist1=dao1.load(nam); %>
                                <%for (int j = 0; j < cdlist1.size(); j++) {%>
				                <%Comment order = cdlist1.get(j);%>
				                <tr><th><%=order.getCname() %></th>
				                <td><%=order.getCitem() %></td>
				                </tr>
				                <% }%>
				                 </table>
				                 </div>
                                  <%} %> 
                                
</body>
</html>