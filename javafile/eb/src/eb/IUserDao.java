package eb;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {

	boolean insert(User user) throws SQLException;

	boolean update(User user) throws SQLException;

	boolean delete(String email) throws SQLException;

	User Load(String uid) throws SQLException;

	List<User> loadAll() throws SQLException;

	boolean isExist(String email) throws SQLException;
	
/****************************************************************/
	
	boolean changePassword(String newpwd,String email, String oldpwd)
			throws SQLException;
	
	boolean insert(List<User> ulist) throws SQLException;
}

