package shopping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.bean.Customer;
import shopping.service.AuthHelper;
import shopping.service.CustomerInfoService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		urlPatterns = { "/LoginServlet"},
		initParams = { 
				@WebInitParam(name = "login", value = "/jsp/register/login.jsp"),
				@WebInitParam(name = "logout", value = "/home"),
				@WebInitParam(name = "dologin", value = "/home") }
		)
public class LoginServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = this.getParameter(request, "action");
		next = "/home";
		switch(action) {
		case "login":
			//dosometing  设置防止重复提交标志
			//next = "/jsp/register/login.jsp";
			next = this.getServletConfig().getInitParameter("login");
			break;
		case "logout":{
				HttpSession session = request.getSession(true);
				if (session != null) {
					session.invalidate();
				}
				next = this.getServletConfig().getInitParameter("logout");
			}
			break ;
		case "dologin":{
				String email = request.getParameter("userMail");
				String pwd = request.getParameter("userPassword");
				CustomerInfoService service = new CustomerInfoService();
				Customer c = service.load(email, pwd);
				HttpSession session = request.getSession(true);
				if(c!=null&&session!=null) {
					AuthHelper.setCustomerInfo2Session(session, c);
					next = this.getServletConfig().getInitParameter("dologin");
				}
				else
					next = this.getServletConfig().getInitParameter("login");;
			}
			break;
		}
		
		this.forward(next, request, response);
	}
}
