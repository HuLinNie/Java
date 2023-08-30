package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dealServlet
 */
@WebServlet(
		urlPatterns = { "/DealServlet"},
		initParams = { 
				@WebInitParam(name = "show", value = "/admin/jiaoyiguanli/order.jsp"),
				
				}
		)
public class DealServlet extends ActionServlet {
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
