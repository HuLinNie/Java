
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dowhat")
@MultipartConfig // 涓嶉厤缃娉ㄨВ锛屾棤娉曡浆鍙�"multipart/form-data" 琛ㄥ崟鍐呭
public class ConctrollerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String what = request.getParameter("what");
		String clienttoken = request.getParameter("token");
		Object serverToken = request.getSession().getAttribute("token");

		String next = "/";
		switch (what) {
		case "index": // 杩斿洖棣栭〉
			next = "/";
			break;
		case "register_img": // 璇锋眰娉ㄥ唽鐨勮〃鍗�
			next = "/register2.jsp";// 璁剧疆琛ㄥ崟jsp椤甸潰锛屽皢杞彂琛ㄥ崟鍙戦�佸埌瀹㈡埛绔�
			break;
		case "doregister_img": // 鎻愪氦娉ㄥ唽鏁版嵁
			if (serverToken == null || clienttoken == null)
				break;
			if (clienttoken.compareToIgnoreCase((String) serverToken) != 0)
				break;
			next = "/register_img"; // 璁剧疆澶勭悊鏁版嵁鐨剆ervlet url 锛屽皢杞彂鏁版嵁鍒版servlet
			break;
		}
		String token = getToken();
		// 璁剧疆璇锋眰灞炴�oken锛屽湪璁剧疆浜唗oken鏍囪鐨勯〉闈笂璁剧疆鍊硷紝闃叉閲嶅鎻愪氦
		request.setAttribute("token", token);
		// 鏈嶅姟鍣ㄧtoken
		request.getSession().setAttribute("token", token);
		// 璇锋眰杞彂鐨勫埌椤甸潰銆佹垨瀹為檯澶勭悊鏁版嵁鐨剆ervlet
		request.getServletContext().getRequestDispatcher(next).forward(request, response);
	}

	private String getToken() {
		return UUID.randomUUID().toString().replace('-', '_');
	}
}
