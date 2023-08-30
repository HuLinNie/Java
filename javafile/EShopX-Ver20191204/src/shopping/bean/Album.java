package shopping.bean;

import java.io.Serializable;
import java.util.StringTokenizer;

import com.alibaba.fastjson.JSON;

public class Album implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name; // 涓撹緫銆佸敱鐗�
	private String artist;
	private String country;
	private double price;

	public Album() {
		id = -1;
		name = "";
		artist = "";
		country = "";
		price = 0;
	}

	public Album(int id, String album, String artist, String country, double price) {
		this.id = id;
		this.name = album;
		this.artist = artist;
		this.country = country;
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

	public void setArtist(String group) {
		artist = group;
	}

	public String getArtist() {
		return artist;
	}

	public void setCountry(String cty) {
		country = cty;
	}

	public String getCountry() {
		return country;
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
		return name + " | " + artist + " | " + country + " | " + strprice;
	}

	public static Album valueOf(String myCd, String split) {
		StringTokenizer t = new StringTokenizer(myCd, split);
		String album = t.nextToken();
		String artist = t.nextToken();
		String country = t.nextToken();
		String price = t.nextToken();
		price = price.replace('￥',' ').trim();

		Album cd = new Album();
		cd.setName(album);
		cd.setArtist(artist);
		cd.setCountry(country);
		cd.setPrice(Float.parseFloat(price));

		return cd;
	}
}
