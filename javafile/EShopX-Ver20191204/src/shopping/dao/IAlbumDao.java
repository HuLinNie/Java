package shopping.dao;

import java.sql.SQLException;
import java.util.List;

import shopping.bean.Album;

public interface IAlbumDao {
	
	Album select(String name) throws SQLException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	void insert(Album cd) throws SQLException;
	/**
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Album load(int id) throws SQLException;
	/**
	 * 
	 * @param album
	 * @return
	 * @throws SQLException
	 */
	List<Album> query(String album) throws SQLException;
	/**
	 * 
	 * @param cd
	 * @throws SQLException
	 */
	void update(Album cd) throws SQLException;
	/**
	 * 
	 * @param id
	 * @throws SQLException
	 */
	void delete(int id) throws SQLException;
	
	void deleteByAlbum(String Album) throws SQLException;
	
	List<Album> load() throws SQLException;
	List<Album> loadAvailable() throws SQLException ;
}
