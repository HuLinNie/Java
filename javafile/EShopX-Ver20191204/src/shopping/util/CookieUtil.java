package shopping.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	public static Cookie findCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name))
			return (Cookie) cookieMap.get(name);
		return null;
	}

	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		try {
			Cookie cookie = new Cookie(name, value);
			cookie.setPath("/");
			if (maxAge >= 0)
				cookie.setMaxAge(maxAge);
			response.addCookie(cookie);
		} catch (Exception ex) {

		}
	}

	public static void removeCookie(HttpServletResponse response, String name) {
		addCookie(response, name, null, 0);
	}

}
