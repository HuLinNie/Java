<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博物馆</title>
<base href="<%=web.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<style>
	#albumlist{width:450px;}
    .form-ctrl a{display: inline-block;width:70%; }
   .embe{
			padding: 20px;
			margin-left:50px;
			border-style: outset;
			border-width:1px;
			width: 300px;
			border-radius: 5px;
			background-color: #F0E4E4;
		}		
		embed{
			align-content: center;
			background-color: #F3DEEC；
			
		}
</style>
</head>
<body>
	<jsp:include page="/jsp/_header.jsp" />
	<hr>
		<div class ="embe">
		<embed video src="video/1575367482.mp4" width=“200” height="180">
		</embed>
		</div>
	<div id="albumlist" class="body-content-height" style="width:100%;margin:5px 0;">
	<form name="shoppingForm" action="CartServlet" method="POST">
	<%
		ICommodityDao dao = new CommodityDaoImpl(); Commodity cf =dao.select("山海关门票");
	%>
	
			<input type="hidden" name="action" value="Add" />
			<input type="hidden" name="albumId" value="<%=cf.getId() %>" />
			数量:<input type="text" name="qty" value='1' style="width:80px;text-align:center;"/>
			<div class="form-item">
				<div class="form-ctrl" >
					<a href="Album?action=show&id=<%=cf.getId() %>"><%=cf.toStringWithoutID()%></a>
					<input type="submit" name="Submit" value="加入购物车" class="btn-green" style="width:130px"/>
				</div>
			</div>
	</form>
           <a href="https://720yun.com/t/735ju0eu5n7">景区详细介绍</a>
	</div>
	<jsp:include page="/jsp/_bottom.jsp" />			

</body>
</html>