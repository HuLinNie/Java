<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>信息</title>
	<base href="<%=web.util.BasePath.get(request)%>" />
		<link rel="stylesheet" type="text/css" href="css/header.css" />
</head>
<body>
	<jsp:include page="../_header.jsp" />
		<div class="body-content-height">
			<p style='text-align:center'>欢迎加入魅力秦皇岛旅游网站</p>
			<p style='text-align:center'>您的注册信息如下</p>
			<p style='font-weight:bolder; text-align:center'>${register_info}<%=request.getAttribute("uinfo") %></p>
			<p style='text-align:center'><a href="home">返回登录</a></p>
		</div>
	<jsp:include page="../_bottom.jsp" />
</body>
</html>