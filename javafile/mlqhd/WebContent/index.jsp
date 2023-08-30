<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, web.bean.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>魅力秦皇岛</title>
	<base href="<%=web.util.BasePath.get(request)%>" />
	<link rel="stylesheet" type="text/css" href="css/index.css" />
	<style>
		#progress{
				position:fixed;
				background:#000;
				top:0;
				left:0;
				width:100%;
				height:100%;
				z-index:9999;	
					}
		#progress p{
				width:500px;
				height:30px;
				border-radius:3px;
				background:#ffffcc;
				color:#330000;
				font-size:14px;
				line-height:30px;
				text-align:center;
				overflow:hidden;
				font-family:'宋体';
				position:absolute;
				top:50%;
				left:50%;
				margin-top:-15px;
				margin-left:-250px;			
				}
	</style>
</head>
	
<body>
	<div id='progress'>
		<p>0%</p>
	</div>
	
	<script>
		var oP=document.getElementById('progress').getElementsByTagName('p')[0];
		function move(num){clearInterval(oP.timer);
		oP.timer = setInterval(function(){
			if (parseInt(oP.innerHTML)<num){
				var s = parseInt(oP.innerHTML)+1;
				var w = 500*s/100;
				oP.innerHTML = s+'%';
				oP.style.width = w+'px';
			}
			else{
				clearInterval(oP.timer);
			}
		},60);
		};
	</script>
	 <jsp:include page="jsp/_header.jsp" />
   <!-- banner star -->
    <div class="banner">
        <div class="in">
            <ul class="in-ul">
                <li><a href="#"><img src="images/in1.jpg" alt="秦皇岛旅游景点"/></a></li>
                <li><a href="#"><img src="images/in2.jpg" alt="秦皇岛旅游景点"/></a></li>
                <li><a href="#"><img src="images/in4.jpg" alt="秦皇岛旅游景点"/></a></li>
                <!-- again! -->
                <li><a href="#"><img src="images/in1.jpg" alt="秦皇岛旅游景点"/></a></li>
                <li><a href="#"><img src="images/in2.jpg" alt="秦皇岛旅游景点"/></a></li>
                <li><a href="#"><img src="images/in4.jpg" alt="秦皇岛旅游景点"/></a></li>
            </ul>
            <div class="in-left">
                    <div class="subnav">
                            <ul>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                            </ul>
                    </div>
            </div>
            <div class="in-right">
                    <div class="subnav">
                            <ul>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                            </ul>
                    </div>
            </div>
        </div>
    </div>
    <!-- banner end -->
    <!-- little banner star -->
    <div class="libanner">
        <div class="libanner-left">
            <ul>
                <div>景点推荐</div>
                <li><a href="#">鸽子窝公园</a></li>
                <li><a href="#">老虎石海上公园</a></li>
                <li><a href="#">山海关</a></li>
                <li><a href="#">秦皇野生动物园</a></li>
                <li><a href="#">翡翠岛</a></li>
                <li><a href="#">碧螺塔海上公园</a></li>
                <li><a href="#">祖山风景区</a></li>
                <li><a href="#">冰糖峪</a></li>
                <li><a href="#">求仙入海处</a></li>
                <li><a href="#">孟姜女庙</a></li>
                <span><a href="#">去逛逛</a></span>
            </ul>
        </div>
    <!-- libanner end -->
    </div>
    <div class="pro">
        <div>景点推荐</div>
        <!-- <a href="index.html">查看全部</a> -->
    </div>
    <!-- little banner end -->
    <!-- product begin -->
    <div class="product-max">
        <ul>
            <li>
                <div>
                    <div class="p-image"><img src="images/sp.jpg" /></div>
                    <div class="head"><a href="#">老虎石海上公园 4A级景区</a></div>
                    <p>
                        <span>网红打卡</span>· 666人在看
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sp.jpg" /></div>
                    <div class="head"><a href="#">老虎石海上公园 4A级景区</a></div>
                    <p>
                        <span>网红打卡</span>· 666人在看
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sp.jpg" /></div>
                    <div class="head"><a href="#">老虎石海上公园 4A级景区</a></div>
                    <p>
                        <span>网红打卡</span>· 666人在看
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sp.jpg" /></div>
                    <div class="head"><a href="#">老虎石海上公园 4A级景区</a></div>
                    <p>
                        <span>网红打卡</span>· 666人在看
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sp.jpg" /></div>
                    <div class="head"><a href="#">老虎石海上公园 4A级景区</a></div>
                    <p>
                        <span>网红打卡</span>· 666人在看
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sp.jpg" /></div>
                    <div class="head"><a href="#">老虎石海上公园 4A级景区</a></div>
                    <p>
                        <span>网红打卡</span>· 666人在看
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sp.jpg" /></div>
                    <div class="head"><a href="#">老虎石海上公园 4A级景区</a></div>
                    <p>
                        <span>网红打卡</span>· 666人在看
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sp.jpg" /></div>
                    <div class="head"><a href="#">老虎石海上公园 4A级景区</a></div>
                    <p>
                        <span>网红打卡</span>· 666人在看
                    </p>
                </div>
            </li>
             <li>
                <div>
                    <div class="p-image"><img src="images/sp.jpg" /></div>
                    <div class="head"><a href="#">老虎石海上公园 4A级景区</a></div>
                    <p>
                        <span>网红打卡</span>· 666人在看
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sp.jpg" /></div>
                    <div class="head"><a href="#">老虎石海上公园 4A级景区</a></div>
                    <p>
                        <span>网红打卡</span>· 666人在看
                    </p>
                </div>
            </li>
        </ul>
    </div>
   <!-- product end -->
    <!-- footer start -->
    <div class="footer">
        <div class="footer-left">
            <p>秦皇岛欢迎您 热爱旅游的您 热爱文化的您<br>
                © 2019年YY Inc.保留所有权利。-冀ICP备18016532号
            </p>
            <!-- <a href="index.html">下载APP</a> -->
        </div>
        <div class="footer-right">
            <dl>
                <dt>关于我们</dt>
                <dd>联系方式</dd>
                <dd>管理团队</dd>
                <dd>在线客服</dd>
                <dd>问题咨询</dd>
                <dd>帮助</dd>
            </dl>
            <dl>
                <dt>建议</dt>
                <dd>网站建议</dd>
                <dd>布局建议</dd>
                <dd>其他建议</dd>
            </dl>
            <dl>
                <dt>联系方式</dt>
                <dd>QQ</dd>
                <dd>微信</dd>
                <dd>微博</dd>
            </dl>
            
        </div>
    </div>
    <!-- footer end -->
     
    	<script>
    	move(100);
    	document.getElementById("progress").style.display="none";
    	</script>
    	
    
</body>
</html>