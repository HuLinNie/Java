package web.util;

import javax.servlet.http.HttpServletRequest;

public class BasePath {
	public static String get(HttpServletRequest request) {
		if (request == null)
			return "";
		StringBuilder sb = new StringBuilder();

		return sb.append(request.getScheme()).append("://").append(request.getServerName()).append(":")
				.append(request.getServerPort()).append(request.getContextPath()).append("/").toString();

	}
}