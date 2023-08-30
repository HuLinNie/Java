<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, web.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<title>登录</title>
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
<!--fonts-->
<link href='https://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!--//fonts-->
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
		                             48.00</span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                            <div class="cart_box1">
								  <div class="message1">
							   	     <div class="alert-close1"> </div> 
					                <div class="list_img"><img src="images/2.jpeg" class="img-responsive" alt=""></div>
								    <div class="list_desc"><h4><a href="#">白花蛇草水</a></h4>1x<span class="actual">
		                             120.00</span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                        </div>
	                        <div class="total">
	                        	<div class="total_left">购物车小计: </div>
	                        	<div class="total_right">168.00</div>
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
					  
					</div>	
					</div>
					
				<script type="text/javascript" src="js/nav.js"></script>
			
			
		</div>
		</div>
					
		
		
	
			<div class="container">
		<div class="account">
			<h2 class="account-in">用户</h2>
				<form action="LoginServlet" method="post">
				<div>
					<span>用户名：</span>
					<input type="text" name="userName"/>
				</div> 			
				
				<div> 
					<span class="word">密&nbsp;&nbsp;码：</span>
					<input type="password" name="userPassword">
				</div>	
					<input type="hidden" name="action" value="dologin"/> 			
					<input type="submit" value="登录"> 
				</form>
		</div>
	</div>
</body>
</html>