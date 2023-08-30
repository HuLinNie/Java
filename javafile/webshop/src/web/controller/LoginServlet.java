package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.bean.Customer;
import web.service.AuthHelper;
import web.service.CustomerInfoService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		urlPatterns = { "/LoginServlet"},
		initParams = { 
				@WebInitParam(name = "login", value = "/login.jsp"),
				@WebInitParam(name = "dologin", value = "/index.jsp") }
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
		case "dologin":{
				String name = request.getParameter("userName");
				String pwd = request.getParameter("userPassword");
				CustomerInfoService service = new CustomerInfoService();
				Customer c = service.load(name, pwd);
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
