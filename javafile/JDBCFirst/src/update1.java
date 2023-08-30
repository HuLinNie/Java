import java.sql.*;
public class update1 {
	public static   void main(String [] args) {
		String jurl="jdbc:mysql://localhost:3306/wxh?user=root&password=wnhl123&useSSL=false";
		String sql= "insert into wxh.student(sname,class)values('ºç','wedsdf')";
		try (Connection con=DriverManager.getConnection(jurl);
			Statement stmt = con.createStatement();
			){
		stmt.executeUpdate(sql);
			System.out.println(stmt.executeUpdate(sql));
			stmt.close();
			con.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally { 
			System.out.println("insert into table successed!");
		}
		String sql1= "select * from wxh.student";
		try {Connection con=DriverManager.getConnection(jurl);
				Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql1);
				while(rs.next()) {
					String name=rs.getString("sname");
					String clas=rs.getString("class");
					System.out.println("name:"+name);
					System.out.println("class"+clas);
				}
				rs.close();
				stmt.close();
				con.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				System.out.println("select table successed!");
			}
		 String url2="jdbc:mysql://localhost:3306/eb1920?user=root&password=wnhl123&useSSL=false";
		 String sql2="select * from eb1920.user";
		try {Connection conn=DriverManager.getConnection(url2);
		Statement stm=conn.createStatement();
		ResultSet st=stm.executeQuery(sql2);
		while(st.next()) {
			String email = st.getString("email");
			String name = st.getString("name");
			String password = st.getString("password");
			String memo= st.getString("memo");
			Date regdate= st.getDate("regdate");
			System.out.println("email:"+email);
			System.out.println("name:"+name);
			System.out.println("password:"+password);
			System.out.println("memo:"+memo);
			System.out.println("regdate:"+regdate);			
		}
		
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		String url3="jdbc:mysql://localhost:3306?user=root&password=wnhl123&useSSL=false";
		String sql3="insert into eb1920.user(email,name,password,memo,regdate)values('hj¼ÇºÅ¼ÇºÅgh@neup.edu.cn','nhl','dgs','dfa','2018-10-24 20:58:25')";
		try {
			Connection connn=DriverManager.getConnection(url3);
			PreparedStatement stm=connn.prepareStatement(sql3);
			System.out.println(stm.executeUpdate());
		}catch(SQLException e) {
			e.printStackTrace();
		}
//		 String url4="jdbc:mysql://localhost:3306/eb1920?user=root&password=wnhl123&useSSL=false";
//		 String sql4="select * from eb1920.user";
		try {Connection conn=DriverManager.getConnection(url2);
		Statement stm=conn.createStatement();
		ResultSet st=stm.executeQuery(sql2);
		while(st.next()) {
			String email = st.getString("email");
			String name = st.getString("name");
			String password = st.getString("password");
			String memo= st.getString("memo");
			Date regdate= st.getDate("regdate");
			System.out.println("email:"+email);
			System.out.println("name:"+name);
			System.out.println("password:"+password);
			System.out.println("memo:"+memo);
			System.out.println("regdate:"+regdate);			
		}	
		}catch(SQLException e) {
		e.printStackTrace();	
		}

	}

}


    
