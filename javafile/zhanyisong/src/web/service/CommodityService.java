package web.service;

import java.sql.SQLException;
import java.util.List;

import web.bean.Commodity;
import web.dao.ICommodityDao;
import web.dao.impl.CommodityDaoImpl;

public class CommodityService {
	ICommodityDao dao = null;
	public CommodityService(){
		dao =new CommodityDaoImpl();
	}
	public Commodity  findout(String name) {
		try {
			return dao.select(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;	
	}
	public Commodity find(String name){
		try {
			return dao.load(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Commodity> load(){
		try {
			return dao.load();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public List<Commodity> loadAvailable(){
		try {
			return dao.loadAvailable();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public boolean save(Commodity album) {
		try {
			dao.insert(album);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int id) {
		try {
			dao.delete(id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
}
