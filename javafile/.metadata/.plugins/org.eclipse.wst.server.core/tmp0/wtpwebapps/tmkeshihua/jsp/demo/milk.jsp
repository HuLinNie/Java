<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, java.io.*,web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>牛奶</title>
<base href="<%=web.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/shopclass.css" />
</head>
<body>
<jsp:include page="../template/_header.jsp" />
	
	 <div class="product-max" style="margin-left:10%">
	 			<%
	 				ICommodityDao dao = new CommodityDaoImpl(); List<Commodity> cf =dao.queryType("牛奶");
	 			%> 
	 			<%for( int i=0;i<cf.size();i++){%>		
                    <ul>
                      <li>
                           <div>
                              <div class="p-image"><a href="CommodityServlet?action=show&id=<%=cf.get(i).getId()%>"><img src="<%=cf.get(i).getImage()%>" /></a></div>      
                                  	 <div class="head"><%=cf.get(i).getName() %> <%=Numeric.toFixedDecimalString(cf.get(i).getPrice(), 2) %>元
                                  	 	<a class="person" id="toCart" href="CartServlet?action=add&id=<%=cf.get(i).getId()%>"><img src="images/gwc.jpg" alt="购物车"></a>
                                  		
                                  	 </div>
                                 		<p>
                                			  总销量<span><%=cf.get(i).getTotalamount() %></span>
                              			</p>	 
                          </div>
                           </li>
                       <% };%>
                     </ul>
      </div>
   

</body>
</html>