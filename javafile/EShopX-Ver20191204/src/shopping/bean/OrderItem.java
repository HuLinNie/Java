package shopping.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class OrderItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private Album album;
	private int quantity;
	private String orderId;
	public OrderItem(){
		
	}
	public OrderItem(long id,Album cd,int count)
	{
		this.id = id;
		this.album = cd;
		this.quantity = count;
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
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album cd) {
		this.album = cd;
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
	
}
