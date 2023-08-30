package shopping.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shopping.bean.Album;
import shopping.bean.Customer;
import shopping.bean.Order;
import shopping.bean.OrderItem;
import shopping.dao.IOrderDao;
import shopping.dao.ShopDao;

public class OrderDaoImpl extends ShopDao implements IOrderDao {

	@Override
	public boolean insert(Order order) throws SQLException {
		if (order == null)
			return false;
		int r1 = 0;
		Connection conn = null;
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		try {
			conn = getConnection();
			String insertSql = "insert into order_(id,date,amount,customer_id) values(?,?,?,?)";
			String insert_items = "insert into order_item(count,order_id,album_id) values(?,?,?)";
			conn.setAutoCommit(false);
			st = conn.prepareStatement(insertSql);
			st1 = conn.prepareStatement(insert_items);
			String oid = order.getId();
			st.setString(1, oid);
			st.setObject(2, order.getDate());
			st.setDouble(3, order.getAmount());
			st.setInt(4, order.getCustomer().getId());
			
			int r = st.executeUpdate();
			for (int i = 0; i < order.getItems().size(); i++) {
				OrderItem item = order.getItems().get(i);
				st1.setInt(1, item.getQuantity());
				st1.setString(2, oid);
				st1.setInt(3, item.getAlbum().getId());
				r1 += st1.executeUpdate();
				st1.clearParameters();
			}
			
			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			ex.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
			if (st != null)
				st.close();
			if (st1 != null)
				st1.close();
			close(conn);
		}
		return r1 /* +r */ == order.getItems().size() /* +1 */ ; // order 插入 返回 1
	}

	@Override
	public boolean update(Order order) throws SQLException {
		if (order == null)
			return false;
		int r1 = 0;
		Connection conn = null;
		PreparedStatement st = null;
		PreparedStatement st_insert = null;
		PreparedStatement st_delete = null;
		try {
			conn = getConnection();
			String update_order = "update order_ set date=?,amount=?,customer_id=? where id=?";
			String delete_items = "delete from order_item where order_id=?";
			String insert_items = "insert into order_item(count,order_id,album_id) values(?,?,?)";
			
			conn.setAutoCommit(false);
			
			st = conn.prepareStatement(update_order);
			st_insert = conn.prepareStatement(insert_items);
			st_delete = conn.prepareStatement(delete_items);

			String oid = order.getId();
			st.setString(4, oid);
			st.setObject(1, order.getDate());
			st.setDouble(2, order.getAmount());
			st.setInt(3, order.getCustomer().getId());
			int r = st.executeUpdate();
			
			st_delete.setString(1, oid);
			int r2 = st_delete.executeUpdate(); // 删除原有记录

			//重新添加
			for (int i = 0; i < order.getItems().size(); i++) {
				OrderItem item = order.getItems().get(i);
				
				//st_insert.setLong(1, item.getId());
				st_insert.setInt(1, item.getQuantity());
				st_insert.setString(2, oid);
				st_insert.setInt(3, item.getAlbum().getId());
				r1 += st_insert.executeUpdate();
				st_insert.clearParameters();
			}

			conn.commit();
		} catch (SQLException ex) {
			conn.rollback();
			
			ex.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
			if (st != null)
				st.close();
			if (st_insert != null)
				st_insert.close();
			close(conn);
		}
		return r1 /* +r */ == order.getItems().size() /* +1 */ ; // order 插入 返回 1
	}

	@Override
	public boolean delete(String id) throws SQLException {

		Connection conn = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		try {
			conn = getConnection();
			String delete_order = "delete from order_ where id=?";
			String delete_items = "delete from order_item where order_id=?";

			//autoCommit = conn.getAutoCommit();

			conn.setAutoCommit(false);

			st2 = conn.prepareStatement(delete_items);
			st2.setString(1, id);
			int r2 = st2.executeUpdate();

			st = conn.prepareStatement(delete_order);
			st.setString(1, id);
			int r = st.executeUpdate();

			conn.commit();
			return r == 1; // 若order删除成功，则任务成功
			// conn.setAutoCommit(true);

		} catch (SQLException ex) {
			conn.rollback();
		} finally {
			conn.setAutoCommit(true);
			if (st != null)
				st.close();
			if (st2 != null)
				st2.close();
			close(conn);
		}
		return false;
	}

