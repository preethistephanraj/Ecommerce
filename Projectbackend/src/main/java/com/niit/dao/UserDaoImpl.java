package com.niit.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.model.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addUser(User User) {
		try {
			sessionFactory.getCurrentSession().save(User);
			return true;
		}
		catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return false;
		}
	}
	
	@Transactional
	@Override
	public boolean deleteUser(User User) {
		try {
			sessionFactory.getCurrentSession().delete(User);
			return true;
		}
		catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return false;
		}
	}
	@Transactional
	@Override
	public boolean updateUser(User User) {
		try {
			sessionFactory.getCurrentSession().update(User);
			return true;
		}
		catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return false;
		}
	}
	
	@Transactional
	@Override
	public User viewUserByEmail(String emailId) {
		try {
			return (User) sessionFactory.getCurrentSession().createQuery("from User where emailID='"+emailId+"'").list();
		}catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return null;
		}		
	}

	@Transactional
	@Override
	public User viewUserByUsername(String username) {
		try {
			return (User) sessionFactory.getCurrentSession().createQuery("from User where username='"+username+"'").list().get(0);
		}catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return null;
		}		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<User> listUser() {
		try {
			return (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
		}catch(Exception e) {
			System.out.println("There is an exception here! The details are: \n =================================");
			System.out.println(e);
			return null;
		}
	}
}

		
	