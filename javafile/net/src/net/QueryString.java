package net;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QueryString {
	private StringBuilder query = new StringBuilder();
	public QueryString() {
		
	}
	public synchronized void add(String name, String value,String coder) throws UnsupportedEncodingException {
		query.append('&');
		if(coder==null)
		{
			coder="utf-8";
		}
		query.append(URLEncoder.encode(name,coder));
		query.append('=');
		query.append(URLEncoder.encode(value,coder));
	}
	public synchronized void add(String name, String value) throws UnsupportedEncodingException {
		add(name,value,null);
	}
	public synchronized String getQuery() {
		return query.toString();
	}
	public String toString() {
		return getQuery();
	}
}
