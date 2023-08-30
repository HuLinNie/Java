<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>信息</title>
	<base href="<%=web.util.BasePath.get(request)%>" />
		
</head>
<body>
	
		<div class="body-content-height">
			<p style='text-align:center'>webshop</p>
			<p style='text-align:center'>您的注册信息如下</p>
			<p style='font-weight:bolder; text-align:center'>${register_info}</p>
			<!--%=request.getAttribute("uinfo") %-->
			<p style='text-align:center'><a href="home">返回登录</a></p>
		</div>
	
</body>
</html>