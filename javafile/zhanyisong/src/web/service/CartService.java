package web.service;

import java.util.List;


import web.bean.Cart;
import web.bean.OrderItem;
import web.dao.ICartDao;
import web.dao.impl.CartDaoImpl;

public class CartService {
	private int customerId;
	private Cart cart;
	private ICartDao cartDao;

	public CartService(int customer_id) {
		this.customerId = customer_id;
		this.cartDao = new CartDaoImpl();
		
		Cart cart = cartDao.load(customer_id);
		if(cart==null){
			cart = new Cart();
			cartDao.insert(customer_id, cart);
		}
		this.cart= cart;
	}
	
	public boolean setItems(List<OrderItem> items) {
		if (items == null)
			return true;
		cart.setItems(items);
		return cartDao.save(customerId, cart);
	}

	public boolean addItem(OrderItem item) {
		if (item == null)
			return true;
		cart.add(item);
		return cartDao.save(customerId, cart);
	}

	public boolean removeItem(OrderItem item) {
		if (item == null)
			return true;
		cart.remove(item);
		return cartDao.save(customerId, cart);
	}

	public boolean removeItemAt(int idx) {
		cart.remove(idx);
		return cartDao.save(customerId, cart);
	}

	public boolean clear() {
		cart.clear();
		return cartDao.clearCart(customerId);
	}
	
	public float getAmount() {
		return cart.getAmount();
	}
	

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public ICartDao getCartDao() {
		return cartDao;
	}
	public void setCartDao(ICartDao cartDao) {
		this.cartDao = cartDao;
	}
	
}
