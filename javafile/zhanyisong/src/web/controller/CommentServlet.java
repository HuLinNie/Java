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
		urlPatterns = { "/CommentServlet"},
		initParams = { 
				@WebInitParam(name = "showcomment", value = "/jsp/demo/detail.jsp"),
				@WebInitParam(name = "delete", value = "/admin/kehufuwu/comment.jsp"),
				 }
		)
public class CommentServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = this.getParameter(request, "action");
		next = "/home";
		HttpSession session = request.getSession(true);
		Customer customer = AuthHelper.getCustomerInfoBySession(session);
		if (customer != null) {
			//从参数获取转向页�?
			next = this.getServletConfig().getInitParameter(action);
			switch (action) {
			case "showcomment":
				// 获取参数
				int id = customer.getId();
				String citem = request.getParameter("pjsp");
				String cname = request.getParameter("cname");
				ICommodityDao da =new CommodityDaoImpl();
				Commodity com=null;
				try {
					 com = da.select(cname);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Comment c= new Comment(id,citem,cname);
				CommentDaoImpl comm = new CommentDaoImpl();
				try {
					comm.insert(c);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestAttrHelper.setCommodityByName(request, com);
				break;	
			
			case "delete":
				int id1= Integer.parseInt(request.getParameter("id"));
				CommentDaoImpl comm1 = new CommentDaoImpl();
				try {
					comm1.delete(id1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				next = this.getServletConfig().getInitParameter("delete");
				break;
			}
		}
		else {
			next = this.getServletConfig().getInitParameter("login");
		}
		this.forward(next, request, response);
	}
}
