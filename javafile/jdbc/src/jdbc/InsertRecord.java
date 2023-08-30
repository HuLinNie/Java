package jdbc;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class InsertRecord {
//	private static IUserDao getUserDao() {
//		String dbUrl = "jdbc:mysql://localhost/eb1920";
//		Properties prop = new Properties();
//
//		prop.put("user", "root");
//		prop.put("password", "root");
//		prop.put("serverTimezone", "PRC"); // 设置时区
//		prop.put("useSSL", false); // 不使用SSL加密
//		IUserDao ud = new UserDao(dbUrl, prop);
//		return ud;
//	}
	public static void main( String[] args) {
		String url="jdbc:mysql://localhost:3306/eb1920?user=root&password=wnhl123&useSSL=false";
//		Properties prop = new Properties();
//		prop.put("user", "root");
//		prop.put("password", "wnhl123");
//		prop.put("serverTimezone", "PRC");
//		
//		prop.put("useSSL", false);
		
//		String query="create table eb1920.order(email varchar(80),orderid varchar(80),totalprice varchar(80),primary key(orderid), foreign key(email) references eb1920.user(email));";
//		String query1="insert into eb1920.order(email,orderid,totalprice)values('u001@neuq.edu.cn','123','120'); ";
		String query2="select email1,name,password,orderid,totalprice from eb1920.user,eb1920.order where user.email = order.email1;";
				
	try {		
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con =DriverManager.getConnection(url);
		Statement stmt=con.createStatement();
//		stmt.execute(query);
//		stmt.execute(query1);
//		stmt.execute(query2);
//		System.out.println(stmt.execute(query));
//		System.out.println(stmt.execute(query1));
//		System.out.println(stmt.execute(query2));
		ResultSet rs = stmt.executeQuery(query2);
		while(rs.next()) {
			String email1=rs.getString("email1");
			String password=rs.getString("password");
			String name=rs.getString("name");
			String orderid=rs.getString("orderid");
			String totalprice=rs.getString("totalprice");
			System.out.println("name:"+name);
			System.out.println("email1"+email1);
			System.out.println("password"+password);
			System.out.println("orderid"+orderid);
			System.out.println("totalprice"+totalprice);
		}
		rs.close();
		stmt.close();
		con.close();
	}
//		catch(SQLException ex) {}
		catch(java.lang.Exception ex) {ex.printStackTrace();}
		
	}
}