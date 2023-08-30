package web.service;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import web.bean.Customer;
import web.bean.Adminuser;

public class AuthHelper {
	
	public static final String customer_attr = "CUSTOMER_JSON";
	public static Customer getCustomerInfoBySession(HttpSession session) {
		if (session == null)
			return null;
		try {
			Object attr = session.getAttribute(customer_attr);
			if(attr==null)
				return null;
			String json = attr.toString();
			return JSON.parseObject(json, Customer.class);
		} catch (Exception ex) {
			//ex.printStackTrace();
		}
		return null;

	}

	public static void setCustomerInfo2Session(HttpSession session, Customer customer) {
		if (session == null || customer == null)
			return;
		session.setAttribute(customer_attr, JSON.toJSONString(customer));
	}
	
	public static void setAdminuserInfo2Session(HttpSession session, Adminuser adminuser) {
		if (session == null || adminuser == null)
			return;
		session.setAttribute(customer_attr, JSON.toJSONString(adminuser));
	}

	public static boolean isLogin(HttpSession session) {
		return null != getCustomerInfoBySession(session);
	}
}
