package shopping.dao;

import java.sql.SQLException;
import java.util.List;

import shopping.bean.Order;

public interface IOrderDao {
	public boolean insert(Order o) throws SQLException;
	public boolean update(Order o) throws SQLException;
	public boolean delete(String id)  throws SQLException;
	public Order load(String id)  throws SQLException;
	/**
	 * 返回order中的内容，其他细节不加载，用于用户浏览（不涉及明细内容）
	 * @param userid
	 * @return
	 * @throws SQLException
	 */
	public List<Order> loadByCustomer(int customerid)  throws SQLException;
}
