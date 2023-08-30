package eb;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

public class DaoTest {

	private static IUserDao getUserDao() {
		String dbUrl = "jdbc:mysql://localhost/eb1920?user=root&password=wnhl123&useSSL=false";
//		Properties prop = new Properties();
//
//		prop.put("user", "root");
//		prop.put("password", "wnhl123");
//		prop.put("serverTimezone", "PRC"); // 设置时区
//		prop.put("useSSL", false); // 不使用SSL加密
		IUserDao ud = new UserDao(dbUrl);
		return ud;
	}

	
	public static void main(String[] args) throws SQLException {
		
		IUserDao ud = getUserDao();

		User user = new User();
		user.setEmail("u001@neuq.edu.cn");
		user.setName("uTest");
		user.setPassword("u001");
		user.setMemo("u001@testinfo");
//		user.setRegDate(2017-11-24);
////		
		boolean isExist = ud.isExist("u001@neuq.edu.cn");
		if(!isExist)
			ud.insert(user);
		else {
			System.out.println("u001 exist: "+isExist);
		}
//////		
//		User u = ud.Load("u001@neuq.edu.cn");
//		if(u!=null)
//		{	
//			System.out.println(u.toString());
//			u.setName("uTest001");
//			ud.update(u);
//		}
//		ud.delete("u001@neuq.edu.cn");
//		
//		if(null == ud.Load("u001@sohu.com"))
//			System.out.println("Deleted");
//		else
//			System.out.println(u.toString());
//		
//		
//		
		List<User> ul = new Vector<User>(10);
		for (int i = 0; i < 10; i++) {
			ul.add(UserCreator.generateUser());
		}
		System.out.println(ud.insert(ul));

	}



}
