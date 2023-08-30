<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, java.io.*,web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品展示</title>
<base href="<%=web.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<style type="text/css">
	.top{
		
		height:300px;
	}
	.p-image{
	width:300px;
	height:300px;
	margin-left:20%;
	float:left;
	}
	.p-image img{
	width:260px;
	height:260px;
	border-radius:20px;
	margin-left:10%;
	}
	.top_head_right{
	width:300px;
	height:260px;
	float:left;
	margin-top:20px;
	}
	.middle{
		position:relative;
		margin-left:25%;
		
	}
	.bottom{
		height:300px;
		margin-left:25%;
	}
	table{
	margin-left:2%;
	}
</style>
</head>
<body>
<jsp:include page="../template/_header.jsp" /> 
		<div class="top">
     		<% Commodity cd = web.util.RequestAttrHelper.getCommodityByName(request);%>
            <div class="p-image"><img src="<%=cd.getImage() %>" /></div> 
            <div class="top_head_right">
            	<h1><%=cd.getName()%><%=Numeric.toFixedDecimalString(cd.getPrice(), 2)%> 元 </h1>
           	 	<div style="margin-top:30px;">月销量：<%=cd.getMonthamount() %></div> 
           	 	<div style="margin-top:30px;"> 回购率：<%=Numeric.toFixedDecimalString(cd.getRepurchaserate(), 2) %></div> 
            	<div style="margin-top:30px;margin-left:80px;"><a  href="CartServlet?action=add&id=<%=cd.getId() %>" style="text-decoration:none;color:red">加入超市购物车</a></div>
            </div>
          </div>  
            <div class="middle">       
            <form action="CommentServlet" method="post">
                                 评价商品<input type="text" name="pjsp" />
                                  评价服务<input type="text" name="pjfw" />
           <input type="hidden" name="cname" value="<%=cd.getName()%>"/>
            <input type="hidden" name="action" value="showcomment"/>
            <input type="submit" name="submit" value="提交评价"/>
            </form>
                              
            <%String nam = cd.getName(); %>
            <%ICommentDao dao1= new CommentDaoImpl();List<Comment> cdlist=dao1.load(cd.getId());%>
                                     
              <table>
              <tr><th>累计评价</th> <td><%=cd.getCommentamount()%></td>
              </tr>
               <%for (int i = 0; i < cdlist.size(); i++) {%>
			   <%Comment order = cdlist.get(i);%>
			<tr><td>用户<%=order.getCustomerid()%>在<%=order.getTime()%>作出了评价</td>
			<td>商品：<%=order.getShopcontent() %>服务：<%=order.getServicecontent() %></td>
			</tr>
				 <% }%>          
                  </table>
            </div>
            
           <div class="bottom"><h1>产品详情</h1>
            <span style="margin-left:30px">规格：<%=cd.getSpecification() %></span> 
        	<span style="margin-left:80px">产地：<%=cd.getProducearea() %></span><br>
            <span style="margin-left:30px">保质期：<%=cd.getBaozhidate() %></span> 
        	<span style="margin-left:80px">配料：<%=cd.getMaterial() %></span> 
           </div>
</body>
</html>