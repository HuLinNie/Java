package neuq.eb.bean;

public class Student {
	private String id;
	private String name;
	private String password;
	private String email;
	private String photoPath;
	private String memo;
	private String localtion;
	private String birthday; // 使用yyyy-MM-dd 形式的字符串
	private String courses;
	// private int grade; //不能记录年级，类似年龄，应记录生日，此场景应记录入学日期
	private String registerDate;// 入学日期

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('{');

		builder.append(id).append(',')//id
				.append(name).append(',')//name
				.append(email).append(',')//email
				.append(birthday).append(',')//birthday
				.append(registerDate).append(',')//registerDate
				.append(courses).append(',')//course
				.append(localtion).append(',')//localtion
				.append(photoPath).append(',')//photo
				.append(memo);

		builder.append('}');
		return builder.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getLocaltion() {
		return localtion;
	}

	public void setLocaltion(String localtion) {
		this.localtion = localtion;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerYear) {
		this.registerDate = registerYear;
	}

}
