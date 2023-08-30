<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*, java.io.*,web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>交易管理</title>
 <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="css/sidebar-nav.min.css" rel="stylesheet">
    <!-- toast CSS -->
    <link href="css/jquery.toast.css" rel="stylesheet">
    <!-- morris CSS -->
    <link href="css/morris.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style1.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="css/blue-dark.css" id="theme" rel="stylesheet"> 
    
    <style>
    td img{
	width:60px;
	height:60px;
	border-radius:20px;}
    </style>
</head>

<body>
		
        <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">商品下架</h4> </div>
                        <ol class="breadcrumb">
                             <li><a href="home">买家中心</a></li>
                            <li><a href="AdminhomeServlet?action=adminhome">卖家服务</a></li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
       
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title">商品</h3>
                            <p class="text-muted">Commodity<code>.table</code></p>
                            <div class="table-responsive">
                                <table class="table">
                                <%ICommodityDao idao = new  CommodityDaoImpl(); %>
			<%List<Commodity> cdlist = idao.query();%>
                                    <thead>
                                        <tr>
                                            
                                            <th></th>
                                            <th>商品ID</th>
                                            <th>商品名称</th>
                                            <th>商品价格</th>
                                			<th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       <%for (int i = 0; i < cdlist.size(); i++) {%>
				                <%Commodity order = cdlist.get(i);%>
                                    <tbody>
                                        <tr>
                                        	<td><img src="<%=order.getImage()%>"></td>
                                            <td><%=order.getId() %></td>
                                           
                                            <td><%=order.getName() %></td>
                                            <td><%=Numeric.toFixedDecimalString(order.getPrice(), 2)%></td>
                                           <td><a href="SpServlet?action=update&id=<%=order.getId() %>">更新</a></td>
                                            <td><a href="SpServlet?action=dodelete&id=<%=order.getId() %>">删除</a></td>
                                        </tr>
                                    </tbody>
                                <% }%>
                                
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            
  
     
 
</body>
</html>