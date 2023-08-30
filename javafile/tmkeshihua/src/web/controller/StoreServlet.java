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
		urlPatterns = { "/StoreServlet"},
		initParams = { 
				@WebInitParam(name = "show", value = "/admin/dianpuguanli/store.jsp"),
				
				}
		)
public class StoreServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = this.getParameter(request, "action");
		next = "/home";
		switch(action) {
		case "show":
			next = this.getServletConfig().getInitParameter("show");
			break;
		
		
	}
		this.forward(next, request, response);
}

}