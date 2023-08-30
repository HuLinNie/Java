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
	private String name; // 娑撴捁绶妴浣告暠閻楋拷
	private String image;
	private String producearea;
	private String baozhidate;
	private String specification;
	private String material;
	private String type;
	private double price;
	private int monthamount;
	private int totalamount;
	private int commentamount;
	private float repurchaserate;
	private int jhsprice_number;
	private int stock;

	public Commodity() {
		id = -1;
		name = "";
		image = "";
		price = 0;
		producearea="";
		baozhidate="";
		specification="";
		type="";
		material="";
		monthamount=0;
		totalamount=0;
		commentamount=0;
		repurchaserate=0;
	}

	public Commodity(int id, String name, String type,String image, String producearea,String baozhidate,String specification,String material,double price, int monthamount, int totalamount, int commentamount,float repurchaserate,int jhsprice_number,int stock) {
		this.id = id;
		this.name = name;
		this.type=type;
		this.image = image;
		this.producearea=producearea;
		this.baozhidate=baozhidate;
		this.specification=specification;
		this.material=material;
		this.monthamount=monthamount;
		this.totalamount=totalamount;
		this.commentamount=commentamount;		
		this.price = price;	
		this.repurchaserate=repurchaserate;
		this.jhsprice_number=jhsprice_number;
		this.stock=stock;
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
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
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
	public void setProducearea(String p) {
		producearea = p;
	}

	public String getProducearea() {
		return producearea;
	}
	public void setRepurchaserate(float p) {
		repurchaserate = p;
	}

	public float getRepurchaserate() {
		return repurchaserate;
	}
	public void setBaozhidate(String p) {
		baozhidate = p;
	}

	public String getBaozhidate() {
		return baozhidate;
	}
	public void setMaterial(String p) {
		material = p;
	}

	public String  getMaterial() {
		return material;
	}
	public void setSpecification(String p) {
		specification = p;
	}

	public String  getSpecification() {
		return specification;
	}
	public void setTotalamount(int p) {
		totalamount = p;
	}

	public int getTotalamount() {
		return totalamount;
	}
	public void setMonthamount(int p) {
		monthamount = p;
	}

	public int getMonthamount() {
		return monthamount;
	}
	public void setCommentamount(int p) {
		commentamount= p;
	}

	public int getCommentamount() {
		return commentamount;
	}
	public void setJhsprice_number(int p) {
		jhsprice_number= p;
	}

	public int getJhsprice_number() {
		return jhsprice_number;
	}
	public void setStock(int p) {
		stock= p;
	}

	public int getStock() {
		return stock;
	}
	public String toString() {
		return JSON.toJSONString(this);
	}
	public String toStringWithoutID() {
		//閺嬪嫰锟界姵鏌熷▔鏇犳畱鐎涙顑侀弽鐓庣础鏉╂瑩鍣锋俊鍌涚亯鐏忓繑鏆熸稉宥堝喕2娴ｏ拷,娴兼矮浜�0鐞涖儴鍐�.
		java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat(".00");
		String strprice = decimalFormat.format(price);
		return name + " | " + image + " | "  + " | " + strprice;
	}

	public static Commodity valueOf(String myCd, String split) {
		StringTokenizer t = new StringTokenizer(myCd, split);
		String name = t.nextToken();
		String image = t.nextToken();
	
		String price = t.nextToken();
		price = price.replace('无',' ').trim();

		Commodity cd = new Commodity();
		cd.setName(name);
		cd.setImage(image);
		
		cd.setPrice(Float.parseFloat(price));

		return cd;
	}
}
