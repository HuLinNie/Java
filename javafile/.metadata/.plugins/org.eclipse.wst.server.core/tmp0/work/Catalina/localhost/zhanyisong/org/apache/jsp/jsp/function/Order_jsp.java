/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.29
 * Generated at: 2020-04-05 13:56:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.function;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import web.bean.*;
import web.util.*;
import web.service.*;
import web.dao.*;
import web.dao.impl.*;

public final class Order_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>所有订单</title>\r\n");
      out.write("<base href=\"");
      out.print(BasePath.get(request));
      out.write("\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/header.css\" />\r\n");
      out.write("<style>\r\n");
      out.write("\t.sptp{width:80x;\r\n");
      out.write("\theight:80px;}\r\n");
      out.write("\t.total{\r\n");
      out.write("\tmargin-left:35%;\r\n");
      out.write("\theight:20px;}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../template/_header.jsp", out, false);
      out.write("\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t<div style=\"width: 100%; min-height: 500px\">\r\n");
      out.write("\t\t<table style=\"margin: 0 auto;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<th><b>日期</b></th>\r\n");
      out.write("\t\t\t\t<th><b>订单号</b></th>\r\n");
      out.write("\t\t\t\t<th><b>总价</b></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");
Customer cu = AuthHelper.getCustomerInfoBySession(session); 
      out.write("\r\n");
      out.write("\t\t\t");
int customerid=cu.getId(); 
      out.write("\r\n");
      out.write("\t\t\t");
IOrderDao  idao = new  OrderDaoImpl(); 
      out.write("\r\n");
      out.write("\t\t\t");
List<Order> orderlist = idao.loadByCustomer(customerid); 
      out.write("\r\n");
      out.write("\t\t\t<tr><td><b>我的ID：");
      out.print(customerid);
      out.write("</b></td></tr>\r\n");
      out.write("\t\t\t");
for (int i = 0; i < orderlist.size(); i++) {
      out.write("\r\n");
      out.write("\t\t\t\t");
Order order = orderlist.get(i);
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td><b>");
      out.print(order.getDate());
      out.write("</b></td>\r\n");
      out.write("\t\t\t\t\t<td><b>");
      out.print(order.getId());
      out.write("</b></td>\r\n");
      out.write("\t\t\t\t\t<td><b>");
      out.print(Numeric.toFixedDecimalString(order.getAmount(), 2));
      out.write("</b></td>\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");
String oid1 = order.getId(); 
      out.write("\r\n");
      out.write("\t\t\t\t\t");
Cart cart = idao.load1(oid1);
      out.write("\r\n");
      out.write("\t\t\t\t\t");
List<OrderItem> buylist = cart.getItems();
      out.write("\r\n");
      out.write("\t\t\t\t\t");

					for(int idx = 0 ; idx < buylist.size(); idx++){
							OrderItem anOrder = buylist.get(idx);
							Commodity cd = anOrder.getCommodity();
							if(cd!=null){
				
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><b><img class=\"sptp\" src=\"");
      out.print(cd.getImage());
      out.write("\"/></b></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><b>");
      out.print(cd.getName());
      out.write("</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><b>");
      out.print(Numeric.toFixedDecimalString(cd.getPrice(), 2));
      out.write("</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><b>");
      out.print(anOrder.getQuantity());
      out.write("</b></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><b>");
      out.print(Numeric.toFixedDecimalString(cd.getPrice()*anOrder.getQuantity(),2) );
      out.write("</b></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t\t\t");
}
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t");
}
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../template/_bottom.jsp", out, false);
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