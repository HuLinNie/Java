<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>魅力秦皇岛</title>
<link rel="stylesheet" type="text/css" href="css/header.css" />
</head>
<body>
	<jsp:include page="/jsp/_header.jsp" />
	<div >
		<video width="580" height="100%" controls="controls" autoplay="autoplay" style="position:relative;left:30%">
                <source src="video/1577103947.mp4" type="video/webm" /> 
        </video>
	</div>
	<div>
		<form name="commentForm" action="CommentServlet" method="post" style="position:relative;left:35%">
			<% Customer cu = AuthHelper.getCustomerInfoBySession(session); %>
			<input type="hidden" name="action" value="showcomment" />
			<input type="hidden" name="customerId" value="<%=cu.getId() %>" />
			<label >景区评价</label>
			<input type="text" placeholder="50 words or less" name="commentItem" />
			<input type="submit" name="Submit" value="提交评价" class="btn-green" style="width:130px"/>
		</form>
	</div>
	<jsp:include page="/jsp/_bottom.jsp" />		
</body>
</html>