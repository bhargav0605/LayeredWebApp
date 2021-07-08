package com.phoenix.exceptions;
/*
 * Author: bhargav.parmar@stltech.in
 * version: 1.0.0
 * Date: 07-Jul-2021
 * Copyright: Sterlite Technology Ltd.
 */

public class ServiceExceptions extends Exception{
	private String errorMessage;
	
	public ServiceExceptions(String errorMessage) {
		super(errorMessage);
	}

}
