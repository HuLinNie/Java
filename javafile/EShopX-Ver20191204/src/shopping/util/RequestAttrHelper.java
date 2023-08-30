package shopping.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import shopping.bean.*;

public class RequestAttrHelper {
	
	public final static String AlbumList = "shopping.Album";
	public final static String AlbumOrder = "shopping.Order";
	public final static String AlbumCart = "shopping.Cart";
	
	
	public static List<Album> getAlbum(HttpServletRequest request) {
		Object obj = request.getAttribute(AlbumList);
		return obj == null ? new ArrayList<Album>(0) : (List<Album>) obj;
	}
	
	public static void setAlbum(HttpServletRequest request,List<Album> list) {
		request.setAttribute(AlbumList, list);
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
}
