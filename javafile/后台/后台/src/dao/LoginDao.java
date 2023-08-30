package dao;

import java.sql.*;

import entity.Login;

public class LoginDao {
	public static int login(Login login) {		
		final String URL = "jdbc:mysql://localhost:3306/web20?useSSL=false&serverTimezone=PRC";
		final String USERNAME = "root";
		final String PWD = "";
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			//导入驱动，加载驱动类
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			stmt = connection.createStatement();
			String name = login.getUname();
			String pwd = login.getUpwd();
			String sql = "select count(*) from login where name='"+name+"' and pwd='"+pwd+"'";
			
//			pstmt.setString(1, login.getUname());
//			pstmt.setString(2, login.getUpwd());	
			rs = stmt.executeQuery(sql);
			int count = -1;			
			if(rs.next()){
				count = rs.getInt(1);
			}
			if(count>0){
				return 1;
			}else {
				return 0;
			}			
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			return -1;
		}catch (SQLException e){
			e.printStackTrace();
			return -1;
		}catch (Exception e){
			e.printStackTrace();
			return -1;
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(connection!=null) connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
