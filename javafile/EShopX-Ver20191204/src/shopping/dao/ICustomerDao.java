package shopping.dao;

import java.sql.SQLException;
import java.util.List;

import shopping.bean.Customer;

public interface ICustomerDao {
	public boolean insert(Customer c) throws SQLException;
	public boolean update(Customer c) throws SQLException;
	public List<Customer> query(String name) throws SQLException;
	public void delete(int id) throws SQLException;
	public Customer load(String email, String pwd) throws SQLException;
}
