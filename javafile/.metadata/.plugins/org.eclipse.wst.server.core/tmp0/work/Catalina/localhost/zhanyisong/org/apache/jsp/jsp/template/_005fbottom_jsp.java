/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2020-03-30 09:42:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _005fbottom_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style>\r\n");
      out.write(".footer {\r\n");
      out.write("\twidth: 1180px;\r\n");
      out.write("\theight: 200px;\r\n");
      out.write("\tbackground-color: #FFF;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\tpadding-top: 30px;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("}\r\n");
      out.write(".footer-left{\r\n");
      out.write("\twidth: 505px;\r\n");
      out.write("\theight: 150px;\r\n");
      out.write("\t/* background-color: blue; */\r\n");
      out.write("\tmargin-top:30px;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("}\r\n");
      out.write(".footer-left P{\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tline-height: 24px;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tcolor: #444;\r\n");
      out.write("\tmargin: 20px 0 0;\r\n");
      out.write("\t/* background-color: #fff; */\r\n");
      out.write("}\r\n");
      out.write(".footer-right{\r\n");
      out.write("\twidth: 600px;\r\n");
      out.write("\theight: 130px;\r\n");
      out.write("\tmargin:auto 0;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tright: 0px;\r\n");
      out.write("}\r\n");
      out.write(".footer-right dl{\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tmargin-left: 130px;\r\n");
      out.write("}\r\n");
      out.write(".footer-right dl dt{\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tcolor: #333;\r\n");
      out.write("\theight: 30px;\r\n");
      out.write("}\r\n");
      out.write(".footer-right dd{\r\n");
      out.write("\theight: 20px;\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tcolor:#444;\r\n");
      out.write("}\r\n");
      out.write(".in video{\r\n");
      out.write("    width:580px;\r\n");
      out.write("    height:100%;\r\n");
      out.write("    position:absolute;\r\n");
      out.write("    left:200px;\r\n");
      out.write("\tdisplay:block;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t <!-- footer start -->\r\n");
      out.write("    <div class=\"footer\">\r\n");
      out.write("        <div class=\"footer-left\">\r\n");
      out.write("            <p>Shopping Near<br>\r\n");
      out.write("                The meanning of life is that it stops.\r\n");
      out.write("            </p>\r\n");
      out.write("            <!-- <a href=\"index.html\">下载APP</a> -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"footer-right\">\r\n");
      out.write("            <dl>\r\n");
      out.write("                <dt>关于我们</dt>\r\n");
      out.write("                <a href=\"index.html\"><dd>联系方式</dd></a>\r\n");
      out.write("                <a href=\"index.html\"><dd>管理团队</dd></a>\r\n");
      out.write("                <a href=\"index.html\"><dd>在线客服</dd></a>\r\n");
      out.write("                <a href=\"index.html\"><dd>问题咨询</dd></a>\r\n");
      out.write("                <a href=\"index.html\"><dd>帮助</dd></a>\r\n");
      out.write("            </dl>\r\n");
      out.write("            <dl>\r\n");
      out.write("                <dt>建议</dt>\r\n");
      out.write("                <a href=\"index.html\"><dd>网站建议</dd></a>\r\n");
      out.write("                <a href=\"index.html\"><dd>布局建议</dd></a>\r\n");
      out.write("                <a href=\"index.html\"><dd>其他建议</dd></a>\r\n");
      out.write("            </dl>\r\n");
      out.write("            <dl>\r\n");
      out.write("                <dt>联系方式</dt>\r\n");
      out.write("                <a href=\"index.html\"><dd>QQ</dd></a>\r\n");
      out.write("                <a href=\"index.html\"><dd>微信</dd></a>\r\n");
      out.write("                <a href=\"index.html\"><dd>微博</dd></a>\r\n");
      out.write("            </dl>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- footer end -->\r\n");
      out.write("     \r\n");
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
