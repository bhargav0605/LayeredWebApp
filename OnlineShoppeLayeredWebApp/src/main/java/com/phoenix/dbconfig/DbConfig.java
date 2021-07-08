package com.phoenix.dbconfig;
/*
 * Author: bhargav.parmar@stltech.in
 * version: 1.0.0
 * Date: 07-Jul-2021
 * Copyright: Sterlite Technology Ltd.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
	public static Connection getConnection(String jdbcDriver,
											String jdbcUrl,
											String username,
											String password) 
												throws ClassNotFoundException, 
														SQLException{
	//Load JDBC Driver
	Class.forName(jdbcDriver);
	
	//Establish connection
	return DriverManager.getConnection(jdbcUrl, username, password);
	}
}
