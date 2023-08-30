package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.bean.Commodity;
import web.dao.ICommodityDao;
import web.dao.ShopDao;

public class CommodityDaoImpl extends ShopDao implements ICommodityDao {
	Connection conn;
//	public AlbumDaoImpl(Connection conn) {
//		this.conn = conn;
//	}
	@Override
	public Commodity select(String name) throws SQLException {
		Connection conn = getConnection();
		String query="select * from commodity where name=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, name);
		ResultSet rs= stmt.executeQuery();
		Commodity cde=null;
		while(rs.next()) {
			int id = rs.getInt("id");
			String _name = rs.getString("name");
			String type = rs.getString("type");
			String image = rs.getString("image");
			String producearea= rs.getString("producearea");
			String baozhidate= rs.getString("baozhidate");
			String specification= rs.getString("specification");
			String material= rs.getString("material");
			float repurchaserate= rs.getFloat("repurchaserate");
			int monthamount=rs.getInt("monthamount");
			int totalamount=rs.getInt("totalamount");
			int commentamount=rs.getInt("commentamount");
			float price = rs.getFloat("price");
			int jhsprice_number=rs.getInt("jhsprice_number");
			int stock=rs.getInt("stock");
			
		   cde = new Commodity(id,_name,type,image,producearea,baozhidate, specification, material,price,monthamount,totalamount,commentamount,repurchaserate,jhsprice_number,stock);
			
		}
		close(rs,stmt,conn);
		return  cde;
		
	} 
	@Override
	public void insert(Commodity album) throws SQLException {
		if (album == null)
			return;
		Connection conn = getConnection();

		String insert = "insert into commodity(name,image,price) values(?,?,?)";
		PreparedStatement st0 = conn.prepareStatement(insert);

		st0.setString(1, album.getName());
		st0.setString(2, album.getImage());
		st0.setDouble(3, album.getPrice());
	
		int r = st0.executeUpdate();
		close(st0, conn);
	}

	@Override
	public List<Commodity> query(String name) throws SQLException {
		List<Commodity> cdlist = new ArrayList<Commodity>();

		Connection conn = getConnection();

		String query = "Select * from commodity where name like ?";
		PreparedStatement st1 = conn.prepareStatement(query);

		name = name == null ? "" : name;
		st1.setString(1, "%" + name + "%");

		ResultSet rs1 = st1.executeQuery();

		while (rs1.next()) {
			int id = rs1.getInt("id");
			String _album = rs1.getString("name");
			String type = rs1.getString("type");
			String artist = rs1.getString("image");
			String producearea= rs1.getString("producearea");
			String baozhidate= rs1.getString("baozhidate");
			String specification= rs1.getString("specification");
			float repurchaserate= rs1.getFloat("repurchaserate");
			String material= rs1.getString("material");
			int monthamount=rs1.getInt("monthamount");
			int totalamount=rs1.getInt("totalamount");
			int commentamount=rs1.getInt("commentamount");
			float price = rs1.getFloat("price");
			int jhsprice_number=rs1.getInt("jhsprice_number");
			int stock=rs1.getInt("stock");
			Commodity cd = new Commodity(id,_album,type,artist,producearea,baozhidate, specification, material,price,monthamount,totalamount,commentamount,repurchaserate,jhsprice_number,stock);
			cdlist.add(cd);
		}

		close(rs1, st1, conn);

		return cdlist;
	}

	@Override
	public Commodity load(String name) throws SQLException {

		Connection conn = getConnection();

		String query = "select * from commodity where name=?";
		PreparedStatement st1 = conn.prepareStatement(query);
		st1.setString(1, name);
		ResultSet rs1 = st1.executeQuery();
		Commodity cd = null;
		while (rs1.next()) {
			int id = rs1.getInt("id");
			String _album = rs1.getString("name");
			String type = rs1.getString("type");
			String artist = rs1.getString("image");
			double price = rs1.getDouble("price");
			String producearea= rs1.getString("producearea");
			float repurchaserate= rs1.getFloat("repurchaserate");
			String baozhidate= rs1.getString("baozhidate");
			String specification= rs1.getString("specification");
			String material= rs1.getString("material");
			int monthamount=rs1.getInt("monthamount");
			int totalamount=rs1.getInt("totalamount");
			int commentamount=rs1.getInt("commentamount");
			int jhsprice_number=rs1.getInt("jhsprice_number");
			int stock=rs1.getInt("stock");
			cd = new Commodity(id,_album,type,artist,producearea,baozhidate, specification, material,price,monthamount,totalamount,commentamount,repurchaserate,jhsprice_number,stock);

		}
		close(rs1, st1, conn);
		return cd;
	}
	
