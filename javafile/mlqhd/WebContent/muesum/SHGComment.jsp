<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>魅力秦皇岛</title>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<style>
	.embe{
			position:relative;
			margin:0 auto;
			border-style: outset;
			border-width:1px;
			width: 300px;
			border-radius: 5px;
			background-color: #F0E4E4;
		}		
		embed{
			align-content: center;
			background-color: skyblue;
			
		}
	.back a{
		 position:relative;
		 left:47%;
		 text-decoration:none;
		 color:black;
	}
	.back a:hover{
		color:red;
	}
</style>
</head>
<body>
	<jsp:include page="/jsp/_header.jsp" />
	<label style="position:relative;left:47%">景区展示</label>
	<div class ="embe">
		<embed video src="video/1575367482.mp4" width=“200” height="180">
		</embed>
	</div>	<hr>
	<div class="commment" style="position: relative;margin:0 auto;">
			<table style="margin: 0 auto;width:300px;">
			<tr>
				<th><b>景区评价</b></th>
			</tr><% Customer cu = AuthHelper.getCustomerInfoBySession(session); %>
			<%List<Comment> cdlist = new CommentDaoImpl().load();%>
			<%for (int i = 0; i < cdlist.size(); i++) {%>
			<%Comment cd = cdlist.get(i); %>	
				<tr>
					<td><b><%=cu.getMail()%><br><%=cd.toStringWithoutID()%><br></b></td>
				</tr>
				<%} %>
			</table>
	<div class="back"><a href="home">返回首页</a></div>		
	</div>

	<jsp:include page="/jsp/_bottom.jsp" />		
</body>
</html>