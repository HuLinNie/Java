package web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import web.bean.Commodity;
import web.dao.ICommodityDao;
import web.dao.impl.CommodityDaoImpl;

/**
 * Servlet implementation class Jhsprice_numberServlet
 */
@WebServlet("/Jhsprice_numberServlet")
public class Jhsprice_numberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ICommodityDao dao=new CommodityDaoImpl();
		List<Commodity> array = null;
		
	    try {
			 array= dao.load();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    String json =JSON.toJSONString(array);
	    System.out.println("聚划算占比");
	    System.out.println(json);
	    response.setContentType("text/html;charset=utf-8");
	    response.getWriter().write(json);
	}

}
