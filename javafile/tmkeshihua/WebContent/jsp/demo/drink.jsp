<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>饮料</title>
<base href="<%=web.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/shopclass.css" />
<style>

</style>
</head>
<body>
<jsp:include page="../template/_header.jsp" />
	  <!-- 商品分类页开始 -->
        <div class="spfl">
            <div class="spfl-left">
                <div class="subnav">
                    <ul>
                        <li style="color:#fff;">商品分类</li>
                        <li><a href="#">可口可乐<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;可乐</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/yl_kl.jpg" /></div>                                            
                                                </div>
                                            </li>                                        
                                        </ul>
                                    </div>
                                </div>    
                                                        
                            </div>
                        </li>
                        <li><a href="#">加多宝<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;凉茶</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/yl_jdb.jpg" /></div>                                            
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>    
                                                       
                            </div>
                        </li>
                        <li><a href="#">王老吉<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;饮料</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/yl_wlj.jpg" /></div>                                            
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>    
                                                    
                            </div>
                        </li>
                        <li><a href="#">农夫山泉<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;饮用水</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/yl_ht.jpg" /></div>                                            
                                                </div>
                                            </li>                                           
                                        </ul>
                                    </div>
                                </div>    
                                                           
                            </div>
                        </li>
                        <li><a href="#">雀巢<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;咖啡</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/yl_kf.jpg" /></div>                                            
                                                </div>
                                            </li>                                           
                                        </ul>
                                    </div>
                                </div>    
                                                      
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="spfl-right">
                <div class="product-max">
	 			<%
	 				ICommodityDao dao = new CommodityDaoImpl(); List<Commodity> cf =dao.queryType("饮料");
	 			%> 
	 			<%for( int i=0;i<cf.size();i++){%>		
                    <ul>
                      <li>
                           <div>
                              <div class="p-image"><a href="CommodityServlet?action=show&id=<%=cf.get(i).getId()%>"><img src="<%=cf.get(i).getImage()%>" /></a></div>      
                                  	 <div class="head"><%=cf.get(i).getName() %> <%=Numeric.toFixedDecimalString(cf.get(i).getPrice(), 2) %>
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
            </div>
        </div>
        <!-- 商品分类页结束 -->
</body>
</html>