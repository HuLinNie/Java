package web.controller.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import web.util.UUIDHelper;

public class FormSubmitHelper {
	public static String TOKEN = "Submit_Token";
	
	public static boolean isReSubmit(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session==null)
			return false;
		String rToken = request.getParameter(TOKEN);
		if(rToken==null)
			return false;
		
		String sToken = getAttributeStringValue(session,TOKEN);
		
		//System.out.println("session Token="+sToken + ",request Token="+rToken);
		
		if(sToken.compareToIgnoreCase(rToken)==0)
			return false;
		return true;
	}

	private static String getAttributeStringValue(HttpSession session,String key) {
		Object obj = session.getAttribute(key);
		session.removeAttribute(key);
		return obj == null ? "" : (String) obj;
	}
	
	public static String generateToken(HttpSession session)
	{
		String token = UUIDHelper.generateShortString();
		if(session!=null)
		{
			session.setAttribute(TOKEN, token);
		}
		return token;
	}

}
