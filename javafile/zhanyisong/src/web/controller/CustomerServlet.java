package web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.bean.Commodity;
import web.bean.Cart;
import web.bean.Comment;
import web.bean.Customer;
import web.bean.Order;
import web.bean.OrderItem;
import web.dao.ICommodityDao;
import web.dao.impl.CommentDaoImpl;
import web.dao.impl.CommodityDaoImpl;
import web.dao.impl.CustomerDaoImpl;
import web.service.CommodityService;
import web.service.AuthHelper;
import web.service.CartService;
import web.service.CustomerInfoService;
import web.service.OrderService;
import web.util.RequestAttrHelper;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(
		urlPatterns = { "/CustomerServlet"},
		initParams = { 
				@WebInitParam(name = "showcomment", value = "/jsp/demo/detail.jsp"),
				@WebInitParam(name = "delete", value = "/admin/yonghuguanli/user.jsp"),
				 }
		)
public class CustomerServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = this.getParameter(request, "action");
		next = "/home";
		switch(action) {
			case "delete":
				int id1= Integer.parseInt(request.getParameter("id"));
				CustomerDaoImpl comm1 = new CustomerDaoImpl();
				try {
					comm1.delete(id1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				next = this.getServletConfig().getInitParameter("delete");
				break;}
				
	this.forward(next, request, response);
	}
	
}
