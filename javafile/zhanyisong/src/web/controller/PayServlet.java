package web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.bean.Customer;
import web.dao.impl.CustomerDaoImpl;
import web.service.AuthHelper;
import web.service.CustomerInfoService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		urlPatterns = { "/PayServlet"},
		initParams = { 
				@WebInitParam(name = "pay", value = "/jsp/function/Order.jsp"),
				}
		)
public class PayServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);	
		next = this.getServletConfig().getInitParameter("pay");
		request.getServletContext().getRequestDispatcher(next).forward(request, response);
		
//		this.forward(next, request, response);
	}
}
