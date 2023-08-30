<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="css/index_admin.css" />
    <script src="js/echarts.min.js" ></script>
    <script src="js/jquery.js" ></script>
    <script>// 柱状图模块1
    function zzchart() {
    	  // 1实例化对象
    	  var myChart = echarts.init(document.querySelector(".zzchart"));
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
    	          color: "rgba(255,255,255,.6) ",
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
    	          color: "rgba(255,255,255,.6) ",
    	          fontSize: 12
    	        },
    	        // y轴的线条改为了 2像素
    	        axisLine: {
    	          lineStyle: {
    	            color: "rgba(255,255,255,.1)",
    	            width: 2
    	          }
    	        },
    	        // y轴分割线的颜色
    	        splitLine: {
    	          lineStyle: {
    	            color: "rgba(255,255,255,.1)"
    	          }
    	        }
    	      }
    	    ],
    	    series: [
    	      {
    	        name: "总销量",
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
    	 				nums.push(result[i].totalamount);
    	 			}
    	 			myChart.hideLoading();
    	 			myChart.setOption({
    	 				xAxis:{data:shops},
    	 				series:[{
    	 					name:'总销量',
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

    	
    	
    	<script>
    	// 柱状图2
    	function   zzchart2() {
    	  var myColor = ["#1089E7", "#F57474", "#56D0E3", "#F8B448", "#8B78F6","#1089E7", "#F57474", "#56D0E3", "#F8B448"];
    	  // 1. 实例化对象
    	  var myChart = echarts.init(document.querySelector(".zzchart2"));
    	 
    	   // 2. 指定配置和数据
  var option = {
    grid: {
      top: "10%",
      left: "45%",
      bottom: "10%"
      // containLabel: true
    },
    // 不显示x轴的相关信息
    xAxis: {
      show: false
    },
    yAxis: [
      {
        type: "category",
        inverse: true,
        data: [],
        // 不显示y轴的线
        axisLine: {
          show: false
        },
        // 不显示刻度
       axisTick: {
          show: false
        },
        // 把刻度标签里面的文字颜色设置为白色
        axisLabel: {
          color: "#fff"
        }
      },
      {
        data: [],
        inverse: true,
        // 不显示y轴的线
        axisLine: {
          show: false
        },
        // 不显示刻度
        axisTick: {
          show: false
        },
        // 把刻度标签里面的文字颜色设置为白色
        axisLabel: {
          color: "#fff"
        }
      }
    ]
   
  };

    	  // 3. 把配置给实例对象
    	  myChart.setOption(option);
    	 window.addEventListener("resize", function() {
    	    myChart.resize();
    	  });
    	 myChart.showLoading();
    	 var names=[];
    	 var nums=[];
    	 $.ajax({
    		 type:"post",
    	 	async:true,
    	 	url:"repurchaserate.do",
    	 	data:{},
    	 	dataType:"json",
    	 	success:function(result){
    	 		if(result){
    	 			for(var i=0;i<9;i++){
    	 				names.push(result[i].name);
    	 			}
    	 			for(var i=0;i<9;i++){
    	 				
    	 				nums.push((Number(result[i].repurchaserate)*100));
    	 			}
    	 			myChart.hideLoading();
    	 			myChart.setOption({
    	 				yAxis:{data:names},
    	 				 series: [
    	 				      {
    	 				        name: "条",
    	 				        type: "bar",
    	 				        data:nums,
    	 				        yAxisIndex: 0,
    	 				        // 修改第一组柱子的圆角
    	 				        itemStyle: {
    	 				          barBorderRadius: 20,
    	 				          // 此时的color 可以修改柱子的颜色
    	 				          color: function(params) {
    	 				            // params 传进来的是柱子对象
    	 				            // console.log(params);
    	 				            // dataIndex 是当前柱子的索引号
    	 				            return myColor[params.dataIndex];
    	 				          }
    	 				        },
    	 				        // 柱子之间的距离
    	 				        barCategoryGap: 50,
    	 				        //柱子的宽度
    	 				        barWidth: 10,
    	 				        // 显示柱子内的文字
    	 				        label: {
    	 				          show: true,
    	 				          position: "inside",
    	 				          // {c} 会自动的解析为 数据  data里面的数据
    	 				          formatter: "{c}%"
    	 				        }
    	 				      },
    	 				      {
    	 				        name: "框",
    	 				        type: "bar",
    	 				        barCategoryGap: 50,
    	 				        barWidth: 15,
    	 				        yAxisIndex: 1,
    	 				        data: [100, 100, 100, 100, 100,100,100,100,100],
    	 				        itemStyle: {
    	 				          color: "none",
    	 				          borderColor: "#00c1de",
    	 				          borderWidth: 3,
    	 				          barBorderRadius: 15
    	 				        }
    	 				      }
    	 				    ]
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

    	
    	
    	
    	<script>
    	// 折线图1模块制作
    	function zxchart() {
    	  var yearData = [
    	    {
    	      year: "2020", // 年份
    	      data: [
    	        // 两个数组是因为有两条线
    	        [1000, 2000, 5000, 7500, 10000, 12500, 9000, 10100, 14200, 17500, 20000, 22500],
    	        [1750, 3750, 6500, 10000, 17500, 16500, 15500, 18000, 20000, 22500, 22500, 37500]
    	      ]
    	    },
    	    {
    	      year: "2021", // 年份
    	      data: [
    	        // 两个数组是因为有两条线
    	        [20000, 25000, 10000, 12500,17500 , , , , , , , ],
    	        [60000, 55000, 40000, 32500, 35200, , , , , , , ]
    	      ]
    	    }
    	  ];
    	  // 1. 实例化对象
    	  var myChart = echarts.init(document.querySelector(".zxchart"));
    	  // 2.指定配置
    	  var option = {
    	    // 通过这个color修改两条线的颜色
    	    color: ["#00f2f1", "#ed3f35"],
    	    tooltip: {
    	      trigger: "axis"
    	    },
    	    legend: {
    	      // 如果series 对象有name 值，则 legend可以不用写data
    	      // 修改图例组件 文字颜色
    	      textStyle: {
    	        color: "#4c9bfd"
    	      },
    	      // 这个10% 必须加引号
    	      right: "10%"
    	    },
    	    grid: {
    	      top: "20%",
    	      left: "3%",
    	      right: "4%",
    	      bottom: "3%",
    	      show: true, // 显示边框
    	      borderColor: "#012f4a", // 边框颜色
    	      containLabel: true // 包含刻度文字在内
    	    },

    	    xAxis: {
    	      type: "category",
    	      boundaryGap: false,
    	      data: [
    	        "1月",
    	        "2月",
    	        "3月",
    	        "4月",
    	        "5月",
    	        "6月",
    	        "7月",
    	        "8月",
    	        "9月",
    	        "10月",
    	        "11月",
    	        "12月"
    	      ],
    	      axisTick: {
    	        show: false // 去除刻度线
    	      },
    	      axisLabel: {
    	        color: "#4c9bfd" // 文本颜色
    	      },
    	      axisLine: {
    	        show: false // 去除轴线
    	      }
    	    },
    	    yAxis: {
    	      type: "value",
    	      axisTick: {
    	        show: false // 去除刻度线
    	      },
    	      axisLabel: {
    	        color: "#4c9bfd" // 文本颜色
    	      },
    	      axisLine: {
    	        show: false // 去除轴线
    	      },
    	      splitLine: {
    	        lineStyle: {
    	          color: "#012f4a" // 分割线颜色
    	        }
    	      }
    	    },
    	    series: [
    	      {
    	        name: "蒙牛特仑苏低脂牛奶",
    	        type: "line",
    	        // true 可以让我们的折线显示带有弧度
    	        smooth: true,
    	        data: yearData[0].data[0]
    	      },
    	      {
    	        name: "伊利金典有机纯牛奶",
    	        type: "line",
    	        smooth: true,
    	        data: yearData[0].data[1]
    	      }
    	    ]
    	  };

    	  // 3. 把配置给实例对象
    	  myChart.setOption(option);
    	  // 4. 让图表跟随屏幕自动的去适应
    	  window.addEventListener("resize", function() {
    	    myChart.resize();
    	  });

    	  // 5.点击切换效果
    	  $("h2").on("click", "a", function() {
    	    // alert(1);
    	    // console.log($(this).index());
    	    // 点击 a 之后 根据当前a的索引号 找到对应的 yearData的相关对象
    	    // console.log(yearData[$(this).index()]);
    	    var obj = yearData[$(this).index()];
    	    option.series[0].data = obj.data[0];
    	    option.series[1].data = obj.data[1];
    	    // 需要重新渲染
    	    myChart.setOption(option);
    	 window.addEventListener("resize", function() {
    	    myChart.resize();
    	  });
    	  });
    	};
	</script>




    	
    <script>
    	// 饼形图2 地区分布模块
    	function bxchart() {
    	  var myChart = echarts.init(document.querySelector(".bxchart"));
    	  var option = {
    	    color: [
    	      "#006cff",
    	      "#60cda0",
    	      "#ed8884",
    	      "#ff9f7f",
    	      "#0096ff",
    	      "#9fe6b8",
    	      "#32c5e9",
    	      "#1d9dff",
    	      "#0058ff"
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
    	        color: "rgba(255,255,255,.5)",
    	        fontSize: "12"
    	      }
    	    },
    	    series: [
    	      {
    	        name: "聚划算占比",
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
    	        data: []
    	      }
    	    ]
    	  };
    	  myChart.setOption(option);
    	 window.addEventListener("resize", function() {
    	    myChart.resize();
    	  });
    	 myChart.showLoading();
    	 var nums=[];
    	 $.ajax({
    		 type:"post",
    	 	async:true,
    	 	url:"jhspricenumber.do",
    	 	data:{},
    	 	dataType:"json",
    	 	success:function(result){
    	 		if(result){
    	 			var jhssum=0;
    	 			for(var i=0;i<9;i++){
    	 				jhssum=jhssum+result[i].jhsprice_number;
    	 				
    	 			}
    	 			var sum=parseFloat(jhssum);
    	 			for(var i=0;i<9;i++){
    	 				nums.push({value:result[i].jhsprice_number,name:result[i].name});
    	 				console.log(Math.round(parseFloat(result[i].jhsprice_number)/sum*100));
    	 			}
    	 			myChart.hideLoading();
    	 			myChart.setOption({
    	 				series:[{
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





    <script >  //积分表模块
    function  jifenbiao(){
    	var myChart = echarts.init(document.getElementById('jifenbiao'));
    	var option = {
    	    xAxis: {
    	        splitLine: {
    	            show: false
    	        },
    	        axisLabel: {
    	            show: false
    	        },
    	        axisLine: {
    	            show: false
    	        }
    	    },
    	    yAxis: {
    	        splitLine: {
    	            show: false
    	        },
    	        axisLabel: {
    	            show: false
    	        },
    	        axisLine: {
    	            show: false
    	        }
    	    },
    	    series: [
    	        // 内圆
    	        {
    	            type: 'pie',
    	            radius: ['0', '25%'],
    	            center: ['50%', '50%'],
    	            z: 4,
    	            hoverAnimation: false,
    	            data: [{
    	                name: '积分',
    	                value: 1,
    	                itemStyle: {
    	                    normal: {
    	                        color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
    	                            offset: 0,
    	                            color: '#ffeb7b'
    	                        }, {
    	                            offset: 1,
    	                            color: '#ffeb7b'
    	                        }])
    	                    }

    	                },
    	                label: {
    	                    normal: {
    	                        rich: {
    	                            a: {
    	                                color: '#994D01',
    	                                align: 'center',
    	                                fontSize: 30,
    	                                padding: [0,0,56,0],
    	                                fontWeight: "bold"
    	                            },
    	                            b: {
    	                                color: '#AF6E2F',
    	                                align: 'center',
    	                                fontSize: 16,
    	                                fontWeight: "bold"
    	                            }
    	                        },
    	                        formatter: function(params) {
    	                            return "{a|" + params.value + "}\n\n" + "{b|" + "天猫超市" + "}";
    	                        },
    	                        position: 'center',
    	                        show: true
    	                    }
    	                },
    	                labelLine: {
    	                    show: false
    	                }
    	            }],
    	        },
    	        //进度图
    	        {
    	            type: 'gauge',
    	            radius: '55%',
    	            center: ['50%', '50%'],
    	            min: 0,
    	            max: 1000,
    	            z: 5,
    	            splitNumber: 1, //刻度数量
    	            startAngle: 220,
    	            endAngle: -40,
    	            animation: true,
    	            animationDuration: 10000,
    	            //分隔线样式。
    	            splitLine: {
    	                show: false,
    	            },
    	            axisTick: {
    	                show: false
    	            },
    	            title: {
    	                show: false
    	            },
    	            axisLabel: {
    	                color: 'rgba(255,255,255,0)',
    	                fontSize: 12,
    	            }, //刻度节点文字颜色
    	            detail: {
    	                show: false
    	            },
    	            axisLine: {
    	                show: true,
    	                lineStyle: {
    	                    width: 20,
    	                    color: [
    	                        [
    	                            0.02, new echarts.graphic.LinearGradient(
    	                                0, 0, 1, 0, [{
    	                                        offset: 0,
    	                                        color: '#F08E25'
    	                                    }, {
    	                                        offset: 0.5,
    	                                        color: '#F8B840'
    	                                    },
    	                                    {
    	                                        offset: 1,
    	                                        color: '#F6EC4F'
    	                                    }
    	                                ]
    	                            )
    	                        ],
    	                        [
    	                            1, new echarts.graphic.LinearGradient(
    	                                0, 0, 1, 0, [{
    	                                        offset: 0,
    	                                        color: 'rgba(255,255,255, 0.3)'
    	                                    }, {
    	                                        offset: 0.5,
    	                                        color: 'rgba(255,255,255, 0.2)'
    	                                    },
    	                                    {
    	                                        offset: 1,
    	                                        color: 'rgba(255,255,255, 0.1)'
    	                                    }
    	                                ]
    	                            )
    	                        ]
    	                    ]
    	                }
    	            }
    	        },
    	        //刻度尺
    	        {
    	            type: "gauge",
    	            radius: "56%",
    	            startAngle: 220,
    	            endAngle: -40,
    	            z: 2,
    	            axisTick: {
    	                show: true,
    	                lineStyle: {
    	                    color: '#fff',
    	                    width: 1
    	                },
    	                length: -8
    	            }, //刻度样式
    	            splitLine: {
    	                show: true,
    	                lineStyle: {
    	                    color: '#fff',
    	                    width: 1
    	                },
    	                length: -8
    	            }, //分隔线样式
    	            axisLabel: {
    	                color: 'rgba(255,255,255,0)',
    	                fontSize: 12,
    	            }, //刻度节点文字颜色
    	            pointer: {
    	                show: false
    	            },
    	            axisLine: {
    	                show: false
    	            },
    	            label: {
    	                show: false
    	            },
    	            //仪表盘详情，用于显示数据。
    	            detail: {
    	                show: true,
    	                offsetCenter: [8, '98%'],
    	                color: '#fff',
    	                formatter: function(params) {
    	                    return '- 销量遥遥领先-'
    	                },
    	                textStyle: {
    	                    fontSize: 20
    	                }
    	            }
    	        },
    	        // 外一层圈
    	        {
    	            type: "pie",
    	            radius: "30%",
    	            startAngle: 220,
    	            endAngle: -40,
    	            hoverAnimation: false,
    	            center: ["50%", "50%"],
    	            avoidLabelOverlap: false,
    	            label: {
    	                show: false
    	            },
    	            labelLine: {
    	                show: false
    	            },
    	            data: [{
    	                value: 1
    	            }],
    	            itemStyle: {
    	                normal: {
    	                    color: {
    	                        type: "linear",
    	                        x: 0,
    	                        y: 0,
    	                        x2: 0,
    	                        y2: 1,
    	                        colorStops: [{
    	                            offset: 0,
    	                            color: "#FDE35A"
    	                        }, {
    	                            offset: 1,
    	                            color: "#F28930"
    	                        }]
    	                    }
    	                }
    	            }
    	        },
    	        //外二层圈
    	        {
    	            type: "pie",
    	            radius: "35%",
    	            center: ["50%", "50%"],
    	            avoidLabelOverlap: false,
    	            z: 0,
    	            hoverAnimation: false,
    	            label: {
    	                show: false
    	            },
    	            labelLine: {
    	                show: false
    	            },
    	            data: [{
    	                "value": 1
    	            }],
    	            itemStyle: {
    	                normal: {
    	                    color: {
    	                        type: "linear",
    	                        x: 0,
    	                        y: 0,
    	                        x2: 0,
    	                        y2: 1,
    	                        colorStops: [{
    	                            offset: 0,
    	                            color: "rgba(253, 227, 90, 0.25)"
    	                        }, {
    	                            offset: 1,
    	                            color: "rgba(253, 227, 90, 0)"
    	                        }]
    	                    }
    	                }
    	            }
    	        },
    	        //最外层圈
    	        {
    	            type: "pie",

    	            radius: "40%",
    	            center: ["50%", "50%"],
    	            avoidLabelOverlap: false,
    	            z: 0,
    	            hoverAnimation: false,
    	            label: {
    	                show: false,
    	            },
    	            labelLine: {
    	                show: false
    	            },
    	            data: [{
    	                value: 1
    	            }],
    	            itemStyle: {
    	                normal: {
    	                    color: {
    	                        type: "linear",
    	                        x: 0,
    	                        y: 0,
    	                        x2: 0,
    	                        y2: 1,
    	                        colorStops: [{
    	                                offset: 0,
    	                                color: "rgba(253, 227, 90, 0.2)"
    	                            },
    	                            {
    	                                offset: 1,
    	                                color: "rgba(249, 137, 27, 0)"
    	                            }
    	                        ]
    	                    }
    	                }
    	            }
    	        }
    	    ]
    	}
    	myChart.setOption(option) ;
    	}

</script>


   
   
   <script >//详细数据模块
   function detail(){
	   var myChart2 = echarts.init(document.getElementById('detail'));
	   var links = []
	   // =======================
	   // 人员信息数据
	   
	   // =======================
	   // 人员关系数据
	   var nodes=[]
	   var infos = {};
	   var legend = new Set()
	   echar_data = []
	   echar_links = []
	   myChart2.showLoading();
    	
    	 $.ajax({
    		 type:"post",
    	 	async:true,
    	 	url:"commoditydetail.do",
    	 	data:{},
    	 	dataType:"json",
    	 	success:function(result){
    	 		if(result){
    	 			for(var i=0;i<9;i++){
    	 				links.push({source:result[i].name,target:result[(i+1)%9].name,value:''});
    	 			}
    	 			for(var i=0;i<9;i++){
    	 				nodes.push({
    	 		           '类别':result[i].name,
    	 		           '库存':result[i].stock,
    	 		           '保质期':result[i].baozhidate ,
    	 		          '评论数': result[i].commentamount,
    	 		         '配料': result[i].material,
    	 		      });	
    	 				
    	 			}
    	 			for (var node of nodes){
    	 				  
    	 		       if(node['类别'] in infos){
    	 		           window.alert('类别重复，请修改: ' + node['类别'])
    	 		       }
    	 		       
    	 		       infos[node['类别']] = Object.assign({}, node);
    	 		       
    	 		   }
    	 		   // 检查边的links的姓名是否都出现在nodes中
    	 		   for(var link of links){
    	 		       if( !( (link.source in infos) && (link.target in infos) ) ){
    	 		           window.alert('类别未出现导致边非法:' + link)
    	 		       }
    	 		       
    	 		   }
    	 		  for (var node of nodes){
    	 		       legend.add(node['类别']);
    	 		   }
    	 		   legend = Array.from(legend);
    	 		   legend.sort(); 

    	 		  
    	 		   for (var node of nodes){
    	 			  console.log(node);
    	 		       echar_data.push({
    	 		                   name: node['类别'],
    	 		                   category:  legend.findIndex((element) => element == node['类别']),
    	 		                   draggable: true,
    	 		               })
    	 		   }

    	 		  
    	 		   for(var link of links){
    	 			  
    	 		       echar_links.push({
    	 		                   source: link.source,
    	 		                   target: link.target,
    	 		                   value: link.value
    	 		               })
    	 		               
    	 		   } 
    	 			myChart2.hideLoading();
    	 			option2 = {
    	 			       title: {
    	 			           text: '商品详细信息',
    	 			          textStyle: {
    	 			               color: "#ffeb7b"
    	 			           } 
    	 			       },
    	 			       tooltip: {
    	 			           trigger: 'item',
    	 			           formatter: function(params) {
    	 			               if(params.dataType == 'edge'){
    	 			                   var info = '<p style="font-size:14px">' + params.name + '</p>'
    	 			                   info = info + '<p style="font-size:14px">' + params.value + '</p>'
    	 			                   return info;
    	 			               }
    	 			               
    	 			               if (params.name in infos) {
    	 			                   var info = '<p style="font-size:14px">' + params.name + '</p>'
    	 			                   for (var p in infos[params.name]) {
    	 			                       info = info + '<p style = "font-size:12px" >' + p + ':' + infos[params.name][p] + '</p>'
    	 			                   }
    	 			                   return info;
    	 			               }
    	 			           },
    	 			           backgroundColor: "#ff7f50", //提示标签背景颜色 
    	 			           textStyle: {
    	 			               color: "#fff"
    	 			           } //提示标签字体颜色 
    	 			       },
    	 			       animationDurationUpdate: 1500,
    	 			       animationEasingUpdate: 'quinticInOut',
    	 			       label: {
    	 			           normal: {
    	 			               show: true,
    	 			               textStyle: {
    	 			                   fontSize: 12
    	 			               },
    	 			           }
    	 			       },
    	 			       legend: {
    	 			           x: "center",
    	 			           show: true,
    	 			           data: legend 
    	 			       },
    	 			       series: [
    	 			           {
    	 			               type: 'graph',
    	 			               layout: 'force',
    	 			               symbolSize: 45,
    	 			               focusNodeAdjacency: true,
    	 			               roam: true,
    	 			               categories: [{
    	 			                   name: legend[0],
    	 			                   itemStyle: {
    	 			                       normal: {
    	 			                           color: "#009800",
    	 			                       }
    	 			                   }
    	 			               }, {
    	 			                   name: legend[1],
    	 			                   itemStyle: {
    	 			                       normal: {
    	 			                           color: "#9592FF",
    	 			                       }
    	 			                   }
    	 			               }, {
    	 			                   name: legend[2],
    	 			                   itemStyle: {
    	 			                       normal: {
    	 			                           color: "#3592FF",
    	 			                       }
    	 			                   }
    	 			               },
    	 			                {
    	 			                   name: legend[3],
    	 			                   itemStyle: {
    	 			                       normal: {
    	 			                           color: "#33362F",
    	 			                       }
    	 			                   }
    	 			               },
    	 			                {
    	 			                   name: legend[4],
    	 			                   itemStyle: {
    	 			                       normal: {
    	 			                           color: "#31592F",
    	 			                       }
    	 			                   }
    	 			               },
    	 			                {
    	 			                   name: legend[5],
    	 			                   itemStyle: {
    	 			                       normal: {
    	 			                           color: "#36782F",
    	 			                       }
    	 			                   }
    	 			               },
    	 			                {
    	 			                   name: legend[6],
    	 			                   itemStyle: {
    	 			                       normal: {
    	 			                           color: "#31892F",
    	 			                       }
    	 			                   }
    	 			               },
    	 			                {
    	 			                   name: legend[7],
    	 			                   itemStyle: {
    	 			                       normal: {
    	 			                           color: "#31122F",
    	 			                       }
    	 			                   }
    	 			               },
    	 			                {
    	 			                   name: legend[8],
    	 			                   itemStyle: {
    	 			                       normal: {
    	 			                           color: "#33392F",
    	 			                       }
    	 			                   }
    	 			               }],
    	 			               label: {
    	 			                   normal: {
    	 			                       show: true,
    	 			                       textStyle: {
    	 			                           fontSize: 12
    	 			                       },
    	 			                   }
    	 			               },
    	 			               force: {
    	 			                   repulsion: 1000
    	 			               },
    	 			               edgeSymbolSize: [4, 50],
    	 			               edgeLabel: {
    	 			                   normal: {
    	 			                       show: true,
    	 			                       textStyle: {
    	 			                           fontSize: 10
    	 			                       },
    	 			                       formatter: "{c}"
    	 			                   }
    	 			               },
    	 			               data: echar_data,
    	 			               links: echar_links,
    	 			               lineStyle: {
    	 			                   normal: {
    	 			                       opacity: 0.9,
    	 			                       width: 1,
    	 			                       curveness: 0
    	 			                   }
    	 			               }
    	 			           }
    	 			       ]
    	 			   };
    	 			   myChart2.setOption(option2) ;
    	 		}	
    	 	},
    		error:function(errorMsg){
    			alert("图表数据请求失败！");
    			myChart.hideLoading();
    		}	 
    	 })
	  
	   // =======================
			
	   //数据正确性检查
	   //检查节点是否有重复人名
	   
	   

	   //格式化输入数据
	  
	   

	   
	   }
   </script>
   
   
   
   
   
   
   
   
   <script >//时间模块
   var t = null;
   t = setTimeout(time, 1000); //開始运行
   function time() {
     clearTimeout(t); //清除定时器
     dt = new Date();
     var y = dt.getFullYear();
     var mt = dt.getMonth() + 1;
     var day = dt.getDate();
     var h = dt.getHours(); //获取时
     var m = dt.getMinutes(); //获取分
     var s = dt.getSeconds(); //获取秒
     document.querySelector(".showTime").innerHTML =
       "当前时间：" +
       y +
       "年" +
       mt +
       "月" +
       day +
       "-" +
       h +
       "时" +
       m +
       "分" +
       s +
       "秒";
     t = setTimeout(time, 1000); //设定定时器，循环运行
   }
   </script>  
</head>
<body>
<header>
	<a   href="home" style="text-decoration:none"><span class="left">买家中心</span>
    <h1>天猫超市销售数据实时监控</h1> </a>  
    <div class="showTime"></div>
    <script>time</script>
</header>
 <div class="main_box">
	<div class="column1">
		<h2><a href="DealServlet?action=show" >商品总销量</a>                
                    </h2>
		<div class="zzchart" style="width:500px;height:300px; "></div>
          			<script>zzchart();</script>
		<h2><a href="DealServlet?action=show" >商品月销量趋势</a> <a href="javacript:;">2021</a><a href="javascript:;">2020</a></h2>
          		<div class="zxchart" style="width:500px;height:500px;"></div>
	 		<script  type="text/javascript">zxchart();</script></div>      
	<div class="column2">
        <div id="jifenbiao" style="width:550px;height:300px; "></div>
         	 <script>jifenbiao();</script>
		<h2><a href="SpServlet?action=show" >商品详情</a></h2>
		<div id="detail" style="width:550px;height:800px;"></div>
			<script  type="text/javascript">detail();</script>
	</div>

	<div class="column3">
		<h2><a href="SpServlet?action=show" >商品回购率</a></h2>
		<div class="zzchart2" style="width:500px;height:300px; "></div>
          			<script>zzchart2();</script>
		<h2><a href="SpServlet?action=show" >聚划算活动销量占比统计 </a></h2>
          		<div class="bxchart" style="width:500px;height:550px;background: rgba(255, 255, 255, 0.03);border-radius:5px;"></div>
			 <script  type="text/javascript">bxchart();</script></div>

</div>	
</body>
</html>
