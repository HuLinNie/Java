package entity;

public class Login {
	private String name;
	private String pwd;
	
	public Login(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	public String getUname() {
		return name;
	}
	public void setUname(String name) {
		this.name = name;
	}
	public String getUpwd() {
		return pwd;
	}
	public void setUpwd(String pwd) {
		this.pwd = pwd;
	}
}
