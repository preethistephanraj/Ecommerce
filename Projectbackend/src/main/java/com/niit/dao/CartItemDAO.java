package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;

public interface CartItemDAO {
		
	public boolean addCart(CartItem cartItem);
	public boolean deleteCart(CartItem cartItem);
	public boolean updateCart(CartItem cartItem);
	public CartItem getCart(int cartItemId);
	public List<CartItem> getCartByCartId(String username,int cartId);
	public List<CartItem> listCart(String username);	
}
