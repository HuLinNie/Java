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

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取待修改的编号
		int number = Integer.parseInt(request.getParameter("number"));
		//System.out.println(number);
		//获取修改后的内容
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String kind = request.getParameter("kind");
		//将修改后的内容封装到一个实体类中
		Product product = new Product(number,name,price,kind);
		
		ProductService productService = new ProductService();
		boolean result = productService.updateProductByPnub(number, product);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();		
//		if(result) {
//			//out.println("修改成功！");
//			//response.sendRedirect("QueryAllProductsServlet");//重新查询所有产品
//		}else {
//			//out.println("修改失败！");
//		}
		if(!result) {//如果修改失败，给request放入一条数据error
			request.setAttribute("error", "addError");			
		}else {//修改成功
			request.setAttribute("error", "noaddError");	
		}
		request.getRequestDispatcher("QueryAllProductsServlet").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
