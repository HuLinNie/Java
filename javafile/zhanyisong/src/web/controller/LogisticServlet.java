package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogisticServlet
 */
@WebServlet(
		urlPatterns = { "/LogisticServlet"},
		initParams = { 
				@WebInitParam(name = "show", value = "/admin/wuliuguanli/logistic.jsp"),
				
				}
		)
public class LogisticServlet extends ActionServlet {
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