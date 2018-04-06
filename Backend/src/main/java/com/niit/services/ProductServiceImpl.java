package com.niit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDao;
import com.niit.model.Product;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

}
