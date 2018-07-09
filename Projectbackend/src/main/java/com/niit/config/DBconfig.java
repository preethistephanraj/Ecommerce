package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CartItemDAO;
import com.niit.dao.CartItemDAOImpl;
import com.niit.dao.CategoryDao;
import com.niit.dao.CategoryDaoImpl;
import com.niit.dao.OrderDetailDAO;
import com.niit.dao.OrderDetailDAOImpl;
import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.dao.SupplierDao;
import com.niit.dao.SupplierDaoImpl;
import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.OrderDetail;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBconfig {

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		System.out.println("Inside getH2DataSource method -- start");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl("jdbc:h2:~/Ecom");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("Inside getH2DataSource method -- end");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		System.out.println("Inside getHibernateProperties method");
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		System.out.println("Inside getSession factory method");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());

		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
		sessionBuilder.addAnnotatedClass(OrderDetail.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired(required = true)
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	@Autowired(required = true)
	@Bean(name = "ProductDao")
	public ProductDao getProductDao(SessionFactory sessionFactory) {
		return new ProductDaoImpl();
	}

	@Autowired(required = true)
	@Bean(name = "CategoryDao")
	public CategoryDao getcategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl();
	}

	@Autowired(required = true)
	@Bean(name = "SupplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
		return new SupplierDaoImpl();
	}

	@Autowired(required = true)
	@Bean(name = "UserDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoImpl();
	}
	@Autowired
	@Bean(name="cartItemDAO")
	public CartItemDAO getCartItemDAO()	{
		System.out.println("----CartItemDAO bean creation---");
		return new CartItemDAOImpl();
	
	}
	
	@Autowired(required=true)
	@Bean(name="orderDetailDAO")
	public OrderDetailDAO getOrderDetailDAO()	{
		System.out.println("----OrderDetailDAO bean creation---");
		return new OrderDetailDAOImpl();
	}

}