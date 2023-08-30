<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="shopping.util.BasePath"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>UserRegister</title>
	<base href="<%=BasePath.get(request)%>" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<jsp:include page="../_header.jsp" />
	<div class="form-wrapper body-content-height">
		<form action="RegisterServlet" method="post">
		<input type="hidden" name="action" value="doRegister"> 
			<div class="form-title">
				<span>用户注册</span>
			</div>
			<div class="form-item">
				<div class="form-ctrl">
					<input type="text" id="userMail" name="userMail" autocomplete="off" placeholder="请输入邮箱" class=""/>
				</div>
				<div class="form-tips" style="display: none;">请输入邮箱</div>
			</div>

			<div class="form-item">
				<div class="form-ctrl">
					<input type="text" id="userName" name="userName" autocomplete="off" placeholder="请输入用户名" class=""/>
				</div>
				<div class="form-tips" style="display: none;">请输入用户名</div>
			</div>
			<div class="form-item">
				<div class="form-ctrl">
					<input type="password" id="userPassword" name="userPassword" autocomplete="off" placeholder="请输入密码" class=""/>
				</div>
				<div class="form-tips" style="display: none;">请输入密码</div>
			</div>
			<div class="form-item">
				<div class="form-ctrl">
					<input type="text" id="userPhone" name="userPhone" autocomplete="off" placeholder="请输入电话号码" class=""/>
				</div>
				<div class="form-tips" style="display: none;">请输入电话号码</div>
			</div>
			<div class="form-item">
				<div class="form-ctrl">
					<input type="date" id="userBirthday" name="userBirthday"/>
				</div>
			</div>
			<div class="form-item">
				<div class="form-ctrl">
					<input type="submit" class="btn-green" value="注册" />
				</div>
				<div class="form-tips"></div>
			</div>
		</form>
		<form action="LoginServlet" method="post">
			<input type="hidden" name="action" value="login"> 
			 <div class="form-item">
                <div class="form-ctrl">
                	<input type="submit" class="btn-green"  value="去登录"  style="background-color: #f3f6f8;color: #666;" />
                </div>
                <div class="form-tips"></div>
             </div>
		</form>
	</div>
	<jsp:include page="../_bottom.jsp" />
</body>
</html>