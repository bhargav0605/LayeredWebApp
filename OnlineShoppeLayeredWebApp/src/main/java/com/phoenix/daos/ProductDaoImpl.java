package com.phoenix.daos;
/*
 * Author: bhargav.parmar@stltech.in
 * version: 1.0.0
 * Date: 07-Jul-2021
 * Copyright: Sterlite Technology Ltd.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.phoenix.data.Product;
import com.phoenix.dbconfig.OracleConnection;

public class ProductDaoImpl implements ProductDao{
	
	private static Connection con;
	
	static {
		try {
			con = OracleConnection.getOracleConnection();
			System.out.println("Oracle database connection is successful.");	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Product getProductById(int id) throws SQLException {
		//Query 
		String sql = "SELECT * FROM product1 WHERE id=?";
		
		//Preparing the statement
		PreparedStatement stmt = con.prepareStatement(sql);
		
		//setting the user-name in statement
		stmt.setInt(1, id);
		
		//resultant dataset received
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setBrand(rs.getString(3));
			product.setPrice(rs.getFloat(4));
			return product;
		} else {
			return null;
		}
	}

	@Override
	public List<Product> getAllProduct() throws SQLException {
		//Query 
		String sql = "SELECT * FROM product1";
		
		//Creating statement
		Statement stmt = con.createStatement();
		
		//Result that will be received
		ResultSet rs = stmt.executeQuery(sql);
		
		List<Product> products = new ArrayList<Product>();
		while(rs.next()) {
			Product product = new Product();
			product.setId(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setBrand(rs.getString(3));
			product.setPrice(rs.getFloat(4));
			products.add(product);
		}
		return products;
	}

	@Override
	public void insert(Product product) throws SQLException {
		String sql = "INSERT INTO product1 (id,name,brand,price) VALUES(?,?,?,?)";
		
		//Preparing the statement
		PreparedStatement stmt = con.prepareStatement(sql);
		
		//setting the user-name in statement
		stmt.setInt(1, product.getId());
		stmt.setString(2, product.getName());
		stmt.setString(3, product.getBrand());
		stmt.setFloat(4, product.getPrice());
		
		int updateCount = stmt.executeUpdate();
		if(updateCount>0) {
			System.out.println("New product added successfully.");
		} else {
			System.out.println("Sorry! product could not be added.");
		}
	}

	@Override
	public void update(Product product) throws SQLException {
		String sql = "UPDATE product1 SET price=? WHERE id=?";
		//Preparing the statement
		PreparedStatement stmt = con.prepareStatement(sql);
		//setting the user-name in statement
		stmt.setFloat(1, product.getPrice());
		stmt.setInt(2, product.getId());
		int updateCount = stmt.executeUpdate();
		if(updateCount>0) {
			System.out.println("Product updated successfully");
		} else {
			System.out.println("Sorry! Product could not be upadted.");
		}
	}

	@Override
	public void delete(Product product) throws SQLException {
		String sql = "DELETE FROM product1 WHERE id=?";
		//Preparing the statement
		PreparedStatement stmt = con.prepareStatement(sql);
		//setting the user-name in statement
		stmt.setInt(1, product.getId());
		int updateCount = stmt.executeUpdate();
		if(updateCount>0) {
			System.out.println("Product Deleted successfully");
		} else {
			System.out.println("Sorry! Product could not be deleted.");
		}
	}
} //end of class
