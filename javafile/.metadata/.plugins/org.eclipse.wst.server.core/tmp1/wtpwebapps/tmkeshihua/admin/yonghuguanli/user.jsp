<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*, java.io.*,web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
</head>
<body>
<div>
	<jsp:include page="../left.jsp" />
	<div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">用户管理</h4> </div>
                        <ol class="breadcrumb">
                            <li><a href="#">Welcome</a></li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title">订单</h3>
                            <p class="text-muted">Customer<code>.table</code></p>
                            <div class="table-responsive">
                            <%ICustomerDao dao1= new CustomerDaoImpl();List<Customer> cdlist=dao1.load();%>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>用户名</th>
                                            <th>电话</th>
                                            <th>地址</th>
                                            <th>用户权限</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%for (int i = 0; i < cdlist.size(); i++) {%>
				                <%Customer order = cdlist.get(i);%>
                                    <tbody>
                                        <tr>
                                            <td><%=order.getId() %></td>
                                            <td><%=order.getName() %></td>
                                            <td><%=order.getPhone()%></td>
                                            <td><%=order.getAddress()%></td>
                                            <td></td>
                                            <td><a href="CustomerServlet?action=delete&id=<%=order.getId() %>">删除</a></td>
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