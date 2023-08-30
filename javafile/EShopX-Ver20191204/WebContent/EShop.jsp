<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, shopping.bean.*,shopping.util.*,shopping.service.*,shopping.dao.impl.*,shopping.dao.*,shopping.controller.*,shopping.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>音乐无界</title>
<base href="<%=shopping.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style>
	#albumlist{width:450px;}
    .form-ctrl a{display: inline-block;width:70%; }
</style>
</head>
<body>
	<jsp:include page="jsp/_header.jsp" />
	<hr>
	<a href ="#"><% IAlbumDao dao = new AlbumDaoImpl();%>
	 <%Album cf =dao.select("山海关门票");%>
	 <%=cf.getId()%>
	 <%cf.toStringWithoutID(); %></a>
	<div id="albumlist" class="body-content-height" style="width:100%;margin:5px 0;">
		<%List<Album> cdlist = shopping.util.RequestAttrHelper.getAlbum(request);%>
		<%for(Album cd: cdlist){%>
		<form name="shoppingForm" action="CartServlet" method="POST">
			<input type="hidden" name="action" value="Add" />
			<input type="hidden" name="albumId" value="<%=cd.getId() %>" />
			<div class="form-item">
				<div class="form-ctrl" >
					<a href="Album?action=show&id=<%=cd.getId() %>"><%=cd.toStringWithoutID() %></a>
					数量:<input type="text" name="qty" value='1' style="width:80px;text-align:center;"/>
					<input type="submit" name="Submit" value="加入购物车" class="btn-green" style="width:130px"/>
				</div>
			</div>
		</form>
		<%}%>
	</div>
	<jsp:include page="jsp/_bottom.jsp" />
</body>
</html>