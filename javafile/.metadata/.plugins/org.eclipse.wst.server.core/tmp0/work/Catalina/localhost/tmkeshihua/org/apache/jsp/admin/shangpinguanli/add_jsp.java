/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2021-04-12 03:31:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin.shangpinguanli;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>添加商品</title>\r\n");
      out.write("\r\n");
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
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"row bg-title\">\r\n");
      out.write("                    <div class=\"col-lg-3 col-md-4 col-sm-4 col-xs-12\">\r\n");
      out.write("                        <h4 class=\"page-title\">添加商品</h4> </div>\r\n");
      out.write("                        <ol class=\"breadcrumb\">\r\n");
      out.write("                             <li><a href=\"home\">买家中心</a></li>\r\n");
      out.write("                            <li><a href=\"AdminhomeServlet?action=adminhome\">卖家服务</a></li>\r\n");
      out.write("                        </ol>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.col-lg-12 -->\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form  action=\"SpServlet\" method=\"post\" >\r\n");
      out.write("\t\t&nbsp;\r\n");
      out.write("\t\t<table cellSpacing=\"1\" cellPadding=\"5\" width=\"100%\" align=\"center\"\r\n");
      out.write("\t\t\tbgColor=\"#eeeeee\" style=\"border: 1px solid #8ba7e3\" border=\"0\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"18%\" align=\"center\" bgColor=\"#f5fafe\" class=\"ta_01\">\r\n");
      out.write("\t\t\t\t\t商品名称：</td>\r\n");
      out.write("\t\t\t\t<td class=\"ta_01\" bgColor=\"#ffffff\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"name\" value=\"\" id=\"userAction_save_do_logonName\" class=\"bg\" />\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td width=\"18%\" align=\"center\" bgColor=\"#f5fafe\" class=\"ta_01\">\r\n");
      out.write("\t\t\t\t\t商品价格：\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td class=\"ta_01\" bgColor=\"#ffffff\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"price\" value=\"\" id=\"userAction_save_do_logonName\" class=\"bg\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"18%\" align=\"center\" bgColor=\"#f5fafe\" class=\"ta_01\">\r\n");
      out.write("\t\t\t\t\t商品图片：</td>\r\n");
      out.write("\t\t\t\t<td class=\"ta_01\" bgColor=\"#ffffff\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t<input type=\"file\" name=\"image\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"18%\" align=\"center\" bgColor=\"#f5fafe\" class=\"ta_01\">\r\n");
      out.write("\t\t\t\t\t商品描述：</td>\r\n");
      out.write("\t\t\t\t<td class=\"ta_01\" bgColor=\"#ffffff\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<textarea name=\"pdesc\" rows=\"5\" cols=\"30\"></textarea>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"ta_01\" style=\"WIDTH: 100%\" align=\"center\" bgColor=\"#f5fafe\" colSpan=\"4\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\"  value=\"确定\"/> <FONT face=\"宋体\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>\r\n");
      out.write("\t\t\t\t\t<button type=\"reset\" value=\"重置\" class=\"button_cancel\">&#37325;&#32622;</button>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"action\" value=\"doadd\"/>\r\n");
      out.write("\t\t\t\t\t<FONT face=\"宋体\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT\r\n");
      out.write("\t\t\t\t\tclass=\"button_ok\" type=\"button\" onclick=\"history.go(-1)\" value=\"返回\" />\r\n");
      out.write("\t\t\t\t\t<span id=\"Label1\"></span>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
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
