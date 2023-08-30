<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entity.Product" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("tr:even").css("background-color","lightgray");
		});
	</script>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/hxb.css"/>
	<link rel="stylesheet" type="text/css" href="./css/newhxb.css"/>
	<title>商品信息列表</title>
</head>
<body>
	<div class="div1" style="background:#708090">
		<img src="img/21.jpg" width="85px" height="85px" />
	</div>
	<div class="div2">
	<%
	String error = (String)request.getAttribute("error");
	if(error!=null){
		if(error.equals("addError")){
			out.print("操作失败");
		}else if(error.equals("noaddError")){
			out.print("操作成功");
		}
	}
	String right = (String)request.getAttribute("right");
	if (right!=null){
		if(right.equals("addRight")){
			out.print("登录成功，欢迎使用！");
		}
	}
	%>
	</div>
	
	<!-- 左侧 -->
	<div class="PublicDownWhole clearfix">
    	<div class="leftBox" style="background:	#708090">
          	<ul>
               <a href="users.html"><li style="color:#FFFAFA"><span></span>用户管理</li></a>
               <li class="Select" style="color:#FFFAFA"><span></span>商品管理</li>
               <a href="orders.html"><li style="color:#FFFAFA"><span></span>订单管理</li></a>
               <a href="index.jsp"><li style="color:#FFFAFA"><span></span>退出系统</li></a>
           	</ul>
         </div>
	<!-- 右侧 -->
	<div class="RightBox" style="margin-left:0;"">
    	<div class="PublicContentBox">
    		<div class="InquireTableBox">
            	<div class="headbox">
                     <div class="PublicBtnIcon Color5Btn">
                         <form action="add.jsp" method="post" >
							<input  style="color:#FFFAFA" type="submit" value="新增商品" /><br/>
						</form>
                     </div>
                 </div>
            	 <!--查询到的商品-->
                 <div class="InquireSelectTable">
                  	<table class="PublicTableCss"  width="1000px" height="330px" align="center">
                     	<thead>
                        	<tr>
                               <label for="inputcheck"></label>
                               <th>编号</th>
								<th>名称</th>
								<th>价格</th>
								<th>规格</th>
								<th>操作</th>
                             </tr>
                        </thead>
	                    <tbody>
	                        <%
								List<Product> products = (List<Product>)request.getAttribute("products");
								for(Product product:products){
							%>
							<tr>
								<td><%=product.getNumber() %></td>
								<td><%=product.getName() %></td>
								<td>¥ <%=product.getPrice() %></td>
								<td><%=product.getKind() %></td>
								<td><a href="DeleteProductServlet?number=<%=product.getNumber() %>" style="color:black">删除</a>	&ensp;		
									<a href="QueryProductByPnubServlet?number=<%=product.getNumber() %>" style="color:black">修改</a></td>
							</tr>
							<%
								}
							%>
						</tbody>
	               </table>
	             </div>
             </div>
         </div>
        </div>
	 </div>
                    
	
</body>
</html>