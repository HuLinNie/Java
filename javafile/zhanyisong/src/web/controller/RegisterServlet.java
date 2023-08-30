package web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.bean.Adminuser;
import web.bean.Customer;
import web.dao.IAdminuserDao;
import web.dao.impl.AdminuserDaoImpl;
import web.service.CustomerInfoService;

@WebServlet(
		urlPatterns = { "/RegisterServlet"},
		initParams = { 
				@WebInitParam(name = "register", value = "/jsp/register/register.jsp"),
				@WebInitParam(name = "doregister", value = "/jsp/register/register_result.jsp"),
				@WebInitParam(name = "adminregister", value = "/admin/register.jsp"),
				@WebInitParam(name = "admindoregister", value = "/admin/index.jsp")
			}
		)
public class RegisterServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action= getParameter(request,"action");
		next = "/home";
		switch (action) {
		case "register":
			next = this.getServletConfig().getInitParameter("register");
			break;
		case "doregister":
			String name = request.getParameter("userName");
			String pwd = request.getParameter("userPassword");
			String phone = request.getParameter("userPhone");
			
			Customer c = new Customer();
			
			c.setName(name);
			c.setPassword(pwd);
			c.setPhone(phone);
			CustomerInfoService serv = new CustomerInfoService();
			serv.save(c);
			request.setAttribute("register_info", c);
			next = this.getServletConfig().getInitParameter("doregister");
			break;
		
		case "adminregister":
			next = this.getServletConfig().getInitParameter("adminregister");
			break;
			
		case "admindoregister":
			String name1 = request.getParameter("userName");
			String pwd1 = request.getParameter("userPassword");
			String phone1 = request.getParameter("userPhone");
			
			Adminuser c1 = new Adminuser();
			
			c1.setName(name1);
			c1.setPassword(pwd1);
			c1.setPhone(phone1);
			IAdminuserDao serv1 = new AdminuserDaoImpl();
			
			try {
				serv1.insert(c1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			next = this.getServletConfig().getInitParameter("admindoregister");
			break;
		
		}
		this.forward(next, request, response);
	}

}
