package web.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String phone;
	private String password;
	private String address;
	
	public String toJSON(){
		return JSON.toJSONString(this);
	}
	public static Customer NULL = new Customer() {
		private static final long serialVersionUID = -7275126538204560558L;
		{
			super.id = -1;
			super.name = "";
			super.phone = "";
			super.password = "";
			super.address="";
			
		}
	};
	public String toString(){
		return "Customer["
				+ this.id
				+"," + this.name
				+"," + this.phone+this.address
				+ "]";
	}
	
	//private ArrayList<Order> orders;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setName(String name) {
		this.name = name;
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
