<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<base href="<%=shopping.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style>
#title {
	height: 90px;
	line-height: 90px;
	margin: 0 10px 0 1px;
	float: left;
	font-size: 3em;
	font-family: 楷体;
	background-color: rgb(245, 247, 251);
}

#fdiv {
	float: right;
	padding: 0;
	width: 200px;
	line-height: 90px;
}
form{display:inline;}

#toCart{
		width:130px;
		float:right;    
		display: inline-block;
	    background-color: #fdb933;
	    text-align: center;
	    padding:0;
    }
</style>
</head>
<body>
	<div style="background-color: #008B8B; min-height: 90px"">
		<div id="title">音乐无极限</div>
		<div id="fdiv">
			<form name="logout" action="LoginServlet" method="post">
				<% boolean islogin = shopping.service.AuthHelper.isLogin(request.getSession()); %>
				<input type="hidden" name="action" value="<%= (islogin?"logout":"login")%>"> 
				<input type="submit" name="Submit" value="<%= (islogin?"注销":"登录")%>" class="btn-green ctrl-button">
			</form>
			<form name="register" action="RegisterServlet" method="post">
				<input type="hidden" name="action" value="register"> 
				<input type="submit" name="Submit" value="注册" class="btn-green ctrl-button">
			</form>
		</div>
		
		<div style="clear: both;"></div>
		<nav><a href="">首页</a>|<a>流行</a>|<a>摇滚</a>|<a>知识</a>|<a>公司信息</a>|<a>个人信息</a><a id="toCart" href="CartServlet?action=ShowCart">购物车</a></nav>
	</div>
</body>
</html>