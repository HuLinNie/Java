<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, java.io.*,web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>附近商家</title>
<base href="<%=web.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/nearbyshops.css" />
 <link rel="stylesheet" type="text/css" href="css/shopclass.css" />
</head>
<body>
	<jsp:include page="../template/_header.jsp" />
	   <!-- 商家页面开始 -->
    <div class="shangjia">
        <div class="top">
            <div class="top-left">
                <div class="subnav">
                    <ul>
                        <li style="color:#fff;">附近超市</li>
                        <li><a href="#">书儒超市<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="fl-fl">
                                    <ul>
                                        <li style="color:#fff;">商品分类</li>
                                        <li><a href="商品分类.html">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="商品分类.html">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="商品分类.html">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="商品分类.html">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="商品分类.html">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li><a href="#">书儒超市<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="fl-fl">
                                    <ul>
                                        <li style="color:#fff;">商品分类</li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li><a href="#">书儒超市<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="fl-fl">
                                    <ul>
                                        <li style="color:#fff;">商品分类</li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li><a href="#">书儒超市<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="fl-fl">
                                    <ul>
                                        <li style="color:#fff;">商品分类</li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li><a href="#">书儒超市<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="fl-fl">
                                    <ul>
                                        <li style="color:#fff;">商品分类</li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li><a href="#">书儒超市<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="fl-fl">
                                    <ul>
                                        <li style="color:#fff;">商品分类</li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                    </ul>
                                </div>                            
                            </div>
                        </li>
                        <li><a href="#">书儒超市<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="fl-fl">
                                    <ul>
                                        <li style="color:#fff;">商品分类</li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                    </ul>
                                </div>                            
                            </div>
                        </li>
                        <li><a href="#">书儒超市<span> > </span></a>
                            <div class="subnav-fl">
                                <div class="fl-fl">
                                    <ul>
                                        <li style="color:#fff;">商品分类</li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                        <li><a href="#">零食/水果/蔬菜/糕点<span> > </span></a>
                                            <div class="sub-fl"></div>
                                        </li>
                                    </ul>
                                </div>                            
                            </div>
                        </li>
                        <li><a href="#">书儒超市<span> > </span></a></li>
                    </ul>
                </div>
            </div>
            <div class="top-right">
                <img src="images/chaoshi.jpg" >
            </div>
        </div>
    </div>

    <!-- 商家页面结束 -->
    <!-- product begin -->
    <div class="product-max">
        <div class="pro"><div class="tuijian">肉类/蔬菜</div></div>
        <div class="tuijina_is"> 
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
                        <div class="p-image"><img src="images/2.jpg" /></div>
                        <div class="head"><a href="#">菠萝蜜 25/kg</a></div>
                        <p>
                            <span>站主推荐</span>· 600人已购买
                        </p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="p-image"><img src="images/3.jpg" /></div>
                        <div class="head"><a href="#">苹果 5/kg</a></div>
                        <p>
                            <span>站主推荐</span>· 666人购买
                        </p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="p-image"><img src="images/4.jpg" /></div>
                        <div class="head"><a href="#">猕猴桃 5/kg</a></div>
                        <p>
                            <span>站主推荐</span>· 666人已购买
                        </p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="p-image"><img src="images/5.jpg" /></div>
                        <div class="head"><a href="#">山竹 8/kg</a></div>
                        <p>
                            <span>站主推荐</span>· 66购买
                        </p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="p-image"><img src="images/6.jpg" /></div>
                        <div class="head"><a href="#">榴莲 40/个</a></div>
                        <p>
                            <span>站主强推</span>· 66+购买
                        </p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="p-image"><img src="images/7.jpg" /></div>
                        <div class="head"><a href="#">新疆哈密瓜 4/kg</a></div>
                        <p>
                            <span>同学推荐</span>· 666人在看
                        </p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="p-image"><img src="images/8.jpg" /></div>
                        <div class="head"><a href="#">凤梨 4/kg</a></div>
                        <p>
                            <span>一致好评</span>· 66人在看
                        </p>
                    </div>
                </li>
                 <li>
                    <div>
                        <div class="p-image"><img src="images/9.jpg" /></div>
                        <div class="head"><a href="#">同花菜 4/kg</a></div>
                        <p>
                            <span>大妈说好</span>· 666人在看
                        </p>
                    </div>
                </li>
                <li>
                    <div>
                        <div class="p-image"><img src="images/10.jpg" /></div>
                        <div class="head"><a href="#">莴苣 4/kg</a></div>
                        <p>
                            <span>市民最爱</span>· 666人在看
                        </p>
                    </div>
                </li>

            </ul>
        </div>   
        <div class="pro"><div class="tuijian">零食/水果/蔬菜/糕点</div></div>
        <div class="tuijina_is"> 
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
                        <div class="p-image"><img src="images/sg2.jpg" /></div>
                        <div class="head"><a href="#">菠萝蜜 25/kg</a></div>
                        <p>
                            <span>站主推荐</span>· 600人已购买
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
                <li>
                    <div>
                        <div class="p-image"><img src="images/10.jpg" /></div>
                        <div class="head"><a href="#">莴苣 4/kg</a></div>
                        <p>
                            <span>市民最爱</span>· 666人在看
                        </p>
                    </div>
                </li>

            </ul>
        </div>
        <div class="pro"><div class="tuijian">零食/水果/蔬菜/糕点</div></div>
        <div class="tuijina_is"> 
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
                        <div class="p-image"><img src="images/sg2.jpg" /></div>
                        <div class="head"><a href="#">菠萝蜜 25/kg</a></div>
                        <p>
                            <span>站主推荐</span>· 600人已购买
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
                <li>
                    <div>
                        <div class="p-image"><img src="images/10.jpg" /></div>
                        <div class="head"><a href="#">莴苣 4/kg</a></div>
                        <p>
                            <span>市民最爱</span>· 666人在看
                        </p>
                    </div>
                </li>

            </ul>
        </div>
        <div class="pro"><div class="tuijian">零食/水果/蔬菜/糕点</div></div>
        <div class="tuijina_is"> 
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
                        <div class="p-image"><img src="images/sg2.jpg" /></div>
                        <div class="head"><a href="#">菠萝蜜 25/kg</a></div>
                        <p>
                            <span>站主推荐</span>· 600人已购买
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
                <li>
                    <div>
                        <div class="p-image"><img src="images/10.jpg" /></div>
                        <div class="head"><a href="#">莴苣 4/kg</a></div>
                        <p>
                            <span>市民最爱</span>· 666人在看
                        </p>
                    </div>
                </li>

            </ul>
        </div>
    </div>
   <!-- product end -->
</body>
</html>