<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="./css/index.css"/>
	<title>青饮后端</title>
</head>
<body>
	<div class="div">
		<div class="div1">
			<img src="img/21.jpg" width="130px" height="130px" />
		</div>
		<div class="div2">
			<form action="LoginServlet" method="post">
				<input type="text" name="name" style="margin-top:70px" placeholder="请输入用户名"/><br/>
				<input type="password" name="pwd" placeholder="请输入密码"/><br/>
				<input type="submit" value="登录" /><br/>
			</form>
			<%
			String right = (String)request.getAttribute("right");
			if(right!=null){
				if(right.equals("noaddRight")){
					out.print("账号或密码有误，请重新输入！");
				}
			}
			%>
		</div>
	</div>
	
</body>
</html>