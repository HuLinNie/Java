package entity;

public class Product {
	private int number;
	private String name;
	private int price;
	private String kind;
//	private String feature;
//	private Boolean sell;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
//	public String getFeature() {
//		return feature;
//	}
//	public void setFeature(String feature) {
//		this.feature = feature;
//	}
//	public Boolean getSell() {
//		return sell;
//	}
//	public void setSell(Boolean sell) {
//		this.sell = sell;
//	}
	public Product(int number, String name, int price, String kind) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.kind = kind;
//		this.feature = feature;
//		this.sell = sell;
	}
	
//	public Product(String name, int price, String kind) {
//		super();		
//		this.name = name;
//		this.price = price;
//		this.kind = kind;
//		this.feature = feature;
//		this.sell = sell;
//	}
//	
	public String toString() {
		return this.getNumber()+"-"+this.getName()+"-"+this.getPrice()+"-"+this.getKind();
	}
}
