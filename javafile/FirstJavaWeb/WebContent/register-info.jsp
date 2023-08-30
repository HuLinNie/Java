<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册信息</title>
<style>
	div a{
		display:block;
		text-align:center;
	}
	h1{
		display:block;
		text-align:center;
	}
	#msg{
		margin:20px auto;
		width:680px;
		font-size:32px;
	}
</style>
</head>
<body>
	<h1>注册信息</h1>
	<div id="msg">${reg_msg}</div>
	<div><a href="dowhat?what=index">返回首页</a></div>
</body>
</html>