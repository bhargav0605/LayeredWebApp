package com.phoenix.services;
/*
 * Author: bhargav.parmar@stltech.in
 * version: 1.0.0
 * Date: 07-Jul-2021
 * Copyright: Sterlite Technology Ltd.
 */

import java.util.List;

import com.phoenix.data.User;
import com.phoenix.exceptions.ServiceExceptions;
import com.phoenix.exceptions.UserNotFoundException;

public interface LoginService {
	List<User> findAll() throws ServiceExceptions;
	User findByUserId(String username) throws UserNotFoundException, ServiceExceptions;
	void add(User user) throws ServiceExceptions;
	void edit(User user) throws ServiceExceptions;
	void remove(User user) throws ServiceExceptions;
	String changePassword(String newPassword) throws ServiceExceptions;
} //end of class
