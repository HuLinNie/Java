/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2020-03-30 14:50:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.demo;

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

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>山海关大樱桃详情页</title>\r\n");
      out.write("<base href=\"");
      out.print(web.util.BasePath.get(request));
      out.write("\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/header.css\" />\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\t.p-image img{\r\n");
      out.write("\twidth:360px;\r\n");
      out.write("\theight:360px;\r\n");
      out.write("\tborder-radius:20px;}\r\n");
      out.write("\t\r\n");
      out.write("\t.weizhi{\r\n");
      out.write("\tmargin-left:35%;}\r\n");
      out.write("\t.weizhi .head{\r\n");
      out.write("\tmargin-left:12%;\r\n");
      out.write("\t}\r\n");
      out.write("\ttable{\r\n");
      out.write("\tmargin-left:2%;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../template/_header.jsp", out, false);
      out.write(" \r\n");
      out.write("\t \t\t\t<div class=\"weizhi\">\r\n");
      out.write("     \t\t\t\t\t\t");
 Commodity cd = web.util.RequestAttrHelper.getCommodityByName(request);
      out.write("\r\n");
      out.write("                              <div class=\"p-image\"><img src=\"");
      out.print(cd.getImage() );
      out.write("\" /></div>    \r\n");
      out.write("                                  \t <div class=\"head\">");
      out.print(cd.getName());
      out.write(' ');
      out.write(' ');
      out.write(' ');
      out.print(cd.getPrice());
      out.write(" /kg\r\n");
      out.write("                                  \t \t<a class=\"person\" id=\"toCart\" href=\"CartServlet?action=add&id=");
      out.print(cd.getId() );
      out.write("\">加入购物车</a>\r\n");
      out.write("                                  \t </div>                  \r\n");
      out.write("                                 <form action=\"CommentServlet\" method=\"post\">\r\n");
      out.write("                                 \t评价商品<input type=\"text\" name=\"pjsp\" />\r\n");
      out.write("                                 \t 评价服务<input type=\"text\" name=\"pjfw\" />\r\n");
      out.write("                                   <input type=\"hidden\" name=\"cname\" value=\"");
      out.print(cd.getName());
      out.write("\"/>\r\n");
      out.write("                                    <input type=\"hidden\" name=\"action\" value=\"showcomment\"/>\r\n");
      out.write("                                  <input type=\"submit\" name=\"submit\" value=\"提交评价\"/>\r\n");
      out.write("                                 </form>\r\n");
      out.write("                                \r\n");
      out.write("                        \t\t");
String nam = cd.getName(); 
      out.write("\r\n");
      out.write("                                ");
ICommentDao dao1= new CommentDaoImpl();List<Comment> cdlist=dao1.load(nam);
      out.write("\r\n");
      out.write("                                     \r\n");
      out.write("                                 <table>\r\n");
      out.write("                                  <tr><th>累计评价</th> <td>");
      out.print( cdlist.size() );
      out.write("条</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                <tr><th>商品</th> <th>评论内容</th>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                                ");
for (int i = 0; i < cdlist.size(); i++) {
      out.write("\r\n");
      out.write("\t\t\t\t                ");
Comment order = cdlist.get(i);
      out.write("\r\n");
      out.write("\t\t\t\t                \r\n");
      out.write("\t\t\t\t               \r\n");
      out.write("\t\t\t\t                <tr><th>");
      out.print(order.getCname() );
      out.write("</th>\r\n");
      out.write("\t\t\t\t                <td>");
      out.print(order.getCitem() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t                </tr>\r\n");
      out.write("\t\t\t\t                ");
 }
      out.write("\r\n");
      out.write("                               \r\n");
      out.write("                                </table>\r\n");
      out.write("              </div>  \r\n");
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
