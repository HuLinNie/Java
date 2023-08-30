<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>旅游攻略</title>
<link rel="stylesheet" type="text/css" href="css/header.css" />
<style>
	.relicAppLeft{ width: 180px; float: left; margin-right: 50px; background-color: #fff; position: relative; z-index: 998; }
.relicAppLeft li{ height: 36px; border-bottom: 1px solid #e3e3e3; line-height: 36px; font-size: 16px; text-indent: 34px;}
.relicAppLeft li.channelOn,.relicAppLeft li:hover{ background: #b3a574 url(raChannelBg.png) no-repeat left center; border-color: #b3a574; }
.relicAppLeft li.hasSubChannel a{ background: url(raSubChannel.png) no-repeat 154px center; }
.relicAppLeft li.hasSubChannel:hover a{ background: url(raSubChannelOn.png) no-repeat 154px center;  }
.relicAppLeft li:hover ul{ display: block; }  
.relicAppLeft li.channelOn a,.relicAppLeft li:hover a{ color: #fff; }
.relicAppLeft li a{ color: #333; display: block; text-decoration:none; }
.pic img{
	height: 500px;
	weight:800px;
}
	}
</style>
</head>
<body>
<jsp:include page="/jsp/_header.jsp" />
<div class="relicAppLeft">
		<ul>
			<li class="channelon">
				<a href="#">景点导览</a>
			</li>
			<li class="li">
				<a href="#">热门景点</a>
			</li>
			<li class="li">
				<a href="#">定制行程</a>
			</li>
		</ul>
	</div>
	<div class="pic">
		<img src="images/tj.jpg"/>
	</div>
<jsp:include page="/jsp/_bottom.jsp" />		
</body>
</html>