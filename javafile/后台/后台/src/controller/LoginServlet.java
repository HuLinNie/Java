package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import entity.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    
//    public LoginServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Login login = new Login(name,pwd);
		
		int result = LoginDao.login(login);
//		if(result > 0) {
//			response.sendRedirect("QueryAllProductsServlet");			
//		} else {
//			response.sendRedirect("index.jsp");
//		}
		if(result > 0) {
			request.setAttribute("right", "addRight");
			//response.sendRedirect("QueryAllProductsServlet");	
			request.getRequestDispatcher("QueryAllProductsServlet").forward(request, response);
		} else {
			request.setAttribute("right", "noaddRight");
			//response.sendRedirect("index.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
