package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.CategoryDao;
import com.niit.model.Category;

public class CategoryTest {
	static CategoryDao categoryDao;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDao=(CategoryDao)context.getBean("categoryDao");
	}
	
	@Ignore
	@Test
	public void addCategoryTest() {
		Category category=new Category();
		category.setCategoryName("Gadgets");
		category.setCategoryDesc("Latest gadgets");
		assertTrue("Problem in Category Insertion",categoryDao.addCategory(category));
	}
	
	@Ignore
	@Test
	public void getCategoryTest() {
		assertNotNull("Problem in get Category",categoryDao.getCategory(2));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest() {
		Category category = categoryDao.getCategory(4);		
		assertTrue("Problem in Category Deletion",categoryDao.deleteCategory(category));		
	}
	
	@Ignore
	@Test
	public void updateCategoryTest() {
		Category category = categoryDao.getCategory(5);
		category.setCategoryName("Electronics");
		assertTrue("Problem in Category updation",categoryDao.updateCategory(category));		
	}
	
	@Test
	public void listCategoryTest() {
		assertNotNull("Problem in listing all Category",categoryDao.listCategory());
		System.out.println("Category ID   Category Name \t\t Category Desc");
		for(Category category:categoryDao.listCategory()) {
			System.out.print(category.getCategoryId()+"\t\t");
			System.out.print(category.getCategoryName()+"\t\t\t");
			System.out.println(category.getCategoryDesc());
		}
	}
}