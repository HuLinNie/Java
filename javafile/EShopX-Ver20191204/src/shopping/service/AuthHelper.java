package shopping.service;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import shopping.bean.Customer;

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

	public static boolean isLogin(HttpSession session) {
		return null != getCustomerInfoBySession(session);
	}
}
