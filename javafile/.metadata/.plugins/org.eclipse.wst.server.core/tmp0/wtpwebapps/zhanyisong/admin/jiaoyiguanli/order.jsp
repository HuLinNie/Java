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
</head>

<body>
		<jsp:include page="../left.jsp" />
        
         <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">交易管理</h4> </div>
                        <ol class="breadcrumb">
                             <li><a href="home">买家中心</a></li>
                            <li><a href="AdminhomeServlet?action=adminhome">卖家服务</a></li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title">订单</h3>
                            <p class="text-muted">Order<code>.table</code></p>
                            <div class="table-responsive">
                                <table class="table">
                                <%IOrderDao  idao = new  OrderDaoImpl(); %>
			<%List<Order> cdlist = idao.load(); %>
                                    <thead>
                                        <tr>
                                            <th>订单号</th>
                                            <th>订单状态</th>
                                            <th>顾客ID</th>
                                            <th>总价</th>
                                            <th>日期</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       <%for (int i = 0; i < cdlist.size(); i++) {%>
				                <%Order order = cdlist.get(i);%>
                                    <tbody>
                                        <tr>
                                            <td><%=order.getId()%></td>
                                            <td>已支付</td>
                                            <td><%=order.getCustomer_id() %></td>
                                            <td><%=Numeric.toFixedDecimalString(order.getAmount(), 2)%></td>
                                            <td><%=order.getDate().toLocalDate()%></td>
                                            <td></td>
                                            <td><a href="CartServlet?action=deleteorder&id=<%=order.getId() %>">删除</a></td>
                                        </tr>
                                    </tbody>
                                <% }%>
                                    
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
 
        </div>
        <!-- /#page-wrapper -->
  
     
 
</body>
</html>