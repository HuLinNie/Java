<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, java.io.*,web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索结果</title>
<base href="<%=web.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/shopclass.css" />
</head>
<body>
<jsp:include page="../template/_header.jsp" />                
           <div class="product-max" style="margin-left:10%">
	 			<%
	 			List<Commodity> cdlist= web.util.RequestAttrHelper.getCommodity(request); 
	 			%> 
	 			<%for (int i=0;i<cdlist.size();i++){ %>		
	 			<%	Commodity cd = cdlist.get(i); %>
                    <ul>
                      <li>
                           <div>
                              <div class="p-image"><a href="CommodityServlet?action=show&id=<%=cd.getId()%>"><img src="<%=cd.getImage()%>" /></a></div>      
                                  	 <div class="head"><%=cd.getName() %> <%=Numeric.toFixedDecimalString(cd.getPrice(), 2) %>
                                  	 	<a class="person" id="toCart" href="CartServlet?action=add&id=<%=cd.getId()%>"><img src="images/gwc.jpg" alt="购物车"></a>
                                  		
                                  	 </div>
                                 		<p>
                                			  总销量<span><%=cd.getTotalamount() %></span>
                              			</p>	 
                          </div>
                           </li>
                       <% };%>
                     </ul>
      </div>
                                
</body>
</html>