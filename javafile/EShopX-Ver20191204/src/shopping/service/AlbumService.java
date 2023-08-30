package shopping.service;

import java.sql.SQLException;
import java.util.List;

import shopping.bean.Album;
import shopping.dao.IAlbumDao;
import shopping.dao.impl.AlbumDaoImpl;

public class AlbumService {
	IAlbumDao dao = null;
	public AlbumService(){
		dao =new AlbumDaoImpl();
	}
	
	public Album  findout(String name) {
		try {
			return dao.select(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;	
	}
	
	public Album find(int id){
		try {
			return dao.load(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Album> load(){
		try {
			return dao.load();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public List<Album> loadAvailable(){
		try {
			return dao.loadAvailable();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public boolean save(Album album) {
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
	public Album load(int id) {
		try {
			return dao.load(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
