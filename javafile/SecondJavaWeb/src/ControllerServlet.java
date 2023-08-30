

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/dowhat")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String what = request.getParameter("what");
		String next = "/";
		switch (what) {
		case "index": // 鏉╂柨娲栨＃鏍��
			next = "/";
			break;
		case "register_image": // 鐠囬攱鐪板▔銊ュ斀閻ㄥ嫯銆冮崡锟�
			next = "/register.jsp";// 鐠佸墽鐤嗙悰銊ュ礋jsp妞ょ敻娼伴敍灞界殺鏉烆剙褰傜悰銊ュ礋閸欐垿锟戒礁鍩岀�广垺鍩涚粩锟�
			break;
		case "doregister_image":
			next = "/register_image"; // 鐠佸墽鐤嗘径鍕倞閺佺増宓侀惃鍓唀rvlet url 閿涘苯鐨㈡潪顒�褰傞弫鐗堝祦閸掔増顒漵ervlet
		break;
		}
	
		request.getServletContext().getRequestDispatcher(next).forward(request, response);
	}


}
