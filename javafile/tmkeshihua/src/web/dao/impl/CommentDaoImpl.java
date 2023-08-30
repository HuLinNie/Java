package web.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import web.bean.Commodity;
import web.bean.Comment;
import web.dao.ICommentDao;
import web.dao.ShopDao;

public class CommentDaoImpl extends ShopDao implements ICommentDao {
	Connection conn;
//	public AlbumDaoImpl(Connection conn) {
//		this.conn = conn;
//	}
	
	@Override
	public boolean insert(Comment c) throws SQLException {
		Connection conn = getConnection();
		String insertSql = "insert into comment_item(shopid,customerid,shopcontent,servicecontent) values(?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(insertSql);
		st.setInt(1,c.getShopid());
		st.setInt(2,c.getCustomerid());
		st.setString(3,c.getShopcontent());
		st.setString(4,c.getServicecontent());
		int r = st.executeUpdate();
		close(st,conn);
		return r==1;
	}

	@Override
	public List<Comment> load(int shopid) throws SQLException {
		List<Comment> cdlist = new ArrayList<Comment>();

		Connection conn = getConnection();

		String query = "select * from comment_item where shopid=?";
		PreparedStatement st1 = conn.prepareStatement(query);
		st1.setInt(1, shopid);
		ResultSet rs1 = st1.executeQuery();
		while (rs1.next()) {
			int cid = rs1.getInt("cid");
			int customerid = rs1.getInt("customerid");
			String shopcontent = rs1.getString("shopcontent");
			String servicecontent = rs1.getString("servicecontent");
			LocalDateTime time=rs1.getTimestamp("date").toLocalDateTime();
			Comment cd = new Comment(cid,shopid,customerid,shopcontent,servicecontent,time);
			cdlist.add(cd);
		}
		close(rs1, st1, conn);
		return cdlist;
	}

	@Override
	public List<Comment> load() throws SQLException {
		List<Comment> cdlist = new ArrayList<Comment>();

		Connection conn = getConnection();

		String query = "Select * from comment_item";
		PreparedStatement st1 = conn.prepareStatement(query);
		ResultSet rs1 = st1.executeQuery();

		while (rs1.next()) {
			int cid = rs1.getInt("cid");
			int shopid = rs1.getInt("shopid");
			int customerid = rs1.getInt("customerid");
			String shopcontent = rs1.getString("shopcontent");
			String servicecontent = rs1.getString("servicecontent");
			LocalDateTime time=rs1.getTimestamp("date").toLocalDateTime();
			Comment cd = new Comment(cid,shopid,customerid,shopcontent,servicecontent,time);
			cdlist.add(cd);
		}
		close(rs1, st1, conn);
		return cdlist;
	}

	@Override
	public void delete(int id) throws SQLException {
		Connection conn = getConnection();
		String del = "delete from comment_item  where cid=?";
		PreparedStatement st1 = conn.prepareStatement(del);
		st1.setInt(1, id);
		int r = st1.executeUpdate();
		close(st1, conn);	
	}

}
