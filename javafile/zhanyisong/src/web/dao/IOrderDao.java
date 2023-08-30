package web.dao;

import java.sql.SQLException;
import java.util.List;

import web.bean.Cart;
import web.bean.Order;
import web.bean.OrderItem;

public interface IOrderDao {
	public boolean insert(Order o) throws SQLException;
	public boolean update(Order o) throws SQLException;
	public boolean delete(String id)  throws SQLException;
	public Order load(String id)  throws SQLException;
	public List<Order> load()  throws SQLException;
	public Order select(String oid)  throws SQLException;
	public List<Order> loadByCustomer(int customerid)  throws SQLException;
	public boolean inser(OrderItem ot) throws SQLException;
	public Cart load1(String oid) throws SQLException;
}
