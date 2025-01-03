package web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.bean.Commodity;
import web.dao.ICommodityDao;
import web.dao.impl.CommodityDaoImpl;

/**
 * Servlet implementation class SpServlet
 */
@WebServlet(
		urlPatterns = { "/SpServlet"},
		initParams = { 
				@WebInitParam(name = "show", value = "/admin/shangpinguanli/commodity.jsp"),
				@WebInitParam(name = "add", value = "/admin/shangpinguanli/add.jsp"),
				@WebInitParam(name = "delete", value = "/admin/shangpinguanli/delete.jsp"),
				@WebInitParam(name = "update", value = "/admin/shangpinguanli/update.jsp"),
				@WebInitParam(name = "doadd", value = "/admin/shangpinguanli/delete.jsp"),
				@WebInitParam(name = "doupdate", value = "/admin/shangpinguanli/update.jsp"),
				@WebInitParam(name = "dodelete", value = "/admin/shangpinguanli/delete.jsp"),
				
				}
		)
public class SpServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = this.getParameter(request, "action");
		next = "/home";
		switch(action) {
		case "show":
			next = this.getServletConfig().getInitParameter("show");
			break;
			
		case "add":
			next = this.getServletConfig().getInitParameter("add");
			break;
		
		case "delete":
			next = this.getServletConfig().getInitParameter("delete");
			break;
		
		case "update":
			if(request.getParameter("id")==null) 
				next = this.getServletConfig().getInitParameter("delete");
			else {
				
			int id1 = Integer.parseInt(request.getParameter("id"));
			
			ICommodityDao idao1 =new  CommodityDaoImpl();
			Commodity com=null;
			try {
				com = idao1.load(id1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.setAttribute("Commodity1", com);
			next = this.getServletConfig().getInitParameter("update");}
			break;
		
		case "dodelete":
			ICommodityDao idao =new  CommodityDaoImpl();
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				idao.delete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			next = this.getServletConfig().getInitParameter("dodelete");
			break;
			
		case "doupdate":
			int id2 = Integer.parseInt(request.getParameter("id"));
			double price = Double.parseDouble(request.getParameter("price"));
			String image = request.getParameter("image");
			String name = request.getParameter("name");
			Commodity cd = new Commodity();
			cd.setId(id2);
			cd.setName(name);
			cd.setImage(image);
			cd.setPrice(price);
			ICommodityDao idao2 =new  CommodityDaoImpl();
			try {
				idao2.update(cd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("Commodity1", cd);
			next = this.getServletConfig().getInitParameter("doupdate");
			break;
			
		case "doadd":
			double price1 = Double.parseDouble(request.getParameter("price"));
			String image1 = request.getParameter("image");
			String name1 = request.getParameter("name");
			Commodity cd1 = new Commodity();
			
			cd1.setName(name1);
			cd1.setImage(image1);
			cd1.setPrice(price1);
			ICommodityDao idao3 =new  CommodityDaoImpl();
			try {
				idao3.insert(cd1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			next = this.getServletConfig().getInitParameter("doadd");
			break;
		
		
	}
		this.forward(next, request, response);
}

}