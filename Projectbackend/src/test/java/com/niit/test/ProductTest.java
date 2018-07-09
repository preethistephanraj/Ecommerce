package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.dao.ProductDao;
import com.niit.model.Product;

public class ProductTest {
	static ProductDao productDao;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDao=(ProductDao)context.getBean("productDao");
	}
	
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("Chimney");
		product.setCategoryId(3);
		product.setSupplierId(104);
		product.setPrice(400);
		product.setProdDesc("Artistic, clay designed home decor chimney");
		product.setStock(2);
		assertTrue("Problem in Product Insertion",productDao.addProduct(product));
	}	
	
	@Test
	public void viewProductTest()
	{
		assertNotNull("Problem in get Product",productDao.viewProduct(2));
		Product product = productDao.viewProduct(1);
		System.out.println("Product ID: "+product.getProductId());
		System.out.println("Product Name: "+product.getProductName());
		System.out.println("Product Desc: "+product.getProdDesc());
		System.out.println("Product price: "+product.getPrice());
		System.out.println("Product quantity: "+product.getStock());
	}
	
	@Ignore
	@Test
	public void deleteProductTest() {
		Product product = productDao.viewProduct(8);		
		assertTrue("Problem in Product Deletion",productDao.deleteProduct(product));		
	}
	
	@Ignore
	@Test
	public void updateProductTest() {
		Product product = productDao.viewProduct(6);
		//product.setProductName("Designer Kurthi");
		product.setProdDesc("Green and peach coloured floral kurthis");
		assertTrue("Problem in Product updation",productDao.updateProduct(product));		
	}
	
	@Ignore
	@Test
	public void listProductTest() {
		assertNotNull("Problem in listing all Product",productDao.listProducts());
		System.out.println("Product ID   Product Name\t\t Product Desc\t\t\t\t\t\t Price\t CategoryID \t Supplier ID \t Quantity");
		for(Product product:productDao.listProducts()) {
			System.out.print(product.getProductId()+"\t\t");
			System.out.print(product.getProductName()+"\t\t");
			System.out.print(product.getProdDesc()+"\t\t\t");
			System.out.print(product.getPrice()+"\t\t");
			System.out.print(product.getCategoryId()+"\t\t");
			System.out.print(product.getSupplierId()+"\t\t");
			System.out.println(product.getStock()+"\t\t");			
		}
	}
}
