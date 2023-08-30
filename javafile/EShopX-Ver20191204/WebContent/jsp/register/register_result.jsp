<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>信息</title>
	<base href="<%=shopping.util.BasePath.get(request)%>" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<jsp:include page="../_header.jsp" />
		<div class="body-content-height">
			<p style='text-align:center'>Hello <span style='font-weight:bolder;'>${register_info}<%=request.getAttribute("uinfo") %></span>,Wecolme to Servlet World!</p>
			<p style='text-align:center'><a href='home'>index Page</a></p>
			<p style='text-align:center'><a href='user?index'>index Page</a></p>
		</div>
	<jsp:include page="../_bottom.jsp" />
</body>
</html>