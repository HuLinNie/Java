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
     <script src="js/echarts.min.js" ></script>
    <script src="js/jquery.js" ></script>
    <script>// 柱状图模块1
    function zzchart() {
    	  // 1实例化对象
    	  var myChart = echarts.init(document.getElementById('yxlzzchart'));
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
    	        name: "月销量（2021年05月）",
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
    	 				nums.push(result[i].monthamount);
    	 			}
    	 			myChart.hideLoading();
    	 			myChart.setOption({
    	 				xAxis:{data:shops},
    	 				series:[{
    	 					name:'月销量',
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
                       
                        <div class="white-box" id="yxlzzchart" style="width:1200px;height:500px;margin-left:5% ">
                        
                        </div>
                        <script>zzchart();</script>
                    </div>
                </div>
                <div class="white-box" id="timeseries" style="width:1350px;height:900px;margin-left:1% "></div>
               
               
                <script>
               
                var myChart = echarts.init(document.getElementById('timeseries'));
        		//指定图表的配置项和数据
        		  // 指定图表的配置项和数据
                var monthList = ['1月份','2月份','3月份','4月份','5月份'];
                var commodityList = ['jd','tls','wz','cz','kfe','rx','kf','kl','wlj'];
                var ComIcons = {
                        'jd': 'logo/nn_jd.jpg',
                        'tls': 'logo/nn_tls.jpg',
                        'wz': 'logo/nn_wz.jpg',
                        'cz': 'logo/sn_cz.jpg',
                        'kfe': 'logo/sn_kfe.jpg',
                        'rx': 'logo/sn_rx.jpg',
                        'kf': 'logo/yl_kf.jpg',
                        'kl': 'logo/yl_kl.jpg',
                        'wlj': 'logo/yl_wlj.jpg'
                };
                var option = {
                		 
                    timeline:{
                        axisType: 'category',
                        autoPlay: true,
                        playInterval: 1500,
                        data: monthList,
                        label:{
                            fontSize: 18
                        }
                    },
                    baseOption:{
                        dataset:{
                            source:[
                                ['month','jd','tls','wz','cz','kfe','rx','kf','kl','wlj'],
                                ['1月份',20000,60000,30000,25000,32000,10000,8000,9000,5000],
                                ['2月份',25000,55000,20000,20000,28000,8000,6000,5000,6000],
                                ['3月份',10000,40000,10000,19000,25000,9000,5000,6000,9000],
                                ['4月份',12500,32500,24000,17000,20000,12000,4000,8000,5000],
                                ['5月份',17500,35200,12000,18000,18000,6000,3000,7000,10000],
                            ]
                        },

                        title: {
                            text: '2021年1月份各商品的销量',
                            left: 'center',
                            textStyle:{
                                fontSize:24
                            }
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        toolbox: {
                            feature: {
                                saveAsImage: {}
                            }
                        },
                        legend: {                
                        },               
                        grid: {
                            left: '1%',
                            
                            containLabel: true
                        },
                        xAxis: [
                            {
                            type:'category',
                            data: commodityList,
                            axisPointer: {
                            type: 'shadow'
                            },
                            axisLabel: {
                            	color: "rgba(0,0,0,.6) ",
                                formatter: function (value) {
                                    return '{' + value + '| }\n{value|' + value + '}';
                                },
                                margin: 20,
                                rich: {
                                    value: {
                                        lineHeight: 30,
                                        fontSize: 18,
                                        align: 'center'
                                    },
        							jd: {
                                        height: 40,
                                        align: 'center',
                                        backgroundColor: {
                                            image: ComIcons.jd
                                        }
                                    },
                                  	tls: {
                                        height: 40,
                                        align: 'center',
                                        backgroundColor: {
                                            image: ComIcons.tls
                                        }
                                    },
        							 wz: {
                                        height: 40,
                                        align: 'center',
                                        backgroundColor: {
                                            image: ComIcons.wz
                                        }
                                    },
                                    	cz: {
                                        height: 40,
                                        align: 'center',
                                        backgroundColor: {
                                            image: ComIcons.cz
                                        }
                                    },
                                  	  kfe: {
                                        height: 40,
                                        align: 'center',
                                        backgroundColor: {
                                            image: ComIcons.kfe
                                        }
                                    },
                                    	rx: {
                                        height: 40,
                                        align: 'center',
                                        backgroundColor: {
                                            image: ComIcons.rx
                                        }
                                    },
                                    	kf: {
                                        height: 40,
                                        align: 'center',
                                        backgroundColor: {
                                            image: ComIcons.kf
                                        }
                                    },
                                  	  kl: {
                                        height: 40,
                                        align: 'center',
                                        backgroundColor: {
                                            image: ComIcons.kl
                                        }
                                    },
                                   	 wlj: {
                                        height: 40,
                                        align: 'center',
                                        backgroundColor: {
                                            image: ComIcons.wlj
                                        }
                                    },
                                }
                            } 
                            
                            },
                        ],
                        yAxis:[ 
                            {
                            name:'销量',
                            type:'value',
                            nameTextStyle:{
                                fontSize:18
                            },
                            axisLabel:{
                            	color: "rgba(0,0,0,.6) ",
                                fontSize:18
                            },
                            axisLine: {
                  	          lineStyle: {
                  	            color: "rgba(0,0,0,.1)",
                  	            width: 2
                  	          }
                  	        },
                  	      splitLine: {
                	          lineStyle: {
                	            color: "rgba(0,0,0,.1)"
                	          }
                	        },
                            },                
                        ],
                        series: [                
                            {
                            	 itemStyle: {
                       	          // 修改柱子圆角
                       	          color: ["#2f89cf"],
                       	          barBorderRadius: 5
                       	        },
                            type: 'bar',
                            seriesLayoutBy: 'row',
                            encode:{
                                x:'month',
                                y:'1月份'
                            }
                            },
                        ]
                    },
                    options:[]
                };

                for (var n = 0; n<monthList.length; n++){
                    option.options.push({
                        title:{
                            show:true,
                            text:'2021年'+monthList[n]+'各种商品销量',
                            left: 'center',
                            textStyle:{
                                fontSize:24
                            }
                        },
                        series:[
                            {
                            type: 'bar',
                            seriesLayoutBy: 'row',
                            encode:{
                                x:'month',
                                y:monthList[n]
                            }
                            },
                        ]
                    });
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
                </script>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
   			
        
        <!-- /#page-wrapper -->
  
     
 
</body>
</html>