package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;



@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int number = Integer.parseInt(request.getParameter("number"));
		ProductService productService = new ProductService();
		boolean result = productService.deleteProductByPnub(number);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();		
//		if(result) {
//			out.println("删除成功！");
//			response.sendRedirect("QueryAllProductsServlet");//重新查询所有产品
//		}else {
//			out.println("删除失败！");
//		}
		if(!result) {//如果删除失败，给request放入一条数据error
			request.setAttribute("error", "addError");			
		}else {//删除成功
			request.setAttribute("error", "noaddError");	
		}
		request.getRequestDispatcher("QueryAllProductsServlet").forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
