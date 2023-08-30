

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet(
		urlPatterns= {"/register_image"},
		initParams=@WebInitParam(name = "nextUrl", value = "/register-info.jsp"))
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nextUrl;
//	private String tmpPath;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
//		this.tmpPath = config.getInitParameter("tmpPath");
		this.nextUrl = config.getInitParameter("nextUrl");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("stuId");
		String name = request.getParameter("Name");
		StringBuilder builder = new StringBuilder();
		request.setAttribute("reg_msg",builder.append(id).append(',')//id
				.append(name).toString());
		
		request.getServletContext().getRequestDispatcher(nextUrl).forward(request, response);
	}

}
