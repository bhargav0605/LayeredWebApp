package com.phoenix.daos;
/*
 * Author: bhargav.parmar@stltech.in
 * version: 1.0.0
 * Date: 07-Jul-2021
 * Copyright: Sterlite Technology Ltd.
 */

import java.sql.SQLException;
import java.util.List;

import com.phoenix.data.User;

public interface LoginDao {
	
	//CRUD - Operations that has to be performed in implemented classes
	List<User> getAllUsers() throws SQLException;
	User getUserById(String username) throws SQLException;
	void insert(User user) throws SQLException;
	void delete(User user) throws SQLException;
	void update(User user) throws SQLException;
} // end of class
