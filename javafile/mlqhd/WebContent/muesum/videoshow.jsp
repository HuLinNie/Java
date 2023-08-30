<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>魅力秦皇岛</title>
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/mv.css" />
	<style>
		.mai{
				
				position:fixed;
				left:43%;
				top:40%;
				z-index:9999;
				font-size:36px;
				color:#ffffff;
				background: #F3B76A;
				border-radius:5px;
				width:260px;
				text-align:center;
				
		}
	</style>
</head>
<body>
	<jsp:include page="/jsp/_header.jsp" />
	<div class="banner">
        <div class="in">
        	
            <video width="580" height="100%" controls="controls" autoplay="autoplay">
                <source src="images/qhd.qlv" type="video/ogg" />
                <source src="images/qhd.qlv" type="video/mp4" />
                <source src="images/qhd.qlv" type="video/webm" />
                <object data="images/qhd.qlv" width="580" height="100%">
                   <embed width="580" height="100%" src="images/qhd.qlv" />
                </object>
            </video>
            <div class="in-left">
                    <div class="subnav">
                            <ul>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游景点<span> > </span></a></li>
                            </ul>
                    </div>
            </div>
           
            <div class="in-right">
                    <div class="subnav">
                            <ul>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                <li><a href="#">秦皇岛旅游博物馆<span> > </span></a></li>
                                
                            </ul>
                    </div>
            </div>
            <div class="goumaijiesuo">
            <%
            	ICommodityDao dao = new CommodityDaoImpl(); Commodity cf =dao.select("视频讲解");
            %>
             <form name="shoppingForm" action="CartServlet" method="POST">
						<input type="hidden" name="action" value="Add" />
						<input type="hidden" name="albumId" value="<%=cf.getId() %>" />
						<input type="text" name="qty" value='1' style="width:80px;text-align:center; display:none;"/>
                   		<input  class="mai" type="submit" name="Submit" value="￥ 15.00 解锁"  />
                   	</form>
            </div>	
        </div>
    </div>
    <!-- banner end -->
    <!-- little banner star -->
    <div class="libanner">
        <div class="libanner-left">
            <ul>
                <div>景点推荐</div>
                <li><a href="#">鸽子窝公园</a></li>
                <li><a href="#">老虎石海上公园</a></li>
                <li><a href="#">山海关</a></li>
                <li><a href="#">秦皇野生动物园</a></li>
                <li><a href="#">翡翠岛</a></li>
                <li><a href="#">碧螺塔海上公园</a></li>
                <li><a href="#">祖山风景区</a></li>
                <li><a href="#">冰糖峪</a></li>
                <li><a href="#">求仙入海处</a></li>
                <li><a href="#">孟姜女庙</a></li>
                <span><a href="#">去逛逛</a></span>
            </ul>
        </div>
    </div>
    <!-- libanner end -->
</body>
</html>