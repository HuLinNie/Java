package shopping.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	List<OrderItem> items = new ArrayList<OrderItem>();
	
	public static Cart NULL = new Cart() {
		private static final long serialVersionUID = -5021679523389041273L;
	};
	
	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public String toJSON() {
		return JSON.toJSONString(this);
	}

	public static Cart FromJSON(String json) {
		return JSON.parseObject(json, Cart.class);
	}

	public void add(OrderItem item) {
		if (item == null)
			return;
		int idx = find(item);
		if (idx < 0)
			this.items.add(item);
		else {
			OrderItem item1 = items.get(idx);
			int count = item1.getQuantity() + item.getQuantity();
			item1.setQuantity(count);
			items.set(idx, item1);
		}
	}

	public void remove(OrderItem item) {
		remove(find(item));
	}

	public void remove(int idx) {
		if (idx >= 0 && idx < items.size())
			items.remove(idx);
	}

	public void update(List<OrderItem> items) {
		this.items.clear();
		this.items.addAll(items);
	}

	public int find(OrderItem item) {
		Album cd = item.getAlbum();
		if (cd == null)
			return -1;
		int id = cd.getId();
		for (int i = 0; i < this.items.size(); i++) {
			if (this.items.get(i).getAlbum().getId()==id) {
				return i;
			}
		}
		return -1;
	}
	public int findByName(OrderItem item) {
		Album cd = item.getAlbum();
		if (cd == null)
			return -1;
		String album = cd.getName();
		for (int i = 0; i < this.items.size(); i++) {
			if (this.items.get(i).getAlbum().getName().equals(album)) {
				return i;
			}
		}
		return -1;
	}

	public void clear() {
		this.items.clear();
	}

	public float getAmount() {
		float total = 0;
		for (int i = 0; i < items.size(); i++) {
			OrderItem item = items.get(i);
			Album cd = item.getAlbum();
			if (cd != null) {
				double price = item.getAlbum().getPrice();
				int qty = item.getQuantity();
				total += (price * qty);
			}
		}
		total += 0.005;
		return total;
	}
}
