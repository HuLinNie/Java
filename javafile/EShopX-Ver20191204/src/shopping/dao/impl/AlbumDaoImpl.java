package shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import shopping.bean.Album;
import shopping.dao.IAlbumDao;
import shopping.dao.ShopDao;

public class AlbumDaoImpl extends ShopDao implements IAlbumDao {
	Connection conn;
//	public AlbumDaoImpl(Connection conn) {
//		this.conn = conn;
//	}
	
	@Override
	public Album select(String name) throws SQLException {
		Connection conn = getConnection();
		String query="select * from album where name=?;";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, name);
		ResultSet rs= stmt.executeQuery();
		Album cde=null;
		while(rs.next()) {
			int id = rs.getInt("id");
			String _album = rs.getString("name");
			String artist = rs.getString("artist");
			String country = rs.getString("country");
			float price = rs.getFloat("price");
		   cde = new Album(id,_album,artist,country,price);
			
		}
		close(rs,stmt,conn);
		return  cde;
		
	} 
	
	@Override
	public void insert(Album album) throws SQLException {
		if (album == null)
			return;
		Connection conn = getConnection();

		String insert = "insert into album(name,artist,country,price) values(?,?,?,?)";
		PreparedStatement st0 = conn.prepareStatement(insert);

		st0.setString(1, album.getName());
		st0.setString(2, album.getArtist());
		st0.setString(3, album.getCountry());
		st0.setDouble(4, album.getPrice());
	
		int r = st0.executeUpdate();
		close(st0, conn);
	}

	@Override
	public List<Album> query(String album) throws SQLException {
		List<Album> cdlist = new ArrayList<Album>();

		Connection conn = getConnection();

		String query = "Select id,name,artist,country,price from album where name like ?";
		PreparedStatement st1 = conn.prepareStatement(query);

		album = album == null ? "" : album;
		st1.setString(1, "%" + album + "%");

		ResultSet rs1 = st1.executeQuery();

		while (rs1.next()) {
			int id = rs1.getInt("id");
			String _album = rs1.getString("name");
			String artist = rs1.getString("artist");
			String country = rs1.getString("country");
			float price = rs1.getFloat("price");
			Album cd = new Album(id, _album, artist, country, price);
			cdlist.add(cd);
		}

		close(rs1, st1, conn);

		return cdlist;
	}

	@Override
	public Album load(int id) throws SQLException {

		Connection conn = getConnection();

		String query = "Select name,artist,country,price from album where id=?";
		PreparedStatement st1 = conn.prepareStatement(query);

		st1.setInt(1, id);

		ResultSet rs1 = st1.executeQuery();
		Album cd = null;
		while (rs1.next()) {
			String _album = rs1.getString("name");
			String artist = rs1.getString("artist");
			String country = rs1.getString("country");
			float price = rs1.getFloat("price");
			cd = new Album(id, _album, artist, country, price);

		}
		close(rs1, st1, conn);
		return cd;
	}

	@Override
	public void update(Album cd) throws SQLException {
		Connection conn = getConnection();

		String update = "update name set id,name=?,artist=?,country=?,price=?  where id=?";
		PreparedStatement st1 = conn.prepareStatement(update);

		st1.setString(1, cd.getName());
		st1.setString(2, cd.getArtist());
		st1.setString(3, cd.getCountry());
		st1.setDouble(4, cd.getPrice());
		st1.setInt(5, cd.getId());

		int r = st1.executeUpdate();

		close(st1, conn);

	}

	@Override
	public void delete(int id) throws SQLException {
//		Connection conn = getConnection();
//
//		String delete = "delete from album where id=?";
//		PreparedStatement st1 = conn.prepareStatement(delete);
//
//		st1.setInt(1, id);
//
//		int r = st1.executeUpdate();
//
//		close(st1, conn);

		Connection conn = getConnection();

		String update = "update album set isdroped=1  where id=?";
		PreparedStatement st1 = conn.prepareStatement(update);

		st1.setInt(1, id);

		int r = st1.executeUpdate();

		close(st1, conn);
	}

	@Override
	public void deleteByAlbum(String Album) throws SQLException {
		Connection conn = getConnection();

		String delete = "delete from album where name=?";
		PreparedStatement st1 = conn.prepareStatement(delete);

		st1.setString(1, Album);

		int r = st1.executeUpdate();

		close(st1, conn);

	}

	@Override
	public List<Album> load() throws SQLException {
		List<Album> cdlist = new ArrayList<Album>();

		Connection conn = getConnection();

		String query = "Select id,name,artist,country,price from album";
		Statement st1 = conn.createStatement();
		ResultSet rs1 = st1.executeQuery(query);

		while (rs1.next()) {
			int id = rs1.getInt("id");
			String _album = rs1.getString("name");
			String artist = rs1.getString("artist");
			String country = rs1.getString("country");
			float price = rs1.getFloat("price");
			Album cd = new Album(id, _album, artist, country, price);
			cdlist.add(cd);
		}

		close(rs1, st1, conn);

		return cdlist;
	}
	@Override
	public List<Album> loadAvailable() throws SQLException {
		List<Album> cdlist = new ArrayList<Album>();

		Connection conn = getConnection();

		String query = "Select id,name,artist,country,price from album where isdroped=0 or ISNULL(isdroped)";
		Statement st1 = conn.createStatement();
		ResultSet rs1 = st1.executeQuery(query);

		while (rs1.next()) {
			int id = rs1.getInt("id");
			String _album = rs1.getString("name");
			String artist = rs1.getString("artist");
			String country = rs1.getString("country");
			float price = rs1.getFloat("price");
			Album cd = new Album(id, _album, artist, country, price);
			cdlist.add(cd);
		}

		close(rs1, st1, conn);

		return cdlist;
	}
	public static void main(String[] args) throws SQLException {
		AlbumDaoImpl dao = new AlbumDaoImpl();
		Album album = new Album();
		album.setArtist("mouren");
		album.setCountry("china");
		album.setName("random1");
		album.setPrice(25);
		
		dao.insert(album);
	}

	

}