	@Override
	public Order load(String id) throws SQLException {
		Order o = null;
		
	
//		USE `web2019`;
//		DROP procedure IF EXISTS `load_order`;
//
//		DELIMITER $$
//		USE `web2019`$$
//		CREATE PROCEDURE `load_order` (in order_id varchar(32))
//		BEGIN
//			select order_.id as id,amount,date,customer_id,name,birthday,mail,phone,address from order_ left join customer on order_.customer_id=customer.id where order_.id=order_id;
//			select order_item.id,order_item.count,album.id as album_id,album.name,album.artist,album.country,album.price from order_item left join album on order_item.album_id=album.id where order_item.order_id=order_id;
//		END$$
//
//		DELIMITER ;
		
		Connection conn = null;
		CallableStatement st = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			st = conn.prepareCall("{call load_order(?)}");
			st.setString(1, id);
			if(st.execute())
			{
				o = new Order();
				Customer c = new Customer();
				List<OrderItem> items = new ArrayList<OrderItem>();
				rs = st.getResultSet();	//order
				while (rs.next()) {
					o.setId(rs.getString("id"));
					o.setAmount(rs.getFloat("amount"));
					o.setDate(rs.getTimestamp("date").toLocalDateTime());
					
					c.setId(rs.getInt("customer_id"));
					c.setName(rs.getString("name"));
					c.setBirthday(rs.getString("birthday"));
					c.setMail(rs.getString("mail"));
					c.setPhone(rs.getString("phone"));
					c.setAddress(rs.getString("address"));
					
					o.setCustomer(c);
				}
				if (st.getMoreResults()) { //orderitem
					rs = st.getResultSet();
					while(rs.next())
					{
						OrderItem item = new OrderItem();
						Album cd = new Album();
						item.setId(rs.getInt("id"));
						item.setQuantity(rs.getInt("count"));
						item.setOrderId(id);
						cd.setId(rs.getInt("album_id"));
						cd.setName(rs.getString("name"));
						cd.setArtist(rs.getString("artist"));
						cd.setCountry(rs.getString("country"));
						cd.setPrice(rs.getFloat("price"));
						
						item.setAlbum(cd);
						items.add(item);
					}
					o.setItems(items);
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(st,conn);
		}
		return o;
	}

	@Override

	
//	USE `web2019`;
//	DROP procedure IF EXISTS `load_orderByCustomer`;
//
//	DELIMITER $$
//	USE `web2019`$$
//	CREATE PROCEDURE `load_orderByCustomer` (in customer_id int)
//	BEGIN
//		select id,name,sex,birthday,address,mail,phone from customer where id=customer_id;
//		select id,amount,date from order_  where order_.customer_id=customer_id;
//	END$$
//
//	DELIMITER ;
	public List<Order> loadByCustomer(int customerid) throws SQLException {
		
		
		List<Order> orders = new ArrayList<Order>();
		
		Connection conn = null;
		CallableStatement st = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			st = conn.prepareCall("{call load_orderByCustomer(?)}");
			st.setInt(1, customerid);
			
			if(st.execute())
			{
				Customer c = new Customer();
				
				rs = st.getResultSet();	//order
				while (rs.next()) {
					
					c.setId(rs.getInt("id"));
					c.setName(rs.getString("name"));
					c.setBirthday(rs.getString("birthday"));
					c.setMail(rs.getString("mail"));
					c.setPhone(rs.getString("phone"));
					c.setAddress(rs.getString("address"));
					
				}
				if (st.getMoreResults()) { //orderitem
					rs = st.getResultSet();
					while(rs.next())
					{
						Order item = new Order();
						item.setId(rs.getString("id"));
						item.setAmount(rs.getDouble("amount"));
						item.setDate(rs.getTimestamp("date").toLocalDateTime());
						item.setCustomer(c);
						
						orders.add(item);
					}
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(st,conn);
		}
		return orders;
	}

}
