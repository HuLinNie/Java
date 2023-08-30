package shopping.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String birthday;
	private String address;
	private String mail;
	private String phone;
	private String password;
	public String toJSON(){
		return JSON.toJSONString(this);
	}
	public static Customer NULL = new Customer() {
		private static final long serialVersionUID = -7275126538204560558L;
		{
			super.id = -1;
			super.name = "";
			super.birthday = "1970-01-01";
			super.address = "";
			super.mail = "";
			super.phone = "";
			super.password = "";
		}
	};
	public String toString(){
		return "Customer["
				+ this.id
				+"," + this.name
				+"," + this.birthday
				+"," + this.address
				+"," + this.mail
				+"," + this.phone
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
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
