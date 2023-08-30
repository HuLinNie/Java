<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		function check(){//true:表单正常提交,false:表单终止提交
			var nub = $("#number").val();
			if(!(nub.length = 3)){
				alert("编号有误，长度必须是3位！")
				return false;
			}
			return true;
		}
		
	</script>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/form.css"/>
	<title>增加商品</title>
</head>
<body>
	<div class="div">
		<form action ="AddProductServlet" method="post" onsubmit="return check()">
			编号<input type="text" name="number"  id="number" style="margin-top:20px"/><br/>
			名称<input type="text" name="name"/><br/>
			价格<input type="text" name="price"/><br/>
			规格<input type="text" name="kind"/><br/>
			<input type="submit" value="新增商品"/>&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;
			<a href="QueryAllProductsServlet" style="color:black;">返回</a>
		</form>
	</div>
</body>
</html>