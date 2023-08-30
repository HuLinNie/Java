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
		String insertSql = "insert into comment_item(cid,citem,cname) values(?,?,?)";
		PreparedStatement st = conn.prepareStatement(insertSql);
		st.setInt(1,c.getCid());
		st.setString(2,c.getCitem());
		st.setString(3,c.getCname());
		
		int r = st.executeUpdate();
		
		close(st,conn);
		return r==1;
	}
	
	@Override
	public Comment select() throws SQLException {
		Connection conn = getConnection();
		String query="select * from comment_item";
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs= stmt.executeQuery();
		Comment cde=null;
		while(rs.next()) {
			int id = rs.getInt("cid");
			String _album = rs.getString("citem");
			String _cname = rs.getString("cname");
			LocalDateTime time=rs.getTimestamp("date").toLocalDateTime();
		   cde = new Comment(id,_album,_cname,time);		
		}
		close(rs,stmt,conn);
		return  cde;
		
	}

	@Override
	public List<Comment> load(String cname) throws SQLException {
		List<Comment> cdlist = new ArrayList<Comment>();

		Connection conn = getConnection();

		String query = "Select * from comment_item where cname=?";
		PreparedStatement st1 = conn.prepareStatement(query);
		st1.setString(1, cname);
		ResultSet rs1 = st1.executeQuery();

		while (rs1.next()) {
			int id = rs1.getInt("cid");
			String _album = rs1.getString("citem");
			String _cname = rs1.getString("cname");
			LocalDateTime time=rs1.getTimestamp("date").toLocalDateTime();
			Comment cd = new Comment(id, _album,_cname,time);
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
			int id = rs1.getInt("cid");
			String _album = rs1.getString("citem");
			String _cname = rs1.getString("cname");
			LocalDateTime time=rs1.getTimestamp("date").toLocalDateTime();
			Comment cd = new Comment(id, _album,_cname,time);
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