package web.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.StringTokenizer;

import com.alibaba.fastjson.JSON;

public class Comment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cid;
	private int shopid;
	private int customerid;
	private String shopcontent; // 涓撹緫銆佸敱鐗�
	private String servicecontent;
	private LocalDateTime time;
	public Comment() {
		cid = -1;
		shopid = -1;
		customerid =-1;
		shopcontent="";
		servicecontent="";
		time= LocalDateTime.now();
	}

	public Comment(int cid,int shopid,int customerid, String shopcontent,String servicecontent,LocalDateTime time) {
		this.cid = cid;
		this.shopid=shopid;
		this.customerid=customerid;
		this.shopcontent=shopcontent;
		this.servicecontent=servicecontent;
		this.time = time;
	}
	public Comment(int shopid,int customerid, String shopcontent,String servicecontent) {
		this.customerid = customerid;
		this.shopid=shopid;
		this.shopcontent = shopcontent;
		this.servicecontent= servicecontent;
		
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
		
	}
	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid= shopid;
		
	}
	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
		
	}
	
	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getShopcontent() {
		return shopcontent;
	}

	public void setShopcontent(String shopcontent) {
		this.shopcontent = shopcontent;
	}

	
	public void setServicecontent(String servicecontent) {
		this.servicecontent = servicecontent;
	}

	public String getServicecontent() {
		return servicecontent;
	}

	
	public String toString() {
		return JSON.toJSONString(this);
	}
	public String toStringWithoutID() {
		
		
		return cid+"|"+shopcontent+servicecontent ;
	}

}
