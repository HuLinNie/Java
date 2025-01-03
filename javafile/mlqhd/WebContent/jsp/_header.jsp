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
</head>
<body>
	<div class="header">
        <div class="inner">
            <div class="logo"><img src="images/logo.jpg" /></div>
            <div class="nav">
                <ul>
                    <li><a href="home">首页</a></li>
                    <li><a href="muesum?action=muesumjd">景区</a></li>
                    <li><a href="muesum?action=muesumbwg">博物馆</a></li>
                    <li><a href="muesum?action=showvideo">视频学习</a></li>
                </ul>
            </div>
            <div class="search">
            		<form name="search" action="SearchServlet" method="post">
                   	<input type="search" name="Search" id="search_01" placeholder="搜索景区、博物馆、旅游攻略" ><button></button></form>
                    <%String name =null; %>
                    <script>
                    	
                    	function inputLoad(){
                    		var input=document.getElementById("search_01");
                    		input.addElementListener("search_01",search,false);
                    	}
                    	function test(){ name=this.id}
                    	 
                    	
                    </script>
                    <script>inputLoad();
                	test();
                	</script>
                   <% name=request.getParameter("Search") ;%>
                    <%List<Search> cdlist = new SearchDaoImpl().load(name);%>
					<%for (int i = 0; i < cdlist.size(); i++) {%>
					<%Search cd = cdlist.get(i); %>
					<form name="search" action="SearchServlet" method="post">
					<input type="button" name="Search" id="" value=<%=cd.getSname() %> ></form>	
					<%}%>	
            </div>
            <div class="personal">
                <ul>
                	<li><a id="toOrder" href="CartServlet?action=ShowOrder">订单</a></li>
                    <li><a id="toCart" href="CartServlet?action=ShowCart">购物车</a></li>
                    <li><img src="images/gwc.jpg" alt=""></li>
                    <li><img src="images/id.jpeg" alt=""></li>
                    <li>
                     <form name="logout" action="LoginServlet" method="post">
					 <% boolean islogin = web.service.AuthHelper.isLogin(request.getSession()); %>
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