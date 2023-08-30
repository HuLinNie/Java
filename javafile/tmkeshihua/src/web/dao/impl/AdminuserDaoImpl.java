package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import web.dao.ShopDao;
import web.bean.Adminuser;
import web.bean.Customer;
import web.dao.IAdminuserDao;

public class AdminuserDaoImpl extends ShopDao implements IAdminuserDao {

	@Override
	public Adminuser load(String name, String pwd) throws SQLException {
		Adminuser c = null;
		Connection conn = getConnection();
		String sql = "Select adid,username,phone from adminuser where username=? and password=?"; //pwd=
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1,name);
		st.setString(2, pwd);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			int id = rs.getInt("adid");
			String _name = rs.getString("username");
			
			String phone = rs.getString("phone");
			
			c = new Adminuser();
			c.setId(id);
			c.setName(_name);
			c.setPhone(phone);
			//System.out.println(c.toString());
		}

		close(rs,st,conn);
		return c;
		
	}

	@Override
	public boolean insert(Adminuser c) throws SQLException {
		Connection conn = getConnection();
		String insertSql = "insert into adminuser(username,phone,password) values(?,?,?)";
		PreparedStatement st = conn.prepareStatement(insertSql);
		
		st.setString(1,c.getName());
		st.setString(2,c.getPhone());
		st.setString(3, c.getPassword());
		int r = st.executeUpdate();
		
		close(st,conn);
		return r==1;
		
	}

}
