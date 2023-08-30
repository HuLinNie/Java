<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,java.io.*,java.net.Socket,net.socket.talk.*,javax.swing.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客服</title>
<base href="<%=BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
	<style>
		#header{padding: 1em;
			
			box-sizing: border-box;
			border:1px solid #F1EBEC;
			margin:5px,0;
			text-align:center;
			font-family:华文行楷;
			font-size: 36px;
			color: #000000;
			
		}
		#chatframe{
			background:url(images/ql.jpg) no-repeat;
			padding: 1em;
			box-sizing: border-box;
			border:2px dotted red;
			margin:5px,0;
			float: left;
			width:80%;
			height: 400px;
			border-width:1px 1px 0px 1px;	
			margin-left: 10%;
		}
		.connection{padding: 1em;
			
			box-sizing: border-box;
			border:1px solid #F1EBEC;
			margin:5px,0;
			text-align:center;
			font-family:华文行楷;
			font-size: 36px;
			color: #000000;
		}
	</style>
</head>
<body>
	<jsp:include page="_header.jsp" />
	<div id="header">
		天下第一关-山海关				
	</div>
	<div id="chatframe">
	连接成功${clientinfo}<br>
	客服：客服小娜竭诚为你服务！<br>
	客服：有什么可以帮到您的呢？<br>
	${chatcontent_info1}<br>
	</div>
	<div id="" class="connection">
	<form action="ChatServlet">
		<button name="action" value="getconnection" style="width:130px;height:25px;background:skyblue;">建立连接</button>
		<button name="action" value="exit" style="width:130px;height:25px;;background:skyblue;">退出</button>
		<input type="text"  name="chatcontent" placeholder="" style="width:300px;height:25px;"/>
		<input  type="hidden" name="action" value="send" />
		<input type="submit" name="send" value="提交" style="width:130px;height:25px;;background:skyblue;"/>
	 </form>
	</div>
	<jsp:include page="_bottom.jsp" />
</body>
</html>
