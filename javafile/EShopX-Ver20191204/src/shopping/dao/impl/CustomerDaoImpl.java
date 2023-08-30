package shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shopping.bean.Customer;
import shopping.dao.ICustomerDao;
import shopping.dao.ShopDao;

public class CustomerDaoImpl extends ShopDao implements ICustomerDao {

	@Override
	public boolean insert(Customer c) throws SQLException {
		Connection conn = getConnection();
		String insertSql = "insert into customer(name,birthday,address,mail,phone,password) values(?,?,?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(insertSql);
		
		st.setString(1,c.getName());
		st.setString(2,c.getBirthday());
		st.setString(3,c.getAddress());
		st.setString(4,c.getMail());
		st.setString(5,c.getPhone());
		st.setString(6, c.getPassword());
		int r = st.executeUpdate();
		
		close(st,conn);
		return r==1;
	}

	@Override
	public boolean update(Customer c) throws SQLException {
		Connection conn = getConnection();
		String sql = "update customer set name=?,birthday=?,address=?,mail=?,phone=?,password=? where id=?";
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1,c.getName());
		st.setString(2,c.getBirthday());
		st.setString(3,c.getAddress());
		st.setString(4,c.getMail());
		st.setString(5,c.getPhone());
		st.setString(6, c.getPassword());
		st.setInt(7, c.getId());
		
		int r = st.executeUpdate();
		
		close(st,conn);
		return r==1;
	}

	@Override
	public List<Customer> query(String name) throws SQLException {
		Connection conn = getConnection();
		String sql = "Select id,name,birthday,address,mail,phone from customer where name like ?";
		PreparedStatement st = conn.prepareStatement(sql);
		name = name==null?"":name;
		st.setString(1,name);
		
		
		ResultSet rs = st.executeQuery();
		List<Customer> clist = new ArrayList<Customer>();
		while(rs.next()){
			int id = rs.getInt("id");
			String _name = rs.getString("name");
			String birthday = rs.getString("birthday");
			String address = rs.getString("address");
			String mail = rs.getString("mail");
			String phone = rs.getString("phone");
			
			Customer c = new Customer();
			c.setId(id);
			c.setName(_name);
			c.setBirthday(birthday);
			c.setAddress(address);
			c.setMail(mail);
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
	public Customer load(String email, String pwd) throws SQLException {
		Customer c = null;
		Connection conn = getConnection();
		String sql = "Select id,name,birthday,address,mail,phone from customer where mail=? and password=?"; //pwd=
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1,email);
		st.setString(2, pwd);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			int id = rs.getInt("id");
			String _name = rs.getString("name");
			String birthday = rs.getString("birthday");
			String address = rs.getString("address");
			String mail = rs.getString("mail");
			String phone = rs.getString("phone");
			
			c = new Customer();
			c.setId(id);
			c.setName(_name);
			c.setBirthday(birthday);
			c.setAddress(address);
			c.setMail(mail);
			c.setPhone(phone);
			//System.out.println(c.toString());
		}

		close(rs,st,conn);
		return c;
	}
	public static void main(String[] args) throws SQLException {
		Customer c = new Customer();
		c.setName("test");
		c.setMail("gaojiao@sohu.com");
		c.setPhone("13930326545");
		c.setAddress("ÇØ»Êµº");
		c.setBirthday("2019-09-09");
		ICustomerDao d = new CustomerDaoImpl();
		d.insert(c);
		
	}
}
