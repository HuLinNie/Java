<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<base href="<%=web.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<style>
#plus{
width:190px;
border: 1px solid #00a4ff;
}
</style>
</head>       
<body>
	<div class="header">
        <div class="inner">
            <div class="logo"><img src="images/logo.jpg" /></div>
            <div class="nav">
                <ul>
                    <li><a href="home">首页</a></li>
                    <li><a href="jsp/demo/schoolmarket.jsp">牛奶</a></li>
                    <li><a href="jsp/demo/nearbyshops.jsp">酸奶</a></li>
                    <li><a href="jsp/demo/shopview.jsp">饮料</a></li>
                    <li><a href="jsp/demo/shopview.jsp">饮用水</a></li>
                    <li><a href="jsp/demo/shopview.jsp">可口可乐</a></li>
                     <li><a href="jsp/demo/shopview.jsp">啤酒</a></li>
                </ul>
            </div>
            <div class="search">
            		<form name="search" action="SearchServlet" method="post">
                   	<input  type="text" class="text1" name="search" id="search_01" placeholder="请输入关键字" >
                   	<input id="button" type="submit" value=""/>
                   	<input  type="hidden" name="action" value="search"/>
                   	
                    <div id="plus"></div>
                    </form>
                    </div>
                   <%String cn =null; %>
                    <script>
                    var input = document.getElementById("search_01");
                	input.addEventListener("input",inputLoad,false);
                	function inputLoad(e){
                		var con = e.data;	
                		cn = con;
                		if(cn!=null){
                		var tem = document.getElementById("plus");
                		tem.innerHTML = cn;
                		}
                	}
                    </script>
                   
                    <script>
                    	inputLoad(input);
                    </script>
          
            <div class="personal">
                <ul>
                	<li><a id="toOrder" href="admin/login.jsp">卖家服务</a></li>
                	<li><a id="toOrder" href="CartServlet?action=ShowOrder">订单</a></li>
                    <li><a id="toCart" href="CartServlet?action=ShowCart">购物车</a></li>
                    <li><img src="images/gwc.jpg" alt="购物车"></li>
                    <li><img src="images/id.jpeg" alt="帅照"></li>
                    <li>
                     <form name="logout" action="LoginServlet" method="post">
					 <% boolean islogin = web.service.AuthHelper.isLogin(request.getSession());%>
					 <input type="hidden" name="action" value="<%= (islogin?"logout":"login")%>"> 
					 <input type="submit" name="Submit" value="<%= (islogin?"注销":"登录")%>" class="btn-green ctrl-button">	
			     	</form>
			     	</li>
                 
                </ul>
            </div>
        </div>
    </div>
</body>
</html>