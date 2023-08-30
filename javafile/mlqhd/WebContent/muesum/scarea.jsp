<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@ page import="java.util.*, java.io.*,web.bean.*,web.util.*,web.service.*,web.dao.impl.*,web.dao.*,web.controller.*,web.controller.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>景区</title>
<base href="<%=web.util.BasePath.get(request)%>" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/jd.css">
</head>
<body>
	<jsp:include page="/jsp/_header.jsp" />
	 <!-- table start -->
   
   <div class="product-max">
       <ul>
           <li>
               <div>
                   <div class="p-image"><img src="images/sp.jpg" /></div>
                    <p class="head">老虎石海上公园<p>
                     <div class="kuang"> <div class="gou"><span>票价10元/人</span><a href="#"><button class="mai">点击购买</button></a></div>
                    <p>
                        老虎石海上公园位于北戴河风景区中心一占地面积3.3 万平方米。这里，巨石延
伸入海，形如群虎盘踞，故名老虎石。老虎石浴场是北戴河海滨的中心浴场，这里滩
宽海阔，入海坡度平缓，水质良好，因而成为暑期海浴人数最多的浴场。这里还有大
型的娱乐公园，园内设有海上飞伞、帆板、冲浪板、儿童乐园等，是国内较大的海上综
合性公园。
                    </p></div>
               </div>
           </li>
           <li>
               <div><a href="muesum?action=showscarea" style="text-decoration:none">             
					<%
             						ICommodityDao dao = new CommodityDaoImpl(); Commodity cf =dao.select("山海关门票");
             					%>
                   <div class="p-image"><img src="images/shg.jpg" /></div>
                   <p class="head">山海关——天下第一关<p>
                    <div class="kuang">
                    <div class="gou">
                    <span> <%="优惠："+cf.getCountry()+"价格："+cf.getPrice()%></span>
                    <form name="shoppingForm" action="CartServlet" method="POST">
						<input type="hidden" name="action" value="Add" />
						<input type="hidden" name="albumId" value="<%=cf.getId() %>" />
						数量:<input type="text" name="qty" value='1' style="width:80px;text-align:center;"/>
                   		<input  class="mai" type="submit" name="Submit" value="点击购买" />
                   	</form></div>
                    <p>
                         <%  FilePathDaoImpl fpd = new FilePathDaoImpl();%>
	<%  List<FilePath> cdlist =fpd.load();%>
	<%  for( int i=0;i<cdlist.size();i++) {%>
		<% 	 FilePath ft=cdlist.get(i);%>
		<% 	 String path = ft.getFpath();%>
		<% 	 FileInputStream fi = new FileInputStream(path);%>
		<%InputStreamReader fs = new InputStreamReader(fi,"UTF-8") ;%>	
		<% 	 BufferedReader fr = new BufferedReader(fs);%>
		<%-- 	 FileWriter fw = new FileWriter("");--%>
		<% 	 String c=null;%>
		<% 	 while( (c = fr.readLine())!=null) {%>
			<%=c%>
			<%};%>
			<%};%>
                    </p></div>
     </a></div>
    	</li>
           <li>
               <div>
                   <div class="p-image"><img src="images/dwy.jpg" /></div>
                   <p class="head">秦皇岛野生动物园<p>
                    <div class="kuang">
                    <div class="gou"><span>票价90元/人</span><a href="#"><button class="mai">点击购买</button></a></div>
                    <p>
                         秦皇岛野生动物园位于举世闻名的北戴河风景区绿树金沙环碧海的海滨国家森林公
园内。面积334公顷，是亚洲占地面积最大，自然环境最优美的野生动物园。秦皇岛野生
动物园利用森林公园得天独厚的森林资源和优美的自然环境，采用大圈散养的方式，
建成猛兽区、热带动物区、草食动物区、非洲动物区、中心娱乐广场等20多处动物观赏及
娱乐休闲景区；在这里，郁郁葱葱的绿色林带与绵延二百华里的海岸沙滩。辽阔无际的
大海交相辉映形成一幅绝妙的天然画卷。大自然的恩赐加上人们的精心雕印，赋予这里
得天独厚的观赏内涵。</p>
                    </div>
               </div>
           </li>
           <li>
               <div>
                   <div class="p-image"><img src="images/zs.jpg" /></div>
                   <p class="head">祖山风景区<p>
                    <div class="kuang">
                    <div class="gou"><span>票价80元/人</span><a href="#"><button class="mai">点击购买</button></a></div>
                    <p>
                           祖山位于秦皇岛青龙县境内，由于渤海以北、燕山以东诸峰都是由它的分支绵延而成，
