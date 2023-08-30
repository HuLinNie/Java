package web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ShopDao {
	protected static String user = "root";
	protected static String pw = "wnhl123";
	protected static String connStr = "jdbc:mysql://localhost/web2020?useSSL=false&serverTimezone=PRC&useUnicode&characterEncoding=UTF-8";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected Connection getConnection() throws SQLException {

		//return DriverManager.getConnection(connStr, user, pw);
		Context ctx;
		try {
			ctx = new InitialContext ();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/web2020") ;
			
			Connection conn=ds.getConnection() ;
			
			return conn;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void close(ResultSet rs, Statement st, Connection connection) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (connection != null)
				connection.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void close(Statement st, Connection connection) {
		close(null, st, connection);
	}

	public void close(Connection connection) {
		close(null, null, connection);
	}
}
