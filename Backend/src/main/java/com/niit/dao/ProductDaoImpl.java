package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
  SessionFactory sessionFactory;
	public List<Product> getAllProducts() {
		Session session=sessionFactory.getCurrentSession();
		String hqlString="from Product";
		Query query= session.createQuery(hqlString);
		List<Product> products=query.list();
		return products;
	}
}
