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
		urlPatterns = { "/AdminhomeServlet"},
		initParams = {@WebInitParam(name = "adminhome", value = "/admin/index.jsp")}
		)
public class AdminhomeServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		next = this.getServletConfig().getInitParameter("adminhome");
		forward(next,request, response);
	}

}
