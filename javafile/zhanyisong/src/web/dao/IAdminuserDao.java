package web.dao;

import java.sql.SQLException;

import web.bean.Adminuser;
public interface IAdminuserDao {
	public Adminuser load(String name, String pwd) throws SQLException;
	public boolean insert(Adminuser c) throws SQLException;

}
