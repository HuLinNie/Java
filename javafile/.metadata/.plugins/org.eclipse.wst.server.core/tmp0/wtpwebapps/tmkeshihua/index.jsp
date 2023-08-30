<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>天猫超市乳饮品</title>
	<base href="<%=web.util.BasePath.get(request)%>" />
	<link rel="stylesheet" type="text/css" href="css/index.css" />
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
		<style type="text/css">
	.person{
	float:right;
	}
	.person img{width:40px;
	height:40px;}	
</style>
</head>
	
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
		},60);
		};
	</script>
	 <jsp:include page="jsp/template/_header.jsp" />
  <!-- banner star -->
    <div class="banner">
        <div class="in">
            <ul class="in-ul">
                <li><a href="#"><img src="images/nn_tls.jpg" alt="牛奶"/></a></li>
                <li><a href="#"><img src="images/nn_jd.jpg" alt="牛奶"/></a></li>
                <li><a href="#"><img src="images/nn_zgl.jpg" alt="牛奶"/></a></li>
                <!-- again! -->
                <li><a href="#"><img src="images/yl_kl.jpg" alt="饮料"/></a></li>
                <li><a href="#"><img src="images/yl_jdb.jpg" alt="饮料"/></a></li>
                <li><a href="#"><img src="images/yl_ht.jpg" alt="饮料"/></a></li>
                <!-- again! -->
                <li><a href="#"><img src="images/sn_cz.jpg" alt="酸奶"/></a></li>
                <li><a href="#"><img src="images/sn_rx.jpg" alt="酸奶"/></a></li>
                <li><a href="#"><img src="images/sn_kfe.jpg" alt="酸奶"/></a></li>
            </ul>
            <div class="in-left">
                    <div class="subnav">
                            <ul>
                                <li style="color:#fff;">商品分类</li>
                                <li><a href="#">可口可乐<span> > </span></a></li>
                                <li><a href="#">营养早餐<span> > </span></a></li>
                                <li><a href="#">进口乳饮<span> > </span></a></li>
                                <li><a href="jsp/demo/drink.jsp">饮料<span> > </span></a></li>
                                <li><a href="jsp/demo/milk.jsp">牛奶<span> > </span></a></li>
                                <li><a href="jsp/demo/smilk.jsp">酸奶<span> > </span></a></li>
                                <li><a href="#">饮用水<span> > </span></a></li>
                                <li><a href="#">啤酒<span> > </span></a></li>
                                <li><a href="#">葡萄酒<span> > </span></a></li>
                            </ul>
                    </div>
            </div>
            <div class="in-right">
                    <div class="subnav">
                            <ul>
                                <li style="color:#fff;">爆款好货</li>
                                <li><a href="#">真果粒四种口味<span> > </span></a></li>
                                <li><a href="#">可口可乐迷你装<span> > </span></a></li>
                                <li><a href="#">53度飞天茅台<span> > </span></a></li>
                                <li><a href="#">国潮AD钙奶<span> > </span></a></li>
                                <li><a href="#">伊利金典纯牛奶<span> > </span></a></li>
                                <li><a href="#">红牛功能饮料<span> > </span></a></li>
                                <li><a href="#">蒙牛纯甄酸奶<span> > </span></a></li>
                                <li><a href="#">12瓶装农夫山泉<span> > </span></a></li>
                                <li><a href="#">康师傅茶饮料<span> > </span></a></li>
                            </ul>
                    </div>
            </div>
        </div>
    </div>
    <!-- banner end -->
    <!-- little banner star -->
    <div class="libanner">
        <div class="libanner-left">
            <ul>
                <div>热门商品</div>
               
               
            </ul>
        </div>
    <!-- libanner end -->
    </div>
    <div class="pro">
        <div>商品推荐</div>
        <!-- <a href="index.html">查看全部</a> -->
    </div>
    <!-- little banner end -->
    <!-- product begin -->
    <div class="product-max">
	 			<%
	 				ICommodityDao dao = new CommodityDaoImpl(); List<Commodity> cf =dao.query();
	 			%> 
	 			<%for( int i=0;i<cf.size();i++){%>		
                    <ul>
                      <li>
                           <div>
                              <div class="p-image"><a href="CommodityServlet?action=show&id=<%=cf.get(i).getId()%>"><img src="<%=cf.get(i).getImage()%>" /></a></div>      
                                  	 <div class="head"><%=cf.get(i).getName() %> <%=Numeric.toFixedDecimalString(cf.get(i).getPrice(), 2) %>元
                                  	 	<a class="person" id="toCart" href="CartServlet?action=add&id=<%=cf.get(i).getId()%>"><img src="images/gwc.jpg" alt="购物车"></a>
                                  		
                                  	 </div>
                                 		<p>
                                			 总销量<span><%=cf.get(i).getTotalamount() %></span>
                              			</p>	 
                          </div>
                           </li>
                       <% };%>
                     </ul>
      </div>
   <!-- product end -->
    <!-- footer start -->
    
     
    	<script>
    	move(100);
    	document.getElementById("progress").style.display="none";
    	</script>
    <jsp:include page="jsp/template/_bottom.jsp" />	
    
</body>
</html>