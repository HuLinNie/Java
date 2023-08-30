package web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.bean.Commodity;
import web.bean.Customer;
import web.dao.ICommodityDao;
import web.dao.impl.CommodityDaoImpl;
import web.service.AuthHelper;
import web.service.CustomerInfoService;
import web.util.RequestAttrHelper;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(urlPatterns = { "/SearchServlet"},
initParams = { 
		@WebInitParam(name = "search", value = "/jsp/demo/search.jsp")}
)
public class SearchServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;
	private String nextUrl;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("search");
		System.out.println(id);
		nextUrl = this.getServletConfig().getInitParameter("search");
		ICommodityDao dao = new CommodityDaoImpl();
		List<Commodity> clist=null;
		try {
			 clist =dao.query(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestAttrHelper.setCommodity(request, clist);
		request.getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
}
}  
