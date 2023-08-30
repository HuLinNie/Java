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
     <script src="js/echarts.min.js" ></script>
    <script src="js/jquery.js" ></script>
     <script>// 柱状图模块1
    function zzchart() {
    	  // 1实例化对象
    	  var myChart = echarts.init(document.getElementById('pllzzchart'));
    	  // 2. 指定配置项和数据
    	  var option = {
    	    color: ["#2f89cf"],
    	    tooltip: {
    	      trigger: "axis",
    	      axisPointer: {
    	        // 坐标轴指示器，坐标轴触发有效
    	        type: "shadow" // 默认为直线，可选为：'line' | 'shadow'
    	      }
    	    },
    	    // 修改图表的大小
    	    grid: {
    	      left: "0%",
    	      top: "10px",
    	      right: "0%",
    	      bottom: "4%",
    	      containLabel: true
    	    },
    	    xAxis: [
    	      {
    	        type: "category",
    	        data: [],
    	        axisTick: {
    	          alignWithLabel: true
    	        },
    	        // 修改刻度标签 相关样式
    	        axisLabel: {
    	          color: "rgba(0,0,0,.6) ",
    	          fontSize: "12"
    	        },
    	        // 不显示x坐标轴的样式
    	        axisLine: {
    	          show: false
    	        }
    	      }
    	    ],
    	    yAxis: [
    	      {
    	        type: "value",
    	        // 修改刻度标签 相关样式
    	        axisLabel: {
    	          color: "rgba(0,0,0,.6) ",
    	          fontSize: 12
    	        },
    	        // y轴的线条改为了 2像素
    	        axisLine: {
    	          lineStyle: {
    	            color: "rgba(0,0,0,.1)",
    	            width: 2
    	          }
    	        },
    	        // y轴分割线的颜色
    	        splitLine: {
    	          lineStyle: {
    	            color: "rgba(0,0,0,.1)"
    	          }
    	        }
    	      }
    	    ],
    	    series: [
    	      {
    	        name: "商品评论数",
    	        type: "bar",
    	        barWidth: "35%",
    	        data:[],
    	        itemStyle: {
    	          // 修改柱子圆角
    	          barBorderRadius: 5
    	        }
    	      }
    	    ]
    	  };
    	  // 3. 把配置项给实例对象
    	  myChart.setOption(option);
    	 window.addEventListener("resize", function() {
    	    myChart.resize();
    	  });
    	 myChart.showLoading();
    	 var shops=[];
    	 var nums=[];
    	 $.ajax({
    		 type:"post",
    	 	async:true,
    	 	url:"bar.do",
    	 	data:{},
    	 	dataType:"json",
    	 	success:function(result){
    	 		if(result){
    	 			for(var i=0;i<result.length;i++){
    	 				shops.push(result[i].name);
    	 			}
    	 			for(var i=0;i<result.length;i++){
    	 				nums.push(result[i].commentamount);
    	 			}
    	 			myChart.hideLoading();
    	 			myChart.setOption({
    	 				xAxis:{data:shops},
    	 				series:[{
    	 					name:'评论量',
    	 					data:nums
    	 				}]
    	 			})
    	 		}	
    	 	},
    		error:function(errorMsg){
    			alert("图表数据请求失败！");
    			myChart.hideLoading();
    		}	 
    	 })
    	};
	</script>
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
				                <%ICommodityDao dao = new CommodityDaoImpl();%>
                                    <tbody>
                                        <tr>
                                            <td><%=i+1 %></td>
                                            <td><%=dao.select(cdlist.get(i).getShopid()) %></td>
                                            <td>商品：<%=order.getShopcontent()%>服务：<%=order.getServicecontent()%></td>
                                            <td><%=order.getTime().toLocalDate()%></td>
                                            <td><a href="CommentServlet?action=delete&id=<%=order.getCid()%>">删除</a></td>
                                        </tr>
                                    </tbody>
                                <% }%>
                                </table>
                        </div>  
                        <div class="white-box" id="pllzzchart" style="height:500px ">
                        
                        </div>
                        <script>zzchart();</script>
                        
                                          
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