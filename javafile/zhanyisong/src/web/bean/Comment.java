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
	private String citem; // 涓撹緫銆佸敱鐗�
	private String cname;
	private LocalDateTime time;
	public Comment() {
		cid = -1;
		citem = "";
		cname="";
		time= LocalDateTime.now();
	}

	public Comment(int id, String citem,String cname,LocalDateTime time) {
		this.cid = id;
		this.citem = citem;
		this.cname= cname;
		this.time = time;
	}
	public Comment(int id, String citem,String cname) {
		this.cid = id;
		this.citem = citem;
		this.cname= cname;
		
	}

	public int getCid() {
		return cid;
	}

	public void setCid(LocalDateTime time) {
		this.time = time;
		
	}
	
	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(int id) {
		this.cid = id;
	}
	public String getCname() {
		return cname;
	}

	public void setSname(String cname) {
		this.cname = cname;
	}

	
	public void setCitem(String title) {
		this.citem = title;
	}

	public String getCitem() {
		return citem;
	}

	
	public String toString() {
		return JSON.toJSONString(this);
	}
	public String toStringWithoutID() {
		
		
		return cid+"|"+citem ;
	}

}
