package web.service;

import java.sql.SQLException;

import web.bean.Customer;
import web.dao.ICustomerDao;
import web.dao.impl.CustomerDaoImpl;

public class CustomerInfoService {

	public CustomerInfoService() {
		// this.dao = dao;
		dao = new CustomerDaoImpl();
	}

	private ICustomerDao dao;

	public Customer load(String name, String pwd) {
		try {
			return dao.load(name, pwd);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public ICustomerDao getDao() {
		return dao;
	}

	public void setDao(ICustomerDao dao) {
		this.dao = dao;
	}

	public void save(Customer c) {
		try {
			dao.insert(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