	@Override
	public Commodity load(int id) throws SQLException {

		Connection conn = getConnection();

		String query = "select * from commodity where id=?";
		PreparedStatement st1 = conn.prepareStatement(query);
		st1.setInt(1, id);
		ResultSet rs1 = st1.executeQuery();
		Commodity cd = null;
		while (rs1.next()) {
			int id1 = rs1.getInt("id");
			String _album = rs1.getString("name");
			String type = rs1.getString("type");
			String artist = rs1.getString("image");
			double price = rs1.getDouble("price");
			String producearea= rs1.getString("producearea");
			String baozhidate= rs1.getString("baozhidate");
			String specification= rs1.getString("specification");
			float repurchaserate= rs1.getFloat("repurchaserate");
			String material= rs1.getString("material");
			int monthamount=rs1.getInt("monthamount");
			int totalamount=rs1.getInt("totalamount");
			int commentamount=rs1.getInt("commentamount");
			int jhsprice_number=rs1.getInt("jhsprice_number");
			int stock=rs1.getInt("stock");
			cd = new Commodity(id1,_album,type,artist,producearea,baozhidate, specification, material,price,monthamount,totalamount,commentamount,repurchaserate,jhsprice_number,stock);

		}
		close(rs1, st1, conn);
		return cd;
	}

	@Override
	public void update(Commodity cd) throws SQLException {
		Connection conn = getConnection();

		String update = "update commodity set name=?,image=?,price=? where id=?";
		PreparedStatement st1 = conn.prepareStatement(update);

		st1.setString(1, cd.getName());
		st1.setString(2, cd.getImage());
		
		st1.setDouble(3, cd.getPrice());
		st1.setInt(4, cd.getId());

//		int r = st1.executeUpdate();

		close(st1, conn);

	}

	@Override
	public void delete(int id) throws SQLException {


		Connection conn = getConnection();

		String update = "delete from commodity  where id=?";
		PreparedStatement st1 = conn.prepareStatement(update);

		st1.setInt(1, id);

		int r = st1.executeUpdate();

		close(st1, conn);
	}

	@Override
	public void deleteByAlbum(String Album) throws SQLException {
		Connection conn = getConnection();

		String delete = "delete from commodity where name=?";
		PreparedStatement st1 = conn.prepareStatement(delete);

		st1.setString(1, Album);

		int r = st1.executeUpdate();

		close(st1, conn);

	}

