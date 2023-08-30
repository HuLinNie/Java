<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.io.*,web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户服务</title>
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
	<div id="wrapper">
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">客服服务</h4> </div>
                
                        <ol class="breadcrumb">
                            <li><a href="home">买家中心</a></li>
                            <li><a href="AdminhomeServlet?action=adminhome">卖家服务</a></li>

                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <!-- .row -->
                <div class="row">
                	<%ICommentDao dao1= new CommentDaoImpl();List<Comment> cdlist=dao1.load();%>
                    <div class="col-md-4 col-xs-12">
                        <div class="white-box">
                            <div class="user-bg"> <img width="100%" alt="user" src="images/admin/comment.jpg"/>
                                <div class="overlay-box">
                                    <div class="user-content">
                                        <a href="javascript:void(0)"><img src="images/admin/comment.jpg" class="thumb-lg img-circle" alt="img"></a>
                                        <h4 class="text-white">顾客评论</h4>
                                        <h5 class="text-white"></h5> </div>
                                </div>
                            </div>
                            <div class="user-btm-box">
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-purple"><i class="ti-facebook"></i></p>
                                    <h1>好评<%=cdlist.size() %></h1> </div>
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-blue"><i class="ti-twitter"></i></p>
                                    <h1>差评0</h1> </div>
                                <div class="col-md-4 col-sm-4 text-center">
                                    <p class="text-danger"><i class="ti-dribbble"></i></p>
                                    <h1>总计<%=cdlist.size() %></h1> </div>
                            </div>
                            <form class="form-horizontal form-material">
                                <div class="form-group">
                                    <label class="col-md-12">评论管理</label>
                                    <div class="col-md-12">
                                        <input type="text" placeholder="" class="form-control form-control-line"> </div>
                                </div>
                                <div class="form-group">
                                    <label for="example-email" class="col-md-12">退款管理</label>
                                    <div class="col-md-12">
                                        <input type="email" placeholder="" class="form-control form-control-line" name="example-email" id="example-email"> </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12">违规记录</label>
                                    <div class="col-md-12">
                                        <input type="password" value="" class="form-control form-control-line"> </div>
                                </div>
                            </form>
                             
                        </div>
                        
                        
                    </div>
                    <div class="col-md-8 col-xs-12">
                        <div class="white-box">
                            
                      <table class="table">
                                    <thead>
                                        <tr>
                                            <th>序号</th>
                                            <th>商品名称</th>
                                            <th>评论内容</th>
                                            <th>日期</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                     <%for (int i = 0; i < cdlist.size(); i++) {%>
				                <%Comment order = cdlist.get(i);%>
                                    <tbody>
                                        <tr>
                                            <td><%=i+1 %></td>
                                            <td><%=order.getCname() %></td>
                                            <td><%=order.getCitem()%></td>
                                            <td><%=order.getTime().toLocalDate()%></td>
                                            <td><a href="CommentServlet?action=delete&id=<%=order.getCid() %>">删除</a></td>
                                        </tr>
                                    </tbody>
                                <% }%>
                                </table>
                        </div>
                      
                        
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
          
        <!-- /#page-wrapper -->
    </div>
    </div>
</body>
</html>