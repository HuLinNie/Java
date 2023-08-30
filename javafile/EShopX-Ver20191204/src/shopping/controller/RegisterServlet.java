package shopping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.bean.Customer;
import shopping.service.CustomerInfoService;

@WebServlet(
		urlPatterns = { "/RegisterServlet"},
		initParams = { 
				@WebInitParam(name = "register", value = "/jsp/register/register.jsp"),
				@WebInitParam(name = "doregister", value = "/jsp/register/register_result.jsp")
			}
		)
public class RegisterServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action= getParameter(request,"action");
		next = "/home";
		switch (action) {
		case "register":
			// dosometing //dosometing 设置防止重复提交标志
			//next = "/jsp/register/register.jsp";
			next = this.getServletConfig().getInitParameter("register");
			break;
		case "doregister":
			// 保存用户数据
			String email = request.getParameter("userMail");
			String name = request.getParameter("userName");
			String pwd = request.getParameter("userPassword");
			String phone = request.getParameter("userPhone");
			String birthday = request.getParameter("userBirthday");

			String address = "";
			Customer c = new Customer();
			c.setMail(email);
			c.setName(name);
			c.setPassword(pwd);
			c.setPhone(phone);
			c.setBirthday(birthday);
			c.setAddress(address);

			CustomerInfoService serv = new CustomerInfoService();
			serv.save(c);
			request.setAttribute("register_info", c);

			//next = "/jsp/register/register_result.jsp";
			next = this.getServletConfig().getInitParameter("doregister");
			break;
		}
		this.forward(next, request, response);
	}

}
