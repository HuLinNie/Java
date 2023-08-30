package eb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/**
 * 在UTEST库中 建user表，设置主键为email
 * create table user( 
 * email varchar(80), 
 * name varchar(80), 
 * password varchar(80), 
 * memo varchar(256), 
 * regdate datetime,
 * constraint pk__user  primary key(email) );
 *  
 * @author isaer_
 *
 */
public class UserDao implements IUserDao {
	private String ConnStr;
	private Properties prop;

	public UserDao(String dbURL) {
		this.ConnStr = dbURL;
		this.prop = prop;
	}

	
	@Override
	public boolean insert(User user) throws SQLException {
		String sql = "insert into user(?,?,?,?,?) values(?,?,?,?,?)";
		try (
				//建立数据库连接
				Connection conn = DriverManager.getConnection(ConnStr);
				//生成预处理语句对象
				PreparedStatement stmt = conn.prepareStatement(sql)
		) {
			//设置参数值
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getMemo());
			stmt.setObject(5, user.getRegDate());
			//发送语句 执行更新 获取执行结果（数据库影响的行数）
			int val = stmt.executeUpdate();
			//判断是否更新了一行 
			return val == 1;
		}
	}
	/**
	 * 基于用户注册的邮箱，对用户信息更新，
	 * 注册时间不可修改，邮箱不可修改
	 */
	@Override
	public boolean update(User user) throws SQLException {
		String sql = "update user set name=?,password=?,memo=? where email=?";
		try (Connection conn = DriverManager.getConnection(ConnStr);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getMemo());
			stmt.setString(4, user.getEmail());
			int val = stmt.executeUpdate();
			return val == 1;
		}
	}

	@Override
	public boolean delete(String email) throws SQLException {
		String sql = "delete from user  where email=?";
		try (Connection conn = DriverManager.getConnection(ConnStr);
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, email);
			int val = stmt.executeUpdate();
			return val == 1;
		}
	}

	@Override
	public User Load(String email) throws SQLException {
		User user = null;
		String sql = "select email,name,password,memo,regdate from user where email=?";
		try (Connection conn = DriverManager.getConnection(ConnStr);
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, email);

			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					user = new User();
					user.setEmail(rs.getString(1));
					user.setName(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setMemo(rs.getString(4));
					user.setRegDate(rs.getTimestamp(5).toLocalDateTime());
				}
			}
		}
		return user;
	}

	@Override
	public List<User> loadAll() throws SQLException {
		List<User> ulist = new Vector<User>();
		String sql = "select email,name,password,memo,regdate from user";
		try (Connection conn = DriverManager.getConnection(ConnStr);
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				User user = new User();
				user.setEmail(rs.getString(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setMemo(rs.getString(4));
				user.setRegDate(rs.getTimestamp(5).toLocalDateTime());
				ulist.add(user);
			}
		}
		return ulist;
	}

	@Override
	public boolean isExist(String email) throws SQLException {
		String sql = "select count(*) from user where email = ?";
		try (Connection conn = DriverManager.getConnection(ConnStr);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, email);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					return (int) rs.getInt(1) == 1;
				}
			}
		}
		return false;
	}

	@Override
	public boolean changePassword(String newpwd,String email, String oldpwd) 
			throws SQLException {
		String sql = "update user set password=? where email=? and password=?";
		try(Connection conn = DriverManager.getConnection(ConnStr);
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, newpwd);
			stmt.setString(2, email);
			stmt.setString(3, oldpwd);
			return 1 == stmt.executeUpdate();
		}
	}

	@Override
	public boolean insert(List<User> ulist) throws SQLException {
		String sql = "insert into user(email,name,password,memo,regdate) values(?,?,?,?,?)";
		try (  //建立数据库连接
				Connection conn = DriverManager.getConnection(ConnStr);
				//生成预处理语句对象
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			try{
				conn.setAutoCommit(false);
				for(int i = 0 ; i < ulist.size(); i++) {
					User user = ulist.get(i);
					//设置参数值
					stmt.setString(1, user.getEmail());
					stmt.setString(2, user.getName());
					stmt.setString(3, user.getPassword());
					stmt.setString(4, user.getMemo());
					stmt.setObject(5, user.getRegDate());
					//发送语句 执行更新 获取执行结果（数据库影响的行数）
					stmt.addBatch();
				}
				int[] results = stmt.executeBatch();
				conn.commit();
				conn.setAutoCommit(true);
				int sum = 0 ;
				for(int i = 0 ; i < results.length ; i++) {
					sum += results[i];
				}
				return sum == ulist.size();
			}
			catch(SQLException ex) {
				conn.rollback();
				conn.setAutoCommit(true);
			}
		}
		return false;
	}

}
