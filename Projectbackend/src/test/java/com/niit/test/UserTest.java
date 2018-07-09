package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.UserDao;
import com.niit.model.User;

public class UserTest {
	
	static UserDao userDao;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDao=(UserDao)context.getBean("userDao");
	}
	@Ignore
	@Test
	public void addUserTest() {
		User user = new User();
		user.setUsername("U1002");
		user.setPassword("pass123");
		user.setMobileNo("9943952979");
		user.setEmailId("sansa@home.com");
		user.setAddress("46, Winterfell - HYD12Z");
		user.setEnabled(true);
		user.setRole("admin");
		assertTrue("Problem in Product Insertion",userDao.addUser(user));
	}
	
	@Ignore
	@Test
	public void deleteUserDetailTest() {
		User user = userDao.viewUserByEmail("sansa@winterfell.com");
		assertTrue("Problem in Product Insertion",userDao.deleteUser(user));
	}
	
	@Ignore
	@Test
	public void viewUserDetailByEmailTest() {
		assertNotNull("Problem in get Product",userDao.viewUserByEmail("arya@winterfell.com"));
		User user = userDao.viewUserByEmail("arya@winterfell.com");
		System.out.println("User Name is "+user.getUsername());
		System.out.println("Password is "+user.getPassword());
		System.out.println("Mobile number is "+user.getMobileNo());
		System.out.println("Address is "+user.getAddress());
	}	
	
	@Ignore
	@Test
	public void viewUserDetailByUsernameTest() {
		assertNotNull("Problem in get Product",userDao.viewUserByUsername("U1001"));
		User user = userDao.viewUserByUsername("U1001");
		System.out.println("User Name is "+user.getUsername());
		System.out.println("Password is "+user.getPassword());
		System.out.println("Mobile number is "+user.getMobileNo());
		System.out.println("Email ID is "+user.getEmailId());
		System.out.println("Address is "+user.getAddress());
	}
	
	@Ignore
	@Test
	public void updateUserDetailTest() {
		User user = userDao.viewUserByUsername("U1002");
		//user.setAddress("22, Hate Hound, Roam Around, Needle - STARK");
		user.setEmailId("sansa@winterfell.com");
		assertTrue("Problem in Product Insertion",userDao.updateUser(user));
	}
		
	@Test
	public void listUser() {
		assertNotNull("Issue in listing user details..",userDao.listUser());
		List<User> listUser = userDao.listUser();
		System.out.println("User Name\t Name \t\t Mobile Number\t\t Email ID\t\t\t Address");
		for(User user:listUser) {
			System.out.print(user.getUsername()+"\t\t");
			System.out.print(user.getMobileNo()+"\t\t");
			System.out.print(user.getEmailId()+"\t\t");
			System.out.println(user.getAddress());
		}
	}
	
}
