package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartItemDAO;
import com.niit.model.CartItem;


public class CartTest {
static CartItemDAO cartItemDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		cartItemDAO =(CartItemDAO)context.getBean("cartItemDAO");
	}
	
	
	@Test
	public void addCartItemTest() {
		CartItem cart = new CartItem();
		cart.setCartId(1001);
		cart.setProductId(1);
		cart.setQuantity(1);
		cart.setUsername("U1001");
		cart.setPaymentStatus("NP");
		cart.setSubTotal(1999);
		assertTrue("Problem in cart item insertion",cartItemDAO.addCart(cart));
	}
	@Ignore
	@Test
	public void getCartItemTest() {
		assertNotNull("Problem in retrieving cart item", cartItemDAO.getCart(2));
	}	
	
	@Ignore
	@Test
	public void updateCartItemTest( ) {
		CartItem cart = cartItemDAO.getCart(1);
		cart.setQuantity(1);
		cart.setSubTotal(1999);
		assertTrue("Problem in updating the cart item", cartItemDAO.updateCart(cart));
	}
	
	@Ignore
	@Test
	public void deleteCartItemTest() {
		CartItem cartItem = cartItemDAO.getCart(1);
		assertTrue("Problem in deleting the cart item", cartItemDAO.deleteCart(cartItem));
	}
	
	@Ignore
	@Test
	public void listCartItemsTest() {
		assertNotNull("Problem in retrieving cart items", cartItemDAO.listCart("U1001"));
		List<CartItem> listCartItem = cartItemDAO.listCart("U1001");
		System.out.println("CartItem ID \t CartID \t ProductId \tQuantity \t Sub Total\tPayment Status");
		for(CartItem cart:listCartItem) {
			System.out.print(cart.getCartItemId()+"\t\t");
			System.out.print(cart.getCartId()+"\t\t");
			System.out.print(cart.getProductId()+"\t\t");
			System.out.print(cart.getQuantity()+"\t\t");
			System.out.print(cart.getSubTotal()+"\t\t");
			System.out.println(cart.getPaymentStatus());
		}
	}
}
	