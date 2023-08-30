package web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.bean.Commodity;
import web.service.CommodityService;
import web.util.RequestAttrHelper;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(
		urlPatterns = { "/home"},
		initParams = {@WebInitParam(name = "home", value = "/index.jsp")}
		)
public class HomeServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//唱片服务�?
		CommodityService serv = new CommodityService();
		//从数据库查询唱片
		List<Commodity> list = serv.loadAvailable();
		//将唱片列表设置到request中，用于在首页中显示
		RequestAttrHelper.setCommodity(request, list);
		next = this.getServletConfig().getInitParameter("home");
		forward(next,request, response);
	}

}
