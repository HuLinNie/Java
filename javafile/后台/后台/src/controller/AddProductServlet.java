package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int number = Integer.parseInt(request.getParameter("number"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String kind = request.getParameter("kind");
		Product product = new Product(number,name,price,kind);
		
		ProductService productService = new ProductService();
		boolean result = productService.addProduct(product);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		if(result) {
//			out.println("增加成功！");
//		}else {
//			out.println("增加失败！");
//		}
		if(!result) {//如果增加失败，给request放入一条数据error
			request.setAttribute("error", "addError");			
		}else {//增加成功
			request.setAttribute("error", "noaddError");	
		}
		request.getRequestDispatcher("QueryAllProductsServlet").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
