package shopping.dao;



import shopping.bean.Cart;

public interface ICartDao {
	boolean save(int customerid, Cart cart);
	Cart load(int customerid);
	boolean insert(int customerid, Cart cart);
	boolean clearCart(int customerid);
}
