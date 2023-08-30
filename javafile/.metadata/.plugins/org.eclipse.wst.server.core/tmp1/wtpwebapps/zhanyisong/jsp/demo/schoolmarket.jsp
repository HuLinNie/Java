<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, java.io.*,web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校园超市</title>
<base href="<%=web.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/shopclass.css" />
<style type="text/css">
	.person{
	float:right;
	}
	.person img{width:40px;
	height:40px;}
	
</style>
</head>
<body>
<jsp:include page="../template/_header.jsp" />
	
	 <div class="product-max">
	 			<%
	 				ICommodityDao dao = new CommodityDaoImpl(); List<Commodity> cf =dao.query();
	 			%> 
	 			<%for( int i=0;i<cf.size();i++){%>		
                    <ul>
                      <li>
                           <div>
                              <div class="p-image"><a href="CommodityServlet?action=show&id=<%=cf.get(i).getId()%>"><img src="<%=cf.get(i).getImage()%>" /></a></div>      
                                  	 <div class="head"><%=cf.get(i).getName() %> <%=cf.get(i).getPrice() %>/kg
                                  	 	<a class="person" id="toCart" href="CartServlet?action=add&id=<%=cf.get(i).getId()%>"><img src="images/gwc.jpg" alt="购物车"></a>
                                  		
                                  	 </div>
                                 		<p>
                                			 <span>站主推荐</span>· 666人已购买
                              			</p>	 
                          </div>
                           </li>
                       <% };%>
                     </ul>
      </div>
   

</body>
</html>