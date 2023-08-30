package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDao {
	final String URL = "jdbc:mysql://localhost:3306/web20?useSSL=false&serverTimezone=PRC";
	final String USERNAME = "root";
	final String PWD = "";
	//查询是否存在
	public boolean isExist(int number) {
		return queryProductByPnub(number)==null? false:true ;
	}
	//增加商品
	public boolean addProduct(Product product) {
		Connection connection = null;
		PreparedStatement pstmt = null;		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			String sql = "insert into product values(?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,product.getNumber());
			pstmt.setString(2,product.getName());
			pstmt.setInt(3,product.getPrice());
			pstmt.setString(4,product.getKind());
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException e){
			e.printStackTrace();	
			return false;
		}catch (SQLException e){
			e.printStackTrace();	
			return false;
		}catch (Exception e){
			e.printStackTrace();
			return false;			
		}finally {
			try {				
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	//通过编号删除产品
	public boolean deleteProductByPnub(int number) {
		Connection connection = null;
		PreparedStatement pstmt = null;		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			String sql = "delete from product where number=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,number);			
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException e){
			e.printStackTrace();	
			return false;
		}catch (SQLException e){
			e.printStackTrace();	
			return false;
		}catch (Exception e){
			e.printStackTrace();
			return false;			
		}finally {
			try {				
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	//通过编号更改产品
	public boolean updateProductByPnub(int number,Product product) {
		Connection connection = null;
		PreparedStatement pstmt = null;		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			String sql = "update product set name=?,price=?,kind=? where number=?";
			pstmt = connection.prepareStatement(sql);			
			
			pstmt.setString(1,product.getName());
			pstmt.setInt(2,product.getPrice());
			pstmt.setString(3,product.getKind());
			
			pstmt.setInt(4,product.getNumber());
			
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException e){
			e.printStackTrace();	
			return false;
		}catch (SQLException e){
			e.printStackTrace();	
			return false;
		}catch (Exception e){
			e.printStackTrace();
			return false;			
		}finally {
			try {				
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	//通过编号查询产品
	public Product queryProductByPnub(int number) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		try{			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			String sql = "select * from product where number = ? ";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1,number);
			rs = pstmt.executeQuery();
			if(rs.next()){
				int number1 = rs.getInt("number");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String kind = rs.getString("kind");
				product = new Product(number1,name,price,kind);
			}
			return product;
		} catch (ClassNotFoundException e){
			e.printStackTrace();	
			return null;
		}catch (SQLException e){
			e.printStackTrace();	
			return null;
		}catch (Exception e){
			e.printStackTrace();
			return null;			
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	//查询全部
	public List<Product> queryAllProducts() {
		List<Product> products = new ArrayList<>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		try{			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL,USERNAME,PWD);
			String sql = "select * from product ";
			pstmt = connection.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			while(rs.next()){
				int number = rs.getInt("number");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String kind = rs.getString("kind");
				product = new Product(number,name,price,kind);
				products.add(product);
			}
			return products;
		} catch (ClassNotFoundException e){
			e.printStackTrace();	
			return null;
		}catch (SQLException e){
			e.printStackTrace();	
			return null;
		}catch (Exception e){
			e.printStackTrace();
			return null;			
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
}
