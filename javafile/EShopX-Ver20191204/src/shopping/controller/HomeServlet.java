package shopping.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.bean.Album;
import shopping.service.AlbumService;
import shopping.util.RequestAttrHelper;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(
		urlPatterns = { "/home"},
		initParams = {@WebInitParam(name = "home", value = "/EShop.jsp")}
		)
public class HomeServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//唱片服务类
		AlbumService serv = new AlbumService();
		//从数据库查询唱片
		List<Album> list = serv.loadAvailable();
		//将唱片列表设置到request中，用于在首页中显示
		RequestAttrHelper.setAlbum(request, list);
		next = this.getServletConfig().getInitParameter("home");
		forward(next,request, response);
	}

}
