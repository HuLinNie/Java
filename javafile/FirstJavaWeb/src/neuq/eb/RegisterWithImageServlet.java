package neuq.eb;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import neuq.eb.bean.Student;

/**
 * Servlet implementation class RegisterWithImageServlet
 */
// 搴旈槻姝㈢洿鎺ヨ闂Servlet
// 姝ｅ紡椤圭洰璁块棶鏉冮檺璁剧疆搴斾娇鐢ㄦ嫤鎴櫒锛堣繃婊ゅ櫒绛夛級瀹炵幇
@WebServlet(
	urlPatterns = { "/register_img" }, 
	initParams = { @WebInitParam(name = "photoPath", value = "\\img\\photo"),
		@WebInitParam(name = "tmpPath", value = "\\tmp"),
		@WebInitParam(name = "nextUrl", value = "/register-info.jsp") })
@MultipartConfig
public class RegisterWithImageServlet extends HttpServlet {
	private String photoPath;
	private String tmpPath;
	private String nextUrl;

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.photoPath = config.getInitParameter("photoPath");
		this.tmpPath = config.getInitParameter("tmpPath");
		this.nextUrl = config.getInitParameter("nextUrl");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("utf-8");
		
		String filename = getFile(request, "file_pic");
		String id = request.getParameter("stuId");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String bthday = request.getParameter("bthday");
		String email = request.getParameter("email");
		String registerDate = request.getParameter("registerDate");
		String[] course = request.getParameterValues("course");

		String localtion = request.getParameter("location");
		String memo = request.getParameter("memo");
		/************************************************************/
		/************************************************************/
		//鏋勯�爏tudent
		Student st = new Student();
		st.setId(id);
		st.setName(name);
		st.setPassword(pwd);
		st.setEmail(email);
		st.setBirthday(bthday);
		st.setRegisterDate(registerDate);
		st.setMemo(memo);
		st.setPhotoPath(filename);
		st.setLocaltion(localtion);
		
		StringBuilder builder = new StringBuilder();
		if (course != null) {
			for (String c : course)
				builder.append(c).append(",");
		}
		builder.deleteCharAt(builder.length()-1);
		st.setCourses(builder.toString());
		//瀛樺叆鏁版嵁搴�
		//鈥︹��
		
		// 
		//璁剧疆request浣滅敤鍩熷弬鏁�,灏嗗緱鍒扮殑鏁版嵁锛堝瓨鍏ユ暟鎹簱鏄惁鎴愬姛锛夎浆鍙戝埌register-info.jsp椤甸潰锛屽搷搴旂粰鐢ㄦ埛
		request.setAttribute("reg_msg", st.toString());
		//杞彂
		request.getServletContext().getRequestDispatcher(nextUrl).forward(request, response);

	}

	private String getFile(HttpServletRequest request, String name) throws IOException, ServletException {
		// 鑾峰彇Part瀵硅薄锛堝寘鍚枃浠舵暟鎹級
		Part part = request.getPart(name);
		if (part != null) {
			// 寰楀埌缃戠珯/tmp璺緞鐨勭湡瀹炵墿鐞嗚矾寰�
			// String uploadPath = request.getServletContext().getRealPath("/tmp");
			String uploadPath = request.getServletContext().getRealPath(tmpPath);
			// 浠ラ殢鏈篣UID涓庝笂浼犳枃浠剁殑鏂囦欢鍚嶏紝鐢熸垚鏂扮殑闅忔満鏂囦欢鍚�
			String shortname = UUID.randomUUID().toString() + part.getSubmittedFileName();
			// 鐢熸垚瀛樻斁鏂囦欢鐨勫畬鏁磋矾寰勪笌鏂囦欢鍚�
			String fileName = uploadPath + File.separatorChar + shortname;
			// 鍐欏叆鏂囦欢鏁版嵁
			part.write(fileName);
			return shortname;
		}
		return "";
	}
}
