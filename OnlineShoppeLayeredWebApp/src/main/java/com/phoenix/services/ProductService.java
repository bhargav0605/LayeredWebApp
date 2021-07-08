package com.phoenix.services;

import java.util.List;

import com.phoenix.data.Product;
import com.phoenix.exceptions.ProductNotFoundException;
import com.phoenix.exceptions.ServiceExceptions;

public interface ProductService {
	List<Product> findAll() throws ServiceExceptions;
	Product findProductById(int id) throws ProductNotFoundException, ServiceExceptions;
	void add(Product product) throws ServiceExceptions;
	void edit(Product product) throws ServiceExceptions;
	void remove(Product product) throws ServiceExceptions;
	List<Product> findByName(String name) throws ServiceExceptions;
	List<Product> findByBrand(String brand) throws ServiceExceptions;
	List<Product> findByPrice(float price) throws ServiceExceptions;
	List<Product> findByPriceRange(float minPrice, float maxPrice) throws ServiceExceptions;
	List<Product> findByNameAndBrand(String name, String brand) throws ServiceExceptions;
	List<Product> findByNameAndPrice(String name, float price) throws ServiceExceptions;
	List<Product> findBrandAndPrice(String brand, float price) throws ServiceExceptions;
	List<Product> sortByName() throws ServiceExceptions;
	List<Product> sortByBrand() throws ServiceExceptions;
	List<Product> sortByPrice() throws ServiceExceptions;
	List<Product> sortByPriceDesc() throws ServiceExceptions;
} // end of class
