/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2021-04-17 15:42:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin.kehufuwu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.io.*;
import web.bean.*;
import web.util.*;
import web.service.*;
import web.dao.impl.*;
import web.dao.*;
import web.controller.*;
import web.controller.helper.*;

public final class comment_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("web.dao");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("web.controller");
    _jspx_imports_packages.add("web.controller.helper");
    _jspx_imports_packages.add("web.util");
    _jspx_imports_packages.add("web.bean");
    _jspx_imports_packages.add("web.dao.impl");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("web.service");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>客户服务</title>\r\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Menu CSS -->\r\n");
      out.write("    <link href=\"css/sidebar-nav.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- toast CSS -->\r\n");
      out.write("    <link href=\"css/jquery.toast.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- morris CSS -->\r\n");
      out.write("    <link href=\"css/morris.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- animation CSS -->\r\n");
      out.write("    <link href=\"css/animate.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Custom CSS -->\r\n");
      out.write("    <link href=\"css/style1.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- color CSS -->\r\n");
      out.write("    <link href=\"css/blue-dark.css\" id=\"theme\" rel=\"stylesheet\"> \r\n");
      out.write("     <script src=\"js/echarts.min.js\" ></script>\r\n");
      out.write("    <script src=\"js/jquery.js\" ></script>\r\n");
      out.write("     <script>// 柱状图模块1\r\n");
      out.write("    function zzchart() {\r\n");
      out.write("    \t  // 1实例化对象\r\n");
      out.write("    \t  var myChart = echarts.init(document.getElementById('pllzzchart'));\r\n");
      out.write("    \t  // 2. 指定配置项和数据\r\n");
      out.write("    \t  var option = {\r\n");
      out.write("    \t    color: [\"#2f89cf\"],\r\n");
      out.write("    \t    tooltip: {\r\n");
      out.write("    \t      trigger: \"axis\",\r\n");
      out.write("    \t      axisPointer: {\r\n");
      out.write("    \t        // 坐标轴指示器，坐标轴触发有效\r\n");
      out.write("    \t        type: \"shadow\" // 默认为直线，可选为：'line' | 'shadow'\r\n");
      out.write("    \t      }\r\n");
      out.write("    \t    },\r\n");
      out.write("    \t    // 修改图表的大小\r\n");
      out.write("    \t    grid: {\r\n");
      out.write("    \t      left: \"0%\",\r\n");
      out.write("    \t      top: \"10px\",\r\n");
      out.write("    \t      right: \"0%\",\r\n");
      out.write("    \t      bottom: \"4%\",\r\n");
      out.write("    \t      containLabel: true\r\n");
      out.write("    \t    },\r\n");
      out.write("    \t    xAxis: [\r\n");
      out.write("    \t      {\r\n");
      out.write("    \t        type: \"category\",\r\n");
      out.write("    \t        data: [],\r\n");
      out.write("    \t        axisTick: {\r\n");
      out.write("    \t          alignWithLabel: true\r\n");
      out.write("    \t        },\r\n");
      out.write("    \t        // 修改刻度标签 相关样式\r\n");
      out.write("    \t        axisLabel: {\r\n");
      out.write("    \t          color: \"rgba(0,0,0,.6) \",\r\n");
      out.write("    \t          fontSize: \"12\"\r\n");
      out.write("    \t        },\r\n");
      out.write("    \t        // 不显示x坐标轴的样式\r\n");
      out.write("    \t        axisLine: {\r\n");
      out.write("    \t          show: false\r\n");
      out.write("    \t        }\r\n");
      out.write("    \t      }\r\n");
      out.write("    \t    ],\r\n");
      out.write("    \t    yAxis: [\r\n");
      out.write("    \t      {\r\n");
      out.write("    \t        type: \"value\",\r\n");
      out.write("    \t        // 修改刻度标签 相关样式\r\n");
      out.write("    \t        axisLabel: {\r\n");
      out.write("    \t          color: \"rgba(0,0,0,.6) \",\r\n");
      out.write("    \t          fontSize: 12\r\n");
      out.write("    \t        },\r\n");
      out.write("    \t        // y轴的线条改为了 2像素\r\n");
      out.write("    \t        axisLine: {\r\n");
      out.write("    \t          lineStyle: {\r\n");
      out.write("    \t            color: \"rgba(0,0,0,.1)\",\r\n");
      out.write("    \t            width: 2\r\n");
      out.write("    \t          }\r\n");
      out.write("    \t        },\r\n");
      out.write("    \t        // y轴分割线的颜色\r\n");
      out.write("    \t        splitLine: {\r\n");
      out.write("    \t          lineStyle: {\r\n");
      out.write("    \t            color: \"rgba(0,0,0,.1)\"\r\n");
      out.write("    \t          }\r\n");
      out.write("    \t        }\r\n");
      out.write("    \t      }\r\n");
      out.write("    \t    ],\r\n");
      out.write("    \t    series: [\r\n");
      out.write("    \t      {\r\n");
      out.write("    \t        name: \"商品评论数\",\r\n");
      out.write("    \t        type: \"bar\",\r\n");
      out.write("    \t        barWidth: \"35%\",\r\n");
      out.write("    \t        data:[],\r\n");
      out.write("    \t        itemStyle: {\r\n");
      out.write("    \t          // 修改柱子圆角\r\n");
      out.write("    \t          barBorderRadius: 5\r\n");
      out.write("    \t        }\r\n");
      out.write("    \t      }\r\n");
      out.write("    \t    ]\r\n");
      out.write("    \t  };\r\n");
      out.write("    \t  // 3. 把配置项给实例对象\r\n");
      out.write("    \t  myChart.setOption(option);\r\n");
      out.write("    \t window.addEventListener(\"resize\", function() {\r\n");
      out.write("    \t    myChart.resize();\r\n");
      out.write("    \t  });\r\n");
      out.write("    \t myChart.showLoading();\r\n");
      out.write("    \t var shops=[];\r\n");
      out.write("    \t var nums=[];\r\n");
      out.write("    \t $.ajax({\r\n");
      out.write("    \t\t type:\"post\",\r\n");
      out.write("    \t \tasync:true,\r\n");
      out.write("    \t \turl:\"bar.do\",\r\n");
      out.write("    \t \tdata:{},\r\n");
      out.write("    \t \tdataType:\"json\",\r\n");
      out.write("    \t \tsuccess:function(result){\r\n");
      out.write("    \t \t\tif(result){\r\n");
      out.write("    \t \t\t\tfor(var i=0;i<result.length;i++){\r\n");
      out.write("    \t \t\t\t\tshops.push(result[i].name);\r\n");
      out.write("    \t \t\t\t}\r\n");
      out.write("    \t \t\t\tfor(var i=0;i<result.length;i++){\r\n");
      out.write("    \t \t\t\t\tnums.push(result[i].commentamount);\r\n");
      out.write("    \t \t\t\t}\r\n");
      out.write("    \t \t\t\tmyChart.hideLoading();\r\n");
      out.write("    \t \t\t\tmyChart.setOption({\r\n");
      out.write("    \t \t\t\t\txAxis:{data:shops},\r\n");
      out.write("    \t \t\t\t\tseries:[{\r\n");
      out.write("    \t \t\t\t\t\tname:'评论量',\r\n");
      out.write("    \t \t\t\t\t\tdata:nums\r\n");
      out.write("    \t \t\t\t\t}]\r\n");
      out.write("    \t \t\t\t})\r\n");
      out.write("    \t \t\t}\t\r\n");
      out.write("    \t \t},\r\n");
      out.write("    \t\terror:function(errorMsg){\r\n");
      out.write("    \t\t\talert(\"图表数据请求失败！\");\r\n");
      out.write("    \t\t\tmyChart.hideLoading();\r\n");
      out.write("    \t\t}\t \r\n");
      out.write("    \t })\r\n");
      out.write("    \t};\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../left.jsp", out, false);
      out.write("\r\n");
      out.write("\t<div id=\"wrapper\">\r\n");
      out.write("        <!-- Page Content -->\r\n");
      out.write("        <div id=\"page-wrapper\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"row bg-title\">\r\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-4 col-xs-12\">\r\n");
      out.write("                        <h4 class=\"page-title\">客服服务</h4> </div>\r\n");
      out.write("                \r\n");
      out.write("                        <ol class=\"breadcrumb\">\r\n");
      out.write("                            <li><a href=\"home\">买家中心</a></li>\r\n");
      out.write("                            <li><a href=\"AdminhomeServlet?action=adminhome\">卖家服务</a></li>\r\n");
      out.write("\r\n");
      out.write("                        </ol>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("                <!-- .row -->\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                \t");
ICommentDao dao1= new CommentDaoImpl();List<Comment> cdlist=dao1.load();
      out.write("\r\n");
      out.write("                    <div class=\"col-md-4 col-xs-12\">\r\n");
      out.write("                        <div class=\"white-box\">\r\n");
      out.write("                            <div class=\"user-bg\"> <img width=\"100%\" alt=\"user\" src=\"images/admin/comment.jpg\"/>\r\n");
      out.write("                                <div class=\"overlay-box\">\r\n");
      out.write("                                    <div class=\"user-content\">\r\n");
      out.write("                                        <a href=\"javascript:void(0)\"><img src=\"images/admin/comment.jpg\" class=\"thumb-lg img-circle\" alt=\"img\"></a>\r\n");
      out.write("                                        <h4 class=\"text-white\">顾客评论</h4>\r\n");
      out.write("                                        <h5 class=\"text-white\"></h5> </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"user-btm-box\">\r\n");
      out.write("                                <div class=\"col-md-4 col-sm-4 text-center\">\r\n");
      out.write("                                    <p class=\"text-purple\"><i class=\"ti-facebook\"></i></p>\r\n");
      out.write("                                    <h1>好评");
      out.print(cdlist.size() );
      out.write("</h1> </div>\r\n");
      out.write("                                <div class=\"col-md-4 col-sm-4 text-center\">\r\n");
      out.write("                                    <p class=\"text-blue\"><i class=\"ti-twitter\"></i></p>\r\n");
      out.write("                                    <h1>差评0</h1> </div>\r\n");
      out.write("                                <div class=\"col-md-4 col-sm-4 text-center\">\r\n");
      out.write("                                    <p class=\"text-danger\"><i class=\"ti-dribbble\"></i></p>\r\n");
      out.write("                                    <h1>总计");
      out.print(cdlist.size() );
      out.write("</h1> </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <form class=\"form-horizontal form-material\">\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-md-12\">评论管理</label>\r\n");
      out.write("                                    <div class=\"col-md-12\">\r\n");
      out.write("                                        <input type=\"text\" placeholder=\"\" class=\"form-control form-control-line\"> </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label for=\"example-email\" class=\"col-md-12\">退款管理</label>\r\n");
      out.write("                                    <div class=\"col-md-12\">\r\n");
      out.write("                                        <input type=\"email\" placeholder=\"\" class=\"form-control form-control-line\" name=\"example-email\" id=\"example-email\"> </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <label class=\"col-md-12\">违规记录</label>\r\n");
      out.write("                                    <div class=\"col-md-12\">\r\n");
      out.write("                                        <input type=\"password\" value=\"\" class=\"form-control form-control-line\"> </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                             \r\n");
      out.write("                        </div>\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-md-8 col-xs-12\">\r\n");
      out.write("                        <div class=\"white-box\">\r\n");
      out.write("                            \r\n");
      out.write("                      <table class=\"table\">\r\n");
      out.write("                                    <thead>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <th>序号</th>\r\n");
      out.write("                                            <th>商品名称</th>\r\n");
      out.write("                                            <th>评论内容</th>\r\n");
      out.write("                                            <th>日期</th>\r\n");
      out.write("                                            <th></th>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </thead>\r\n");
      out.write("                                     ");
for (int i = 0; i < cdlist.size(); i++) {
      out.write("\r\n");
      out.write("\t\t\t\t                ");
Comment order = cdlist.get(i);
      out.write("\r\n");
      out.write("\t\t\t\t                ");
ICommodityDao dao = new CommodityDaoImpl();
      out.write("\r\n");
      out.write("                                    <tbody>\r\n");
      out.write("                                        <tr>\r\n");
      out.write("                                            <td>");
      out.print(i+1 );
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(dao.select(cdlist.get(i).getShopid()) );
      out.write("</td>\r\n");
      out.write("                                            <td>商品：");
      out.print(order.getShopcontent());
      out.write('服');
      out.write('务');
      out.write('：');
      out.print(order.getServicecontent());
      out.write("</td>\r\n");
      out.write("                                            <td>");
      out.print(order.getTime().toLocalDate());
      out.write("</td>\r\n");
      out.write("                                            <td><a href=\"CommentServlet?action=delete&id=");
      out.print(order.getCid());
      out.write("\">删除</a></td>\r\n");
      out.write("                                        </tr>\r\n");
      out.write("                                    </tbody>\r\n");
      out.write("                                ");
 }
      out.write("\r\n");
      out.write("                                </table>\r\n");
      out.write("                        </div>  \r\n");
      out.write("                        <div class=\"white-box\" id=\"pllzzchart\" style=\"height:500px \">\r\n");
      out.write("                        \r\n");
      out.write("                        </div>\r\n");
      out.write("                        <script>zzchart();</script>\r\n");
      out.write("                        \r\n");
      out.write("                                          \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /.row -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- /.container-fluid -->\r\n");
      out.write("          \r\n");
      out.write("        <!-- /#page-wrapper -->\r\n");
      out.write("    </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
