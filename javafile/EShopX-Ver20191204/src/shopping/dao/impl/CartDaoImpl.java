package shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alibaba.fastjson.JSON;

import shopping.bean.Cart;
import shopping.dao.ICartDao;
import shopping.dao.ShopDao;

public class CartDaoImpl extends ShopDao implements ICartDao {

	@Override
	public boolean save(int customerid, Cart cart) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = getConnection();

			st = conn.prepareStatement("update cart set cart=? where userid=?");
			st.setString(1, cart.toJSON());
			st.setInt(2, customerid);

			int r = st.executeUpdate();

			return r == 1;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(st,conn);
		}
		return false;
	}

	@Override
	public boolean insert(int customerid, Cart cart) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = getConnection();

			st = conn.prepareStatement("insert into cart(userid,cart) values(?,?)");
			st.setInt(1, customerid);
			st.setString(2, cart.toJSON());

			int r = st.executeUpdate();

			return r == 1;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(st,conn);
		}
		return false;
	}
	
	@Override
	public Cart load(int customerid) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Cart cart = null;
		try {
			conn = getConnection();

			st = conn.prepareStatement("select cart from cart where userid=?");
			st.setInt(1, customerid);

			rs = st.executeQuery();
			if (rs.next()) {
				String json = rs.getString(1);
				cart = JSON.parseObject(json, Cart.class);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			close(rs,st,conn);
		}
		return cart;
	}

	@Override
	public boolean clearCart(int customerid) {
		Cart cart = new Cart();
		return this.save(customerid, cart);
		
	}

}
