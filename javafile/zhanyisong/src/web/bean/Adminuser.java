package web.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class Adminuser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int adid;
	private String username;
	private String phone;
	private String password;
	
	public String toJSON(){
		return JSON.toJSONString(this);
	}
	public static Adminuser NULL = new Adminuser() {
		private static final long serialVersionUID = -7275126538204560558L;
		{
			super.adid = -1;
			super.username = "";
			super.phone = "";
			super.password = "";
			
		}
	};
	public String toString(){
		return "Adminuser["
				+ this.adid
				+"," + this.username
				+"," + this.phone
				+ "]";
	}
	
	//private ArrayList<Order> orders;
	public int getId() {
		return adid;
	}
	public void setId(int adid) {
		this.adid = adid;
	}
	public String getName() {
		return username;
	}
	public void setName(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String pwd) {
		this.password = pwd;		
	}
}
