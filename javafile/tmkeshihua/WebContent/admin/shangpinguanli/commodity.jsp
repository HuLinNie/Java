<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
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
    function nnzzchart() {
    	  // 1实例化对象
    	  var myChart = echarts.init(document.getElementById('nnstockzzchart'));
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
    	        name: "库存",
    	        type: "bar",
    	        barWidth: "35%",
    	        data:[],
    	        itemStyle: {
    	          // 修改柱子圆角
    	          barBorderRadius: 5
    	        }
    	      }
    	    ],
    	    toolbox:{
				show:true,
				feature:{
					mark:{show:true},
					dataView:{show:true,readOnly:false},
					magicType:{show:true,type:['line','bar']}
				}
			}
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
    	 			var str="牛奶";
    	 			for(var i=0;i<result.length;i++){
    	 				if(result[i].type==str){
    	 				shops.push(result[i].name);
    	 				nums.push(result[i].stock)}
    	 			}
    	 			myChart.hideLoading();
    	 			myChart.setOption({
    	 				xAxis:{data:shops},
    	 				series:[{
    	 					name:'库存',
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
	
	
	
	<script>// 柱状图模块1
    function snzzchart() {
    	  // 1实例化对象
    	  var myChart = echarts.init(document.getElementById('snstockzzchart'));
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
    	        name: "库存",
    	        type: "bar",
    	        barWidth: "35%",
    	        data:[],
    	        itemStyle: {
    	          // 修改柱子圆角
    	          barBorderRadius: 5
    	        }
    	      }
    	    ],
    	    toolbox:{
				show:true,
				feature:{
					mark:{show:true},
					dataView:{show:true,readOnly:false},
					magicType:{show:true,type:['line','bar']}
				}
			}
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
    	 			var str="酸奶";
    	 			for(var i=0;i<result.length;i++){
    	 				if(result[i].type==str){
    	 				shops.push(result[i].name);
    	 				nums.push(result[i].stock)}
    	 			}
    	 			for(var i=0;i<result.length;i++){
    	 				nums.push(result[i].monthamount);
    	 			}
    	 			myChart.hideLoading();
    	 			myChart.setOption({
    	 				xAxis:{data:shops},
    	 				series:[{
    	 					name:'库存',
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
	
	
	
	<script>// 柱状图模块1
    function ylzzchart() {
    	  // 1实例化对象
    	  var myChart = echarts.init(document.getElementById('ylstockzzchart'));
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
    	        name: "库存",
    	        type: "bar",
    	        barWidth: "35%",
    	        data:[],
    	        itemStyle: {
    	          // 修改柱子圆角
    	          barBorderRadius: 5
    	        }
    	      }
    	    ],
    	    toolbox:{
				show:true,
				feature:{
					mark:{show:true},
					dataView:{show:true,readOnly:false},
					magicType:{show:true,type:['line','bar']}
				}
			}
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
    	 			var str="饮料";
    	 			for(var i=0;i<result.length;i++){
    	 				if(result[i].type==str){
    	 				shops.push(result[i].name);
    	 				nums.push(result[i].stock)}
    	 			}
    	 			myChart.hideLoading();
    	 			myChart.setOption({
    	 				xAxis:{data:shops},
    	 				series:[{
    	 					name:'库存',
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
	
	 <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">商品管理</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="home">买家中心</a></li>
                            <li><a href="AdminhomeServlet?action=adminhome">卖家服务</a></li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- row -->
                <div class="row">
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-md-6 col-sm-6 col-xs-6"> <i data-icon="E" class="linea-icon linea-basic"></i>
                                    <h5 class="text-muted vb"><a href="SpServlet?action=update">编辑</a></h5> </div>
                                <div class="col-md-6 col-sm-6 col-xs-6">
                                    <h3 class="counter text-right m-t-15 text-danger">天猫</h3> </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%"> <span class="sr-only">40% Complete (success)</span> </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic" data-icon="&#xe01b;"></i>
                                    <h5 class="text-muted vb"><a href="SpServlet?action=add">添加</a></h5> </div>
                                <div class="col-md-6 col-sm-6 col-xs-6">
                                    <h3 class="counter text-right m-t-15 text-megna">超市</h3> </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-megna" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%"> <span class="sr-only">40% Complete (success)</span> </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                    <!--col -->
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                        <div class="white-box">
                            <div class="col-in row">
                                <div class="col-md-6 col-sm-6 col-xs-6"> <i class="linea-icon linea-basic" data-icon="&#xe00b;"></i>
                                    <h5 class="text-muted vb"><a href="SpServlet?action=delete">删除</a></h5> </div>
                                <div class="col-md-6 col-sm-6 col-xs-6">
                                    <h3 class="counter text-right m-t-15 text-primary">饮品</h3> </div>
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="progress">
                                        <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%"> <span class="sr-only">40% Complete (success)</span> </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
                <!--row -->
                <div class="row">
                    <div class="col-md-12">
                        <div class="white-box" style="width:420px;height:500px; margin-left:15px;float:left" id="nnstockzzchart"> 
                        </div><script>nnzzchart();</script>
                        <div class="white-box" style="width:420px;height:500px;margin-left:15px; float:left" id="snstockzzchart">
                        </div><script>snzzchart();</script>
                        <div class="white-box" style="width:420px;height:500px;margin-left:15px; float:left" id="ylstockzzchart">
                        </div><script>ylzzchart();</script>
                    </div>
                </div>
               
               
    </div>          
  </div>                           
              
                           
    
</body>
</html>