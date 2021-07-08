package com.phoenix.dbconfig;
/*
 * Author: bhargav.parmar@stltech.in
 * version: 1.0.0
 * Date: 07-Jul-2021
 * Copyright: Sterlite Technology Ltd.
 */

import java.sql.Connection;
import java.sql.SQLException;

public class OracleConnection {
	//getting connection with oracle
	public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUser = "hr";
		String dbPassword = "hr";
		
		return DbConfig.getConnection(jdbcDriver,jdbcUrl,dbUser,dbPassword);
	}
} //end of class
