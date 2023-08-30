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
	width:360px;
	height:360px;
	border-radius:20px;}
	
	.weizhi{
	margin-left:35%;}
	.weizhi .head{
	margin-left:12%;
	}
	table{
	margin-left:2%;
	}
</style>
</head>
<body>
<jsp:include page="../template/_header.jsp" /> 
	 			<div class="weizhi">
     						<% Commodity cd = web.util.RequestAttrHelper.getCommodityByName(request);%>
                              <div class="p-image"><img src="<%=cd.getImage() %>" /></div>    
                                  	 <div class="head"><%=cd.getName()%>   <%=cd.getPrice()%> /kg
                                  	 	<a class="person" id="toCart" href="CartServlet?action=add&id=<%=cd.getId() %>">加入购物车</a>
                                  	 </div>                  
                                 <form action="CommentServlet" method="post">
                                 	评价商品<input type="text" name="pjsp" />
                                 	 评价服务<input type="text" name="pjfw" />
                                   <input type="hidden" name="cname" value="<%=cd.getName()%>"/>
                                    <input type="hidden" name="action" value="showcomment"/>
                                  <input type="submit" name="submit" value="提交评价"/>
                                 </form>
                                
                        		<%String nam = cd.getName(); %>
                                <%ICommentDao dao1= new CommentDaoImpl();List<Comment> cdlist=dao1.load(nam);%>
                                     
                                 <table>
                                  <tr><th>累计评价</th> <td><%= cdlist.size() %>条</td>
                                </tr>
                                <tr><th>商品</th> <th>评论内容</th>
                                </tr>
                                <%for (int i = 0; i < cdlist.size(); i++) {%>
				                <%Comment order = cdlist.get(i);%>
				                
				               
				                <tr><th><%=order.getCname() %></th>
				                <td><%=order.getCitem() %></td>
				                </tr>
				                <% }%>
                               
                                </table>
              </div>  
</body>
</html>