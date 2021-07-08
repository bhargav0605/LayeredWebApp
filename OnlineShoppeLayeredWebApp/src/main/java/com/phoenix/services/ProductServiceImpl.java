package com.phoenix.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.phoenix.daos.ProductDao;
import com.phoenix.daos.ProductDaoImpl;
import com.phoenix.data.Product;
import com.phoenix.exceptions.ProductNotFoundException;
import com.phoenix.exceptions.ServiceExceptions;

public class ProductServiceImpl implements ProductService{
	
	private ProductDao productDao;
	
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}

	@Override
	public List<Product> findAll() throws ServiceExceptions {
		try {
			return productDao.getAllProduct();
		} catch (SQLException e) {
			throw new ServiceExceptions(e.getMessage());
		}
	}

	@Override
	public Product findProductById(int id) throws ProductNotFoundException, ServiceExceptions {
		try {
			return productDao.getProductById(id);
		} catch (SQLException e) {
			throw new ServiceExceptions(e.getMessage());
		} 
	}

	@Override
	public void add(Product product) throws ServiceExceptions {
		try {
			productDao.insert(product);
		} catch (SQLException e) {
			throw new ServiceExceptions(e.getMessage());
		}
	}

	@Override
	public void edit(Product product) throws ServiceExceptions {
		try {
			productDao.update(product);
		} catch (SQLException e) {
			throw new ServiceExceptions(e.getMessage());
		}
	}

	@Override
	public void remove(Product product) throws ServiceExceptions {
		try {
			productDao.delete(product);
		} catch (SQLException e) {
			throw new ServiceExceptions(e.getMessage());
		}
	}

	@Override
	public List<Product> findByName(String name) throws ServiceExceptions {
		List<Product> dbProducts = findAll();
		List<Product> productsByName = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getName().equals(name)) {
				productsByName.add(product);
			}
		}
		
		return productsByName;
	}

	@Override
	public List<Product> findByBrand(String brand) throws ServiceExceptions {
		List<Product> dbProducts = findAll();
		
		List<Product> productsByBrand = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getBrand().equals(brand)) {
				productsByBrand.add(product);
			}
		}
		return productsByBrand;
	}

	@Override
	public List<Product> findByPrice(float price) throws ServiceExceptions {
		List<Product> dbProducts = findAll();
		
		List<Product> productsByPrice = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getPrice() == price) {
				productsByPrice.add(product);
			}
		}
		return productsByPrice;
	}

	@Override
	public List<Product> findByPriceRange(float minPrice, float maxPrice) throws ServiceExceptions {
		List<Product> dbProducts = findAll();
		
		List<Product> productsByPriceRange = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getPrice() >= maxPrice && product.getPrice() <= minPrice) {
				productsByPriceRange.add(product);
			}
		}
		return productsByPriceRange;
	}

	@Override
	public List<Product> findByNameAndBrand(String name, String brand) throws ServiceExceptions {
List<Product> dbProducts = findAll();
		
		List<Product> productsByBrand = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getBrand().equals(brand)) {
				productsByBrand.add(product);
			}
		}
		return productsByBrand;
	}

	@Override
	public List<Product> findByNameAndPrice(String name, float price) throws ServiceExceptions {
		List<Product> dbProducts = findAll();
		
		List<Product> productsByNameAndPrice = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getName().equals(name) && product.getPrice() == price) {
				productsByNameAndPrice.add(product);
			}
		}
		return productsByNameAndPrice;
	}

	@Override
	public List<Product> findBrandAndPrice(String brand, float price) throws ServiceExceptions {
		List<Product> dbProducts = findAll();
		
		List<Product> productsByBrandAndPrice = new ArrayList<Product>();
		for(Product product : dbProducts) {
			if(product.getBrand().equals(brand) && product.getPrice() == price) {
				productsByBrandAndPrice.add(product);
			}
		}
		return productsByBrandAndPrice;
	}

	@Override
	public List<Product> sortByName() throws ServiceExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> sortByBrand() throws ServiceExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> sortByPrice() throws ServiceExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> sortByPriceDesc() throws ServiceExceptions {
		// TODO Auto-generated method stub
		return null;
	}
} //end of class