故以“群山之祖”命名。其最高峰天女峰，海拔1428米，略逊于泰山。登上天女峰，东观
日出，南追帆影，西望长城，北俯群山，美景尽收眼底，这些却是泰山所没有的。游人回
来说祖山有奇险的山景和明秀的水景，当代诗人臧克家老先生以“画境诗天”赞之。然而
祖山却名不见经传，或许它的美正是要我们去发现、去印证。著名景点有：乌龙谷、云海
佛光、仙女云床、飞瀑谷。
                    </p></div>
               </div>
           </li>
       </ul>
       <li>
               <div>
                   <div class="p-image"><img src="images/qxrh.jpg" /></div>
                   <p class="head">秦皇求仙入海处<p>
                    <div class="kuang">
                    <div class="gou"><span>票价40元/人</span><a href="#"><button class="mai">点击购买</button></a></div>
                    <p>
                        秦皇求仙入海处位于秦皇岛市海港区东南部，秦皇岛古属碣石地域，因秦始皇东巡驻
跸于此而得名。据《史记·秦始皇本纪》记载，秦始皇于公元前215年东巡碣石——秦皇
岛，并在此拜海，先后派卢生、侯公、韩终等两批方士携童男童女入海求仙，寻求长生不
老药。明宪宗成化13年，立“秦皇求仙入海处”石碑一座，以纪圣境。在秦皇求仙入海处
还可看到规模宏大的秦皇岛港，秦皇岛港位于渤海辽东湾西测，是国家级主枢纽港，
也是国家唯一直接管理的港口，世界上最大的煤炭输出港之一。
                    </p></div>
               </div>
           </li>
           <li>
               <div>
                   <div class="p-image"><img src="images/mjnm.jpg" /></div>
                   <p class="head">孟姜女庙<p>
                    <div class="kuang">
                    <div class="gou"><span>票价25元/人</span><a href="#"><button class="mai">点击购买</button></a></div>
                   <p>  姜女庙又叫贞女祠，位于山海关城东约6公里的凤凰山上，相传始建于宋朝以前。孟
姜女的故事是中国民间四大传说之一，后人景仰孟姜女的忠贞，感叹她的忠烈而建此庙。
现存的孟姜女庙体现了明朝的建筑风格，庙前依山砌筑108磴行人石板梯道，象征孟姜女
寻夫的艰辛和曲折。当您拾级而上走过挂有“贞女祠”匾额的山门，来到前殿，闻名全国
的奇特楹联，上联：“海水朝朝朝朝朝朝朝落”；下联：“浮云长长长长长长长消”。
会映入您的眼帘，楹联的读法断句有多种，您可在这里细细品酌，会感到妙趣横生。
殿内正中塑孟姜女泥像一座，淡装素彩，面带愁容，她双目中透出的无限哀怨，可使您
想象到当年孟姜女千里迢迢寻夫的凄凉心境。
                    </p></div>
               </div>
           </li>
           <li>
               <div>
                   <div class="p-image"><img src="images/fcd.jpg" /></div>
                   <p class="head">翡翠岛<p>
                    <div class="kuang">
                    <div class="gou"><span>票价75元/人</span><a href="#"><button class="mai">点击购买</button></a></div>
                    <p>   翡翠岛，当地人俗称“大峪”，其东北西三面由渤海和七里海环绕，是一座由金黄色
细沙构成的半岛。这里沙细、潍缓、水清、潮平，在该地区旅游部门的合理开发和保护之
下，没有受到任何污染，是生态旅游的最佳地点。当你与海水嬉戏之后，沿沙山往上走，
不仅可以欣赏大自然鬼斧神工创造的“海边沙漠”这一奇景，还可赤脚走在太阳晒得滚烫
的细沙之上足疗。有了壮观的沙山，“滑沙”似乎不能缺少。从40米高的沙山顶端乘滑板
飞驰而下，直面扑向大海，可同时领略滑沙、滑水、游泳三种乐趣。沙山“借得江南绿叶
装点半岛翡翠，移来塞北黄沙成就大漠风光。”
                    </p></div>
               </div>
           </li>
           <li>
               <div>
                   <div class="p-image"><img src="images/gzw.jpg" /></div>
                   <p class="head">鸽子窝公园<p>
                    <div class="kuang">
                    <div class="gou"><span>票价25元/人</span><a href="#"><button class="mai">点击购买</button></a></div>
                    <p>   1954年夏，毛泽东主席曾在鸽子窝公园目极远眺，感慨万千，写下《浪淘沙·北戴
河》这一不朽诗篇。为深切缅怀毛主席的丰功伟绩，北戴河区政府在鸽子窝公园敬立了
诗词碑和毛泽东主席雕像。1985年在园内东南临海崖顶处，建起一条50米长的仿古建筑
---望海长廊，廊内彩绘100多幅传统壁画。长廊南部建有书阁，专供名人名家及游客题
诗作画之用，书阁上挂有周谷城副委员长题写的《书阁》牌匾。书阁的西侧建有碑廊和碑
亭，上面挂有方毅副总理题写的《碑亭》牌匾。公园西海滩有人工湖一座，湖中水榭曲桥
亭子等是您休息、游玩的场所，园内放养着600余只广场鸽，可同您戏耍、合影。立长廊，
观沧海，赏红日喷薄欲出，看海上渔帆点点，鸽子窝公园定会使您对它青睐有加。
                    </p></div>
               </div>
           </li>
       </ul>
   </div>
    <!-- table end -->
	<jsp:include page="/jsp/_bottom.jsp" />
</body>
</html>