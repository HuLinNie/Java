<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script src="js/serialize.js" type="text/javascript" ></script>
</head>
<body>
	<div id="divform">
		<form id="myForm" method="post" action="dowhat?what=doregister_img" enctype="multipart/form-data">
		<!-- form id="myForm" method="post" action="register_img" enctype="multipart/form-data"-->
			<input type="hidden" id="token" name="token" value="${token}"/>
			<div>
				<div style="clear: left">基本信息</div>
				<div id="basic_info">
					<div>
						<label id="tb1_id" for="txtStuId" class="txtlabel">学号: </label>
						<input type="text" name="stuId" id="txtStuId" value="97415509"/>
					</div>
					<div>
						<label id="tb1_id" for="txtName" class="txtlabel">姓名: </label>
						<input type="text" name="name" id="txtName" value="gaojiao" />
					</div>
					<div>
						<label id="tb2_id" for="txtPwd" class="txtlabel">密码: </label>
						<input type="password" name="pwd" id="txtPwd" value="123456"/>
					</div>
					<div>
						<label id="lb_bthday" for="bthday" class="txtlabel">生日:</label>
						<input type="date" name="bthday" id="bthday" value="1979-01-01"/>
					</div>
					<div>
						<label id="lb_email" for="email" class="txtlabel">邮箱:</label>
						<input type="email" name="email" id="email" value="gaojiao@neuq.edu.cn"/>
					</div>
					<div>
						<label id="lb_rDate" for="registerDate" class="txtlabel">入学时间:</label>
						<input type="date" name="registerDate" id="registerDate" value="1997-09-01"/>
					</div>
				</div>
				<!-- 图片************************************** -->
				<div id="u_pic_file">
					<img id="u_pic"/><br> 
					<input type="file" id="file_pic" name="file_pic"/>
				</div>
				<!-- ****************************************** -->
			</div>
			<div class="clearfloat"></div>
			<hr>
			<div>
				<span>修学课程：</span> 
				<input type="checkbox" id="cb_java" name="course" value="java" checked><label for="cb_java">Java程序设计</label> 
				<input type="checkbox" id="cb_web" name="course" value="web" checked><label for="cb_web">网站设计与开发</label>
				<input type="checkbox" id="cb_os" name="course" value="os" checked><label for="cb_os">计算机操作系统</label>
			</div>

			<div style="margin: 10px;">
				<span>上课地点：</span>
				<select name="location" id="selLocation">
					<option value="0" selected>北校区</option>
					<option value="1">南校区</option>
					<option value="2">北戴河校区</option>
					<option value="3">其他</option>
				</select>
			</div>
			<div>
				<div>备注：</div>
				<textarea name="memo" id="txtMemo">测试数据</textarea>
			</div>
			<div style="text-align: center;">
				<input type="submit" class="btn" value="注册" name="submit-btn">
				<input type="reset" class="btn" value="重置">
			</div>
			<div ><a href="index.html" class="center">返回</a></div>
		</form>
	</div>
	<script>
	//文档内容都呈现后执行以下脚本
		let pic_file = document.querySelector("#file_pic");
		let pic = document.querySelector("#u_pic");
		pic_file.addEventListener("change",function(event){
			let fileurl = window.URL.createObjectURL(event.target.files[0]);
			pic.setAttribute("src",fileurl);
		});
		let btReset = document.querySelector("input[type=reset]");
		btReset.addEventListener("click",function(event){
			pic.removeAttribute("src");
		});
	</script>
</body>
</html>