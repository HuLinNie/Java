package web.dao;

import java.sql.SQLException;
import java.util.List;

import web.bean.Commodity;

public interface ICommodityDao {
	Commodity select(String name) throws SQLException;
	/**
	 * 
	 * @param cd
	 * @throws SQLException
	 */
	public Commodity load(int id) throws SQLException ;
	String select(int id) throws SQLException;
	public boolean updateCommentamount(String shopname) throws SQLException;
	void insert(Commodity cd) throws SQLException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Commodity load(String name) throws SQLException;
	/**
	 * 
	 * @param album
	 * @return
	 * @throws SQLException
	 */
	List<Commodity> query(String name) throws SQLException;
	List<Commodity> queryType(String type) throws SQLException;
	List<Commodity> query() throws SQLException;
	/**
	 * 
	 * @param cd
	 * @throws SQLException
	 */
	void update(Commodity cd) throws SQLException;
	/**
	 * 
	 * @param id
	 * @throws SQLException
	 */
	void delete(int id) throws SQLException;
	
	void deleteByAlbum(String Album) throws SQLException;
	
	List<Commodity> load() throws SQLException;
	List<Commodity> loadAvailable() throws SQLException ;
}