	@Override
	public List<Commodity> load() throws SQLException {
		List<Commodity> cdlist = new ArrayList<Commodity>();

		Connection conn = getConnection();

		String query = "Select * from commodity";
		Statement st1 = conn.createStatement();
		ResultSet rs1 = st1.executeQuery(query);

		while (rs1.next()) {
			int id = rs1.getInt("id");
			String _album = rs1.getString("name");
			String type = rs1.getString("type");
			String artist = rs1.getString("image");
			float price = rs1.getFloat("price");
			String producearea= rs1.getString("producearea");
			String baozhidate= rs1.getString("baozhidate");
			float repurchaserate= rs1.getFloat("repurchaserate");
			String specification= rs1.getString("specification");
			String material= rs1.getString("material");
			int monthamount=rs1.getInt("monthamount");
			int totalamount=rs1.getInt("totalamount");
			int commentamount=rs1.getInt("commentamount");
			int jhsprice_number=rs1.getInt("jhsprice_number");
			int stock=rs1.getInt("stock");
			Commodity cd = new Commodity(id,_album,type,artist,producearea,baozhidate, specification, material,price,monthamount,totalamount,commentamount,repurchaserate,jhsprice_number,stock);
			cdlist.add(cd);
		}

		close(rs1, st1, conn);

		return cdlist;
	}
	@Override
	public List<Commodity> loadAvailable() throws SQLException {
		List<Commodity> cdlist = new ArrayList<Commodity>();

		Connection conn = getConnection();

		String query = "Select * from commodity where isdroped=0 or ISNULL(isdroped)";
		Statement st1 = conn.createStatement();
		ResultSet rs1 = st1.executeQuery(query);

		while (rs1.next()) {
			int id = rs1.getInt("id");
			String _album = rs1.getString("name");
			String type = rs1.getString("type");
			String artist = rs1.getString("image");
			float price = rs1.getFloat("price");
			String producearea= rs1.getString("producearea");
			String baozhidate= rs1.getString("baozhidate");
			float repurchaserate= rs1.getFloat("repurchaserate");
			String specification= rs1.getString("specification");
			String material= rs1.getString("material");
			int monthamount=rs1.getInt("monthamount");
			int totalamount=rs1.getInt("totalamount");
			int commentamount=rs1.getInt("commentamount");
			int jhsprice_number=rs1.getInt("jhsprice_number");
			int stock=rs1.getInt("stock");
			Commodity cd = new Commodity(id,_album,type,artist,producearea,baozhidate, specification, material,price,monthamount,totalamount,commentamount,repurchaserate,jhsprice_number,stock);
			cdlist.add(cd);
		}

		close(rs1, st1, conn);

		return cdlist;
	}
	public static void main(String[] args) throws SQLException {
		CommodityDaoImpl dao = new CommodityDaoImpl();
		Commodity album = new Commodity();
		album.setName("mouren");
		album.setImage("china");
		album.setPrice(25);
		dao.insert(album);
	}
	@Override
	public List<Commodity> query() throws SQLException {
		List<Commodity> cdlist = new ArrayList<Commodity>();

		Connection conn = getConnection();

		String query = "Select * from commodity";
		Statement st1 = conn.createStatement();
		ResultSet rs1 = st1.executeQuery(query);

		while (rs1.next()) {
			int id = rs1.getInt("id");
			String _album = rs1.getString("name");
			String type = rs1.getString("type");
			String artist = rs1.getString("image");
			float price = rs1.getFloat("price");
			float repurchaserate= rs1.getFloat("repurchaserate");
			String producearea= rs1.getString("producearea");
			String baozhidate= rs1.getString("baozhidate");
			String specification= rs1.getString("specification");
			String material= rs1.getString("material");
			int monthamount=rs1.getInt("monthamount");
			int totalamount=rs1.getInt("totalamount");
			int commentamount=rs1.getInt("commentamount");
			int jhsprice_number=rs1.getInt("jhsprice_number");
			int stock=rs1.getInt("stock");
			Commodity cd = new Commodity(id,_album,type,artist,producearea,baozhidate, specification, material,price,monthamount,totalamount,commentamount,repurchaserate,jhsprice_number,stock);
			cdlist.add(cd);
		}

		close(rs1, st1, conn);

		return cdlist;
	}
	@Override
	public String select(int id) throws SQLException {
		Connection conn = getConnection();
		String query="select name from commodity where id=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs= stmt.executeQuery();
		String name="d";
		while(rs.next()) {
			
			name = rs.getString("name");	
		}
		close(rs,stmt,conn);
		return name ;
	}
	@Override
	public List<Commodity> queryType(String type) throws SQLException {
		List<Commodity> cdlist = new ArrayList<Commodity>();

		Connection conn = getConnection();

		String query = "Select * from commodity where type=?";
		PreparedStatement st1 = conn.prepareStatement(query);
		st1.setString(1, type);
		ResultSet rs1 = st1.executeQuery();
		while (rs1.next()) {
			int id = rs1.getInt("id");
			String _album = rs1.getString("name");
			String type1 = rs1.getString("type");
			String artist = rs1.getString("image");
			String producearea= rs1.getString("producearea");
			String baozhidate= rs1.getString("baozhidate");
			String specification= rs1.getString("specification");
			float repurchaserate= rs1.getFloat("repurchaserate");
			String material= rs1.getString("material");
			int monthamount=rs1.getInt("monthamount");
			int totalamount=rs1.getInt("totalamount");
			int commentamount=rs1.getInt("commentamount");
			float price = rs1.getFloat("price");
			int jhsprice_number=rs1.getInt("jhsprice_number");
			int stock=rs1.getInt("stock");
			Commodity cd = new Commodity(id,_album,type1,artist,producearea,baozhidate, specification, material,price,monthamount,totalamount,commentamount,repurchaserate,jhsprice_number,stock);
			cdlist.add(cd);
		}

		close(rs1, st1, conn);

		return cdlist;
	}
	@Override
	public boolean updateCommentamount(String shopname) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();

		String update = "update commodity set commentamount=? where name=?";
		PreparedStatement st1 = conn.prepareStatement(update);
		ICommodityDao dao = new CommodityDaoImpl();
		Commodity cd= dao.select(shopname);
		st1.setInt(1, cd.getCommentamount()+1);
		st1.setString(2, shopname);
		int r = st1.executeUpdate();
		close(st1,conn);
		return r==1;
	}
	
}
