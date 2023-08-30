package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;

@WebServlet("/QueryProductByPnubServlet")
public class QueryProductByPnubServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		int number = Integer.parseInt(request.getParameter("number"));
		
		ProductService productService = new ProductService();
		Product product = productService.queryProductByPnub(number);
		//System.out.println(product);
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("productInfo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
