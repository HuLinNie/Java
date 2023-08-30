package web.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.bean.*;

public class RequestAttrHelper {
	
	public final static String CommodityList = "web.Commodity";
	public final static String AlbumOrder = "web.Order";
	public final static String AlbumCart = "web.Cart";
	public final static String Commentitem = "web.Comment";
	public final static String CommodityByName = "web.Commodity";
	
	public static List<Commodity> getCommodity(HttpServletRequest request) {
		Object obj = request.getAttribute(CommodityList);
		return obj == null ? new ArrayList<Commodity>(0) : (List<Commodity>) obj;
	}
	
	public static void setCommodity(HttpServletRequest request,List<Commodity> list) {
		request.setAttribute(CommodityList, list);
	}
	public static List<Comment> getComment(HttpServletRequest request) {
		Object obj = request.getAttribute(Commentitem);
		return obj == null ? new ArrayList<Comment>(0) : (List<Comment>) obj;
	}
	
	public static void setComment(HttpServletRequest request,List<Comment> list) {
		request.setAttribute(Commentitem, list);
	}
	public static Order getOrder(HttpServletRequest request) {
		Object obj = request.getAttribute(AlbumOrder);
		return obj == null ? Order.NULL : (Order) obj;
	}
	public static void setOrder(HttpServletRequest request, Order o) {
		request.setAttribute(AlbumOrder, o);
	}
	
	public static Cart getCartObject(HttpServletRequest request) {
		Object obj = request.getAttribute(AlbumCart);
		return obj == null ? Cart.NULL : (Cart) obj;
	}
	public static void setCartObject(HttpServletRequest request, Cart c) {
		request.setAttribute(AlbumCart, c);
	}
	public static Commodity getCommodityByName(HttpServletRequest request) {
		Object obj = request.getAttribute(CommodityByName);
		return obj == null ? Commodity.NULL : (Commodity) obj;
	}
	public static void setCommodityByName(HttpServletRequest request, Commodity c) {
		request.setAttribute(CommodityByName, c);
	}
	
	
}
