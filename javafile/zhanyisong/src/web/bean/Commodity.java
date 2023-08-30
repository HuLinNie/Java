package web.bean;

import java.io.Serializable;
import java.util.StringTokenizer;

import com.alibaba.fastjson.JSON;

public class Commodity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Commodity NULL;
	private int id;
	private String name; // 涓撹緫銆佸敱鐗�
	private String image;
	private double price;

	public Commodity() {
		id = -1;
		name = "";
		image = "";
		price = 0;
	}

	public Commodity(int id, String name, String image, double price) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String title) {
		name = title;
	}

	public String getName() {
		return name;
	}

	public void setImage(String group) {
		image = group;
	}

	public String getImage() {
		return image;
	}


	public void setPrice(double p) {
		price = p;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return JSON.toJSONString(this);
	}
	public String toStringWithoutID() {
		//鏋勯�犳柟娉曠殑瀛楃鏍煎紡杩欓噷濡傛灉灏忔暟涓嶈冻2浣�,浼氫互0琛ヨ冻.
		java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat(".00");
		String strprice = decimalFormat.format(price);
		return name + " | " + image + " | "  + " | " + strprice;
	}

	public static Commodity valueOf(String myCd, String split) {
		StringTokenizer t = new StringTokenizer(myCd, split);
		String name = t.nextToken();
		String image = t.nextToken();
	
		String price = t.nextToken();
		price = price.replace('￥',' ').trim();

		Commodity cd = new Commodity();
		cd.setName(name);
		cd.setImage(image);
		
		cd.setPrice(Float.parseFloat(price));

		return cd;
	}
}
