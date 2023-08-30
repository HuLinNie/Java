<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品速览</title>
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
                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;水果</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>
                                </div>    
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;蔬菜</p></div>
                                    <div class="sc">
                                        <ul>

                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>  
                                </div>                                  
                            </div>
                        </li>
                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;水果</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>
                                </div>    
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;蔬菜</p></div>
                                    <div class="sc">
                                        <ul>

                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>  
                                </div>                                  
                            </div>
                        </li>
                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;水果</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>
                                </div>    
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;蔬菜</p></div>
                                    <div class="sc">
                                        <ul>

                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>  
                                </div>                                  
                            </div>
                        </li>
                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;水果</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>
                                </div>    
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;蔬菜</p></div>
                                    <div class="sc">
                                        <ul>

                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>  
                                </div>                                  
                            </div>
                        </li>
                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;水果</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>
                                </div>    
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;蔬菜</p></div>
                                    <div class="sc">
                                        <ul>

                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>  
                                </div>                                  
                            </div>
                        </li>
                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;水果</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>
                                </div>    
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;蔬菜</p></div>
                                    <div class="sc">
                                        <ul>

                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>  
                                </div>                                  
                            </div>
                        </li>
                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;水果</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>
                                </div>    
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;蔬菜</p></div>
                                    <div class="sc">
                                        <ul>

                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>  
                                </div>                                  
                            </div>
                        </li>
                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;水果</p> </div>
                                    <div class="sg">

                                        <ul>                               
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/sg5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>
                                </div>    
                                <div class="boder">
                                    <div><p>&emsp;&nbsp;蔬菜</p></div>
                                    <div class="sc">
                                        <ul>

                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/1.jpg" /></div>                                            
                                                </div>
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/2.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/3.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/4.jpg" /></div>
                                                </div>                                        
                                            </li>
                                            <li>
                                                <div>
                                                    <div class="p-image"><img src="images/5.jpg" /></div>
                                                </div>                                        
                                            </li>
                                        </ul>
                                    </div>  
                                </div>                                  
                            </div>
                        </li>
                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="spfl-right">
                <div class="product-max">
                    <ul>
                        <li>
                            <div>
                                <div class="p-image"><img src="images/sg1.jpg" /></div>
                                <div class="head"><a href="#">山海关樱桃 20/kg</a></div>
                                <p>
                                    <span>站主推荐</span>· 666人已购买
                                </p>
                            </div>
                        </li>
                        <li>
                            <div>
                                <div class="p-image"><img src="images/sg3.jpg" /></div>
                                <div class="head"><a href="#">苹果 5/kg</a></div>
                                <p>
                                    <span>站主推荐</span>· 666人购买
                                </p>
                            </div>
                        </li>
                        <li>
                            <div>
                                <div class="p-image"><img src="images/sg4.jpg" /></div>
                                <div class="head"><a href="#">猕猴桃 5/kg</a></div>
                                <p>
                                    <span>站主推荐</span>· 666人已购买
                                </p>
                            </div>
                        </li>
                        <li>
                            <div>
                                <div class="p-image"><img src="images/sg5.jpg" /></div>
                                <div class="head"><a href="#">山竹 8/kg</a></div>
                                <p>
                                    <span>站主推荐</span>· 66购买
                                </p>
                            </div>
                        </li>
                        <li>
                            <div>
                                <div class="p-image"><img src="images/sg6.jpg" /></div>
                                <div class="head"><a href="#">榴莲 40/个</a></div>
                                <p>
                                    <span>站主强推</span>· 66+购买
                                </p>
                            </div>
                        </li>
                        <li>
                            <div>
                                <div class="p-image"><img src="images/sg7.jpg" /></div>
                                <div class="head"><a href="#">新疆哈密瓜 4/kg</a></div>
                                <p>
                                    <span>同学推荐</span>· 666人在看
                                </p>
                            </div>
                        </li>
                        <li>
                            <div>
                                <div class="p-image"><img src="images/sg8.jpg" /></div>
                                <div class="head"><a href="#">凤梨 4/kg</a></div>
                                <p>
                                    <span>一致好评</span>· 66人在看
                                </p>
                            </div>
                        </li>
                         <li>
                            <div>
                                <div class="p-image"><img src="images/12.jpg" /></div>
                                <div class="head"><a href="#">同花菜 4/kg</a></div>
                                <p>
                                    <span>大妈说好</span>· 666人在看
                                </p>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 商品分类页结束 -->
</body>
</html>