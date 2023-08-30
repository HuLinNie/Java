package service;

import java.util.List;

import dao.ProductDao;
import entity.Product;

public class ProductService {
	ProductDao productDao = new ProductDao();
	
	public boolean addProduct(Product product) {
		if(!productDao.isExist(product.getNumber())) {
			productDao.addProduct(product);
			return true;
		}else {
			System.out.println("此商品已存在！");
			return false;
		}
	}
	
	public boolean deleteProductByPnub(int number) {
		if(productDao.isExist(number)) {
			return productDao.deleteProductByPnub(number);
		}else {
			return false;
		}
	}
	
	public boolean updateProductByPnub(int number,Product product) {

		if(productDao.isExist(number)) {
			return productDao.updateProductByPnub(number, product);
		}else {
			return false;
		}
	}
	
	public Product queryProductByPnub(int number) {
		return productDao.queryProductByPnub(number);
	}

	public List<Product> queryAllProducts(){
		return productDao.queryAllProducts();
	}
}
