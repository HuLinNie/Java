<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, web.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="0.8;url=index.jsp">
<title>登录加载中</title>
</head>
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
		body{overflow:hidden;}
	</style>
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
		},8);
		};
	</script>
	<script>
    	move(20);
    </script>
    <script>
    	move(40);
    </script>
    <script>
    	move(60);
    </script>
    <script>
    	move(80);
    </script>
	<script>
    	move(100);
    </script>
    <script>
    </script>
   
</body>
</html>