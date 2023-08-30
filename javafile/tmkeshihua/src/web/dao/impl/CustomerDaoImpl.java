package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.bean.Customer;
import web.dao.ICustomerDao;
import web.dao.ShopDao;

public class CustomerDaoImpl extends ShopDao implements ICustomerDao {

	@Override
	public boolean insert(Customer c) throws SQLException {
		Connection conn = getConnection();
		String insertSql = "insert into customer(name,phone,password,address) values(?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(insertSql);
		
		st.setString(1,c.getName());
		st.setString(2,c.getPhone());
		st.setString(3, c.getPassword());
		st.setString(4, c.getAddress());
		int r = st.executeUpdate();
		
		close(st,conn);
		return r==1;
	}

	@Override
	public boolean update(Customer c) throws SQLException {
		Connection conn = getConnection();
		String sql = "update customer set name=?,phone=?,password=? address=? where id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1,c.getName());
		st.setString(2,c.getPhone());
		st.setString(3, c.getPassword());
		st.setString(4, c.getAddress());
		st.setInt(5, c.getId());
		
		int r = st.executeUpdate();
		
		close(st,conn);
		return r==1;
	}

	@Override
	public List<Customer> query(String name) throws SQLException {
		Connection conn = getConnection();
		String sql = "Select id,name,phone from customer where name like ?";
		PreparedStatement st = conn.prepareStatement(sql);
		name = name==null?"":name;
		st.setString(1,name);
		
		
		ResultSet rs = st.executeQuery();
		List<Customer> clist = new ArrayList<Customer>();
		while(rs.next()){
			int id = rs.getInt("id");
			String _name = rs.getString("name");
			String phone = rs.getString("phone");
			
			Customer c = new Customer();
			c.setId(id);
			c.setName(_name);
			c.setPhone(phone);
			clist.add(c);
		}

		close(rs,st,conn);
		return clist;
	}

	@Override
	public void delete(int id) throws SQLException {
		Connection conn = getConnection();
		String sql = "delete from customer where id=?";
		PreparedStatement st = conn.prepareStatement(sql);

		st.setInt(1, id);
		
		int r = st.executeUpdate();
		
		close(st,conn);
	}

	@Override
	public Customer load(String name, String pwd) throws SQLException {
		Customer c = null;
		Connection conn = getConnection();
		String sql = "Select id,name,phone from customer where name=? and password=?"; //pwd=
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1,name);
		st.setString(2, pwd);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			int id = rs.getInt("id");
			String _name = rs.getString("name");
			
			String phone = rs.getString("phone");
			
			c = new Customer();
			c.setId(id);
			c.setName(_name);
			c.setPhone(phone);
			//System.out.println(c.toString());
		}

		close(rs,st,conn);
		return c;
	}
	public static void main(String[] args) throws SQLException {
		Customer c = new Customer();
		c.setName("test");
		c.setPhone("13930326545");
		ICustomerDao d = new CustomerDaoImpl();
		d.insert(c);
		
	}

	@Override
	public boolean update(String name) throws SQLException {
		Connection conn = getConnection();
		String sql = "update customer set mark=1 where name=?";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1,name);
		
		int r = st.executeUpdate();
		close(st,conn);
		return r==1;
	}

	@Override
	public String select(String name) throws SQLException {
		Connection conn = getConnection();
		String sql = "Select mark from customer where name=?"; 
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1,name);
		
		
		ResultSet rs = st.executeQuery();
		String mark =null;
		while(rs.next()){
			
			 mark = rs.getString("mark");
		}
		close(rs,st,conn);
		return mark;		
	}

	@Override
	public List<Customer> load() throws SQLException {
		Connection conn = getConnection();
		String sql = "Select id,name,phone,address from customer";
		PreparedStatement st = conn.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		List<Customer> clist = new ArrayList<Customer>();
		while(rs.next()){
			int id = rs.getInt("id");
			String _name = rs.getString("name");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			Customer c = new Customer();
			c.setId(id);
			c.setName(_name);
			c.setPhone(phone);
			c.setAddress(address);
			clist.add(c);
		}

		close(rs,st,conn);
		return clist;
	}
}
