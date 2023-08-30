package web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KhServlet
 */
@WebServlet(
		urlPatterns = { "/KhServlet"},
		initParams = { 
				@WebInitParam(name = "show", value = "/admin/kehufuwu/comment.jsp"),
				
				}
		)
public class KhServlet extends ActionServlet {
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
