package com.phoenix.web.models;
/*
 * Author: bhargav.parmar@stltech.in
 * version: 1.0.0
 * Date: 07-Jul-2021
 * Copyright: Sterlite Technology Ltd.
 */

import java.sql.SQLException;

import com.phoenix.daos.LoginDao;
import com.phoenix.daos.LoginDaoImpl;
import com.phoenix.data.User;

public class LoginBean {
	
	//Properties of model or java bean
	private String username;
	private String password;
	
	//Getters and Setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isValid() {
		LoginDao loginDao = new LoginDaoImpl();
		User dbUser = null;
		try {
			dbUser = loginDao.getUserById(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(username != null && password != null
				&& username.equals(dbUser.getUsername())
				&& password.equals(dbUser.getPassword())) {
			return true;
		} else {
			return false;
		}
	}
} //end of class
