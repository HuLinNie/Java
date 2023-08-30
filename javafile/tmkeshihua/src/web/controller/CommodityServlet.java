package web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.bean.Commodity;
import web.dao.ICommodityDao;
import web.dao.impl.CommodityDaoImpl;
import web.service.CommodityService;
import web.util.RequestAttrHelper;

@WebServlet(
		urlPatterns = { "/CommodityServlet"},
		initParams = { 
				@WebInitParam(name = "show", value = "/jsp/demo/detail.jsp"),
				@WebInitParam(name = "add", value = "/home"),
				@WebInitParam(name = "edit", value = "/home"),
				@WebInitParam(name = "save", value = "/home"),
				@WebInitParam(name = "delete", value = "/home"),
				@WebInitParam(name = "list", value = "/home")
			}
		)
public class CommodityServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action= getParameter(request,"action");
		next = "/home";
		switch(action) {
		case "show":
			int id=Integer.parseInt(request.getParameter("id"));
			ICommodityDao dao = new CommodityDaoImpl(); 
			String name=null;
			try {
				name = dao.select(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Commodity cf = null;
			try {
				 cf =dao.select(name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestAttrHelper.setCommodityByName(request, cf);
			next = this.getServletConfig().getInitParameter("show");
			break;
		case "add"://准备添加唱片，get添加唱片表单
			break;
		case "edit"://准备编辑唱片信息，get编辑唱片表单（与add共用表单，表单中组件置入要编辑唱片的信息�?
			break;
		case "save"://提交唱片数据（对应add与edit后的数据保存），存入系统
			break;
			
		case "list"://显示唱片列表，准备下�?步操作（删除、编辑）;
			break;
		case "delete":
			break;
		
		}
		this.forward(next, request, response);
	}
}
