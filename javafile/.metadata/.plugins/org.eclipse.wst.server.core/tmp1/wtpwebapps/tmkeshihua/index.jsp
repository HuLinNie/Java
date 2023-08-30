<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, web.bean.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>天猫超市乳饮品</title>
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
	 <jsp:include page="jsp/template/_header.jsp" />
  <!-- banner star -->
    <div class="banner">
        <div class="in">
            <ul class="in-ul">
                <li><a href="#"><img src="images/sg1.jpg" alt="秦皇岛旅游景点"/></a></li>
                <li><a href="#"><img src="images/sg2.jpg" alt="秦皇岛旅游景点"/></a></li>
                <li><a href="#"><img src="images/sg3.jpg" alt="秦皇岛旅游景点"/></a></li>
                <!-- again! -->
                <li><a href="#"><img src="images/sg1.jpg" alt="秦皇岛旅游景点"/></a></li>
                <li><a href="#"><img src="images/sg2.jpg" alt="秦皇岛旅游景点"/></a></li>
                <li><a href="#"><img src="images/sg3.jpg" alt="秦皇岛旅游景点"/></a></li>
            </ul>
            <div class="in-left">
                    <div class="subnav">
                            <ul>
                                <li style="color:#fff;">商品分类</li>
                                <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a></li>
                                <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a></li>
                                <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a></li>
                                <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a></li>
                                <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a></li>
                                <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a></li>
                                <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a></li>
                                <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a></li>
                                <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a></li>
                            </ul>
                    </div>
            </div>
            <div class="in-right">
                    <div class="subnav">
                            <ul>
                                <li style="color:#fff;">附近超市</li>
                                <li><a href="#">书儒超市<span> > </span></a></li>
                                <li><a href="#">书儒超市<span> > </span></a></li>
                                <li><a href="#">书儒超市<span> > </span></a></li>
                                <li><a href="#">书儒超市<span> > </span></a></li>
                                <li><a href="#">书儒超市<span> > </span></a></li>
                                <li><a href="#">书儒超市<span> > </span></a></li>
                                <li><a href="#">书儒超市<span> > </span></a></li>
                                <li><a href="#">书儒超市<span> > </span></a></li>
                                <li><a href="#">书儒超市<span> > </span></a></li>
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
                <div>热门商品</div>
                <li><a href="#">泡面</a></li>
                <li><a href="#">苹果</a></li>
                <li><a href="#">洗衣液</a></li>
                <li><a href="#">矿泉水</a></li>
                <li><a href="#">饮料</a></li>
                <li><a href="#">面巾纸</a></li>
                <li><a href="#">钢笔</a></li>
                <li><a href="#">东大方格纸</a></li>
                <li><a href="#">牛奶</a></li>
                <li><a href="#">面包</a></li>
                <li><a href="#">东大方格纸</a></li>
                <li><a href="#">2B铅笔</a></li>
                <li><a href="#">文件夹</a></li>
                <li><a href="#">薯片</a></li>
                <span><a href="#">去选购！</a></span>
            </ul>
        </div>
    <!-- libanner end -->
    </div>
    <div class="pro">
        <div>商品推荐</div>
        <!-- <a href="index.html">查看全部</a> -->
    </div>
    <!-- little banner end -->
    <!-- product begin -->
    <div class="product-max">
        <ul>
            <li>
                <div>
                    <div class="p-image"><img src="images/sg1.jpg" /></div>
                    <div class="head"><a href="#">山海关樱桃 20/kg</a></div>
                    <p>
                        <span>站主推荐</span>· 666人已购买
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sg2.jpg" /></div>
                    <div class="head"><a href="#">菠萝蜜 25/kg</a></div>
                    <p>
                        <span>站主推荐</span>· 600人已购买
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sg3.jpg" /></div>
                    <div class="head"><a href="#">苹果 5/kg</a></div>
                    <p>
                        <span>站主推荐</span>· 666人购买
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sg4.jpg" /></div>
                    <div class="head"><a href="#">猕猴桃 5/kg</a></div>
                    <p>
                        <span>站主推荐</span>· 666人已购买
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sg5.jpg" /></div>
                    <div class="head"><a href="#">山竹 8/kg</a></div>
                    <p>
                        <span>站主推荐</span>· 66购买
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sg6.jpg" /></div>
                    <div class="head"><a href="#">榴莲 40/个</a></div>
                    <p>
                        <span>站主强推</span>· 66+购买
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sg7.jpg" /></div>
                    <div class="head"><a href="#">新疆哈密瓜 4/kg</a></div>
                    <p>
                        <span>同学推荐</span>· 666人在看
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/sg8.jpg" /></div>
                    <div class="head"><a href="#">凤梨 4/kg</a></div>
                    <p>
                        <span>一致好评</span>· 66人在看
                    </p>
                </div>
            </li>
             <li>
                <div>
                    <div class="p-image"><img src="images/12.jpg" /></div>
                    <div class="head"><a href="#">同花菜 4/kg</a></div>
                    <p>
                        <span>大妈说好</span>· 666人在看
                    </p>
                </div>
            </li>
            <li>
                <div>
                    <div class="p-image"><img src="images/10.jpg" /></div>
                    <div class="head"><a href="#">莴苣 4/kg</a></div>
                    <p>
                        <span>市民最爱</span>· 666人在看
                    </p>
                </div>
            </li>
        </ul>
    </div>
   <!-- product end -->
    <!-- footer start -->
    
     
    	<script>
    	move(100);
    	document.getElementById("progress").style.display="none";
    	</script>
    <jsp:include page="jsp/template/_bottom.jsp" />	
    
</body>
</html>