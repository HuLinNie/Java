package shopping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.bean.Album;
import shopping.bean.Cart;
import shopping.bean.Customer;
import shopping.bean.Order;
import shopping.bean.OrderItem;
import shopping.service.AlbumService;
import shopping.service.AuthHelper;
import shopping.service.CartService;
import shopping.service.OrderService;
import shopping.util.RequestAttrHelper;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(
		urlPatterns = { "/CartServlet"},
		initParams = { 
				@WebInitParam(name = "showcart", value = "/jsp/Cart.jsp"),
				@WebInitParam(name = "checkout", value = "/jsp/Checkout.jsp"),
				@WebInitParam(name = "docheckout", value = "/home"),
				@WebInitParam(name = "add", value = "/CartServlet?action=showcart"),
				@WebInitParam(name = "delete", value = "/CartServlet?action=showcart"),
				@WebInitParam(name = "login", value = "/LoginServlet?action=login") }
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
			//浠庡弬鏁拌幏鍙栬浆鍚戦〉闈�
			next = this.getServletConfig().getInitParameter(action);
			CartService cartServ = new CartService(customer.getId());
			cart = cartServ.getCart();
			switch (action) {
			case "showcart":
				RequestAttrHelper.setCartObject(request, cart);
				next = "/jsp/Cart.jsp";
				break;
			case "checkout":
				OrderService oServ = new OrderService();
				String oid = oServ.CreateOrder(customer);// 娣诲姞璁㈠崟鍒扮郴缁熶腑
				OrderService oService = new OrderService();
				Order order = oService.load(oid);//
				RequestAttrHelper.setOrder(request, order);
				break;
			case "docheckout":
				break;
			case "add":
				// 鑾峰彇鍙傛暟
				int id = Integer.parseInt(request.getParameter("albumId"));
				// 鍞辩墖鏁伴噺
				int count = Integer.parseInt(request.getParameter("qty"));
				// 閫氳繃鍞辩墖绠＄悊鏈嶅姟锛屽姞杞藉嚭瑕佹坊鍔犲埌璐墿杞︾殑浜у搧
				AlbumService cdServ = new AlbumService();
				Album aCD = cdServ.find(id);
				// 鍒涘缓璐墿杞︽潯鐩紝璁剧疆鍞辩墖涓庢暟閲�
				OrderItem item = new OrderItem();
				item.setAlbum(aCD);
				item.setQuantity(count);
				System.out.print(item);
				cartServ.addItem(item);// 鍔犲叆璐墿杞�
				break;
			case "delete":
				String del = request.getParameter("delindex");
				cartServ.removeItemAt(Integer.parseInt(del));
				break;
			}
		}
		else {
			next = this.getServletConfig().getInitParameter("login");
		}
		this.forward(next, request, response);
	}
}
