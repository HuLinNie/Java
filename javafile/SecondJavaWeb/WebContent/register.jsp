<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
</head>
<body>
<div>
	<form  id="MyForm" method="post" action="dowhat?what=doregister_image"  enctype="multipart/form-data">
		<div>
		<label  id="tb1_id" for="txtStuId" class="txtlabel">学号：</label>
		<input type="text" id="stuId" name="txtstuID" value="123456"/>
		</div>
		<div>
		<label id="tb1_id" for="txtName" class="txtlabel">姓名：</label>
		<input type="text" id="Name" name="txtName" value="nhl">
		</div>
		<div style="text-align: center;">
				<input type="submit" class="btn" value="注册" name="submit-btn">
				<input type="reset" class="btn" value="重置">
		</div>
		<div ><a href="index.html" class="center">返回</a></div>	
	</form>
</div>
</body>
</html>