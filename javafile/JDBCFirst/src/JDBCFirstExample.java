import java.sql.*;

//import java.util.Properties;
public class JDBCFirstExample {
	static final String JDBC_DRIVE = "com.mysql.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://localhost:3306/wxh?user=root&password=wnhl123&useSSL=false";
	public static void main(String []args) {
		Connection conn=null;
//		Statement stmt = null;
		try {
//			String sql = "Select * from wxh.student";
			String sql2 ="insert into wxh.student(sname,class) values(?,?);";
			
			Class.forName(JDBC_DRIVE).newInstance();
			conn = DriverManager.getConnection(DB_URL);
			PreparedStatement stmt1=conn.prepareStatement(sql2);
			stmt1.setString(1, "Ŷ");
			stmt1.setString(2, "12");
			
			boolean c=stmt1.execute();
			System.out.println(c);
//			ResultSet rs = stmt.executeQuery(sql);
//		
//			while(rs.next()) {
//				String sname =rs.getString(1);
//				String cla=rs.getString(2);
//			System.out.println("sname:"+sname);
//			System.out.println("class:"+cla);
//			}
//			rs.close();
//			
			stmt1.close();
			conn.close();
		}catch(SQLException se) {se.printStackTrace();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}

}
