package eb;

import java.time.LocalDateTime;

public class User {
	private String email;
	private String name;
	private String password;
	private String memo;
	private LocalDateTime regDate;
	
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String toString() {
		return "{" + name + "," + email + "," + regDate.toString() + "," +  memo + "}";
	}
}
