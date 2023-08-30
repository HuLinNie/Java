<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>登录</title>
		<base href="<%=shopping.util.BasePath.get(request)%>" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
	<jsp:include page="../_header.jsp" />
	<div class="form-wrapper body-content-height">
		<form action="LoginServlet" method="post">
			<input type="hidden" name="action" value="doLogin"> 
				<div class="form-title">
                	<span>用户登录</span>
                </div>
				<div class="form-item">
                	<div class="form-ctrl">
                		<input type="text"  id="userMail"  name="userMail"  autocomplete="off"  placeholder="请输入邮箱" class="" value="abc@neu.edu">
                	</div>
                	<div class="form-tips" style="display: none;">请输入邮箱</div>
                </div>
                
                <div class="form-item">
                	<div class="form-ctrl">
                		<input type="password"  id="userPassword" name="userPassword" autocomplete="off"  placeholder="请输入密码" class="" value="gaojiao">
                	</div>
                	<div class="form-tips" style="display: none;">请输入密码</div>
                </div>
                
                <div class="form-item">
                	<div class="form-ctrl">
                		<input type="submit" class="btn-green" value="登录"/>
                	</div>
                	<div class="form-tips"></div>
                </div>
        </form>
		<form action="RegisterServlet" method="post">
			<input type="hidden" name="action" value="register"> 
                <div class="form-item">
                	<div class="form-ctrl">
                		<input type="submit" class="btn-green" value="去注册" style="background-color: #f3f6f8;color: #666;"/>
                	</div>
                	<div class="form-tips"></div>
                </div>
		</form>
	</div>
	<jsp:include page="../_bottom.jsp" />
	</body>
</html>