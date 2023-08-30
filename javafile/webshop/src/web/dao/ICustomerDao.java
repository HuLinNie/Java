package web.dao;

import java.sql.SQLException;
import java.util.List;

import web.bean.Customer;

public interface ICustomerDao {
	public boolean insert(Customer c) throws SQLException;
	public boolean update(Customer c) throws SQLException;
	public List<Customer> query(String name) throws SQLException;
	public void delete(int id) throws SQLException;
	public Customer load(String name, String pwd) throws SQLException;
	public boolean update(String name) throws SQLException;
	public String select (String name) throws SQLException;
}
