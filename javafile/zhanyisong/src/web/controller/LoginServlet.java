package web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.bean.Adminuser;
import web.bean.Customer;
import web.dao.IAdminuserDao;
import web.dao.impl.AdminuserDaoImpl;
import web.service.AuthHelper;
import web.service.CustomerInfoService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		urlPatterns = { "/LoginServlet"},
		initParams = { 
				@WebInitParam(name = "login", value = "/jsp/register/login.jsp"),
				@WebInitParam(name = "logout", value = "/home"),
				@WebInitParam(name = "dologin", value = "/jsp/template/jindutiao.jsp"),
				@WebInitParam(name = "admindologin", value = "/admin/index.jsp"),
				@WebInitParam(name = "adminlogin", value = "/admin/login.jsp"),
				@WebInitParam(name = "adminlogout", value = "/home")
				}
		)
public class LoginServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = this.getParameter(request, "action");
		next = "/home";
		switch(action) {
		case "login":
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
					next = this.getServletConfig().getInitParameter("login");
			}
			break;
			
		case "adminlogin":
			next = this.getServletConfig().getInitParameter("adminlogin");
			break;
		
		
		case "adminlogout":{
			HttpSession session = request.getSession(true);
			if (session != null) {
				session.invalidate();
			}
		next = this.getServletConfig().getInitParameter("adminlogout");
	}
		break ;
		
		case "admindologin":{
			String name = request.getParameter("userName");
			String pwd = request.getParameter("userPassword");
			IAdminuserDao aduser = new AdminuserDaoImpl();
			
			Adminuser c=null;
			try {
				c = aduser.load(name, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HttpSession session = request.getSession(true);
			if(c!=null&&session!=null) {
				AuthHelper.setAdminuserInfo2Session(session, c);
				next = this.getServletConfig().getInitParameter("admindologin");
			}
			else
				next = this.getServletConfig().getInitParameter("adminlogin");
		}
		break;
		
	}
		this.forward(next, request, response);
}

}