package com.phoenix.daos;
/*
 * Author: bhargav.parmar@stltech.in
 * version: 1.0.0
 * Date: 07-Jul-2021
 * Copyright: Sterlite Technology Ltd.
 */

import java.sql.SQLException;
import java.util.List;

import com.phoenix.data.Product;

public interface ProductDao {
	
	//Basic CRUD Methods
	Product getProductById(int id) throws SQLException;
	List<Product> getAllProduct() throws SQLException;
	void insert(Product product) throws SQLException;
	void update(Product product) throws SQLException;
	void delete(Product product) throws SQLException;
} // end of class
