package web.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class OrderItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private Commodity commodity;
	private int userid;
	private int quantity;
	private String orderId;
	private Cart cart;
	
	public OrderItem(){
		
	}
	public OrderItem(long id,Commodity cd,int count)
	{
		this.id = id;
		this.commodity = cd;
		this.quantity = count;
	}
	
	public OrderItem(int userid,String orderid,Cart cart) {
		this.userid=userid;
		this.orderId = orderid;
		this.cart = cart;
	}
	
	public String toString()
	{
		return JSON.toJSONString(this);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity cd) {
		this.commodity = cd;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int count) {
		this.quantity = count;
	}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public void setUserId(int userid) {
		this.userid = userid;	
	}
	public int getUserId() {	
		return userid;
	}
	public void setCart(Cart cart) {
		this.cart = cart;	
	}
	
	public Cart getCart() {
		return cart;
	}
	
	
}
