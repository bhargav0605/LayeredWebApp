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

import com.phoenix.data.User;
import com.phoenix.dbconfig.OracleConnection;

public class LoginDaoImpl implements LoginDao{
	
	//Database connectivity
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
	public List<User> getAllUsers() throws SQLException {
		//Query 
		String sql = "SELECT * FROM login";
		
		//Creating statement
		Statement stmt = con.createStatement();
		
		//Result that will be received
		ResultSet rs = stmt.executeQuery(sql);
		
		List<User> users = new ArrayList<User>();
		while(rs.next()) {
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			users.add(user);
		}
		return users;
	}

	@Override
	public User getUserById(String username) throws SQLException {
		//This is query to get all users.
		String sql = "SELECT username, password FROM login WHERE username=?";
		
		//Preparing the statement
		PreparedStatement stmt = con.prepareStatement(sql);
		
		//setting the user-name in statement
		stmt.setString(1, username);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			return user;
		} else {
			return null;
		}
	}

	@Override
	public void insert(User user) throws SQLException {
		String sql = "INSERT INTO login (username,password) VALUES(?,?)";
		//Preparing the statement
		PreparedStatement stmt = con.prepareStatement(sql);
		//setting the user-name in statement
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getPassword());
		int updateCount = stmt.executeUpdate();
		if(updateCount>0) {
			System.out.println("New user added successfully.");
		} else {
			System.out.println("Sorry! User could not be added.");
		}
	}

	@Override
	public void delete(User user) throws SQLException {
		String sql = "DELETE FROM login WHERE username=?";
		//Preparing the statement
		PreparedStatement stmt = con.prepareStatement(sql);
		//setting the user-name in statement
		stmt.setString(1, user.getUsername());
		int updateCount = stmt.executeUpdate();
		if(updateCount>0) {
			System.out.println("User Deleted successfully");
		} else {
			System.out.println("Sorry! User could not be deleted.");
		}	
	}

	@Override
	public void update(User user) throws SQLException {
		String sql = "UPDATE login SET password=? WHERE username=?";
		//Preparing the statement
		PreparedStatement stmt = con.prepareStatement(sql);
		//setting the user-name in statement
		stmt.setString(1, user.getUsername());
		stmt.setString(2, user.getPassword());
		int updateCount = stmt.executeUpdate();
		if(updateCount>0) {
			System.out.println("User updated successfully");
		} else {
			System.out.println("Sorry! User could not be upadted.");
		}
	}
} // end of class
