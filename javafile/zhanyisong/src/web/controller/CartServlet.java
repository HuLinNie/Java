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
import web.bean.Customer;
import web.bean.Order;
import web.bean.OrderItem;
import web.dao.ICommodityDao;
import web.dao.IOrderDao;
import web.dao.impl.CommodityDaoImpl;
import web.dao.impl.OrderDaoImpl;
import web.service.CommodityService;
import web.service.AuthHelper;
import web.service.CartService;
import web.service.OrderService;
import web.util.RequestAttrHelper;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(
		urlPatterns = { "/CartServlet"},
		initParams = { 
				@WebInitParam(name = "showcart", value = "/jsp/function/Cart.jsp"),
				@WebInitParam(name = "checkout", value = "/jsp/function/Checkout.jsp"),
				@WebInitParam(name = "deorder", value = "/jsp/function/Checkout.jsp"),
				@WebInitParam(name = "docheckout", value = "/home"),
				@WebInitParam(name = "add", value = "/CartServlet?action=showcart"),
				@WebInitParam(name = "deleteorder", value = "/admin/jiaoyiguanli/order.jsp"),
				@WebInitParam(name = "delete", value = "/CartServlet?action=showcart"),
				@WebInitParam(name = "login", value = "/LoginServlet?action=login"),
				@WebInitParam(name = "showorder", value = "/jsp/function/Order.jsp") }
		)
public class CartServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = this.getParameter(request, "action");
		next = "/home";
		HttpSession session = request.getSession(true);
		Cart cart = null;
		Customer customer = AuthHelper.getCustomerInfoBySession(session);
		if (customer != null) {
			//从参数获取转向页�?
			next = this.getServletConfig().getInitParameter(action);
			CartService cartServ = new CartService(customer.getId());
			cart = cartServ.getCart();
			switch (action) {
			case "showcart":
				RequestAttrHelper.setCartObject(request, cart);
				next = this.getServletConfig().getInitParameter("showcart");
				break;
			case "checkout":
				OrderService oServ = new OrderService();
				
				String oid = oServ.CreateOrder(customer);// 添加订单到系统中
				OrderDaoImpl oService = new OrderDaoImpl();
				Order order=null;
				try {
					order = oService.select(oid);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//
				RequestAttrHelper.setCartObject(request, cart);
//				request.setAttribute("theorder", order);
				RequestAttrHelper.setOrder(request, order);			
				break;
			case "docheckout":
				break;
			case "add":
				// 获取参数
//				int id = Integer.parseInt(request.getParameter("albumId"));
//				// 唱片数量
//				int count = Integer.parseInt(request.getParameter("qty"));
				// 通过唱片管理服务，加载出要添加到购物车的产品
				int  id =Integer.parseInt(request.getParameter("id"));
				ICommodityDao dao = new CommodityDaoImpl();
				String name=null;
				try {
					name = dao.select(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int count =1;
//				int id = customer.getId(); 	
//				CommodityService cdServ = new CommodityService();
				Commodity aCD=null;
				try {
					aCD = dao.load(name);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 创建购物车条目，设置唱片与数�?
				OrderItem item = new OrderItem();
				item.setCommodity(aCD);
				item.setQuantity(count);
				System.out.println(item);
				cartServ.addItem(item);// 加入购物�?
				break;
			case "delete":
				String del = request.getParameter("delindex");
				cartServ.removeItemAt(Integer.parseInt(del));
				break;
				
			case "deleteorder":
				String dele = request.getParameter("id");
				IOrderDao dao2 = new OrderDaoImpl();
				try {
					dao2.delete(dele);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				next = this.getServletConfig().getInitParameter("deleteorder");
				break;
				
			
			case "deorder":
				String del2 = request.getParameter("delindex");
				cartServ.removeItemAt(Integer.parseInt(del2));
				IOrderDao dao1= new OrderDaoImpl();
				String id1 = request.getParameter("oid");
				try {
					dao1.delete(id1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		else {
			next = this.getServletConfig().getInitParameter("login");
		}
		this.forward(next, request, response);
	}
}
