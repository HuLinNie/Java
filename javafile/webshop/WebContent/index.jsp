<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, web.bean.*"%>
<!DOCTYPE html>
<html lang="en">
<body>
<head>
<title>青欢快送</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
				<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
<!--slider-script-->
		<script src="js/responsiveslides.min.js"></script>
			<script>
				$(function () {
				  $("#slider1").responsiveSlides({
					auto: true,
					speed: 500,
					namespace: "callbacks",
					pager: true,
				  });
				});
			</script>
<!--//slider-script-->
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>
</head>
<body>
  <!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">	
			<div class="header-top-in">			
				<div class="logo">
					<a href="index.html"><img src="images/logo2.png" alt=" " ></a>
				</div>
				<div class="header-in">
					<ul class="icon1 sub-icon1">
							<li  ><a href="login.jsp">登录</a> </li>
							<li  ><a href="register.jsp"> 注册</a></li>
							<li ><a href="购物车.html" >购物车</a></li>
							<li > <a href="客服.html" >客服</a> </li>	
							<li><div class="cart">
									<a href="#" class="cart-in"> </a>
									<span> 2</span>
								</div>
								<ul class="sub-icon1 list">
						  <h3>最近添加</h3>
						  <div class="shopping_cart">
							  <div class="cart_box">
							   	 <div class="message">
							   	     <div class="alert-close"> </div> 
					                <div class="list_img"><img src="images/1.jpeg" class="img-responsive" alt=""></div>
								    <div class="list_desc"><h4><a href="#">崂山矿泉水</a></h4>24x<span class="actual">
		                             ￥48.00</span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                            <div class="cart_box1">
								  <div class="message1">
							   	     <div class="alert-close1"> </div> 
					                <div class="list_img"><img src="images/2.jpeg" class="img-responsive" alt=""></div>
								    <div class="list_desc"><h4><a href="#">白花蛇草水</a></h4>1x<span class="actual">
		                             ￥120.00</span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                        </div>
	                        <div class="total">
	                        	<div class="total_left">购物车小计: </div>
	                        	<div class="total_right">￥168.00</div>
	                        	<div class="clearfix"> </div>
	                        </div>
                            <div class="login_buttons">
							  <div class="check_button"><a href="checkout.html">查看</a></div>
							  <div class="clearfix"></div>
						    </div>
					      <div class="clearfix"></div>
						</ul>
							</li>
						</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			</div>
		</div>
		<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
			<a class="toggleMenu" href="#">Menu</a>
				<div class="nav">
					<li class="active"><a href="首页.html"><i> </i>首页</a></li>
					</a>
						
						</li> 						
						<li><a href="商家推荐.html" >商家推荐</a></li>            
						<li><a href="动态新闻.html" >动态新闻</a></li>						  				 
					   <li><a href="联系我们.html" >联系我们</a></li>	
					   <div class="search">
						<form>
							<input type="text" value="搜索...." onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '';}" >
							<input type="submit" value="">
						</form>
					</div>
					</div>	
					</div>
					
				<script type="text/javascript" src="js/nav.js"></script>
			
			
		</div>
		</div>
		
		
	
			
				<div class="banner-mat">
		<div class="container">
			<div class="banner">
	
				<!-- Slideshow 4 -->
			   <div class="slider">
			<ul class="rslides" id="slider1">
			  <li><img src="images/34.jpg" alt="">
			  </li>
			   <li><img src="images/32.png" alt="">
			  </li>
			  <li><img src="images/7.png" alt="">
			  </li>
			  <li><img src="images/8.png" alt="">
			  </li>
			  <li><img src="images/3.png" alt="">
			  </li>
			  
			</ul>
		</div>

				<div class="banner-bottom">
					<div class="banner-matter">
						<p>崂山桶装水，喝过才知道！</p>
						<a href="商品.html" class="hvr-shutter-in-vertical ">购买</a>
					</div>
					
					<div class="clearfix"></div>
				</div>
			</div>				
			<!-- //slider-->
		</div>
	</div>
		<!---->
		<div class="container">
			<div class="content">
				<div class="content-top">
					<h3 class="future">精选</h3>
					<div class="content-top-in">
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href=""><img  src="images/10.png" alt="" /></a>	
								<div class="top-content">
									<h5><a href="商品.html">崂山桶装水</a></h5>
									<div class="white">
										<a href="" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">加入购物车</a>
										<p class="dollar"><span class="in-dollar">￥</span><span>3</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>

								</div>							
							</div>
						</div>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href=""><img  src="images/1.jpeg" alt="" /></a>	
								<div class="top-content">
									<h5><a href="">崂山矿泉水24瓶</a></h5>
									<div class="white">
										<a href="" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">加入购物车</a>
										<p class="dollar"><span class="in-dollar">￥</span><span>4</span><span>8</span></p>
										<div class="clearfix"></div>
									</div>

								</div>							
							</div>
						</div>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href=""><img  src="images/2.jpeg" alt="" /></a>	
								<div class="top-content">
									<h5><a href="">白花蛇草水10瓶</a></h5>
									<div class="white">
										<a href="" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">加入购物车</a>
										<p class="dollar"><span class="in-dollar">￥</span><span>5</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href=""><img  src="images/4.jpeg" alt="" /></a>	
								<div class="top-content">
									<h5><a href="">崂山可乐24瓶</a></h5>
									<div class="white">
										<a href="" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">加入购物车</a>
										<p class="dollar"><span class="in-dollar">￥</span><span>4</span><span>8</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						
                       <!---->
				<div class="container2">
			<div class="content">
				<div class="content-top">
					<h3 class="future"></h3>
					<div class="content-top-in">
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href=""><img  src="images/11.jpeg" alt="" /></a>	
								<div class="top-content">
									<h5><a href="">崂山原味苏打水10瓶</a></h5>
									<div class="white">
										<a href="" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">加入购物车</a>
										<p class="dollar"><span class="in-dollar">￥</span><span>4</span><span>5</span></p>
										<div class="clearfix"></div>
									</div>

								</div>							
							</div>
						</div>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href=""><img  src="images/12.jpeg" alt="" />	</a>
								<div class="top-content">
									<h5><a href="">崂山柠檬味苏打水10瓶</a></h5>
									<div class="white">
										<a href="" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">加入购物车</a>
										<p class="dollar"><span class="in-dollar">￥</span><span>4</span><span>5</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href=""><img  src="images/5.jpeg" alt="" /></a>	
								<div class="top-content">
									<h5><a href="">崂山西柚味苏打水10瓶</a></h5>
									<div class="white">
										<a href="" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">加入购物车</a>
										<p class="dollar"><span class="in-dollar">￥</span><span>4</span><span>5</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						
					
                       <div class="col-md-3 md-col">
							<div class="col-md">
								<a href=""><img  src="images/13.jpeg" alt="" /></a>	
								<div class="top-content">
									<h5><a href="">崂山珍品矿泉水</a></h5>
									<div class="white">
										<a href="" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">加入购物车</a>
										<p class="dollar"><span class="in-dollar">￥</span><span>2</span><span>2</span></p>
										<div class="clearfix"></div>
									</div>

								</div>							
							</div>
						</div>
						<!---->
						</div>
				</div>
				<ul class="start">
					<li ><a href="#"><i></i></a></li>
					<li><span>1</span></li>
					<li class="arrow"><a href="#">2</a></li>
					<li class="arrow"><a href="#">3</a></li>
					<li class="arrow"><a href="#">4</a></li>
					<li class="arrow"><a href="#">5</a></li>
					<li ><a href="#"><i  class="next"> </i></a></li>
				</ul>
			</div>
		</div>
						
			<!---->
			<div class="footer-middle">
				<div class="container">
					<div class="footer-middle-in">
						<h6>关于我们</h6>
						<p>青饮快送是青岛饮料集团有限公司旗下产品的网上购物商城，这里优惠多多，欢迎您在线选购！</p>
					</div>
					<div class="footer-middle-in">
						<h6>信息</h6>
						<ul>
							<li><a href="#">关于我们</a></li>
							<li><a href="#">配送信息</a></li>
							<li><a href="#">隐私政策</a></li>
							<li><a href="#">条款及细则</a></li>
						</ul>
					</div>
					<div class="footer-middle-in">
						<h6>客户服务</h6>
						<ul>
							<li><a href="联系我们.html">联系我们</a></li>
							<li><a href="#">退货</a></li>
							<li><a href="#">网站地图</a></li>
						</ul>
					</div>
					<div class="footer-middle-in">
						<h6>我的账户</h6>
						<ul>
							<li><a href="">我的账户</a></li>
							<li><a href="#">订单历史</a></li>
							<li><a href="">愿望清单</a></li>
							
						</ul>
					</div>
					<div class="footer-middle-in">
						<h6>附加功能</h6>
						<ul>
							<li><a href="#">品牌</a></li>
							<li><a href="#">购物券</a></li>
							<li><a href="#">会员</a></li>
							<li><a href="#">特价商品</a></li>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<p class="footer-class">Copyright &copy; 2020.青饮快送</a></a></p>
			<script type="text/javascript">
						$(document).ready(function() {
							/*
							var defaults = {
					  			containerID: 'toTop', // fading element id
								containerHoverID: 'toTopHover', // fading element hover id
								scrollSpeed: 1200,
								easingType: 'linear' 
					 		};
							*/
							
							$().UItoTop({ easingType: 'easeOutQuart' });
							
						});
					</script>
				<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>

		</div>

</body>
</html>