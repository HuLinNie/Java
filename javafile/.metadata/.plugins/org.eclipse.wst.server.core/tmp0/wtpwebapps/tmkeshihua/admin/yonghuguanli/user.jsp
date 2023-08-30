<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*, java.io.*,web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
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
<script src="js/echarts.min.js" ></script>
    <script src="js/jquery.js" ></script>
    <script>
    // 饼形图2 地区分布模块
function bxchart() {
  var myChart = echarts.init(document.getElementById('yhdqbxchart'));
  var option = {
    color: [
      "#006cff",
      "#60cda0",
      "#ed8884",
      "#ff9f7f",
      "#0096ff",
      "#9fe6b8",
      "#32c5e9",
      "#1d9dff"
    ],
    tooltip: {
      trigger: "item",
      formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
      bottom: "0%",
      itemWidth: 10,
      itemHeight: 10,
      textStyle: {
        color: "rgba(0,0,0,.5)",
        fontSize: "12"
      }
    },
    series: [
      {
        name: "人脉分布",
        type: "pie",
        radius: ["10%", "70%"],
        center: ["50%", "50%"],
        roseType: "radius",
        // 图形的文字标签
        label: {
          fontSize: 10
        },
        // 链接图形和文字的线条
        labelLine: {
          // length 链接图形的线条
          length: 6,
          // length2 链接文字的线条
          length2: 8
        },
        data: [
          { value: 80, name: "河北" },
          { value: 50, name: "辽宁" },
          { value: 60, name: "浙江" },
          { value: 30, name: "江苏" },
          { value: 40, name: "山西" },
          { value: 10, name: "上海" },
          { value: 20, name: "北京" },
          { value: 32, name: "湖北" }
        ]
      }
    ]
  };
  myChart.setOption(option);
 window.addEventListener("resize", function() {
    myChart.resize();
  });
};
</script>   
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
                        <div class="white-box" id="yhdqbxchart" style="height:500px ">
                        
                        </div>
                        <script>bxchart();</script>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
 
        </div>
        <!-- /#page-wrapper -->

</body>
</html>