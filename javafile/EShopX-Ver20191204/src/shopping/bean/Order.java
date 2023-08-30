package shopping.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import shopping.util.UUIDHelper;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;

	public Order() {
		id = UUIDHelper.generateShortString();
		date =  LocalDateTime.now();//,"yyyy-MM-dd hh:mm:ss");
		items = new ArrayList<OrderItem>();
	}
	public static Order NULL= new Order() {
		private static final long serialVersionUID = -1550628597715925577L;
		{
			super.id = UUIDHelper.generateShortString();
			super.date =  LocalDateTime.now();
			super.items = new ArrayList<OrderItem>(0);
			super.amount = 0;
			super.customer=null;
		}
	};
	private String id;

	/**
	 * 订单提交时间，系统自动记录
	 */
	private LocalDateTime date;

	/**
	 * 订单所有者
	 */
	private Customer customer;

	private double amount;

	private List<OrderItem> items = null;

	public String toString() {
		return JSON.toJSONString(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		if (items == null)
			this.items.clear();

		this.items = items;
	}
	public void add(List<OrderItem> items) {
		this.items.addAll(items);
	}

	public void add(OrderItem item) {
		this.items.add(item);
	}

	public void remove(OrderItem item) {
		this.items.remove(item);
	}

	public void remove(int pos) {
		this.items.remove(pos);
	}

	public OrderItem getItem(int idx) {
		if (idx >= 0 && idx <= items.size())
			return items.get(idx);
		return null;
	}

	public void setItem(int idx, OrderItem item) {
		if (idx >= 0 && idx <= items.size())
			items.set(idx, item);
	}
}
