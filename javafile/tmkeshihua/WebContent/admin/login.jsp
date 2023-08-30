<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>卖家登录</title>
		<base href="<%=web.util.BasePath.get(request)%>" />
		<link rel="stylesheet" type="text/css" href="css/login.css">
		
		<style>
			.form{width: 1130px;height:500px;background: url('images/admin/login.jpg')no-repeat center center; }
		</style>
	</head>
	<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="home" target="_blank"><img src="images/logo.jpg" alt=""></a>
			</div>
		</div>
		<form  method="post" action="LoginServlet" class="form center">
		<input type="hidden" name="action" value="admindologin"/>
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="RegisterServlet?action=adminRegister" target="_self">免费注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">用户名:&nbsp;<input class="shurukuang" type="text" name="userName" placeholder="请输入你的用户名"/></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password" name="userPassword" placeholder="请输入你的密码"/></div>
					<div class="username">
						<div class="left fl">验证码:&nbsp;<input class="yanzhengma" type="text" name="userYanzhengma" placeholder="请输入验证码"/></div>
						<div class="right fl"><img src="images/yanzhengma.jpg"></div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="login_submit">
					<input class="submit" type="submit" name="submit" value="立即登录"/>
				</div>
				
			</div>
		</div>
		</form>
	</body>
</html>