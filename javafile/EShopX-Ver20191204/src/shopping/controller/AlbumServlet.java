package shopping.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.bean.Album;
import shopping.service.AlbumService;

@WebServlet(
		urlPatterns = { "/Album"},
		initParams = { 
				@WebInitParam(name = "show", value = "/jsp/Album.jsp"),
				@WebInitParam(name = "add", value = "/home"),
				@WebInitParam(name = "edit", value = "/home"),
				@WebInitParam(name = "save", value = "/home"),
				@WebInitParam(name = "delete", value = "/home"),
				@WebInitParam(name = "list", value = "/home")
			}
		)
public class AlbumServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action= getParameter(request,"action");
		next = "/home";
		switch(action) {
		case "show":
			String albumid = request.getParameter("id");
			try {
				int id = Integer.parseInt(albumid);
				AlbumService serv = new AlbumService();
				Album cd = serv.load(id);
				request.setAttribute("album", cd);
				
				//next = "/jsp/Album.jsp";
				next = this.getServletConfig().getInitParameter("show");
			} catch (NumberFormatException ex) {
	
			}
			break;
		case "add"://鍑嗗娣诲姞鍞辩墖锛実et娣诲姞鍞辩墖琛ㄥ崟
			break;
		case "edit"://鍑嗗缂栬緫鍞辩墖淇℃伅锛実et缂栬緫鍞辩墖琛ㄥ崟锛堜笌add鍏辩敤琛ㄥ崟锛岃〃鍗曚腑缁勪欢缃叆瑕佺紪杈戝敱鐗囩殑淇℃伅锛�
			break;
		case "save"://鎻愪氦鍞辩墖鏁版嵁锛堝搴攁dd涓巈dit鍚庣殑鏁版嵁淇濆瓨锛夛紝瀛樺叆绯荤粺
			break;
			
		case "list"://鏄剧ず鍞辩墖鍒楄〃锛屽噯澶囦笅涓�姝ユ搷浣滐紙鍒犻櫎銆佺紪杈戯級;
			break;
		case "delete":
			break;
		
		}
		this.forward(next, request, response);
	}
}
