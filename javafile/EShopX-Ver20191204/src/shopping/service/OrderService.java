package shopping.service;

import java.sql.SQLException;

import shopping.bean.Cart;
import shopping.bean.Customer;
import shopping.bean.Order;
import shopping.dao.ICartDao;
import shopping.dao.ICustomerDao;
import shopping.dao.IOrderDao;
import shopping.dao.impl.CartDaoImpl;
import shopping.dao.impl.CustomerDaoImpl;
import shopping.dao.impl.OrderDaoImpl;

public class OrderService {
	ICartDao cdao = null;
	IOrderDao odao = null;
	ICustomerDao customerdao = null;

	public OrderService() {
		cdao = new CartDaoImpl();
		odao = new OrderDaoImpl();
		customerdao = new CustomerDaoImpl();
	}

	public String CreateOrder(Customer c) {
		try {
			if (c == null)
				return "";
			Cart cart = cdao.load(c.getId());
			if (cart == null || cart.getItems().size() == 0)
				return "";

			Order order = new Order();
			order.setCustomer(c);
			order.add(cart.getItems());
			order.setAmount(cart.getAmount());
			
			if(odao.insert(order))//应采用事务，不可中断
			{
				cdao.clearCart(c.getId());
			}
			else
			{
				System.out.println("insert order failure!!!");
			}
			return order.getId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	public Order load(String orderid) {
		try {
			return odao.load(orderid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
